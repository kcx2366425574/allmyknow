package designpattern.singleton;
/**
 * @date 2019-10-13
 * @author kcx
 * @description 饿汉单例模式，静态内部类,延迟加载，效率高，推荐使用。
 * 静态内部类在HungerSingleton3加载时不会立即实例化，而是在需要实例化时，调用getInstance（）方法
 */
public class HungerSingleton3 {

	/**
	 * 构造方法私有化
	 */
	private HungerSingleton3() {};
	
	/**
	 * 创建一个静态内部类
	 */
	private static class SingletonInstance{
		private static final HungerSingleton3 singleton = new HungerSingleton3();
	}
	
	public HungerSingleton3 getSingleton() {
		return SingletonInstance.singleton;
	}
	
}
