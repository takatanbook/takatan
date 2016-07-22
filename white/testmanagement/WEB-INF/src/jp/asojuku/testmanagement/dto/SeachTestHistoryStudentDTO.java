package jp.asojuku.testmanagement.dto;

public class SeachTestHistoryStudentDTO {
	//学科
	private String department;
	//学年
	private int grade;
	//クラス名
	private String class_name;
	//学生氏名
	private String student_name;
	//学生ふりがな
	private String student_huri_name;
	
	//学生番号
	private String student_id;
	
	//学生生年月日
	private String student_date;
	
	public String getStudent_huri_name() {
		return student_huri_name;
	}
	public void setStudent_huri_name(String student_huri_name) {
		this.student_huri_name = student_huri_name;
	}
	
	public String getStudent_date() {
		return student_date;
	}
	public void setStudent_date(String student_date) {
		this.student_date = student_date;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	
}
