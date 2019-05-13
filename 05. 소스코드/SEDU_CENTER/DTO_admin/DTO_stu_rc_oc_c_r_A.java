package DTO_admin;

public class DTO_stu_rc_oc_c_r_A {

	/*
	 * -- 1. 관리자 – 5. 출결 관리 및 출결조회 - a. 학생별 조회 및 수정
	 * 
	 * tblStudent
	 * tblRegiCourse
	 * tblOpenCourse
	 * tblCourse
	 * tblRoom
	 * 
	 */
	
	private String student_seq; // 조회한 학생번호
	private String studentName; // 조회한 학생이름
	private String studentPw; // 조회한 학생 주민뒷자리
	private String courseName; // 조회한 학생이 듣고있는(들었던) 과정명
	private String courseDuration; // 조회한 학생이 듣고있는(들었던) 과정기간
	private String className; // 조회한 학생이 듣고있는(들었던) 강의실명
	
	public String getStudent_seq() {
		return student_seq;
	}
	public void setStudent_seq(String student_seq) {
		this.student_seq = student_seq;
	}
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
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	
	
	
}
