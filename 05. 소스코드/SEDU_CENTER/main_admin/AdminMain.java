package main_admin;

import java.util.ArrayList;
import java.util.Scanner;

import Admin.IService_AdminFunction2_A;
import Admin.IService_AdminFunction_A;
import Admin.IService_gradeViews;
import Admin.IService_studentManagement;
import Admin.Service_AdminFunction1;
import Admin.Service_AdminFunction2_A;
import Admin.Service_AdminFunction_A;
import Admin.Service_GradeViews;
import Admin.Service_StudentManagement;
import Admin.View_AdminFunction2_A;
import Admin.View_AdminFunction_A;
import Admin.View_GradeViews;
import Admin.View_StudentManagement;
import DTO_admin.DTO;
import dto_common.DTO_Student;

/**
 * MVC 패턴에서 관리자 컨트롤러 역할
 * 
 *
 */
public class AdminMain {

	private View_AdminMain view;
	private IService_AdminMain iAdminMainService;
	private IService_studentManagement srvc_stdntMgmt;
	private IService_AdminFunction_A adminFunction;
	private View_AdminFunction_A viewAdminFunction;
	private View_AdminFunction2_A viewAdminFunction2;
	private View_StudentManagement viewStudentManagement; // 뷰 - 1. 관리자 - 3. 학생관리
	private View_GradeViews viewGradeViews; // 뷰 - 1. 관리자 - 4. 성적조회
	private IService_AdminFunction2_A adminFunction2;
	private IService_gradeViews srvc_gradeViews; // 서비스 - 1. 관리자 - 4. 성적조회
	private Service_AdminFunction1 adminfunction1;
	private Scanner scan;
	public static String id;
	public static String pw;

	/**
	 * MVC 패턴에서 Service 와 View 를 초기화 해주는 생성자
	 */
	public AdminMain() {

		iAdminMainService = new Service_AdminMain();
		srvc_stdntMgmt = new Service_StudentManagement();
		adminFunction = new Service_AdminFunction_A();
		adminfunction1 = new Service_AdminFunction1();
		adminFunction2 = new Service_AdminFunction2_A();
		srvc_gradeViews = new Service_GradeViews(); // 서비스 - 1. 관리자 - 4. 성적조회
		view = new View_AdminMain();
		viewAdminFunction = new View_AdminFunction_A();
		viewAdminFunction2 = new View_AdminFunction2_A();
		viewStudentManagement = new View_StudentManagement(); // 뷰 - 1. 관리자 - 3. 학생관리
		viewGradeViews = new View_GradeViews(); // 뷰 - 1. 관리자 - 4. 성적조회
		scan = new Scanner(System.in);

	}

	/**
	 * 관리자 메인메뉴를 출력하고 값을 입력받는 메소드
	 */
	public void cStart() {

		// view.title(View_AdminMain.menu);
		view.logo();
		view.title(View_AdminMain.login);
		cLogin();


//		int num = scan.nextInt();
//		scan.nextLine();
//		view.pause();

	}

	/**
	 * 관리자 로그인 메소드
	 * 
	 * @param num 로그인으로 이동할 지 이전 메뉴로 돌아갈지 판단해주는 매개변수
	 */
	public void cLogin() {

		boolean flag = true;

		while (flag) {

			flag = false;

			boolean loginFlag = false;

			while (!loginFlag) {
				System.out.print("\t\t\t- ID(이름) : ");
				id = scan.nextLine();
				System.out.print("\t\t\t- PW(주민번호 뒷자리) : ");
				pw = scan.nextLine();

				loginFlag = iAdminMainService.sLogin(id, pw); // 아이디와 비밀번호가 있는지 확인

				if (!loginFlag)
					System.out.println("\t\t\t아이디 또는 비밀번호가 없습니다.");
				else {
					view.pause();
					cAdminMainMenu();
				}
			}

			if (flag) {
				view.vWrong(); // 잘못입력표시
			}

		}
	}

