package DTO_admin;

public class DTO_record_request_rc_stu_oc_tc_t_A {

	/*
	 * 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역 - a. 일괄 조회 및 수정
	 * 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역 - b. 교사별 조회 및 수정 - 1. 선택
	 * 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역 - c. 학생별 조회 및 수정 - 검색, 조회 및 수정
	 * 
	 * tblConsultRecord
	 * tblConsultRequest
	 * tblRegiCourse
	 * tblStudent
	 * tblOpenCourse
	 * tblTeacherCourse
	 * tblTeacher
	 * 
	 */
	
	private String record_seq; // 상담일지내역에 대한 순서번호
	private String consultationDate; // 상담일지내역에 대한 상담일시
	private String teacherName; // 상담일지내역에 대한 교사명
	private String studentName; // 상담일지내역에 대한 학생명
	private String callrequestDetails; // 상담일지내역에 대한 상담요청내용
	private String contentsConsultation; // 상담일지내역에 대한 상담내용
	private String requestNum; // 상담일지내역에 대한 상담요청번호
	
	
	
	public String getRecord_seq() {
		return record_seq;
	}
	public void setRecord_seq(String record_seq) {
		this.record_seq = record_seq;
	}
	public String getRequestNum() {
		return requestNum;
	}
	public void setRequestNum(String requestNum) {
		this.requestNum = requestNum;
	}
	public String getConsultationDate() {
		return consultationDate;
	}
	public void setConsultationDate(String consultationDate) {
		this.consultationDate = consultationDate;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getCallrequestDetails() {
		return callrequestDetails;
	}
	public void setCallrequestDetails(String callrequestDetails) {
		this.callrequestDetails = callrequestDetails;
	}
	public String getContentsConsultation() {
		return contentsConsultation;
	}
	public void setContentsConsultation(String contentsConsultation) {
		this.contentsConsultation = contentsConsultation;
	}
	
	
	
}
