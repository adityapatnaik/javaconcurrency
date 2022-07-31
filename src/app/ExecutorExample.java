package app;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;



public class ExecutorExample {
	
	static Callable<String> task1 = ()->{
		System.out.println("Task Started:"+Thread.currentThread().getName());
		TimeUnit.SECONDS.sleep(0);
		return "Task Result";
	};
	
	public static void main(String...args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		try {
			Future<String> future = executor.submit(task1);
			System.out.println(future.get());
			executor.shutdown();
			executor.awaitTermination(3, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(!executor.isTerminated()) {
				System.out.println("Cancel non-finished tasks");
			}
			executor.shutdownNow();
			System.out.println("Shutdown Finished!");
		}
	}

}
