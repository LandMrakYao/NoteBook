package com.tianqiauto.quartz.jobs.sap;

import com.tianqiauto.base.utils.SpringUtil;
import com.tianqiauto.tis.pc.sap.bean.SapResult;
import com.tianqiauto.tis.pc.sap.service.SapInterfaceService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Description:查询sap入库信息
 * @Author: 李晓晓
 * @CreateDate: 2018/08/24 14:42
 */
@DisallowConcurrentExecution
public class SapRuKuJob implements Job {
    @Override
    public void execute(JobExecutionContext jctx) throws JobExecutionException {
        try {
            SapInterfaceService sapInterfaceService = SpringUtil.getBean(SapInterfaceService.class);
            SapResult result = sapInterfaceService.callRuku();
            if(result.getSuccess()){
                jctx.setResult("查询入库信息成功!");
            }else{
                jctx.setResult("查询入库信息失败:" +result.getMessage());
            }
        } catch (Exception e) {
            jctx.setResult("查询入库信息失败:" + e.getMessage());
        }
    }
}
