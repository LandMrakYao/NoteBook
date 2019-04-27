package com.tianqiauto.quartz.controller;

import java.util.List;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianqiauto.accessLog.annotation.SysLog;
import com.tianqiauto.base.model.AjaxResult;
import com.tianqiauto.quartz.bean.ScheduleJob;
import com.tianqiauto.quartz.service.JobTaskService;

/**
* @author tianqiauto-swg 
* @date 2017年7月25日 上午11:00:08   
*/
@Controller
@RequestMapping("/quartz")
public class QuartzController {
	@Autowired
	private JobTaskService taskService;
	
	/** 
	* @Title: queryAllJobs 
	* @Description: 查询所有的定时任务
	* @param @throws SchedulerException
	* @return List<ScheduleJob>
	*/
	@RequestMapping("queryall")
	@ResponseBody
	public List<ScheduleJob> queryAllJobs() throws SchedulerException{
		return taskService.getAllJob();
	}
	
	/** 
	* @Title: queryRunningJobs 
	* @Description: 查询所有正在执行的定时任务
	* @param @throws SchedulerException
	* @return List<ScheduleJob>
	*/
	@RequestMapping("queryrunning")
	@ResponseBody
	public List<ScheduleJob> queryRunningJobs() throws SchedulerException{
		return taskService.getRunningJob();
	}
	
	/** 
	* @Title: updateJob 
	* @Description: 更新一个定时任务
	* @param @param job
	* @param @throws SchedulerException
	* @return AjaxResult
	*/
	@RequestMapping("update")
	@ResponseBody
	@SysLog("更新定时任务")
	public AjaxResult updateJob(ScheduleJob job) throws SchedulerException{
		AjaxResult result = new AjaxResult();
		try{
			taskService.updateJobCron(job);
			result.setSuccess(true);
		}catch(Exception e ){
			result.setSuccess(false);
			result.setMessage("定时任务修改失败："+e.getMessage());
		}
		return result;
	}
	
	/** 
	* @Title: addJob 
	* @Description: 添加一个定时任务
	* @throws ClassNotFoundException
	* @return AjaxResult
	*/
	@RequestMapping("/add")
	@ResponseBody
	@SysLog("创建定时任务")
	public AjaxResult addJob(ScheduleJob job){
		AjaxResult result = new AjaxResult();
		try{
			taskService.addJob(job);
			result.setSuccess(true);
		}catch(Exception e ){
			result.setSuccess(false);
			result.setMessage("定时任务创建失败："+e.getMessage());
		}
		return result;
	}

	/** 
	* @Title: deleteJob 
	* @Description: 删除一个定时任务，需要传入定时任务的名字和分组
	* @param job 
	* @throws SchedulerException
	* @return AjaxResult
	*/
	@RequestMapping("/delete")
	@ResponseBody
	@SysLog("删除定时任务")
	public AjaxResult deleteJob(ScheduleJob job) throws SchedulerException{
		AjaxResult result = new AjaxResult();
		try{
			taskService.deleteJob(job);
			result.setSuccess(true);
		}catch(Exception e ){
			result.setSuccess(false);
			result.setMessage("定时任务删除失败："+e.getMessage());
		}
		return result;
		
	}
	
	/** 
	* @Title: runJobNow 
	* @Description: 立刻执行一个定时任务
	* @param @param job
	* @param @throws SchedulerException
	* @return AjaxResult
	*/
	@RequestMapping("/run")
	@ResponseBody
	@SysLog("手动执行定时任务")
	public AjaxResult runJobNow(ScheduleJob job) throws SchedulerException{
		AjaxResult result = new AjaxResult();
		try{
			taskService.runAJobNow(job);
			result.setSuccess(true);
		}catch(Exception e ){
			result.setSuccess(false);
			result.setMessage("定时任务调用失败："+e.getMessage());
		}
		return result;
	}

	/** 
	* @Title: pauseJob 
	* @Description: 暂定一个定时任务
	* @param @param job
	* @param @throws SchedulerException
	* @return AjaxResult
	*/
	@RequestMapping("/pause")
	@ResponseBody
	@SysLog("暂停定时任务")
	public AjaxResult pauseJob(ScheduleJob job) throws SchedulerException{
		AjaxResult result = new AjaxResult();
		try{
			taskService.pauseJob(job);
			result.setSuccess(true);
		}catch(Exception e ){
			result.setSuccess(false);
			result.setMessage("定时任务暂停失败："+e.getMessage());
		}
		return result;
	}
	
	/** 
	* @Title: resumeJob 
	* @Description: 恢复一个定时任务
	* @param @param job
	* @param @throws SchedulerException
	* @return AjaxResult
	*/
	@RequestMapping("/resume")
	@ResponseBody
	@SysLog("恢复执行定时任务")
	public AjaxResult resumeJob(ScheduleJob job) throws SchedulerException{
		AjaxResult result = new AjaxResult();
		try{
			taskService.resumeJob(job);
			result.setSuccess(true);
		}catch(Exception e ){
			result.setSuccess(false);
			result.setMessage("定时任务恢复失败："+e.getMessage());
		}
		return result;
	}
}