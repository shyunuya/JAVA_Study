package practice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Readfile {
	public Readfile() {
		
	}
	
	private String[] lineArr = null;
	private BufferedReader readIn = null;

	public HashMap<Integer, Integer> getReadFile() throws FileNotFoundException {
		HashMap<Integer, Integer> map = new HashMap<>();
		String line = null;
		StringBuffer tempQuery = new StringBuffer();
		String tempStringQuery = null;
		try {
			this.readIn = new BufferedReader(new FileReader("C:\\Desktop\\lotto_stat.txt"));
			while ((line = readIn.readLine()) != null) {
				tempQuery.append(line.trim() + ' ');
			}
			tempStringQuery = tempQuery.toString();
			lineArr = tempStringQuery.split(" ");
			int tempInt = 0;
			int[] arrInt = new int[2];
			for (String a : lineArr) {
				String[] tempString = a.split(",");
				for (int i = 0; i < tempString.length; i++) {
					tempInt = Integer.parseInt(tempString[i]);
					arrInt[i] = tempInt;
				}
				map.put(arrInt[0], arrInt[1]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
}
