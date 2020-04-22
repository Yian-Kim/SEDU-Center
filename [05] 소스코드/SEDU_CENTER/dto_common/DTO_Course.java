package dto_common;

public class DTO_Course {

	private String course_seq; // 과정번호(PK)
	private String name; // 과정이름
	private String period; // 과정기간(몇일인지)
	
	public String getCourse_seq() {
		return course_seq;
	}
	public void setCourse_seq(String course_seq) {
		this.course_seq = course_seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	
}
