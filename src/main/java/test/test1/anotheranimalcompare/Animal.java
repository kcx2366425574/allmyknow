package test.test1.anotheranimalcompare;
/**
 * @date 2019-08-26
 * @author kcx
 *
 */
public class Animal{
	
	private int age;
	private double weight;
	
	

	public Animal() {}		
	public Animal(int age, double weight) {
		super();
		this.age = age;
		this.weight = weight;
	}



	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "Animal [age=" + age + ", weight=" + weight + "]";
	}
	

}
