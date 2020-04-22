package DTO_admin;

public class DTO_oc_c_r_A {     
	
	/*
	 * 1. 관리자 – 2. 개설 과정 및 과목 관리(개설과정PK 번호 받아옴)
	 * a. 과정명
	 * 
	 * tblOpenCourse
	 * tblCourse
	 * tblRoom
	 */

	private String rownum; // 개설 과정 및 과목 관리의 순서번호
	private String courseName; // 개설 과정에 대한 과정명
	private String courseduration; // 개설 과정에 대한 기간
	private String className; // 개설 과정에 대한 해당 강의실명
	private String subjectRegistration; // 개설 과정에 대한 과목 등록여부
	private String studentNum; // 개설 과정에 대한 등록 학생수
	
	public String getRownum() {
		return rownum;
	}
	public void setRownum(String rownum) {
		this.rownum = rownum;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseduration() {
		return courseduration;
	}
	public void setCourseduration(String courseduration) {
		this.courseduration = courseduration;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getSubjectRegistration() {
		return subjectRegistration;
	}
	public void setSubjectRegistration(String subjectRegistration) {
		this.subjectRegistration = subjectRegistration;
	}
	public String getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}
	
	
	
}
