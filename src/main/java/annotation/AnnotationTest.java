package annotation;
/**
 * @date 2019-12-05
 * @author kcx
 * @description 
 */

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Annotaion在反射函数中的使用示例
 */
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
	String[] value() default "unknown";
}

/**
 * Person类。使用MyAnnotation注解。
 */
class Person{
	@MyAnnotation
	@Deprecated
	public void empty() {
		System.out.println("\nempty");
	}
	
	@MyAnnotation(value = {"girl","boy"})
	public void somebody(String name,int age) {
		System.out.println("\nsomebody:"+name+", "+age);
	}
}
public class AnnotationTest {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Person person = new Person();
		
		Class<Person> c = Person.class;
		
		/**
		 * 获取somebody()方法的Method实例
		 */
		Method somebodyMethod = c.getDeclaredMethod("somebody", String.class,int.class);
		
		/**
		 * 执行该方法
		 */
		somebodyMethod.invoke(person, new Object[] {"Lily",18});
		iteratorAnnotations(somebodyMethod);
		
		// 获取 somebody() 方法的Method实例
        Method mEmpty = c.getMethod("empty", new Class[]{});
        // 执行该方法
        mEmpty.invoke(person, new Object[]{});        
        iteratorAnnotations(mEmpty);
	}

	private static void iteratorAnnotations(Method method) {
		// 判断 somebody() 方法是否包含MyAnnotation注解
        if(method.isAnnotationPresent(MyAnnotation.class)){
            // 获取该方法的MyAnnotation注解实例
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            System.out.println("----------获取 myAnnotation的值，并打印出来------------");
            // 获取 myAnnotation的值，并打印出来
            String[] values = myAnnotation.value();
            for (String str:values) {
                System.out.printf(str+", ");
            }
            System.out.println();
        }
        
        
        System.out.println("----------获取方法上的所有注解，并打印出来-------");
        // 获取方法上的所有注解，并打印出来
        Annotation[] annotations = method.getAnnotations();
        for(Annotation annotation : annotations){
            System.out.println(annotation);
        }
    
	}
}
