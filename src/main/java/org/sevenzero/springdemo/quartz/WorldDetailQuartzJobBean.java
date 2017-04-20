package org.sevenzero.springdemo.quartz;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;
import org.sevenzero.springdemo.job.WorldJob;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 
 * @author lb
 * @version 1.0.1
 * @Description
 * @date 2017年4月17日
 *
 */
public class WorldDetailQuartzJobBean extends QuartzJobBean implements StatefulJob {
	
	static final Logger logger = Logger.getLogger(WorldDetailQuartzJobBean.class.getSimpleName());

	private WorldJob worldJob;

	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {

//		logger.info("******* Bean ****** " + worldJob);
		
		if (null != worldJob) {
			worldJob.execute();
		}

	}

	public void setWorldJob(WorldJob worldJob) {
		this.worldJob = worldJob;
	}

}
