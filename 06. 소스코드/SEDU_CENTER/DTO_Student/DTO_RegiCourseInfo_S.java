package DTO_Student;
/*
 * ● 10. 과정 및 과목 조회
 * 		a. 수강중인 과정에 대한 정보조회
 *
 * 
 * [ 해당 쿼리에서 사용된 테이블 ]  
 * tblOpenCourse
 * tblcourse
 * tblroom
 * tblTeacherCourse
 * tblteacher
 * tblRegiCourse
 * 
 */

public class DTO_RegiCourseInfo_S {

	private String courseName; //과정명
	private String tname; //교사명
	private String roomName;//강의실명
	
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

}
