package DTO_Student;
/*
 * ● 7. 교사평가
 * 	   b.주관식
 * 		 - 주관식 문제 & 답변 결과 출력      
 * 
 * 
 * [ 해당 쿼리에서 사용된 테이블 ]
 *   tblstudent
 *   tblregicourse
 *   tblresult
 *   tblopencourse
 *   tblcourse
 *   tblteacherEval_A
 *   tblteachereval_q
 * 
 */

public class DTO_TeacherEvalSubject_S {
	private String evalq_seq;// 평가문제번호
	private String question;//평가문제
	private String subjective_a;//평가답변

	
	
	public String getEvalq_seq() {
		return evalq_seq;
	}
	public void setEvalq_seq(String evalq_seq) {
		this.evalq_seq = evalq_seq;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getSubjective_a() {
		return subjective_a;
	}
	public void setSubjective_a(String subjective_a) {
		this.subjective_a = subjective_a;
	}
	
	
	
	
}
