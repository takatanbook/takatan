package jp.asojuku.testmanagement.entity;

public class ManageEntity {
	
	public static String MANAGE_ID         = "manage_id";
	public static String MANAGE_NAME       = "manage_name";
	public static String MANAGE_NAME_KANA  = "manage_name_kana";
	public static String MANAGE_PASS       = "manage_pass";
	public static String MANAGE_MAIL       = "manage_email";
	
	private String  ManageId;
	private String  ManageName;
	private String  ManageNameKana;
	private String  ManageMail;
	
	public String getManageId() {
		return ManageId;
	}
	public void setManageId(String manageId) {
		ManageId = manageId;
	}
	public String getManageName() {
		return ManageName;
	}
	public void setManageName(String manageName) {
		ManageName = manageName;
	}
	public String getManageNameKana() {
		return ManageNameKana;
	}
	public void setManageNameKana(String manageNameKana) {
		ManageNameKana = manageNameKana;
	}
	public String getManageMail() {
		return ManageMail;
	}
	public void setManageMail(String manageMail) {
		ManageMail = manageMail;
	}


}
