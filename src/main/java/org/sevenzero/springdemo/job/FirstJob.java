package org.sevenzero.springdemo.job;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

@Service
@DisallowConcurrentExecution
public class FirstJob implements Job {
	
	private static final Logger log = Logger.getLogger(FirstJob.class);

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		
		log.info("### JOB first job " + new Date());
		
	}

}
