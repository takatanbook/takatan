
<!DOCTYPE html>
<html lang="ja">
<head>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page import="jp.asojuku.testmanagement.dto.SeachTestHistoryStudentDTO" %>
<%@ page import="jp.asojuku.testmanagement.dto.SeachTestHistoryStudentResultDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="jp.asojuku.testmanagement.dto.SeachStudentHistoryTestResultDTO" %>
<%@ page import="jp.asojuku.testmanagement.dto.SeachStudentHistoryTestDTO" %>
<%@ page import="jp.asojuku.testmanagement.util.CipherHelper" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Date" %>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
</head>
<body>
<header><h1><a href="<%=request.getContextPath() %>/admintestview"">検定管理システム</a></h1></header>
<%
//seachstudenthistorytestresult
	SeachStudentHistoryTestResultDTO result =
			(SeachStudentHistoryTestResultDTO)request.getAttribute("seachstudenthistorytestresult");
	SeachTestHistoryStudentResultDTO resultdto =
			(SeachTestHistoryStudentResultDTO)request.getAttribute("seachstudentlogtextresult");


%>

<%
      if(resultdto != null){
    		String keword = resultdto.getKeyword();
    		List<SeachTestHistoryStudentDTO> list = resultdto.getStudentinfolist();
    		if(list == null){
    			System.out.println("null");
    		}
%>
<div class="main">

  <div class="info">
  <p>キーワード：<input type="text" name="">
  <button class="button1" type="submit">再検索</button></p>

  <h2>検索結果：　"<%= keword %>"</h2>

  <table class="list">

    <tr>
      <th>学科</th><th>学年</th><th>クラス</th><th>氏名</th>
    </tr>
    <% for(SeachTestHistoryStudentDTO data: list) {%>
      <% String encrypedResult = CipherHelper.encrypt(data.getStudent_id()); %>
      <tr>
        <td><%= data.getDepartment() %></td><td><%= data.getGrade() %></td><td><%= data.getClass_name() %></td><td><a href="<%=request.getContextPath() %>/historyoftest?student_id=<%=URLEncoder.encode(encrypedResult,"UTF-8")%>"><%= data.getStudent_name() %></a></td>
      </tr>
    <%} %>

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


  	    <%} else if(result  != null){ %>
<div class="main">
    <div class="info">
      <form action ="<%=request.getContextPath() %>/seachStudenttesthistory" method="POST">
        <p>キーワード：<input type="text" name="keyword">
        <button class="button1" type="submit">再検索</button></p>
      </form>
      <h2>検索結果：　"<%=result.getKeyword()%>"</h2>
      <table class="list">
        <tr>
          <th>実施日</th><th>主催</th><th>検定名</th><th>合否</th>
          </tr>
        <tr>
  		      <% List<SeachStudentHistoryTestDTO> list = result.getstudenttestloginfolist();%>
            <% String nae = "";%>
  		      <% for (SeachStudentHistoryTestDTO data : list) { %>
        			<%
        			String date = "";
        			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        			date = sdf1.format(data.getTestDay());
        			%>
              <%

    			      int i = data.getExamationResult();
    			      if(i == 1){nae ="合格";}else{nae = "不合格";}
  			      %>
              <tr>
          			<td><%= date %></td><td><%= data.getTestSponsor() %></td><td><%= data.getTestName() %></td><td class="student_test_result"><%= nae %></td>
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
	    <% } %>

<footer>&copy; 2016 WhiteCo.</footer>
</body>
</html>