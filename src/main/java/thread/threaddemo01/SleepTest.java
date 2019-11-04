package thread.threaddemo01;

import java.util.concurrent.TimeUnit;

/*
  @date 2019-08-01
  @author kcx
*/
public class SleepTest {

	public static void main(String[] args) {
		try {
			TimeUnit.MINUTES.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
