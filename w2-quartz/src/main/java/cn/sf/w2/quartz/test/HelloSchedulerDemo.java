package cn.sf.w2.quartz.test;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class HelloSchedulerDemo {
    public static void main(String[] args) throws SchedulerException {
        //从调度工厂中获取调度器实例
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        //通过JobBuilder构建一个任务实例
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                //设置任务的唯一实例名称和任务组名称组名
                .withIdentity("job1", "group1")
                //构建实例
                .build();
        //通过TriggerBuilder构建触发器实例
        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                //设置触发器唯一实例名称和触发器的组名
                .withIdentity("trigger1", "group1")
                //执行计划，每五秒执行一次
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5))
                //立即执行
                .startNow()
                //构建实例
                .build();
        //调度器绑定任务实例和触发器
        scheduler.scheduleJob(jobDetail,trigger);
        //开启定时任务
        scheduler.start();
    }
}
