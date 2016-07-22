package jp.asojuku.testmanagement.vailidator;

import java.util.ArrayList;
import java.util.List;

public class TestValidator {
	public  List<String> testvalidator(String test_date,String test_name,String test_sponsor){
		List<String> errors = new ArrayList<String>();
		errors = testDate(test_date,errors);
		errors = testName(test_name,errors);
		errors = testSponsor(test_sponsor,errors);
		return errors;
	}
	public List<String> testDate(String test_date ,List<String> err) {
		
		if (test_date == null || test_date.trim().isEmpty()) {
			err.add("学年は必ず入力してください。");
			return err;
		}
		return err;
	}
	public List<String> testName(String test_name ,List<String> err) {
		
		if (test_name == null || test_name.trim().isEmpty()) {
			err.add("学年は必ず入力してください。");
			return err;
		}
		return err;
	}
	public List<String> testSponsor(String test_sponsor ,List<String> err) {
		
		if (test_sponsor == null || test_sponsor.trim().isEmpty()) {
			err.add("学年は必ず入力してください。");
			return err;
		}
		return err;
	}
}
