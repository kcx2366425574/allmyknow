package reflec;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import thread.monitor.ThisMonitor;

/**
 * @date 2019-12-01
 * @author kcx
 * @description 反射
 */
public class TestReflec {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		/**
		 * 调用某个对象的getClass()方法
		 */
		Person person = new Person();
		Class pClass = person.getClass();
		/**
		 * 调用某个类的class属性
		 */
		Class class1 = Person.class;
		/**
		 * 使用 Class 类中的 forName()静态方法(最安全/性能最好)
		 */
		Class class2 = Class.forName("reflec.Person");
		/**
		 * 获取 Person 类的所有方法信息
		 */
		Method[] methodsMethod = class2.getDeclaredMethods();
		for (Method method : methodsMethod) {
			System.out.println(method.toString());
		}
		
		System.out.println("-------------------");
		
		/**
		 * 获取Person类的所有成员属性信息
		 */
		Field[] field = class2.getDeclaredFields();
		for (Field field2 : field) {
			System.out.println(field2.toString());
		}
		
		System.out.println("-------------------");
		
		/**
		 * 获取Person类的所有构造方法信息
		 */
		Constructor[] constructors = class2.getDeclaredConstructors();
		for (Constructor constructor : constructors) {
			System.out.println(constructor.toString());
		}
		
		/***
		 * 创建对象的两种方法
		 * 1.class对象的newInstance()
		 */

		Person anoPerson = (Person)class2.newInstance();
		
		/**
		 * 2.Constructor对象的newInstance()
		 */
		Constructor c = class2.getDeclaredConstructor(String.class,int.class);
		Person person2 = (Person) c.newInstance("tom",14);
		anoPerson.setName("tom");
		anoPerson.setAge(14);
		System.out.println(person2.toString()+"   "+anoPerson.toString());
		System.out.println(person2.equals(anoPerson));
	}
	
}

class Person implements Serializable{
	private String name;
	private int age;
	
	public Person() {}
	public Person(String name,int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person tem = (Person)obj;
			return tem.getAge()==this.age&&tem.getName().equals(this.name);
		}
		return false;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
	
	
}