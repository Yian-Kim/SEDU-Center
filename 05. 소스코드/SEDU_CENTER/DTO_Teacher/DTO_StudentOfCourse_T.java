/*

강의스케줄 조회 #3

개설과정 테이블 : tblOpenCourse
과정 테이블 : tblCourse
수강신청 테이블 : tblRegiCourse
학생 테이블 : tblStudent

 */

package DTO_Teacher;

public class DTO_StudentOfCourse_T {

	private String StudentName; // 학생명
	private String Student_seq; // 학번
	private String studentTel; // 학생 연락처
	private String major; // 학과(전공)
	private String courseName; // 과정명
	
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getStudent_seq() {
		return Student_seq;
	}
	public void setStudent_seq(String student_seq) {
		Student_seq = student_seq;
	}
	public String getStudentTel() {
		return studentTel;
	}
	public void setStudentTel(String studentTel) {
		this.studentTel = studentTel;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
	
}
