package dto_common;

public class DTO_TeacherEval_Q {

	private String evalQ_seq; // 평가문제 번호(PK)
	private String question; // 문제
	private String type_seq; // 유형번호(FK)
	private String ratio1; // 1번 질문 평가비율 
	private String ratio2; // 2번 질문 평가비율 
	private String ratio3; // 3번 질문 평가비율 
	private String ratio4; // 4번 질문 평가비율 
	private String ratio5; // 5번 질문 평가비율 
	
	
	
	public String getRatio2() {
		return ratio2;
	}
	public void setRatio2(String ratio2) {
		this.ratio2 = ratio2;
	}
	public String getRatio3() {
		return ratio3;
	}
	public void setRatio3(String ratio3) {
		this.ratio3 = ratio3;
	}
	public String getRatio4() {
		return ratio4;
	}
	public void setRatio4(String ratio4) {
		this.ratio4 = ratio4;
	}
	public String getRatio5() {
		return ratio5;
	}
	public void setRatio5(String ratio5) {
		this.ratio5 = ratio5;
	}
	public String getRatio1() {
		return ratio1;
	}
	public void setRatio1(String ratio1) {
		this.ratio1 = ratio1;
	}
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
