package dto_common;

public class DTO_RegiCourse {

	private String regiCourse_seq; // 수강신청번호(PK)
	private String student_seq; // 학생번호(FK)
	private String openCourse_seq; // 개설과정번호(FK)
	
	public String getRegiCourse_seq() {
		return regiCourse_seq;
	}
	public void setRegiCourse_seq(String regiCourse_seq) {
		this.regiCourse_seq = regiCourse_seq;
	}
	public String getStudent_seq() {
		return student_seq;
	}
	public void setStudent_seq(String student_seq) {
		this.student_seq = student_seq;
	}
	public String getOpenCourse_seq() {
		return openCourse_seq;
	}
	public void setOpenCourse_seq(String openCourse_seq) {
		this.openCourse_seq = openCourse_seq;
	}
	
	
	
}
