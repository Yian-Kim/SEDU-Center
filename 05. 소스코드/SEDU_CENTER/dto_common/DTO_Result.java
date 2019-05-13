package dto_common;

public class DTO_Result {

	private String result_seq; // 수료여부 번호(PK)
	private String state; // 수료여부
	private String finalDate; // 수료/중도탈락 날짜
	private String regiCourse_seq; // 수강신청번호(FK)
	
	public String getResult_seq() {
		return result_seq;
	}
	public void setResult_seq(String result_seq) {
		this.result_seq = result_seq;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(String finalDate) {
		this.finalDate = finalDate;
	}
	public String getRegiCourse_seq() {
		return regiCourse_seq;
	}
	public void setRegiCourse_seq(String regiCourse_seq) {
		this.regiCourse_seq = regiCourse_seq;
	}
	
	
	
}
