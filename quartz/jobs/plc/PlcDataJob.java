package com.tianqiauto.quartz.jobs.plc;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.tianqiauto.base.dao.BaseService;
import com.tianqiauto.base.utils.PropertiesUtils;
import com.tianqiauto.base.utils.SpringUtil;
import com.tianqiauto.modbus.bean.Plc;
import com.tianqiauto.modbus.service.CaijiService;
import com.tianqiauto.modbus.thread.ReadPlcThread;

/**
 * @Description: PLC采集任务
 * @Author: LXX
 * @CreateDate: 2018/08/13 18:37
 */
@DisallowConcurrentExecution
public class PlcDataJob implements Job {

	private static Logger logger = Logger.getLogger(PlcDataJob.class);

	/**
	 * 每个线程采集的机台数量
	 */
	private Integer threadMachineNumber = Integer.valueOf(PropertiesUtils.getProperties("/application.properties","com.tis.plc.threadMachineNumber"));

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		long start = System.currentTimeMillis();
		logger.info("---------PLC数据开始采集---------");
		try {
			CaijiService caijiService = SpringUtil.getBean(CaijiService.class);
			List<Plc> plcList = caijiService.queryAllPlcAndParams();
			// 将数据分组，创建多线程执行采集和写入操作，每%threadMachineNumber%台车一个线程执行采集任务
			int threadNums = (plcList.size() % threadMachineNumber == 0 ? plcList
					.size() / threadMachineNumber
					: (plcList.size() / threadMachineNumber + 1));


			CountDownLatch latch = new CountDownLatch(threadNums);

			// 创建sql集合
			Vector<String> allSqls = new Vector<String>();

			for (int i = 0; i < threadNums; i++) {
				int toIndex = ((i + 1) * threadMachineNumber < plcList.size() ? (i + 1)* threadMachineNumber: plcList.size());
				List<Plc> datas = plcList.subList(i * threadMachineNumber,toIndex);
				String threadName = "PLC实时数据采集线程：" + (i + 1) + "/" + threadNums;
				ReadPlcThread thread = new ReadPlcThread(threadName, latch,datas, allSqls);
				thread.start();
			}
			latch.await();

			BaseService baseService = SpringUtil.getBean(BaseService.class);
			baseService.batchUpdate(allSqls);

			long end = System.currentTimeMillis();
			logger.info("------整个PLC数据采集过程共耗时:"+(end-start)+"毫秒------");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e,e);
			context.setResult("PLC数据采集失败:" + e.getMessage());
		}
	}
}
