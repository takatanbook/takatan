<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
<title>検定管理システム</title>
<link href="<%=request.getContextPath() %>/view/css/style.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/view/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
$(function(){
    $('a,a img,button').css({
        opacity: 1.0,
        filter: "alpha(opacity=100)"
        }).hover(function(){
            $(this).fadeTo(200,0.6);
        },function(){
            $(this).fadeTo(200,1.0);
    })
});
</script>
</head>
<body>

<header><h1><a href="/testmanagement/examationlist">検定管理システム</a></h1></header>

<%@ page import="jp.asojuku.testmanagement.dto.ExamationInfoDto" %>
<%@ page import="javax.servlet.http.HttpSession"%>
<%
	HttpSession examationsession = request.getSession(false);
	ExamationInfoDto examationinfo = (ExamationInfoDto)examationsession.getAttribute("examationinfo");

	int id = Integer.parseInt(request.getParameter("delid"));



%>
<div class="main">

	<div class="info">
	<h2>受験検定削除</h2>
	<p>以下の受験情報を削除しますか？</p>
	<table class="list">
		<tr>
			<td class="testadd">実施日</td><td><%=examationinfo.getTestDay().get(id) %></td>
		</tr>
		<tr>
			<td class="testadd">主催</td><td><%=examationinfo.getSponsor().get(id) %></td>
		</tr>
		<tr>
			<td class="testadd">検定名</td><td><%=examationinfo.getTestName().get(id) %></td>
		</tr>
		<tr>
			<td class="testadd">合否</td><td><%if(examationinfo.getResult().get(id) == 0){ %>合格<%}else{ %>不合格<% } %></td>
		</tr>
	</table>
	<form action="<%=request.getContextPath() %>/examationdelete" method="POST">
	<p><button class="button1" name="examationid" value="<%=examationinfo.getExamationId().get(id) %>" type="submit">削除</button></p>
	</form>
	</div>

	<div class="side">
	<form action="<%=request.getContextPath() %>/logout"><button class="menu" type="submit">ログアウト</button></form>

	<p><hr></p>

	<form action="<%=request.getContextPath() %>/examationlist"><button class="menu" type="submit">受験検定一覧</button></form>
	<form action="<%=request.getContextPath() %>/view/examationadd1.jsp" method="POST"><button class="menu" type="submit">受験検定の追加</button></form>
	</div>

</div>

<footer>&copy; 2016 WhiteCo.</footer>

</body>
</html>