	/**
	 * 관리자 메뉴와 해당 메뉴 선택하여 기능 수행하는 메소드
	 */
	public void cAdminMainMenu() {

		boolean flag = true;

		while (flag) {

			view.title(View_AdminMain.menu);
			view.menu();
			System.out.print("\t\t\t입력 : ");
			int num = scan.nextInt();
//			scan.nextLine();
			view.pause();

			if (num == 1) {

				flag = false;
				// 관리자 1번기능
				adminfunction1.adminFunction1Start();

			} else if (num == 2) {

				flag = false;
				// 관리자 2번기능

				adminFunction.sOpenMgmtInfo();
				String select = scan.nextLine();

				view.pause();

				amOCSmgmt(select);

			} else if (num == 3) {

				flag = false;
				// 관리자 3번기능
				srvc_stdntMgmt.StudentManagementInfo(); // 1.관리자 - 3.학생관리
				String select = scan.nextLine();

				stdntMgmt(select);

			} else if (num == 4) {

				flag = false;
				// 관리자 4번기능
				srvc_gradeViews.gradeViewsInfo(); // 1.관리자 - 4.성적조회
				String select = scan.nextLine();

				gradeViews(select);

			} else if (num == 5) {

				// 관리자 5번기능

				flag = false;
				cAttendanceMgmt();

			} else if (num == 6) {

				// 관리자 6번기능

				flag = false;
				cTeacherEvalMgmt();

			} else if (num == 7) {

				// 관리자 7번기능

				flag = false;
				cConsult();

			} else if (num == 0) {

				flag = false;
				cStart();

			} else {
				view.vWrong(); // 잘못입력 표시
			}
		}

	}

//	/**
//	 * 관리자 > 교사 계정 관리 기능 수행하기 위해 초기화 시켜주는 생성자
//	 */
//	public Service_AdminFunction1() {
//		view = new View();
//		service = new Service();
//		scan = new Scanner(System.in);
//		
//	}
//	
//	/**
//	 * 관리자 > 교사 계정 관리 기능 수행 메소드
//	 */
//	public void adminFunction1Start() {
//		
//		
//		
//		boolean loop =true;
//		while(loop) {
//			
//			ArrayList<DTO> list = service.list();
//			
//			view.begin();
//			view.list(list);
//			view.menu();
//			
//			String sel = scan.nextLine();
//			view.pause();
//			if(sel.equals("a"))service.add();
//			else if(sel.equals("b"))service.edit();
//			else if(sel.equals("c"))service.del();
//			else if(sel.equals("z")) {
//				loop= false;
//				AdminMain adminMain = new AdminMain();
//				adminMain.cAdminMainMenu();
//			}
//			else service.detail(sel);
//			
//			System.out.println();
//		
//		}
//		
//	}
	
	
	/**
	 * 관리자 > 출결 관리 및 출결조회에 대한 컨트롤러
	 */
	public void cAttendanceMgmt() {

		viewAdminFunction2.vAttendanceMgmt();

		String select = scan.nextLine();

		view.pause();

		if (select.equalsIgnoreCase("a")) {

			// 1. 관리자 - 5. 출결 관리 및 출결조회 -a. 학생별 조회 및 수정
			cAttendanceStudentInfoModify();

		} else if (select.equalsIgnoreCase("b")) {

			// 1. 관리자 - 5. 출결 관리 및 출결조회 -b. 과정별 조회
			cAttendanceCourseInfo();

		} else if (select.equalsIgnoreCase("z")) {
			// 관리자 초기메뉴로 돌아가기
			cAdminMainMenu();
		}

	}

	/**
	 * 관리자 > 출결 관리 및 출결조회 > 과정별 조회
	 */
	public void cAttendanceCourseInfo() {

		// 1. 관리자 - 5. 출결 관리 및 출결조회 -b. 과정별 조회
		adminFunction2.sAttendanceCourseInfo();

		String select = scan.nextLine();

		view.pause();

		if (select.equalsIgnoreCase("z")) {
			// 1. 관리자 - 5. 출결 관리 및 출결조회로 이동
			cAttendanceMgmt();
		} else {
			adminFunction2.sAttendanceCourseView(select);

			String choice = scan.nextLine();

			if (choice.equalsIgnoreCase("a")) {
				adminFunction2.sAttendanceCourseModify(choice);

				// 1. 관리자 - 5. 출결 관리 및 출결조회 -b. 과정별 조회로 돌아감
				cAttendanceCourseInfo();

			} else if (choice.equalsIgnoreCase("z")) {
				view.pause();
				// 1. 관리자 - 5. 출결 관리 및 출결조회 -b. 과정별 조회로 돌아감
				cAttendanceCourseInfo();
			}
		}

	}

