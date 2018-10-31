package kr.co.hk;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/commentDelete")
public class commentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		System.out.println("board_no: " +board_no);
		int comment_no = Integer.parseInt(request.getParameter("comment_no"));
		System.out.println("comment_no : " + comment_no);
		
		BoardDAO.commentDelete(board_no, comment_no);
		
		//RequestDispatcher 리케스트 값 담아서 보낼때 새롭게  
		//response 바로 넘어가는거
		
		response.sendRedirect("detail?board_no="+board_no);
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
