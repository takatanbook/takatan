<!DOCTYPE html>
<html lang="ja">
<head>
	<%@ page contentType="text/html; charset=utf-8" %>
	
	
</head>
<body>
<%
	String err = (String)request.getAttribute("errMsg");
%>
<%if (err != null ){%>
	<p><%= err %></p>
<%} %>
	<form action ="<%=request.getContextPath() %>/seachtestinfo" method="POST">
	キーワード<input type="text" name="keyword" > <br />
	<input type="submit" value="検索" />
	</form>
	<form action ="<%=request.getContextPath() %>/seachStudenttesthistory" method="POST">
	学生氏名:<input type="text" name="keyword" > <br />
	<input type="submit" value="検索" />
	</form>
</body>
</html>