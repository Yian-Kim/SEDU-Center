package Teacher;

import java.util.Scanner;

// 업무 담당자
// 데이터 입출력, 화면 입출력, 데이터 연상 가공 등 담당하는 클래스
// 단, 업무가 과하거나 반복되는 다른 객체에게 위임 > 분산 예정
public class Service implements IService {

	// 업무 중 일부가 DAO에게 위임 > 선택
	// private DAO dao;
	private View view;
	private Scanner scan;
	private static int flag = 0;

	public Service() {
		// this.dao = new DAO();
		view = new View();
		scan = new Scanner(System.in);
	}


// ----------------------------------------------------------------------
//		[1] 강의스케줄 조회 - (1) 과정, 과목 출력
// ----------------------------------------------------------------------
	
	
	@Override
	public void teacherSchedule() throws InterruptedException { // 강의스케줄 조회

		view.title(View.Schedule); // 타이틀 출력

		System.out.println("-----------------------------------------------");
		System.out.println("강의명\t\t시작날짜\t종료날짜\t강의실명");
		System.out.println("-----------------------------------------------");
		System.out.println("// DAO 부분");
		System.out.println("-----------------------------------------------");
		String select = "";

		if (flag == 0) { // 맨 처음에는 flag가 0, 선택 메뉴 출력

			System.out.println("------------------------");
			System.out.println("[  ] 안의 번호를 입력해주세요.");
			System.out.println();
			System.out.println("[1] 과목보기");
			System.out.println("[2] 학생정보 보기");
			System.out.println("[0] 교사 메뉴로 돌아가기");
			System.out.println("------------------------");
			System.out.print("번호 : ");
		}

		if (flag == 1) { // 과목 출력
			System.out.println("-----------------------------------------------");
			System.out.println("과목명\t\t시작날짜\t종료날짜\t학습기간");
			System.out.println("-----------------------------------------------");
			System.out.println("// DAO 부분");
			System.out.println("-----------------------------------------------");
			System.out.println("------------------------");
			System.out.println("[  ] 안의 번호를 입력해주세요.");
			System.out.println();
			System.out.println("[2] 학생정보 보기");
			System.out.println("[0] 교사 메뉴로 돌아가기");
			System.out.println("------------------------");
			System.out.print("번호 : ");

		}

		select = scan.nextLine(); // 선택 번호 입력
		view.pause();

		switch (select) {

		case "1": // 과목보기
			flag = 1;
			teacherSchedule();
			break;

		case "2": // 학생정보 보기
			flag = 1;
			studentInfo();
			break;

		case "0": // 교사 메뉴로 돌아가기
			flag = 0;
			TeacherController.start();
			break;
		}
	}

	
// ----------------------------------------------------------------------
//		[1] 강의스케줄 조회 - (2) 학생정보 출력
// ----------------------------------------------------------------------
		

	@Override
	public void studentInfo() throws InterruptedException { // 강의스케줄 조회 - 학생정보 보기

		view.title(View.StudentInfo); // 타이틀 출력

		System.out.println("---------------------------------------------------------------");
		System.out.println("이름\t학번\t연락처\t\t전공\t\t수강중인 과정");
		System.out.println("---------------------------------------------------------------");
		
		if (flag == 1) { // 25명 중 1~10번까지 DAO 출력
			
			System.out.println("DAO 출력");
			System.out.println("---------------------------------------------------------------");
			System.out.println("\t\t(1..10 / 25)");
			
		} else if (flag == 2) { // 25명 중 11~20번까지 DAO 출력
			
			System.out.println("DAO 출력");
			System.out.println("---------------------------------------------------------------");
			System.out.println("\t\t(11..20 / 25)");
			
		} else if (flag == 3) { // 25명 중 21~25번까지 DAO 출력
			
			System.out.println("DAO 출력");
			System.out.println("---------------------------------------------------------------");
			System.out.println("\t\t(21..25 / 25)");
			
		}
		
		System.out.println("---------------------------------------------------------------");
		System.out.println("------------------------");
		System.out.println("[  ] 안의 번호를 입력해주세요.");
		
		if (flag == 1) {
			System.out.println("[1] 더보기");
			System.out.println("[0] 교사 메뉴로 돌아가기");
		} else if (flag == 2) {
			System.out.println("[1] 더보기");
			System.out.println("[2] 이전으로 돌아가기");
			System.out.println("[0] 교사 메뉴로 돌아가기");
		} else if (flag == 3) {
			System.out.println("[2] 이전으로 돌아가기");
			System.out.println("[0] 교사 메뉴로 돌아가기");
		}

		System.out.println("------------------------");
		System.out.print("번호 : ");
		String select = scan.nextLine(); // 선택 번호 입력
		view.pause();

		switch (select) {

		case "1": // 더보기
			flag++;
			studentInfo();
			break;

		case "2": // 이전으로 돌아가기
			flag--;
			studentInfo();
			break;

		case "0": // 교사 메뉴로 돌아가기
			flag = 0;
			TeacherController.start();
			break;
		}
	}

	
// ----------------------------------------------------------------------
//		[2] 성적 입출력
// ----------------------------------------------------------------------
		
	@Override
	public void gradeOuput() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attendanceMGMT() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teacherEvaluation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teacherConsult() {
		// TODO Auto-generated method stub
		
	}



}
