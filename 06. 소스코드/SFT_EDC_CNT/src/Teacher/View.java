package Teacher;

import java.util.Scanner;

public class View {

	public final static int menu = 0;
	public final static int schedule = 1;
	public final static int studentInfo = 2;
	public final static int gradeInputOutput = 3;
	public final static int gradeInput = 4;
	public final static int gradeOutput = 5;
	

	public void teacherMenu() { // 프로그램 시작, 교사메뉴
		System.out.println("\t------------------");
		System.out.println("\t[1] 강의스케줄 조회");
		System.out.println("\t[2] 성적 입출력");
		System.out.println("\t[3] 출결관리 및 조회");
		System.out.println("\t[4] 교사평가 조회");
		System.out.println("\t[5] 상담일지 조회");
		System.out.println("\t[0] 프로그램 종료");
		System.out.println("\t------------------");
		System.out.print("\t선택 : ");
	}

	public void end() { // 프로그램 종료
		System.out.println("프로그램을 종료합니다.");
	}

	public void title(int n) { // 타이틀 출력
		
		if (n == View.menu) {
			System.out.println("\t◆ 교사 메뉴 ◆");
		} else if (n == View.schedule) {
			System.out.println("\t\t◆ 강의스케줄 조회 ◆");
		} else if (n == View.studentInfo) {
			System.out.println("\t\t◆ 학생정보 조회 ◆");
		} else if (n == View.gradeInputOutput) {
			System.out.println("\t\t◆ 성적 입력 및 조회 ◆");
		} else if (n == View.gradeInput) {
			System.out.println("\t\t◆ 성적 입력 ◆");
		} else if (n == View.gradeOutput) {
			System.out.println("\t\t◆ 성적 조회 ◆");
		}

		
	}

	public void pause() throws InterruptedException { // 프로그램 넘어가기 전에 출력

		System.out.println("\t계속하려면 엔터를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();

		clearScreen();
		System.out.println("\t\t\t\t\tLOADING.....");
		Thread.sleep(700);
		clearScreen();

	}

	private void clearScreen() { // 화면지우기

		for (int i = 0; i < 50; i++) {
			System.out.println("");
		}

	}

//	public void select() { // 사용자 입력 선택
//		
//		System.out.println("[  ] 안의 번호를 입력해주세요.");
//		System.out.println();
//		
//		// 강의스케줄 조회
//		System.out.println("[1] 과목보기");
//		System.out.println("[2] 학생정보 보기");
//		System.out.println("[3] 교사 메뉴로 돌아가기");
//		System.out.println("------------------------");
//		System.out.print("번호 : ");
//		
//	}

}
