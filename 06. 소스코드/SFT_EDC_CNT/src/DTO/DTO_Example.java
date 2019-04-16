package DTO;

public class DTO_Example {

	private String example_seq; // 보기 번호(PK)
	private String content; // 보기 내용
	private String numberExample;
	
	
	
	public String getNumberExample() {
		return numberExample;
	}
	public void setNumberExample(String numberExample) {
		this.numberExample = numberExample;
	}
	public String getExample_seq() {
		return example_seq;
	}
	public void setExample_seq(String example_seq) {
		this.example_seq = example_seq;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
