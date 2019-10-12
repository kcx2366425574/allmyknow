package datastructure.map;

import java.util.HashMap;

/**
 * @date 2019-09-05
 * @author kcx
 * @description 
 */
public class HashMapTest {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("1", "2");
		String value = map.put("1", "3");
		System.out.println(value);
		
		System.out.println("10000000".hashCode());
	}
	
}
