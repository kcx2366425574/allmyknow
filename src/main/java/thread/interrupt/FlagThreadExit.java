package thread.interrupt;

import java.util.concurrent.TimeUnit;

/*
  @date 2019-08-01
  @Author kcx
*/
public class FlagThreadExit {

	static class MyTask extends Thread{
		private volatile boolean closed = false;
		
		@Override
		public void run() {
			System.out.println("I will start work");
			while(!closed && !isInterrupted()) {
				//��������
			}
			System.out.println("I will be exiting");
		}
		public void close() {
			this.closed = true;
			this.interrupt();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		MyTask task = new MyTask();
		task.start();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("System will be shutdown.");
		task.close();
	}

}
