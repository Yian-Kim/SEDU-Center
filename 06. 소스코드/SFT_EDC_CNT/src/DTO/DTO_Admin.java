package DTO;

public class DTO_Admin {

	private String admin_seq; // 관리자계정 번호(PK)
	private String id; // 관리자 이름
	private String pw; // 관리자 주민
	
	public String getAdmin_seq() {
		return admin_seq;
	}
	public void setAdmin_seq(String admin_seq) {
		this.admin_seq = admin_seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
	
}
