package DTO_Student;
/*
 *  ● 9. 상담 일지 조회
 * 		b. 상담 이후 작성된 일지 조회
 * 
 * 
 * [ 해당 쿼리에서 사용된 테이블 ] 
 * tblstudent
 * tblregicourse
 * tblConsultRequest
 * tblConsultRecord
 * 
 */

public class DTO_ConsultRecode_S {

	private String student_seq; //학생번호
	private String sname; //학생명
	private String requestDate; //상담요청일
	private String recordDate; // 상담일지작성일
	private String requestcontent; //상담요청내용
	private String recordcontent; //상담일지내용
	
	
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
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public String getRequestcontent() {
		return requestcontent;
	}
	public void setRequestcontent(String requestcontent) {
		this.requestcontent = requestcontent;
	}
	public String getRecordcontent() {
		return recordcontent;
	}
	public void setRecordcontent(String recordcontent) {
		this.recordcontent = recordcontent;
	}
	
	
}
