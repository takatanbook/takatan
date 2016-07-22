package jp.asojuku.testmanagement.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.asojuku.testmanagement.bo.ExamationDeleteBo;
import jp.asojuku.testmanagement.exception.SystemErrorExcepton;

public class ExamationDeleteAction extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		int id = Integer.parseInt(req.getParameter("examationid"));
		ExamationDeleteBo examationdel = new  ExamationDeleteBo();
		int result = 0;
		try{
			result = examationdel.examationDelete(id);



		}catch(SystemErrorExcepton e){
			//システムエラーがおきた時にシステムエラーpegeにジャンプ。
			RequestDispatcher rd = req.getRequestDispatcher("view/error.jsp");
			rd.forward(req, resp);
		}

		RequestDispatcher rd = req.getRequestDispatcher("view/examationdelend.jsp");
		rd.forward(req, resp);
	}


}
