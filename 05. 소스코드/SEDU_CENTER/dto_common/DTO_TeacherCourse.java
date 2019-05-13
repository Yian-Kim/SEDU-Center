package dto_common;

public class DTO_TeacherCourse {

	private String teacherCourse_seq; // 교사와 개설과정에 대한 번호시퀀스(PK)
	private String openCourse_seq; // 개설과정번호(FK)
	private String teacher_seq; // 교사 번호(FK)
	
	public String getTeacherCourse_seq() {
		return teacherCourse_seq;
	}
	public void setTeacherCourse_seq(String teacherCourse_seq) {
		this.teacherCourse_seq = teacherCourse_seq;
	}
	public String getOpenCourse_seq() {
		return openCourse_seq;
	}
	public void setOpenCourse_seq(String openCourse_seq) {
		this.openCourse_seq = openCourse_seq;
	}
	public String getTeacher_seq() {
		return teacher_seq;
	}
	public void setTeacher_seq(String teacher_seq) {
		this.teacher_seq = teacher_seq;
	}
	
	
	
}
