package DTO_admin;

public class DTO_teq_t_A {

	private String evalq_seq; // 교사평가 질문에 대한 순서번호이자 평가질문(PK)
	private String questionnaire; // 교사평가 질문
	private String questionType; // 유형(주관식,객관식인지)
	
	
	
	public String getEvalq_seq() {
		return evalq_seq;
	}
	public void setEvalq_seq(String evalq_seq) {
		this.evalq_seq = evalq_seq;
	}
	public String getQuestionnaire() {
		return questionnaire;
	}
	public void setQuestionnaire(String questionnaire) {
		this.questionnaire = questionnaire;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	
	
	
}
