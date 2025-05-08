package controller;

import java.util.Scanner;

public class DetailController {

	static Scanner sc = new Scanner(System.in);
	
	
	public void excute() {
		boolean isStop = false;
		while (!isStop) {
			menuDisplay();
			int job = sc.nextInt();
			switch (job) {
			case 1 -> {
				f_selectOne();
			}
			case 2 -> {
				f_update();
			}
			case 3 -> {
				f_delete();
			}
			case 99 -> {
				isStop = true;
			}
			}
			
		}
		System.out.println("=========Detail Controller End=========");
	}

	private void f_delete() {
		System.out.print("삭제할 글 id >");
		int id = sc.nextInt();
		
		
	}

	private void f_update() {
		System.out.println("업데이트할 글 id >");
		int id = sc.nextInt();
		
	}

	private void f_selectOne() {
		System.out.print("상세조회할 글 id >");
		int id = sc.nextInt();
		
	}
	
	
	
	private void menuDisplay() {
		System.out.println("-------------------------");
		System.out.println("1.글 상세조회 2.글 수정 3. 글 삭제");
		System.out.println("99.뒤로가기");
		System.out.println("-------------------------");
		System.out.print("작업선택>");
		
	}
}
