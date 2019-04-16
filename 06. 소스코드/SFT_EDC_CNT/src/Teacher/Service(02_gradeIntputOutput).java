
// Service - Teacher - GradeIntputOutput

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

		switch (select) {

		case "1": // 성적입력
			System.out.println("성적을 입력하실 [ 과목번호 ]를 입력해주세요.");
			System.out.print("과목번호 : ");
			subjectNum = scan.nextLine(); // 과목번호

			System.out.println("-------------------------------------------------");
			System.out.println("[ DAO 부분 작업 : 과목명 ] 성적입력 화면으로 이동합니다...");

			view.pause();
			flag = 1;
			gradeInput();
			break;

		case "2": // 성적조회
			System.out.println("성적을 조회하실 [ 과목번호 ]를 입력해주세요.");
			System.out.print("과목번호 : ");
			subjectNum = scan.nextLine(); // 과목번호

			System.out.println("-------------------------------------------------");
			System.out.println("[ DAO 부분 작업 : 과목명 ] 성적조회 화면으로 이동합니다...");

			view.pause();
			flag = 1;
			gradeOutput();
			break;

		case "0": // 교사 메뉴로 돌아가기
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

		if (flag == 1) {
			System.out.println("[1] 다음 >>");
			System.out.println("[2] 점수입력");
			System.out.println("[#] 과목목록으로 돌아가기");
			System.out.println("[0] 교사 메뉴로 돌아가기");
		} else if (flag == 2) {
			System.out.println("[1] 다음 >>");
			System.out.println("[2] 점수입력");
			System.out.println("[3] << 이전");
			System.out.println("[#] 과목목록으로 돌아가기");
			System.out.println("[0] 교사 메뉴로 돌아가기");
		} else if (flag == 3) {
			System.out.println("[2] 점수입력");
			System.out.println("[3] << 이전");
			System.out.println("[#] 과목목록으로 돌아가기");
			System.out.println("[0] 교사 메뉴로 돌아가기");
		}

		System.out.println("------------------------");
		System.out.print("번호 : ");
		String select = scan.nextLine(); // 선택 번호 입력
		view.pause();

		switch (select) {

		case "1": // 더보기
			flag++;
			gradeOutput();
			break;

		case "2": // 점수입력
			gradeInput();
			view.pause();
			break;

		case "3": // 이전으로 돌아가기
			flag--;
			gradeOutput();
			break;

		case "#": // 과목목록으로 돌아가기
			flag = 1;
			gradeInputOuput();
			break;

		case "0": // 교사 메뉴로 돌아가기
			flag = 0;
			TeacherController.start();
			break;
		}
	}

// ----------------------------------------------------------------------
//		[2] 성적 입출력 - (3) 성적입력
// ----------------------------------------------------------------------

	@Override
	public void gradeInput() throws InterruptedException { // 성적조회

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

