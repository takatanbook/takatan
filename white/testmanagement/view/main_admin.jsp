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

<header>
	<h1><a href="<%=request.getContextPath() %>/admintop">検定管理システム</a></h1>
</header>

<div class="main">

	<div class="info">
	<h2>管理者メニュー</h2>
	<p><a href="<%=request.getContextPath() %>/admintestview">→検定情報</a></p>
	<p><a href="student_list.html">→学生情報</a></p>
	</div>
	
	<div class="side">
	<form action="<%=request.getContextPath() %>/logout"><button class="menu" type="submit">ログアウト</button></form>
	<form action="<%=request.getContextPath() %>/admintop" method="POST"><button class="menu" type="submit">メニュートップ</button></form>
	</div>

</div>

<footer>&copy; 2016 WhiteCo.</footer>

</body>
</html>