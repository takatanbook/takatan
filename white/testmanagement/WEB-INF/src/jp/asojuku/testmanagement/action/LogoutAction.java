package jp.asojuku.testmanagement.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class LogoutAction extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//セッションの削除
		deleteLoginInfo(request);
		//トップ画面へ遷移（リダイレクト）
		response.sendRedirect(request.getContextPath()+"/login");
	}

	/**
	 * セッションの削除
	 * @param request
	 */
	private void deleteLoginInfo(HttpServletRequest request){

		HttpSession session = request.getSession(false);

		if( session != null ){
			//ログオン情報の削除
			session.removeAttribute("logininfo");
			//セッションの破棄
			session.invalidate();
		}

	}
}
