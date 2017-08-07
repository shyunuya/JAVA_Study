package practice;

/**
 * Created by Edward Hyunwoo Shin. 
 * Description: Rank the random array values.
 * 
 */

public class RankingArray {

	public static void main(String[] args) {

		int[] arr = new int[10];
		int[] rank = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		
		// Inserting random values in array.
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 101);
			System.out.println("arr[" + i + "] = " + arr[i]);
		}
		// Rank array values. 1 - highest, 10 - lowest
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					rank[i] += 1;
				}
			}
			System.out.println("arr[" + i +"] = "+ arr[i] + " rank : " + rank[i]);
		}
	}
}
