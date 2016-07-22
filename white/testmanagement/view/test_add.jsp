<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>検定管理システム</title>
<link href="<%=request.getContextPath() %>/view/css/style.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/view/js/jquery-1.11.3.min.js"></script>
<%@ page import="java.util.List" %>
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
<% List<String> arr; %>
<%  arr = (List)request.getAttribute("list");%>
<header><h1><a href="main_admin.html">検定管理システム</a></h1></header>

<div class="main">

	<div class="info">
	<h2>検定情報追加</h2>
	<% if (arr != null){ %>
		<% for(int i = 0; i < arr.size(); i++) {%>
			<%= arr.get(i) %>
		<%} %>
	<%} %>
	
	<form action="cmfirmtestadd" method="POST">
	<table class="list">
		<tr>
			<td class="testadd">実施日</td>
			<td class="testadd_main">
				<select name="jisshi_year" class="drop">
				<optgroup label="年">
				<option value="2016">2016年</option>
				<option value="2015">2015年</option>
				<option value="2014">2014年</option>
				<option value="2013">2013年</option>
				<option value="2012">2012年</option>
				<option value="2011">2011年</option>
				<option value="2010">2010年</option>
				</optgroup>
				</select><br>

				<select name="jisshi_month" class="drop">
				<optgroup label="月">
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

				<select name="jisshi_day" class="drop">
				<optgroup label="日">
				<option value="1">1日</option>
				<option value="2">2日</option>
				<option value="3">3日</option>
				<option value="4">4日</option>
				<option value="5">5日</option>
				<option value="6">6日</option>
				<option value="7">7日</option>
				<option value="8">8日</option>
				<option value="9">9日</option>
				<option value="10">10日</option>
				<option value="11">11日</option>
				<option value="12">12日</option>
				<option value="13">13日</option>
				<option value="14">14日</option>
				<option value="15">15日</option>
				<option value="16">16日</option>
				<option value="17">17日</option>
				<option value="18">18日</option>
				<option value="19">19日</option>
				<option value="20">20日</option>
				<option value="21">21日</option>
				<option value="22">22日</option>
				<option value="23">23日</option>
				<option value="24">24日</option>
				<option value="25">25日</option>
				<option value="26">26日</option>
				<option value="27">27日</option>
				<option value="28">28日</option>
				<option value="29">29日</option>
				<option value="30">30日</option>
				<option value="31">31日</option>
				</optgroup>
				</select><br>
			</td>
		</tr>
		<tr>
			<td class="testadd">主催名</td>
			<td class="testadd_main"><input type="text" name="sponsor"></td>
		</tr>
		<tr>
			<td class="testadd">検定名</td>
			<td class="testadd_main"><input type="text" name="test_name"></td>
		</tr>
	</table>

	<table class="button">
		<tr>
			<td class="button">
				<button class="button1" type="submit">確認</button>
			</td>
		</tr>
	</table>
	</form>
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