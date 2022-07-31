package app;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExectorDemo {
	
	static Runnable scheduledTask = ()->{
			System.out.println("Task Starts"+Thread.currentThread().getName());
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	};
	
	static Callable<String> scheduledTask2 = ()->{
		System.out.println("Task Starts"+Thread.currentThread().getName());
		TimeUnit.SECONDS.sleep(2);
		return "Task1 Completed";
};
	
	public static void main(String...strings) {
		
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		
		ScheduledFuture<?> future = executor.scheduleWithFixedDelay(scheduledTask,0, 1, TimeUnit.SECONDS);
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Is Done: "+future.cancel(true));
		
		
	}

}
