package com.tianqiauto.quartz.jobs.ygfz;

import com.tianqiauto.base.dao.BaseService;
import com.tianqiauto.base.utils.SpringUtil;
import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Description:定时任务更新员工分组中的组号
 * @Author: 李晓晓
 * @CreateDate: 2018/08/24 15:21
 */
@DisallowConcurrentExecution
public class UpdateYuangongFenzuJob implements Job {
    Logger log = Logger.getLogger(this.getClass());

    @Override
    public void execute(JobExecutionContext jctx) throws JobExecutionException {
        log.info("==定时更新员工分组中的设定组号任务开始执行==");
        long startTime = System.currentTimeMillis();
        try {
            /*通过Spring容器util类获取到容器中的BaseService实例*/
            BaseService baseService = SpringUtil.getBean(BaseService.class);
            baseService.callProcedureWithOutParams("JOB_YG_YGFZ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        log.info("[定时更新员工分组中的设定组号任务执行结束][.执行时间：" + (endTime - startTime) + "毫秒");
    }
}
