package org.sevenzero.springdemo.quartz;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.sevenzero.springdemo.job.HelloJob;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 
 * @author lb
 * @version 1.0.1
 * @Description
 * @date 2017年4月17日
 *
 */
public class HelloDetailQuartzJobBean extends QuartzJobBean {
	
	static final Logger logger = Logger.getLogger(HelloDetailQuartzJobBean.class.getSimpleName());

	private HelloJob helloJob;

	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {

//		logger.info("******* Bean ****** " + helloJob);
		
		if (null != helloJob) {
			helloJob.doStudy();
		}

	}

	public void setHelloJob(HelloJob helloJob) {
		this.helloJob = helloJob;
	}

}
