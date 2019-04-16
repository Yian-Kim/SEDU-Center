
// Service - Teacher - teacherEvaluation
	
// ----------------------------------------------------------------------
//		[4] 교사평가 조회  - (1) 메뉴
//----------------------------------------------------------------------

	
	@Override
	public void teacherEvaluation() throws InterruptedException { // 교사평가 메뉴

		view.title(View.evaluation);

		System.out.println();
		System.out.println("과정명 : [ DAO 작업 필요 ]");
		System.out.println();
		System.out.println("------------------------------");
		System.out.println();
		System.out.println("[1] 객관식 통계");
		System.out.println("[2] 좋았던 점");
		System.out.println("[3] 아쉬운 점 & 개선할 점");
		System.out.println("[0] 교사 메뉴로 돌아가기");
		System.out.println();
		System.out.println("------------------------------");
		System.out.println();
		System.out.println("[  ] 안의 번호를 입력해주세요.");
		System.out.println();
		System.out.print("선택 : ");
		int select = Integer.parseInt(scan.nextLine());
		String str = " ";
		view.pause();

		switch (select) {

		case 1: // 객관식 통계
			str = "객관식 통계";
			break;

		case 2: // 좋았던 점
			flag = 1;
			str = "좋았던 점";
			break;

		case 3: // 아쉬운 점 & 개선할 점
			flag = 1;
			str = "아쉬운 점 & 개선할 점";
			break;

		case 0: // 교사 메뉴로 돌아가기
			flag = 0;
			TeacherController.start();
			break;
		}

		evalOutput(select, str); // 출력

	}

	
// ----------------------------------------------------------------------
//			[4] 교사평가 조회 - (2) 평가결과
//----------------------------------------------------------------------

		
	@Override
	public void evalOutput(int select, String str) throws InterruptedException {

		view.title(View.evaluation);

		System.out.println();
		System.out.println("과정명 : [ DAO 작업 필요 ]");
		System.out.print("- ");

		if (select == 1) { // 객관식

			System.out.println(str);
			System.out.println("--------------------------------------------------------------------");
			System.out.println("번호\t질문\t\t\t매우그렇다\t그렇다\t보통이다\t아니다\t매우아니다");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("DAO작업 필요");

		} else if(select == 2 || select == 3) { // 주관식

			System.out.println(str);
			System.out.println("--------------------------------------------------------------------");
			System.out.println("번호\t내용");
			System.out.println("--------------------------------------------------------------------");
			
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
		}
		
		System.out.println("---------------------------------------------------------------");
		System.out.println("------------------------");
		System.out.println("[  ] 안의 번호를 입력해주세요.");
	
		if (select == 1) { // 객관식 통계 화면
			
			System.out.println();
			System.out.println("[1] 좋았던 점");
			System.out.println("[2] 아쉬운 점 & 개선할 점");
			System.out.println("[0] 교사 메뉴로 돌아가기");
			System.out.println("------------------------");
			System.out.print("번호 : ");
			
			
		} else if (select == 2) { // 좋았던 점 화면
			
			System.out.println();
			
			if (flag == 1) {
				System.out.println("[1] 다음 >>");
				System.out.println("[2] 객관식 통계");
				System.out.println("[3] 아쉬운 점 & 개선할 점");
				System.out.println("[0] 교사 메뉴로 돌아가기");
			} else if (flag == 2) {
				System.out.println("[1] 다음 >>");
				System.out.println("[2] 객관식 통계");
				System.out.println("[3] 아쉬운 점 & 개선할 점");
				System.out.println("[4] << 이전");
				System.out.println("[0] 교사 메뉴로 돌아가기");
			} else if (flag == 3) {
				System.out.println("[2] 객관식 통계");
				System.out.println("[3] 아쉬운 점 & 개선할 점");
				System.out.println("[4] << 이전");
				System.out.println("[0] 교사 메뉴로 돌아가기");
			}
			
		} else if (select == 3) { // 아쉬운 점 & 개선할 점 화면
			
			System.out.println();
			
			if (flag == 1) {
				System.out.println("[1] 다음 >>");
				System.out.println("[2] 객관식 통계");
				System.out.println("[3] 좋았던 점");
				System.out.println("[0] 교사 메뉴로 돌아가기");
			} else if (flag == 2) {
				System.out.println("[1] 다음 >>");
				System.out.println("[2] 객관식 통계");
				System.out.println("[3] 좋았던 점");
				System.out.println("[4] << 이전");
				System.out.println("[0] 교사 메뉴로 돌아가기");
			} else if (flag == 3) {
				System.out.println("[2] 객관식 통계");
				System.out.println("[3] 좋았던 점");
				System.out.println("[4] << 이전");
				System.out.println("[0] 교사 메뉴로 돌아가기");
			}
			
		}
		
		System.out.println("------------------------");
		System.out.print("번호 : ");
		String num = scan.nextLine();
		view.pause();
		
		switch(num) {
		
			case "1" :
				if (select == 1) { // 객관식 통계 -> 좋았던 점
					str = "좋았던 점"; 
					select = 2;
					flag = 1;
				} else if (select == 2) { // 좋았던 점, 다음
					str = "좋았던 점";
					flag++;
				} else if (select == 3) { // 아쉬운 점 & 개선할 점, 다음
					str = "아쉬운 점 & 개선할 점"; 
					flag++;
				}		
				break;
			
			case "2" :
				if (select == 1) { // 객관식 통계 -> 아쉬운 점 &개선할 점
					str = "아쉬운 점 & 개선할 점";
					select = 3;
					flag = 1;
				} else if (select == 2 || select == 3) { // 좋았던 점, 아쉬운 점 -> 객관식 통계
					str = "객관식 통계";
					select = 1;
				}
				break;
			
			case "3" :
				if (select == 2) { // 좋았던 점 <-> 아쉬운 점 & 개선할 점
					str = "아쉬운 점 & 개선할 점";
					select = 3;
					flag = 1;
				} else if (select == 3) {
					str = "좋았던 점";
					select = 2;
					flag = 1;
				}
				break;
			
			case "4" : // 이전
				
				if (select == 2) { str = "좋았던 점"; } 
				else if (select == 3) { str = "아쉬운 점 & 개선할 점"; }
				
				flag --;
				evalOutput(select, str);
				break;
				
			case "0" : // 교사 메누로 돌아가기
				flag = 0;
				TeacherController.start();
				break;
		
		}

	}