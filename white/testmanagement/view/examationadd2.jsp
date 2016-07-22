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

	HttpSession examationsearchsession = request.getSession(false);

	ExamationInfoDto examationinfo = (ExamationInfoDto)examationsearchsession.getAttribute("examationinfo");

	int size = examationinfo.getTestName().size();


%>

<div class="main">

	<div class="info">
	<h2>受験検定追加</h2>
	<p>受験した検定を検索してください。</p>

	<form action="<%=request.getContextPath() %>/examationaddsearch" method="POST">
		<select name="jisshi_nen" class="drop">
		<optgroup label="実施年">
		<option value="2016">2016年</option>
		<option value="2015">2015年</option>
		<option value="2014">2014年</option>
		<option value="2013">2013年</option>
		<option value="2012">2012年</option>
		<option value="2011">2011年</option>
		<option value="2010">2010年</option>
		</optgroup>
		</select><br>

		<select name="jisshi_tsuki" class="drop">
		<optgroup label="実施月">
		<option value="1">1月</option>
		<option value="2">2月</option>
		<option value="3">3月</option>
		<option value="4">4月</option>
		<option value="5">5月</option>
		<option value="6">6月</option>
		<option value="7">7月</option>
		<option value="8">8月</option>
		<option value="9">9月</option>
		<option value="10">10月</option>
		<option value="11">11月</option>
		<option value="12">12月</option>
		</optgroup>
		</select><br>

		<button class="button1" type="submit">検索</button>
	</form>

	<p>受験した検定を選択してください。</p>

	<table class="list">
		<tr>
			<th>実施日</th><th>主催</th><th>検定名</th>
		</tr>
		<%for(int i = 0;i < size;i++){ %>
		<tr>
			<td><%=examationinfo.getTestDay().get(i) %></td><td><%=examationinfo.getSponsor().get(i) %></td><td><a href="/testmanagement/view/examationadd3.jsp?forid=<%=i%>"><%=examationinfo.getTestName().get(i)	%></a></td>
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