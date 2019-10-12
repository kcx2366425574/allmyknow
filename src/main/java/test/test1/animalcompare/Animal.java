package test.test1.animalcompare;
/**
 * @date 2019-08-25
 * @author kcx
 *
 */
public class Animal implements Comparable<Animal>{
	
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
	public int compareTo(Animal o) {
		return Double.compare(this.weight, o.weight);
	}

}
