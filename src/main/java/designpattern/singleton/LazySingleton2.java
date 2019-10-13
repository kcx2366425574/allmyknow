package designpattern.singleton;
/**
 * @date 2019-10-13
 * @author kcx
 * @description 懒汉模式（线程安全,但是效率低，不推荐使用）
 */
public class LazySingleton2 {

	private static LazySingleton2 singleton;
	
	private LazySingleton2() {};
	
	/**
	 * 提供一个静态的共有方法，当使用这个方法时才去创建实例
	 */
	public static synchronized LazySingleton2 getSingleton() {
		if(singleton == null) {
			singleton = new LazySingleton2();
		}
		return singleton;
	}
	
}
