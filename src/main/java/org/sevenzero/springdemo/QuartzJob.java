package org.sevenzero.springdemo;

import java.util.Date;

/**
 * 
 * @author lb
 * @version 1.0.1
 * @Description
 * @date 2017年4月17日
 *
 */
public class QuartzJob {
	
	public void execute() {
		System.out.println("### " + new Date());
	}

}
