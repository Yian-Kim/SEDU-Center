package main_admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto_common.DTO_Admin;


public class DAO_AdminMain {

		private Connection conn;
		private Statement stat;
		private PreparedStatement pstat;
		
		// 초기화(선행 작업)
		// DB 접속
		public DAO_AdminMain() {
			
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
		 * @return 연동되어있으면 true 아니면 false
		 */
		public boolean isConnected() { // 조건문 써먹을수 잇음
			
			try {
				return !this.conn.isClosed();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
					
		}
		
		/**
		 * DB 연결 자원 해제
		 */
		public void close() {
			try {
				
				this.conn.close();
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		
		/**
		 * 관리자 로그인시 아이디와 비밀번호를 DB에서 가져옴
		 * @return 관리자 아이디,비밀번호 리스트
		 */
		public ArrayList<DTO_Admin> adminLogin() {
			
			
			ArrayList<DTO_Admin> dto_admin_list = new ArrayList<DTO_Admin>();
			
			String sql = "SELECT id, pw FROM tblAdmin";
			
			try {
				
				ResultSet rs = stat.executeQuery(sql);
				
				while(rs.next()) {
					
					DTO_Admin DTO_admin = new DTO_Admin();
					
					DTO_admin.setId(rs.getString("id"));
					DTO_admin.setPw(rs.getString("pw"));
					
					dto_admin_list.add(DTO_admin);
					
				}
				
				return dto_admin_list;
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return null;
			
			
		}
		
		
	
}
