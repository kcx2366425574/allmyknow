package proxy.cglib;
/**
 * @date 2019-12-15
 * @author kcx
 * @description 
 */
public class CglibTest {
	public static void main(String[] args) {
		BookProxy proxy = new BookProxy();
		Book book = (Book) proxy.getInstance(new BookImpl());
		book.getBookId();
	}

}
