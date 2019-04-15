package Teacher;

import java.util.Scanner;


public class TeacherController {

	// 메인 객체가 업무를 분산시키기 위해 사용하는 위임 객체
	// 1. View 객체
	// 2. Service 객체
	private static View view; // 출력화면 클래스
	private static IService service; // 
	private static Scanner scan; // 입력
	private static Boolean loop = true;
	
	static {
		view = new View();
		service = new Service();
		scan = new Scanner(System.in);
	}
	
	public static void main(String[] args) throws InterruptedException {
		start(); // 추후 취합 시 지워야 할 부분 
	}

	public static void start() throws InterruptedException {
		
		view.title(View.menu); // 타이틀 출력
		view.teacherMenu(); // 교사 메뉴 출력
		
		String menu = scan.nextLine();
		
		while(loop) {
			
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
					loop = false;
					break;
			}	
		}	
		view.end();
	}	
}
