package test.test1.animalcompare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @date 2019-08-25
 * @author kcx
 * @description animal类实现了comparable接口，在测试类中使用Collections.sort()
 *
 */
public class AnimalTest {

	public static void main(String[] args) {

		Animal tiger = new Animal(3, 33.2);
		Animal cat = new Animal(5, 5.2);
		Animal dolphin = new Animal(6,131.7);
		Animal snake = new Animal(2,13.1);
		
		List<Animal> list = new ArrayList<Animal>();
		list.add(snake);
		list.add(tiger);
		list.add(dolphin);
		list.add(cat);
		
		Collections.sort(list);

		for (Animal animal : list) {
			System.out.println(animal);
		}
		
	}

}
