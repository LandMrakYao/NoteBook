package com.tianqiauto.quartz.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**   
* @Description: 定时任务类
* @author Sunwg  
* @date 2017年11月4日 下午4:12:34   
*/
public class ScheduleJob {

	/**
	 * 任务名称
	 */
	private String name;
	/**
	 * 任务分组
	 */
	private String group;
	/**
	 * 任务状态 是否启动任务
	 */
	private String status;
	/**
	 * cron表达式
	 */
	private String cron;
	
	/**
	 * 下一次触发时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用  
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//存日期时使用  
	private Date nextFireTime;
	
	/**
	 * 任务执行时调用哪个类的方法 包名+类名
	 */
	private String bean;
	/**
	 * 描述
	 */
	private String description;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCron() {
		return cron;
	}
	public void setCron(String cron) {
		this.cron = cron;
	}
	public String getBean() {
		return bean;
	}
	public void setBean(String bean) {
		this.bean = bean;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getNextFireTime() {
		return nextFireTime;
	}
	public void setNextFireTime(Date nextFireTime) {
		this.nextFireTime = nextFireTime;
	}
	
}