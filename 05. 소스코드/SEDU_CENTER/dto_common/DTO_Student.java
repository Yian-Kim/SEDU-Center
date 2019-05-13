package dto_common;

public class DTO_Student {

	private String student_seq; // 학생번호(PK)
	private String name; // 학생이름
	private String pw; // 학생 주민
	private String tel; // 학생 전화번호
	private String regiDate; // 학생 등록일
	private String major; // 학생 전공
	private String numberStudent; // 학생수
	
	
	               
	public String getNumberStudent() {
		return numberStudent;
	}
	public void setNumberStudent(String numberStudent) {
		this.numberStudent = numberStudent;
	}
	public String getStudent_seq() {
		return student_seq;
	}
	public void setStudent_seq(String student_seq) {
		this.student_seq = student_seq;
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
	public String getRegiDate() {
		return regiDate;
	}
	public void setRegiDate(String regiDate) {
		this.regiDate = regiDate;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	
	
}
