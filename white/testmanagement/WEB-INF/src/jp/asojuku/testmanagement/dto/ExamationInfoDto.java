package jp.asojuku.testmanagement.dto;

import java.util.ArrayList;

public class ExamationInfoDto {

	private ArrayList<Integer> examation_id = new ArrayList<Integer>();
	private ArrayList<String> test_name = new ArrayList<String>();
	private ArrayList<String> sponsor = new ArrayList<String>();
	private ArrayList<String> test_day = new ArrayList<String>();
	private ArrayList<Integer> result = new ArrayList<Integer>();



	public ArrayList<Integer> getExamationId() {
		return examation_id;
	}
	public void setExamationId(int id) {
		this.examation_id.add(id);
	}


	public ArrayList<String> getTestName() {
		return test_name;
	}
	public void setTestName(String name) {
		this.test_name.add(name);
	}


	public ArrayList<String> getSponsor() {
		return sponsor;
	}
	public void setSponsor(String spon) {
		this.sponsor.add(spon);
	}


	public ArrayList<String> getTestDay() {
		return test_day;
	}
	public void setTestDay(String day) {
		this.test_day.add(day);
	}


	public ArrayList<Integer> getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result.add(result);
	}

}
