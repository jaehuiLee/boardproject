package service;

import model.Board;
import model.BoardDAO;

public class BoardService {
	
	final BoardDAO boardDAO = new BoardDAO();
	
	public boolean createBoard(Board board) {
        return boardDAO.insert(board);
    }
}
