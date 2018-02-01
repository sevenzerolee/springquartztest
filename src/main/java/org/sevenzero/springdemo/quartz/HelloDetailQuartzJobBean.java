package org.sevenzero.springdemo.quartz;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 
 * @author lb
 * @version 1.0.1
 * @Description
 * @date 2017年4月17日
 *
 */
@DisallowConcurrentExecution
public class HelloDetailQuartzJobBean extends QuartzJobBean {
	
	static final Logger log = Logger.getLogger(HelloDetailQuartzJobBean.class.getSimpleName());

	private int sleep = 10;

	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		
		log.info("############## 耗时" + sleep + "秒 Start It is hello " + new Date());
		
		try {
			Thread.sleep(sleep * 1000L);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		log.info("############## 耗时" + sleep + "秒 End   It is hello " + new Date());

	}

}
