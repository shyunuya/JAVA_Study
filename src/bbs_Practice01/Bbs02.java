package bbs_Practice01;

import java.util.Scanner;

/**
 * Created by Edward Hyunwoo Shin.
 */
/**
 * Description: Updated version of bbs01.java. Separated codes from main by its function.
 * Function : 1. Create 2. Read 3. Update 4. Delete 5. List 6. Exit 
 * Post Attribute : 1. No 2. title 3. Content
 * 
 */

public class Bbs02 {

	private static Scanner sc = new Scanner(System.in);
	private static String[][] bbsNum = new String[10][];
	private static int seq = 1;
	private static int idx = 0;

	public static void readme() {
		System.out.println("Wecome to the Edward's Simple BBS!!");
		System.out.println("");
		System.out.println("***********OPTION************");
		System.out.println("1. Create");
		System.out.println("2. Read");
		System.out.println("3. Update");
		System.out.println("4. Delete");
		System.out.println("5. List");
		System.out.println("6. Exit");
		System.out.println("******************************");
	}

	public static void exit() {
		System.out.println("Program Terminated! Good bye~~~");
	}

	public static String getUserInput() {
		return sc.nextLine();
	}

	public static void create() {
		if (idx == bbsNum.length) {
			System.out.println("Reached Max number of posts.\n Please delete first and then create again");
			return;
		}

		String no = String.valueOf(seq);

		System.out.println("Enter Title : ");
		String title = getUserInput();

		System.out.println("Enter Content : ");
		String content = getUserInput();

		String[] bbs = new String[3];
		bbs[0] = no;
		bbs[1] = title;
		bbs[2] = content;

		bbsNum[idx++] = bbs;
		seq++;

		System.out.println("Done!");

	}

	private static String[] getSearch(String no) {
		for (String[] bbs : bbsNum) {
			if (bbs != null && bbs[0].equals(no))
				return bbs;
		}
		return null;
	}

	private static int getIndex(String no) {
		for (int i = 0; i < bbsNum.length; i++) {
			String[] bbs = bbsNum[i];

			if (bbs != null && bbs[0].equals(no)) {
				return i;
			}
		}
		return -1;
	}

	public static void read(String no) {
		if (no == null || no == "") {
			System.out.println("Wrong input");
			return;
		}
		String[] bbs = getSearch(no);
		if (bbs == null) {
			System.out.println("There is no post");
			return;
		}

		System.out.println("No : " + bbs[0]);
		System.out.println("Title : " + bbs[1]);
		System.out.println("Content : " + bbs[2]);
	}

	public static void update(String no) {
		if (no == null || no == "") {
			System.out.println("Wrong Input");
			return;
		}
		String[] bbs = getSearch(no);

		if (bbs == null) {
			System.out.println("There is no post");
			return;
		}

		System.out.println("Title : ");
		String title = sc.nextLine();

		System.out.println("Content : ");
		String content = sc.nextLine();

		bbs[1] = title;
		bbs[2] = content;

		System.out.println("Successfully updated ");

	}

	public static void delete(String no) {
		if (no == null || no == "") {
			System.out.println("Wrong Input");
			return;
		}

		int index = getIndex(no);

		if (index == -1) {
			System.out.println("There is no post");
			return;
		}

		bbsNum[index] = null;
		idx--;

		for (int i = 0; i < bbsNum.length; i++) {
			if (index == 0) {
				break;
			}

			if (index == bbsNum.length - 1) {
				break;
			}

			if (i > index) {
				if (i < bbsNum.length) {
					bbsNum[i - 1] = bbsNum[i];
					bbsNum[i] = null;
				}
			}
		}
		System.out.println("Successfully deleted");

	}

	public static void getList() {
		for (int i = 0; i < bbsNum.length; i++) {
			if (bbsNum[i] == null)
				continue;

			System.out.println("Index : " + i);
			System.out.println("No : " + bbsNum[i][0]);
			System.out.println("Title : " + bbsNum[i][1]);
			System.out.println("Content : " + bbsNum[i][2]);

		}
	}

	public static void main(String[] args) {
		while(true){
			readme();
			
			String selection = getUserInput();
			
			if (selection.equals("1")){
				create();
			} else if (selection.equals("2")){
				System.out.println("Please Enter No. : ");
				read(getUserInput());
			} else if (selection.equals("3")) {
				System.out.println("Please Enter No. : ");
				update(getUserInput());
			} else if (selection.equals("4")){
				System.out.println("Please Enter No. : ");
				delete(getUserInput());
			} else if (selection.equals("5")) {
				getList();
			} else if (selection.equals("6")) {
				exit();
				break;
			} else {
				System.out.println("Wrong option. Please choose number from list.");
			}
			
		}
	}

}
