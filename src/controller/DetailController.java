package controller;

import java.util.Scanner;
import common.Controller;

public class DetailController implements Controller {

	@Override
	public void execute(Scanner sc) {

		boolean isStop = false;
		while (!isStop) {
			menuDisplay();
			int job = sc.nextInt();
			switch (job) {
			case 1 -> {
				f_selectOne(sc);
			}
			case 2 -> {
				f_update(sc);
			}
			case 3 -> {
				f_delete(sc);
			}
			case 99 -> {
				isStop = true;
			}
			}
			
		}
		System.out.println("=========Detail Controller End=========");
	}

	private void f_delete(Scanner sc) {
		System.out.print("삭제할 글 id >");
		int id = sc.nextInt();
		
		
	}

	private void f_update(Scanner sc) {
		System.out.println("업데이트할 글 id >");
		int id = sc.nextInt();
		
	}

	private void f_selectOne(Scanner sc) {
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
