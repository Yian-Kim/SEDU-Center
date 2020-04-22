package DTO_admin;

public class DTO_stu_rc_oc_admg_A {

	/*
	 * 1. 관리자 -5. 출결 관리 및 출결조회 - b. 과정별 조회 - 과정 선택시
	 * 
	 * tblstudent
	 * tblregicourse
	 * tblopencourse
	 * tblattendancemgmt
	 * 
	 */
	
	private String student_seq; // 학생 번호
	private String studentName; // 학생명
	private String commuteTime; // 출근시간
	private String quittingTime; // 퇴근시간
	private String attendanceSituation; // 근태상황
	private String regiNum; //수강신청번호
	
	public String getRegiNum() {
		return regiNum;
	}
	public void setRegiNum(String regiNum) {
		this.regiNum = regiNum;
	}
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
