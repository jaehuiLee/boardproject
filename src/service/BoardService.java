package service;

import java.util.List;

import model.Board;
import model.BoardDAO;

public class BoardService {
  private final BoardDAO boardDAO = new BoardDAO();
	
	public Board selectOne(int id) {
		return boardDAO.selectOne(id);
	}
	 
	public boolean update(Board board) {
		return boardDAO.update(board);
	}
	 
	public boolean delete(int id) {
		return boardDAO.delete(id);
	}
	
	public boolean createBoard(Board board) {
    return boardDAO.insert(board);
  }
  
	public List<Board> selectAll() {
		return boardDAO.selectAll();
	}
}
