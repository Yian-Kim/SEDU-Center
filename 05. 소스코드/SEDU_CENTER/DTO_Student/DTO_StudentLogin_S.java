package DTO_Student;
/*
 *  ● 1. 학생 로그인
 * 
 * [ 해당 쿼리에서 사용된 테이블 ] 
 * tblstudent
 * 
 */

public class DTO_StudentLogin_S {

	private String name;
	private String pw;
	private String student_seq;
	
	
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
	
}
