/*

강의스케줄 조회 #2

개설과정 테이블 : tblOpenCourse
개설과목관리 테이블 : tblOpenSubjectMGMT
과목 테이블 : tblSubject
담당과정 테이블 : tblTeacherCourse
교사계정 테이블 : tblTeacher

 */

package DTO_Teacher;

public class DTO_SubjectOfCourse_T {

	// 3번
	private String subjectname; // 과목 이름
	private String subjectStartDate; // 개설과목 시작날짜
	private String subjectEndDate; // 개설과목 종료날짜
	private String subjectPeriod; // 과목기간
	
	
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public String getSubjectStartDate() {
		return subjectStartDate;
	}
	public void setSubjectStartDate(String subjectStartDate) {
		this.subjectStartDate = subjectStartDate;
	}
	public String getSubjectEndDate() {
		return subjectEndDate;
	}
	public void setSubjectEndDate(String subjectEndDate) {
		this.subjectEndDate = subjectEndDate;
	}
	public String getSubjectPeriod() {
		return subjectPeriod;
	}
	public void setSubjectPeriod(String subjectPeriod) {
		this.subjectPeriod = subjectPeriod;
	}
	
}
