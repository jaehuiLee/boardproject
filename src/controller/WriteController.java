package controller;

import java.util.Scanner;

import common.Controller;
import model.Board;
import service.BoardService;

public class WriteController implements Controller {

    private BoardService boardService;

    public WriteController() {
        this.boardService = new BoardService();
    }

    @Override
    public void execute(Scanner sc) {
        System.out.println("\n[글 작성]");

        System.out.print("제목: ");
        String title = sc.nextLine();

        System.out.print("내용: ");
        String content = sc.nextLine();

        System.out.print("작성자: ");
        String writer = sc.nextLine();

        Board board = Board.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();

        boolean isSuccess = boardService.createBoard(board);

        if (isSuccess) {
            System.out.println("글이 성공적으로 작성되었습니다!");
        } else {
            System.out.println("글 작성에 실패했습니다!");
        }
    }
}
