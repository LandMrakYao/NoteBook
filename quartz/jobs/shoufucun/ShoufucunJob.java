package com.tianqiauto.quartz.jobs.shoufucun;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.tianqiauto.base.dao.BaseService;
import com.tianqiauto.base.utils.SpringUtil;

/**   
* @Description: 收付存实时计算job
* @author Sunwg  
* @date 2018年8月24日 下午1:38:56   
*/
@DisallowConcurrentExecution
public class ShoufucunJob implements Job{
	public void execute(JobExecutionContext jctx) throws JobExecutionException {
		try{
			BaseService baseService = SpringUtil.getBean(BaseService.class);
			baseService.callProcedureWithOutParams("JOB_SHOUFUCUN");
			jctx.setResult("收付存计算成功");
		}catch(Exception e){
			jctx.setResult("收付存计算失败:"+e.getLocalizedMessage());
		}
		
	}
}
