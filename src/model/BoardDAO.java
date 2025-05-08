package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DBUtil;

public class BoardDAO {

    private static final String INSERT_SQL = "INSERT INTO board (id, title, content, writer, created_date) VALUES (board_seq.NEXTVAL, ?, ?, ?, SYSTIMESTAMP)";
    private static final String SELECT_ALL_SQL = "SELECT id, title, writer, created_date FROM board ORDER BY created_date DESC";
    private static final String SELECT_ONE_SQL = "SELECT id, title, content, writer, created_date FROM board WHERE id = ?";
    private static final String UPDATE_SQL = "UPDATE board SET title = ?, content = ? WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM board WHERE id = ?";

    /**
     * 게시글 생성
     */
    public boolean insert(Board board) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(INSERT_SQL);
            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());
            pstmt.setString(3, board.getWriter());

            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            System.err.println("[DB 오류] 게시글 작성 중 오류: " + e.getMessage());
        } finally {
            DBUtil.dbDisconnect(conn, pstmt, null);
        }
        return false;
    }

    /**
     * 전체 게시글 조회
     */
    public List<Board> selectAll() {
        List<Board> boardList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(SELECT_ALL_SQL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Board board = Board.builder()
                        .id(rs.getInt("id"))
                        .title(rs.getString("title"))
                        .writer(rs.getString("writer"))
                        .createdDate(rs.getTimestamp("created_date"))
                        .build();

                boardList.add(board);
            }

        } catch (SQLException e) {
            System.err.println("[DB 오류] 전체 게시글 조회 중 오류: " + e.getMessage());
        } finally {
            DBUtil.dbDisconnect(conn, pstmt, rs);
        }

        return boardList;
    }

    /**
     * 특정 게시글 조회
     */
    public Board selectOne(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(SELECT_ONE_SQL);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return Board.builder()
                        .id(rs.getInt("id"))
                        .title(rs.getString("title"))
                        .content(rs.getString("content"))
                        .writer(rs.getString("writer"))
                        .createdDate(rs.getTimestamp("created_date"))
                        .build();
            }

        } catch (SQLException e) {
            System.err.println("[DB 오류] 게시글 조회 중 오류: " + e.getMessage());
        } finally {
            DBUtil.dbDisconnect(conn, pstmt, rs);
        }

        return null;
    }

    /**
     * 게시글 수정
     */
    public boolean update(Board board) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(UPDATE_SQL);
            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());
            pstmt.setInt(3, board.getId());

            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            System.err.println("[DB 오류] 게시글 수정 중 오류: " + e.getMessage());
        } finally {
            DBUtil.dbDisconnect(conn, pstmt, null);
        }
        return false;
    }

    /**
     * 게시글 삭제
     */
    public boolean delete(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(DELETE_SQL);
            pstmt.setInt(1, id);

            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            System.err.println("[DB 오류] 게시글 삭제 중 오류: " + e.getMessage());
        } finally {
            DBUtil.dbDisconnect(conn, pstmt, null);
        }
        return false;
    }
}
