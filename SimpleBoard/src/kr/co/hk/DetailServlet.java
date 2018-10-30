package kr.co.hk;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.impl.javax.rmi.CORBA.Util;


@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		BoardVO vo = BoardDAO.getBoardDetail(board_no); //문제야~
		
		request.setAttribute("vo", vo);  // 문제야~
						
		//CommentVO 
		List<CommentVO> commentList = BoardDAO.getCommentList(board_no);
		request.setAttribute("commentList", commentList);	
		
						//title이고  .jsp
		Utils.dispatcher("디테일", "detail", request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		BoardDAO.boardUPdateCnt(board_no);
		
		response.sendRedirect("detail?board_no=" + board_no);
		
		
		
	}

}
