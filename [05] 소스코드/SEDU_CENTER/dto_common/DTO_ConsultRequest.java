package dto_common;

public class DTO_ConsultRequest {

	private String consult_seq; // 상담요청 번호(PK)
	private String requestDate; // 요청날짜
	private String requestContent; // 요청내용
	private String regiCourse_seq; // 수강신청번호(FK)
	
	public String getConsult_seq() {
		return consult_seq;
	}
	public void setConsult_seq(String consult_seq) {
		this.consult_seq = consult_seq;
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
	public String getRegiCourse_seq() {
		return regiCourse_seq;
	}
	public void setRegiCourse_seq(String regiCourse_seq) {
		this.regiCourse_seq = regiCourse_seq;
	}
	
	
	
}
