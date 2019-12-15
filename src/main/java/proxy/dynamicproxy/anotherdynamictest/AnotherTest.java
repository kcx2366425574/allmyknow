package proxy.dynamicproxy.anotherdynamictest;

/**
 * @date 2019-12-09
 * @author kcx
 * @description 
 */
public class AnotherTest {

	public static void main(String[] args) {
		CountProxy proxy = new CountProxy();
		Count count = (Count) proxy.bind(new CountImpl());
		count.queryCount();
		
		Book book = (Book) proxy.bind(new BookImpl());
		book.getBookId();
	}
}
