package proxy.staticproxy;
/**
 * @date 2019-12-09
 * @author kcx
 * @description 
 */
public class ProxyTest {

	public static void main(String[] args) {
		Count count = new CountImpl();
		Proxy proxy = new Proxy(count);
		proxy.updateCount();
	}
}
