package test.test1.anotheranimalcompare;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @date 2019-08-25
 * @author kcx
 * @description 通过数组排序
 *
 */
public class AnimalTest {

	public static void main(String[] args) {

		Animal tiger = new Animal(3, 33.2);
		Animal cat = new Animal(5, 5.2);
		Animal dolphin = new Animal(6,131.7);
		Animal snake = new Animal(2,13.1);
		
		Animal[] animals = new Animal[4];
		animals[0]=tiger;
		animals[1]=cat;
		animals[2]=dolphin;
		animals[3]=snake;
		
		
		Arrays.sort(animals,new Comparator<Animal>() {
			@Override
			public int compare(Animal a1,Animal a2) {
				return Double.compare(a1.getWeight(),a2.getWeight());
			}
		});
		
		for (Animal animal : animals) {
			System.out.println(animal);
		}
		
		for(int i = 1;i>-5;i--) {
			System.out.println(i);
		}
		
	}

}
