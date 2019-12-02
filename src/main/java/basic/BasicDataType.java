package basic;
/**
 * @date 2019-09-10
 * @author kcx
 * @description java有八种基本数据类型，
 * 整型byte/short/int/long
 * 小数类型float/double
 * 字符类型char
 * 真假类型 boolean
 */

public class BasicDataType {

	/**
	 * byte -2^7~2^(7-1)
	 * short -2^15~2^(15-1)
	 * int -2^31~2^(31-1)
	 * long -2^63~2^(63-1)
	 * 数字常量默认int
	 */
	public static void main(String[] args) {
		
		short s = 1;
		//s = s+1; //会报错
		s +=1; 
		
		String[] strs = new String[] {"flower","flow","flight"};
		String string = longestCommonPrefix(strs);
		System.out.println(string);
		
		
		String string2="abcdefg";
		String string3 = reverse(string2);
		System.out.println("-----------------------");
		System.out.println(string3);
		
	}
	
	/**
	 * 递归反转字符串
	 * @param originStr
	 * @return
	 */
	public static String reverse(String originStr) {
		System.out.println(originStr);
	    if(originStr == null || originStr.length() <= 1) 
	        return originStr;
	    return reverse(originStr.substring(1)) + originStr.charAt(0);
	}
	
	public static String longestCommonPrefix(String[] strs) {
		   if (strs.length == 0) return "";
		   String prefix = strs[0];
		   for (int i = 1; i < strs.length; i++)
		       while (strs[i].indexOf(prefix) != 0) {
		           prefix = prefix.substring(0, prefix.length() - 1);
		           System.out.println(prefix);
		           if (prefix.isEmpty()) return "";
		       }    
		   return prefix;
		}
	
	
	
}