	/**
	 * 관리자 > 출결 관리 및 출결조회 > 학생별 조회 및 수정
	 */
	public void cAttendanceStudentInfoModify() {
		// 1. 관리자 - 5. 출결 관리 및 출결조회 -a. 학생별 조회 및 수정

		adminFunction2.sAttendanceStudentInfoModify();

		String choice = scan.nextLine();

		if (choice.equalsIgnoreCase("z")) {
			view.pause();

			// 1. 관리자 - 5. 출결 관리 및 출결조회로 이동
			cAttendanceMgmt();
		} else {
			System.out.println("- 조회기간을 입력해 주세요(ex 2018-01-01)");
			System.out.print("시작일(ex 2018-01-01) : ");
			String startDate = scan.nextLine();
			System.out.print("종료일(ex 2018-01-01) : ");
			String endDate = scan.nextLine();

			view.pause();

			adminFunction2.sAttendanceStudentInfoModifySelect(choice, startDate, endDate);

			String sel = scan.nextLine();

			if (sel.equalsIgnoreCase("a")) {

				// 근태상황 수정하기
				adminFunction2.sAttendanceStateModify();

				// 1. 관리자 - 5. 출결 관리 및 출결조회 -a. 학생별 조회 및 수정으로 돌아감
				cAttendanceStudentInfoModify();
			} else if (sel.equalsIgnoreCase("z")) {
				view.pause();
				// 1. 관리자 - 5. 출결 관리 및 출결조회 -a. 학생별 조회 및 수정으로 돌아감
				cAttendanceStudentInfoModify();
			}

		}

	}

