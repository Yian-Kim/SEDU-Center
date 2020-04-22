package DTO;

public class DTO_TeacherEval_Q {

	private String evalQ_seq; // 평가문제 번호(PK)
	private String question; // 문제
	private String type_seq; // 유형번호(FK)
	
	public String getEvalQ_seq() {
		return evalQ_seq;
	}
	public void setEvalQ_seq(String evalQ_seq) {
		this.evalQ_seq = evalQ_seq;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getType_seq() {
		return type_seq;
	}
	public void setType_seq(String type_seq) {
		this.type_seq = type_seq;
	}
	
	
	
}
