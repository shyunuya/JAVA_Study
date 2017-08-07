package practice;

import java.util.Scanner;

/**
 * Created by Edward Hyunwoo Shin. Problem: Given an array size as an input by user
 * and create an array with random numbers. Then find sum and average. Put end
 * of array indicator by -1.
 */
public class SumAndAvg {

	public static void main(String[] args) {
		int userInput = 0;
		int count = 0;
		int sum = 0;
		double avg = 0d;

		System.out.print("Please Enter Array Size : ");
		Scanner scanner = new Scanner(System.in);

		userInput = Integer.parseInt(scanner.nextLine());

		int[] arr = new int[userInput + 1];
		arr[arr.length - 1] = -1; // indicates end of the array.
		for (int i = 0; i < arr.length - 1; i++) {
			arr[i] = (int) (Math.random() * 100 + 1);
			System.out.println("arr[" + i + "] = " + arr[i]);
		}
		System.out.println("arr[" + userInput + "] = " + arr[arr.length - 1]);

		while (arr[count] != -1) {
			sum += arr[count];
			count++;
		}
		System.out.println("Count = " + count);
		System.out.println("Sum of all array elements is : " + sum);
		avg = Math.round((double) sum / count * 100) / 100.0;
		System.out.println("Avg of array elements is : " + avg);
	}
}
