package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO_admin.DTO_am_rc_A;
import DTO_admin.DTO_c_oc_r_tc_t_A;
import DTO_admin.DTO_stu_rc_oc_admg_A;
import DTO_admin.DTO_stu_rc_oc_c_r_A;
import main_admin.DBUtil;

public class DAO_A_AdminFunction2 {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	
	// 초기화(선행 작업)
	// DB 접속
	/**
	 * DB 접속을 위해 초기화 시켜주는 생성자
	 */
	public DAO_A_AdminFunction2() {
		
		try {
			DBUtil util = new DBUtil();
			this.conn = util.connect();
			this.stat = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DAO.Constructor");
		}
		
	}
	
	/**
	 * DB와 연동되어있는지 확인하는 메소드
	 * @return
	 */
	public boolean isConnected() { // 조건문 써먹을수 잇음
		
		try {
			return !this.conn.isClosed();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
				
	}
	
	/**
	 * DB와 연결한 자원을 반납하는 메소드
	 */
	public void close() {
		try {
			
			this.conn.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * 관리자 > 출결 관리 및 출결조회 > 학생별 조회 및 수정에서 입력한 학생 이름과 같은 
	 * 학생 정보를 DB에서 가져오는 메소드
	 * @param name 입력한 학생명
	 * @return 입력한 학생명과 일치하는 정보
	 */
	public ArrayList<DTO_stu_rc_oc_c_r_A> daoAttendanceStudentInfoModify(String name) {

		ArrayList<DTO_stu_rc_oc_c_r_A> list = new ArrayList<DTO_stu_rc_oc_c_r_A>();
		
		String sql = "SELECT s.student_seq, rpad(s.name,15,' ') as studentName, s.pw as studentPw, rpad(c.name,35, ' ') as courseName, oc.startDate || '~' || oc.endDate as courseDuration, rpad(r.roomName,12, ' ') as className FROM tblStudent s INNER JOIN tblRegiCourse rc ON s.student_seq = rc.student_seq INNER JOIN tblOpenCourse oc ON rc.openCourse_seq = oc.openCourse_seq INNER JOIN tblCourse c ON oc.course_seq = c.course_seq INNER JOIN tblRoom r ON oc.room_seq = r.room_seq WHERE s.name = '" + name + "'";
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_stu_rc_oc_c_r_A dto = new DTO_stu_rc_oc_c_r_A();
				
				dto.setStudent_seq(rs.getString("student_seq"));
				dto.setStudentName(rs.getString("studentName"));
				dto.setStudentPw(rs.getString("studentPw"));
				dto.setCourseName(rs.getString("courseName"));
				dto.setCourseDuration(rs.getString("courseDuration"));
				dto.setClassName(rs.getString("className"));
				
				list.add(dto);
				
			}
			
			return list;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction2_A 클래스 daoAttendanceStudentInfoModify(String name) 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 학생명을 DB에서 가져오는 메소드
	 * @param choice 학생번호
	 * @return 학생명
	 */
	public String StudentName(String choice) {
		// 1. 관리자 - 5. 출결 관리 및 출결 조회 - a. 학생별 조회에서 학생명 가져와서 반환
		
		String sql = "select rpad(name,15,' ') as studentName from tblStudent where student_seq = " + choice;
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				String name = rs.getString("studentName");
				
				return name;
			}
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction2_A 클래스 StudentName(String choice) 오류!");
			e.printStackTrace();
		}
		
		
		return null;
	}

	/**
	 * 학생에 대한 출결내역을 DB에서 가져오는 메소드
	 * @param choice 학생번호
	 * @param startDate 출결조회 시작일
	 * @param endDate 출결조회 종료일
	 * @return 학생에 대한 출결조회 리스트
	 */
	public ArrayList<DTO_am_rc_A> daoAttendanceInfo(String choice, String startDate, String endDate) {

		String sql = "SELECT am.regicourse_seq, to_char(am.attendDate,'yyyy-mm-dd') as attendanceDay, to_char(am.workOn, 'hh24:mi') as commuteTime, rpad(to_char(am.workOff, 'hh24:mi'),4, ' ') as quittingTime, rpad(am.state,10,' ') as attendanceSituation FROM tblAttendanceMgmt am INNER JOIN tblRegiCourse rc ON am.regiCourse_seq = rc.regiCourse_seq WHERE rc.student_seq = " + choice + " AND attendDate BETWEEN to_date('" + startDate + "','yyyy-mm-dd') AND to_date('" + endDate +"','yyyy-mm-dd')";
		
		ArrayList<DTO_am_rc_A> list = new ArrayList<DTO_am_rc_A>();
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_am_rc_A dto = new DTO_am_rc_A();
				
				dto.setRegiNum(rs.getString("regicourse_Seq"));
				dto.setAttendanceDay(rs.getString("attendanceDay"));
				dto.setCommuteTime(rs.getString("commuteTime"));
				dto.setQuittingTime(rs.getString("quittingTime"));
				dto.setAttendanceSituation(rs.getString("attendanceSituation"));
				
				list.add(dto);
				
			}
			
			return list;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction2_A 클래스 daoAttendanceInfo(String choice, String startDate, String endDate) 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 해당 학생의 출결 날짜에 대한 근태상황 수정
	 * @param regiNum 수강신청 번호
	 * @param date 출결 날짜
	 * @param state 근태상황
	 * @return 수정완료 1 수정실패 0
	 */
	public int daoAttendanceStateModify(String regiNum, String date, String state) {

		String sql = "UPDATE tblattendancemgmt SET state = '" + state + "' WHERE attenddate = to_date('" + date + "','yyyy-mm-dd') and regicourse_seq = " + regiNum;
		
		try {
			int result = stat.executeUpdate(sql);
			
			return result;
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction2_A 클래스 daoAttendanceStateModify(String regiNum, String date, String state) 오류!");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * DB에서 개설 과정 정보를 가져오는 메소드
	 * @return 개설 과정정보
	 */
	public ArrayList<DTO_c_oc_r_tc_t_A> daoAttendanceCourseInfo() {

		ArrayList<DTO_c_oc_r_tc_t_A> list = new ArrayList<DTO_c_oc_r_tc_t_A>();
		
		String sql = "select oc.opencourse_seq, rpad(c.name,35, ' ') as courseName, oc.startdate || ' ~ ' || oc.enddate as courseDuration, rpad(t.name,15,' ') as teacherName, rpad(r.roomname,12,' ') as className  from tblopencourse oc inner join tblteachercourse tc on tc.opencourse_seq = oc.opencourse_seq inner join tblteacher t on t.teacher_seq = tc.teacher_seq inner join tblcourse c on c.course_seq = oc.course_seq inner join tblroom r on r.room_seq = oc.room_seq";
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_c_oc_r_tc_t_A dto = new DTO_c_oc_r_tc_t_A();
				
				dto.setOpencourse_seq(rs.getString("opencourse_seq"));
				dto.setCourseName(rs.getString("courseName"));
				dto.setCoureseDuration(rs.getString("courseDuration"));
				dto.setTeacherName(rs.getString("teacherName"));
				dto.setClassName(rs.getString("className"));
				
				list.add(dto);
			}
			return list;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction2_A 클래스 daoAttendanceCourseInfo() 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 관리자 > 출결 관리 및 출결조회 > 과정별조회 > 과정 선택시
	 * 해당 과정의 선택한 날에 대한 학생들의 출결 조회를 DB에서 가져옴
	 * @param select 과정PK
	 * @param date 출결조회일
	 * @return 과정에 대한 학생들의 출결조회 정보
	 */
	public ArrayList<DTO_stu_rc_oc_admg_A> daoAttendanceCourseView(String select, String date) {

		ArrayList<DTO_stu_rc_oc_admg_A> list = new ArrayList<DTO_stu_rc_oc_admg_A>();
		
		String sql = "select rc.regicourse_seq, s.student_seq, rpad(s.name,15, ' ') as studentName, to_char(admg.workon, 'hh24:mm') as commuteTime, to_char(admg.workoff, 'hh24:mm') as quittingTime, rpad(admg.state,12, ' ') as attendanceSituation from tblstudent s inner join tblregicourse rc on s.student_seq = rc.student_seq inner join tblopencourse oc on oc.opencourse_seq = rc.opencourse_seq inner join tblattendancemgmt admg on admg.regicourse_seq = rc.regicourse_seq where oc.opencourse_seq = " + select +" and admg.attendDate = to_date('" + date + "','yyyy-mm-dd')";
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_stu_rc_oc_admg_A dto = new DTO_stu_rc_oc_admg_A();
				
				dto.setRegiNum(rs.getString("regicourse_seq"));
				dto.setStudent_seq(rs.getString("student_seq"));
				dto.setStudentName(rs.getString("studentName"));
				dto.setCommuteTime(rs.getString("commuteTime"));
				dto.setQuittingTime(rs.getString("quittingTime"));
				dto.setAttendanceSituation(rs.getString("attendanceSituation"));
				
				list.add(dto);
				
			}
			
			return list;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction2_A 클래스 daoAttendanceCourseView(String select, String date) 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 관리자 > 출결 관리 및 출결조회 > 과정별 조회 > 과정 선택시
	 * 과정명
	 * @param select 과정PK
	 * @return 과정명
	 */
	public String daoAttendanceCourseName(String select) {

		String sql = "select rpad(c.name,35,' ') as courseName from tblCourse c inner join tblOpenCourse oc on c.course_seq = oc.course_seq where oc.course_seq = " + select;
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				String name = rs.getString("courseName");
				
				return name;
			}
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction2_A 클래스 daoAttendanceCourseName(String select) 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

}
