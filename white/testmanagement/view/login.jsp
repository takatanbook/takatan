
<!DOCTYPE html>
<html>
<head>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
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
<% String err = (String)request.getAttribute("errMsg");%>
<header><h1>検定管理システム</h1></header>

<div class="main">

	<div class="login">
	<h2>ログイン</h2>
	<% if(err != null){%><%=err %><%} %>
	<form action="<%=request.getContextPath() %>/auth" method="POST">
	<p>ユーザー名（メールアドレス）<br /><input type="text" name="username" size="30" style="font-family:Tahoma"></p>
	<p>パスワード<br /><input type="password" name="password" size="30" style="font-family:Tahoma"></p>
	<button class="button1" type="submit">ログイン</button>
	</form>
	</div>

</div>

<footer>&copy; 2016 WhiteCo.</footer>

</body>
</html>