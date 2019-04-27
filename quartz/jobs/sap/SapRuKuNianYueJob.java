package com.tianqiauto.quartz.jobs.sap;

import com.tianqiauto.base.utils.DateUtils;
import com.tianqiauto.base.utils.SpringUtil;
import com.tianqiauto.tis.pc.sap.bean.SapResult;
import com.tianqiauto.tis.pc.sap.service.SapInterfaceService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Description:sap按年月查询入库数据
 * @Author: 李晓晓
 * @CreateDate: 2018/08/24 14:45
 */
@DisallowConcurrentExecution
public class SapRuKuNianYueJob implements Job {
    @Override
    public void execute(JobExecutionContext jctx) throws JobExecutionException {
        try {
            //获取当前年
            String nowYear = DateUtils.getNowYear();
            //获取当前月(带0)
            String nowMonth = DateUtils.getNowMonthWithZero();
            SapInterfaceService sapInterfaceService = SpringUtil.getBean(SapInterfaceService.class);
            SapResult result = sapInterfaceService.callRukuNianyue(nowYear, nowMonth);
            if(result.getSuccess()){
                jctx.setResult("按年月查询入库数据成功!");
            }else{
                jctx.setResult("按年月查询入库数据失败:" +result.getMessage());
            }
        } catch (Exception e) {
            jctx.setResult("按年月查询入库数据失败:" + e.getMessage());
        }
    }

}
