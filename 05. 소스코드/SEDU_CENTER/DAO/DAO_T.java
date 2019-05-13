package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.DTO_Teacher;
import DTO_Teacher.DTO_CourseOfTeacher_T;
import DTO_Teacher.DTO_StudentOfCourse_T;
import DTO_Teacher.DTO_SubjectOfCourse_T;
import Teacher.Login_T;


public class DAO_T {

	private Connection conn;
	   private Statement stat;
	   private PreparedStatement pstat;
	   
	   public static String teacher_course_seq;
	   
	   // 초기화(선행 작업)
	   // DB 접속
	   public DAO_T() {
	      
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
	    * 로그인을 위해 교사의 이름(아이디)과 비밀번호를 가져오는 메소드
	    */
	   public ArrayList<DTO_Teacher> TeacherLogin() {
	         
	         ArrayList<DTO_Teacher> dto_teacher_list = new ArrayList<DTO_Teacher>();
	         
	         String sql = "SELECT name, pw, teacher_seq FROM tblteacher";
	         
	         try {
	            
	            ResultSet rs = stat.executeQuery(sql);
	            
	            while(rs.next()) {
	               
	            	DTO_Teacher DTO_teacher = new DTO_Teacher();
	               
	            	DTO_teacher.setName(rs.getString("name"));
	            	DTO_teacher.setPw(rs.getString("pw"));
	            	DTO_teacher.setTeacher_Seq(rs.getString("teacher_seq"));
	            	
	               dto_teacher_list.add(DTO_teacher);
	               
	            }
	            
	            return dto_teacher_list;
	            
	         } catch (SQLException e) {
	            
	            e.printStackTrace();
	         }
	         
	         return null;
	         
	         
	      }
	   
	   /**
	    * 로그인 후 로그인된 교사의 과정에 대한 정보를 불러오는 메소드
	    */
	   public ArrayList<DTO_CourseOfTeacher_T> teacherSchedule_1() {
		   
		   ArrayList<DTO_CourseOfTeacher_T> dto_teacher_list = new ArrayList<DTO_CourseOfTeacher_T>();
		   
		   
		    try {

		    	String sql = "select oc.opencourse_seq, c.name, to_char(oc.startDate, 'yyyy-mm-dd') as startdate, to_char(oc.endDate, 'yyyy-mm-dd') as enddate, r.roomName from tblTeacher t inner join tblTeachercourse tc on t.teacher_seq = tc.teachercourse_seq inner join tblOpenCourse oc on oc.openCourse_seq = tc.openCourse_seq inner join tblCourse c on oc.course_seq = c.course_seq inner join tblRoom r on oc.room_seq = r.room_seq where t.teacher_seq = ?";
		    	
				pstat = conn.prepareStatement(sql);
				
				pstat.setString(1, Login_T.teacher_seq_id);
				
				ResultSet rs = pstat.executeQuery();
				
				while (rs.next()) {
//					System.out.printf("%s\t\t%s\t$s\t%s\n", rs.getString("c.name"), rs.getString("oc.startdate"), rs.getString("oc.enddate"), rs.getString("r.roomname"));
					DTO_CourseOfTeacher_T cof = new DTO_CourseOfTeacher_T();
					cof.setCourseName(rs.getString("name"));
					cof.setCourseStartDate(rs.getString("startdate"));
					cof.setCourseEndDate(rs.getString("enddate"));
					cof.setRoomName(rs.getString("roomName"));
					
					teacher_course_seq = rs.getString("opencourse_seq");
					
					dto_teacher_list.add(cof);
				}
				
				
				return dto_teacher_list;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		   return null;
	   }
	
	   /**
	    * 로그인 후 로그인된 교사의 과목에 대한 정보를 불러오는 메소드
	    */
	   public ArrayList<DTO_SubjectOfCourse_T> teacherSchedule_2() {
		   
		   ArrayList<DTO_SubjectOfCourse_T> dto_teacher_list = new ArrayList<DTO_SubjectOfCourse_T>();
		   
		   
		   try {
			   
			   String sql = "select s.name, to_char(osm.startDate, 'yyyy-mm-dd') as startdate, to_char(osm.endDate, 'yyyy-mm-dd') as enddate, s.period from tblOpencourse oc inner join tblOpenSubjectMgmt osm  on oc.openCourse_seq = osm.openCourse_seq inner join tblSubject s on s.subject_seq = osm.subject_seq inner join tblteachercourse tc on oc.openCourse_seq = tc.openCourse_seq inner join tblTeacher t on t.teacher_seq = tc.teacher_seq where t.teacher_seq = ? and oc.opencourse_seq = ?";
			   
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, Login_T.teacher_seq_id);
			pstat.setString(2, teacher_course_seq);
			
			ResultSet rs = pstat.executeQuery();
			
			while (rs.next()) {
				DTO_SubjectOfCourse_T soc = new DTO_SubjectOfCourse_T();
				soc.setSubjectname(rs.getString("name"));
				soc.setSubjectStartDate(rs.getString("startdate"));
				soc.setSubjectEndDate(rs.getString("enddate"));
				soc.setSubjectPeriod(rs.getString("period"));
				
				dto_teacher_list.add(soc);
			}
			
			
			return dto_teacher_list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return null;	
		   
	   }
	   
	   /**
	    * 로그인 후 로그인된 교사의 학생들에 대한 정보를 가져오는 메소드
	    */
	   public ArrayList<DTO_StudentOfCourse_T> teacherSchedule_3() {
		   
		   ArrayList<DTO_StudentOfCourse_T> dto_teacher_list = new ArrayList<DTO_StudentOfCourse_T>();
		   
		   
		   try {
			   
			  // String sql = "select s.name as studentname, s.student_seq, s.tel, s.major, c.name as coursename from tblOpenCourse oc inner join tblCourse c on oc.course_seq = c.course_seq inner join tblRegiCourse rg on rg.openCourse_seq = oc.openCourse_seq inner join tblStudent s on s.student_seq = rg.student_seq where t.teacher_seq = ? and oc.opencourse_seq = ?";
			   String sql = "select s.name as studentname, s.student_seq, s.tel, s.major, c.name as coursename from tblOpenCourse oc inner join tblCourse c on oc.course_seq = c.course_seq inner join tblRegiCourse rg on rg.openCourse_seq = oc.openCourse_seq inner join tblStudent s on s.student_seq = rg.student_seq inner join tblTeacherCourse tc on tc.openCourse_seq = oc.opencourse_seq where tc.teacher_seq = ? and oc.opencourse_seq = ?";
			   
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, Login_T.teacher_seq_id);
			pstat.setString(2, teacher_course_seq);
			
			ResultSet rs = pstat.executeQuery();
			
			while (rs.next()) {
				DTO_StudentOfCourse_T soc = new DTO_StudentOfCourse_T();
				soc.setStudentName(rs.getString("studentname"));
				soc.setStudent_seq(rs.getString("student_seq"));
				soc.setStudentTel(rs.getString("tel"));
				soc.setMajor(rs.getString("major"));
				soc.setCourseName(rs.getString("coursename"));
				
				dto_teacher_list.add(soc);
			}
			
			return dto_teacher_list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		   return null;
		   
	   }
	   
}
































