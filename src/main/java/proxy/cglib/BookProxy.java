package proxy.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @date 2019-12-15
 * @author kcx
 * @description 
 */
public class BookProxy implements MethodInterceptor{
	
	private Object target;
	
	/**
	 * 创建代理对象
	 */
	public Object getInstance(Object target) {
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		/**
		 * 回调方法
		 */
		enhancer.setCallback(this);
		
		/**
		 * 创建对象
		 */
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("cglib代理开始");
		proxy.invokeSuper(obj, args);
		System.out.println("cglib代理结束");
		return null;
	}

}
