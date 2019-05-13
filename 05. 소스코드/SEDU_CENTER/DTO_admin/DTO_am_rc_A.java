package DTO_admin;

public class DTO_am_rc_A {

	/*
	 * 1. 관리자 - 5. 출결 관리 및 출결조회 - a. 학생별 조회
	 * 
	 * tblAttendanceMgmt
	 * tblRegiCourse
	 * 
	 */
	
	private String attendanceDay; // 근태 날짜
	private String commuteTime; // 출근시간
	private String quittingTime; // 퇴근시간
	private String attendanceSituation; // 근태상황
	private String RegiNum; // 수강신청번호
	
	public String getRegiNum() {
		return RegiNum;
	}
	public void setRegiNum(String regiNum) {
		RegiNum = regiNum;
	}
	public String getAttendanceDay() {
		return attendanceDay;
	}
	public void setAttendanceDay(String attendanceDay) {
		this.attendanceDay = attendanceDay;
	}
	public String getCommuteTime() {
		return commuteTime;
	}
	public void setCommuteTime(String commuteTime) {
		this.commuteTime = commuteTime;
	}
	public String getQuittingTime() {
		return quittingTime;
	}
	public void setQuittingTime(String quittingTime) {
		this.quittingTime = quittingTime;
	}
	public String getAttendanceSituation() {
		return attendanceSituation;
	}
	public void setAttendanceSituation(String attendanceSituation) {
		this.attendanceSituation = attendanceSituation;
	}
	
	
	
}
