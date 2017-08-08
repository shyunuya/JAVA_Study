package lotto_number;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LottoNum {
	public static void main(String[] args) throws FileNotFoundException {
		Readfile readIn = new Readfile();
		HashMap<Integer, Integer> map = readIn.getReadFile();
		HashMap<Integer, Float> percentMap = new HashMap<>();
		HashMap<Float, ArrayList<Integer>> swapMap = new HashMap<>();
		float[] percent = new float[45];

		int count = 0;
		Iterator<Integer> key = map.keySet().iterator();
		while (key.hasNext()) {
			Integer keys = key.next();
			percent[count] = (float) (map.get(keys)) / 48 * 100;
			percentMap.put(keys, percent[count]);
			count++;
		}

		Iterator<Integer> swap = percentMap.keySet().iterator();
		int count2 = 0;
		int count3 = 0;
		while (swap.hasNext()) {
			Integer tempInt = swap.next();
			swapMap.put(percentMap.get(tempInt), null);
		}

		for (Float entry : swapMap.keySet()) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			Float floatValue = entry;
			for (Entry<Integer, Float> entry2 : percentMap.entrySet()) {
				if (floatValue.equals(entry2.getValue())) {
					list.add(entry2.getKey());
				}
			}
			swapMap.put(floatValue, list);

		}

		for (Entry<Float, ArrayList<Integer>> entry : swapMap.entrySet()) {
			System.out.println("key : " + entry.getKey() + "         value : " + entry.getValue());
		}
		
		GenNum(swapMap);
		
		// Iterator<Integer> sort = sortByValue(swapMap).iterator();
		// while(sort.hasNext()){
		// Integer floatValue = sort.next();
		//
		// }
		// Iterator<Float> sort = sortByValue(swapMap).iterator();
		// int count2 = 0;
		// while (sort.hasNext()) {
		// count2++;
		// Integer keys = sort.next();
		// System.out.println("keys : " + keys + " values : " +
		// percentMap.get(keys));
		//
		// }

	}

	// public static List<Float> sortByValue(final HashMap<Float,
	// ArrayList<Integer>> swapMap) {
	// List<Float> list = new ArrayList<Float>();
	// list.addAll(swapMap.keySet());
	//
	// Collections.sort(list, new Comparator<Object>() {
	// @SuppressWarnings({ "unchecked", "rawtypes" })
	// public int compare(Object o1, Object o2) {
	// Object v1 = swapMap.get(o1);
	// Object v2 = swapMap.get(o2);
	//
	// return ((Comparable) v2).compareTo(v1);
	//
	// }
	// });
	//
	// return list;
	// }

	public static void GenNum(HashMap<Float, ArrayList<Integer>> swapMap) {
		int first1 = 0;
		int second2 = 0;
		int third3 = 0;
		int fourth4 = 0;
		int fifth5 = 0;
		int sixth6 = 0;

		int[] moneyBall = new int[6];

	
		for (Entry<Float, ArrayList<Integer>> entry : swapMap.entrySet()) {
			System.out.println(entry.getKey().hashCode());
		}

	}
}
