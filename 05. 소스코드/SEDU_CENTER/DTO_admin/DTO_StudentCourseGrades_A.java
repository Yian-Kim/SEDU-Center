package DTO_admin;

public class DTO_StudentCourseGrades_A {

	/*
	 * 1. 관리자 - 4. 성적 조회 - b. 학생별 성적 조회 - 학생 선택시
	 * 학생의 수강과정에 대한 수강과목과 점수를 보여줌
	 * 
	 * [해당 쿼리에서 사용된 테이블]
	 * tblStudent
	 * tblRegiCourse
	 * tblGrade
	 * tblOpenSubjectMgmt
	 * tblSubject
	 */
	
	private String subjectName; // 과목명
	private String subjectDuration; // 과목기간
	private String recordScore; // 점수
	private String studentName; // 학생명
	
	
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getSubjectDuration() {
		return subjectDuration;
	}
	public void setSubjectDuration(String subjectDuration) {
		this.subjectDuration = subjectDuration;
	}
	public String getRecordScore() {
		return recordScore;
	}
	public void setRecordScore(String recordScore) {
		this.recordScore = recordScore;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	
}
