/*

강의스케줄 조회 #1
- JOIN한 테이블

교사계정 테이블 : tblTeacher
담당과정 테이블 : tblTeacherCourse
개설과정 테이블 : tblOpenCourse
과정 테이블 : tblCourse
강의실 테이블 : tblRoom

 */

package DTO_Teacher;

public class DTO_CourseOfTeacher_T {

	// 1,2번
	private String opencourse_seq; // 개설과정 번호(PK)
	private String courseName; // 과정 이름
	private String courseStartDate; // 개설과정 시작날짜
	private String courseEndDate; // 개설과정 종료날짜
	private String roomName; // 강의실명
	
	
	public String getOpencourse_seq() {
		return opencourse_seq;
	}
	public void setOpencourse_seq(String opencourse_seq) {
		this.opencourse_seq = opencourse_seq;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseStartDate() {
		return courseStartDate;
	}
	public void setCourseStartDate(String courseStartDate) {
		this.courseStartDate = courseStartDate;
	}
	public String getCourseEndDate() {
		return courseEndDate;
	}
	public void setCourseEndDate(String courseEndDate) {
		this.courseEndDate = courseEndDate;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

}
