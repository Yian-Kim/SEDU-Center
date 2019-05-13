package DTO;

public class DTO_Type {

	private String type_seq; // 유형번호(PK)
	private String type; // 유형(주관식인지 객관식인지)
	
	public String getType_seq() {
		return type_seq;
	}
	public void setType_seq(String type_seq) {
		this.type_seq = type_seq;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
