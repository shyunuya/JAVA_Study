package bbs_Practice01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Edward Hyunwoo Shin.
 */
/**
 * Description: Updated version of bbs03.java. Used Java API (List and ArrayList).
 * Function : 1. Create 2. Read 3. Update 4. Delete 5. List 6. Exit 
 * Post Attribute : 1. No 2. title 3. Content
 * 
 */

public class Bbs04 {

	private Scanner sc;
	private List<String[]> bbsList;

	private int seq;

	public Bbs04() {
		this.sc = new Scanner(System.in);
		this.bbsList = new ArrayList<String[]>();
		this.seq = 1;
	}

	public void readme() {
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

	public void exit() {
		System.out.println("Program Terminated! Good bye~~~");
	}

	public String getUserInput() {
		return this.sc.nextLine();
	}

	public void create() {

		String no = String.valueOf(seq);

		System.out.println("Enter Title : ");
		String title = getUserInput();

		System.out.println("Enter Content : ");
		String content = getUserInput();

		String[] bbs = new String[3];
		bbs[0] = no;
		bbs[1] = title;
		bbs[2] = content;

		this.bbsList.add(bbs);
		this.seq++;

		System.out.println("Done!");
	}

	private String[] getSearch(String no) {
		for (String[] bbs : this.bbsList) {
			if (bbs != null && bbs[0].equals(no))
				return bbs;
		}
		return null;
	}

	public void read(String no) {
		if (no == null || no == "") {
			System.out.println("Wrong input");
			return;
		}
		String[] bbs = this.getSearch(no);

		if (bbs == null) {
			System.out.println("There is no post");
			return;
		}

		System.out.println("No : " + bbs[0]);
		System.out.println("Title : " + bbs[1]);
		System.out.println("Content : " + bbs[2]);
	}

	public void update(String no) {
		if (no == null || no == "") {
			System.out.println("Wrong Input");
			return;
		}
		String[] bbs = this.getSearch(no);

		if (bbs == null) {
			System.out.println("There is no post");
			return;
		}

		System.out.println("Title : ");
		String title = this.getUserInput();

		System.out.println("Content : ");
		String content = this.getUserInput();

		bbs[1] = title;
		bbs[2] = content;

		System.out.println("Successfully updated ");

	}

	public void delete(String no) {
		if (no == null || no == "") {
			System.out.println("Wrong Input");
			return;
		}

		String[] bbs = this.getSearch(no);

		if (bbs == null) {
			System.out.println("There is no post");
			return;
		}

		this.bbsList.remove(bbs);

		System.out.println("Successfully deleted");

	}

	public void getList() {
		for (String[] bbs : this.bbsList) {
			if (bbs != null) {
				System.out.println("No : " + bbs[0]);
				System.out.println("Title : " + bbs[1]);
				System.out.println("Content : " + bbs[2]);
			}
		}
	}

	public static void main(String[] args) {
		Bbs04 bbs = new Bbs04();

		while (true) {
			bbs.readme();

			String selection = bbs.getUserInput();

			if (selection.equals("1")) {
				bbs.create();
			} else if (selection.equals("2")) {
				System.out.println("Please Enter No. : ");
				bbs.read(bbs.getUserInput());
			} else if (selection.equals("3")) {
				System.out.println("Please Enter No. : ");
				bbs.update(bbs.getUserInput());
			} else if (selection.equals("4")) {
				System.out.println("Please Enter No. : ");
				bbs.delete(bbs.getUserInput());
			} else if (selection.equals("5")) {
				bbs.getList();
			} else if (selection.equals("6")) {
				bbs.exit();
				break;
			} else {
				System.out.println("Wrong option. Please choose number from list.");
			}

		}
	}
}
