package proxy.dynamicproxy.dynamic;

/**
 * @date 2019-12-09
 * @author kcx
 * @description 
 */
public class DynamicBookProxyTest {

	public static void main(String[] args) {
		BookProxy proxy = new BookProxy();
		BookFacade bookFacade = (BookFacade) proxy.bind(new BookImpl());
		bookFacade.addBook();
	}
}
