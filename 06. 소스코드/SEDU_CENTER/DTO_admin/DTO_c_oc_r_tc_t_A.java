package DTO_admin;

public class DTO_c_oc_r_tc_t_A {

	/*
	 * 1. 관리자 - 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 - b. 과정별 조회 및 수정
	 * -- 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역 - b. 교사별 조회 및 수정
	 * -- 1. 관리자 – 5. 출결 관리 및 출결조회 - b. 과정별 조회
	 * 
	 * tblCourse
	 * tblOpenCourse
	 * tblRoom
	 * tblTeacherCourse
	 * tblTeacher
	 * 
	 */
	
	private String rownum; // 상담 요청 내역의 교사별 조회 순서 번호
	private String courseName; // 상담 요청 내역의 교사별 조회 과정명
	private String coureseDuration;// 상담 요청 내역의 교사별 조회 과정기간
	private String teacherName;// 상담 요청 내역의 교사별 조회 교사명
	private String className;// 상담 요청 내역의 교사별 조회 강의실명
	private String teacherNum; // 상담 요청 내역의 교사별 조회 교사번호
	private String openCourseNum; // 상담 요청 내역의 교사별 조회 개설과정번호
	private String opencourse_seq; // 상담일지 내역의 개설과정번호
	
	public String getOpencourse_seq() {
		return opencourse_seq;
	}
	public void setOpencourse_seq(String opencourse_seq) {
		this.opencourse_seq = opencourse_seq;
	}
	
	
	public String getTeacherNum() {
		return teacherNum;
	}
	public void setTeacherNum(String teacherNum) {
		this.teacherNum = teacherNum;
	}
	public String getOpenCourseNum() {
		return openCourseNum;
	}
	public void setOpenCourseNum(String openCourseNum) {
		this.openCourseNum = openCourseNum;
	}
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
	public String getCoureseDuration() {
		return coureseDuration;
	}
	public void setCoureseDuration(String coureseDuration) {
		this.coureseDuration = coureseDuration;
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
