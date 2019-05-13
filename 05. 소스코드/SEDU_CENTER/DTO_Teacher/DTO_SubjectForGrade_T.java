/*

성적 입출력 #1,2

담당과정 테이블 : tblTeacherCourse
개설과정 테이블 : tblOpenCourse
개설과목관리 테이블 : tblOpenSubjectMGMT
과목 테이블 : tblSubject

 */

// 1,2번
package DTO_Teacher;

public class DTO_SubjectForGrade_T {

	private String subject_seq; // 과목 번호
	private String subjectName; // 과목 이름
	private String subjectEndDate; // 과목 종료날짜
	
	public String getSubject_seq() {
		return subject_seq;
	}
	public void setSubject_seq(String subject_seq) {
		this.subject_seq = subject_seq;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getSubjectEndDate() {
		return subjectEndDate;
	}
	public void setSubjectEndDate(String subjectEndDate) {
		this.subjectEndDate = subjectEndDate;
	}
	
}
