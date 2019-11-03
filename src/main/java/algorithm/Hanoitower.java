package algorithm;

import java.util.Map;

/**
 * @date 2019-10-14
 * @author kcx
 * @description 
 */
public class Hanoitower {

	public static void main(String[] args) {
		hanoitower(3, 'A', 'B', 'C');
	}

	public static void hanoitower(int n,char a,char b,char c) {
		if(n == 1) {
			System.out.println("第1个盘  "+a+"->"+c);
		}else {
			/**
			 * 1.将底盘上面所有的盘通过c移动到b
			 */
			hanoitower(n-1, a, c, b);
			
			/**
			 * 2.将底盘移动到c
			 */
			System.out.println("第"+n+"个盘  "+a+"->"+c);
			
			/**
			 * 3.将b上的盘子通过a移动到c
			 */
			hanoitower(n-1, b, a, c);
		}
	}
}
