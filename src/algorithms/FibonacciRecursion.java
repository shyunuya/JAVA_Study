package practice;

import java.util.Scanner;
/**
 * Created by Edward Hyunwoo Shin.
 */
/**
 * Problem: User enters input for position of fibonacci  to obtain a value of that position.
 */
public class FibonacciRecursion {

	public static int fibo(int num) {

		if (num < 2) {
			return num;
		} else {
			return fibo(num - 2) + fibo(num - 1);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = 0;
		System.out.println("Enter the Nth place : ");
		num = Integer.parseInt(scan.nextLine());
		System.out.println(fibo(num));

	}
}
