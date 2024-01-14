package at.schrer.alarms.config;

import at.schrer.alarms.sync.jobs.BglAlarmsSynchronizerJob;
import at.schrer.alarms.sync.jobs.BglBrigadesSynchronizerJob;
import at.schrer.alarms.sync.jobs.UAAlarmsSynchronizerJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfiguration {
    @Value("${alarms.sync.interval}")
    private int defaultAlarmSyncInterval;

    @Value("${brigades.sync.interval}")
    private int defaultBrigadesSyncInterval;

    @Bean
    public JobDetail uaAlarmSyncJobDetail(){
        return createJobDetail(UAAlarmsSynchronizerJob.class,
                "uaAlarmSyncJob",
                "Upper Austria Alarms Sync Job"
        );
    }

    @Bean
    public Trigger uaAlarmSyncTrigger(JobDetail uaAlarmSyncJobDetail) {
        return createSyncTrigger(uaAlarmSyncJobDetail,
                "uaAlarmSyncTrigger",
                "Alarm Sync for Upper Austria",
                defaultAlarmSyncInterval
        );
    }

    @Bean
    public JobDetail bglAlarmSyncJobDetail(){
        return createJobDetail(BglAlarmsSynchronizerJob.class,
                "bgAlarmSyncJob",
                "Burgenland Alarms Sync Job"
        );
    }

    @Bean
    public Trigger bglAlarmSyncTrigger(JobDetail bglAlarmSyncJobDetail) {
        return createSyncTrigger(bglAlarmSyncJobDetail,
                "bglAlarmSyncTrigger",
                "Alarm Sync for Burgenland",
                defaultAlarmSyncInterval
        );
    }

    @Bean
    public JobDetail bglBrigadesSyncJobDetail(){
        return createJobDetail(BglBrigadesSynchronizerJob.class,
                "bgBrigadesSyncJob",
                "Burgenland brigade Sync Job"
        );
    }

    @Bean
    public Trigger bglBrigadesSyncTrigger(JobDetail bglBrigadesSyncJobDetail) {
        return createSyncTrigger(bglBrigadesSyncJobDetail,
                "bglBrigadesSyncTrigger",
                "bglBrigadesSyncTrigger",
                defaultBrigadesSyncInterval
        );
    }

    private JobDetail createJobDetail(Class<? extends Job> clazz, String identity, String description){
        return JobBuilder.newJob()
                .ofType(clazz)
                .storeDurably()
                .withIdentity(identity)
                .withDescription(description)
                .build();
    }

    private Trigger createSyncTrigger(JobDetail jobDetail, String identity, String description, int intervalInSeconds){
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity(identity)
                .withDescription(description)
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(intervalInSeconds))
                .build();
    }
}
