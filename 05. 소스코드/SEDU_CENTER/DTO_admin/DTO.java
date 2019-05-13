package DTO_admin;
public class DTO {

	private String Teacher_seq;
	private String name;
	private String pw;
	private String tel;
	private String tAvlSubject;
	
	public String gettAvlSubject() {
		return tAvlSubject;
	}
	public void settAvlSubject(String tAvlSubject) {
		this.tAvlSubject = tAvlSubject;
	}
	public String getTeacher_seq() {
		return Teacher_seq;
	}
	public void setTeacher_seq(String teacher_seq) {
		Teacher_seq = teacher_seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	


}
