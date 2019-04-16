package DTO;

public class DTO_AvlSubject {

	private String avlSubject_seq; // 교사가 강의가능과목 번호(PK)
	private String teacher_seq; // 교사번호(FK)
	private String subject_seq; // 과목번호(FK)
	
	public String getAvlSubject_seq() {
		return avlSubject_seq;
	}
	public void setAvlSubject_seq(String avlSubject_seq) {
		this.avlSubject_seq = avlSubject_seq;
	}
	public String getTeacher_seq() {
		return teacher_seq;
	}
	public void setTeacher_seq(String teacher_seq) {
		this.teacher_seq = teacher_seq;
	}
	public String getSubject_seq() {
		return subject_seq;
	}
	public void setSubject_seq(String subject_seq) {
		this.subject_seq = subject_seq;
	}
	
	
	
}
