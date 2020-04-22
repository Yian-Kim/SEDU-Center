package dto_common;

public class DTO_Grade {

	private String grade_seq; // 성적 번호(PK)
	private String score; // 점수
	private String testDate; // 시험날짜
	private String regiCourse_seq; // 수강신청번호(FK)
	private String openSubjectMgmt_seq; // 개설과목관리번호(FK)
	
	public String getGrade_seq() {
		return grade_seq;
	}
	public void setGrade_seq(String grade_seq) {
		this.grade_seq = grade_seq;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getTestDate() {
		return testDate;
	}
	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}
	public String getRegiCourse_seq() {
		return regiCourse_seq;
	}
	public void setRegiCourse_seq(String regiCourse_seq) {
		this.regiCourse_seq = regiCourse_seq;
	}
	public String getOpenSubjectMgmt_seq() {
		return openSubjectMgmt_seq;
	}
	public void setOpenSubjectMgmt_seq(String openSubjectMgmt_seq) {
		this.openSubjectMgmt_seq = openSubjectMgmt_seq;
	}
	
	
	
}
