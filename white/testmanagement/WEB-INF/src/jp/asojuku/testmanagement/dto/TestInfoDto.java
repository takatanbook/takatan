package jp.asojuku.testmanagement.dto;
import java.io.Serializable;
import java.util.Date;
public class TestInfoDto implements Serializable
{
	//実施日
	private Date ExaminationDate;
	//主催者
	private String Sponsor;
	//検定名
	private String TestName;
	private String TestId;
	
	public String getTestId() {
		return TestId;
	}
	public void setTestId(String testId) {
		TestId = testId;
	}
	public Date getExaminationDate() {
		return ExaminationDate;
	}
	public void setExaminationDate(Date examinationDate) {
		ExaminationDate = examinationDate;
	}
	public String getSponsor() {
		return Sponsor;
	}
	public void setSponsor(String sponsor) {
		Sponsor = sponsor;
	}
	public String getTestName() {
		return TestName;
	}
	public void setTestName(String testName) {
		TestName = testName;
	}
	
	
}
