package designpattern.singleton;
/**
 * @date 2019-10-13
 * @author kcx
 * @description 懒汉模式，双重检查，线程安全
 */
public class LazySingleton4 {

	private static volatile LazySingleton4 singleton;
	
	private LazySingleton4() {};
	
	/**
	 * 提供一个静态的共有方法，当使用这个方法时才去创建实例
	 */
	public static LazySingleton4 getSingleton() {
		
		//双重检查
		if(singleton == null) {
			synchronized (LazySingleton4.class) {
				if(singleton == null) {
					singleton = new LazySingleton4();
				}
			}	
		}
		return singleton;
	}
	
}
