package org.sevenzero.springdemo;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.BeansException;
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
public class MyDetailQuartzJobBean extends QuartzJobBean {
	
	private static final Logger logger = Logger.getLogger(MyDetailQuartzJobBean.class.getSimpleName());

	private String targetObject;

	private String targetMethod;

	private ApplicationContext ctx;

	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {

		try {
			logger.info("execute [" + ctx + ", " + targetObject + "] at once >>>>>>");

			Object otargetObject = ctx.getBean(targetObject);
			Method m = null;
			try {
				m = otargetObject.getClass().getMethod(targetMethod, new Class[] {});
				m.invoke(otargetObject, new Object[] {});
			} 
			catch (SecurityException e) {
				logger.error(e);
				e.printStackTrace();
			} 
			catch (NoSuchMethodException e) {
				logger.error(e);
				e.printStackTrace();
			}

		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new JobExecutionException(e);
		}

	}

	public void setCtx(ApplicationContext ctx) {
		this.ctx = ctx;
	}

	public ApplicationContext getCtx() {
		return ctx;
	}

	public void setTargetObject(String targetObject) {
		this.targetObject = targetObject;
	}

	public void setTargetMethod(String targetMethod) {
		this.targetMethod = targetMethod;
	}

	public String getTargetObject() {
		return targetObject;
	}

	public String getTargetMethod() {
		return targetMethod;
	}

}
