package Admin;

import java.util.Scanner;

public class View_GradeViews {

   /**
    *  1. 관리자 - 4. 성적 조회
    */
   public void mainMenu() {
      
      System.out.println("================================================================================================");
      System.out.println("\t\t\t\t1. 관리자 - 4. 성적 조회");
      System.out.println("================================================================================================");
      System.out.println("a. 과정별 성적 조회");
      System.out.println("b. 학생별 성적 조회");
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
      System.out.println();
      System.out.println("================================================================================================");
      
   }//mainMenu()

//---------------------------------------------------------------------------------------------------------------------------------------
   
   /**
    *  1. 관리자 - 4. 성적 조회 - a. 과정별 성적 조회(타이틀)
    */
   public void openCourseListTitle() {
      
      System.out.println("================================================================================================");
      System.out.println("\t\t\t1. 관리자 - 4. 성적 조회 - a. 과정별 성적 조회");
      System.out.println("================================================================================================");
      System.out.println("\t\t[과정명]\t\t\t[과정기간]\t\t\t[교사명]\t[강의실]");
      System.out.println();
      
   }//openCourseListTitle()

//---------------------------------------------------------------------------------------------------------------------------------------

   /**
    *  1. 관리자 - 4. 성적 조회 - a. 과정별 성적 조회(메뉴)
    */
   public void openCourseListMenu() {

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
      System.out.println("------------------------------------------------------------------------------------------------");
      System.out.println("- 성적 조회를 원하는 과정의 번호를 선택해 주세요.");
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println("================================================================================================");
      
   }//openCourseListMenu()
   
//---------------------------------------------------------------------------------------------------------------------------------------
   
   /**
    *  1. 관리자 - 4. 성적 조회 - a. 과정별 성적 조회 - 과정 선택결과(타이틀)
    */
   public void openCourseDetailsTitle() {
      
      System.out.println("================================================================================================");
      System.out.println("\t\t\t1. 관리자 - 4. 성적 조회 - a. 과정별 성적 조회 - 과정 선택결과");
      System.out.println("================================================================================================");
      
   }//openCourseDetails()
   
//---------------------------------------------------------------------------------------------------------------------------------------
   
   /**
    *  1. 관리자 - 4. 성적 조회 - a. 과정별 성적 조회 - 과정 선택결과(메뉴)
    */
   public void openCourseDetailsMenu() {
      
      System.out.println();
      System.out.println("------------------------------------------------------------------------------------------------");
      System.out.println("- 성적 조회를 원하는 과목의 번호를 선택해 주세요.");
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println("z. 뒤로가기");
      System.out.println();
      System.out.println("================================================================================================");
      
   }//openCourseDetailsMenu()
   
//---------------------------------------------------------------------------------------------------------------------------------------
   
   /**
    *  1. 관리자 - 4. 성적 조회 - a. 과정별 성적 조회 - 과정 - 과목 선택결과(타이틀)
    */
   public void openSubjectDetailsTitle() {
      
      System.out.println("================================================================================================");
      System.out.println("\t\t\t1. 관리자 - 4. 성적 조회 - a. 과정별 성적 조회 - 과정 - 과목 선택결과");
      System.out.println("================================================================================================");
      
   }//openSubjectDetails()
   
//---------------------------------------------------------------------------------------------------------------------------------------

   /**
    *  1. 관리자 - 4. 성적 조회 - a. 과정별 성적 조회 - 과정 - 과목 선택결과(메뉴)
    */
   public void openSubjectDetailsMenu() {

      System.out.println("------------------------------------------------------------------------------------------------");
      System.out.println("- 아무키나 누르면 뒤로 돌아갑니다.");
      System.out.println("================================================================================================");
      
   }//openSubjectDetailsMenu()

//---------------------------------------------------------------------------------------------------------------------------------------
   
   /**
    *  1. 관리자 - 4. 성적 조회 - b. 학생별 성적 조회
    */
   public void studentSearchTitle() {
      
      System.out.println("================================================================================================");
      System.out.println("\t\t\t1. 관리자 - 4. 성적 조회 - b. 학생별 성적 조회");
      System.out.println("================================================================================================");
      System.out.println("성적 조회를 원하는 학생명을 입력해주세요.");
      System.out.print("학생명 : ");
      
   }//studentSearch()

//---------------------------------------------------------------------------------------------------------------------------------------

   /**
    *  1. 관리자 - 4. 성적 조회 - b. 학생별 성적 조회(뒤로가기)
    */
   public void back() {
      
      System.out.println("------------------------------------------------------------------------------------------------");
      System.out.println(" - 성적 조회를 원하는 학생의 번호를 선택해 주세요.");
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
      System.out.println("z.뒤로가기");
      System.out.println();
      System.out.println("================================================================================================");
      
   }//back()

//---------------------------------------------------------------------------------------------------------------------------------------
   
   /**
    *  1. 관리자 - 4. 성적 조회 - b. 학생별 성적 조회 - 학생 정보
    */
   public void studentSubjectInfoTitle() {
      
      System.out.println("================================================================================================");
      System.out.println("\t\t\t1. 관리자 - 4. 성적 조회 - b. 학생별 성적 조회 - 학생정보");
      System.out.println("================================================================================================");
      
   }//studentSearch()

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

}//Class_View_GradeViews