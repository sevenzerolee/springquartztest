package org.sevenzero.springdemo.job;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 
 * @author lb
 * @version 1.0.1
 * @Description
 * @date 2017年3月30日
 * 
 */
@Component("helloJob")
public class HelloJob {
	
	static final Logger log = Logger.getLogger(HelloJob.class);

	/**
	 * 执行10秒
	 */
	public void execute() {
		log.info("############## 耗时10秒 Start It is hello " + new Date());
		
		try {
			Thread.sleep(10 * 1000L);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
