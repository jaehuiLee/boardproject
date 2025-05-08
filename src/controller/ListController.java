package controller;

import java.util.List;
import java.util.Scanner;

import common.Controller;
import model.Board;
import service.BoardService;

public class ListController implements Controller {

    private final BoardService boardService = new BoardService();

    @Override
    public void execute(Scanner sc) {
        List<Board> boardList = boardService.selectAll();

        if (boardList.isEmpty()) {
            System.out.println("게시글이 없습니다.");
        } else {
        	System.out.println("==============================================================");
        	System.out.println("ID   | 제목          | 작성자    | 작성일");
        	System.out.println("--------------------------------------------------------------");

        	for (Board board : boardList) {
        	    System.out.printf("%-4d | %-13s | %-9s | %s\n",
        	            board.getId(),
        	            board.getTitle(),
        	            board.getWriter(),
        	            board.getCreatedDate().toString().substring(0, 19));
        	}

        }
    }
}
