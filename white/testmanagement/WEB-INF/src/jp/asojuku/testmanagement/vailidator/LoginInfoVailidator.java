package jp.asojuku.testmanagement.vailidator;

public class LoginInfoVailidator {
	
	//学校の管理者用のメールアドレスの正規表現
	private static String ManagerMail = "[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+(\\.[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+)*+(.*)@asojuku.ac.jp";
	
	//学校の学生用のメールアドレスの正規表現
	private static String StudentMail = "[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+(\\.[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+)*+(.*)@st.asojuku.ac.jp";
	
	public static final int MANAGE_INFO_IDX  = 1;
	public static final int STUDENT_INFO_IDX = 2;
	public static final int ILLEGAL_IND      = 3; 
	//管理者か学生を判定する(1は、管理者-2は、生徒-３は、不正)
	public static int MailCheck(String mail){
		int n;
		
		if (mail.matches(ManagerMail)) {
		  n =  MANAGE_INFO_IDX;
		} else if(mail.matches(StudentMail)){
		  n = STUDENT_INFO_IDX;
		}else{
		  n = ILLEGAL_IND;
		}
		return n;
	}

}