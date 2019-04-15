package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
	   
}
