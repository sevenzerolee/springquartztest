package org.sevenzero.springdemo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author lb
 * @version 1.0.1
 * @Description
 * @date 2017年4月17日
 *
 */
public class WorldJob implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4297964891946540442L;

	public void execute() {
		System.out.println("$$$$$$ " + new Date());
	}

}
