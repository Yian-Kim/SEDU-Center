/*

교사평가관리 #1

교사계정 테이블 : tblTeacher
담당과정 테이블 : tblTeacherCourse
개설과정 테이블 : tblOpenCourse
과정 테이블 : tblCourse
수강신청 테이블 : tblRegiCourse
평가답변테이블 : tblTeacherEval_A
평가문제테이블 : tblTeacherEval_Q
보기 테이블 : tblExample

 */

package DTO_Teacher;

public class DTO_EvalObjective_T {

	private String teacher_seq; // 교사번호
	private String objective_Q; // 객관식 문제
	private String objective_A; // 객관식 답변
	private String evalQ_seq; // 평가문제번호
	
	private String veryGood; // 매우그렇다
	private String good; // 그렇다
	private String normal; // 보통이다
	private String bad; // 아니다
	private String veryBad; // 매우 아니다
	
	public String getTeacher_seq() {
		return teacher_seq;
	}
	public void setTeacher_seq(String teacher_seq) {
		this.teacher_seq = teacher_seq;
	}
	public String getObjective_Q() {
		return objective_Q;
	}
	public void setObjective_Q(String objective_Q) {
		this.objective_Q = objective_Q;
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
	public String getVeryGood() {
		return veryGood;
	}
	public void setVeryGood(String veryGood) {
		this.veryGood = veryGood;
	}
	public String getGood() {
		return good;
	}
	public void setGood(String good) {
		this.good = good;
	}
	public String getNormal() {
		return normal;
	}
	public void setNormal(String normal) {
		this.normal = normal;
	}
	public String getBad() {
		return bad;
	}
	public void setBad(String bad) {
		this.bad = bad;
	}
	public String getVeryBad() {
		return veryBad;
	}
	public void setVeryBad(String veryBad) {
		this.veryBad = veryBad;
	}
	
	
}
