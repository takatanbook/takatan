package jp.asojuku.testmanagement.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.asojuku.testmanagement.bo.DeleteTestInfoBo;
import jp.asojuku.testmanagement.dto.LogonInfoDTO;
import jp.asojuku.testmanagement.dto.TestSeachResultDto;
import jp.asojuku.testmanagement.exception.SystemErrorExcepton;
import jp.asojuku.testmanagement.vailidator.LoginInfoVailidator;

public class ConfirmationDeleteTestInfoAction extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		HttpSession session = req.getSession(false);
		String test_id = req.getParameter("date");
		LogonInfoDTO user = (LogonInfoDTO)session.getAttribute("logininfo");
		int authority = 0;
		String err = "";
		TestSeachResultDto result;
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
		DeleteTestInfoBo deletetestinfobo = new DeleteTestInfoBo();
		try {
			
			result = deletetestinfobo.testdeleteinformation(test_id);
			if(result.getSearchNum() == 0){
				err= "システムエラーが起きたので、管理者にご連絡してください";
				fowardErrDisp(req,resp,err);
				return;
			}
			setTestSeachResultToRequest(req,result);
			RequestDispatcher rd = req.getRequestDispatcher("view/confirmationdeltetestinfo.jsp");
			rd.forward(req, resp);
			
		} catch (NamingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			//システムエラーがおきた時にシステムエラーpegeにジャンプ。
			err = "システムエラーが起きたので、管理者にご連絡してください";
			fowardErrDisp(req,resp,err);
		} catch( SQLException | SystemErrorExcepton e){
			System.out.println(e.getMessage());
			//システムエラーがおきた時にシステムエラーpegeにジャンプ。
			err = "システムエラーが起きたので、管理者にご連絡してください";
			fowardErrDisp(req,resp,err);
		} 
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		doPost(req, resp);
	}
	private void fowardErrDisp(HttpServletRequest request, HttpServletResponse resp,String err) throws IOException ,ServletException{
		
		request.setAttribute("errMsg",err );
		//画面転送
		RequestDispatcher rd = request.getRequestDispatcher("view/systenerror.jsp");
		rd.forward(request, resp);
	}
	private void setTestSeachResultToRequest(HttpServletRequest request ,TestSeachResultDto dto){

		request.setAttribute("testseachresult", dto);
	}
	
}
