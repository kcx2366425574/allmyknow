package designpattern.singleton;
/**
 * @date 2019-10-13
 * @author kcx
 * @description 懒汉模式（线程不安全,不推荐使用）
 */
public class LazySingleton {

	private static LazySingleton singleton;
	
	private LazySingleton() {};
	
	/**
	 * 提供一个静态的共有方法，当使用这个方法时才去创建实例
	 */
	public static LazySingleton getSingleton() {
		if(singleton == null) {
			singleton = new LazySingleton();
		}
		return singleton;
	}
	
}
