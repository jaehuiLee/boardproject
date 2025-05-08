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
            System.out.println("==========================================================================================");
            System.out.printf("%-5s | %-20s | %-10s | %-19s | %-30s\n",
                    "ID", "제목", "작성자", "작성일", "내용");
            System.out.println("------------------------------------------------------------------------------------------");

            for (Board board : boardList) {
                System.out.printf("%-5d | %-20s | %-10s | %-19s | %-30s\n",
                        board.getId(),
                        truncate(board.getTitle(), 20),
                        board.getWriter(),
                        board.getCreatedDate().toString().substring(0, 19),
                        summarize(board.getContent()));
            }

            System.out.println("------------------------------------------------------------------------------------------");
            System.out.printf("총 %d건의 게시글이 있습니다.\n", boardList.size());
        }
    }

    // 긴 내용은 앞부분만 출력 (30자 제한)
    private String summarize(String content) {
        if (content == null) return "(내용 없음)";
        return content.length() > 30 ? content.substring(0, 30) + "..." : content;
    }

    // 제목도 너무 길면 자르기
    private String truncate(String str, int maxLength) {
        if (str == null) return "";
        return str.length() > maxLength ? str.substring(0, maxLength - 1) + "…" : str;
    }
}
