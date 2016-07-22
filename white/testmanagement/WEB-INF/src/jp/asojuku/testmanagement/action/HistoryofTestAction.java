package jp.asojuku.testmanagement.action;

import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.asojuku.testmanagement.bo.SeachStudentHistoryTestBo;
import jp.asojuku.testmanagement.dto.LogonInfoDTO;
import jp.asojuku.testmanagement.dto.SeachStudentHistoryTestResultDTO;
import jp.asojuku.testmanagement.exception.SystemErrorExcepton;
import jp.asojuku.testmanagement.util.CipherHelper;
import jp.asojuku.testmanagement.vailidator.LoginInfoVailidator;
//学生が過去に取得したテスト情報を取得する.
public class HistoryofTestAction extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		HttpSession session = req.getSession(false);
		String student_id = (String)req.getParameter("student_id");
		
		
		 LogonInfoDTO user = (LogonInfoDTO)session.getAttribute("logininfo");
		 int authority = 0;
		 String err = "";
		 SeachStudentHistoryTestResultDTO seachstudenthistorytestresultdto = new SeachStudentHistoryTestResultDTO();
		 SeachStudentHistoryTestBo seachstudenthistorytest = new SeachStudentHistoryTestBo();
	
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
		try{
			student_id = URLDecoder.decode(student_id,"UTF-8");
			student_id = CipherHelper.decrypt(student_id);
			seachstudenthistorytestresultdto = seachstudenthistorytest.historyoftest(student_id);
			
			setSeachStudentHistoryTestResultDTOToRequest(req,seachstudenthistorytestresultdto);
			 RequestDispatcher rd = req.getRequestDispatcher("view/result.jsp");
			 rd.forward(req, resp);
			
		} catch(SystemErrorExcepton e){
			//システムエラーがおきた時にシステムエラーpegeにジャンプ。
			err = "システムエラーが起きたので、管理者にご連絡してください";
			fowardErrDisp(req,resp,err);
			
		}catch(NamingException e){
			//DB接続エラーがおきた時にシステムエラーpegeにジャンプ。
			err = "システムエラーが起きたので、管理者にご連絡してください";
			fowardErrDisp(req,resp,err);
		}catch(SQLException e){
			//SQLでエラーがおきた時にシステムエラーpegeにジャンプ。
			err = "システムエラーが起きたので、管理者にご連絡してください";
			fowardErrDisp(req,resp,err);
		}catch(Exception e){
			err = "システムエラーが起きたので、管理者にご連絡してください";
			fowardErrDisp(req,resp,err);
		}
	}
	private void fowardErrDisp(HttpServletRequest request, HttpServletResponse resp,String err) throws IOException ,ServletException{
		
		request.setAttribute("errMsg",err );
		//画面転送
		RequestDispatcher rd = request.getRequestDispatcher("view/systenerror.jsp");
		rd.forward(request, resp);
	}
	private void setSeachStudentHistoryTestResultDTOToRequest(HttpServletRequest request , SeachStudentHistoryTestResultDTO seachstudenthistorytestresultdto){

		request.setAttribute("seachstudenthistorytestresult", seachstudenthistorytestresultdto);
	}

}
