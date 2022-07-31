package app;

public class MainApplication {
	
	public static void main(String... args) {
		
		System.out.println("Hello World!");
		
		Runnable task = ()->{
			System.out.println("Running task: "+Thread.currentThread().getName());
		};
		
		task.run(); // Running task: main
		
		Thread thread = new Thread(task);
		/*
		 	Hello World!
			Running task: main
			End of Code!
			Running task: Thread-0
		*/
		thread.start(); 
		
		System.out.println("End of Code!");
		
		
	}

}
