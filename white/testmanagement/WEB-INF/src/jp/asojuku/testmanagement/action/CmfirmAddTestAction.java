package jp.asojuku.testmanagement.action;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.asojuku.testmanagement.bo.DeleteTestInfoBo;
import jp.asojuku.testmanagement.bo.TestAddBo;
import jp.asojuku.testmanagement.vailidator.UtilValidator;

public class CmfirmAddTestAction extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ

		HttpSession session = req.getSession(false);

		String jisshi_year = req.getParameter("jisshi_year");
		String jisshi_month = req.getParameter("jisshi_month");
		String jisshi_day = req.getParameter("jisshi_day");
		String sponsor = req.getParameter("sponsor");
		String test_name = req.getParameter("test_name");

		String kara = "値が空です!";
		String husei = "値が不正です!";
		
		//この辺に入力チェック処理
		UtilValidator utilcheck = new UtilValidator();
		List<String> list = new ArrayList<String>();
		if(utilcheck.isEmpty(jisshi_year) == false ){
			list.add("年が"+kara);
		}else if(utilcheck.stringLengthCheck(jisshi_year, 4, 4) == false){
			list.add("年が"+husei);
		}else if(utilcheck.escapeHTML(jisshi_year) == false){
			list.add("年が"+husei);
		}
		
		if(utilcheck.isEmpty(jisshi_month) == false ){
			list.add("月が"+kara);
		}else if(utilcheck.stringLengthCheck(jisshi_month, 1, 2) == false){
			list.add("月が"+husei);
		}else if(utilcheck.escapeHTML(jisshi_month) == false){
			list.add("月が"+husei);
		}
		if(utilcheck.isEmpty(jisshi_day) == false ){
			list.add("日が"+kara);
		}else if(utilcheck.stringLengthCheck(jisshi_day, 1, 2) == false){
			list.add("日が"+husei);
		}else if(utilcheck.escapeHTML(jisshi_day) == false){
			list.add("日が"+husei);
		}
		if(utilcheck.isEmpty(sponsor) == false ){
			list.add("主催名が"+kara);
		}else if(utilcheck.stringLengthCheck(sponsor, 1, 50) == false){
			list.add("主催名が"+husei);
		}else if(utilcheck.escapeHTML(sponsor) == false){
			list.add("主催名が"+husei);
		}else if(utilcheck.isEnAndJp(sponsor) == false){
		 	list.add("主催名が");
		}
		if(utilcheck.isEmpty(test_name) == false ){
			list.add("検定名が"+kara);
		}else if(utilcheck.stringLengthCheck(test_name, 1, 50) == false){
			list.add("検定名が"+husei);
		}else if(utilcheck.escapeHTML(test_name) == false){
			list.add("検定名が"+husei);
		}else if(utilcheck.isEnAndJpAndNumber(test_name) == false){
			list.add("検定名が" + husei);
		}
		if( list.isEmpty()){
			req.setAttribute("list", list);
			RequestDispatcher rd = req.getRequestDispatcher("view/test_add.jsp");		//指定ページへ遷移
			rd.forward(req, resp);
			return;
		}
		
		TestAddBo testaddbo = new TestAddBo();
		int count;
		String day = jisshi_year + "-" + jisshi_month + "-" + jisshi_day;
		try {
			
			count = testaddbo.testingAlreadyExists(test_name, sponsor, day);
			if(count != 0){
				String name = "テストデータが同じ値が既にあります!";
				req.setAttribute("test_err", name);
				RequestDispatcher rd = req.getRequestDispatcher("view/test_add.jsp");		//指定ページへ遷移
				rd.forward(req, resp);
				return;
			}
			
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		session.setAttribute("jisshi_year", jisshi_year);
		session.setAttribute("jisshi_month", jisshi_month);
		session.setAttribute("jisshi_day", jisshi_day);
		session.setAttribute("sponsor", sponsor);
		session.setAttribute("test_name", test_name);


		//req.setAttribute("jisshi_year", jisshi_year);
		//req.setAttribute("jisshi_month", jisshi_month);
		//req.setAttribute("jisshi_day", jisshi_day);
		//req.setAttribute("sponsor", sponsor);
		//req.setAttribute("test_name", test_name);

		RequestDispatcher rd = req.getRequestDispatcher("view/test_add_kakunin.jsp");		//指定ページへ遷移
		rd.forward(req, resp);
	}
	private void fowardErrDisp(HttpServletRequest request, HttpServletResponse resp,String[] err) throws IOException ,ServletException{
		
		request.setAttribute("errMsg",err );
		//画面転送
		RequestDispatcher rd = request.getRequestDispatcher("view/systenerror.jsp");
		rd.forward(request, resp);
	}

}
