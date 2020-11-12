package com.mveeramuthu.executor.basic;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {

	public static void main(String[] args) throws InterruptedException {
	    System.out.println("Current Time = "+new Date());

	    ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);

	    for(int i=1; i<=3; i++){
		Thread.sleep(2000);
		MyRunnable task = new MyRunnable("Task "+i);
		scheduledThreadPool.schedule(task,3, TimeUnit.SECONDS); // schedule task delay to 3 seconds
	    }

	    Thread.sleep(6000); // Adding some delay
	    scheduledThreadPool.shutdown();
	    System.out.println("Completed all threads");
	}
}
