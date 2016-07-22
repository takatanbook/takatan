package jp.asojuku.testmanagement.bo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import jp.asojuku.testmanagement.dto.LogonInfoDTO;
import jp.asojuku.testmanagement.entity.ManageEntity;
import jp.asojuku.testmanagement.entity.StudentEntity;
import jp.asojuku.testmanagement.exception.SystemErrorExcepton;
import jp.asojuku.testmanagement.model.Dbcontrol;
import jp.asojuku.testmanagement.vailidator.LoginInfoVailidator;

public class LoginBo {
	
	//学生用のログイン用のSQL文
	private static final String STUDENT_INFO_BY_UP_SQL =
				"SELECT * FROM student WHERE "+StudentEntity.STUDENT_MAIL+"=? AND "+StudentEntity.STUDENT_PASS+"=?";
	
	//管理者のログイン用のSQL文
	private static final String MANAGE_INFO_BY_UP_SQL =
			"SELECT * FROM manage WHERE "+ManageEntity.MANAGE_MAIL+"=? AND "+ManageEntity.MANAGE_PASS+"=?";
	
	//学生用のPreparedStatementにセットする数字
	private static final int STUDENT_INFO_BY_UP_NAME_IDX = 1;
	private static final int STUDENT_INFO_BY_UP_PASS_IDX = 2;
	
	//管理者用のPreparedStatementにセットする数字
	private static final int MANAGE_INFO_BY_UP_NAME_IDX = 1;
	private static final int MANAGE_INFO_BY_UP_PASS_IDX = 2;
	

	private LogonInfoDTO memberinfo;
	
	public LogonInfoDTO getMemberInfoByUserPassword(String name,String pass) throws SQLException, SystemErrorExcepton{

		ResultSet rs = null;
		
		Dbcontrol db = new Dbcontrol();
		String userName = "";
		userName = name;
		int n;
		n = LoginInfoVailidator.MailCheck(userName);
		
        try {
        	
        	db.connect();
        	if( n == LoginInfoVailidator.MANAGE_INFO_IDX){
        		memberinfo = LogonManageSelect(userName,pass,db);
        	}else if(n == LoginInfoVailidator.STUDENT_INFO_IDX){
        	
        		memberinfo = LogonStudentSelect(userName,pass,db);
	        }else {
	        	memberinfo = null;
	        }
	        
	       
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			throw new SystemErrorExcepton();

		} catch (NamingException e) {
			
			e.printStackTrace();
			throw new SystemErrorExcepton();
		} finally {

	        // 接続を閉じる
        	if( rs != null ){
				rs.close();
        	}
    		db.close();
		}
		return memberinfo;
	}
	//エンティティをDTOに変換
	public LogonInfoDTO chageentityTodto(StudentEntity entity){
		LogonInfoDTO memberinfo = new LogonInfoDTO();
		memberinfo.setName( entity.getStudentName() );
		memberinfo.setId( entity.getStudentId() );
		memberinfo.setAuthority(LoginInfoVailidator.STUDENT_INFO_IDX);
		return memberinfo;
	}
	//エンティティをDTOに変換
	public LogonInfoDTO chageentityTodto(ManageEntity entity){
		LogonInfoDTO memberinfo = new LogonInfoDTO();
		memberinfo.setName( entity.getManageMail() );
		memberinfo.setId( entity.getManageId() );
		memberinfo.setAuthority(LoginInfoVailidator.MANAGE_INFO_IDX);
		return memberinfo;
	}
	public LogonInfoDTO LogonManageSelect(String name,String pass,Dbcontrol db) throws SQLException{
		ResultSet rs = null;
		ManageEntity   manageentity = null;
	
		db.prepareStatement(MANAGE_INFO_BY_UP_SQL);

        db.setString(MANAGE_INFO_BY_UP_NAME_IDX, name);
        db.setString(MANAGE_INFO_BY_UP_PASS_IDX, pass);

        rs = db.executeQuery();
       
        while(rs.next()){
        	manageentity = new ManageEntity();
           
        	manageentity.setManageId(rs.getString(ManageEntity.MANAGE_ID));
        	manageentity.setManageName(rs.getString(ManageEntity.MANAGE_NAME));
        	manageentity.setManageNameKana(rs.getString(ManageEntity.MANAGE_NAME_KANA));
        	manageentity.setManageMail(rs.getString(ManageEntity.MANAGE_MAIL));
        	memberinfo = chageentityTodto(manageentity);
        }
        
        return memberinfo;
	}
	public LogonInfoDTO LogonStudentSelect(String name,String pass,Dbcontrol db) throws SQLException{
		ResultSet rs = null;
		StudentEntity studententity = null;
		
		db.prepareStatement(STUDENT_INFO_BY_UP_SQL);

        db.setString(STUDENT_INFO_BY_UP_NAME_IDX, name);
        db.setString(STUDENT_INFO_BY_UP_PASS_IDX, pass);

        rs = db.executeQuery();
       
        while(rs.next()){
        	studententity = new StudentEntity();
          
        	studententity.setStudentName(rs.getString(StudentEntity.STUDENT_NAME));
        	studententity.setStudentId(rs.getString(StudentEntity.STUDENT_ID));
        	studententity.setStudentMail(rs.getString(StudentEntity.STUDENT_MAIL));
        	studententity.setStudentNameKana(rs.getString(StudentEntity.STUDENT_NAME_KANA));
        	studententity.setStudentBirth(rs.getDate(StudentEntity.STUDENT_BIRTH));
        	studententity.setDepartId(rs.getString(StudentEntity.DEPART_ID));
        	studententity.setStudentYear(rs.getInt(StudentEntity.STUDENT_YEAR));
        	studententity.setStudentClassName(rs.getString(StudentEntity.STUDNET_CLASS_NAME));
        	studententity.setStudentExistFlg(rs.getInt(StudentEntity.STUDENT_EXIST_FLG));
        	memberinfo = chageentityTodto(studententity);
        	
        }
        
        return memberinfo;
	}
}
