package thread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @date 2019-07-14
 * @author kcx
 *
 */
public class ThreadInterrupt {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(()-> {
			try {
				TimeUnit.MINUTES.sleep(1);
			} catch (InterruptedException e) {
				System.out.println("Oh,i am interrupted.");
			}
			
		});
		
		thread.start();
		
		//short block and make sure thread is started
		TimeUnit.SECONDS.sleep(2);
		thread.interrupt();
	}

}
