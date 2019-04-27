package com.tianqiauto.quartz.jobs.history;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.tianqiauto.base.dao.BaseService;
import com.tianqiauto.base.utils.SpringUtil;

/**   
* @Description:历史数据写入定时任务
* @author Sunwg  
* @date 2018年6月14日 下午5:55:39   
*/
@DisallowConcurrentExecution
public class WriteHistoryDataJob implements Job{
	
	public void execute(JobExecutionContext jctx) throws JobExecutionException {
		try{
			BaseService baseService = SpringUtil.getBean(BaseService.class);
			baseService.callProcedureWithOutParams("JOB_HISDATA_WRITE");
			jctx.setResult("历史数据写入成功!");
		}catch(Exception e){
			jctx.setResult("历史数据写入失败:" + e.getMessage());
		}
	}
}
