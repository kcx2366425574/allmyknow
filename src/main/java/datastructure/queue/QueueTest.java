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
	 * 定义装苹果的篮子	
	 */
	public static class Basket{
		
		//篮子，能够容纳三个苹果
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
	 * 测试方法
	 */
	public static void testBasket() {
		//建立一个装苹果的篮子
		final Basket basket = new Basket();
		
		class Producer implements Runnable{
			@Override
			public void run() {
				try {
					while(true) {
						//生产苹果
						System.out.println("生产者准备生产苹果："+System.currentTimeMillis());
						basket.produce();
						System.out.println("生产苹果完毕："+System.currentTimeMillis());
						System.out.println("目前共有苹果："+basket.getAppleNumber());
						//休眠三百毫秒
						Thread.sleep(300);
					}
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
		/**
		 * 定义苹果消费者
		 */
		class Consumer implements Runnable{
			@Override
			public void run() {
				try {
					while(true) {
						System.out.println("消费者准备消费苹果："+System.currentTimeMillis());
						basket.consume();
						System.out.println("消费者消费苹果完毕"+System.currentTimeMillis());
						System.out.println("消费完后一共剩余苹果："+basket.getAppleNumber());
						
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
		
		//程序运行10s后，所有任务停止
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
