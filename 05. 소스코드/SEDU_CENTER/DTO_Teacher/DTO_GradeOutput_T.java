/*

성적입출력 #3

학생 테이블 : tblStudent
수강신청 테이블 : tblRegiCourse
성적정보 테이블 : tblGrade
개설과목관리 테이블 : tblOpenSubjectMGMT
과목 테이블 : tblSubject
개설과정 테이블 : tblOpenCourse
담당과정 테이블 : tblTeacherCourse
수료여부 테이블 : tblResult

 */

package DTO_Teacher;

public class DTO_GradeOutput_T {

	private String student_seq; // 학생번호
	private String studentName; // 학생명
	private String subjectName; // 과목명
	private String score; // 점수
	
	public String getStudent_seq() {
		return student_seq;
	}
	public void setStudent_seq(String student_seq) {
		this.student_seq = student_seq;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
}
