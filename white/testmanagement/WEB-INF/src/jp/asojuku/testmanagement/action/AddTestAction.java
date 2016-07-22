package jp.asojuku.testmanagement.action;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.asojuku.testmanagement.bo.TestAddBo;
import jp.asojuku.testmanagement.dto.LogonInfoDTO;
import jp.asojuku.testmanagement.exception.SystemErrorExcepton;

public class AddTestAction extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		//super.doPost(req, resp);

		int result = 0;
		String manage_id = null;
		String test_name = null;
		String test_sponsor = null;
		String day = null;
		String test_day_y = null;
		String test_day_m = null;
		String test_day_d = null;
		String fowardDisp = "";

		LogonInfoDTO logon;
		HttpSession session = req.getSession(false);
		logon = (LogonInfoDTO)session.getAttribute("logininfo");

		manage_id = logon.getId();

		test_name = (String)session.getAttribute("test_name");
		test_sponsor = (String)session.getAttribute("sponsor");
		test_day_y = (String)session.getAttribute("jisshi_year");
		test_day_m = (String)session.getAttribute("jisshi_month");
		test_day_d = (String)session.getAttribute("jisshi_day");

		day = test_day_y + "-" + test_day_m + "-" + test_day_d;

		try {
			if( manage_id == null){

					fowardLoginErrDisp(req,resp);
					return;

			}
			TestAddBo testaddbo = new TestAddBo();

			result = testaddbo.addTest(test_name, test_sponsor, day);

			if (result == 0) {

				 fowardDisp = "view/error.jsp";	//エラーページ

			}else{

				 fowardDisp = "view/test_add_complete.jsp";	//完了ページへ遷移

			}
			RequestDispatcher rd = req.getRequestDispatcher(fowardDisp);		//指定ページへ遷移
			rd.forward(req, resp);
			return;

		} catch (SystemErrorExcepton | ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			RequestDispatcher rd = req.getRequestDispatcher("view/error.jsp"); //エラーページへ遷移
			rd.forward(req, resp);
			return;
		}

	}
	private void fowardLoginErrDisp(HttpServletRequest request, HttpServletResponse resp) throws IOException, SystemErrorExcepton, ServletException{
		//エラーメッセージをセット
		String errMsg;

		errMsg = "ログインできませんでした。メールアドレスかパスワードが間違っています。";

		request.setAttribute("errMsg",errMsg );

		//画面転送
		RequestDispatcher rd = request.getRequestDispatcher("view/login.jsp");
		rd.forward(request, resp);
		return;

	}




}
