/*

출결관리 및 조회 #1~5

학생 테이블 : tblStudent
수강신청 테이블 : tblRegiCourse
근태관리 테이블 : tblAttendanceMGMT
개설과정 테이블 : tblOpenCourse
담당과정 테이블 : tblTeacherCourse


 */

package DTO_Teacher;

public class DTO_AttendanceMGMT_T {

	private String studentName; // 학생명
	private String attendDate; // 출결날짜
	private String startTime; // 출근시간
	private String endTime; // 퇴근시간
	private String state; // 근태상황
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getAttendDate() {
		return attendDate;
	}
	public void setAttendDate(String attendDate) {
		this.attendDate = attendDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;		
	}
	public String getStartTime() {
		return startTime;
	}
	
	public void setEndTime(String endTime) {
		this.endTime = endTime;		
	}
	public String getEndTime() {
		return endTime;
	}

}
