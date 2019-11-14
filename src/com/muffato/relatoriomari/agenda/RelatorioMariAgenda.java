package com.muffato.relatoriomari.agenda;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class RelatorioMariAgenda {

	public static void inicia() throws Exception {
		JobDetail job = JobBuilder.newJob(RelatorioMariJob.class).withIdentity(
				"RelatorioMariJob", "relatorio").build();

		String agenda= "0 0 1 * * ?";
		 
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity(
				"RelatorioMariJob", "relatorio").withSchedule(
						CronScheduleBuilder.cronSchedule(agenda)).build();
		 		 
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);
	}
	
}