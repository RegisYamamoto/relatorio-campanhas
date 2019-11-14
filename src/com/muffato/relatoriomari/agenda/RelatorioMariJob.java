package com.muffato.relatoriomari.agenda;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.muffato.relatoriomari.service.RelatorioMariService;

public class RelatorioMariJob implements Job{
	public void execute(JobExecutionContext context) throws JobExecutionException {
		new RelatorioMariService().gerar();
	}

}