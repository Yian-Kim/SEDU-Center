package dto_common;

public class DTO_Teacher {

	private String teacher_Seq; // 교사 번호(PK)
	private String name; // 교사 이름
	private String pw; // 교사 주민
	private String tel; // 교사 전화번호
	private String numberTeachers; // 교사 수
	
	public String getNumberTeachers() {
		return numberTeachers;
	}
	public void setNumberTeachers(String numberTeachers) {
		this.numberTeachers = numberTeachers;
	}
	public String getTeacher_Seq() {
		return teacher_Seq;
	}
	public void setTeacher_Seq(String teacher_Seq) {
		this.teacher_Seq = teacher_Seq;
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
