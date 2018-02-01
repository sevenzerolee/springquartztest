package org.sevenzero.springdemo.controller;

import org.apache.log4j.Logger;
import org.quartz.SchedulerException;
import org.sevenzero.springdemo.mgr.QuartzManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {
	
	static final Logger log = Logger.getLogger(JobController.class);
	
	@Autowired
	private QuartzManager quartzManager;
	
	@RequestMapping(value = "jobAdd", produces = MediaType.APPLICATION_JSON_VALUE)
	public String jobHello(@RequestParam String jobName, @RequestParam String jobTrigger) {
		log.info("### " + jobName + ", " + jobTrigger);
		
		// test code
//		quartzManager.test();
		try {
			quartzManager.addJob(jobName, jobTrigger);
		} 
		catch (SchedulerException e) {
			e.printStackTrace();
		}
		
		return "add";
	}
	
	@RequestMapping(value = "jobStart")
	public String jobStart(@RequestParam String jobName) {
		log.info("### " + jobName);
		
		try {
			quartzManager.startJob(jobName);
		} 
		catch (SchedulerException e) {
			e.printStackTrace();
		}
		
		return "start";
	}
	
	@RequestMapping(value = "jobPause")
	public String jobPause(@RequestParam String jobName) {
		log.info("### " + jobName);
		
		try {
			quartzManager.pauseJob(jobName);
		} 
		catch (SchedulerException e) {
			e.printStackTrace();
		}
		
		return "pause";
	}
	
	@RequestMapping(value = "jobDelete")
	public String jobDelete(@RequestParam String jobName) {
		log.info("### " + jobName);
		
		try {
			quartzManager.deleteJob(jobName);
		} 
		catch (SchedulerException e) {
			e.printStackTrace();
		}
		
		return "pause";
	}

}
