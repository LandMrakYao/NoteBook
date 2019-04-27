package com.tianqiauto.quartz.jobs.sap;

import com.tianqiauto.base.utils.SpringUtil;
import com.tianqiauto.tis.pc.sap.bean.SapResult;
import com.tianqiauto.tis.pc.sap.service.SapInterfaceService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Description:sap倍捻下机回传
 * @Author: 李晓晓
 * @CreateDate: 2018/08/24 14:36
 */
@DisallowConcurrentExecution
public class SapBeinianxiajiJob implements Job {

    @Override
    public void execute(JobExecutionContext jctx) throws JobExecutionException {
        try {
            SapInterfaceService sapInterfaceService = SpringUtil.getBean(SapInterfaceService.class);
            SapResult result = sapInterfaceService.callBeinianxiaji();
            if(result.getSuccess()){
                jctx.setResult("倍捻下机回传成功!");
            }else{
                jctx.setResult("倍捻下机回传失败:" +result.getMessage());
            }
        } catch (Exception e) {
            jctx.setResult("倍捻下机回传失败:" + e.getMessage());
        }
    }
}
