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

		view.title(View.schedule); // 타이틀 출력

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

		view.title(View.studentInfo); // 타이틀 출력

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
//		[2] 성적 입출력 - (1) 과정, 과목 출력
// ----------------------------------------------------------------------

	
	@Override
	public void gradeInputOuput() throws InterruptedException { // 성적입출력
		
		view.title(View.gradeInputOutput);
		
		System.out.println("-----------------------------------------------");
		System.out.println("과정번호\t과정명\t\t시작날짜\t종료날짜\t강의실명");
		System.out.println("-----------------------------------------------");
		System.out.println("// DAO 부분");
		System.out.println("-----------------------------------------------");
		System.out.println();
		System.out.println("-----------------------------------------------");
		System.out.println("과목번호\t과목명\t\t종료날짜");
		System.out.println("-----------------------------------------------");
		System.out.println("// DAO 부분");
		System.out.println("-----------------------------------------------");
		System.out.println();
		System.out.println("------------------------");
		System.out.println("[  ] 안의 번호를 입력해주세요.");
		System.out.println();
		System.out.println("[1] 성적입력");
		System.out.println("[2] 성적조회");
		System.out.println("[0] 교사 메뉴로 돌아가기");
		System.out.println("------------------------");
		System.out.print("선택 : ");
		String select = scan.nextLine(); // 선택 번호 입력
		System.out.println("-----------------------------------");
		
		String subjectNum = "";
		
		switch(select) {
		
			case "1" : // 성적입력
				System.out.println("성적을 입력하실 [ 과목번호 ]를 입력해주세요.");
				System.out.print("과목번호 : ");
				subjectNum = scan.nextLine(); // 과목번호
				
				System.out.println("-------------------------------------------------");
				System.out.println("[ DAO 부분 작업 : 과목명 ] 성적입력 화면으로 이동합니다...");
				
				view.pause();
				flag = 1;
				gradeInput();
				break;
				
			case "2" : // 성적조회
				System.out.println("성적을 조회하실 [ 과목번호 ]를 입력해주세요.");
				System.out.print("과목번호 : ");
				subjectNum = scan.nextLine(); // 과목번호
				
				System.out.println("-------------------------------------------------");
				System.out.println("[ DAO 부분 작업 : 과목명 ] 성적조회 화면으로 이동합니다...");
				
				view.pause();
				flag = 1;
				gradeOutput();
				break;
				
			case "0" : // 교사 메뉴로 돌아가기
				view.pause();
				TeacherController.start();
				break;
		}
	}
	
	
// ----------------------------------------------------------------------
//		[2] 성적 입출력 - (2) 성적조회
// ----------------------------------------------------------------------
			
	
	@Override
	public void gradeOutput() throws InterruptedException { // 성적조회
		
		view.title(View.gradeOutput);
		System.out.println();
		System.out.println("과정명 : DAO 작업 필요");
		System.out.println("과목명 : DAO 작업 필요");
		System.out.println();
		System.out.println("-----------------------------------------------------------");
		System.out.println("학번\t이름\t과목명\t\t점수");
		System.out.println("-----------------------------------------------------------");
		
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
		System.out.println();

		view.title(View.gradeInput);
		
		System.out.println();
		System.out.println("과정명 : DAO 작업 필요");
		System.out.println("과목명 : DAO 작업 필요");
		System.out.println();
		System.out.println("-----------------------------------------------------------");
		System.out.println("학번\t이름\t과목명\t\t점수");
		System.out.println("-----------------------------------------------------------");
		
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
		System.out.println("입력하실 [ 학번 ] 과 [ 점수 ]를 입력해주세요.");
		System.out.println();
		System.out.print("학번 : ");
		String studentNum = scan.nextLine(); 
		System.out.print("점수 : ");
		String score = scan.nextLine();
		System.out.println("DAO 작업 필요\n// ** 보고 있는 화면에 따라서 출력되는 화면이 달라짐\n//SQL 수정 필요"); 
		System.out.println("------------------------");
		System.out.println("수정되었습니다. 성적조회 화면으로 이동합니다.");
		view.pause();
		gradeOutput();
	}
	
	
// ----------------------------------------------------------------------
//		[3] 출결관리 및 조회 - (3) 성적입력
// ----------------------------------------------------------------------

			

	@Override
	public void teacherEvaluation() {
		// TODO Auto-generated method stub

	}

	@Override
	public void teacherConsult() {
		// TODO Auto-generated method stub

	}





}
