package com.example.demo.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimerTasks {

	private final static Logger LOG = LoggerFactory.getLogger(TimerTasks.class);
	
	@Scheduled(initialDelay=1000,fixedDelay=5*1000)
	public void printHelloWorld1()
	{
		int i =0 ;
		++i;
		LOG.info("stdout fixedDelay run has initialDelay ...");
	}
	
	@Scheduled(fixedDelay=5*1000)
	public void printHelloWorld()
	{
		int i =0 ;
		++i;
	
		LOG.info("log fixedDelay run ...");
	}
	
	@Scheduled(cron ="0/4 * * * * ?")
	public void cronJob(){
	        LOG.info("log cron every four seconds  ...");
	}
	
}
