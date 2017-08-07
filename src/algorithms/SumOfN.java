package practice;

import java.util.Scanner;
/**
 * Created by Edward Hyunwoo Shin. 
 * Description: Given input by user, find sum of N.
 * 
 */
public class SumOfN {

	public static void main(String[] args) {
		int sum = 0;
		int userInput = 0;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("please enter the value : ");
		userInput = Integer.parseInt(scanner.nextLine());
		
		System.out.println("userInput = " + userInput);
		
		for (int i = 0; i <= userInput ; i++){
			sum = sum + i;
			System.out.println("i = " + i);
			System.out.println("Sum = " + sum);
		}
		
	}

}
