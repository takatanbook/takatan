package jp.asojuku.testmanagement.entity;
import java.sql.Date;
public class TestListEntity {
	public static String TEST_DAY     = "test_day"; 
	public static String TEST_SPONSOR = "test_sponsor";
	public static String TEST_NAME    = "test_name";
	public static String TEST_ID      = "test_id";
	
	private Date test_day;
	private String test_sponsor;
	private String test_name;
	private String test_id;
	
	public String getTest_id() {
		return test_id;
	}
	public void setTest_id(String test_id) {
		this.test_id = test_id;
	}
	public Date getTest_day() {
		return test_day;
	}
	public void setTest_day(Date test_day) {
		this.test_day = test_day;
	}
	public String getTest_sponsor() {
		return test_sponsor;
	}
	public void setTest_sponsor(String test_sponsor) {
		this.test_sponsor = test_sponsor;
	}
	public String getTest_name() {
		return test_name;
	}
	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}
}
