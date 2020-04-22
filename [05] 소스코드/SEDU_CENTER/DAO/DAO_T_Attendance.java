package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO_Teacher.DTO_AttendanceMGMT_T;
import DTO_Teacher.DTO_CourseOfTeacher_T;
import Teacher.Login_T;
import Teacher.TeacherService;

public class DAO_T_Attendance {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;

	// 초기화(선행 작업)
	// DB 접속
	public DAO_T_Attendance() {

		try {
			DBUtil util = new DBUtil();
			this.conn = util.connect();
			this.stat = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DAO.Constructor");
		}

	}

	public boolean isConnected() { // 조건문 써먹을수 잇음

		try {
			return !this.conn.isClosed();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public void close() {
		try {

			this.conn.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * 로그인 된 교사의 전체 학생들의 특정 날짜에 대한 출석 정보를 가져오는 메소드
	 */
	public ArrayList<DTO_AttendanceMGMT_T> allStdDate() { // 전체 날짜 조회

		ArrayList<DTO_AttendanceMGMT_T> dto_attendance_list1 = new ArrayList<DTO_AttendanceMGMT_T>();

		try {

			String sql = "select s.name as studentName, to_char(am.attendDate, 'yyyy-mm-dd') as aDate, to_char(am.workon, 'hh24:mi') as startTime, to_char(am.workoff, 'hh24:mi') as endTime, am.state "
					+ "from tblStudent s inner join tblRegiCourse rg "
						+ "on s.student_seq = rg.student_seq "
							+ "inner join tblAttendanceMgmt am "
								+ "on am.regiCourse_seq = rg.regiCourse_seq "
									+ "inner join tblopencourse oc "
										+ "on oc.opencourse_seq = rg.opencourse_seq "
											+ "inner join tblteachercourse tc "
												+ "on tc.opencourse_seq = oc.opencourse_seq "
													+ "where tc.teacher_seq = ? and attendDate = ?";
			pstat = conn.prepareStatement(sql);

			pstat.setString(1, Login_T.teacher_seq_id);
			pstat.setString(2, TeacherService.seldate);
			
			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				DTO_AttendanceMGMT_T ad = new DTO_AttendanceMGMT_T();
				ad.setStudentName(rs.getString("studentName"));
				ad.setAttendDate(rs.getString("aDate"));
				ad.setStartTime(rs.getString("startTime"));
				ad.setEndTime(rs.getString("endTime"));				
				ad.setState(rs.getString("state"));

				dto_attendance_list1.add(ad);
			}
			
			return dto_attendance_list1;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * 로그인 된 교사의 특정 학생의 특정 기간에 대한 출석 정보를 가져오는 메소드
	 */
	public ArrayList<DTO_AttendanceMGMT_T> persPeriodDate() { // 개인별 기간 조회
		ArrayList<DTO_AttendanceMGMT_T> dto_attendance_list2 = new ArrayList<DTO_AttendanceMGMT_T>();

		try {

			String sql = "select to_char(am.attendDate, 'yyyy-mm-dd') as aDate, to_char(am.workon, 'hh24:mi') as startTime, to_char(am.workoff, 'hh24:mi') as endTime, am.state "
							+ "from tblStudent s inner join tblRegiCourse rg "
								+ "on s.student_seq = rg.student_seq "
									+ "inner join tblAttendanceMgmt am "
										+ "on am.regiCourse_seq = rg.regiCourse_seq "
											+ "inner join tblopencourse oc "
												+ "on oc.opencourse_seq = rg.opencourse_seq "
													+ "inner join tblteachercourse tc "
														+ "on tc.opencourse_seq = oc.opencourse_seq "
															+ "where tc.teacher_seq = ? and s.name = ?"
																+ "and attendDate between ? and ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, Login_T.teacher_seq_id);
			pstat.setString(2, TeacherService.name);
			pstat.setString(3, TeacherService.startDate);
			pstat.setString(4, TeacherService.endDate);
			

			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				DTO_AttendanceMGMT_T ad = new DTO_AttendanceMGMT_T();
				ad.setAttendDate(rs.getString("aDate"));
				ad.setStartTime(rs.getString("startTime"));
				ad.setEndTime(rs.getString("endTime"));
				ad.setState(rs.getString("state"));
				
				dto_attendance_list2.add(ad);
			}

			return dto_attendance_list2;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 로그인 된 교사의 특정 학생의 특정 날짜에 대한 출석 정보를 가져오는 메소드
	 */
	public ArrayList<DTO_AttendanceMGMT_T> personalDate() {
		ArrayList<DTO_AttendanceMGMT_T> dto_attendance_list3 = new ArrayList<DTO_AttendanceMGMT_T>();

		try {

			String sql = "select to_char(am.attendDate, 'yyyy-mm-dd') as aDate, to_char(am.workon, 'hh24:mi') as startTime, to_char(am.workoff, 'hh24:mi') as endTime, am.state "
							+ "from tblStudent s inner join tblRegiCourse rg "
								+ "on s.student_seq = rg.student_seq "
									+ "inner join tblAttendanceMgmt am "
										+ "on am.regiCourse_seq = rg.regiCourse_seq "
											+ "inner join tblopencourse oc "
												+ "on oc.opencourse_seq = rg.opencourse_seq "
													+ "inner join tblteachercourse tc "
														+ "on tc.opencourse_seq = oc.opencourse_seq "
															+ "where tc.teacher_seq = ? and s.name = ?"
																+ "and attendDate = ?";
			
			
			pstat = conn.prepareStatement(sql);

			pstat.setString(1, Login_T.teacher_seq_id);
			pstat.setString(2, TeacherService.name);
			pstat.setString(3, TeacherService.seldate);

			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				DTO_AttendanceMGMT_T ad = new DTO_AttendanceMGMT_T();				
				ad.setStartTime(rs.getString("startTime"));
				ad.setEndTime(rs.getString("endTime"));
				ad.setState(rs.getString("state"));

				dto_attendance_list3.add(ad);
			}

			return dto_attendance_list3;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
