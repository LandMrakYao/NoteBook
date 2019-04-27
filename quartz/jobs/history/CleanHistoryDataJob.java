package com.tianqiauto.quartz.jobs.history;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.tianqiauto.base.dao.BaseService;
import com.tianqiauto.base.utils.SpringUtil;

/**   
* @Description: 清理历史数据定时任务
* @author Sunwg  
* @date 2018年6月23日 上午9:06:49   
*/
@DisallowConcurrentExecution
public class CleanHistoryDataJob implements Job{
	
	public void execute(JobExecutionContext jctx) throws JobExecutionException {
		try{
			BaseService baseService = SpringUtil.getBean(BaseService.class);
			baseService.callProcedureWithOutParams("JOB_HISDATA_CLEAN");
			jctx.setResult("历史数据清理成功!");
		}catch(Exception e){
			jctx.setResult("历史数据清理失败:" + e.getMessage());
		}
	}
}
