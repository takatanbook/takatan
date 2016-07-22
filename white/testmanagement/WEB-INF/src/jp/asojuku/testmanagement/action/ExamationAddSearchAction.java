package jp.asojuku.testmanagement.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.asojuku.testmanagement.bo.ExamationAddSearchBo;
import jp.asojuku.testmanagement.dto.ExamationInfoDto;
import jp.asojuku.testmanagement.dto.LogonInfoDTO;
import jp.asojuku.testmanagement.exception.SystemErrorExcepton;

public class ExamationAddSearchAction extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		String day = req.getParameter("jisshi_nen");
		String month = req.getParameter("jisshi_tsuki");
		ExamationInfoDto examationinfo;
		HttpSession session = req.getSession(false);
		LogonInfoDTO logoninfo = (LogonInfoDTO)session.getAttribute("logininfo");

		try{
			ExamationAddSearchBo examationaddsearch = new  ExamationAddSearchBo();
			day = day + "/" + month;

			examationinfo = examationaddsearch.examationsearch(day, req);
			setExamationInfoToSession(req,examationinfo,logoninfo);



		}catch(SystemErrorExcepton | SQLException e){
			//システムエラーがおきた時にシステムエラーpegeにジャンプ。
			RequestDispatcher rd = req.getRequestDispatcher("view/error.jsp");
			rd.forward(req, resp);
		}
		RequestDispatcher rd = req.getRequestDispatcher("view/examationadd2.jsp");
		rd.forward(req, resp);

	}
	private void setExamationInfoToSession(HttpServletRequest request, ExamationInfoDto  examationInfo,LogonInfoDTO logoninfo){

		HttpSession examationsearchsession = request.getSession(false);

		if( examationsearchsession != null ){
			//セッションをいったん破棄
			examationsearchsession.invalidate();
		}

		//セッション再作成
		examationsearchsession = request.getSession(true);

		examationsearchsession.setAttribute("examationinfo", examationInfo);
		examationsearchsession.setAttribute("logininfo", logoninfo);
	}


}
