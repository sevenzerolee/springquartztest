package org.sevenzero.springdemo.mgr;

import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.sevenzero.springdemo.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author lb
 * @version 1.0.1
 * @Description
 * @date 2018年1月29日
 *
 */
//@Component // 可行
@Service // 可行
public class QuartzManager {
	
	static final Logger log = Logger.getLogger(QuartzManager.class);
	
	@Autowired
	private Scheduler scheduler;
	
	public void test() {
		log.info("### test");
		log.info("### " + scheduler);
		
	}
	
	/**
	 * 添加一个定时任务，不启动
	 * @param jobName
	 * @param time
	 * @throws SchedulerException
	 */
	public void addJob(String jobName, String time) throws SchedulerException {
		// 构造JobDetail
//		String jobGroup = jobName + "Group";
		Job obj = (Job) BeanUtil.getBean(jobName);
		JobDetail jobDetail = JobBuilder.newJob(obj.getClass())
				.storeDurably(true)
				.withIdentity(jobName)
				.build();
//		scheduler.addJob(jobDetail, true);
		
		String triggerName = jobName + "Trigger";
//		String triggerGroup = triggerName + "Group";
//		log.info("### " + jobName + ", " + jobGroup + ", " + triggerName + ", " + triggerGroup + ", " + time);
		log.info("### " + jobName + ", " + triggerName + ", " + time);
		
		// 判断Trigger是否存在
		TriggerKey triggerKey = TriggerKey.triggerKey(triggerName);
		CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
		CronScheduleBuilder csb = CronScheduleBuilder.cronSchedule(time);
		
		if (null == trigger) {
		    trigger = TriggerBuilder.newTrigger()
		    		.withIdentity(triggerName)
		    		.withSchedule(csb)
		    		.build();
		    
		    scheduler.scheduleJob(jobDetail, trigger);
		}
		else {
			String oldTime = trigger.getCronExpression();
			log.info("### " + oldTime);
			if (!oldTime.equalsIgnoreCase(time)) {
				 trigger = TriggerBuilder.newTrigger()
				    		.withIdentity(triggerName)
				    		.withSchedule(csb)
				    		.build();
				 scheduler.rescheduleJob(triggerKey, trigger);
			}
			else {
				log.info("### 周期相同不用更新");
			}
		}
		scheduler.pauseJob(jobDetail.getKey());
	    
//	    scheduler.start();
	}
	
	/**
	 * 启动一个任务
	 * @param jobName
	 * @throws SchedulerException
	 */
	public void startJob(String jobName) throws SchedulerException {
		JobKey jobKey = JobKey.jobKey(jobName);
		scheduler.resumeJob(jobKey);
	}
	
	/**
	 * 暂停一个任务
	 * @param jobName
	 * @throws SchedulerException
	 */
	public void pauseJob(String jobName) throws SchedulerException {
		JobKey jobKey = JobKey.jobKey(jobName);
		scheduler.pauseJob(jobKey);
	}
	
	/**
	 * 删除一个任务
	 * @param jobName
	 * @throws SchedulerException
	 */
	public void deleteJob(String jobName) throws SchedulerException {
		JobKey jobKey = JobKey.jobKey(jobName);
		scheduler.deleteJob(jobKey);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
