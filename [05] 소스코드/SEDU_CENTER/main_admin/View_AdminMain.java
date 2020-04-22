package main_admin;

import java.util.Scanner;

import Teacher.TeacherView;

public class View_AdminMain {

	public final static int login = 0;
	public final static int menu = 1;
	public final static int schedule = 2;
	public final static int studentInfo = 2;
	public final static int gradeInputOutput = 3;
	public final static int gradeInput = 4;
	public final static int gradeOutput = 5;
	public final static int attendanceMGMT = 6;
	public final static int attendanceOutput = 7;
	public final static int attendanceInput = 8;
	public final static int evaluation = 9;
	public final static int consult = 10;


	// public static View_AdminMain view = new View_AdminMain();
	
	public void title(int n) { // 타이틀 출력

		if (n == View_AdminMain.login) {
			System.out.println();
			System.out.println("\t\t\t――――――――――――――――――――――――――");
			System.out.println("\t\t\t◆\t관리자 계정 로그인\t◆");
			System.out.println("\t\t\t――――――――――――――――――――――――――");
		} else if (n == View_AdminMain.menu) {
			System.out.println();
			System.out.println("\t\t\t――――――――――――――――――――――――――");
			System.out.println("\t\t\t◆\t관리자 메뉴\t◆");
			System.out.println("\t\t\t――――――――――――――――――――――――――");
		} else if (n == TeacherView.schedule) {
			System.out.println();
			System.out.println("\t\t\t――――――――――――――――――――――――――");
			System.out.println("\t\t\t◆\t강의스케줄 조회\t◆");
			System.out.println("\t\t\t――――――――――――――――――――――――――");
		} else if (n == TeacherView.studentInfo) {
			System.out.println();
			System.out.println("\t\t\t――――――――――――――――――――――――――");
			System.out.println("\t\t\t◆\t학생정보 조회\t◆");
			System.out.println("\t\t\t――――――――――――――――――――――――――");
		} else if (n == TeacherView.gradeInputOutput) {
			System.out.println();
			System.out.println("\t\t\t――――――――――――――――――――――――――");
			System.out.println("\t\t\t◆\t성적입력 및 조회\t◆");
			System.out.println("\t\t\t――――――――――――――――――――――――――");
		} else if (n == TeacherView.gradeInput) {
			System.out.println();
			System.out.println("\t\t\t――――――――――――――――――――――――――");
			System.out.println("\t\t\t◆\t성적입력\t◆");
			System.out.println("\t\t\t――――――――――――――――――――――――――");
		} else if (n == TeacherView.gradeOutput) {
			System.out.println();
			System.out.println("\t\t\t――――――――――――――――――――――――――");
			System.out.println("\t\t\t◆\t성적조회\t◆");
			System.out.println("\t\t\t――――――――――――――――――――――――――");
		} else if (n == TeacherView.attendanceMGMT) {
			System.out.println();
			System.out.println("\t\t\t――――――――――――――――――――――――――");
			System.out.println("\t\t\t◆\t출결관리 및 조회\t◆");
			System.out.println("\t\t\t――――――――――――――――――――――――――");
		} else if (n == TeacherView.attendanceOutput) {
			System.out.println();
			System.out.println("\t\t\t――――――――――――――――――――――――――");
			System.out.println("\t\t\t◆\t출결조회\t\t◆");
			System.out.println("\t\t\t――――――――――――――――――――――――――");
		} else if (n == TeacherView.attendanceInput) {
			System.out.println();
			System.out.println("\t\t\t――――――――――――――――――――――――――");
			System.out.println("\t\t\t◆\t출결입력\t\t◆");
			System.out.println("\t\t\t――――――――――――――――――――――――――");
		} else if (n == TeacherView.evaluation) {
			System.out.println();
			System.out.println("\t\t\t――――――――――――――――――――――――――");
			System.out.println("\t\t\t◆\t교사평가 조회\t◆");
			System.out.println("\t\t\t――――――――――――――――――――――――――");

		} else if (n == TeacherView.consult) {
			System.out.println();
			System.out.println("\t\t\t――――――――――――――――――――――――――");
			System.out.println("\t\t\t◆\t상담일지 조회\t◆");
			System.out.println("\t\t\t――――――――――――――――――――――――――");
		} else if (n == TeacherView.login) {
			System.out.println();
			System.out.println("\t\t\t――――――――――――――――――――――――――");
			System.out.println("\t\t\t◆\t교사 계정 로그인\t◆");
			System.out.println("\t\t\t――――――――――――――――――――――――――");
		}
	}
	
