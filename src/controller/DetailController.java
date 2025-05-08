package controller;

import java.util.Scanner;
import common.Controller;
import model.Board;
import service.BoardService;

public class DetailController implements Controller {
	BoardService boardService = new BoardService();

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
				sc.nextLine();
			}
			}

		}
		System.out.println("=========Detail Controller End=========");
	}

	private void f_delete(Scanner sc) {
		System.out.print("삭제할 글 id >");
		int id = sc.nextInt();
		sc.nextLine(); // 개행 제거

		boolean success = boardService.delete(id);

		if (success) {
			System.out.println("게시글이 성공적으로 삭제되었습니다.");
		} else {
			System.out.println("삭제 실패: 해당 ID의 게시글이 존재하지 않거나 오류가 발생했습니다.");
		}
	}

	private void f_update(Scanner sc) {
		System.out.println("업데이트할 글 id >");
		int id = sc.nextInt();
		sc.nextLine(); // 개행 제거

	    // 기존 게시글 불러오기
	    Board board = boardService.selectOne(id);

	    if (board == null) {
	        System.out.println("수정 실패: 해당 ID의 게시글이 존재하지 않습니다.");
	        return;
	    }

	    // 사용자로부터 새 제목/내용 입력받기
	    System.out.println("기존 제목 : " + board.getTitle());
	    System.out.print("새 제목 입력 > ");
	    String newTitle = sc.nextLine();
	    
	    System.out.println("기존 내용 : " + board.getContent());
	    System.out.print("새 내용 입력 > ");
	    String newContent = sc.nextLine();

	    // Board 객체 수정
	    board.setTitle(newTitle);
	    board.setContent(newContent);

	    boolean success = boardService.update(board);

	    if (success) {
	        System.out.println("게시글이 성공적으로 수정되었습니다.");
	    } else {
	        System.out.println("수정 실패: 데이터베이스 오류가 발생했습니다.");
	    }

	}

	private void f_selectOne(Scanner sc) {
		System.out.print("상세조회할 글 id >");
		int id = sc.nextInt();
		sc.nextLine();
		Board board = boardService.selectOne(id);
		if (board != null) {
			System.out.println("\n==== 게시글 상세 정보 ====");
			System.out.println("ID	: " + board.getId());
			System.out.println("제목	: " + board.getTitle());
			System.out.println("내용	: " + board.getContent());
			System.out.println("작성자	: " + board.getWriter());
			System.out.println("작성일자	: " + board.getCreatedDate());
			System.out.println("==========================\n");
		} else {
			System.out.println("해당 ID의 게시글이 존재하지 않습니다.");
		}

	}

	private void menuDisplay() {
		System.out.println("-------------------------");
		System.out.println("1.글 상세조회 2.글 수정 3. 글 삭제");
		System.out.println("99.뒤로가기");
		System.out.println("-------------------------");
		System.out.print("작업선택>");

	}

}
