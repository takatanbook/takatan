package jp.asojuku.testmanagement.entity;

public class ExamationEntity {
	
	public static final String EXAMATIONID  	= "exa_id";
	public static final String STUDENTID    	= "sdt_id";
	public static final String TESTID       	= "test_id";
	public static final String EXAMATIONRESULT  = "result";
	
	private int    examationId;
	private String studentId;
	private int    testId;
	private int    examationresult;
	
	public int getExamationId() {
		return examationId;
	}
	public void setExamationId(int examationId) {
		this.examationId = examationId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public int getExamationresult() {
		return examationresult;
	}
	public void setExamationresult(int examationresult) {
		this.examationresult = examationresult;
	}
}
