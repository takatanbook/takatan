package jp.asojuku.testmanagement.noobentity;

public class ExamationEntity {

	public static String EXAMATION_ID="e.exa_id";
	public static String TEST_NAME="t.test_name";
	public static String SPONSOR ="t.test_sponsor";
	public static String TEST_DAY ="t.test_day";
	public static String RESULT ="e.result";

	public static String TEST_ID="test_id";
	public static String TEST_LIST_NAME="test_name";
	public static String TEST_SPONSOR ="test_sponsor";
	public static String TEST_LIST_DAY ="test_day";


	private Integer examation_id;
	private String test_name;
	private String sponsor;
	private String test_day;
	private Integer result;



	public Integer getExamation_id() {
		return examation_id;
	}
	public void setExamation_id(int id) {
		this.examation_id = id;
	}


	public String getTest_name() {
		return test_name;
	}
	public void setTest_name(String name) {
		this.test_name = name;
	}


	public String getSponsor() {
		return sponsor;
	}
	public void setSponsor(String spon) {
		this.sponsor = spon;
	}


	public String getTest_day() {
		return test_day;
	}
	public void setTest_day(String day) {
		this.test_day = day;
	}


	public Integer getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}

}
