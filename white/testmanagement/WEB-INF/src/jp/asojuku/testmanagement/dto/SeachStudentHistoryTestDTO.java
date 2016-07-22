package jp.asojuku.testmanagement.dto;

import java.util.Date;

public class SeachStudentHistoryTestDTO {
	
	private String studentName;
	private Date   testDay;
	private String testSponsor;
	private String testName;
	private int examationResult;
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Date getTestDay() {
		return testDay;
	}
	public void setTestDay(Date testDay) {
		this.testDay = testDay;
	}
	public String getTestSponsor() {
		return testSponsor;
	}
	public void setTestSponsor(String testSponsor) {
		this.testSponsor = testSponsor;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public int getExamationResult() {
		return examationResult;
	}
	public void setExamationResult(int examationResult) {
		this.examationResult = examationResult;
	}
}