	/**
	 * 관리자 > 상담일지 관리 및 조회
	 */
	public void cConsult() {

		// 1. 관리자 - 7. 상담일지 관리 및 조회
		viewAdminFunction.vConsult();
		System.out.print("\t\t\t선택 : ");
		String select = scan.nextLine();
		System.out.println();
		view.pause();

		if (select.equalsIgnoreCase("a")) {

			// 1. 관리자 - 7. 상담일지 관리 및 조회 - a. 상담 요청 내역
			viewAdminFunction.vConsultRequestInfo();
			String choice = scan.nextLine();

			view.pause();

			if (choice.equalsIgnoreCase("a")) {

				// 1. 관리자 - 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 - a. 일괄 조회 및 수정

				adminFunction.sConsultRequestInfoModify();

				String sel = scan.nextLine();

				if (sel.equalsIgnoreCase("a")) {
					// 요청내역 수정
					adminFunction.sConsultRequestModify();
					view.pause();

					cConsult();

				} else if (sel.equalsIgnoreCase("b")) {
					// 요청내역 삭제
					adminFunction.sConsultRequestDelete();
					view.pause();

					cConsult();

				} else if (sel.equalsIgnoreCase("z")) {
					// 뒤로가기
					view.pause();
					cConsult();
				}

			} else if (choice.equalsIgnoreCase("b")) {
				// 1. 관리자 - 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 - b. 과정별 조회 및 수정

				cConsultCourse();

			} else if (choice.equalsIgnoreCase("c")) {
				// 1. 관리자 – 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 – c. 학생별 조회 및 수정

				cConsultStudent();

			} else if (choice.equalsIgnoreCase("z")) {
				cConsult();
			}

		} else if (select.equalsIgnoreCase("b")) {
			// 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역

			cConsultResult();

		} else if (select.equalsIgnoreCase("z")) {
			cAdminMainMenu();
		}

	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 일지 내역
	 */
	public void cConsultResult() {
		// 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역

		viewAdminFunction.vConsultResult();

		String select = scan.nextLine();
		view.pause();

		if (select.equalsIgnoreCase("a")) {

			// 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역 - a. 일괄 조회 및 수정

			adminFunction.sConsultResultInfo();

			String choice = scan.nextLine();

			if (choice.equalsIgnoreCase("a")) {
				// 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역 - a. 일괄 조회 및 수정 - 수정하기
				adminFunction.sConsultResultModify();
				view.pause();
				cConsultResult();

			} else if (choice.equalsIgnoreCase("b")) {
				// 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역 - a. 일괄 조회 및 수정 - 삭제하기
				adminFunction.sConsultResultDelete();
				view.pause();
				cConsultResult();

			} else if (choice.equalsIgnoreCase("z")) {
				view.pause();
				// 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역으로 돌아감
				cConsultResult();
			}

		} else if (select.equalsIgnoreCase("b")) {
			// 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역 - b. 과정별 조회 및 수정
			adminFunction.sConsultResultInfoCourse();

			String choice = scan.nextLine();
			view.pause();

			if (choice.equalsIgnoreCase("z")) {
				// 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역으로 돌아감
				cConsultResult();
			} else {

				// 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역 - b. 과정별 조회 및 수정 - 1. 선택
				adminFunction.sConsultResultInfoCourseViewModify(choice);

				String sel = scan.nextLine();

				if (sel.equalsIgnoreCase("a")) {

					// 상담일지 수정
					adminFunction.sConsultResultModify();
					view.pause();
					// 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역으로 돌아감
					cConsultResult();

				} else if (sel.equalsIgnoreCase("b")) {

					// 상담일지 삭제
					adminFunction.sConsultResultDelete();
					view.pause();
					// 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역으로 돌아감
					cConsultResult();

				} else if (sel.equalsIgnoreCase("z")) {
					view.pause();
					// 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역으로 돌아감
					cConsultResult();
				}

			}

		} else if (select.equalsIgnoreCase("c")) {
			// 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역 - c. 학생별 조회 및 수정
			cConsultRecordStudent();

		} else if (select.equalsIgnoreCase("z")) {
			// 1. 관리자 - 7. 상담일지 관리 및 조회로 돌아감
			cConsult();

		}

	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 일지 내역 > 학생별 조회 및 수정
	 */
	private void cConsultRecordStudent() {
		// 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역 - c. 학생별 조회 및 수정

		viewAdminFunction.vConsultRecordStudentInfoModify();

		String select = scan.nextLine();
		view.pause();

		if (select.equalsIgnoreCase("a")) {

			adminFunction.cConsultRecordStudentName();

			String choice = scan.nextLine();

			if (choice.equalsIgnoreCase("a")) {

				// 상담일지 수정
				adminFunction.sConsultResultModify();
				view.pause();
				// 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역 - c. 학생별 조회 및 수정으로 돌아감
				cConsultRecordStudent();

			} else if (choice.equalsIgnoreCase("b")) {

				// 상담일지 삭제
				adminFunction.sConsultResultDelete();
				view.pause();
				// 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역 - c. 학생별 조회 및 수정으로 돌아감
				cConsultRecordStudent();

			} else if (choice.equalsIgnoreCase("z")) {
				view.pause();
				// 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역 - c. 학생별 조회 및 수정으로 돌아감
				cConsultRecordStudent();
			}

		} else if (select.equalsIgnoreCase("b")) {

			adminFunction.cConsultRecordStudentPw();

			String choice = scan.nextLine();

			if (choice.equalsIgnoreCase("a")) {

				// 상담일지 수정
				adminFunction.sConsultResultModify();
				view.pause();
				// 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역 - c. 학생별 조회 및 수정으로 돌아감
				cConsultRecordStudent();

			} else if (choice.equalsIgnoreCase("b")) {

				// 상담일지 삭제
				adminFunction.sConsultResultDelete();
				view.pause();
				// 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역 - c. 학생별 조회 및 수정으로 돌아감
				cConsultRecordStudent();

			} else if (choice.equalsIgnoreCase("z")) {
				view.pause();
				// 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역 - c. 학생별 조회 및 수정으로 돌아감
				cConsultRecordStudent();
			}

		} else if (select.equalsIgnoreCase("c")) {

			adminFunction.cConsultRecordStudentMajor();

			String choice = scan.nextLine();

			if (choice.equalsIgnoreCase("a")) {

				// 상담일지 수정
				adminFunction.sConsultResultModify();
				view.pause();
				// 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역 - c. 학생별 조회 및 수정으로 돌아감
				cConsultRecordStudent();

			} else if (choice.equalsIgnoreCase("b")) {

				// 상담일지 삭제
				adminFunction.sConsultResultDelete();
				view.pause();
				// 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역 - c. 학생별 조회 및 수정으로 돌아감
				cConsultRecordStudent();

			} else if (choice.equalsIgnoreCase("z")) {
				view.pause();
				// 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역 - c. 학생별 조회 및 수정으로 돌아감
				cConsultRecordStudent();
			}

		} else if (select.equalsIgnoreCase("z")) {
			// 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역으로 돌아감
			cConsultResult();
		}

	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 요청 내역 > 학생별 조회 및 수정
	 */
	public void cConsultStudent() {

		// 1. 관리자 – 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 – c. 학생별 조회 및 수정
		viewAdminFunction.vConsultStudent();

		String select = scan.nextLine();
		view.pause();

		if (select.equalsIgnoreCase("a")) {
			// a. 학생명
			viewAdminFunction.vConsultRequestStudentName();

			String name = scan.nextLine();

			adminFunction.sConsultRequestStudentName(name);

			String choice = scan.nextLine();

			if (choice.equalsIgnoreCase("z")) {
				view.pause();
				// 1. 관리자 – 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 – c. 학생별 조회 및 수정
				cConsultStudent();
			} else if (choice.equalsIgnoreCase("a")) {
				adminFunction.sConsultRequestModify();
				view.pause();
				cConsultStudent();

			} else if (choice.equalsIgnoreCase("b")) {
				adminFunction.sConsultRequestDelete();
				view.pause();
				cConsultStudent();
			}

		} else if (select.equalsIgnoreCase("b")) {
			// b. 주민번호 뒷자리
			viewAdminFunction.vConsultRequestStudenPw();

			String pw = scan.nextLine();

			adminFunction.sConsultRequestStudentPw(pw);

			String choice = scan.nextLine();

			if (choice.equalsIgnoreCase("z")) {
				view.pause();
				// 1. 관리자 – 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 – c. 학생별 조회 및 수정
				cConsultStudent();
			} else if (choice.equalsIgnoreCase("a")) {
				adminFunction.sConsultRequestModify();
				view.pause();
				cConsultStudent();

			} else if (choice.equalsIgnoreCase("b")) {
				adminFunction.sConsultRequestDelete();
				view.pause();
				cConsultStudent();
			}

		} else if (select.equalsIgnoreCase("c")) {
			// c. 전화번호

			viewAdminFunction.vConsultRequestStudenTel();

			String tel = scan.nextLine();

			adminFunction.sConsultRequestStudentTel(tel);

			String choice = scan.nextLine();

			if (choice.equalsIgnoreCase("z")) {
				view.pause();
				// 1. 관리자 – 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 – c. 학생별 조회 및 수정
				cConsultStudent();
			} else if (choice.equalsIgnoreCase("a")) {
				adminFunction.sConsultRequestModify();
				view.pause();
				cConsultStudent();

			} else if (choice.equalsIgnoreCase("b")) {
				adminFunction.sConsultRequestDelete();
				view.pause();
				cConsultStudent();
			}

		} else if (select.equalsIgnoreCase("d")) {
			// d. 등록일

			viewAdminFunction.vConsultRequestStudenRegdate();

			String regdate = scan.nextLine();

			adminFunction.sConsultRequestStudentRegdate(regdate);

			String choice = scan.nextLine();

			if (choice.equalsIgnoreCase("z")) {
				view.pause();
				// 1. 관리자 – 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 – c. 학생별 조회 및 수정
				cConsultStudent();
			} else if (choice.equalsIgnoreCase("a")) {
				adminFunction.sConsultRequestModify();
				view.pause();
				cConsultStudent();

			} else if (choice.equalsIgnoreCase("b")) {
				adminFunction.sConsultRequestDelete();
				view.pause();
				cConsultStudent();
			}

		} else if (select.equalsIgnoreCase("e")) {
			// e. 학과
			viewAdminFunction.vConsultRequestStudenMajor();

			String major = scan.nextLine();

			adminFunction.sConsultRequestStudentMajor(major);

			String choice = scan.nextLine();

			if (choice.equalsIgnoreCase("z")) {
				view.pause();
				// 1. 관리자 – 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 – c. 학생별 조회 및 수정
				cConsultStudent();
			} else if (choice.equalsIgnoreCase("a")) {
				adminFunction.sConsultRequestModify();
				view.pause();
				cConsultStudent();

			} else if (choice.equalsIgnoreCase("b")) {
				adminFunction.sConsultRequestDelete();
				view.pause();
				cConsultStudent();
			}

		} else if (select.equalsIgnoreCase("z")) {
			// z. 뒤로가기
			cConsult();
		}

	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 요청 내역 > 과정별 조회 및 수정 > 과정별 조회 및 수정
	 */
	public void cConsultCourse() {
		// 1. 관리자 - 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 - b. 과정별 조회 및 수정

		adminFunction.sConsultRequestCourse();

		String select = scan.nextLine();

		view.pause();

		if (select.equalsIgnoreCase("z")) {

			cConsult();

		} else {

			// 1. 관리자 - 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 - b. 과정별 조회 및 수정 - 1. 선택

			adminFunction.sConsultRequestCourseSelect(select);

			String choice = scan.nextLine();

			if (choice.equalsIgnoreCase("a")) {
				adminFunction.sConsultRequestCourseModify();
				view.pause();
				cConsultCourse();
			} else if (choice.equalsIgnoreCase("b")) {
				adminFunction.sConsultRequestCourseDelete();
				view.pause();
				cConsultCourse();
			} else if (choice.equalsIgnoreCase("z")) {
				view.pause();
				cConsultCourse();
			}

		}

	}

	/**
	 * 관리자 > 교사 평가 관리 및 결과 조회
	 */
	public void cTeacherEvalMgmt() {

		// 1. 관리자 – 6. 교사 평가 관리 및 결과 조회

		viewAdminFunction.vTeacherEval();
		String select = scan.nextLine();

		view.pause();

		if (select.equalsIgnoreCase("a")) {

			// a. 질문지 등록

			viewAdminFunction.vTeacherEvalQuestionRegister(); // 교사평가 질문 내용출력
			adminFunction.sTeacherEvalQuestionRegister(); // 교사평가 질문 등록

			cTeacherEvalMgmt(); // 교사평가 질문 등록후 6번기능 처음으로 돌아감

		} else if (select.equalsIgnoreCase("b")) {

			// b. 질문지 수정 및 삭제

			cTeacherEvalQuestionModifyDelete(); // 교사평가 질문지 수정 및 삭제

		} else if (select.equalsIgnoreCase("c")) {

			// c. 교사 평가 결과 조회 및 삭제

			cTeacherEvalQuestionResultInfoDelete();

		} else if (select.equalsIgnoreCase("z")) {
			// 관리자 초기메뉴로 돌아가기
			cAdminMainMenu();
		}

	}

	/**
	 * 관리자 > 교사 평가 관리 및 결과 조회 > 교사 평가 결과 조회 및 삭제
	 */
	public void cTeacherEvalQuestionResultInfoDelete() {

		// 1. 관리자 – 6. 교사 평가 관리 및 결과 조회 - c. 교사 평가 결과 조회 및 삭제

		adminFunction.sTeacherEvalQuestionResultInfoDelete();

		String select = scan.nextLine();
		view.pause();

		if (select.equalsIgnoreCase("z")) {
			cTeacherEvalMgmt();
		} else {

			// z 가 아니면 select는 숫자로 생각하고 개설과정번호로 취급
			// 1. 관리자 – 6. 교사 평가 관리 및 결과 조회 - c. 교사 평가 결과 조회 및 삭제 – 1.(상세보기)
			adminFunction.sTeacherEvalQuestionResultInfoDeleteInfo(select);

			String choice = scan.nextLine();

			view.pause();

			if (choice.equals("6")) {

				// 주관식, 좋았던 점 출력, 문제 시퀀스번호 넘어감
				adminFunction.sGood(choice, select);

				cTeacherEvalQuestionResultInfoDelete();

			} else if (choice.equals("7")) {

				// 주관식 아쉬운 점, 개선할 점 출력, 문제 시퀀스번호 넘어감
				adminFunction.sGood(choice, select);

				cTeacherEvalQuestionResultInfoDelete();

			} else if (choice.equalsIgnoreCase("z")) {

				// 1. 관리자 – 6. 교사 평가 관리 및 결과 조회 - c. 교사 평가 결과 조회 및 삭제 돌아가기
				cTeacherEvalQuestionResultInfoDelete();

			}

		}

	}

	/**
	 * 관리자 > 교사 평가 관리 및 결과 조회 > 질문지 수정 및 삭제
	 */
	public void cTeacherEvalQuestionModifyDelete() {

		adminFunction.sTeacherEvalQuestionModifyDelete(); // 질문지 수정 및 삭제
		String choice = scan.nextLine(); // 질문지 수정 및 삭제에서 기능 선택

		view.pause();

		if (choice.equalsIgnoreCase("z")) {
			cTeacherEvalMgmt(); // 6번기능 처음으로 돌아감
		} else {

			int choiceNum = Integer.parseInt(choice); // z가 아니면 숫자로 바꿈
			adminFunction.sTeacherEvalQuestionModifyDeleteNumber(choiceNum); // 입력한 값에 대해 맞는 질문지 출력 및 수정/삭제 선택

			String select = scan.nextLine();

			view.pause();

			if (select.equalsIgnoreCase("z")) {
				cTeacherEvalQuestionModifyDelete(); // 질문지 수정 및 삭제 처음페이지로 이동
			} else {
				int selectNum = Integer.parseInt(select);

				if (selectNum == 1) {

					adminFunction.sTeacherEvalQuestionModify(choiceNum);

					view.pause();

					cTeacherEvalQuestionModifyDelete(); // 수정후 질문지 수정 및 삭제 처음페이지로 이동

				} else if (selectNum == 2) {

					adminFunction.sTeacherEvalQuestionDelete(choiceNum);

					view.pause();

					cTeacherEvalQuestionModifyDelete(); // 삭제후 질문지 수정 및 삭제 처음페이지로 이동
				}

			}

		}

	}

	/**
	 * 관리자 > 개설 과정 및 과목에서 선택한 메뉴로 기능을 수행하기 위한 메소드
	 * 
	 * @param select 관리자 > 개설 과정 및 과목관리 에서 선택한 메뉴
	 */
	public void amOCSmgmt(String select) {

		int selectNum;

		if (select.equalsIgnoreCase("a")) { // 개설과정 정보 등록

			adminFunction.sOpenMgmtAdd();

			adminFunction.sOpenMgmtInfo();
			select = scan.nextLine();

			amOCSmgmt(select);

		} else if (select.equalsIgnoreCase("z")) { //
			cAdminMainMenu();
		} else {
			selectNum = Integer.parseInt(select);

			int num = adminFunction.sOpenMgmtInfoDetails(selectNum); // 개설과정번호(PK)

			adminFunction.sOCSmgmtdetails(num);

			String choice = scan.nextLine();

			view.pause();

			if (choice.equalsIgnoreCase("a")) {// 개설과목 정보 등록
				adminFunction.sOpenMgmtSubjectRegistration(selectNum);

				adminFunction.sOpenMgmtInfo();
				select = scan.nextLine();
				view.pause();
				amOCSmgmt(select);

			} else if (choice.equalsIgnoreCase("z")) { // 관리자 2번기능 첫화면으로 돌아감
				adminFunction.sOpenMgmtInfo();

				select = scan.nextLine();
				view.pause();
				amOCSmgmt(select);
			}

		}

	}

	// 관리자메뉴 3번
	public void stdntMgmt(String select) {

		// 1.관리자 - 3.학생관리 - a. 학생 정보 전체보기
		if (select.equalsIgnoreCase("a")) {

			srvc_stdntMgmt.vASI();

			String input = scan.nextLine();

			if (!input.equals(null)) {
				srvc_stdntMgmt.StudentManagementInfo(); // 1.관리자 - 3.학생관리
				select = scan.nextLine();
				stdntMgmt(select);
			}

			// 1.관리자 - 3.학생관리 - b. 학생 정보 등록
		} else if (select.equalsIgnoreCase("b")) {

			srvc_stdntMgmt.addStudentInfo();

			String input = scan.nextLine();

			if (!input.equals(null)) {
				srvc_stdntMgmt.StudentManagementInfo(); // 1.관리자 - 3.학생관리
				select = scan.nextLine();
				stdntMgmt(select);
			}

			// 1.관리자 - 3.학생관리 - c. 학생 정보 검색 및 수정
		} else if (select.equalsIgnoreCase("c")) {

			ArrayList<DTO_Student> list = srvc_stdntMgmt.searchEditStudents(); // 1. 관리자 - 3. 학생 관리 - c. 학생 정보 검색 및 수정
			srvc_stdntMgmt.studentSearchResults(list); // 1. 관리자 - 3. 학생 관리 - c. 학생 정보 검색 및 수정 - 검색 결과

			srvc_stdntMgmt.StudentManagementInfo(); // 1.관리자 - 3.학생관리
			select = scan.nextLine();
			stdntMgmt(select);

			// 1.관리자 - 3.학생관리 - z. 뒤로가기
		} else if (select.equalsIgnoreCase("z")) {
			cAdminMainMenu();

			// 예외처리
		} else {
			System.out.println("잘못된 메뉴선택입니다.");
			scan.nextLine();

			srvc_stdntMgmt.StudentManagementInfo(); // 1.관리자 - 3.학생관리
			select = scan.nextLine();

			stdntMgmt(select);
		}

	}// amSdMgmt()

	// 관리자메뉴 4번
	private void gradeViews(String select) {

		// 1. 관리자 - 4. 성적 조회 - a. 과정별 성적 조회
		if (select.equalsIgnoreCase("a")) {

			String courseSeq = srvc_gradeViews.viewOpenCourse();

			// 1. 관리자 - 4. 성적 조회 - a. 과정별 성적 조회 - 과정 선택
			if (!(courseSeq == null)) {
				srvc_gradeViews.viewOpenSubject(courseSeq);
			}

			// 1.관리자 - 4.성적조회
			srvc_gradeViews.gradeViewsInfo();
			select = scan.nextLine();
			gradeViews(select);

			// 1. 관리자 - 4. 성적 조회 - b. 학생별 성적 조회
		} else if (select.equalsIgnoreCase("b")) {

			String studentSeq = srvc_gradeViews.viewStudentCourse();

			// 1. 관리자 - 4. 성적 조회 - b. 학생별 성적 조회 - 학생 선택 결과
			if (!(studentSeq == null)) {
				srvc_gradeViews.viewStudentInfo(studentSeq);
			}

			// 1.관리자 - 4.성적조회
			srvc_gradeViews.gradeViewsInfo();
			select = scan.nextLine();
			gradeViews(select);

			// 1. 관리자 - 4. 성적 조회 - z. 뒤로 가기
		} else if (select.equalsIgnoreCase("z")) {
			cAdminMainMenu();
			// 예외처리
		} else {

			System.out.println("잘못된 메뉴선택입니다.");
			scan.nextLine();

			srvc_gradeViews.gradeViewsInfo(); // 1.관리자 - 4.성적조회
			select = scan.nextLine();
			gradeViews(select);
		}
	}// gradeViews()



}
