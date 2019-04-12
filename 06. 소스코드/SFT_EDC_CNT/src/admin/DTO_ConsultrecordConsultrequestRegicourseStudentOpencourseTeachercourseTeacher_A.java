package admin2_6_7;

public class DTO_ConsultrecordConsultrequestRegicourseStudentOpencourseTeachercourseTeacher_A {

	private String rownum; // 상담일지내역에 대한 순서번호
	private String consultationDate; // 상담일지내역에 대한 상담일시
	private String teacherName; // 상담일지내역에 대한 교사명
	private String studentName; // 상담일지내역에 대한 학생명
	private String callrequestDetails; // 상담일지내역에 대한 상담요청내용
	private String contentsConsultation; // 상담일지내역에 대한 상담내용
	private String requestNum; // 상담일지내역에 대한 상담요청번호
	
	
	
	public String getRequestNum() {
		return requestNum;
	}
	public void setRequestNum(String requestNum) {
		this.requestNum = requestNum;
	}
	public String getRownum() {
		return rownum;
	}
	public void setRownum(String rownum) {
		this.rownum = rownum;
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
