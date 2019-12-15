package proxy.dynamicproxy.anotherdynamictest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @date 2019-12-09
 * @author kcx
 * @description 
 */
public class CountProxy implements InvocationHandler {

	private Object target;
	
	public Object bind(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		
		System.out.println("开始动态代理");
		result = method.invoke(target, args);
		System.out.println("结束动态代理");
		return result;
	}

}
