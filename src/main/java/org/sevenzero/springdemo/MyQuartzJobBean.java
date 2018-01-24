package org.sevenzero.springdemo;

import java.lang.reflect.Method;
import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
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

	static final Logger log = Logger.getLogger(MyQuartzJobBean.class);
	
	private String targetObject;
	private String targetMethod;
	
	private ApplicationContext ctx;

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		
		log.info("It is " + new Date());
		
		try {
			if (null != ctx) {
				Object bean = ctx.getBean(targetObject);
				Method m = bean.getClass().getMethod(targetMethod);
				m.invoke(bean, null);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(2000L);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public void setTargetObject(String targetObject) {
		this.targetObject = targetObject;
	}

	public void setTargetMethod(String targetMethod) {
		this.targetMethod = targetMethod;
	}

	public void setCtx(ApplicationContext ctx) {
		this.ctx = ctx;
	}
	

}
