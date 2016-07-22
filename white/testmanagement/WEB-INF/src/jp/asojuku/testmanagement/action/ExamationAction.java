package jp.asojuku.testmanagement.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.asojuku.testmanagement.bo.ExamationBo;
import jp.asojuku.testmanagement.dto.ExamationInfoDto;
import jp.asojuku.testmanagement.dto.LogonInfoDTO;
import jp.asojuku.testmanagement.exception.SystemErrorExcepton;



public class ExamationAction extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		doGet(req,resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		LogonInfoDTO logoninfo = (LogonInfoDTO)session.getAttribute("logininfo");
		ExamationInfoDto examationinfo;

		try{
			ExamationBo examation = new  ExamationBo();
			examationinfo = examation.getExamation(logoninfo.getId());



			setExamationInfoToSession(req,examationinfo,logoninfo);



		}catch(SystemErrorExcepton | SQLException e){
			//システムエラーがおきた時にシステムエラーpegeにジャンプ。
			RequestDispatcher rd = req.getRequestDispatcher("view/error.jsp");
			rd.forward(req, resp);
		}
		RequestDispatcher rd = req.getRequestDispatcher("view/examation.jsp");
		rd.forward(req, resp);

	}

	private void setExamationInfoToSession(HttpServletRequest request, ExamationInfoDto  examationInfo,LogonInfoDTO logoninfo){

		HttpSession session = request.getSession(false);

		//if( examationsession != null ){
			//セッションをいったん破棄
			//examationsession.invalidate();
		//}

		//セッション再作成
		//examationsession = request.getSession(true);
		
		session.setAttribute("examationinfo", examationInfo);
		session.removeAttribute("logininfo");
		session.setAttribute("logininfo", logoninfo);
	}

}
