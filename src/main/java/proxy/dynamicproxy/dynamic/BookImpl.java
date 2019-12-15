package proxy.dynamicproxy.dynamic;
/**
 * @date 2019-12-09
 * @author kcx
 * @description 
 */
public class BookImpl implements BookFacade{

	@Override
	public void addBook() {
		System.out.println("添加书籍!");
	}

}
