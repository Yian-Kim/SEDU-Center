package Admin;

import java.util.ArrayList;
import java.util.Scanner;

import DTO_admin.DTO;
import DTO_admin.DTO2;


/*
 * 관리자 화면출력
 */
public class View {
/*
 * 관리자-교사계정관리-시작메뉴
 */
	public void begin() {
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 – 1. 교사 계정 관리 ");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	}
/*
 * 관리자-교사계정관리-교사정보수정	
 */
	public void edit() {
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 – 1. 교사 계정 관리 - b. 교사 정보 수정");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		
	}
/*
 * 관리자-교사계정관리-교사정보삭제	
 */
	public void delete() {
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 – 1. 교사 계정 관리 – c. 교사 정보 삭제");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		
	}
/*
 * 관리자-교사계정관리-상세보기 리스트
 */
	public void list(ArrayList<DTO> list) {
		System.out.println(" 번호\t교사명\t주민번호(뒷자리)\t전화번호");
		for (DTO dto : list) {
			System.out.printf(" %s\t%s\t%s\t%s\n"
								, dto.getTeacher_seq()
								, dto.getName()
								, dto.getPw()
								, dto.getTel()
								);
								
								
		}
		
	}
/*
 * 관리자-교사계정관리-교사 등록,수정,삭제 
 */

	public void menu() {
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("a.교사정보등록");
		System.out.println("b.교사정보수정");
		System.out.println("c.교사정보삭제");
		System.out.println("z.뒤로가기");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("- 상세보기를 원하시면 해당번호를 선택해주세요.");

		
	}
/*
 * 관리자-교사계정관리- 교사 정보 상세보기
 */
	
	public void vTeacherDetails(ArrayList<DTO2> list) {
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("\t\t\t\t\t\t1. 관리자 – 1. 교사 계정 관리 -1. (상세보기)");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("\t\t\t\t\t\t" + list.get(0).getTeachername()+"님의 정보입니다.");
		System.out.println("\t\t\t\t\t\t과정명 : " + list.get(0).getCoursename());
		System.out.println("\t\t\t\t\t\t과정기간 : " + list.get(0).getCourseperiod());
		System.out.println("\t\t\t\t\t\t과목명 및 기간 :");
		for (DTO2 dto2 : list) {
			System.out.println("\t\t\t\t\t\t" + dto2.getJungbo());
		}
			System.out.println("\t\t\t\t\t\t강의실 : "+ list.get(0).getRoomname());
		
			System.out.println();
			System.out.print("\t\t");
			pause();
	}
	/*
	 * 교사 정보 추가
	 */

	public void add() {
		System.out.println();
		
		
	}

	public void pause() { // 프로그램 넘어가기 전에 출력

	      System.out.println("\t\t\t\t계속하려면 엔터를 입력하세요.");
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
