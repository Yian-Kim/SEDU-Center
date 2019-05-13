package Teacher;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.DAO_T;
import DTO.DTO_Teacher;
import DTO_Teacher.DTO_CourseOfTeacher_T;

/**
 * 교사 계정 로그인 클래스
 * @author KCM
 *
 */
public class Login_T {

	private static Scanner scan;
	private static TeacherView view;
	public static String teacher_seq_id;

	static {
		scan = new Scanner(System.in);
		view = new TeacherView();
	}

	/**
	 * 교사 계정 로그인을 입력받고, 로그인 시 교사정보를 출력해주는 메소드
	 * @throws InterruptedException
	 */
	public void login() throws InterruptedException {

		view.login_T();
		
		System.out.println("\t\t\t――――――――――――――――――――――――――");
		System.out.println();
		System.out.print("\t\t\t- ID : ");
		String id = scan.nextLine();
		System.out.print("\t\t\t- PW : ");
		String pw = scan.nextLine();
		System.out.println();

		ArrayList<DTO_Teacher> loginList = new ArrayList<DTO_Teacher>();

	      DAO_T dao = new DAO_T();

	      loginList = dao.TeacherLogin();

	      boolean flag = false;
	      
	      String teacherName = "";
	      for (int i = 0; i < loginList.size(); i++) {
	         if (id.equals(loginList.get(i).getName()) && pw.equals(loginList.get(i).getPw())) {
	            teacher_seq_id = loginList.get(i).getTeacher_Seq();
	            teacherName = loginList.get(i).getName();
	            flag = true;
	         }
	      }

	      if (flag) {
	         try {
	            view.pause();
	            
	            ArrayList<DTO_CourseOfTeacher_T> dto_teacher_list = new ArrayList<DTO_CourseOfTeacher_T>();
	            dto_teacher_list = dao.teacherSchedule_1();
	            
	            System.out.printf("\n\n\n\n\n\n\n\n\t안녕하세요. %s 선생님\n\n", teacherName);
	            for (int i = 0; i < dto_teacher_list.size(); i++) {
	               System.out.printf("\n\t강의 과정명 : %s\n", dto_teacher_list.get(i).getCourseName());
	               System.out.printf("\n\t과정 기간 : %s ~ %s\n", dto_teacher_list.get(i).getCourseStartDate(), dto_teacher_list.get(i).getCourseEndDate());
	               System.out.printf("\n\t강의실명 : %s\n", dto_teacher_list.get(i).getRoomName());
	            }
	            view.pause();
	            TeacherController.t_menu();
	         } catch (InterruptedException e) {
	            System.out.println(e.toString());
	         }

	      } else {
	         System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
	         login();
	      }
	}

}
