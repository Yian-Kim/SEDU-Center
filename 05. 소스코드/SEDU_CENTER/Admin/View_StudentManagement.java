package Admin;

import java.util.Scanner;

public class View_StudentManagement {

   /**
    *  1. 관리자 - 3. 학생 관리
    */
   public void info() {
      System.out.println("==============================================================================");
      System.out.println("\t\t\t1. 관리자 - 3. 학생 관리");
      System.out.println("==============================================================================");
      System.out.println("a. 학생 정보 전체보기");
      System.out.println("b. 학생 정보 등록");
      System.out.println("c. 학생 정보 검색 및 수정");
      System.out.println();
      System.out.println();
      System.out.println("z. 뒤로가기");
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println("==============================================================================");
      
   }//info()

//---------------------------------------------------------------------------------------------------------------------------------------

   /**
    *  1. 관리자 - 3. 학생 관리 - a. 학생 정보 전체보기(타이틀)
    */
   public void vASITitle() {
      
      System.out.println("==============================================================================");
      System.out.println("\t\t1. 관리자 - 3. 학생 관리 - a. 학생 정보 전체보기");
      System.out.println("==============================================================================");
      System.out.println("[학생명]\t[주민번호뒷자리]\t[전화번호]\t\t[등록일]\t\t[학과]");
      System.out.println();
      
   }//sdInfoTitle()

//---------------------------------------------------------------------------------------------------------------------------------------
   
   /**
    *  1. 관리자 - 3. 학생 관리 - b. 학생 정보 등록(타이틀)
    */
   public void addStudentInfoTitle() {
      
      System.out.println("==============================================================================");
      System.out.println("\t\t1. 관리자 - 3. 학생 관리 - b. 학생 정보 등록");
      System.out.println("==============================================================================");
      
   }//addStudentInfoTitle()
   
//---------------------------------------------------------------------------------------------------------------------------------------

   
   /**
    *  1. 관리자 - 3. 학생 관리 - c. 학생 정보 검색 및 수정(타이틀)
    */
   public void searchEditStudentsTitle() {
   
      System.out.println("==============================================================================");
      System.out.println("\t\t1. 관리자 - 3. 학생 관리 - c. 학생 정보 검색 및 수정");
      System.out.println("==============================================================================");
      System.out.println();
      
   }//searchEditStudentsTitle()
   
//---------------------------------------------------------------------------------------------------------------------------------------
   
   
   /**
    *  1. 관리자 - 3. 학생 관리 - c. 학생 정보 검색 및 수정(메뉴)
    */
   public void searchEditStudentsList() {
      
      System.out.println("■ 검색 조건");
      System.out.println();
      System.out.println("a. 학생명");
      System.out.println("b. 주민번호뒷자리");
      System.out.println("c. 전화번호");
      System.out.println("d. 등록일");
      System.out.println("e. 학과");
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println("z. 뒤로가기");
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println("==============================================================================");
      
   }//searchEditStudentsList()
//---------------------------------------------------------------------------------------------------------------------------------------
   
   /**
    *  1. 관리자 - 3. 학생 관리 - c. 학생 정보 검색 및 수정 - 검색결과(타이틀)
    */
   public void studentSearchResultsTitle() {
      
      System.out.println("==============================================================================");
      System.out.println("\t\t1. 관리자 - 3. 학생 관리 - c. 학생 정보 검색 및 수정 - 검색결과");
      System.out.println("==============================================================================");
      System.out.println();
      System.out.println("[학생명]\t[주민번호뒷자리]\t[전화번호]\t\t[등록일]\t\t[학과]");
      
   }//studentSearchResults()
//---------------------------------------------------------------------------------------------------------------------------------------

   /**
    *  1. 관리자 - 3. 학생 관리 - c. 학생 정보 검색 및 수정 - 검색결과(메뉴)
    */
   public void studentSearchResultsMenu() {

      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println("z. 뒤로가기");
      System.out.println("------------------------------------------------------------------------------");
      System.out.println("- 학생 정보 수정 및 삭제를 원하시면 해당 번호를 선택해 주세요.");
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println("==============================================================================");
      
   }//studentSearchResultsMenu()

//---------------------------------------------------------------------------------------------------------------------------------------

   /**
    *  1. 관리자 - 3. 학생 관리 - c. 학생 정보 검색 및 수정 - 검색결과 - 학생 선택시(메뉴)
    */
   public void modifyDeleteMenu() {
      
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println("------------------------------------------------------------------------------");
      System.out.println("a. 학생 정보 수정");
      System.out.println("b. 학생 정보 삭제");
      System.out.println();
      System.out.println();
      System.out.println("z. 뒤로가기");
      System.out.println("------------------------------------------------------------------------------");
      
   }//modifyDeleteMenu()

//---------------------------------------------------------------------------------------------------------------------------------------
   
   /**
    *  1. 관리자 - 3. 학생 관리 - c. 학생 정보 검색 및 수정 - 검색결과 - 수정
    */
   public void editStudentInfoTitle() {
      
      System.out.println("==============================================================================");
      System.out.println("\t\t1. 관리자 - 3. 학생 관리 - c. 학생 정보 검색 및 수정 - 검색결과 - 수정");
      System.out.println("==============================================================================");
      System.out.println("[학생명]\t[주민번호뒷자리]\t[전화번호]\t\t[등록일]\t[학과]");
      
      
   }//editStudentInfoTitle()
   
//---------------------------------------------------------------------------------------------------------------------------------------
   
   /**
    *  1. 관리자 - 3. 학생 관리 - c. 학생 정보 검색 및 수정 - 검색결과 - 삭제
    */
   public void deleteStudentInfoTitle() {
      
      System.out.println("==============================================================================");
      System.out.println("\t\t1. 관리자 - 3. 학생 관리 - c. 학생 정보 검색 및 수정 - 검색결과 - 삭제");
      System.out.println("==============================================================================");
      System.out.println("[학생명]\t[주민번호뒷자리]\t[전화번호]\t\t[등록일]\t[학과]");
      
      
   }//deleteStudentInfoTitle()
   
//---------------------------------------------------------------------------------------------------------------------------------------

   /**
    *  뒤로가기
    */
   public void back() {
   
      System.out.println("------------------------------------------------------------------------------");
      System.out.println("- 아무키나 누르면 뒤로 돌아갑니다.");
      System.out.println("==============================================================================");

   }//back()

//---------------------------------------------------------------------------------------------------------------------------------------

   /**
    *  프로그램 넘어가기 전에 출력
    */
   public void pause() throws InterruptedException {
            
      System.out.println("\t계속하려면 엔터를 입력하세요.");
      Scanner scan = new Scanner(System.in);
      scan.nextLine();
      
      clearScreen();
      System.out.println("\t\t\t\t\tLOADING.....");
      Thread.sleep(700);
      clearScreen();
      
   }//pause()

//---------------------------------------------------------------------------------------------------------------------------------------   

   /**
    *  화면 지우기
    */
   public void clearScreen() {

      for (int i = 0; i < 50; i++) {
         System.out.println("");
      }
   
   }//clearScreen()

//---------------------------------------------------------------------------------------------------------------------------------------   


   
}//Class_View_StudentManagement















