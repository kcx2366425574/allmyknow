package thread.hospitaltest;

import java.util.concurrent.TimeUnit;

/*
  @date 2019-08-01
  @Author kcx
*/
public class Hospital implements Runnable {

	private int count = 1;
	
	private static final int MAX = 100;
	
	private static final Object ob = new Object();
	@Override
	public void run() {
		while (count<=MAX) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (ob) {
				System.out.println(Thread.currentThread().getName()+"���ղ���"+count);
				count++;
			}
			
		}
		
		
	}

}
