package com.tianqiauto.quartz.jobs.baojijng;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.tianqiauto.base.dao.BaseService;
import com.tianqiauto.base.utils.SpringUtil;

/**   
* @Description: 报警信息搜集定时任务
* @author Sunwg  
* @date 2018年6月28日 上午11:08:17   
*/
@DisallowConcurrentExecution
public class BaojingInfoCollectJob implements Job{
	
	public void execute(JobExecutionContext jctx) throws JobExecutionException {
		try{
			BaseService baseService = SpringUtil.getBean(BaseService.class);
			baseService.callProcedureWithOutParams("JOB_BAOJING_COLLECT");
			jctx.setResult("报警信息搜集成功");
		}catch(Exception e){
			jctx.setResult("报警信息搜集失败:" + e.getMessage());
		}
	}
}
