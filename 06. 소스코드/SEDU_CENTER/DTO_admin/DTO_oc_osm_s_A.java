package DTO_admin;

public class DTO_oc_osm_s_A {

	/*
	 * 1. 관리자 – 2. 개설 과정 및 과목 관리– 1. (상세보기)
	 * e. 과목명 및 기간
	 * 
	 * tblOpenCourse
	 * tblOpenSubjectMgmt
	 * tblSubject
	 */
	
	private String subjectName; // 해당 과정의 과목명
	private String subjectDuration; // 해당 과정의 과목에 대한 기간

	
	
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
