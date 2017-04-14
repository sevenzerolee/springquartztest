package org.sevenzero.springdemo;

import java.util.Date;

/**
 * 
 * @author lb
 * @version 1.0.1
 * @Description
 * @date 2017年3月30日
 * 
 */
public class SimpleTimeTest {

	public void doStudy() {
		System.out.println("It is " + new Date());
		
		try {
			Thread.sleep(2000L);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
