package designpattern.singleton;
/**
 * @date 2019-10-13
 * @author kcx
 * @description 使用枚举实现单例模式
 */
public class EnumSingleton {

	public static void main(String[] args) {
		Singleton instance = Singleton.INSTANCE;
		Singleton instance2 = Singleton.INSTANCE;
		
		System.out.println(instance==instance2);
	}
}
enum Singleton{
	INSTANCE; //属性
	public void sayOK() {
		System.out.println("OK~");
	}
}
