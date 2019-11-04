package thread.eventqueue;

import java.util.concurrent.TimeUnit;

/**
 * @date 2019-08-09
 * @author kcx
 *
 */
public class EventClient {

	public static void main(String[] args) {
		final EventQueue eventQueue = new EventQueue();
		
		new Thread(()->{
			for(;;) {
				eventQueue.offer(new EventQueue.Event());
			}
		},"producer").start();
		
		
		new Thread(()->{
			for(;;) {
				eventQueue.take();
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"consumer").start();
		
		
	}
	

}
