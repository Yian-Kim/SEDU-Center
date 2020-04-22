package DTO_Student;
/*
 * ● 7. 교사평가
 *	   a. 교사평가 불가한 학생조회
 * 
 * 
 *  [ 해당 쿼리에서 사용된 테이블 ]
 * tblstudent
 * tblregicourse
 * tblresult
 * tblopencourse
 * tblcourse
 * 
 * 
 * - 교사평가는 수료생만 가능하다
 * - 수료 여부에 대한 선검사가 진행되어야 하며 수료학생이 아닌 경우 다음과 같은 테이블을 사용한다.
 * - 조건검사: sysdate > o.enddate 
 * 
 */
public class DTO_EvalNoStudent_S {

	private String sname; // 학생이름
	private String courseName; //과정명
	private String endDate; // 과정 종료일
	
	
	
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
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
}
