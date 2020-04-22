package DTO;

public class DTO_AttendanceMgmt {

	private String attendanceMgmt_seq; // 근태관리 번호(PK)
	private String attendDate; // 근태 날짜
	private String workOn; // 출근 시간
	private String workOff; // 퇴근 시간
	private String state; // 근태상황
	private String regiCourse_seq; // 수강신청번호(FK)
	
	public String getAttendanceMgmt_seq() {
		return attendanceMgmt_seq;
	}
	public void setAttendanceMgmt_seq(String attendanceMgmt_seq) {
		this.attendanceMgmt_seq = attendanceMgmt_seq;
	}
	public String getAttendDate() {
		return attendDate;
	}
	public void setAttendDate(String attendDate) {
		this.attendDate = attendDate;
	}
	public String getWorkOn() {
		return workOn;
	}
	public void setWorkOn(String workOn) {
		this.workOn = workOn;
	}
	public String getWorkOff() {
		return workOff;
	}
	public void setWorkOff(String workOff) {
		this.workOff = workOff;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getRegiCourse_seq() {
		return regiCourse_seq;
	}
	public void setRegiCourse_seq(String regiCourse_seq) {
		this.regiCourse_seq = regiCourse_seq;
	}
	
	
	
}
