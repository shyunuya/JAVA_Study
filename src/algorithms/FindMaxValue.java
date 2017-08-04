package practice;

/**
 * Created by Edward Hyunwoo Shin. 
 * Description: Finds Max value from random
 * values between 0~100 stores in an array.
 */

public class FindMaxValue {

	public static void main(String[] args) {
		int maxNum = -999;
		int[] arr = new int[20];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 101);
			System.out.println("arr[" + i + "] = " + arr[i]);
		}
		for (int a : arr) {
			if (a > maxNum)
				maxNum = a;
		}
		System.out.println("Maximum number is : " + maxNum);
	}
}
