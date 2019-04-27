package com.tianqiauto.quartz.jobs;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@DisallowConcurrentExecution
public class QuartzJob implements Job{
	Logger log = Logger.getLogger(this.getClass());
	public void execute(JobExecutionContext jctx) throws JobExecutionException {
		try{
			log.error("定时任务调度测试程序！");
		}catch(Exception e){
			jctx.setResult("执行失败:"+e.getLocalizedMessage());
		}
		
	}
}
