package com.tianqiauto.quartz.jobs.shift;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.tianqiauto.base.dao.BaseService;
import com.tianqiauto.base.utils.SpringUtil;

/**   
* @Description: 产量数据归档
* @author Sunwg  
* @date 2018年6月14日 下午5:02:11   
*/
@DisallowConcurrentExecution
public class ChanliangShiftJob implements Job{
	
	
	public void execute(JobExecutionContext jctx) throws JobExecutionException {
		try{
			BaseService baseService = SpringUtil.getBean(BaseService.class);
			/**
			 * 做归档的思路是，先将表给拷贝出来，命名方式是 T_CURRENT_FANGSHA_201806011，归档数据从这里出
			 * 
			 * 执行切换班次存储过程
			 * 
			 * 执行切换员工的存储过程 
			 * 
			 * 执行归档的存储过程，归档完成后删除表 
			 */
			baseService.callProcedureWithOutParams("JOB_SHIFT_MAIN");
			jctx.setResult("归档执行成功");
		}catch(Exception e){
			jctx.setResult("执行失败:" + e.getMessage());
		}
	}
}
