package admin;

public class DTO_ViewOpenSubject_A {

	/* 
	 * 1. 관리자 - 4. 성적 조회 - a. 과정별 성적 조회 - 과정 선택시
	 * 개설과정 안의 개설과목을 보여줌, 개설과목번호(PK)를 넘겨줌
	 * 
	 * [해당 쿼리에서 사용된 테이블]
	 * tblOpenCourse
	 * tblOpenSubjectMgmt
	 * tblSubject
	 */
	
	private String openSubjectMgmt_seq; // 개설과목번호(PK) > rownum 배열에 저장
	private String rownum; // 메뉴선택번호
	private String subjectName; // 개설과목명
	private String subjectDuration; // 개설과목기간
	
	
	public String getOpenSubjectMgmt_seq() {
		return openSubjectMgmt_seq;
	}
	public void setOpenSubjectMgmt_seq(String openSubjectMgmt_seq) {
		this.openSubjectMgmt_seq = openSubjectMgmt_seq;
	}
	public String getRownum() {
		return rownum;
	}
	public void setRownum(String rownum) {
		this.rownum = rownum;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getSubjectDuration() {
		return subjectDuration;
	}
	public void setSubjectDuration(String subjectDuration) {
		this.subjectDuration = subjectDuration;
	}
	
	
}
