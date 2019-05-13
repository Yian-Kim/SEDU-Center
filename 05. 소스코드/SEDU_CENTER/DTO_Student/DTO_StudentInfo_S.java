package DTO_Student;
/*
 * ● 2. 학생 기본정보조회
 *     -시스템은 로그인에 성공한 학생에게 해당 학생에 대한 기본정보를 보여준다.
 * 
 * 
 * [ 해당 쿼리에서 사용된 테이블 ] 
 * tblstudent
 * tblRegiCourse
 * tblOpenCourse
 * tblroom
 * tblCourse
 * tblTeacherCourse
 * tblTeacher
 * 
 */

public class DTO_StudentInfo_S {
	
	private String student_seq; // 학생번호(PK)
	private String sname; // 학생이름
	private String courseName; //과정명
	private String StartDate; // 과정 시작일
	private String EndDate; // 과정 종료일
	private String roomName; // 강의실명
	private String tname; // 교사 이름
	
	
	
	public String getStudent_seq() {
		return student_seq;
	}
	public void setStudent_seq(String student_seq) {
		this.student_seq = student_seq;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
	
	
}