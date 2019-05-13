package DAO;
import java.sql.Connection;              

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto_common.DTO_Student;
import main_admin.DBUtil;

public class DAO_A_StudentManagement {
   
   private Connection conn;
   private Statement stat;
   private PreparedStatement pstat;
   
   //초기화(선행 작업)
   // - DB 접속
   public DAO_A_StudentManagement() {
      
      try {
         
         DBUtil util = new DBUtil();
         this.conn = util.connect();
         this.stat = conn.createStatement();
         
         
      } catch (SQLException e) {
         e.printStackTrace();
         System.out.println("DAO.Constructor");
      }
      
   }//DAO_StudentManagement()

//---------------------------------------------------------------------------------------------------------------------------------------      

   /**
    * DB 연결확인
    */
   public boolean isConnected() {
      try {
         return !this.conn.isClosed();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return false;
   }//isConnected()
   
//---------------------------------------------------------------------------------------------------------------------------------------      
   
   /**
    * DB연결 종료
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
    * 학생 목록
    */
   public ArrayList<DTO_Student> list() {
      
      try {
         
         String sql = "select name, pw, tel, regiDate, major from tblStudent";
                  
         ResultSet rs = stat.executeQuery(sql);
         
         ArrayList<DTO_Student> list = new ArrayList<DTO_Student>();
         
         while(rs.next()) {
            
            DTO_Student dto_student = new DTO_Student();
            
            dto_student.setMajor(rs.getString("major"));
            dto_student.setName(rs.getString("name"));
            dto_student.setPw(rs.getString("pw"));
            dto_student.setRegiDate(rs.getString("regiDate").substring(0, 10));
            dto_student.setTel(rs.getString("tel"));
            
            list.add(dto_student);
         }
         
         return list;
         
      } catch (Exception e) {
         System.out.println(e.toString());
      }
      
      return null;
      
   }//list()

//---------------------------------------------------------------------------------------------------------------------------------------      

   /**
    * 학생 등록
    */
   public int add(DTO_Student dto_student) {

      String sql = "insert into tblStudent (student_seq, name, pw, tel, regiDate, major) values (student_seq.nextval, ?, ?, ?, sysdate, ?)";
      
      try {
         
         pstat = conn.prepareStatement(sql);
         pstat.setString(1, dto_student.getName());
         pstat.setString(2, dto_student.getPw());
         pstat.setString(3, dto_student.getTel());
         pstat.setString(4, dto_student.getMajor());
         
         return pstat.executeUpdate();      
         
      } catch (Exception e) {
         System.out.println(e.toString());
      }
      
      return 0;
      
   }//add()
   
//---------------------------------------------------------------------------------------------------------------------------------------      
   
   /**
    * 학생 검색
    */
   public ArrayList<DTO_Student> search(String type, String index) {
      
      try {
         
         String sql = "select * from tblStudent where " + type + " = ?";
         
         pstat = conn.prepareStatement(sql);
         pstat.setString(1, index);
         
         ResultSet rs = pstat.executeQuery();
         
         ArrayList<DTO_Student> list = new ArrayList<DTO_Student>();//복사용

         if (rs.next()) {
            
            DTO_Student dto_student = new DTO_Student();
            
            dto_student.setStudent_seq(rs.getString("student_seq"));
            dto_student.setName(rs.getString("name"));
            dto_student.setPw(rs.getString("pw"));
            dto_student.setTel(rs.getString("tel"));
            dto_student.setRegiDate(rs.getString("regiDate").substring(0, 10));
            dto_student.setMajor(rs.getString("major"));

            list.add(dto_student);
         }
         
         return list;
         
      } catch (Exception e) {
         System.out.println(e.toString());
      }
      
      return null;
      
   }//search()
   
//---------------------------------------------------------------------------------------------------------------------------------------

   /**
    * 학생 검색후 특정학생 선택시
    */
   public DTO_Student selectStudent(String studentNum) {
      
      try {
         
         String sql = "select * from tblStudent where student_seq = ?";
         
         pstat = conn.prepareStatement(sql);
         pstat.setString(1, studentNum);
         
         ResultSet rs = pstat.executeQuery();
         
         DTO_Student dto_student = new DTO_Student();

         if (rs.next()) {
            dto_student.setStudent_seq(rs.getString("student_seq"));
            dto_student.setName(rs.getString("name"));
            dto_student.setPw(rs.getString("pw"));
            dto_student.setTel(rs.getString("tel"));
            dto_student.setRegiDate(rs.getString("regiDate").substring(0, 10));
            dto_student.setMajor(rs.getString("major"));
         }
         
         return dto_student;
         
      } catch (Exception e) {
         System.out.println(e.toString());
      }
      return null;
      
   }//selectStudent()

//---------------------------------------------------------------------------------------------------------------------------------------      

   /**
    * 학생 수정
    */
   public int modifyStudent(String name, String pw, String tel, String major, String studentNum) {
      
      try {
         String sql = "UPDATE tblStudent SET name = ?, pw = ?, tel = ?, major = ? WHERE student_seq = ?";
         
         pstat = conn.prepareStatement(sql);
         pstat.setString(1, name);
         pstat.setString(2, pw);
         pstat.setString(3, tel);
         pstat.setString(4, major);
         pstat.setString(5, studentNum);
         
         return pstat.executeUpdate();
         
      } catch (Exception e) {
         System.out.println(e.toString());
      }
      
      return 0;
      
   }//modifyStudent()

//---------------------------------------------------------------------------------------------------------------------------------------

   /**
    * 학생 삭제
    */
   public int deleteStudent(String studentNum) {

      try {
         String sql = "DELETE FROM tblStudent WHERE student_seq = ?";
         
         pstat = conn.prepareStatement(sql);
         pstat.setString(1, studentNum);
         
         return pstat.executeUpdate();
         
      } catch (Exception e) {
         System.out.println(e.toString());
      }
      
      return 0;
      
   }//deleteStudent()
   
//---------------------------------------------------------------------------------------------------------------------------------------      

}//Class_DAO_StudentManagement
