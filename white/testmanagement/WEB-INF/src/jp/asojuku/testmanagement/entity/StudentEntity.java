package jp.asojuku.testmanagement.entity;

import java.sql.Date;

public class StudentEntity {
	
	public static String STUDENT_ID         = "sdt_id";
	public static String STUDENT_MAIL       = "sdt_email";
	public static String STUDENT_NAME       = "sdt_name";
	public static String STUDENT_NAME_KANA   = "sdt_name_kana";
	public static String STUDENT_PASS       = "sdt_passwd";
	public static String STUDENT_BIRTH      = "sdt_birth";
	public static String DEPART_ID          = "depart_std_id";
	public static String STUDENT_YEAR       = "sdt_year";
	public static String STUDNET_CLASS_NAME  = "class_name";
	public static String STUDENT_EXIST_FLG   = "exist_flg";
	
	private String  StudentId;
	private String  StudentMail;
	private String  StudentName;
	private String  StudentNameKana;
	private Date    StudentBirth;
	private String  DepartId;
	private Integer StudentYear;
	private String  StudentClassName;
	private Integer StudentExistFlg;
	
	public String getStudentId() {
		return StudentId;
	}
	public void setStudentId(String studentId) {
		StudentId = studentId;
	}
	public String getStudentMail() {
		return StudentMail;
	}
	public void setStudentMail(String studentMail) {
		StudentMail = studentMail;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getStudentNameKana() {
		return StudentNameKana;
	}
	public void setStudentNameKana(String studetNameKana) {
		StudentNameKana = studetNameKana;
	}
	public Date getStudentBirth() {
		return StudentBirth;
	}
	public void setStudentBirth(Date studentBirth) {
		StudentBirth = studentBirth;
	}
	public String getDepartId() {
		return DepartId;
	}
	public void setDepartId(String departId) {
		DepartId = departId;
	}
	public Integer getStudentYear() {
		return StudentYear;
	}
	public void setStudentYear(Integer  studentYear) {
		StudentYear = studentYear;
	}
	public String getStudentClassName() {
		return StudentClassName;
	}
	public void setStudentClassName(String studentClassName) {
		StudentClassName = studentClassName;
	}
	public Integer getStudentExistFlg() {
		return StudentExistFlg;
	}
	public void setStudentExistFlg(Integer studentExistFlg) {
		StudentExistFlg = studentExistFlg;
	}
	
}
