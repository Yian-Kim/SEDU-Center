package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO_admin.DTO_StudentCourseGrades_A;
import DTO_admin.DTO_StudentGradesSubject_A;
import DTO_admin.DTO_StudentsTakingCourses_A;
import DTO_admin.DTO_ViewOpenCourse_A;
import DTO_admin.DTO_ViewOpenSubject_A;
import main_admin.DBUtil;

public class DAO_A_GradeViews {
   
   private Connection conn;
   private Statement stat;
   private PreparedStatement pstat;
   
   public DAO_A_GradeViews() {
      
      try {

         DBUtil util = new DBUtil();
         conn = util.connect();
         stat = conn.createStatement();
         
      } catch (SQLException e) {
         e.printStackTrace();
         System.out.println("DAO.Constructor");
      }
      
   }//DAO_GradeViews()
   
//---------------------------------------------------------------------------------------------------------------------------------------   

   /**
    * DB접속 종료
    */
   public void close() {

      try {
         this.conn.close();
      } catch (Exception e) {
         System.out.println(e.toString());
      }      
      
   }//close()
   
//---------------------------------------------------------------------------------------------------------------------------------------   
   
   /**
    * 개설과정 리스트 출력
    */
   public ArrayList<DTO_ViewOpenCourse_A> courseList() {
      
      try {
         String sql = "SELECT oc.openCourse_seq as openCourse_seq, c.name as courseName, oc.startDate || '~' || oc.endDate as courseDuration, t.name as teacherName, r.roomName as className FROM tblCourse c INNER JOIN tblOpenCourse oc ON c.course_seq = oc.course_seq   INNER JOIN tblRoom r ON oc.room_seq = r.room_seq INNER JOIN tblTeacherCourse tc   ON tc.openCourse_seq = oc.openCourse_seq INNER JOIN tblTeacher t ON tc.teacher_seq = t.teacher_seq";
         
         ResultSet rs = stat.executeQuery(sql);
         
         ArrayList<DTO_ViewOpenCourse_A> list = new ArrayList<DTO_ViewOpenCourse_A>();
         
         while (rs.next()) {
            
            DTO_ViewOpenCourse_A dto_vOC = new DTO_ViewOpenCourse_A();
            
            dto_vOC.setCourseName(rs.getString("courseName"));
            dto_vOC.setCourseDuration(rs.getString("courseDuration"));
            dto_vOC.setOpenCourse_seq(rs.getString("openCourse_seq"));
            dto_vOC.setTeacherName(rs.getString("teacherName"));
            dto_vOC.setClassName(rs.getString("className"));
            
            list.add(dto_vOC);
         }
         
         return list;
         
      } catch (Exception e) {
         System.out.println(e.toString());
      }
      
      return null;

   }//list()


//---------------------------------------------------------------------------------------------------------------------------------------
   
   /**
    * 개설과목 리스트 출력
    */
   public ArrayList<DTO_ViewOpenSubject_A> subjectList(String courseSeq) {
      
      try {
         
         String sql = "SELECT osm.openSubjectMgmt_seq as openSubjectMgmt_seq, s.name as subjectName, osm.startDate || '~' || osm.endDate as subjectDuration, c.name as courseName FROM tblOpenCourse oc INNER JOIN tblOpenSubjectMgmt osm ON oc.openCourse_seq = osm.openCourse_seq INNER JOIN tblCourse c ON oc.course_seq = c.course_seq INNER JOIN tblSubject s ON osm.subject_seq = s.subject_seq WHERE oc.openCourse_seq = ?";
         
         pstat = conn.prepareStatement(sql);
         pstat.setString(1, courseSeq);
         
         ResultSet rs = pstat.executeQuery();
         
         ArrayList<DTO_ViewOpenSubject_A> list = new ArrayList<DTO_ViewOpenSubject_A>();
         
         while (rs.next()) {
            
            DTO_ViewOpenSubject_A dto_vOS = new DTO_ViewOpenSubject_A();
            
            dto_vOS.setCourseName(rs.getString("courseName"));
            dto_vOS.setOpenSubjectMgmt_seq(rs.getString("openSubjectMgmt_seq"));
            dto_vOS.setSubjectDuration(rs.getString("subjectDuration"));
            dto_vOS.setSubjectName(rs.getString("subjectName"));
            
            list.add(dto_vOS);
         }
         
         return list;
         
      } catch (Exception e) {
         System.out.println(e.toString());
      }
      
      return null;
      
   }//subjectList()

//---------------------------------------------------------------------------------------------------------------------------------------   

