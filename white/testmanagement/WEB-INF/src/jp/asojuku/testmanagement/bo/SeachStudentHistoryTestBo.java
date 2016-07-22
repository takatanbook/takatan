package jp.asojuku.testmanagement.bo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.lang3.StringUtils;

import jp.asojuku.testmanagement.dto.SeachStudentHistoryTestDTO;
import jp.asojuku.testmanagement.dto.SeachStudentHistoryTestResultDTO;
import jp.asojuku.testmanagement.dto.SeachTestHistoryStudentDTO;
import jp.asojuku.testmanagement.dto.SeachTestHistoryStudentResultDTO;
import jp.asojuku.testmanagement.entity.ExamationEntity;
import jp.asojuku.testmanagement.entity.StudentDepartmentEntity;
import jp.asojuku.testmanagement.entity.StudentEntity;
import jp.asojuku.testmanagement.entity.TestListEntity;
import jp.asojuku.testmanagement.exception.SystemErrorExcepton;
import jp.asojuku.testmanagement.model.Dbcontrol;

public class SeachStudentHistoryTestBo {
	
	private static final String SEACH_STUDENT_HISTORY_TEST_BY_SQL = "SELECT " +
	 "student.sdt_id, student.sdt_name,student.sdt_year,student.class_name,"+
	 "student.depart_std_id,student_department.depart_std_name" +
	 " FROM student_department INNER JOIN student " +
	 "ON student.depart_std_id = student_department.depart_std_id " +
	 "WHERE student.sdt_name LIKE " + "?" + " OR "+ 
	 "student.sdt_name_kana LIKE " + "?";
	
	private static final String SEACH_HISTORY_OF_TEST_SQL = "SELECT "+
	"STUDENT.SDT_NAME,TEST_LIST.TEST_DAY,TEST_LIST.TEST_SPONSOR,"+
	"TEST_LIST.TEST_NAME,EXAMATION.RESULT"+" FROM STUDENT  INNER JOIN EXAMATION "+
	"ON EXAMATION.SDT_ID = STUDENT.SDT_ID "+ " INNER JOIN TEST_LIST "+
	"ON STUDENT.SDT_ID = STUDENT.SDT_ID " + "WHERE STUDENT.SDT_ID = ?";
	
