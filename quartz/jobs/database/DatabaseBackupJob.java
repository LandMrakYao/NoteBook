package com.tianqiauto.quartz.jobs.database;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.tianqiauto.base.dao.BaseService;
import com.tianqiauto.base.utils.SpringUtil;

/**   
* @Description: 数据库定时备份
* @author Sunwg  
* @date 2018年6月23日 上午9:28:43   
*/
@DisallowConcurrentExecution
public class DatabaseBackupJob implements Job{
	
	public void execute(JobExecutionContext jctx) throws JobExecutionException {
		try{
			BaseService baseService = SpringUtil.getBean(BaseService.class);
			baseService.callProcedureWithOutParams("JOB_DATABASE_BACKUP");
			jctx.setResult("数据库备份成功!");
		}catch(Exception e){
			jctx.setResult("数据库备份失败:" + e.getMessage());
		}
	}
}
