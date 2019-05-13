/*

상담일지 조회 #2

학생 테이블 : tblStudent
수강신청 테이블 : tblRegiCourse
상담요청 테이블 : tblConsultRequest
개설과정 테이블 : tblOpenCourse
담당과정 테이블 : tblTeacherCourse
교사 테이블 : tblTeacher
상담일지 테이블 : tblConsultRecord

 */


package DTO_Teacher;

public class DTO_ConsultFinish_T {

	private String student_seq; // 학생번호
	private String studentName; // 학생명
	private String recordDate; // 상담일시
	private String recordContent; // 상담내용
	private String consult_seq; // 상담요청번호
	private String requestContent; // 상담요청내용
	
	public String getStudent_seq() {
		return student_seq;
	}
	public void setStudent_seq(String student_seq) {
		this.student_seq = student_seq;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public String getRecordContent() {
		return recordContent;
	}
	public void setRecordContent(String recordContent) {
		this.recordContent = recordContent;
	}
	public String getConsult_seq() {
		return consult_seq;
	}
	public void setConsult_seq(String consult_seq) {
		this.consult_seq = consult_seq;
	}
	public String getRequestContent() {
		return requestContent;
	}
	public void setRequestContent(String requestContent) {
		this.requestContent = requestContent;
	}
	

}
