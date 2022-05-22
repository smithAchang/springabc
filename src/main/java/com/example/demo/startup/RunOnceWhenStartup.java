package com.example.demo.startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Configuration
public class RunOnceWhenStartup {
	
	private final static Logger LOG = LoggerFactory.getLogger(RunOnceWhenStartup.class);
	
	@Autowired
	private static ApplicationContext applicationContext;
	
	@Component
	public class SearchReceive implements  ApplicationListener<ContextRefreshedEvent> {
	   @Override
	   public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
	       if (contextRefreshedEvent.getApplicationContext().getParent() == null) {//保证只执行一次
	           LOG.info("only run once --- contextRefreshedEvent");
	           displayAllBeans(contextRefreshedEvent.getApplicationContext());
	       }
	   }
	}
	
	
	@Component
	@Order(value = 1)
	public class AfterRunner implements ApplicationRunner {
	    @Override
	    public void run(ApplicationArguments args) throws Exception {
	    	 LOG.info("only run once----for ApplicationRunner");
	    }
	}
	
	
	@Component
	@Order(value = 2)
	public class CommandLineRunnerImpl implements CommandLineRunner {
	    @Override
	    public void run(String... args) throws Exception {
	    	 LOG.info("only run once----for CommandLineRunner");
	    }
	}
	
	
	private static void displayAllBeans(ApplicationContext applicationContext){

		LOG.info("-----------------------------------------");
		String[] allBeanNames = applicationContext.getBeanDefinitionNames();

		for(String beanName : allBeanNames) {

			LOG.info(beanName);

		}
		
		LOG.info("-----------------------------------------");
	}
	

}
