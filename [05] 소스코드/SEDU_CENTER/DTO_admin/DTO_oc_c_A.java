package DTO_admin;

public class DTO_oc_c_A {

	/*
	 * 1. 관리자 – 2. 개설 과정 및 과목 관리– 1. (상세보기)
	 * 1. 관리자 - 5. 출결 관리 및 출결조회 - b. 과정별 조회 - 과정선택시(과정명)
	 * 
	 * tblOpenCourse
	 * tblCourse
	 */
	
	private String courseName; // 개설과정의 해당 과정 이름

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
	
}
