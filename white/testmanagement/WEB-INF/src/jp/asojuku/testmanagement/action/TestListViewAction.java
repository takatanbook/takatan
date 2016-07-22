package jp.asojuku.testmanagement.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.asojuku.testmanagement.dto.LogonInfoDTO;
import jp.asojuku.testmanagement.vailidator.LoginInfoVailidator;
//admintestview
public class TestListViewAction extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		LogonInfoDTO user = (LogonInfoDTO)session.getAttribute("logininfo");
		int authority = 0;
		String err = "";
		if(user == null){
			//まずログインもしていないのに不正に検索をかけようとしていた。
			err = "ログインしていないか、セッションが切れています。ログインをもう一度お願いいたします。";
			fowardErrDisp(req,resp,err);
			return;
		 }
		 //権限を取得
		authority = user.getAuthority();
		//ユーザーの権限を確認
		if (authority !=  LoginInfoVailidator.MANAGE_INFO_IDX) {
			//学生なので権限がないというメッセージを表示
			err = "管理者権限がないので実行できません。";
			fowardErrDisp(req,resp,err);
			return;
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("view/test_list.jsp");
		rd.forward(req, resp);
	}
	private void fowardErrDisp(HttpServletRequest request, HttpServletResponse resp,String err) throws IOException ,ServletException{
			
			request.setAttribute("errMsg",err );
			//画面転送
			RequestDispatcher rd = request.getRequestDispatcher("view/error.jsp");
			rd.forward(request, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		doGet(req, resp);
	}
		
}
