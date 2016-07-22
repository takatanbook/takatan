package jp.asojuku.testmanagement.dto;

import java.io.Serializable;

public class LogonInfoDTO implements Serializable {
	
	private String id;
	private String name;
	private int authority;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}
}
