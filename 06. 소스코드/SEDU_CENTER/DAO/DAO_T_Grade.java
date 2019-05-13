package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO_Teacher.DTO_CourseOfTeacher_T;
import DTO_Teacher.DTO_GradeInput_T;
import DTO_Teacher.DTO_GradeOutput_T;
import DTO_Teacher.DTO_SubjectForGrade_T;
import DTO_Teacher.DTO_SubjectOfCourse_T;
import Teacher.Login_T;
import Teacher.TeacherService;

public class DAO_T_Grade {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;

	public static String subject_seq_gr;
	public static String regicourse_seq;
	public static String opensubjectmgmt_seq;

	// 초기화(선행 작업)
	// DB 접속
	public DAO_T_Grade() {

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
	 * 로그인 된 교사의 현재 진행중인 과정의 과목정보를 불러오는 메소드
	 */
	public ArrayList<DTO_SubjectForGrade_T> teacherGrade_1() {

		ArrayList<DTO_SubjectForGrade_T> dto_grade = new ArrayList<DTO_SubjectForGrade_T>();

		try {

			String sql = "SELECT s.subject_seq, s.name, to_char(os.enddate, 'yyyy-mm-dd') as enddate FROM tblTeacherCourse tc INNER JOIN tblOpenCourse oc ON tc.openCourse_seq = oc.openCourse_seq  INNER JOIN tblOpenSubjectMgmt os ON oc.openCourse_seq = os.openCourse_seq INNER JOIN tblSubject s ON s.subject_seq = os.subject_seq where tc.teacher_seq = ? and oc.opencourse_seq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, Login_T.teacher_seq_id);
			pstat.setString(2, DAO_T.teacher_course_seq);

			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				DTO_SubjectForGrade_T sfg = new DTO_SubjectForGrade_T();
				sfg.setSubject_seq(rs.getString("subject_seq"));
				sfg.setSubjectName(rs.getString("name"));
				sfg.setSubjectEndDate(rs.getString("enddate"));

				for (int i = 0; i < dto_grade.size(); i++) {
					TeacherService.subjectNum = dto_grade.get(i).getSubject_seq();
					subject_seq_gr = dto_grade.get(i).getSubject_seq();
				}

				dto_grade.add(sfg);
			}

			return dto_grade;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * 과목 선택시 해당 과목을 수강한 학생들의 목록과 성적 정보를 불러오는 메소드
	 */
	public ArrayList<DTO_GradeOutput_T> teacherGrade_2() {

		ArrayList<DTO_GradeOutput_T> dto_grade = new ArrayList<DTO_GradeOutput_T>();

		try {

			String sql = "select st.student_seq, st.name as studentname, su.name as subjectname, g.score from tblStudent st inner join tblRegiCourse rg on st.student_seq = rg.student_seq inner join tblGrade g on g.regiCourse_seq = rg.regiCourse_seq inner join tblOpenSubjectMgmt osm  on osm.openSubjectmgmt_seq = g.openSubjectmgmt_seq inner join tblSubject su on su.subject_seq = osm.subject_seq inner join tblopencourse oc on oc.opencourse_seq = rg.opencourse_seq inner join tblteachercourse tc on tc.opencourse_seq = oc.opencourse_seq inner join tblresult r on r.regicourse_seq = rg.regicourse_seq where tc.teacher_seq = ? and oc.opencourse_seq = ? and su.subject_seq = ? and r.state = '수료중'";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, Login_T.teacher_seq_id);
			pstat.setString(2, DAO_T.teacher_course_seq);
			pstat.setString(3, TeacherService.subjectNum);

			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				DTO_GradeOutput_T gop = new DTO_GradeOutput_T();
				gop.setStudent_seq(rs.getString("student_seq"));
				gop.setStudentName(rs.getString("studentname"));
				gop.setSubjectName(rs.getString("subjectname"));
				gop.setScore(rs.getString("score"));

				dto_grade.add(gop);
			}

			return dto_grade;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * 성적입력을 위해 필요한 과정번호와 개설과목번호를 불러오는 메소드
	 */
	public ArrayList<DTO_GradeInput_T> teacherGrade_3() {

		ArrayList<DTO_GradeInput_T> dto_grade = new ArrayList<DTO_GradeInput_T>();

		try {

			String sql = "select rg.regicourse_seq, osm.opensubjectmgmt_seq from tblStudent st inner join tblRegiCourse rg on st.student_seq = rg.student_seq inner join tblGrade g on g.regiCourse_seq = rg.regiCourse_seq inner join tblOpenSubjectMgmt osm on osm.openSubjectmgmt_seq = g.openSubjectmgmt_seq inner join tblSubject su on su.subject_seq = osm.subject_seq inner join tblopencourse oc on oc.opencourse_seq = rg.opencourse_seq inner join tblteachercourse tc on tc.opencourse_seq = oc.opencourse_seq where tc.teacher_seq = ? and oc.opencourse_seq = ? and su.subject_seq = ? and st.student_seq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, Login_T.teacher_seq_id);
			pstat.setString(2, DAO_T.teacher_course_seq);
			pstat.setString(3, TeacherService.subjectNum);
			pstat.setString(4, TeacherService.studentNum);

			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				DTO_GradeInput_T gip = new DTO_GradeInput_T();

				gip.setRegiCouse_seq(rs.getString("regicourse_seq"));
				gip.setOpenSubjectMGMT_seq(rs.getString("opensubjectmgmt_seq"));
				regicourse_seq = rs.getString("regicourse_seq");
				opensubjectmgmt_seq = rs.getString("opensubjectmgmt_seq");
				dto_grade.add(gip);
			}

			return dto_grade;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}
	
	
	/**
	 * 선택된 과목의 성적정보를 입력하는 메소드
	 */
	public int teacherGrade_4() {
	      
		ArrayList<DTO_GradeInput_T> dto_grade = new ArrayList<DTO_GradeInput_T>();
		
		dto_grade = teacherGrade_3();
		
		  String sql = "update tblGrade set score = ? where regiCourse_seq = ? and openSubjectMgmt_seq = ?";
	      
	      try {
	    	  pstat = conn.prepareStatement(sql);
	    	  
	    	  pstat.setString(1, TeacherService.score);
	    	  pstat.setString(2, regicourse_seq);
	    	  pstat.setString(3, opensubjectmgmt_seq);
	    	  
	         int result = pstat.executeUpdate();
	         
	         
	         return result;
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return 0;
	   }
	
	
	
}
