package DTO_Student;
/*
 * [  2개의 테이블에 대해 사용되는 DTO  ]
 * 
 * 
 * ● 7. 교사평가
 * 	   b. 교사 평가 가능한 학생조회
 * 
 * 
 *  [ 해당 쿼리에서 사용된 테이블 ]
 * tblstudent
 * tblregicourse
 * tblresult
 * tblopencourse
 * tblcourse
 * tblteacherCourse
 * tblTeacher
 * 
 * 
 * 
 * ● 9. 상담일지조회
 *     a. 상담을 시행할 교사 + 과정
 *     	- 상담이 완료된 학생의 상담내역에 대해 조회가능
 *     
 *     
 *  [ 해당 쿼리에서 사용된 테이블 ]
 * tblRegiCourse
 * tblOpenCourse
 * tblTeacherCourse
 * tblTeacher
 * tblCourse
 * tblstudent
 * 
 */


public class DTO_EvalOk_Consult_S {
//public class DTO_EvalOkStudent_S {
	
	private String sname ; // 학생명
	private String courseName; //과정명
	private String tname; //교사명
	
	
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	

}
