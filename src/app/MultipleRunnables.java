package app;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultipleRunnables {
	
	public static void main(String... args) {
		
		Runnable task1 = ()->{
			try {
				System.out.println("Task Started:"+Thread.currentThread().getName());
				TimeUnit.SECONDS.sleep(1);
				System.out.println("Task Ended:"+Thread.currentThread().getName());	
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		Runnable task3 = ()->{
			try {
				System.out.println("Task Started:"+Thread.currentThread().getName());
				TimeUnit.SECONDS.sleep(1);
				System.out.println("Task Ended:"+Thread.currentThread().getName());	
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		Runnable task2 = ()->{
			try {
				System.out.println("Task Started:"+Thread.currentThread().getName());
				TimeUnit.SECONDS.sleep(1);
				System.out.println("Task Ended:"+Thread.currentThread().getName());	
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		try {
			executor.execute(task1);
			executor.execute(task2);
			executor.execute(task3);
			executor.shutdown();
			executor.awaitTermination(5, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(!executor.isTerminated()) {
				System.out.println("Cancel Non-finished Tasks");
			}
			executor.shutdownNow();
			System.out.println("Shutdown done");
		}
		
		
	}

}
