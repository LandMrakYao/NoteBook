package com.tianqiauto.quartz.jobs.realtime;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.tianqiauto.base.dao.BaseService;
import com.tianqiauto.base.utils.SpringUtil;

/**   
* @Description: 实时数据汇总更新定时任务
* @author Sunwg  
* @date 2018年6月14日 下午5:55:39   
*/
@DisallowConcurrentExecution
public class RealtimeDiffJob implements Job{
	
	public void execute(JobExecutionContext jctx) throws JobExecutionException {
		try{
			BaseService baseService = SpringUtil.getBean(BaseService.class);
			baseService.callProcedureWithOutParams("JOB_REALTIME_DIFF");
			jctx.setResult("实时数据刷新成功!");
		}catch(Exception e){
			jctx.setResult("实时数据刷新失败:" + e.getMessage());
		}
	}
}
