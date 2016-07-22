<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
<title>検定管理システム</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/view/css/style.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/view/js/jquery-1.11.3.min.js"></script>
<script>
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
<%@ page contentType="text/html; charset=utf-8" %>
	
<%@ page import="jp.asojuku.testmanagement.dto.TestInfoDto" %>
<%@ page import="jp.asojuku.testmanagement.dto.TestSeachResultDto" %>
<%@ page import="java.util.List" %>
<title></title>
</head>

<body>
<%
TestSeachResultDto testseachresultdto = (TestSeachResultDto)request.getAttribute("testseachresult");
int conunt = testseachresultdto.getSearchNum();
List<TestInfoDto> list =testseachresultdto.getTestlist();
%>
<header><h1><a href="main_student.html">検定管理システム</a></h1></header>

<% if(conunt == 0){ %>
	
<% }else{%>

<div class="main">

	<div class="info">
	<h2>検定情報削除</h2>
	<p>以下の検定情報を削除しますか？</p>
	<%for(TestInfoDto data: list){ %>
	<table class="list">
		<tr>
			<td class="testadd">実施日</td><td><%= data.getTestName() %></td>
		</tr>
		<tr>
			<td class="testadd">主催</td><td><%= data.getSponsor() %></td>
		</tr>
		<tr>
			<td class="testadd">検定名</td><td><%= data.getExaminationDate() %></td>
		</tr>
		
	</table>
	
	<table class="button">
		<tr>
			<td class="button">
				<button class="button1" onClick="history.back()">戻る</button>
			</td>
			<td class="button">
				<form action="<%=request.getContextPath() %>/deletetestinfo" method="POST">
				<button class="button1" type="submit" value="<%= data.getTestId()%>" name="date">削除</button>
				</form>
			</td>
		</tr>
	</table>
	</div>
	<%} %>
<% } %>
	
	<div class="side">
	<form action="<%=request.getContextPath() %>/logout"><button class="menu" type="submit">ログアウト</button></form>
	<form action="<%=request.getContextPath() %>/admintop"><button class="menu" type="submit">メニュートップ</button></form>
	
	<p><hr></p>
	
	<form action="<%=request.getContextPath() %>/admintestview" method="POST"><button class="menu" type="submit">検定情報トップ</button></form>
	<form action="test_add.html" method="POST"><button class="menu" type="submit">検定の追加</button></form>
	</div>
	
</div>
</body>
</html>