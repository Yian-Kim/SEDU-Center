package DTO_admin;

public class DTO_StudentRegicourseConsultrequestOpencourse_A {

	private String rownum; // 교사에 대한 상담요청 순서 번호
	private String studentName; // 교사에 대한 상담요청 한 학생명
	private String studentTel; // 교사에 대한 상담요청 한 학생 전화번호
	private String studentMajor; // 교사에 대한 상담요청 한 학생 전공
	private String callRequestDate; // 교사에 대한 상담요청일
	private String callrequestDetails; // 교사에 대한 상담요청내용
	private String requestNumber; // 교사에 대한 상담요청에 대해서 상담요청 테이블의 pk번호
	
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
	public String getCallrequestDetails() {
		return callrequestDetails;
	}
	public void setCallrequestDetails(String callrequestDetails) {
		this.callrequestDetails = callrequestDetails;
	}
	
	
	
}
