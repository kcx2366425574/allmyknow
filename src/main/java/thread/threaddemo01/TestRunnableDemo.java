package thread.threaddemo01;

public class TestRunnableDemo {

	public static void main(String[] args) {


		TestRunnable testRunnable = new TestRunnable();
		
		Thread trThread = new Thread(testRunnable, "thread1");
		
		
		Thread thread = new Thread(testRunnable, "thread2");
		thread.start();
		
		trThread.start();
		
		Thread thread2 = new Thread(testRunnable,"thread3");
		thread2.start();
		

	}

}
