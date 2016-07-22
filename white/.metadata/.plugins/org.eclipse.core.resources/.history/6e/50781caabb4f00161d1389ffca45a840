<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
<title>検定管理システム</title>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
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

<header><h1><a href="main_admin.html">検定管理システム</a></h1></header>
<% String err = (String)request.getAttribute("errMsg");%>
<% String Studenterr = (String)request.getAttribute("StudentMsg");%>

<div class="main">

	<div class="info">
	<h2>検定キーワードで検索</h3>
	
	<form action="<%=request.getContextPath() %>/seachtestinfo" method="POST">
	<%if(err != null) {%><%= err %><% }%><br />
	<input type="text" name="keyword"><br>
	<button class="button1" type="submit">検索</button>
	</form>
	
	<h2>受験学生氏名で検索</h2>
	
	<form action ="<%=request.getContextPath() %>/seachStudenttesthistory" method="POST">
	<%if(Studenterr != null) {%><%= Studenterr %><% }%><br />
	<input type="text" name="keyword"><br>
	<button class="button1" type="submit">検索</button>
	</form>
	</div>
	
	<div class="side">
	<form action="<%=request.getContextPath() %>/logout"><button class="menu" type="submit">ログアウト</button></form>
	<form action="<%=request.getContextPath() %>/admintop"><button class="menu" type="submit">メニュートップ</button></form>
	
	<p><hr></p>
	
	<form action="<%=request.getContextPath() %>/admintestview" method="POST"><button class="menu" type="submit">検定情報トップ</button></form>
	<form action="test_add.html" method="POST"><button class="menu" type="submit">検定の追加</button></form>
	</div>
	
</div>

<footer>&copy; 2016 WhiteCo.</footer>

</body>
</html>