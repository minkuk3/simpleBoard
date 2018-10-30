<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript">
	//유효성 체크
	function chkSubmit() {
		var form = document.frm;
		//console.log(form);
		//alert(form.board_no.value);

		//alert(form.board_no.value.lentgth);

		if (form.board_no.value == "") {
			alert("게시글 없다")
			form.board_no.focus();
			return false;
		} else if (form.board_title.value == "") {
			alert("제목이 없습니다")
			form.board_title.focus();
			return false;
		} else if (form.board_title.value.length == 10) {
			alert("10자 이하로 입력하세요")
			form.board_title.focus();
			return false;
		} else if (form.board_content.value == "") {
			alert("게시글이 없습니다")
			form.board_content.focus();
			return false;
		} else if (form.regdate.value == "") {
			alert("게시글이 없습니다")
			form.regdate.focus();
			return false;
		}

		return true;
	}
</script>

<div class="template">
	<h2>글쓰기</h2>
	<div class="tableBox">
		<form action="write" name="frm" method="post"
			onsubmit="return chkSubmit()">
			<table>

				<colgroup>
					<col class="col1">
					<col class="col2">
				</colgroup>

				<tbody>
					<tr>
						<th>보드번호(자동발생)</th>
						<td><input type="text" name="board_no" value="${board_no }"></td>
					</tr>

					<tr>
						<th>제목</th>
						<td><input type="text" name="board_title"
							value="${board_title }"></td>
					</tr>

					<tr>
						<th>내용</th>
						<td><textarea name="board_content">내용1</textarea></td>
					</tr>

					<tr>
						<th>등록날짜</th>
						<td><input name="regdate" type="text" value="2018-10-29"></td>
					</tr>

					<tr>
						<th colspan="2"><input type="submit" value="등록"> 
						<input type="button" value="조회" onclick="location.href='list'"></th>
					</tr>
				</tbody>

			</table>
		</form>
	</div>
</div>