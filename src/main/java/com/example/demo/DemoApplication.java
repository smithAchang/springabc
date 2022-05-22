package com.example.demo;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.example.demo.tasks.JobTasks;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class DemoApplication {

	private final static Logger LOG = LoggerFactory.getLogger(DemoApplication.class);
	
	private static ApplicationContext applicationContext;
	public static void main(String[] args) {
		applicationContext = SpringApplication.run(DemoApplication.class, args);
		LOG.info("finish application run !");
		
	}
	

	@Bean
    public Executor executeThread() {
		   ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	        executor.setCorePoolSize(1);
	        executor.setMaxPoolSize(2);
	        executor.setQueueCapacity(200);
	        executor.setKeepAliveSeconds(60);
	        executor.setThreadNamePrefix("taskCustomized-");
	        executor.setWaitForTasksToCompleteOnShutdown(false);
	        executor.setAwaitTerminationSeconds(60);
	        executor.setRejectedExecutionHandler(new CallerRunsPolicy());
	        return executor;
    }
	
	
	
	@PostConstruct
	public void postConstruct()
	{
		LOG.info("post Construct of main");
		
	
	}
	
	
	
   

}
