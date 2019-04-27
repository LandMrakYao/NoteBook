package com.tianqiauto.quartz.jobs.sap;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import com.tianqiauto.base.utils.SpringUtil;
import com.tianqiauto.tis.pc.sap.bean.SapResult;
import com.tianqiauto.tis.pc.sap.service.SapInterfaceService;


/**
 * @Description 订单teco回传
 * @author HJiong
 * @time 2018-8-24 下午2:48:30
 */
public class SapOrderTecoJob implements Job{

	public void execute(JobExecutionContext j) throws JobExecutionException {
		try {
			SapInterfaceService sapservice=SpringUtil.getBean(SapInterfaceService.class);
			SapResult result=sapservice.callOrderTeco();
			if(result.getSuccess()){
				j.setResult("订单teco回传接口调用成功");
			}else{
				
				j.setResult("订单teco回传接口调用失败");
			}
			
		} catch (Exception e) {
			j.setResult("订单teco回传接口调用失败："+e.getMessage());
		}
	}
		
}
