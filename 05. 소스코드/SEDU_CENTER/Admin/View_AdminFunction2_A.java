package Admin;

import java.util.ArrayList;
import java.util.Scanner;

import DTO_admin.DTO_am_rc_A;
import DTO_admin.DTO_c_oc_r_tc_t_A;
import DTO_admin.DTO_stu_rc_oc_admg_A;
import DTO_admin.DTO_stu_rc_oc_c_r_A;

public class View_AdminFunction2_A {

	/**
	 * 관리자 > 출결 관리 및 출결 조회
	 */
	public void vAttendanceMgmt() {
		
		System.out.println("=======================================================================================================================================");
		System.out.println("\t\t\t\t\t\t1. 관리자 - 5. 출결 관리 및 출결 조회");
		System.out.println("=======================================================================================================================================");
		System.out.println("a. 학생별 조회 및 수정");
		System.out.println("b. 과정별 조회 및 수정");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("z. 뒤로가기");
		
		
	}

	/**
	 * 관리자 > 출결 관리 및 출결조회 > 학생별 조회 및 수정
	 */
	public void vAttendanceStudentInfoModifyBefore() {
		System.out.println("=======================================================================================================================================");
		System.out.println("\t\t\t\t\t\t1. 관리자 - 5. 출결 관리 및 출결 조회 - a. 학생별 조회 및 수정");
		System.out.println("=======================================================================================================================================");
		System.out.println("출결 조회를 원하는 학생명을 입력해주세요.");
		System.out.print("학생명 : ");
		
	}

	/**
	 * 관리자 > 출결 관리 및 출결조회 > 학생별 조회 및 수정에서 학생 정보를 출력하는 메소드
	 * @param list 입력한 학생명과 같은 이름을 가진 학생 정보가 담긴 리스트
	 */
	public void vAttendanceStudentInfoModifyAfter(ArrayList<DTO_stu_rc_oc_c_r_A> list) {

		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\t\t번호\t학생명\t\t주민번호(뒷자리)\t과정명\t\t\t\t\t과정기간\t\t강의실명");
		
		for(int i = 0; i < list.size(); i++) {
			System.out.printf("\t\t%s.\t%s\t%s\t\t%s\t%s\t%s\n"
							,list.get(i).getStudent_seq()
							,list.get(i).getStudentName()
							,list.get(i).getStudentPw()
							,list.get(i).getCourseName()
							,list.get(i).getCourseDuration()
							,list.get(i).getClassName()
							);
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("- 출결 조회를 원하시면 번호를 선택해 주세요.");
		System.out.println("z. 뒤로가기");
		System.out.print("번호 : ");
		
		
	}

	/**
	 * 관리자 > 출결 관리 및 출결조회 > 학생별 조회 > 학생 선택시
	 * @param name 학생명
	 * @param startDate 출결 조회 시작일
	 * @param endDate 출결 조회 종료일
	 * @param list 출결조회에 관한 정보
	 */
	public void vAttendanceStudentInfoModifySelectHead(String name, String startDate, String endDate,
			ArrayList<DTO_am_rc_A> list) {

		// 1. 관리자 - 5. 출결 관리 및 출결조회 - a. 학생별 조회 출력
		
		System.out.println("=======================================================================================================================================");
		System.out.println("\t\t\t\t\t\t1. 관리자 - 5. 출결 관리 및 출결 조회 - a. 학생별 조회");
		System.out.println("=======================================================================================================================================");
		System.out.println("■ 기간 : " + startDate + "~" + endDate);
		System.out.println("■ 이름 : " + name);
		System.out.println();
		System.out.println("수강신청번호\t날짜\t\t\t출근시간\t\t퇴근시간\t\t근태상황");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
		
		for(int i = 0; i < list.size(); i++) {
			System.out.printf("%s.\t\t%s\t\t%s\t\t%s\t\t%s\n"
							,list.get(i).getRegiNum()
							,list.get(i).getAttendanceDay()
							,list.get(i).getCommuteTime()
							,list.get(i).getQuittingTime()
							,list.get(i).getAttendanceSituation()
							);
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("a. 근태상황 수정");
		System.out.println();
		System.out.println("z. 뒤로가기");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
		
	}

	/**
	 * 관리자 > 출결 관리 및 출결조회 > 과정별 조회
	 * @param list 개설과정정보
	 */
	public void vAttendanceCourseInfo(ArrayList<DTO_c_oc_r_tc_t_A> list) {
		
		System.out.println("=======================================================================================================================================");
		System.out.println("\t\t\t\t\t\t1. 관리자 - 5. 출결 관리 및 출결 조회 - b. 과정별 조회");
		System.out.println("=======================================================================================================================================");
		System.out.println("\t\t\t번호\t과정명\t\t\t\t\t과정기간\t\t교사명\t\t강의실명");
		
		for(int i = 0; i < list.size(); i++) {
			System.out.printf("\t\t\t%s.\t%s\t%s\t%s\t%s\n"
							,list.get(i).getOpencourse_seq()
							,list.get(i).getCourseName()
							,list.get(i).getCoureseDuration()
							,list.get(i).getTeacherName()
							,list.get(i).getClassName()
							);
		}
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("z. 뒤로가기");
		System.out.println("-출결 조회를 원하시면 번호를 선택해주세요.");
		
	}

	/**
	 * 관리자 > 출결 관리 및 출결조회 > 과정별 조회
	 * @param date 기간
	 * @param name 과정명
	 * @param list 출결조회
	 */
	public void vAttendanceCourseView(String date, String name, ArrayList<DTO_stu_rc_oc_admg_A> list) {

		System.out.println("=======================================================================================================================================");
		System.out.println("\t\t\t\t\t\t1. 관리자 - 5. 출결 관리 및 출결 조회 - b. 과정별 조회 - 과정 선택시");
		System.out.println("=======================================================================================================================================");
		
		System.out.println("■ 기간 : " + date);
		System.out.println("■ 과정명 : " + name);
		System.out.println();
		System.out.println("\t\t수강신청번호\t\t학생명\t\t출근시간\t\t\t퇴근시간\t\t근태상황");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
		
		for(int i = 0; i < list.size(); i++) {
			System.out.printf("\t\t%s.\t\t\t%s\t%s\t\t\t%s\t\t%s\n"
							,list.get(i).getRegiNum()
							,list.get(i).getStudentName()
							,list.get(i).getCommuteTime()
							,list.get(i).getQuittingTime()
							,list.get(i).getAttendanceSituation()
							);
		}
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("a. 근태상황 수정");
		System.out.println();
		System.out.println("z. 뒤로가기");
		
	}

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

	   private void clearScreen() { // 화면지우기

	      for (int i = 0; i < 50; i++) {
	         System.out.println("");
	      }

	   }
	
}
