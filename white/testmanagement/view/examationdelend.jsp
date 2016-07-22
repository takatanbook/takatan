<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
<title>検定管理システム</title>
<link href="view/css/style.css" rel="stylesheet" type="text/css" />
<script src="view/js/jquery-1.11.3.min.js"></script>
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

<div class="main">

	<div class="info">
	<h2>受験検定削除</h2>
	<p>受験検定の削除が完了しました。</p>
	<table class="button">
		<tr>
			<td class="button">
				<form action="<%=request.getContextPath() %>/examationlist" method="GET">
				<button class="button1" type="submit">受験検定一覧へ</button>
				</form>
			</td>
		</tr>
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