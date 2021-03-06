/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.69
 * Generated at: 2016-07-22 03:25:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jp.asojuku.testmanagement.dto.SeachTestHistoryStudentDTO;
import jp.asojuku.testmanagement.dto.SeachTestHistoryStudentResultDTO;
import java.util.ArrayList;
import java.util.List;
import jp.asojuku.testmanagement.dto.SeachStudentHistoryTestResultDTO;
import jp.asojuku.testmanagement.dto.SeachStudentHistoryTestDTO;
import jp.asojuku.testmanagement.util.CipherHelper;
import java.text.SimpleDateFormat;
import java.net.URLEncoder;
import java.util.Date;

public final class result_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"ja\">\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/view/css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/view/js/jquery-1.11.3.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("$(function(){\n");
      out.write("    $('a,a img,button').css({\n");
      out.write("        opacity: 1.0,\n");
      out.write("        filter: \"alpha(opacity=100)\"\n");
      out.write("        }).hover(function(){\n");
      out.write("            $(this).fadeTo(200,0.6);\n");
      out.write("        },function(){\n");
      out.write("            $(this).fadeTo(200,1.0);\n");
      out.write("    })\n");
      out.write("});\n");
      out.write("</script>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\n");
      out.write("<title></title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<header><h1><a href=\"");
      out.print(request.getContextPath() );
      out.write("/admintestview\"\">検定管理システム</a></h1></header>\n");

//seachstudenthistorytestresult
	SeachStudentHistoryTestResultDTO result =
			(SeachStudentHistoryTestResultDTO)request.getAttribute("seachstudenthistorytestresult");
	SeachTestHistoryStudentResultDTO resultdto =
			(SeachTestHistoryStudentResultDTO)request.getAttribute("seachstudentlogtextresult");



      out.write('\n');
      out.write('\n');

      if(resultdto != null){
    		String keword = resultdto.getKeyword();
    		List<SeachTestHistoryStudentDTO> list = resultdto.getStudentinfolist();
    		if(list == null){
    			System.out.println("null");
    		}

      out.write("\n");
      out.write("<div class=\"main\">\n");
      out.write("\n");
      out.write("  <div class=\"info\">\n");
      out.write("  <p>キーワード：<input type=\"text\" name=\"\">\n");
      out.write("  <button class=\"button1\" type=\"submit\">再検索</button></p>\n");
      out.write("\n");
      out.write("  <h2>検索結果：　\"");
      out.print( keword );
      out.write("\"</h2>\n");
      out.write("\n");
      out.write("  <table class=\"list\">\n");
      out.write("\n");
      out.write("    <tr>\n");
      out.write("      <th>学科</th><th>学年</th><th>クラス</th><th>氏名</th>\n");
      out.write("    </tr>\n");
      out.write("    ");
 for(SeachTestHistoryStudentDTO data: list) {
      out.write("\n");
      out.write("      ");
 String encrypedResult = CipherHelper.encrypt(data.getStudent_id()); 
      out.write("\n");
      out.write("      <tr>\n");
      out.write("        <td>");
      out.print( data.getDepartment() );
      out.write("</td><td>");
      out.print( data.getGrade() );
      out.write("</td><td>");
      out.print( data.getClass_name() );
      out.write("</td><td><a href=\"");
      out.print(request.getContextPath() );
      out.write("/historyoftest?student_id=");
      out.print(URLEncoder.encode(encrypedResult,"UTF-8"));
      out.write('"');
      out.write('>');
      out.print( data.getStudent_name() );
      out.write("</a></td>\n");
      out.write("      </tr>\n");
      out.write("    ");
} 
      out.write("\n");
      out.write("\n");
      out.write("  </table>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <div class=\"side\">\n");
      out.write("  <form action=\"");
      out.print(request.getContextPath() );
      out.write("/logout\"><button class=\"menu\" type=\"submit\">ログアウト</button></form>\n");
      out.write("  <form action=\"");
      out.print(request.getContextPath() );
      out.write("/admintop\"><button class=\"menu\" type=\"submit\">メニュートップ</button></form>\n");
      out.write("\n");
      out.write("  <p><hr></p>\n");
      out.write("\n");
      out.write("  <form action=\"");
      out.print(request.getContextPath() );
      out.write("/admintestview\" method=\"POST\"><button class=\"menu\" type=\"submit\">検定情報トップ</button></form>\n");
      out.write("  <form action=\"test_add.html\" method=\"POST\"><button class=\"menu\" type=\"submit\">検定の追加</button></form>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("  \t    ");
} else if(result  != null){ 
      out.write("\n");
      out.write("<div class=\"main\">\n");
      out.write("    <div class=\"info\">\n");
      out.write("      <form action =\"");
      out.print(request.getContextPath() );
      out.write("/seachStudenttesthistory\" method=\"POST\">\n");
      out.write("        <p>キーワード：<input type=\"text\" name=\"keyword\">\n");
      out.write("        <button class=\"button1\" type=\"submit\">再検索</button></p>\n");
      out.write("      </form>\n");
      out.write("      <h2>検索結果：　\"");
      out.print(result.getKeyword());
      out.write("\"</h2>\n");
      out.write("      <table class=\"list\">\n");
      out.write("        <tr>\n");
      out.write("          <th>実施日</th><th>主催</th><th>検定名</th><th>合否</th>\n");
      out.write("          </tr>\n");
      out.write("        <tr>\n");
      out.write("  \t\t      ");
 List<SeachStudentHistoryTestDTO> list = result.getstudenttestloginfolist();
      out.write("\n");
      out.write("            ");
 String nae = "";
      out.write("\n");
      out.write("  \t\t      ");
 for (SeachStudentHistoryTestDTO data : list) { 
      out.write("\n");
      out.write("        \t\t\t");

        			String date = "";
        			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        			date = sdf1.format(data.getTestDay());
        			
      out.write("\n");
      out.write("              ");


    			      int i = data.getExamationResult();
    			      if(i == 1){nae ="合格";}else{nae = "不合格";}
  			      
      out.write("\n");
      out.write("              <tr>\n");
      out.write("          \t\t\t<td>");
      out.print( date );
      out.write("</td><td>");
      out.print( data.getTestSponsor() );
      out.write("</td><td>");
      out.print( data.getTestName() );
      out.write("</td><td class=\"student_test_result\">");
      out.print( nae );
      out.write("</td>\n");
      out.write("          \t\t</tr>\n");
      out.write("\n");
      out.write("  \t\t      ");
} 
      out.write("\n");
      out.write("            </table>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"side\">\n");
      out.write("          \t<form action=\"");
      out.print(request.getContextPath() );
      out.write("/logout\"><button class=\"menu\" type=\"submit\">ログアウト</button></form>\n");
      out.write("          \t<form action=\"");
      out.print(request.getContextPath() );
      out.write("/admintop\"><button class=\"menu\" type=\"submit\">メニュートップ</button></form>\n");
      out.write("\n");
      out.write("          \t<p><hr></p>\n");
      out.write("\n");
      out.write("          \t<form action=\"");
      out.print(request.getContextPath() );
      out.write("/admintestview\" method=\"POST\"><button class=\"menu\" type=\"submit\">検定情報トップ</button></form>\n");
      out.write("          \t<form action=\"test_add.html\" method=\"POST\"><button class=\"menu\" type=\"submit\">検定の追加</button></form>\n");
      out.write("          \t</div>\n");
      out.write("\n");
      out.write("          </div>\n");
      out.write("\t    ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("<footer>&copy; 2016 WhiteCo.</footer>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
