package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO_Teacher.DTO_ConsultFinish_T;
import DTO_Teacher.DTO_Consult_T;
import DTO_Teacher.DTO_CourseOfTeacher_T;
import Teacher.Login_T;
import Teacher.TeacherService;

public class DAO_T_Consult {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;

	// 초기화(선행 작업)
	// DB 접속
	public DAO_T_Consult() {

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
	 * 로그인 된 교사에게 들어온 상담요청 정보를 가져오는 메소드
	 */
	public ArrayList<DTO_Consult_T> teacherConsult1() {

		ArrayList<DTO_Consult_T> dto_consult1 = new ArrayList<DTO_Consult_T>();

		try {

			String sql = "select cr.consult_seq, s.student_seq, s.name, s.tel, s.major, to_char(cr.requestDate, 'yyyy-mm-dd') as requestDate, cr.requestContent from tblStudent s inner join tblRegiCourse rg on s.student_seq = rg.student_seq inner join tblconsultrequest cr on rg.regicourse_seq = cr.regicourse_seq inner join tblOpenCourse oc on rg.opencourse_seq = oc.opencourse_seq inner join tblteachercourse tc on tc.opencourse_seq = oc.opencourse_seq inner join tblTeacher t on t.teacher_seq = tc.teacher_seq where t.teacher_seq = ? and cr.consultfin = 'n'";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, Login_T.teacher_seq_id);

			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				DTO_Consult_T ct = new DTO_Consult_T();
				
				ct.setStudent_seq(rs.getString("student_seq"));
				ct.setStudentName(rs.getString("name"));
				ct.setMajor(rs.getString("major"));
				ct.setRequestDate(rs.getString("requestDate"));
				ct.setRequestContent(rs.getString("requestContent"));
				ct.setConsult_seq(rs.getString("consult_seq"));

				dto_consult1.add(ct);
			}

			return dto_consult1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 로그인 된 교사의 완료된 상담 정보를 가져오는 메소드
	 */
	public ArrayList<DTO_ConsultFinish_T> teacherConsult2() {

		ArrayList<DTO_ConsultFinish_T> dto_consult2 = new ArrayList<DTO_ConsultFinish_T>();

		try {

			String sql = "select cr.consult_seq, s.student_seq, s.name, to_char(crecord.recorddate, 'yyyy-mm-dd') as recorddate, crecord.recordcontent from tblStudent s inner join tblRegiCourse rg on s.student_seq = rg.student_seq inner join tblconsultrequest cr on rg.regicourse_seq = cr.regicourse_seq inner join tblOpenCourse oc on rg.opencourse_seq = oc.opencourse_seq inner join tblteachercourse tc on tc.opencourse_seq = oc.opencourse_seq inner join tblTeacher t on t.teacher_seq = tc.teacher_seq inner join tblConsultRecord crecord on crecord.consult_seq = cr.consult_seq where t.teacher_seq = ? and cr.consultfin = 'y'";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, Login_T.teacher_seq_id);

			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				DTO_ConsultFinish_T cf = new DTO_ConsultFinish_T();
				
				cf.setStudent_seq(rs.getString("student_seq"));
				cf.setStudentName(rs.getString("name"));
				cf.setRecordDate(rs.getString("recorddate"));
				cf.setRecordContent(rs.getString("recordcontent"));
				
				dto_consult2.add(cf);
			}

			return dto_consult2;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 상담 일지를 작성하여 상담일지 테이블에 데이터를 저장하는 메소드
	 */
	public int teacherConsult3() {
	      
	      String sql = "insert into tblconsultrecord (record_seq, recordDate, recordContent, consult_seq) VALUES (ConsultRecord_seq.nextVal, to_char(sysdate,'yyyy-mm-dd'), ?, ?)";
	      
	      try {
	    	  pstat = conn.prepareStatement(sql);
	    	  
	    	  pstat.setString(1, TeacherService.consultContent);
	    	  pstat.setString(2, TeacherService.consultNum);
	    	  
	         int result = pstat.executeUpdate();
	         
	         
	         return result;
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return 0;
	   }
	
	/**
	 * 요청된 상담을 진행 후 상담 완료여부를 바꾸는 메소드
	 */
	public int teacherConsult4() {
	      
		
		  String sql = "update tblconsultrequest set consultfin = 'y' where consult_seq = ?";
	      
	      try {
	    	  pstat = conn.prepareStatement(sql);
	    	  
	    	  pstat.setString(1, TeacherService.consultNum);
	    	  
	         int result = pstat.executeUpdate();
	         
	         
	         return result;
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return 0;
	   }

}
