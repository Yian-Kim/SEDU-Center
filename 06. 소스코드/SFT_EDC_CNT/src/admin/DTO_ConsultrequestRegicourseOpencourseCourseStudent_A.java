package admin2_6_7;

public class DTO_ConsultrequestRegicourseOpencourseCourseStudent_A {

	private String rownum; // 상담요청내역에서 학생별 조회에 대한 순서번호
	private String studentName; // 상담요청내역에서 학생별 조회에 대한 학생명
	private String studentTel; // 상담요청내역에서 학생별 조회에 대한 학생 전화번호
	private String studentMajor; // 상담요청내역에서 학생별 조회에 대한 학생 전공
	private String callrequestDate; // 상담요청내역에서 학생별 조회에 대한 상담요청일
	private String callrequestDetails; // 상담요청내역에서 학생별 조회에 대한 상담요청내역
	
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
