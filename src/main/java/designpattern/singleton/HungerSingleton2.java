package designpattern.singleton;
/**
 * @date 2019-10-13
 * @author kcx
 * @description 饿汉单例模式，静态代码块
 */
public class HungerSingleton2 {

	/**
	 * 构造方法私有化，类内部创建对象
	 */
	private HungerSingleton2() {};
	
	private static HungerSingleton2 singleton;
	
	static {
		singleton = new HungerSingleton2();
	}
	
	public HungerSingleton2 getSingleton() {
		return singleton;
	}
}
