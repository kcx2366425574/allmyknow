package thread.threaddemo01;

import java.util.concurrent.TimeUnit;

/**
 * @date 2019-07-13
 * @author kcx
 *
 */
public class TestRunnable implements Runnable {

	private static int total = 100;
	private int index = 1;
	
	@Override
	public void run() {
		while(index<=100) {
			synchronized(this) {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"  total is "+total+",this is No."+index);
				index++;
			}
		}
	}

}
