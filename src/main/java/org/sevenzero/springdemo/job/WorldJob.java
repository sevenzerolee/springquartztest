package org.sevenzero.springdemo.job;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 
 * @author lb
 * @version 1.0.1
 * @Description
 * @date 2017年4月17日
 *
 */
@Component
public class WorldJob{
	
	static final Logger log = Logger.getLogger(WorldJob.class);
	
	/**
	 * 执行8秒
	 */
	public void execute() {
		log.info("$$$$$$$$$$$$$$$$$$$$ 耗时8秒 start" + new Date());
		try {
			Thread.sleep(8 * 1000L);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
