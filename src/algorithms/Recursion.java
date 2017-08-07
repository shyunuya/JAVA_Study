package practice;

import java.util.Scanner;
/**
 * Created by Edward Hyunwoo Shin. 
 * Description:  Given user input, find number of cases with cents (50, 25, 10, 5, 1) you can make using recursion
 * 
 */
public class Recursion {
	static int[] cents = {50, 25, 10, 5, 1};
	
	public static int count(int amount) {
		return count(amount, 0);
	}
	
	public static int count(int amount, int idx){
		if (amount == 0){
			System.out.println("First if statement");
			System.out.println("Amount : " + amount);
			return 1;
		} else if ( amount < 0 || idx >= cents.length){
			System.out.println("Second else if statement ");
			return 0;			
		} else {
			System.out.println("Here is else statement");
			System.out.println("Amount : " + amount + "  Cents[" + idx +"] : " + cents[idx]);
			return count(amount - cents[idx],idx) + count(amount, idx + 1);
		}
	}
	
	public static void main(String[] args) {
		int input;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter input: " );
		input = Integer.parseInt(scan.nextLine());
		System.out.println(count(input));
	}

}
