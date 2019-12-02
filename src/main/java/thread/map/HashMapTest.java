package thread.map;

import java.util.HashMap;
/**
 * @date 2019-09-21
 * @author kcx
 * @description {@link HashMap}put
 */

import org.junit.Test;
public class HashMapTest {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("1", "2");
		String value = map.put("1", "3");
		System.out.println(value);
		System.out.println(map);
	}
	
	@Test
	public void testContainsvalue() {
		String string = null;
		Character character = null;
		System.out.println(1);
	}

}