	private static final int SEACH_HISTORY_OF_TEST_IDX = 1;
	private static final int SEACH_STUDENT_HISTORY_TEST_SDT_NAME_BY_IDX = 1;
	private static final int SEACH_STUDENT_HISTORY_TEST_SDT_NAME_KANA_BY_IDX = 2;
	public SeachTestHistoryStudentResultDTO seachStudentTestlog(String studenkeyword) throws  SystemErrorExcepton, NamingException{
		ResultSet rs = null;
		Dbcontrol db = new Dbcontrol();
		StudentEntity studententity;
		String keyword = studenkeyword;
		StudentDepartmentEntity studentdepartmententity;
		SeachTestHistoryStudentDTO dto = new SeachTestHistoryStudentDTO();
		SeachTestHistoryStudentResultDTO seachtesthistorustudentresult = new SeachTestHistoryStudentResultDTO();
		try {
			
			studenkeyword = makeLikeParameter(studenkeyword);
			db.connect();
			db.prepareStatement(SEACH_STUDENT_HISTORY_TEST_BY_SQL);
			db.setString(SEACH_STUDENT_HISTORY_TEST_SDT_NAME_BY_IDX,studenkeyword);
			db.setString(SEACH_STUDENT_HISTORY_TEST_SDT_NAME_KANA_BY_IDX, studenkeyword);
			rs = db.executeQuery();
			int count = 0;
			while(rs.next()){
				studententity            = new StudentEntity();
				studentdepartmententity  = new StudentDepartmentEntity();
				studententity.setStudentId(rs.getString(StudentEntity.STUDENT_ID));
				studententity.setStudentName(rs.getString(StudentEntity.STUDENT_NAME));
				studententity.setStudentYear(rs.getInt(StudentEntity.STUDENT_YEAR));
				studententity.setStudentClassName(rs.getString(StudentEntity.STUDNET_CLASS_NAME));
				studentdepartmententity.setDepart_sdt_name(rs.getString(StudentDepartmentEntity.DEPARTSDTNAME));
				dto = chageEntityToDto(studententity,studentdepartmententity);
				seachtesthistorustudentresult.add(dto);
				count++;
			}
			seachtesthistorustudentresult.setSearchNum(count);
			seachtesthistorustudentresult.setKeyword(keyword);
			
		} catch (NamingException e) {
			// TODO 自動生成された catch ブロック
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new  NamingException();
		} catch(SQLException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new SystemErrorExcepton();
		}
		return seachtesthistorustudentresult;
	}
	public SeachStudentHistoryTestResultDTO historyoftest(String student_id) throws NamingException, SystemErrorExcepton, SQLException{
		
		ExamationEntity examationentity;
		StudentEntity   studententity;
		TestListEntity testlistentity;
		SeachStudentHistoryTestDTO seachstudenthistorytestdto;
		SeachStudentHistoryTestResultDTO seachstudenthistorytestresultdto  =new SeachStudentHistoryTestResultDTO(); 
		ResultSet rs = null;
		Dbcontrol db = new Dbcontrol();
		try{
			db.connect();
			db.prepareStatement(SEACH_HISTORY_OF_TEST_SQL);
			db.setString(SEACH_HISTORY_OF_TEST_IDX, student_id);
			rs = db.executeQuery();
			int count = 0;
			String name ="";
			while(rs.next()){
				examationentity = new ExamationEntity();
				studententity   = new StudentEntity();
				testlistentity  = new TestListEntity();
				examationentity.setExamationresult(rs.getInt(ExamationEntity.EXAMATIONRESULT));
				studententity.setStudentName(rs.getString(StudentEntity.STUDENT_NAME));
				testlistentity.setTest_day(rs.getDate(TestListEntity.TEST_DAY));
				testlistentity.setTest_sponsor(rs.getString(TestListEntity.TEST_SPONSOR));
				testlistentity.setTest_name(rs.getString(TestListEntity.TEST_NAME));
				seachstudenthistorytestdto= chageEntityToDto(studententity,examationentity,testlistentity);
				seachstudenthistorytestresultdto.add(seachstudenthistorytestdto);
				name = studententity.getStudentName();
				count++; 
			}
			seachstudenthistorytestresultdto.setSearchNum(count);
			seachstudenthistorytestresultdto.setKeyword(name);
			
		} catch (NamingException e) {
			// TODO 自動生成された catch ブロック
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new  NamingException();
		} catch(SQLException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new SystemErrorExcepton();
		} finally{
			// 接続を閉じる
        	if( rs != null ){
				rs.close();
        	}
        	//psとconを閉じる。
    		db.close();
		}
		return seachstudenthistorytestresultdto;
	}
	private String makeLikeParameter(String param){

		//%があった場合を考慮
		StringUtils.replace(param, "%", "\\%");
		//_があった場合を考慮
		StringUtils.replace(param, "_", "\\_");

		return "%"+param+"%";
	}
	private SeachTestHistoryStudentDTO chageEntityToDto(StudentEntity sentity,StudentDepartmentEntity departmententity){
		SeachTestHistoryStudentDTO dto = new SeachTestHistoryStudentDTO();
		dto.setStudent_id(sentity.getStudentId());
		dto.setStudent_name(sentity.getStudentName());
		dto.setClass_name(sentity.getStudentClassName());
		dto.setGrade(sentity.getStudentYear());
		dto.setDepartment(departmententity.getDepart_sdt_name());
		return dto;
	}
	private SeachStudentHistoryTestDTO chageEntityToDto(StudentEntity sentity,ExamationEntity examationentity,TestListEntity testlistentity){
		SeachStudentHistoryTestDTO dto = new SeachStudentHistoryTestDTO();
		dto.setExamationResult(examationentity.getExamationresult());
		dto.setStudentName(sentity.getStudentName());
		dto.setTestDay(testlistentity.getTest_day());
		dto.setTestName(testlistentity.getTest_name());
		dto.setTestSponsor(testlistentity.getTest_sponsor());
		return dto;
	}
}
