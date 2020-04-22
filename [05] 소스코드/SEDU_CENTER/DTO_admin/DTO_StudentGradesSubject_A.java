package DTO_admin;

public class DTO_StudentGradesSubject_A {

	/*
	 * 1. 관리자 - 4. 성적 조회 - a. 과정별 성적 조회 - 과정선택 - 과목선택 후
	 * 과목에 해당하는 학생들의 성적보여줌
	 * 
	 * [해당 쿼리에서 사용된 테이블]
	 * tblOpenCourse
	 * tblOpenSubjectMgmt
	 * tblSubject
	 * tblGrade
	 * tblRegiCourse
	 * tblStudent
	 */
	
	private String studentName; // 학생명
	private String recordScore; // 점수
	private String subjectName; // 과목명
	
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getRecordScore() {
		return recordScore;
	}
	public void setRecordScore(String recordScore) {
		this.recordScore = recordScore;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	
}
