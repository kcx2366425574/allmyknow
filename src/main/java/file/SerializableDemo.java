package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * @date 2019-11-02
 * @author kcx
 * @description 
 */
public class SerializableDemo {

	public static void main(String[] args) {

		ObjectOutputStream objectOutputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			FileOutputStream outputStream = new FileOutputStream("F:\\Wode\\2.txt");
			objectOutputStream = new ObjectOutputStream(outputStream);
			Student student = new Student("张三", 18, "北京");
			objectOutputStream.writeObject(student);
			
			FileInputStream fis = new FileInputStream("F:\\Wode\\2.txt");
			objectInputStream = new ObjectInputStream(fis);
			Student s = (Student) objectInputStream.readObject();
			System.out.println(s);
			
			objectOutputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				objectOutputStream.close();
				objectInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

}


class Student implements Serializable{
	private String name;
	private int age;
	private String address;
	
	public Student() {}

	public Student(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", address=" + address + "]";
	}
	
	
	
}
