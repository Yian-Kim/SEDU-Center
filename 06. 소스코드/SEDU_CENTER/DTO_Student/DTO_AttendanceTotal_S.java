package DTO_Student;
/*
 * ● 4. 전체출결조회
 * ● 5. 월간출결조회
 * ● 6. 일간출결조회
 * 	=> 총 3개의 쿼리에 사용된다.
 * 
 * 
 * [ 해당 쿼리에서 사용된 테이블 ] 
 * tblstudent
 * tblregicourse
 * tblopencourse
 * tblattendancemgmt
 * 
 *  - 한 학생의 전체출결조회, 월간출결조회, 일간출결조회 : 테이블모양이 동일하고 조인된 테이블 또한 동일하다
 *  - 차이점: 조건절 차이 => 월간 조회의 경우 : where substr(att.attenddate,4,2)='입력한 숫자' ; 추가
 *  						 일간 조회의 경우 : where s.name = '강민혁'  and '날짜지정' ; 추가
 */

public class DTO_AttendanceTotal_S {

	private String attendDate; // 근태 날짜
	private String workOn; // 출근 시간
	private String workOff; // 퇴근 시간
	private String state; // 근태상황

	
	public String getAttendDate() {
		return attendDate;
	}
	public void setAttendDate(String attendDate) {
		this.attendDate = attendDate;
	}
	public String getWorkOn() {
		return workOn;
	}
	public void setWorkOn(String workOn) {
		this.workOn = workOn;
	}
	public String getWorkOff() {
		return workOff;
	}
	public void setWorkOff(String workOff) {
		this.workOff = workOff;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	

	
}
