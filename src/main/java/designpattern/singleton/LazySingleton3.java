package designpattern.singleton;
/**
 * @date 2019-10-13
 * @author kcx
 * @description 懒汉模式（线程不安全,同步代码块）
 */
public class LazySingleton3 {

	private static LazySingleton3 singleton;
	
	private LazySingleton3() {};
	
	/**
	 * 提供一个静态的共有方法，当使用这个方法时才去创建实例
	 */
	public static LazySingleton3 getSingleton() {
		
		if(singleton == null) {
			synchronized (LazySingleton3.class) {
				singleton = new LazySingleton3();
			}
		}
		return singleton;
	}
	
}
