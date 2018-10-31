package kr.co.hk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

	public static int getMaxBoardNo() {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			String sql = " SELECT " + " nvl(max(BOARD_NO),10000)+1 "
					+ " FROM S_BOARD ";

			con = DBConnector.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.Close(con, ps, rs);
		}
		return result;
	}

	public static int insertBoard(BoardVO vo) {

		int result = -1;

		Connection con = null;
		PreparedStatement ps = null;

		String sql = " insert into s_board "
				+ " (board_no, board_title, board_content, regdate, cnt) "
				+ " values " + " ( ? , ? , ? , ? , 0) ";

		try {

			con = DBConnector.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getBoard_no());
			ps.setString(2, vo.getBoard_title());
			ps.setString(3, vo.getBoard_content());
			ps.setString(4, vo.getRegdate());

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.Close(con, ps, null);
		}

		return result;

	}

	public static List<BoardVO> getBoardList() {
		List<BoardVO> list = new ArrayList<BoardVO>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		try {
			
			String sql = " select"
					+ " board_no, board_title"
					+ " , to_char(regdate, 'yyyy,mm,dd') as regdate "
					+ " , cnt "
					+ " from s_board order by board_no desc ";
			
			con = DBConnector.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
			
				BoardVO vo = new BoardVO();
				
				vo.setBoard_no(rs.getInt("board_no"));
				vo.setBoard_title(rs.getString("board_title"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setCnt(rs.getInt("cnt"));
				
				list.add(vo);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnector.Close(con, ps, rs);
		}

		return list;

	}
	
	public static BoardVO getBoardDetail(int board_no){
		
		BoardVO vo = new BoardVO();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			String sql = " SELECT "
					+ " Board_no, BOARD_TITLE, BOARD_CONTENT, to_char(REGDATE,'YYYY,MM,DD')as regdate, CNT "
					+ " FROM S_BOARD where board_no = ? ";
    
			
			con = DBConnector.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, board_no); //문제야~ 빼먹음
			rs = ps.executeQuery();
			
			while (rs.next()) {
			
				vo.setBoard_no(rs.getInt("board_no"));
				vo.setBoard_title(rs.getString("board_title"));
				vo.setBoard_content(rs.getString("board_content"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setCnt(rs.getInt("cnt"));
				
				// 끝인줄 몰랐다.. 문제야~ 리턴에 vo라서 끝남
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnector.Close(con, ps, rs);
		}
		
		return vo;
		
		
		
	}
	
	public static int boardUPdateCnt(int board_no){
		
		int result = -1;
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			String sql = " UPDATE S_BOARD "
					+ " set cnt = cnt + 1 "
					+ " where board_no = ? ";
			
			con = DBConnector.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, board_no);
			ps.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnector.Close(con, ps, null);
		}
		return result;
		
		
	}
	
	public static int insertComment(CommentVO vo){
		
		int result = -1;
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			String sql = " INSERT INTO s_comment "
					+ " (board_no, comment_no , comment_content, regdate) "
					+ " VALUES "
					+ " ( ? , (select(nvl(max(comment_no),0)+1) FROM s_comment where board_no = ? ) "
					+ ", ?, sysdate) ";

				
			con = DBConnector.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getBoard_no());
			ps.setInt(2, vo.getBoard_no());
			ps.setString(3, vo.getComment_content());
			
			ps.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnector.Close(con, ps, null);
		}
		
		
		return result;
		
	}
	
	public static List<CommentVO> getCommentList(int board_no){
		
		List<CommentVO> list = new ArrayList<CommentVO>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			String sql = " SELECT "
					+ " COMMENT_NO, COMMENT_CONTENT, to_char(REGDATE, 'YYYY,MM,DD')as regdate "
					+ " FROM S_COMMENT "
					+ " WHERE BOARD_NO = ? "
					+ " ORDER by COMMENT_NO DESC ";
					
			con = DBConnector.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, board_no);
			rs = ps.executeQuery();
			
			while(rs.next()){
				int comment_no = rs.getInt("comment_no");
				String comment_content = rs.getString("comment_content");
				String regdate = rs.getString("regdate");
				
				System.out.println( "comment_no " + comment_no);
				System.out.println( "comment_content " + comment_content);
				System.out.println( "regdate " +regdate);
				
				CommentVO vo = new CommentVO();
				vo.setComment_no(comment_no);
				vo.setComment_content(comment_content);
				vo.setRegdate(regdate);
				
				list.add(vo);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnector.Close(con, ps, rs);
		}
		
		return list;
		
		
	}
	
	public static void commentDelete(int board_no, int comment_no){
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			String sql = " DELETE FROM s_comment "
					+ " WHERE board_no = ? and comment_no = ? ";
			
			con = DBConnector.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, board_no);
			ps.setInt(2, comment_no);
			
			ps.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnector.Close(con, ps, null);
		}
		
	}
	
	public static void boardDelete(int board_no){
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			String sql = " DELETE FROM s_board "
					+ " WHERE board_no = ? " ;
			
			con = DBConnector.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, board_no);
			ps.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnector.Close(con, ps, null);
		}
		
		
	}

}
