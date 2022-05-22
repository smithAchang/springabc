package com.example.demo.tasks;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/*
 * 异步任务，在跨bean被调用时，被框架截取然后被提交到后台线程池
 * */
@Service
public class JobTasks {

	private final static Logger LOG = LoggerFactory.getLogger(JobTasks.class);
	
    @Async
	public void printHelloWorld()
	{
		int i =0 ;
		++i;
		System.out.println("stdout AsyncTasks hello,word");
		LOG.info("LOG hello world from AsyncTasks ...");
	}
    
    @Async
   	public Future<String> printHelloWorld2()
   	{
   		int i =0 ;
   		++i;
   		System.out.println("stdout AsyncTasks hello,word2 use Future");
   		LOG.info("LOG hello world2 from AsyncTasks ...");
   		
   		return new Future<String>()  {

			@Override
			public boolean cancel(boolean mayInterruptIfRunning) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isCancelled() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isDone() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public String get() throws InterruptedException, ExecutionException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String get(long timeout, TimeUnit unit)
					throws InterruptedException, ExecutionException, TimeoutException {
				// TODO Auto-generated method stub
				return null;
			}
	    
   		};
   	}
}
