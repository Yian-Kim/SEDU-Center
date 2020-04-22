package DTO_Student;
/*
 * ● 7. 교사평가
 * 	   a.객관식
 *       - 객관식 문제 & 답변 결과 출력  
 * 
 * 
 * [ 해당 쿼리에서 사용된 테이블 ] 
 * tblstudent
 * tblregicourse
 * tblresult
 * tblopencourse
 * tblcourse
 * tblteacherEval_A
 * tblteachereval_q
 * tblExample
 * 
 */

public class DTO_TeacherEvalObject_S {
	
	private String evalq_seq; // 평가문제번호
	private String question; //평가문제
	private String objective_a; //평가답변
	private String content; // 평가세부내용
		
	
	
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
	public String getObjective_a() {
		return objective_a;
	}
	public void setObjective_a(String objective_a) {
		this.objective_a = objective_a;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	

}
