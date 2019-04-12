package admin2_6_7;

public class DTO_StudentRegicourseConsultrequest_A {

	private String rownum; // 상담요청 내역 - 학생별 조회 및 수정에 대한 순서 번호
	private String studentName; // 상담요청 내역 - 학생별 조회 및 수정에 대한 학생명
	private String studentPw; // 상담요청 내역 - 학생별 조회 및 수정에 대한 학생 주민번호
	private String studentTel; // 상담요청 내역 - 학생별 조회 및 수정에 대한 학생 전화번호
	private String callrequestDate; // 상담요청 내역 - 학생별 조회 및 수정에 대한 학생 등록일
	private String studentMajor; // 상담요청 내역 - 학생별 조회 및 수정에 대한 학생 전공
	private String requestNumber; // 상담요청 내역 - 학생별 조회 및 수정에 대한 상담요청 번호(PK)
	
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
	public String getCallrequestDate() {
		return callrequestDate;
	}
	public void setCallrequestDate(String callrequestDate) {
		this.callrequestDate = callrequestDate;
	}
	public String getStudentMajor() {
		return studentMajor;
	}
	public void setStudentMajor(String studentMajor) {
		this.studentMajor = studentMajor;
	}
	public String getRequestNumber() {
		return requestNumber;
	}
	public void setRequestNumber(String requestNumber) {
		this.requestNumber = requestNumber;
	}
	
	
	
}
