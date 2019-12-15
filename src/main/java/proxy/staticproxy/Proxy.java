package proxy.staticproxy;
/**
 * @date 2019-12-09
 * @author kcx
 * @description 
 */
public class Proxy implements Count{

	private Count count;
	public Proxy(Count count) {
		this.count = count;
	}
	@Override
	public void queryCount() {
		System.out.println("代理开始---------------");
		count.queryCount();
		System.out.println("代理结束-------------------");
	}

	@Override
	public void updateCount() {
		System.out.println("代理开始---------------");
		count.updateCount();
		System.out.println("代理结束-------------------");
	}

}
