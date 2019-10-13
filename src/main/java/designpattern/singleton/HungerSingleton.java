package designpattern.singleton;
/**
 * @date 2019-10-13
 * @author kcx
 * @description 饿汉单例模式，静态常量
 */
public class HungerSingleton {

	/**
	 * 构造方法私有化，类内部创建对象
	 */
	private HungerSingleton() {};
	
	private final static HungerSingleton singleton = new HungerSingleton();
	
	public HungerSingleton getSingleton() {
		return singleton;
	}
}
