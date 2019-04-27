package com.tianqiauto.quartz.jobs.socket;

import com.tianqiauto.base.utils.SpringUtil;
import com.tianqiauto.quartz.jobs.socket.dao.SendDataDao;
import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Description: 能原环境数据Socket同步
 * @Author: 李晓晓
 * @CreateDate: 2018/08/25 11:15
 */
@DisallowConcurrentExecution
public class SocketDnsjtbJob implements Job {

    Logger log = Logger.getLogger(this.getClass());

    @Override
    public void execute(JobExecutionContext jctx) throws JobExecutionException {
        log.info("==能源环境-电能-数据同步==");
        long startTime = System.currentTimeMillis();

        try{
            /*通过Spring容器util类获取到容器中的BaseService实例*/
            SendDataDao sentData = SpringUtil.getBean(SendDataDao.class);
            sentData.sendData();
        }catch(Exception e){
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        log.info("能源环境-电能-数据同步][.执行时间：" +  (endTime - startTime) + "毫秒");
    }
}
