package jp.asojuku.testmanagement.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.asojuku.testmanagement.bo.LoginBo;
import jp.asojuku.testmanagement.dto.LogonInfoDTO;
import jp.asojuku.testmanagement.exception.SystemErrorExcepton;
import jp.asojuku.testmanagement.vailidator.LoginInfoVailidator;

public class LoginAction extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name;
		String pass;

		//MemberInfoDto memberinfo = new MemberInfoDto();
		name = req.getParameter("username");
		pass = req.getParameter("password");
		LogonInfoDTO logon;
		try{

			LoginBo login = new  LoginBo();
			logon = login.getMemberInfoByUserPassword(name, pass);

			//ログインできてるか？
			if(logon == null){

				fowardLoginErrDisp(req,resp);
				return;
			}

			//いらないコード
			//memberinfo = entityChageDto(entity);

			setLoginInfoToSession(req,logon);
			String foward = "";
			//画面転送
			if(logon.getAuthority() == LoginInfoVailidator.STUDENT_INFO_IDX){
				foward = "examationlist";
			}else if(logon.getAuthority() == LoginInfoVailidator.MANAGE_INFO_IDX){
				foward = "admintop";
			}
			RequestDispatcher rd = req.getRequestDispatcher(foward);
			rd.forward(req, resp);
		}catch(SystemErrorExcepton | SQLException e){
			//システムエラーがおきた時にシステムエラーpegeにジャンプ。
			RequestDispatcher rd = req.getRequestDispatcher("view/error.jsp");
			rd.forward(req, resp);
		}


	}
	private void fowardLoginErrDisp(HttpServletRequest request, HttpServletResponse resp) throws IOException, SystemErrorExcepton, ServletException{
		//エラーメッセージをセット
		String errMsg;

		errMsg = "ログインできませんでした。メールアドレスかパスワードが間違っています。";

		request.setAttribute("errMsg",errMsg );

		//画面転送
		RequestDispatcher rd = request.getRequestDispatcher("view/login.jsp");
		rd.forward(request, resp);

	}
	private void setLoginInfoToSession(HttpServletRequest request, LogonInfoDTO  logoninfo){

		HttpSession session = request.getSession(false);

		if( session != null ){
			//セッションをいったん破棄
			session.invalidate();
		}

		//セッション再作成
		session = request.getSession(true);

		session.setAttribute("logininfo", logoninfo);
	}
}
