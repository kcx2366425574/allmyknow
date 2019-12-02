package thread.countdownlatch;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @date 2019-11-28
 * @author kcx
 * @description 
 */
public class TestLock {

	public static void main(String[] args) {
		LockDemo demo = new LockDemo();
		for(int i=0;i<3;i++) {
			new Thread(demo, "窗口"+i).start();;
		}
	}
}

class LockDemo implements Runnable{
	
	private int count = 100;
	private Lock lock = new ReentrantLock();

	@Override
	public void run() {
		
		while(true) {
			
			lock.lock();

			if (count>0) {
				try {
					try {
						TimeUnit.MILLISECONDS.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "卖票:" + count);
					count--;
				} finally {
					lock.unlock();
				} 
			}
			
		}
		
	}
	
}
