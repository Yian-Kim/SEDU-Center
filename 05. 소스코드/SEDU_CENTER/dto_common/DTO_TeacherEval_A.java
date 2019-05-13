package dto_common;

public class DTO_TeacherEval_A {

	private String evalA_seq; // 평가답변 번호(PK)
	private String subjective_A; // 주관식 답변
	private String objective_A; // 객관식 답변(FK)
	private String evalQ_seq; // 평가문제번호(FK)
	private String regiCourse_seq; // 수강신청번호(FK)
	
	public String getEvalA_seq() {
		return evalA_seq;
	}
	public void setEvalA_seq(String evalA_seq) {
		this.evalA_seq = evalA_seq;
	}
	public String getSubjective_A() {
		return subjective_A;
	}
	public void setSubjective_A(String subjective_A) {
		this.subjective_A = subjective_A;
	}
	public String getObjective_A() {
		return objective_A;
	}
	public void setObjective_A(String objective_A) {
		this.objective_A = objective_A;
	}
	public String getEvalQ_seq() {
		return evalQ_seq;
	}
	public void setEvalQ_seq(String evalQ_seq) {
		this.evalQ_seq = evalQ_seq;
	}
	public String getRegiCourse_seq() {
		return regiCourse_seq;
	}
	public void setRegiCourse_seq(String regiCourse_seq) {
		this.regiCourse_seq = regiCourse_seq;
	}
	
	
	
}