   /**
    * 해당과목 학생점수 리스트 출력
    */
   public ArrayList<DTO_StudentGradesSubject_A> studentList(String courseSeq, String subjectSeq) {

      try {
         String sql = "SELECT stu.name as studentName, g.score as recordScore, s.name as subjectName FROM tblOpenCourse oc INNER JOIN tblOpenSubjectMgmt osm ON oc.openCourse_seq = osm.openCourse_seq INNER JOIN tblSubject s ON osm.subject_seq = s.subject_seq INNER JOIN tblGrade g ON g.openSubjectMgmt_seq = osm.openSubjectMgmt_seq INNER JOIN tblRegiCourse rc ON g.regiCourse_seq = rc.regiCourse_seq INNER JOIN tblStudent stu ON rc.student_seq = stu.student_seq WHERE oc.openCourse_seq = ? and osm.openSubjectMgmt_seq = ?";
         
         pstat = conn.prepareStatement(sql);
         
         pstat.setString(1, courseSeq);
         pstat.setString(2, subjectSeq);
         
         ResultSet rs = pstat.executeQuery();
         
         ArrayList<DTO_StudentGradesSubject_A> list = new ArrayList<DTO_StudentGradesSubject_A>();
         
         while (rs.next()) {
            
            DTO_StudentGradesSubject_A dto_sgs = new DTO_StudentGradesSubject_A();
            
            dto_sgs.setStudentName(rs.getString("studentName"));
            dto_sgs.setRecordScore(rs.getString("recordScore"));
            dto_sgs.setSubjectName(rs.getString("subjectName"));
            
            list.add(dto_sgs);
         }
         
         return list;
         
      } catch (Exception e) {
         System.out.println(e.toString());
      }
      return null;
   }//studentList()
   
//---------------------------------------------------------------------------------------------------------------------------------------   

   /**
    * 학생 검색시 학생정보 가져오기
    */
   public ArrayList<DTO_StudentsTakingCourses_A> search(String name) {

      try {

         String sql = "SELECT rownum, s.name as studentName, s.pw as studentPw, c.name as courseName, oc.startDate || '~' || oc.endDate as courseDuration, r.roomName as className, s.student_seq as student_seq FROM tblStudent s INNER JOIN tblRegiCourse rc ON s.student_seq = rc.student_seq INNER JOIN tblOpenCourse oc ON rc.openCourse_seq = oc.openCourse_seq INNER JOIN tblCourse c ON oc.course_seq = c.course_seq INNER JOIN tblRoom r ON oc.room_seq = r.room_seq WHERE s.name = ?";
         
         pstat = conn.prepareStatement(sql);
         
         pstat.setString(1, name);
         
         ResultSet rs = pstat.executeQuery();
         
         ArrayList<DTO_StudentsTakingCourses_A> list = new ArrayList<DTO_StudentsTakingCourses_A>();
         
         while (rs.next()) {
            
            DTO_StudentsTakingCourses_A dto_stc = new DTO_StudentsTakingCourses_A();
            
            dto_stc.setClassName(rs.getString("className"));
            dto_stc.setCourseDuration(rs.getString("courseDuration"));
            dto_stc.setCourseName(rs.getString("courseName"));
            dto_stc.setStudentName(rs.getString("studentName"));
            dto_stc.setStudentPw(rs.getString("studentPw"));
            dto_stc.setStudent_seq(rs.getString("student_seq"));
            
            list.add(dto_stc);
         }
         
         return list;
         
      } catch (Exception e) {
         System.out.println(e.toString());
      }
      
      return null;
      
   }//search
   
//---------------------------------------------------------------------------------------------------------------------------------------
   
   /**
    * 선택한 학생의 과목정보
    */
   public ArrayList<DTO_StudentCourseGrades_A> subjectScore(String studentSeq) {
      
      try {
            
         String sql = "SELECT s.name as subjectName, osm.startDate || '~' || osm.endDate as subjectDuration, g.score as recordScore, stu.name as studentName FROM tblStudent stu INNER JOIN tblRegiCourse rc ON stu.student_seq = rc.student_seq INNER JOIN tblGrade g ON rc.regiCourse_seq = g.regiCourse_seq INNER JOIN tblOpenSubjectMgmt osm ON g.openSubjectMgmt_seq = osm.openSubjectMgmt_seq INNER JOIN tblSubject s ON osm.subject_seq = s.subject_seq WHERE stu.student_seq = ?";
         
         pstat = conn.prepareStatement(sql);
         
         pstat.setString(1, studentSeq);
         
         ResultSet rs = pstat.executeQuery();
         
         ArrayList<DTO_StudentCourseGrades_A> list = new ArrayList<DTO_StudentCourseGrades_A>();
         
         while (rs.next()) {
            
            DTO_StudentCourseGrades_A dto_scg = new DTO_StudentCourseGrades_A();
            
            dto_scg.setSubjectName(rs.getString("subjectName"));
            dto_scg.setSubjectDuration(rs.getString("subjectDuration"));
            dto_scg.setRecordScore(rs.getString("recordScore"));
            dto_scg.setStudentName(rs.getString("studentName"));
            
            list.add(dto_scg);
         }
         
         return list;
         
      } catch (Exception e) {
         System.out.println(e.toString());
      }
   
      return null;
}
   
//---------------------------------------------------------------------------------------------------------------------------------------   
   
   
}//Class_DAO_GradeViews