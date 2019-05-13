package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO_Teacher.DTO_AttendanceMGMT_T;
import DTO_Teacher.DTO_Consult_T;
import DTO_Teacher.DTO_EvalObjective_T;
import DTO_Teacher.DTO_EvalSubjective_T;
import Teacher.Login_T;

public class DAO_T_Evaluation {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;

	// 초기화(선행 작업)
	// DB 접속
	public DAO_T_Evaluation() {

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
	 * 로그인 된 교사의 평가 6번 문제(주관식 좋았던 점)에 대한 답을 불러오는 메소드
	 */
	public ArrayList<DTO_EvalSubjective_T> teacherEval_1() { // 주관식 좋았던 점

		ArrayList<DTO_EvalSubjective_T> dto_eval1 = new ArrayList<DTO_EvalSubjective_T>();

		try {

			String sql = "select tea.subjective_A from tblTeacher t inner join tblTeacherCourse tc on t.teacher_seq = tc.teacher_seq inner join tblOpenCourse oc on oc.openCourse_seq = tc.openCourse_seq inner join tblCourse c on c.course_seq = oc.course_seq inner join tblRegiCourse rc on rc.openCourse_seq = oc.openCourse_seq inner join tblTeacherEval_A tea on tea.regiCourse_seq = rc.regiCourse_seq inner join tblTeacherEval_Q teq on teq.evalQ_seq = tea.evalQ_seq where teq.evalQ_seq= 6 and t.teacher_seq = ? order by dbms_random.value";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, Login_T.teacher_seq_id);

			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				DTO_EvalSubjective_T es = new DTO_EvalSubjective_T();

				es.setSubjective_A(rs.getString("subjective_A"));

				dto_eval1.add(es);
			}

			return dto_eval1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 로그인 된 교사의 평가 7번 문제(주관식 아쉬운 점)에 대한 답을 불러오는 메소드
	 */
	public ArrayList<DTO_EvalSubjective_T> teacherEval_2() { // 주관식 아쉬운 점

		ArrayList<DTO_EvalSubjective_T> dto_eval2 = new ArrayList<DTO_EvalSubjective_T>();

		try {

			String sql = "select tea.subjective_A from tblTeacher t inner join tblTeacherCourse tc on t.teacher_seq = tc.teacher_seq inner join tblOpenCourse oc on oc.openCourse_seq = tc.openCourse_seq inner join tblCourse c on c.course_seq = oc.course_seq inner join tblRegiCourse rc on rc.openCourse_seq = oc.openCourse_seq inner join tblTeacherEval_A tea on tea.regiCourse_seq = rc.regiCourse_seq inner join tblTeacherEval_Q teq on teq.evalQ_seq = tea.evalQ_seq where teq.evalQ_seq= 7 and t.teacher_seq = ? order by dbms_random.value";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, Login_T.teacher_seq_id);

			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				DTO_EvalSubjective_T es = new DTO_EvalSubjective_T();

				es.setSubjective_A(rs.getString("subjective_A"));

				dto_eval2.add(es);
			}

			return dto_eval2;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	/**
	 * 로그인 된 교사의 평가 1~5번 문제(객관식)에 대한 답을 불러와 통계치로 변환시켜주는 메소드
	 */
	public ArrayList<DTO_EvalObjective_T> teacherEval_3() { // 객관식 통계

		ArrayList<DTO_EvalObjective_T> dto_eval3 = new ArrayList<DTO_EvalObjective_T>();

		try {

			String sql1 = "create or replace view vwResult_Objective" + 
					"as" + 
					"select t.teacher_seq, teq.question, tea.objective_A, tea.evalq_seq from tblTeacher t" + 
					"    inner join tblTeacherCourse tc" + 
					"        on t.teacher_seq = tc.teacher_seq" + 
					"            inner join tblOpenCourse oc" + 
					"                on oc.openCourse_seq = tc.openCourse_seq" + 
					"                    inner join tblCourse c --과정 테이블" + 
					"                        on c.course_seq = oc.course_seq" + 
					"                            inner join tblRegiCourse rc" + 
					"                                on rc.openCourse_seq = oc.openCourse_seq" + 
					"                                    inner join tblTeacherEval_A tea" + 
					"                                        on tea.regiCourse_seq = rc.regiCourse_seq" + 
					"                                            inner join tblExample e" + 
					"                                                on e.example_seq = tea.objective_A" + 
					"                                                    inner join tblTeacherEval_Q teq" + 
					"                                                        on teq.evalQ_seq = tea.evalQ_seq";
			pstat = conn.prepareStatement(sql1);
			
			String sql2 = "select question,evalq_seq, round(count(case when objective_A = 5 then 5 else null end) / count(*) * 100,1) as VeryGood, round(count(case when objective_A = 4 then 4 else null end) / count(*) * 100,1) as Good, round(count(case when objective_A = 3 then 3 else null end) / count(*) * 100,1) as Normal, round(count(case when objective_A = 2 then 2 else null end) / count(*) * 100,1) as Bad, round(count(case when objective_A = 1 then 1 else null end) / count(*) * 100,1) as VeryBad from vwResult_Objective vwro where vwro.teacher_seq = ? group by question, evalq_seq order by evalq_seq asc";

			pstat = conn.prepareStatement(sql2);

			pstat.setString(1, Login_T.teacher_seq_id);

			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				DTO_EvalObjective_T eo = new DTO_EvalObjective_T();

				eo.setObjective_Q(rs.getString("question"));
				eo.setEvalQ_seq(rs.getString("evalq_seq"));
				eo.setVeryGood(rs.getString("VeryGood"));
				eo.setGood(rs.getString("Good"));
				eo.setNormal(rs.getString("Normal"));
				eo.setBad(rs.getString("Bad"));
				eo.setVeryBad(rs.getString("VeryBad"));

				dto_eval3.add(eo);
			}

			return dto_eval3;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
