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

	HttpSession logonsession = request.getSession(false);
	HttpSession examationsession = request.getSession(false);

	ExamationInfoDto examationinfo = (ExamationInfoDto)examationsession.getAttribute("examationinfo");

	int size = examationinfo.getTestDay().size();


%>


<div class="main">
	<div class="info">
	<h2>受験検定情報</h2>
	<table class="list">
		<tr>
			<th>実施日</th><th>主催</th><th>検定名</th><th>合否</th><th>操作</th>
		</tr>
		<%for(int i = 0;i < size;i++){ %>
		<tr>
			<th><%=examationinfo.getTestDay().get(i) %></th><th><%=examationinfo.getSponsor().get(i) %></th><th><%=examationinfo.getTestName().get(i) %></th><th><%if(examationinfo.getResult().get(i) == 1){ %>合格<%}else{ %>不合格<%} %></th><th><form action="<%=request.getContextPath() %>/view/examationdel.jsp" method="POST"><button class="button_student" name="delid" value="<%=i %>" type="submit">削除</button></form></th>
		</tr>

		<%} %>
	</table>
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