	public void logo() { // 로고
		
		System.out.println("\n\n");
		System.out.println("\t\t┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┐");
		System.out.println();
		System.out.println(""
				+ "\t      _____ __________  __  _______________   __________________ \r\n" + 
				"\t     / ___// ____/ __ \\/ / / / ____/ ____/ | / /_  __/ ____/ __ \\\r\n" + 
				"\t     \\__ \\/ __/ / / / / / / / /   / __/ /  |/ / / / / __/ / /_/ /\r\n" + 
				"\t    ___/ / /___/ /_/ / /_/ / /___/ /___/ /|  / / / / /___/ _, _/ \r\n" + 
				"\t   /____/_____/_____/\\____/\\____/_____/_/ |_/ /_/ /_____/_/ |_| "); // 2칸 띄어쓰기
		System.out.println();
		System.out.println("\t\t\t\t\tSince 2019.04.17. | 디비 2조");
		System.out.println("\t\t┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┚");

	}

	/**
	 * 번호 선택지 출력 메소드
	 */
	public void vNumSelect() {
		System.out.print("번호 : ");
	}

//	/**
//	 * 관리자 로그인 전 메뉴출력 메소드
//	 */
//	public void vInitialMenu() {
//
//		System.out.println("========================================");
//		System.out.println("\t1. 관리자");
//		System.out.println("========================================");
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println("1. 로그인");
//		System.out.println("0. 뒤로가기");
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println();
//
//	}

	/**
	 * 로그인 실패 멘트 출력 메소드
	 */
	public void vWrong() {
		System.out.println("잘못 입력하셨습니다. 다시입력해주세요.");
	}

	/**
	 * 관리자 메뉴 출력 메소드
	 */
	public void menu() {

		System.out.println("\t\t\t――――――――――――――――――――――――――");
//		System.out.println("\t1. 관리자");
//		System.out.println("\t\t\t――――――――――――――――――――――――――");
		System.out.println();
		System.out.println("\t\t\t[1] 교사 계정 관리");
		System.out.println("\t\t\t[2] 개설 과정 및 과목 관리");
		System.out.println("\t\t\t[3] 학생 관리");
		System.out.println("\t\t\t[4] 시험 관리 및 성적 조회");
		System.out.println("\t\t\t[5] 출결 관리 및 출결 조회");
		System.out.println("\t\t\t[6] 교사 평가 관리 및 결과 조회");
		System.out.println("\t\t\t[7] 상담일지 관리 및 조회");
		System.out.println();
		System.out.println("\t\t\t[0] 로그아웃");
		System.out.println("\t\t\t――――――――――――――――――――――――――");

	}
	
	public void pause() { // 프로그램 넘어가기 전에 출력

		System.out.println("\t\t\t――――――――――――――――――――――――――");
		System.out.println("\t\t\t계속하려면 엔터를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();

		clearScreen();
		System.out.println("\t\t\t\t\tLOADING.....");
		try {
			Thread.sleep(700);
		} catch (Exception e) {
			e.printStackTrace();
		}
		clearScreen();

	}

	private void clearScreen() { // 화면지우기

		for (int i = 0; i < 50; i++) {
			System.out.println("");
		}

	}

}
