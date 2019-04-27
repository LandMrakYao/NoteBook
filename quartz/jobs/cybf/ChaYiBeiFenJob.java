package com.tianqiauto.quartz.jobs.cybf;

import com.tianqiauto.base.dao.BaseService;
import com.tianqiauto.base.utils.SpringUtil;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Description:系统数据库差异备份
 * @Author: 李晓晓
 * @CreateDate: 2018/10/20 11:52
 */
@DisallowConcurrentExecution
public class ChaYiBeiFenJob implements Job {
    @Override
    public void execute(JobExecutionContext jctx) throws JobExecutionException {
        try {
            BaseService baseService = SpringUtil.getBean(BaseService.class);
            baseService.callProcedureWithOutParams("JOB_SYS_DIFF_BACKUP");
            jctx.setResult("系统数据库差异备份成功");
        } catch (Exception e) {
            jctx.setResult("系统数据库差异备份失败:" + e.getMessage());
        }
    }
}
