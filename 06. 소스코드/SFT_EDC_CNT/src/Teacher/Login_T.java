package Teacher;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.DAO_T;
import DTO.DTO_Teacher;


public class Login_T {

	private static Scanner scan;
	public static String teacher_seq_id;

	static {
		scan = new Scanner(System.in);
	}
	
	public void login() {
	      
	      System.out.print("ID : ");
	      String id = scan.nextLine();
	      System.out.print("PW : ");
	      String pw = scan.nextLine();
	      
	      ArrayList<DTO_Teacher> loginList = new ArrayList<DTO_Teacher>();
	      
	      DAO_T dao = new DAO_T();
	      
	      loginList = dao.TeacherLogin();
	      
	      boolean flag = false;
	      
	      for(int i = 0; i < loginList.size(); i++) {
	         if( id.equals(loginList.get(i).getName()) && pw.equals(loginList.get(i).getPw()) ) {
	            teacher_seq_id = loginList.get(i).getTeacher_Seq();
	        	 flag =true;
	         }
	      }
	      
	      if(flag) {
	    	  try {
				TeacherController.start();
			} catch (InterruptedException e) {
				System.out.println(e.toString());
			}
	         
	      }else {
	         System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
	         login();
	      }
	      
	   }
	
}
