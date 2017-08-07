package bbs_Practice01;

import java.util.Scanner;

/**
 * Created by Edward Hyunwoo Shin.
 */
/**
 * Description: Simple Java BBS. Can be stored up to 10 posts. 
 * Function : 1. Create 2. Read 3. Update 4. Delete 5. List 6. Exit 
 * Post Attribute : 1. No 2. title 3. Content
 */
public class Bbs01 {

	public static void main(String[] args) {
		System.out.println("Wecome to the Edward's Simple BBS!!");
		Scanner sc = new Scanner(System.in);

		String[][] bbsNum = new String[10][];
		int seq = 1;
		int idx = 0;

		while (true) {
			System.out.println("***********OPTION************");
			System.out.println("1. Create");
			System.out.println("2. Read");
			System.out.println("3. Update");
			System.out.println("4. Delete");
			System.out.println("5. List");
			System.out.println("6. Exit");
			System.out.println("******************************");

			int selection = Integer.parseInt(sc.nextLine());

			if (selection == 1) {
				if (idx == bbsNum.length) {
					System.out.println("Reached Max number of posts.\n Please delete first and then create again");
					continue;
				}
				String no = String.valueOf(seq);
				System.out.println("Enter Title : ");
				String title = sc.nextLine();

				System.out.println("Enter Content : ");
				String content = sc.nextLine();

				String[] bbs = new String[3];
				bbs[0] = no;
				bbs[1] = title;
				bbs[2] = content;

				bbsNum[idx++] = bbs;
				seq++;

				System.out.println("Done!");
			} else if (selection == 2) {
				System.out.println("Enter Post number : ");
				String no = sc.nextLine();

				boolean flag = false;

				for (String[] bbs : bbsNum) {
					if (bbs != null && bbs[0].equals(no)) {
						System.out.println("No : " + bbs[0]);
						System.out.println("Title : " + bbs[1]);
						System.out.println("Content : " + bbs[2]);
						flag = true;
						break;
					}
				}
				if (!flag) {
					System.out.println("Empty!");
				}
			} else if (selection == 3) {
				System.out.println("Enter Post number : ");
				String no = sc.nextLine();

				boolean flag = false;

				for (String[] bbs : bbsNum) {
					if (bbs != null && bbs[0].equals(no)) {
						System.out.println("Enter Title : ");
						String title = sc.nextLine();

						System.out.println("Enter Content : ");
						String content = sc.nextLine();

						bbs[1] = title;
						bbs[2] = content;

						flag = true;
						break;
					}
				}
				if (!flag) {
					System.out.println("Done!");
				} else {
					System.out.println("Empty!");
				}
			} else if (selection == 4) {
				System.out.println("Enter Post number : ");
				String no = sc.nextLine();

				int index = -1;
				boolean flag = false;

				if (idx == 0) {
					System.out.println("There is no post");
					continue;
				}

				for (int i = 0; i < bbsNum.length; i++) {
					String[] bbs = bbsNum[i];

					if (bbs != null && bbs[0].equals(no)) {
						bbsNum[i] = null;
						index = i;
						idx--;
						flag = true;
						break;
					}
				}

				if (flag) {
					int length = bbsNum.length;
					for (int i = 0; i < length; i++) {
						if (index == 0) {
							break;
						}
						if (index == length - 1) {
							break;
						}

						if (i > index) {
							if (i < length) {
								bbsNum[i - 1] = bbsNum[i];
								bbsNum[i] = null;
							}
						}
					}

					System.out.println("Done!");
				} else {
					System.out.println("Empty!");
				}

			} else if (selection == 5) {
				for (int i = 0; i < bbsNum.length; i++) {
					if (bbsNum[i] == null)
						continue;

					System.out.println("index : " + i);
					System.out.println("No : " + bbsNum[i][0]);
					System.out.println("Title : " + bbsNum[i][1]);
					System.out.println("Content : " + bbsNum[i][2]);

				}
			} else if (selection == 6) {
				System.out.println("Program terminated");
				break;
			} else {
				System.out.println("Wrong option. Please choose number from list.");
			}
		}

	}

}
