package service;

import java.util.List;

import model.Board;
import model.BoardDAO;

public class BoardService {
	
	final BoardDAO boardDAO = new BoardDAO();
	
	public boolean createBoard(Board board) {
        return boardDAO.insert(board);
    }
	
	public List<Board> selectAll() {
		return boardDAO.selectAll();
	}
}
