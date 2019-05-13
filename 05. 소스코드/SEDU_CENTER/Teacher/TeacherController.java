package Teacher;

import java.util.Scanner;

import Main.MainController;

/**
 * 교사 계정으로 로그인 시 교사 메뉴를 출력해주는 메소드
 * @author KCM
 *
 */
public class TeacherController {

	private static TeacherView view; // 출력화면 클래스
	private static IService service; // IService
	private static Scanner scan; // 입력
	private static Boolean loop = true;
	
	static {
		view = new TeacherView();
		service = new TeacherService();
		scan = new Scanner(System.in);
	}
	
//	public static void main(String[] args) throws InterruptedException {
//		Login_T login = new Login_T();
//		login.login();
//		start(); // 추후 취합 시 지워야 할 부분 
//	}

	public static void start() throws InterruptedException {
		
		Login_T login = new Login_T();
		login.login();
		
	}
	
	public static void t_menu() throws InterruptedException {


		
		while(loop) {
			view.title(TeacherView.menu); // 타이틀 출력
			view.teacherMenu(); // 교사 메뉴 출력
			
			String menu = scan.nextLine();
			
			switch(menu) {
				case "1" : // 강의스케줄 조회
					view.pause();
					service.teacherSchedule();
					break;
				case "2" : // 성적 입출력
					view.pause();
					service.gradeInputOuput();
					break;
				case "3" : // 출결관리 및 조회
					view.pause();
					service.attendanceMGMT();
					break;
				case "4" : // 교사평가 결과조회
					view.pause();
					service.teacherEvaluation();
					break;
				case "5" : // 상담일지 조회
					view.pause();
					service.teacherConsult();
					break;
				case "0" : // 프로그램 종료
					MainController.main(null);
					break;
					
			}	
			loop = false;
//			view.end();
			break;
		}	
		
		
	}	
}
