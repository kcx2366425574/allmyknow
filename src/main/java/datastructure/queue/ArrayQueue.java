package datastructure.queue;

import java.util.Queue;

import org.apache.log4j.Logger;

/**
 * @date 2019-09-19
 * @author kcx
 * @description 用数组演示环形队列
 */
public class ArrayQueue{
	
	Logger logger = Logger.getLogger(ArrayQueue.class);
	
	/**
	 * 表示数组的最大容量
	 */
	private int maxSize;
	
	/**
	 * 指向队列头
	 */
	private int front;
	
	/**
	 * 指向队列尾
	 */
	private int rear;
	
	/**
	 * 数组存放数据，模拟队列
	 */
	private int[] arr;
	
	/**
	 * 创建队列的构造器
	 * @param maxSize
	 */
	public ArrayQueue(int maxSize) {
		this.maxSize = maxSize;
		front = 0;
		rear = 0;
		arr = new int[maxSize];
	}
	
	public void add(int a) {
		if(isFull()) {
			logger.info("队列已满，不能添加数据!");
			return;
		}
		
		/**
		 * 如果队列没满
		 */
		arr[rear] = a;
		
		/**
		 * 将rear后移，需考虑模
		 */
		
		rear = (rear + 1) % maxSize;
		
	}
	
	/**
	 * 获取队列数据
	 */
	public int get() {
		if(isEmpty()) {
			throw new RuntimeException("队列为空，不能取数据！");
		}
		
		/**
		 * 将取到的值保留在临时变量中，front后移(考虑取模)，并且返回该临时变量
		 */
		int temp = arr[front];
		front = (front + 1) % maxSize;
		return temp;
	}
	
	/**
	 * 遍历该队列数据
	 */
	public void show() {
		if(isEmpty()) {
			logger.info("该队列中没有数据！");
			return;
		}
		
		for(int i=front;i<front+size();i++) {
			System.out.print(arr[i%maxSize]+"  ");
		}
	}
	
	
	/**
	 * 显示队列头数据
	 */
	public int head() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空，没有有效数据");
		}
		
		return arr[front];
	}
	
	/**
	 * 判断队列是否已满
	 * @return boolean
	 */
	public boolean isFull() {
		return ( rear + 1 ) % maxSize == front;
	}
	
	/**
	 * 判断队列是否为空
	 * @return boolean
	 */
	public boolean isEmpty() {
		return rear == front;
	}
	
	/**
	 * 求出当前队列有效数组个数
	 */
	public int size() {
		return (rear + maxSize - front) % maxSize;
	}
	
	
}