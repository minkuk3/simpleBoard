<%@page import="kr.co.hk.BoardVO"%>
<%@page import="kr.co.hk.BoardDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");
%>

<script type="text/javascript">
	function clkTr(board_no) {

		var form = document.createElement("form");
		form.method = "POST";
		form.action = "detail";

		var element1 = document.createElement("input");
		element1.value = board_no;
		element1.name = "board_no";

		form.appendChild(element1);
		document.body.appendChild(form);
		form.submit();
	}
</script>

<div class="template">
	<h2>리스트</h2>

	<div class="tableBox">
		<table>

			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>

			<%
				if (list != null && list.size() > 0) {
					for (BoardVO vo : list) {
			%>
			<tr>
				<td><%=vo.getBoard_no()%></td>
				<td onclick="clkTr(<%=vo.getBoard_no()%>)"><%=vo.getBoard_title()%></td>
				<td><%=vo.getRegdate()%></td>
				<td><%=vo.getCnt()%></td>

			</tr>

			<%
				}
				}
			%>
		</table>
	</div>

</div>