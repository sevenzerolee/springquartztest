package org.sevenzero.springdemo.controller;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {
	
	static final Logger log = Logger.getLogger(JobController.class);
	
	@RequestMapping(value = "jobHello", produces = MediaType.APPLICATION_JSON_VALUE)
	public String jobHello(@RequestParam String name) {
		log.info("### " + name);
		
		return "OK";
	}

}
