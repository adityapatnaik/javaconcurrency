package app;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class BatchSubmitCallables {
	
	public static void main(String...strings) throws InterruptedException 
	{
		List<Callable<String>> callables = Arrays.asList(
				()->{
					TimeUnit.SECONDS.sleep(1);
					return "task1";
					},
				()->{
					TimeUnit.SECONDS.sleep(3);
					return "task2";
				}
				);
		
		ExecutorService executor = Executors.newWorkStealingPool();
		executor.invokeAll(callables)
		.stream()
		.map(t -> {
			try {
				return t.get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new IllegalStateException(e);
				
			}
			
		})
		.forEach(System.out::println);
		
		ExecutorService executor2 = Executors.newWorkStealingPool();
		try {
			System.out.print(executor2.invokeAny(callables));
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		executor.shutdown();
//		executor.awaitTermination(5, TimeUnit.SECONDS);
		
	}

}
