/*

상담일지 조회 #1

학생 테이블 : tblStudent
수강신청 테이블 : tblRegiCourse
상담요청 테이블 : tblConsultRequest
개설과정 테이블 : tblOpenCourse
담당과정 테이블 : tblTeacherCourse
교사 테이블 : tblTeacher

 */

package DTO_Teacher;

public class DTO_Consult_T {

	private String student_seq; // 학생번호
	private String studentName; // 학생명
	private String major; // 학과(전공)
	private String requestDate; // 요청날짜
	private String requestContent; // 요청내용
	private String consult_seq; //상담 요청 번호
	
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
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public String getRequestContent() {
		return requestContent;
	}
	public void setRequestContent(String requestContent) {
		this.requestContent = requestContent;
	}
	public String getConsult_seq() {
		return consult_seq;
	}
	public void setConsult_seq(String consult_seq) {
		this.consult_seq = consult_seq;
	}
	
	
}
