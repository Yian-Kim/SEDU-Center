package Main;

import java.util.Scanner;

import Student.StudentController;
import Teacher.TeacherController;
import main_admin.AdminMain;

public class MainController {

	public static void main(String[] args) throws InterruptedException {
	
		Scanner scan = new Scanner(System.in);
		View view = new View();
		Boolean loop = true;
		
		System.out.println();
		view.bigTitle();
		// view.bearPic();
		System.out.println();
		System.out.println("\t\t\t\t――――――――――――――――――――――――――");
		System.out.println("\t\t\t\t[1] 관리자 모드");
		System.out.println("\t\t\t\t[2] 학생 모드");
		System.out.println("\t\t\t\t[3] 교사 모드");
		System.out.println("\t\t\t\t[0] 프로그램 종료");
		System.out.println("\t\t\t\t――――――――――――――――――――――――――");
		System.out.print("\t\t\t\t선택 : ");
		String select = scan.nextLine();
		
		while(loop) {
			
			
			switch(select) {
				case "1" : // 관리자모드
					view.pause();
					AdminMain adminMain = new AdminMain();
					adminMain.cStart();
					break;
				case "2" : // 학생 모드
					view.pause();
					StudentController.start();
					break;
				case "3" : // 교사 모드
					view.pause();
					TeacherController.start();
					break;

				case "0" : // 프로그램 종료
					
					break;
					
			}	
			loop = false;
			view.end();
		}	
		
	}
}
