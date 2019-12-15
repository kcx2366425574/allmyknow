package proxy.dynamicproxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @date 2019-12-09
 * @author kcx
 * @description 
 */
public class BookProxy implements InvocationHandler{
	
	private Object target;
	
	/**
	 * 绑定委托对象并返回一个代理类
	 * @return 
	 */
	public Object bind(Object target) {
		this.target = target;
		/**
		 * 取得代理对象（需要绑定接口，这是个缺陷，cglib弥补了这个缺陷）
		 */
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		System.out.println("事物开始");
		/**
		 * 执行方法
		 */
		result = method.invoke(target, args);
		System.out.println("事物结束");
		return result;
	}

}
