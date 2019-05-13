package DTO_admin;

public class DTO_ViewOpenCourse_A {
	
	/*
	 * 1. 관리자 - 4. 성적 조회 - a. 과정별 성적 조회
	 * 개설과정 보여줌(개설과정 PK를 넘김)
	 * 
	 * [해당 쿼리에서 사용된 테이블]
	 * tblCourse
	 * tblOpenCourse
	 * tblRoom
	 * tblTeacherCourse
	 * tblTeacher
	 */
	
	private String openCourse_seq; // 과정번호(PK) 
	private String courseName; // 개설된 과정명
	private String courseDuration; // 과정기간
	private String teacherName; // 교사명
	private String className; // 강의실이름
	
	
	public String getOpenCourse_seq() {
		return openCourse_seq;
	}
	public void setOpenCourse_seq(String openCourse_seq) {
		this.openCourse_seq = openCourse_seq;
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
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	
}
