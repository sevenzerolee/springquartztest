package org.sevenzero.springdemo.util;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * 
 * @author lb
 * @version 1.0.1
 * @Description
 * @date 2018年1月31日
 * 
 * 从 Spring 中获取 Bean 
 *
 */
@Service
public class BeanUtil implements ApplicationContextAware {
	
	private static final Logger log = Logger.getLogger(BeanUtil.class);
	
	private static ApplicationContext context;

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		log.info("### init context");
		context = applicationContext;
	}

	public static ApplicationContext getContext() {
		return context;
	}

	public static Object getBean(String beanName) {
		return context.getBean(beanName);
	}

	public static <T> Object getBeanByClass(Class<T> c) {
		return context.getBean(c);
	}

}
