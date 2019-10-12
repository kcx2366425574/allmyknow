package datastructure.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @date 2019-08-23
 * @author kcx
 *
 */

public class QueueTest {

	/**
	 * ����װƻ��������	
	 */
	public static class Basket{
		
		//���ӣ��ܹ���������ƻ��
		BlockingQueue<String> strQueue = new ArrayBlockingQueue<String>(3);
		
		public void produce() throws InterruptedException {
			strQueue.put("an Apple!");
		}
		
		public String consume() throws InterruptedException {
			return strQueue.take();
		}
		
		public int getAppleNumber() {
			return strQueue.size();
		}
	}
	
	/**
	 * ���Է���
	 */
	public static void testBasket() {
		//����һ��װƻ��������
		final Basket basket = new Basket();
		
		class Producer implements Runnable{
			@Override
			public void run() {
				try {
					while(true) {
						//����ƻ��
						System.out.println("������׼������ƻ����"+System.currentTimeMillis());
						basket.produce();
						System.out.println("����ƻ����ϣ�"+System.currentTimeMillis());
						System.out.println("Ŀǰ����ƻ����"+basket.getAppleNumber());
						//�������ٺ���
						Thread.sleep(300);
					}
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
		/**
		 * ����ƻ��������
		 */
		class Consumer implements Runnable{
			@Override
			public void run() {
				try {
					while(true) {
						System.out.println("������׼������ƻ����"+System.currentTimeMillis());
						basket.consume();
						System.out.println("����������ƻ�����"+System.currentTimeMillis());
						System.out.println("�������һ��ʣ��ƻ����"+basket.getAppleNumber());
						
						TimeUnit.SECONDS.sleep(1);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		 
		    ExecutorService service = new ThreadPoolExecutor(10, 10,
		            60L, TimeUnit.SECONDS,
		            new ArrayBlockingQueue(10));		
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		
		service.submit(producer);
		service.submit(consumer);
		
		//��������10s����������ֹͣ
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		service.shutdownNow();
	}
	
	public static void main(String[] args) {
		testBasket();
	}
	
}
