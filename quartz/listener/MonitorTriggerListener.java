package com.tianqiauto.quartz.listener;

import org.apache.log4j.Logger;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.Trigger.CompletedExecutionInstruction;
import org.quartz.TriggerListener;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tianqiauto.base.utils.DateUtils;
import com.tianqiauto.base.utils.SpringUtil;
import com.tianqiauto.quartz.bean.QuartzLog;

public class MonitorTriggerListener implements TriggerListener {
	Logger logger= Logger.getLogger(this.getClass());
	
	private ThreadLocal<QuartzLog> localLog=new ThreadLocal<QuartzLog>();
	
	@Override
	public String getName() {
		return "MonitorTriggerListener";
	}

	@Override
	public void triggerFired(Trigger arg0, JobExecutionContext jec) {
		QuartzLog quartzLog=new QuartzLog();
		localLog.set(quartzLog);
		try {
			JobDetail jobDetail = jec.getJobDetail();
			String group = jobDetail.getKey().getGroup();
			String name = jobDetail.getKey().getName();
			quartzLog.setStartTime(System.currentTimeMillis());
			quartzLog.setJobGroup(group);
			quartzLog.setJobName(name);
		} catch (Exception e) {
			quartzLog.setExceptionMessage(e.getMessage());
			quartzLog.setDescription(e.getStackTrace().toString());
		}
	}

	@Override
	public void triggerMisfired(Trigger arg0) {
	}

	@Override
	public boolean vetoJobExecution(Trigger arg0, JobExecutionContext arg1) {
		return false;
	}

	@Override
	public void triggerComplete(Trigger trigger, JobExecutionContext context,
			CompletedExecutionInstruction triggerInstructionCode) {
		QuartzLog quartzLog = localLog.get();
		quartzLog.setEndTime(System.currentTimeMillis());
		if(null != trigger.getNextFireTime()){
			quartzLog.setNextTime(trigger.getNextFireTime());
			quartzLog.setDescription("自动触发执行 ");
		}else{
			quartzLog.setDescription("手动调用执行");
		}
		if(null == context.getResult()){
			quartzLog.setResult("执行成功");
		}else{
			quartzLog.setResult(context.getResult().toString());
		}
		logger.info(quartzLog);
		try{
			JdbcTemplate jdbc = SpringUtil.getBean(JdbcTemplate.class);
			String sql = "insert into t_log_jobs (id,startTime,endTime,timeDuration,jobGroup,jobName,nextTime,description,result,exceptionMessage)values("
					+ "NEXT VALUE FOR SYS_SEQ,?,?,?,?,?,?,?,?,?)";
			jdbc.update(
					sql,
					quartzLog.getStartTime(),
					quartzLog.getEndTime(),
					quartzLog.getTimeDuration(),
					quartzLog.getJobGroup(),
					quartzLog.getJobName(),
					(quartzLog.getNextTime() == null ? "" : DateUtils.date2StringV2(quartzLog.getNextTime())),
					quartzLog.getDescription(),
					quartzLog.getResult(),
					(quartzLog.getExceptionMessage() == null ? "" : quartzLog.getExceptionMessage()));
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}