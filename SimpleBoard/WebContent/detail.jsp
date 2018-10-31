
<%@page import="java.util.List"%>
<%@page import="kr.co.hk.CommentVO"%>
<%@page import="javax.xml.stream.events.Comment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	List<CommentVO> commentList = (List<CommentVO>) request
			.getAttribute("commentList");
%>
<div class="template">
	<div class="tableBox">
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
				<th colspan="6">내용</th>
			</tr>
			<tr>
				<td colspan="6">${ vo.board_content}</td>
			</tr>

		</table>
		
		<input type="button" value="목록" onclick="list">
		<input type="button" value="수정">
		<input type="button" value="삭제" onclick="boarddelete(${ vo.board_no})" value="삭제">
		
		<script type="text/javascript">
		
		function boarddelete(board_no){
			if("${commentList.size()}" > 0){
				alert("댓글이 남아있습니다");
				return false;
			}
			location.href="delete?board_no="+ board_no;
			
		}
		
		</script>

		<div style="width: 70%; margin: 0 auto;">
			<div style="float: right; margin-top: 50px;">
				<form action="comment" method="post">
					<input type="hidden" name="board_no" value="${vo.board_no }">
					댓글
					<textarea name="comment_content"
						style="vertical-align: middle; height: 27px;"></textarea>
					<input type="submit" value="등록">
				</form>
			</div>
			<table>
			
			<caption>--- 댓글 ---</caption>

				<tr>
					<th>번호</th>
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
					<td><input type="button" onclick="location.href='commentDelete?board_no=${vo.board_no }&comment_no=<%=vo.getComment_no()%>'" value="삭제"></td>

				</tr>
				<%
					}
					}
				%>
			</table>
		</div>
	</div>
</div>