package kr.co.hk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("-- LriteServlet[get] start--");
		
		List<BoardVO> list = BoardDAO.getBoardList();
		
		request.setAttribute("list", list );
		Utils.dispatcher("리스트", "list", request, response);
		
		
	}
	
}
