package allmyknow.basic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @date 2019-11-24
 * @author kcx
 * @description 
 */

public class Test {

	@org.junit.Test
	public void test() {
		int i = 10;
		i = i++;
		System.out.println(i);
	}
}
