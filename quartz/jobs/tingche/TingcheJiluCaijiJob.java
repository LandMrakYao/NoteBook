package com.tianqiauto.quartz.jobs.tingche;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.tianqiauto.base.dao.BaseService;
import com.tianqiauto.base.utils.SpringUtil;

/**   
* @Description: 采集停车记录定时任务
* @author Sunwg  
* @date 2018年6月14日 下午2:48:24   
*/
@DisallowConcurrentExecution
public class TingcheJiluCaijiJob implements Job{
	public void execute(JobExecutionContext jctx) throws JobExecutionException {
		try{
			BaseService baseService = SpringUtil.getBean(BaseService.class);
			baseService.callProcedureWithOutParams("JOB_TINGCHE_CAIJI");
			jctx.setResult("停车记录采集成功");
		}catch(Exception e){
			jctx.setResult("停车记录采集失败:"+e.getLocalizedMessage());
		}
		
	}
}
