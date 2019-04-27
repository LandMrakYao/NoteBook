package com.tianqiauto.quartz.bean;

import java.util.Date;

public class QuartzLog{
	private long startTime;
	
	private long endTime;
	
	private long timeDuration;
	
	private String jobGroup;
	
	private String jobName;
	
	private Date nextTime;
	
	private String description;
	
	private String result;
	
	private String exceptionMessage;

	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
		this.timeDuration = endTime - startTime;
	}

	public long getTimeDuration() {
		return timeDuration;
	}

	public void setTimeDuration(long timeDuration) {
		this.timeDuration = timeDuration;
	}

	public String getJobGroup() {
		return jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Date getNextTime() {
		return nextTime;
	}

	public void setNextTime(Date nextTime) {
		this.nextTime = nextTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return jobGroup + "["+ jobName +"]执行耗时："+ timeDuration+"毫秒,"+description+result;
	}

}
