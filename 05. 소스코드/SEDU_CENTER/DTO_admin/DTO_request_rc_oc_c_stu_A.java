package DTO_admin;

public class DTO_request_rc_oc_c_stu_A {
	
	/*
	 * 1. 관리자 – 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 – c. 학생별 조회 및 수정 – 검색 – 검색, 조회 및 수정
	 * 
	 * tblConsultRequest
	 * tblRegiCourse
	 * tblOpenCourse
	 * tblCourse
	 * tblStudent
	 * 
	 */

	private String consult_Seq; // 상담요청내역에서 학생별 조회에 대한 순서번호
	private String studentName; // 상담요청내역에서 학생별 조회에 대한 학생명
	private String studentTel; // 상담요청내역에서 학생별 조회에 대한 학생 전화번호
	private String studentMajor; // 상담요청내역에서 학생별 조회에 대한 학생 전공
	private String callrequestDate; // 상담요청내역에서 학생별 조회에 대한 상담요청일
	private String callrequestDetails; // 상담요청내역에서 학생별 조회에 대한 상담요청내역
	
	public String getconsult_Seq() {
		return consult_Seq;
	}
	public void setconsult_Seq(String consult_Seq) {
		this.consult_Seq = consult_Seq;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
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
	public String getCallrequestDate() {
		return callrequestDate;
	}
	public void setCallrequestDate(String callrequestDate) {
		this.callrequestDate = callrequestDate;
	}
	public String getCallrequestDetails() {
		return callrequestDetails;
	}
	public void setCallrequestDetails(String callrequestDetails) {
		this.callrequestDetails = callrequestDetails;
	}
	
	
	
}
