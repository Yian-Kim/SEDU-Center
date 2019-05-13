/*

교사평가관리 #2

교사계정 테이블 : tblTeacher
담당과정 테이블 : tblTeacherCourse
개설과정 테이블 : tblOpenCourse
과정 테이블 : tblCourse
수강신청 테이블 : tblRegiCourse
평가답변 테이블 : tblTeacherEval_A
평가문제 테이블 : tblTeacherEval_Q

 */

package DTO_Teacher;

public class DTO_EvalSubjective_T {
	
	private String subjective_Q;
	private String subjective_A;
	
	
	public String getSubjective_Q() {
		return subjective_Q;
	}
	public void setSubjective_Q(String subjective_Q) {
		this.subjective_Q = subjective_Q;
	}
	public String getSubjective_A() {
		return subjective_A;
	}
	public void setSubjective_A(String subjective_A) {
		this.subjective_A = subjective_A;
	}
	
	
	
}
