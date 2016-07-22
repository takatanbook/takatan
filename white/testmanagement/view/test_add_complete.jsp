<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
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

<header><h1><a href="main_admin.html">検定管理システム</a></h1></header>

<div class="main">

	<div class="info">
	<h2>検定情報追加</h2>
	<p>検定情報の追加が完了しました。</p>
	<table class="button">
		<tr>
			<td class="button">
				<form action="main_admin.html" method="POST">
				<button class="button1" type="submit">メニュートップへ</button>
				</form>
			</td>
			<td class="button">
				<form action="test_list.html" method="POST">
				<button class="button1" type="submit">検定情報トップへ</button>
				</form>
			</td>
			<td class="button">
				<form action="student_list.html" method="POST">
				<button class="button1" type="submit">学生情報トップへ</button>
				</form>
			</td>
		</tr>
	</table>
	</div>

	<div class="side">
	<form action="<%=request.getContextPath() %>/logout"><button class="menu" type="submit">ログアウト</button></form>
	<form action="<%=request.getContextPath() %>/admintop"><button class="menu" type="submit">メニュートップ</button></form>

	<p><hr></p>

	<form action="test_list.html" method="POST"><button class="menu" type="submit">検定情報トップ</button></form>
	<form action="test_add.html" method="POST"><button class="menu" type="submit">検定の追加</button></form>
	</div>

</div>

<footer>&copy; 2016 WhiteCo.</footer>

</body>
</html>