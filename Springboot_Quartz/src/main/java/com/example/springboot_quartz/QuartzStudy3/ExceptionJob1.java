package com.example.springboot_quartz.QuartzStudy3;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ExceptionJob1  implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {

        int i = 0;
        try {
            //故意发生异常
            System.out.println(100/i);

        } catch (Exception e) {
            System.out.println("发生了异常，取消这个Job 对应的所有调度");
            JobExecutionException je =new JobExecutionException(e);
            je.setUnscheduleAllTriggers(true);
            throw je;
        }
    }
}