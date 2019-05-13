package DTO_Student;
/*
 * ● 3. 성적조회 
 *	  -과목별 성적을 조회한다 
 * 
 * 
 * [ 해당 쿼리에서 사용된 테이블 ]  
 * tblstudent
 * tblRegiCourse
 * tblOpenCourse
 * tblCourse
 * tblTeacherCourse
 * tblTeacher
 * tblOpenSubjectMgmt
 * tblsubject
 * tblgrade
 * 
 */

public class DTO_GradeSearch_S {
	
	private String subject_seq; // 과목번호(PK)
	private String subjName; // 과목명
	private String startDate; // 과목 시작일
	private String endDate; // 과목 종료일
	private String tname; // 교사 이름
	private String score; // 점수
	
	
	public String getSubject_seq() {
		return subject_seq;
	}
	public void setSubject_seq(String subject_seq) {
		this.subject_seq = subject_seq;
	}
	public String getSubjName() {
		return subjName;
	}
	public void setSubjName(String subjName) {
		this.subjName = subjName;
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
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
	
	
	
	
	
}
