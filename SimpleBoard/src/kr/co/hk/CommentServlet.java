package kr.co.hk;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/comment")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String comment_content = request.getParameter("comment_content");
		String board_no = request.getParameter("board_no");
		
		int board_no2 = Integer.parseInt(board_no);
		
		System.out.println( "comment_content : " +comment_content );
		System.out.println( " board_no : " + board_no);
		
		CommentVO vo = new CommentVO();
		vo.setComment_content(comment_content);
		vo.setBoard_no(board_no2);
		

		int intBoardNo = BoardDAO.insertComment(vo);
		
		response.sendRedirect("detail?board_no="+ board_no);
		
		
		
				
	}

}
