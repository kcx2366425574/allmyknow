package thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @date 2019-11-28
 * @author kcx
 * @description 闭锁
 */
public class TestCountDownLatch {

	public static void main(String[] args) {
		
		CountDownLatch latch = new CountDownLatch(5);
		LatchDemo demo = new LatchDemo(latch);
		
		long start = System.currentTimeMillis();
		for(int i=0;i<5;i++) {
			new Thread(demo).start();
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("运行时间为:"+(end-start));
	}
}
class LatchDemo implements Runnable{

	private CountDownLatch latch;
	
	public LatchDemo(CountDownLatch latch) {
		this.latch = latch;
	}
	@Override
	public void run() {
		
		synchronized (this) {
			try {
				for(int i=0;i<50000;i++) {
					if(i%2==0) {
						System.out.println(i);
					}
				}
			} finally {
				latch.countDown();
			}
		}
		
	}
}
