package DTO;

public class DTO_OpenSubjectMgmt {

	private String openSubjectMgmt_seq; // 개설과목관리 번호(PK)
	private String startDate; // 과목 시작일
	private String endDate; // 과목 종료일
	private String subject_seq; // 과목번호(FK)
	private String openCourse_seq; // 개설과정번호(FK)
	
	public String getOpenSubjectMgmt_seq() {
		return openSubjectMgmt_seq;
	}
	public void setOpenSubjectMgmt_seq(String openSubjectMgmt_seq) {
		this.openSubjectMgmt_seq = openSubjectMgmt_seq;
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
	public String getSubject_seq() {
		return subject_seq;
	}
	public void setSubject_seq(String subject_seq) {
		this.subject_seq = subject_seq;
	}
	public String getOpenCourse_seq() {
		return openCourse_seq;
	}
	public void setOpenCourse_seq(String openCourse_seq) {
		this.openCourse_seq = openCourse_seq;
	}
	
	
	
	
}
