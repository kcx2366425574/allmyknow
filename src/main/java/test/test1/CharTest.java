package test.test1;
/**
 * @date 2019-11-10
 * @author kcx
 * @description 
 */

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class CharTest {

	@Test
	public void testSwap() {
		char[] ch = {'a','b','c','d','e','f'};
		swap(ch, 0, 3);
		System.out.println(9*8*7*6*5*4*3*2*1);
	}
	
	public static void swap(char[] c,int a,int b) {
		char tem = c[a];
		c[a] = c[b];
		c[b] = tem;
	}
}
