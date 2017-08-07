package practice;

import java.util.Scanner;
/**
 * Created by Edward Hyunwoo Shin. 
 * Description:  Given user input, find factorial value using recursion
 * 
 */
public class Factorial {

	public static void main(String[] args) {
		int input = 0;
		Scanner scan = new Scanner(System.in);
		
		input = Integer.parseInt(scan.nextLine());

		System.out.println(CalcFactorial(input));
	}

	public static int CalcFactorial(int input) {

		if (input == 1) {
			return input;
		} else {
			return CalcFactorial(input - 1) * input;
		}
	}
}
