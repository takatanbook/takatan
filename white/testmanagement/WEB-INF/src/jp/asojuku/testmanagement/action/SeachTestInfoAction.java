package jp.asojuku.testmanagement.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.asojuku.testmanagement.bo.SeachTestKeywordBo;
import jp.asojuku.testmanagement.dto.LogonInfoDTO;
import jp.asojuku.testmanagement.dto.TestSeachResultDto;
import jp.asojuku.testmanagement.exception.SystemErrorExcepton;
import jp.asojuku.testmanagement.vailidator.LoginInfoVailidator;

public class SeachTestInfoAction extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 HttpSession session = req.getSession(false);
	
		 LogonInfoDTO user = (LogonInfoDTO)session.getAttribute("logininfo");
		 int authority = 0;
		 String err = "";
		 try{
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
			 TestSeachResultDto testseachresultdto;
			 String keyword = (String)req.getParameter("keyword");
			 SeachTestKeywordBo seachbo = new SeachTestKeywordBo();
			 testseachresultdto = seachbo.seachTestKeyword(keyword);
			 if(testseachresultdto.getSearchNum() == 0){
				 req.setAttribute("errMsg","検索されたキーワードに一致するものは、ありませんでした。" );
				 RequestDispatcher rd = req.getRequestDispatcher("admintestview");
				 rd.forward(req, resp);
				 return;
			 }
			 setTestSeachResultToRequest(req,testseachresultdto);
			 //検定情報一覧画面(G3-2-1)飛ばす
			 RequestDispatcher rd = req.getRequestDispatcher("view/test.jsp");
			 rd.forward(req, resp);
			 
		 }catch(SystemErrorExcepton | SQLException e){
			 //システムエラーがおきた時にシステムエラーpegeにジャンプ。
			 err = "システムエラーが起きたので、管理者にご連絡してください";
			 fowardErrDisp(req,resp,err);
			 
		 }
	}
	
	private void setTestSeachResultToRequest(HttpServletRequest request ,TestSeachResultDto dto){

		request.setAttribute("testseachresult", dto);
	}
	private void fowardErrDisp(HttpServletRequest request, HttpServletResponse resp,String err) throws IOException ,ServletException{
				
		request.setAttribute("errMsg",err );
		//画面転送
		RequestDispatcher rd = request.getRequestDispatcher("view/systenerror.jsp");
		rd.forward(request, resp);
	}		
}