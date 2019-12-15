package proxy.dynamicproxy.anotherdynamictest;

/**
 * @date 2019-12-15
 * @author kcx
 * @description 
 */
public class BookImpl implements Book {

	@Override
	public void getBookId() {
		System.out.println("我得到了书的id");
	}

}
