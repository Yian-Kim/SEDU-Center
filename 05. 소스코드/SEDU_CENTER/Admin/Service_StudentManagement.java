package Admin;
import java.util.ArrayList;
import java.util.Scanner;

import DAO.DAO_A_StudentManagement;
import dto_common.DTO_Student;

public class Service_StudentManagement implements IService_studentManagement {

   private Scanner scan;
   private View_StudentManagement view;
   
   public Service_StudentManagement() {
      scan = new Scanner(System.in);
      view = new View_StudentManagement();
   }
   
//---------------------------------------------------------------------------------------------------------------------------------------
   
   /**
    * 1. 관리자 - 3. 학생 관리
    */
   public void StudentManagementInfo() {
      
      
      view.clearScreen();

      view.info();
      
   }//sSdMGInfo()

//---------------------------------------------------------------------------------------------------------------------------------------
   
   /**
    * 1. 관리자 - 3. 학생 관리 - a. 학생 정보 전체보기
    */
   public void vASI() {
      
      try {
         view.pause();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      view.clearScreen();
      
      view.vASITitle();
      
      DAO_A_StudentManagement dao_sdmg = new DAO_A_StudentManagement();
      
      //DB 작업 > dao 위임
      ArrayList<DTO_Student> sdList = dao_sdmg.list();
      
      for (DTO_Student dto_student : sdList) {
         System.out.printf("%s\t%s\t\t%s\t%s\t%s\t\n"
                        , dto_student.getName()
                        , dto_student.getPw()
                        , dto_student.getTel()
                        , dto_student.getRegiDate()
                        , dto_student.getMajor());
      }

      dao_sdmg.close();
      
      view.back();
      
   }//vASI()

//---------------------------------------------------------------------------------------------------------------------------------------

   /**
    * 1. 관리자 - 3. 학생 관리 - b. 학생 정보 등록   
    */
   public void addStudentInfo() {
      
      try {
         view.pause();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      view.clearScreen();
      
      view.addStudentInfoTitle();
      
      System.out.print("학생명 : ");
      String sname = scan.nextLine();
   
      System.out.print("주민번호(뒷자리) : ");
      String pw = scan.nextLine();
      
      System.out.print("전화번호('-'포함) : ");
      String tel = scan.nextLine();
      
      System.out.print("학과 : ");
      String major = scan.nextLine();
      
      System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
      System.out.print("정말로 등록하시겠습니까? (y/n) : ");
      String select = scan.nextLine();
      
      if (select.equalsIgnoreCase("y")) {
      
         DAO_A_StudentManagement dao_sdmg = new DAO_A_StudentManagement();
         //서비스객체가 DAO에게 전달하기 위해서 포장
         DTO_Student dto_student = new DTO_Student();
         
         dto_student.setName(sname);
         dto_student.setPw(pw);
         dto_student.setTel(tel);
         dto_student.setMajor(major);
         
         int result = dao_sdmg.add(dto_student);
         
         dao_sdmg.close();
         
         if (result == 1) {
            System.out.println("- 등록을 완료했습니다.");
            scan.nextLine();
         } else {
            System.out.println("- 등록을 실패했습니다.");
            scan.nextLine();
         }
      
      } else if (select.equalsIgnoreCase("n")) {
         System.out.println("- 등록을 취소했습니다.");
         scan.nextLine();
         
      } else {
         System.out.println("- 잘못 선택하셨습니다.");
         scan.nextLine();
      }
      
      view.back();
      
      
   }//addStudentInfo()
      
//---------------------------------------------------------------------------------------------------------------------------------------   

   /**
    * 1. 관리자 - 3. 학생 관리 - c. 학생 정보 검색 및 수정
    */
   public ArrayList<DTO_Student> searchEditStudents() {
      
      try {
         view.pause();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      view.clearScreen();
      
      view.searchEditStudentsTitle();
      view.searchEditStudentsList();
      
      String select = scan.nextLine();
      
            
      if (select.equalsIgnoreCase("a")) {
         
         try {
            view.pause();
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         view.clearScreen();
         
         view.searchEditStudentsTitle();
         
         System.out.print("학생명 : ");
         String name = scan.nextLine();
         
         //DB 작업 > dao 위임(select)
         DAO_A_StudentManagement dao_sdmg = new DAO_A_StudentManagement();
         
         ArrayList<DTO_Student> list = dao_sdmg.search("name", name);
         
         return list;
         
      } else if (select.equalsIgnoreCase("b")) {
         
         try {
            view.pause();
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         view.clearScreen();
         
         view.searchEditStudentsTitle();
         
         System.out.print("주민번호뒷자리 : ");
         String pw = scan.nextLine();

         //DB 작업 > dao 위임(select)
         DAO_A_StudentManagement dao_sdmg = new DAO_A_StudentManagement();
         
         ArrayList<DTO_Student> list = dao_sdmg.search("pw", pw);
         
         return list;
         
      } else if (select.equalsIgnoreCase("c")) {
         
         try {
            view.pause();
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         view.clearScreen();
         
         view.searchEditStudentsTitle();
         
         System.out.print("전화번호 : ");
         String tel = scan.nextLine();

         //DB 작업 > dao 위임(select)
         DAO_A_StudentManagement dao_sdmg = new DAO_A_StudentManagement();
         
         ArrayList<DTO_Student> list = dao_sdmg.search("tel", tel);
         
         return list;
         
      } else if (select.equalsIgnoreCase("d")) {
         
         try {
            view.pause();
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         view.clearScreen();
         
         view.searchEditStudentsTitle();
         
         System.out.print("등록일 : ");
         String regiDate = scan.nextLine();

         //DB 작업 > dao 위임(select)
         DAO_A_StudentManagement dao_sdmg = new DAO_A_StudentManagement();
         
         ArrayList<DTO_Student> list = dao_sdmg.search("regiDate", regiDate);
         
         return list;
         
      } else if (select.equalsIgnoreCase("e")) {
         
         try {
            view.pause();
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         view.clearScreen();
         
         view.searchEditStudentsTitle();
         
         System.out.print("학과 : ");
         String major = scan.nextLine();

         //DB 작업 > dao 위임(select)
         DAO_A_StudentManagement dao_sdmg = new DAO_A_StudentManagement();
         
         ArrayList<DTO_Student> list = dao_sdmg.search("major", major);
         
         return list;
         
      } else if (select.equalsIgnoreCase("z")) {
         
      } else {
         System.out.println("잘못 선택하셨습니다.");
         scan.nextLine();
         searchEditStudents();
      }
      return null;
      
   }//searchEditStudents()

   
//---------------------------------------------------------------------------------------------------------------------------------------   
   
   /**
    * 1. 관리자 - 3. 학생 관리 - c. 학생 정보 검색 및 수정 - 검색 결과
    */
   public void studentSearchResults(ArrayList<DTO_Student> list) {

      try {
         view.pause();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      view.clearScreen();
      view.studentSearchResultsTitle();
      
      DAO_A_StudentManagement dao_sdmg = new DAO_A_StudentManagement();
      
      int i = 0;
      //배열에 시퀀스 저장
      ArrayList<String> seq = new ArrayList<String>();
      
      for (DTO_Student dto_student : list) {
         System.out.printf(i+1+".%s\t%s\t\t%s\t%s\t%s\n"
                        , dto_student.getName()
                        , dto_student.getPw()
                        , dto_student.getTel()
                        , dto_student.getRegiDate()
                        , dto_student.getMajor());
         
         seq.add(dto_student.getStudent_seq()); 

         i++;
      }
      dao_sdmg.close();
      
      view.studentSearchResultsMenu();
      
      String select = scan.nextLine();
      if(isStringDouble(select)) {

         int num = Integer.parseInt(select);
         
         // 학생 번호 선택시
         if (num<=i && num>0) {
            
            try {
               view.pause();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
            view.clearScreen();
            
            view.studentSearchResultsTitle();
            
            //studentNum에 학생시퀀스 입력
            String studentNum = seq.get(num-1);
            
            dao_sdmg = new DAO_A_StudentManagement();
            
            DTO_Student result = dao_sdmg.selectStudent(studentNum);
            
            System.out.printf("%s\t%s\t\t%s\t%s\t%s\n"
                           , result.getName()
                           , result.getPw()
                           , result.getTel()
                           , result.getRegiDate()
                           , result.getMajor());
            dao_sdmg.close();
   
            view.modifyDeleteMenu();
            
            select = scan.nextLine();
            
            if (select.equalsIgnoreCase("a")) {
               modifyStudent(studentNum);
            } else if (select.equalsIgnoreCase("b")) {
               deleteStudent(studentNum);
            } else if (select.equalsIgnoreCase("z")) {
               
            } else {
               System.out.println("메뉴 입력을 잘못하셨습니다.");
               scan.nextLine();
            }
         }
      } else {
         
         // 뒤로가기 클릭시
         if (select.equalsIgnoreCase("z")) {
            
         } else {
            System.out.println("메뉴 입력을 잘못하셨습니다.");
            scan.nextLine();
         }

      }
      
   }//studentSearchResults(ArrayList<DTO_Student> list)



//---------------------------------------------------------------------------------------------------------------------------------------   

   /**
    * 1. 관리자 - 3. 학생 관리 - c. 학생 정보 검색 및 수정 - 검색 결과 - 수정
    */
   public void modifyStudent(String studentNum) {
      
      System.out.print("학생명 : ");
      String name = scan.nextLine();
      
      System.out.print("주민번호(뒷자리) : ");
      String pw = scan.nextLine();
      
      System.out.print("전화번호('-'포함) : ");
      String tel = scan.nextLine();
      
      System.out.print("학과 : ");
      String major = scan.nextLine();
      
      System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
      System.out.print("정말로 수정하시겠습니까? (y/n) : ");
      String select = scan.nextLine();
      
      if (select.equalsIgnoreCase("y")) {
         
         DAO_A_StudentManagement dao_sdmg = new DAO_A_StudentManagement();
         
         int result = dao_sdmg.modifyStudent(name, pw, tel, major, studentNum);
         
         if (result==1) {
            System.out.println("- 수정을 완료했습니다.");
            scan.nextLine();
         } else {
            System.out.println("- 수정을 실패했습니다.");
            scan.nextLine();
         }
         
      } else if (select.equalsIgnoreCase("n")) {
         System.out.println("- 수정이 취소 되었습니다.");
         scan.nextLine();
      } else {
         System.out.println("- 메뉴 입력을 잘못하셨습니다.");
         scan.nextLine();
      }
      
   }//modifyStudent()
      
//---------------------------------------------------------------------------------------------------------------------------------------   
      
   /**
    * 1. 관리자 - 3. 학생 관리 - c. 학생 정보 검색 및 수정 - 검색 결과 - 삭제
    */
   public void deleteStudent(String studentNum) {
      
	   System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
      System.out.println("정말로 삭제하시겠습니까? (y/n)");
      String select = scan.nextLine();
      
      if (select.equalsIgnoreCase("y")) {
         
         DAO_A_StudentManagement dao_sdmg = new DAO_A_StudentManagement();
         
         int result = dao_sdmg.deleteStudent(studentNum);
                  
         if (result==1) {
            System.out.println("- 삭제를 완료했습니다.");
            scan.nextLine();
         } else {
            System.out.println("- 삭제를 실패했습니다.");
            scan.nextLine();
         }
         
      } else if (select.equalsIgnoreCase("n")) {
         System.out.println("- 삭제가 취소 되었습니다.");
         scan.nextLine();
      } else {
         System.out.println("- 메뉴 입력을 잘못하셨습니다.");
         scan.nextLine();
      }
      
   }//deleteStudent()
   
//---------------------------------------------------------------------------------------------------------------------------------------   

   /**
    * 문자열이 숫자인지 아닌지 판별하는 메소드
    */
   public boolean isStringDouble(String s) {
       try {
           Double.parseDouble(s);
           return true;
       } catch (NumberFormatException e) {
           return false;
       }
     }//isStringDouble()
   
}//Class_Service_StudentManagement