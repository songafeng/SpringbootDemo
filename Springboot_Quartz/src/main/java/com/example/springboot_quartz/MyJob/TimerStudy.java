package com.example.springboot_quartz.MyJob;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@Component
public class TimerStudy {

    public void Start()
    {
        //只执行一次的定时任务
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("2000毫米后执行一次。");
            }
        }, 2000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("5000毫米后执行一次。");
            }
        }, new Date(System.currentTimeMillis() + 5000));

//        循环执行任务
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(111);
            }
        }, 1000, 2000); // 1000毫米后执行第一次，之后每2000毫米执行一次


        //终止任务
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
        System.out.println("任务被终止");
    }
}
