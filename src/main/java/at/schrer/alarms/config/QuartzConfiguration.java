package at.schrer.alarms.config;

import at.schrer.alarms.sync.jobs.UAAlarmsSynchronizerJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfiguration {
    @Value("${alarms.sync.interval}")
    private int defaultSyncInterval;

    @Bean
    public JobDetail uaSyncJobDetail(){
        return JobBuilder.newJob()
                .ofType(UAAlarmsSynchronizerJob.class)
                .storeDurably()
                .withIdentity("uaAlarmSyncJob")
                .withDescription("Upper Austria Alarms Sync Job")
                .build();
    }

    @Bean
    public Trigger uaSyncTrigger(JobDetail uaSyncJobDetail) {
        return TriggerBuilder.newTrigger()
                .forJob(uaSyncJobDetail)
                .withIdentity("uaAlarmSyncTrigger")
                .withDescription("Alarm Sync for Upper Austria")
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(defaultSyncInterval))
                .build();
    }
}
