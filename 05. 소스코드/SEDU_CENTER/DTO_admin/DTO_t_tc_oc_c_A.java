package DTO_admin;

public class DTO_t_tc_oc_c_A {

	/*
	 * 1. 관리자 - 6. 교사 평가 관리 및 결과 조회 - c. 교사 평가 결과 조회 및 삭제
	 * 
	 * tblTeacher
	 * tblTeacherCourse
	 * tblOpenCourse
	 * tblCourse
	 */
	
	private String OpenCourse_seq; // 개설과정 번호
	private String courseName; // 교사평가에서 평가한 과정명
	private String teacherName; // 교사평가에서 평가한 교사명
	private String answerVariables; // 교사평가 답변수
	
	public String getOpenCourse_seq() {
		return OpenCourse_seq;
	}
	public void setOpenCourse_seq(String openCourse_seq) {
		OpenCourse_seq = openCourse_seq;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getAnswerVariables() {
		return answerVariables;
	}
	public void setAnswerVariables(String answerVariables) {
		this.answerVariables = answerVariables;
	}
	
	
	
	
}
