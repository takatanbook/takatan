<!DOCTYPE html>
<html lang="ja">
<head>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ page import="jp.asojuku.testmanagement.dto.TestInfoDto" %>
<%@ page import="jp.asojuku.testmanagement.dto.TestSeachResultDto" %>
<%@ page import="java.util.List" %>
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
<header>
<h1><a href="<%=request.getContextPath() %>/admintop">検定管理システム</a></h1>
</header>
<% 
TestSeachResultDto testseachresultdto = (TestSeachResultDto)request.getAttribute("testseachresult");
List<TestInfoDto> result = testseachresultdto.getTestlist();
int count = testseachresultdto.getSearchNum();
String keyword = testseachresultdto.getKeyword();
%>

<div class="main">
<div class="info">
	<form action="<%=request.getContextPath() %>/seachtestinfo" method="POST">
		<p>キーワード：<input type="text" name="keyword">
		<button class="button1" type="submit">再検索</button></p>
	</form>
	<h2>検索結果：　"<%= keyword %>"</h2>
	<table class="list">
		<tr>
			<th>実施日</th><th>主催</th><th>検定名</th><th>操作</th>
		</tr>
		<%if (count != 0){ %>
			<%for (TestInfoDto data:result){%>
		<tr>
			<td><%= data.getExaminationDate() %></td><td><%= data.getSponsor() %></td><td><%= data.getTestName() %></td>
			<td>
				<table class="button_method">
				<tr>
				<td class="button">
				<form action="" method="POST">
				<button class="button_student" type="submit" name="date" value="<%= data.getTestId() %>">更新</button>
				</form>
				</td>
				<td class="button">
				<form action="<%=request.getContextPath() %>/confirmationdeletetestinfo" method="POST">
				<button class="button_student" type="submit" name="date" value="<%= data.getTestId() %>">削除</button>
				</form>
				</td>
				</tr>
				</table>
			</td>
		</tr>
		
	<%} %>
	</table>
	</div>
	
	<div class="side">
	<form action="<%=request.getContextPath() %>/logout"><button class="menu" type="submit">ログアウト</button></form>
	<form action="<%=request.getContextPath() %>/admintop"><button class="menu" type="submit">メニュートップ</button></form>
	
	<p><hr></p>
	
	<form action="<%=request.getContextPath() %>/admintestview" method="POST"><button class="menu" type="submit">検定情報トップ</button></form>
	<form action="test_add.html" method="POST"><button class="menu" type="submit">検定の追加</button></form>
	</div>
	
</div>

	
	
<% }else{%>
<%} %>
</body>
</html>