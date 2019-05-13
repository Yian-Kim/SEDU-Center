package Admin;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.DAO_A_AdminFunction2;
import DTO_admin.DTO_am_rc_A;
import DTO_admin.DTO_c_oc_r_tc_t_A;
import DTO_admin.DTO_stu_rc_oc_admg_A;
import DTO_admin.DTO_stu_rc_oc_c_r_A;

public class Service_AdminFunction2_A implements IService_AdminFunction2_A{

	private View_AdminFunction2_A view_adminFunction2;
	
	public Service_AdminFunction2_A() {
		view_adminFunction2 = new View_AdminFunction2_A();
	}
	
	@Override
	/**
	 * 관리자 > 출결 관리 및 출결조회 > 학생별 조회 및 수정
	 */
	public void sAttendanceStudentInfoModify() {
		
		DAO_A_AdminFunction2 dao_adminFunction2 = new DAO_A_AdminFunction2();
		
		view_adminFunction2.vAttendanceStudentInfoModifyBefore();
		
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		
		ArrayList<DTO_stu_rc_oc_c_r_A> list = new ArrayList<DTO_stu_rc_oc_c_r_A>();
		
		list = dao_adminFunction2.daoAttendanceStudentInfoModify(name);
		
		view_adminFunction2.vAttendanceStudentInfoModifyAfter(list);
		
		
		dao_adminFunction2.close();
	}

	@Override
	/**
	 * 관리자 > 출결 관리 및 출결조회 > 학생별 조회 > 학생 선택시
	 */
	public void sAttendanceStudentInfoModifySelect(String choice, String startDate, String endDate) {

		DAO_A_AdminFunction2 dao_adminFunction2 = new DAO_A_AdminFunction2();
		
		String name = dao_adminFunction2.StudentName(choice);
		
		ArrayList<DTO_am_rc_A> list = new ArrayList<DTO_am_rc_A>();
		list = dao_adminFunction2.daoAttendanceInfo(choice, startDate, endDate);
		
		view_adminFunction2.vAttendanceStudentInfoModifySelectHead(name, startDate, endDate, list);
		
		dao_adminFunction2.close();
	}

	@Override
	/**
	 * 학생에 대한 근태상황 수정
	 */
	public void sAttendanceStateModify() {

		Scanner scan = new Scanner(System.in);
		DAO_A_AdminFunction2 dao_adminFunction2 = new DAO_A_AdminFunction2();
		
		System.out.print("수강신청 번호 : ");
		String regiNum = scan.nextLine();
		System.out.print("날짜 입력(ex 2019-01-01)");
		String date = scan.nextLine();
		System.out.println("근태 상황(정상, 지각, 조퇴, 외출, 병가, 기타) : ");
		String state = scan.nextLine();
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("정말로 수정하시겠습니까?(y/n)");
		String check = scan.nextLine();
		
		if(check.equalsIgnoreCase("y")) {
			
			int result = dao_adminFunction2.daoAttendanceStateModify(regiNum, date, state);
			
			if( result == 1) {
				System.out.println("수정 완료!");
			}else if(result == 0) {
				System.out.println("수정 실패!");
			}
			
		}else if(check.equalsIgnoreCase("n")) {
			System.out.println("수정 취소!");
		}
		
		pause();
		
		dao_adminFunction2.close();
	}

	@Override
	/**
	 * 관리자 > 출결 관리 및 출결조회 > 과정별 조회
	 */
	public void sAttendanceCourseInfo() {
		
		DAO_A_AdminFunction2 dao_adminFunction2 = new DAO_A_AdminFunction2();
		
		ArrayList<DTO_c_oc_r_tc_t_A> list = new ArrayList<DTO_c_oc_r_tc_t_A>();
		list = dao_adminFunction2.daoAttendanceCourseInfo();
		
		view_adminFunction2.vAttendanceCourseInfo(list);
		
		dao_adminFunction2.close();
	}

	@Override
	/**
	 * 관리자 > 출결 관리 및 출결조회 > 과정별 조회
	 */
	public void sAttendanceCourseView(String select) {

		DAO_A_AdminFunction2 dao_adminFunction2 = new DAO_A_AdminFunction2();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("- 조회기간을 입력해주세요.(ex 2019-01-01)");
		String date = scan.nextLine();
		
		ArrayList<DTO_stu_rc_oc_admg_A> list = new ArrayList<DTO_stu_rc_oc_admg_A>();
		list = dao_adminFunction2.daoAttendanceCourseView(select, date);
		
		String name = dao_adminFunction2.daoAttendanceCourseName(select);
		
		view_adminFunction2.vAttendanceCourseView(date, name, list);
				
		
		dao_adminFunction2.close();
	}

	@Override
	/**
	 * 관리자 > 출결 관리 및 출결조회 > 과정별 조회 근태상황 수정
	 */
	public void sAttendanceCourseModify(String choice) {

		DAO_A_AdminFunction2 dao_adminFunction2 = new DAO_A_AdminFunction2();
		
		Scanner scan = new Scanner(System.in);
		System.out.print("수강신청 번호 : ");
		String regiNum = scan.nextLine();
		System.out.print("날짜 입력(ex 2019-01-01) : ");
		String date = scan.nextLine();
		System.out.print("근태 상황(정상, 지각, 조퇴, 외출, 병가, 기타) : ");
		String state = scan.nextLine();
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("정말로 수정하시겠습니까?(y/n)");
		String check = scan.nextLine();
		
		if(check.equalsIgnoreCase("y")) {
			
			int result = dao_adminFunction2.daoAttendanceStateModify(regiNum, date, state);
			
			if(result == 1) {
				System.out.println("수정 완료!");
			}else if(result == 0){
				System.out.println("수정 실패!");
			}
			
		}else if(check.equalsIgnoreCase("n")) {
			System.out.println("수정이 취소되었습니다.");
		}
		
		
		pause();
		
		dao_adminFunction2.close();
	}

	/**
	 * 프로그램 기능을 수행하기전에 잠시 멈춰주는 메소드
	 */
	 public void pause() { // 프로그램 넘어가기 전에 출력

	      System.out.println("\t계속하려면 엔터를 입력하세요.");
	      Scanner scan = new Scanner(System.in);
	      scan.nextLine();

	      clearScreen();
	      System.out.println("\t\t\t\t\tLOADING.....");
	      try {
	      Thread.sleep(700);
	      }catch(Exception e) {
	    	  e.printStackTrace();
	      }
	      clearScreen();

	   }

	 /**
	  * 하나의 기능을 수행할 때마다 콘솔창에서 보여주는 화면을 깔끔하게 보여주기 위한 메소드
	  */
	   private void clearScreen() { // 화면지우기

	      for (int i = 0; i < 50; i++) {
	         System.out.println("");
	      }

	   }
	
}
