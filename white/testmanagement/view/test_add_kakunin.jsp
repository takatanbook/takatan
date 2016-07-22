<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page import="jp.asojuku.testmanagement.dto.LogonInfoDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>検定管理システム</title>
<link href="http://localhost:8081/testmanagement/view/css/style.css" rel="stylesheet" type="text/css" />
<script src="http://localhost:8081/testmanagement/view/jQuery/jquery-1.11.3.min.js"></script>
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
<%
String id = "1";
LogonInfoDTO logon = new LogonInfoDTO();
logon.setId(id);
session.setAttribute("logininfo", logon);

String jisshi_year = (String)session.getAttribute("jisshi_year");
String jisshi_month = (String)session.getAttribute("jisshi_month");
String jisshi_day = (String)session.getAttribute("jisshi_day");
String jisshi = jisshi_year + "/" + jisshi_month + "/" + jisshi_day;
String sponsor = (String)session.getAttribute("sponsor");
String test_name = (String)session.getAttribute("test_name");
%>

<header><h1><a href="test_add">検定管理システム</a></h1></header>

<div class="main">

	<div class="info">
	<h2>検定情報追加</h2>
	<p>以下の検定情報を追加しますか？</p>
	<table class="list">
		<tr>
			<td class="testadd">実施日</td><td><%= jisshi %></td>
		</tr>
		<tr>
			<td class="testadd">主催</td><td><%= sponsor %></td>
		</tr>
		<tr>
			<td class="testadd">検定名</td><td><%= test_name %></td>
		</tr>
	</table>

	<table class="button">
		<tr>
			<td class="button">
				<button class="button1" onClick="history.back()">戻る</button>
			</td>
			<td class="button">
				<form action="testadd" method="POST">
				<button class="button1" type="submit">追加</button>
				</form>
			</td>
		</tr>
	</table>
	</div>

	<div class="side">
	<form action="<%=request.getContextPath() %>/logout"><button class="menu" type="submit">ログアウト</button></form>
	<form action="<%=request.getContextPath() %>/admintop"><button class="menu" type="submit">メニュートップ</button></form>

	<p><hr></p>

	<form action="<%=request.getContextPath() %>/admintestview" method="POST"><button class="menu" type="submit">検定情報トップ</button></form>
	<form action="<%=request.getContextPath() %>/testaddstart" method="GET"><button class="menu" type="submit">検定の追加</button></form>
	</div>

</div>

<footer>&copy; 2016 WhiteCo.</footer>

</body>
</html>