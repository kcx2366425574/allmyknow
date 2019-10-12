package datastructure.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @date 2019-10-09
 * @author kcx
 * @description 
 */
public class Main {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String[] str = new String[count];
        int index = 0;
        System.out.println(count);
        while(scanner.hasNext()){
        	String temp = scanner.next();
        	System.out.println(temp+" "+index);
            str[index] = temp;
            index++;
        }
        Map<Character, Character> map = new HashMap<Character, Character>();
        
        System.out.println(count);
        System.out.println(Arrays.toString(str));
        
    }
}
