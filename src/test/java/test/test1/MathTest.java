package test.test1;
/**
 * @date 2019-08-24
 * @author kcx
 * @discription 测试Math类中的几个函数
 *
 */
public class MathTest {

	public static void main(String[] args) {
//		/**
//		 * 向上取整
//		 */
//		System.out.println(Math.ceil(1.002));
//		
//		/**
//		 * 向下取整
//		 */
//		System.out.println(Math.floor(-1.58));
//		
//		/**
//		 * 四舍五入
//		 */
//		System.out.println(Math.round(-5.501));
//		
//		/**
//		 * 绝对值
//		 */
//		System.out.println(Math.abs(-1));
//		
//		System.out.println(Integer.MIN_VALUE+"  "+Integer.MAX_VALUE);
//		
//		System.out.println(Integer.MIN_VALUE-1);
		
//		int count = 0;
//		for(int i =1;i>=Integer.MIN_VALUE;i--) {
//			if(Math.abs(i)<=0) {
//				count++;
//			}
//		}
//		System.out.println(count);
		
//		System.out.println(("ja"+"va").equals("java"));
//		System.out.println("ja"+"va"=="java");
		
		
		String string = "java";
		String string2 = "ja"+"va";
		System.out.println(string==string2);
		
		String aString = new String("java");
		String bString = new String("ja"+"va");
		System.out.println(aString==bString);
		
		String string3 = "java";
		String string4 = "ja"+"va";
		System.out.println(string3.equals(string4));
		
		String aString3 = new String("java");
		String bString4 = new String("ja"+"va");
		System.out.println(aString3.equals(bString4));
		
	}

}
