package org.sevenzero.springdemo;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 
 * @author lb
 * @version 1.0.1
 * @Description
 * @date 2017年4月17日
 * 
 */
public class MyQuartzJobBean extends QuartzJobBean {


	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		
		System.out.println("It is " + new Date());
		
		try {
			Thread.sleep(2000L);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	ApplicationContext getApplicationContext(final JobExecutionContext jobexecutioncontext) {
        try {
            return (ApplicationContext) jobexecutioncontext.getScheduler().getContext().get("applicationContextKey");
        } 
        catch (SchedulerException e) {
        	e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
