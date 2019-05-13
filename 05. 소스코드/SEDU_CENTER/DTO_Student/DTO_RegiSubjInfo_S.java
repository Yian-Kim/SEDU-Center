package DTO_Student;
/*
 * ● 10. 과정 및 과목 조회
 * 		b. 수강중인 과정 > 과목정보 조회
 * 
 * 
 * [ 해당 쿼리에서 사용된 테이블 ]  
 * tblcourse
 * tblopencourse
 * tblOpenSubjectMgmt
 * tblSubject
 * 
 */
public class DTO_RegiSubjInfo_S {

	private String subject_seq; //과목번호
	private String subjName; //과목명
	private String startdate;//과목 시작일 
	private String enddate;  //과목 종료일
	
	
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
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	
	
	
	
}
