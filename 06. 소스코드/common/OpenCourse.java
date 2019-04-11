package common;

public class OpenCourse {

	private String openCourse_seq; // 개설과정 번호(PK)
	private String startDate; // 과정 시작일
	private String endDate; // 과정 종료일
	private String course_seq; // 과정번호(FK)
	private String room_seq; // 방번호(FK)
	
	public String getOpenCourse_seq() {
		return openCourse_seq;
	}
	public void setOpenCourse_seq(String openCourse_seq) {
		this.openCourse_seq = openCourse_seq;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getCourse_seq() {
		return course_seq;
	}
	public void setCourse_seq(String course_seq) {
		this.course_seq = course_seq;
	}
	public String getRoom_seq() {
		return room_seq;
	}
	public void setRoom_seq(String room_seq) {
		this.room_seq = room_seq;
	}
	
	
	
}
