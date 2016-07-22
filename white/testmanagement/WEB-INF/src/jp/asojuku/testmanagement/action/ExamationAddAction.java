package jp.asojuku.testmanagement.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.asojuku.testmanagement.bo.ExamationAddBo;
import jp.asojuku.testmanagement.dto.ExamationInfoDto;
import jp.asojuku.testmanagement.dto.LogonInfoDTO;
import jp.asojuku.testmanagement.exception.SystemErrorExcepton;

public class ExamationAddAction extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		HttpSession session = req.getSession(false);
		ExamationInfoDto examationinfo = (ExamationInfoDto)session.getAttribute("examationinfo");
		LogonInfoDTO logoninfo = (LogonInfoDTO)session.getAttribute("logininfo");
		String sdt_id = logoninfo.getId();



		int i = (int)session.getAttribute("forid");
		int gouhi = (int)session.getAttribute("gouhi");
		int test_id = examationinfo.getExamationId().get(i);
		ExamationAddBo examationadd = new  ExamationAddBo();


		int result = 0;
		try{
			result = examationadd.examationInsert(sdt_id, test_id ,gouhi);



		}catch(SystemErrorExcepton e){
			//システムエラーがおきた時にシステムエラーpegeにジャンプ。
			RequestDispatcher rd = req.getRequestDispatcher("view/error.jsp");
			rd.forward(req, resp);
		}

		RequestDispatcher rd = req.getRequestDispatcher("view/examationaddend.jsp");
		rd.forward(req, resp);
	}


}
