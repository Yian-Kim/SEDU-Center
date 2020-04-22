package dto_common;

public class DTO_ConsultRecord {

	private String record_seq; // 상담일지 번호(PK)
	private String recordDate; // 상담일시
	private String recordContent; // 상담내용
	private String consult_seq; // 상담요청번호(FK)
	
	public String getRecord_seq() {
		return record_seq;
	}
	public void setRecord_seq(String record_seq) {
		this.record_seq = record_seq;
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
	
	
	
}
