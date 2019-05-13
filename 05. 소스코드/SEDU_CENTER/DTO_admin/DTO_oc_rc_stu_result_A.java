package DTO_admin;

public class DTO_oc_rc_stu_result_A {

	/*
	 * 1. 관리자 – 2. 개설 과정 및 과목 관리– 1. (상세보기)
	 * f. 학생 정보
	 * 
	 * tblOpenCourse
	 * tblRegiCourse
	 * tblStudent
	 * tblResult
	 * 
	 */
	
	private String studentName; // 개설과정에 대한 학생 이름
	private String studentPw; // 개설과정에 대한 학생 주민등록번호
	private String studentTel; // 개설과정에 대한 학생 전화번호
	private String studentRegidate; // 개설과정에 대한 학생 등록일
	private String completion; // 개설과정에 대한 학생 수료여부
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentPw() {
		return studentPw;
	}
	public void setStudentPw(String studentPw) {
		this.studentPw = studentPw;
	}
	public String getStudentTel() {
		return studentTel;
	}
	public void setStudentTel(String studentTel) {
		this.studentTel = studentTel;
	}
	public String getStudentRegidate() {
		return studentRegidate;
	}
	public void setStudentRegidate(String studentRegidate) {
		this.studentRegidate = studentRegidate;
	}
	public String getCompletion() {
		return completion;
	}
	public void setCompletion(String completion) {
		this.completion = completion;
	}
	
	
	
}
