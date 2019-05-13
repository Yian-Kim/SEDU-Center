package DTO_Student;
/*
 * ● 8. 특정학생의 상담신청
 * 예) 이다현 학생의 담당교사는 박세인 교사로 정해져있음 > 상담 신청 시 자동적으로 박세인 교사 앞으로 상담이 신청됨 
 *
 *
 * [ 해당 쿼리에서 사용된 테이블 ]
 * tblstudent
 * tblregicourse
 * tblConsultRequest
 * tblOpenCourse
 * tblTeacherCourse
 * tblTeacher
 * 
 */

public class DTO_ConsultRequest_S {

	private String student_seq; //학생번호
	private String sname; //학생명
	private String requestDate; //상담요청일
	private String requestContent; //상담내용

	
	public String getStudent_seq() {
		return student_seq;
	}
	public void setStudent_seq(String student_seq) {
		this.student_seq = student_seq;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
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
	
}
