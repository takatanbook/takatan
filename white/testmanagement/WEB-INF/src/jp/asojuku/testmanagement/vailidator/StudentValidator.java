package jp.asojuku.testmanagement.vailidator;

import java.util.ArrayList;
import java.util.List;

import jp.asojuku.testmanagement.dto.SeachTestHistoryStudentDTO;

public class StudentValidator {
	private  String mailFormat = "^[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+(\\.[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+)*+(.*)@[a-zA-Z0-9][a-zA-Z0-9\\-]*(\\.[a-zA-Z0-9\\-]+)+$";
	public List<String> Studentvalidator(SeachTestHistoryStudentDTO dto,String email,String pass,String pass2,String flg){
		List<String> errors = new ArrayList<String>();
		errors = sdtEmail(email,errors);
		errors = sdtPasswd(pass,pass2,errors);
		errors = sdtName(dto.getStudent_name(),errors);
		errors = sdtNamekana(dto.getStudent_huri_name(),errors);
		errors = sdtId(dto.getStudent_id(), errors);
		errors = Birth(dto.getStudent_date(),errors);
		errors = departName(dto.getDepartment(),errors);
		errors = className(dto.getClass_name(),errors);
		errors = existFlg(flg,errors);
		
		return errors;
	}
	public List<String> sdtEmail(String sdt_email ,List<String> err) {
		
		if (sdt_email == null || sdt_email.trim().isEmpty() ||
				!sdt_email.matches(mailFormat)) {
			err.add("メールアドレスは必ず正しく入力してください。");
			return err;
			
		}
		return err;
	}

	public List<String> sdtPasswd(String sdt_passwd,String sdt_passwd_confirm, List<String> err) {
		
		if (sdt_passwd == null || sdt_passwd.trim().isEmpty() ||
				sdt_passwd.length() > 20 || sdt_passwd_confirm == null || sdt_passwd_confirm.trim().isEmpty() ||
				sdt_passwd_confirm.length() > 20 || !sdt_passwd.equals(sdt_passwd_confirm)) {
			err.add("パスワードは必ず20桁以内で入力してください。");
			return err;
		}
		return err;
	}

	public List<String> sdtName(String sdt_name ,List<String> err) {
		
		if (sdt_name == null || sdt_name.trim().isEmpty() ||
				sdt_name.length() > 15) {
			err.add("氏名は必ず15桁以内で入力してください。");
			return err;
		}
		return err;
	}
	public List<String> sdtNamekana(String sdt_name_kana ,List<String> err) {
		
		if (sdt_name_kana == null || sdt_name_kana.trim().isEmpty() ||
				sdt_name_kana.length() > 15) {
			err.add("フリガナは必ず15桁以内で入力してください。");
			return err;
		}
		return err;
	}

	public List<String> sdtId(String sdt_id,List<String> err) {
		
		if (sdt_id == null || sdt_id.trim().isEmpty() || sdt_id.length() != 7) {
			err.add("学籍番号は必ず正しく入力してください。");
			return err;
		} else {
			try {
				Integer.parseInt(sdt_id);
			} catch (NumberFormatException e) {
				err.add("学籍番号は数字を入力してください。");
				return err;
			}
		}
		return err;
	}

	public List<String> Birth(String birth_year ,List<String> err) {
		
		if (birth_year == null || birth_year.trim().isEmpty()) {
			err.add("誕生日は必ず入力してください。");
			return err;
		}
		return err;
	}

	

	public List<String> departName(String depart_name ,List<String> err) {
		
		if (depart_name == null || depart_name.trim().isEmpty()) {
			err.add("学科は必ず入力してください。");
			return err;
		}
		return err;
	}

	public List<String> sdtYear(String sdt_year ,List<String> err) {
		
		if (sdt_year == null || sdt_year.trim().isEmpty()) {
			err.add("学年は必ず入力してください。");
			return err;
		}
		return err;
	}

	public  List<String> className(String class_name ,List<String> err) {
		
		if (class_name == null || class_name.trim().isEmpty()) {
			err.add("クラスは必ず入力してください。");
			return err;
		}
		return err;
	}

	public List<String> existFlg(String exist_flg ,List<String> err) {
		
		if (exist_flg == null || exist_flg.trim().isEmpty()) {
			err.add("在学フラグは必ず入力してください。");
			return err;
		}
		return err;
	}
}