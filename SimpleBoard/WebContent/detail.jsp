
<%@page import="java.util.List"%>
<%@page import="kr.co.hk.CommentVO"%>
<%@page import="javax.xml.stream.events.Comment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	List<CommentVO> commentList = (List<CommentVO>) request .getAttribute("commentList");
%>

<table>
	<tr>
		<th>번호</th>
		<td>${ vo.board_no}</td>

		<th>제목</th>
		<td>${ vo.board_title}</td>

		<th>조회수</th>
		<td>${ vo.regdate}${ vo.cnt }</td>
	<tr>
	<tr>
		<th>내용</th>
		<td>${ vo.board_content}</td>
	</tr>

</table>

<form action="comment" method="post">
	<input type="hidden" name="board_no" value="${vo.board_no }">
	댓글
	<textarea name="comment_content"></textarea>
	<input type="submit" value="등록">
</form>

<div>
	<table>


		<tr>
			<th>제목</th>
			<th>내용</th>
			<th>날짜</th>
			<th>삭제</th>
		</tr>
		<%
			if (commentList != null && commentList.size() > 0) {
				for (CommentVO vo : commentList) {
		%>
		<tr>

			<td><%=vo.getComment_no()%></td>
			<td><%=vo.getComment_content()%></td>
			<td><%=vo.getRegdate()%></td>

		</tr>
		<%
				}
			}
		%>
	</table>
</div>