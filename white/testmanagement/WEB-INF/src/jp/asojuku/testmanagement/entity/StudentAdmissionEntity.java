package jp.asojuku.testmanagement.entity;

import java.sql.Date;

public class StudentAdmissionEntity {
	private Integer AdmissionYear;
	private String SdtId;
	private Date SdtAdmissionDay;
	private Date SdtGraduateDay;
	public Integer getAdmissionYear() {
		return AdmissionYear;
	}
	public void setAdmissionYear(Integer admissionYear) {
		AdmissionYear = admissionYear;
	}
	public Date getSdtAdmissionDay() {
		return SdtAdmissionDay;
	}
	public void setSdtAdmissionDay(Date sdtAdmissionDay) {
		SdtAdmissionDay = sdtAdmissionDay;
	}
	public Date getSdtGraduateDay() {
		return SdtGraduateDay;
	}
	public void setSdtGraduateDay(Date sdtGraduateDay) {
		SdtGraduateDay = sdtGraduateDay;
	}
	public int getSdtDropoutStatu() {
		return SdtDropoutStatu;
	}
	public void setSdtDropoutStatu(int sdtDropoutStatu) {
		SdtDropoutStatu = sdtDropoutStatu;
	}
	private int  SdtDropoutStatu;
	public String getSdtId() {
		return SdtId;
	}
	public void setSdtId(String sdtId) {
		SdtId = sdtId;
	}
	
}
