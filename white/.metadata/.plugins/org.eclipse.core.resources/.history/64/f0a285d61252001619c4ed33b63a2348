package jp.asojuku.testmanagement.action;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.asojuku.testmanagement.bo.SeachStudentHistoryTestBo;
import jp.asojuku.testmanagement.dto.LogonInfoDTO;
import jp.asojuku.testmanagement.dto.SeachTestHistoryStudentResultDTO;
import jp.asojuku.testmanagement.exception.SystemErrorExcepton;
import jp.asojuku.testmanagement.vailidator.LoginInfoVailidator;

public class SeachStudentTestHistoryAction extends HttpServlet{

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
			 String keyword = req.getParameter("keyword");
			 SeachTestHistoryStudentResultDTO seachtexthistorystudentresultdto;
			 SeachStudentHistoryTestBo seachstudenthisorytestbo = new SeachStudentHistoryTestBo();
			 seachtexthistorystudentresultdto = seachstudenthisorytestbo.seachStudentTestlog(keyword);
			 setStudentTestSeachResultToRequest(req,seachtexthistorystudentresultdto);
			 if(seachtexthistorystudentresultdto.getSearchNum() == 0){
				 req.setAttribute("StudentMsg","検索された学生は、いません。" );
				 RequestDispatcher rd = req.getRequestDispatcher("admintestview");
				 rd.forward(req, resp);
				 return;
			 }
			//検定情報一覧画面(G3-2-1)飛ばす
			 RequestDispatcher rd = req.getRequestDispatcher("view/result.jsp");
			 rd.forward(req, resp);
		 }catch(SystemErrorExcepton e){
			 
			 e.printStackTrace(); 
			 String err1 = "システムエラーが発生しました。管理者に連絡お願いいたします。";
			 fowardErrDisp(req,resp,err1);
		 }catch(NamingException e){
			 String err2 = "システムエラーが発生しました。管理者に連絡お願いいたします。";
			 e.printStackTrace();
			 fowardErrDisp(req,resp,err2);
		 }
	}
	private void fowardErrDisp(HttpServletRequest request, HttpServletResponse resp,String err) throws IOException ,ServletException{
			
			request.setAttribute("errMsg",err );
			//画面転送
			RequestDispatcher rd = request.getRequestDispatcher("view/systenerror.jsp");
			rd.forward(request, resp);
	}
	private void setStudentTestSeachResultToRequest(HttpServletRequest request ,SeachTestHistoryStudentResultDTO seachtexthistorystudentresultdto){

		request.setAttribute("seachstudentlogtextresult", seachtexthistorystudentresultdto);
	}
	
}
