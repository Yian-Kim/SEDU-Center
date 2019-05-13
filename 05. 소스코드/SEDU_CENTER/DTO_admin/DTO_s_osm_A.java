package DTO_admin;

public class DTO_s_osm_A {

	/*
	 * 1. 관리자 – 2. 개설 과정 및 과목 관리– 1. (상세보기) - a. 개설과목 정보 등록(개설과정번호 받아옴, 배열[입력번호-1])
	 * 
	 * 
	 * tblSubject
	 * tblOpenSubjectMgmt
	 */
	
	private String subjectName; // 개설 과목명
	private String subjectDuration; // 개설 과목 기간
	
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
