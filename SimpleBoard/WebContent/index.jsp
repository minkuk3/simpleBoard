<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title }</title>
<link rel="stylesheet" href="css/common.css" type="text/css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container">
		<jsp:include page="nav.jsp" />
		<jsp:include page="${target}.jsp"></jsp:include>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>