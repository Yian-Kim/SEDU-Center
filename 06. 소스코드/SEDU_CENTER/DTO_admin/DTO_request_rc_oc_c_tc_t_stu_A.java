package DTO_admin;

public class DTO_request_rc_oc_c_tc_t_stu_A {

	/*
	 * 1. 관리자 - 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 - a. 일괄 조회 및 수정
	 * 
	 * tblConsultRequest
	 * tblRegiCourse
	 * tblOpenCourse
	 * tblCourse
	 * tblTeacherCourse
	 * tblTeacher
	 * tblStudent
	 */
	
	private String rownum; // 상담요청내역에 대한 출력번호
	private String studentName; // 상담요청내역에 대한 해당 학생명
	private String teacherName; // 상담요청내역에 대한 해당 교사명
	private String courseName; // 상담요청내역에 대한 해당 과정명
	private String studentTel; // 상담요청내역에 대한 해당 학생 전화번호
	private String studentMajor; // 상담요청내역에 대한 해당 학생 전공
	private String callRequestDate; // 상담요청에 대한 상담요청일
	private String callRequestDetails; // 상담요청에 대한 상담요청내용
	
	public String getRownum() {
		return rownum;
	}
	public void setRownum(String rownum) {
		this.rownum = rownum;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getStudentTel() {
		return studentTel;
	}
	public void setStudentTel(String studentTel) {
		this.studentTel = studentTel;
	}
	public String getStudentMajor() {
		return studentMajor;
	}
	public void setStudentMajor(String studentMajor) {
		this.studentMajor = studentMajor;
	}
	public String getCallRequestDate() {
		return callRequestDate;
	}
	public void setCallRequestDate(String callRequestDate) {
		this.callRequestDate = callRequestDate;
	}
	public String getCallRequestDetails() {
		return callRequestDetails;
	}
	public void setCallRequestDetails(String callRequestDetails) {
		this.callRequestDetails = callRequestDetails;
	}
	
	
	
}
