package test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class Main {

    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();

        Scheduler scheduler = schedulerFactory.getScheduler();

        //JobDetail job = JobBuilder.newJob(ClassToRun.class).withIdentity("jobName","group").build();
        JobDetail job = JobBuilder.newJob(ClassToRun.class).build();

        String exp = "0 * 20 * * ?";
        Trigger trigger = TriggerBuilder.newTrigger()
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule(exp)).build();
        // Planning job detail
        scheduler.scheduleJob(job, trigger);

        // starting scheduler
        scheduler.start();
    }
}
