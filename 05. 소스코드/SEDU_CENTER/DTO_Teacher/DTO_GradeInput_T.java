/*

성적입출력 #4

학생 테이블 : tblStudent
수강신청 테이블 : tblRegiCourse
성적정보 테이블 : tblGrade
개설과목관리 테이블 : tblOpenSubjectMGMT
과목 테이블 : tblSubject
개설과정 테이블 : tblOpenCourse
담당과정 테이블 : tblTeacherCourse

 */

package DTO_Teacher;

public class DTO_GradeInput_T {

	private String regiCouse_seq; // 수강신청번호	
	private String openSubjectMGMT_seq; // 개설과목번호
	
	public String getRegiCouse_seq() {
		return regiCouse_seq;
	}
	public void setRegiCouse_seq(String regiCouse_seq) {
		this.regiCouse_seq = regiCouse_seq;
	}
	public String getOpenSubjectMGMT_seq() {
		return openSubjectMGMT_seq;
	}
	public void setOpenSubjectMGMT_seq(String openSubjectMGMT_seq) {
		this.openSubjectMGMT_seq = openSubjectMGMT_seq;
	}

}
