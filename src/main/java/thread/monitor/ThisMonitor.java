package thread.monitor;

import java.util.concurrent.TimeUnit;

/**
 * @date 2019-08-04
 * @Author kcx
 * @description synchronized�ؼ���������ͬһ��ʵ�������������ͬ����
 */
public class ThisMonitor {
	
	public synchronized void method1() {
		System.out.println(Thread.currentThread().getName()+" enter to method1");
		try {
			TimeUnit.MINUTES.sleep(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void method2() {
		System.out.println(Thread.currentThread().getName()+" enter to method2");
		try {
			TimeUnit.MINUTES.sleep(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ThisMonitor monitor = new ThisMonitor();
		
		new Thread(monitor::method1,"T1").start();
		new Thread(monitor::method2,"T2").start();

		
	}

}
