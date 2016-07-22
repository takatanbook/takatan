package jp.asojuku.testmanagement.entity;

public class StudentDepartmentEntity {
	public static final String DEPARTSDTID = "depart_std_id";
	public static final String DEPARTSDTNAME = "depart_std_name";
	public static final String DEPARTSDTYEAR = "depart_std_year";
	private String depart_sdt_id;
	private String depart_sdt_name;
	private int    depart_sdt_year;
	public String getDepart_sdt_id() {
		return depart_sdt_id;
	}
	public void setDepart_sdt_id(String depart_sdt_id) {
		this.depart_sdt_id = depart_sdt_id;
	}
	public String getDepart_sdt_name() {
		return depart_sdt_name;
	}
	public void setDepart_sdt_name(String depart_sdt_name) {
		this.depart_sdt_name = depart_sdt_name;
	}
	public int getDepart_sdt_year() {
		return depart_sdt_year;
	}
	public void setDepart_sdt_year(int depart_sdt_year) {
		this.depart_sdt_year = depart_sdt_year;
	}
	
}
