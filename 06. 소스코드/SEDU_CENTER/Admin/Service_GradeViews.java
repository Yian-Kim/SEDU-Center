package Admin;
import java.util.ArrayList;
import java.util.Scanner;

import DAO.DAO_A_GradeViews;
import DTO_admin.DTO_StudentCourseGrades_A;
import DTO_admin.DTO_StudentGradesSubject_A;
import DTO_admin.DTO_StudentsTakingCourses_A;
import DTO_admin.DTO_ViewOpenCourse_A;
import DTO_admin.DTO_ViewOpenSubject_A;

public class Service_GradeViews implements IService_gradeViews {

   private Scanner scan;
   private View_GradeViews view;
   
   public Service_GradeViews() {
      scan = new Scanner(System.in);
      view = new View_GradeViews();
   }
   
//---------------------------------------------------------------------------------------------------------------------------------------

   /**
    * 1. 관리자 - 4. 성적 조회(메뉴)
    */
   public void gradeViewsInfo() {
      
      view.clearScreen();
      
      view.mainMenu();
      
   }//gradeViewsInfo()
      
//---------------------------------------------------------------------------------------------------------------------------------------

   /**
    * 1. 관리자 - 4. 성적 조회 - a. 과정별 성적 조회
    */
   public String viewOpenCourse() {

      try {
         view.pause();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      view.clearScreen();
      
      view.openCourseListTitle();
      
      DAO_A_GradeViews dao_gdvs = new DAO_A_GradeViews();
      
      //DB작업 > dao 위임
      ArrayList<DTO_ViewOpenCourse_A> list = dao_gdvs.courseList();
      //배열에 시퀀스 저장
      ArrayList<String> courseSeq = new ArrayList<String>();
      
      int i = 1;
      //과정 출력
      for (DTO_ViewOpenCourse_A dto_vOC : list) {
         System.out.printf(i + ".%-30s\t%s\t%s\t%s\n"
                        , dto_vOC.getCourseName()
                        , dto_vOC.getCourseDuration()
                        , dto_vOC.getTeacherName()
                        , dto_vOC.getClassName());
         courseSeq.add(dto_vOC.getOpenCourse_seq());
         i++;
      }
      dao_gdvs.close();
      
      view.openCourseListMenu();
      
      String select = scan.nextLine();
      
      //입력값이 숫자일 경우
      if(isStringDouble(select)) {
         
         int num = Integer.parseInt(select);
         
         try {
            return courseSeq.get(num-1);
         } catch (Exception e) {
            System.out.println("잘못 선택하셨습니다.");
            scan.nextLine();
            viewOpenCourse();
         }
      
      //입력값이 숫자가 아닐 경우
      } else {
         
         if (!select.equalsIgnoreCase("z")) {
            System.out.println("잘못 선택하셨습니다.");
            scan.nextLine();
            viewOpenCourse();
         }
      }
      return null;
      
   }//viewOpenCourse()
   
//---------------------------------------------------------------------------------------------------------------------------------------
   
   /**
    * 1. 관리자 - 4. 성적 조회 - a. 과정별 성적 조회 - 과정 선택결과
    */
   public void viewOpenSubject(String courseSeq) {
      
      try {
         view.pause();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      view.clearScreen();
      
      view.openCourseDetailsTitle();
      
      DAO_A_GradeViews dao_gdvs = new DAO_A_GradeViews();
      
      ArrayList<DTO_ViewOpenSubject_A> list = dao_gdvs.subjectList(courseSeq);
      
      //과정명출력
      System.out.println();
      System.out.printf("■ %s\n", list.get(0).getCourseName());
      System.out.println();
      System.out.println("\t[과목명]\t\t\t[과목기간]");
      
      //배열에 시퀀스 저장
      ArrayList<String> subjectSeq = new ArrayList<String>();

      int i = 1;
      //과목출력
      for (DTO_ViewOpenSubject_A dto_vos : list) {
         System.out.printf(i+".%-30s\t%s\n"
                        , dto_vos.getSubjectName()
                        , dto_vos.getSubjectDuration());
         subjectSeq.add(dto_vos.getOpenSubjectMgmt_seq());
         i++;
      }
      dao_gdvs.close();
      
      view.openCourseDetailsMenu();
      
      String select = scan.nextLine();
      
      //입력값이 숫자일 경우
      if (isStringDouble(select)) {
         
         int num = Integer.parseInt(select);
         
         try {
            subjectDetails(courseSeq, subjectSeq.get(num-1));
         } catch (Exception e) {
            System.out.println("잘못 선택하셨습니다.");
            scan.nextLine();
            viewOpenSubject(courseSeq);
         }
         
      //입력값이 숫자가 아닐 경우
      } else {
         
         if (!select.equalsIgnoreCase("z")) {
            System.out.println("잘못 선택하셨습니다.");
            scan.nextLine();
            viewOpenSubject(courseSeq);
         }
      }
      
   }//viewOpenSubject()
   
//---------------------------------------------------------------------------------------------------------------------------------------

   /**
    * 1. 관리자 - 4. 성적 조회 - a. 과정별 성적 조회 - 과정 - 과목 선택결과
    */
   public void subjectDetails(String courseSeq, String subjectSeq) {
   
      try {
         view.pause();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      view.clearScreen();
      
      view.openSubjectDetailsTitle();
      
      DAO_A_GradeViews dao_gdvs = new DAO_A_GradeViews();
      
      ArrayList<DTO_StudentGradesSubject_A> list = dao_gdvs.studentList(courseSeq, subjectSeq);
      //과목명 출력
      System.out.printf("■ %s\t\n", list.get(0).getSubjectName());
      System.out.println();
      System.out.println("[학생명]\t[점수]");
      System.out.println();
      
      for (DTO_StudentGradesSubject_A dto_sgs : list) {
         
         System.out.printf("%s\t%4.3s\n"
                        , dto_sgs.getStudentName()
                        , dto_sgs.getRecordScore());
      }
      dao_gdvs.close();
      
      view.openSubjectDetailsMenu();
      
      String input = scan.nextLine();
      
      if (!(input==null)) {
         viewOpenSubject(courseSeq);
      }
      
   }//subjectDetails()
   
//---------------------------------------------------------------------------------------------------------------------------------------   
   
   /**
    * 1. 관리자 - 4. 성적 조회 - b. 학생별 성적 조회
    */
   public String viewStudentCourse() {
   
      try {
         view.pause();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      view.clearScreen();
      
      view.studentSearchTitle();
      String name = scan.nextLine();
      
      DAO_A_GradeViews dao_gdvs = new DAO_A_GradeViews();
      
      ArrayList<DTO_StudentsTakingCourses_A> list = dao_gdvs.search(name);
      
      //학생시퀀스 저장용 배열
      ArrayList<String> student_seq = new ArrayList<String>();

      //학생별 과정정보 출력
      System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
      System.out.println("학생명\t주민번호(뒷자리)\t\t과정명\t\t\t과정기간\t\t\t강의실명");
      System.out.println();
      
      int i = 1;
      for(DTO_StudentsTakingCourses_A dto_stc : list) {
         System.out.printf(i+".%s\t%s\t\t%s\t%s\t%s\n"
                        , dto_stc.getStudentName()
                        , dto_stc.getStudentPw()
                        , dto_stc.getCourseName()
                        , dto_stc.getCourseDuration()
                        , dto_stc.getClassName());
         student_seq.add(dto_stc.getStudent_seq());
         i++;
      }
      dao_gdvs.close();
      
      view.back();
      
      String select = scan.nextLine();
      
      //숫자 입력시
      if (isStringDouble(select)) {
         
         int num = Integer.parseInt(select);
         
         try {
            return student_seq.get(num-1);
         } catch (Exception e) {
            System.out.println("번호를 잘못 입력하셨습니다.");
            scan.nextLine();
            viewStudentCourse();
         }
      
      //입력값이 숫자가 아닐 경우
      } else {
         if (!select.equalsIgnoreCase("z")) {
            System.out.println("잘못 선택하셨습니다.");
            scan.nextLine();
            viewStudentCourse();
         } else {
            
         }
      }
      return null;
      
   }//viewStudentCourse()
   
//---------------------------------------------------------------------------------------------------------------------------------------   

   /**
    * 1. 관리자 - 4. 성적 조회 - b. 학생별 성적 조회 - 학생 선택 결과
    */
   public void viewStudentInfo(String studentSeq) {
      
      try {
         view.pause();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      view.clearScreen();
      
      view.studentSubjectInfoTitle();
      
      DAO_A_GradeViews dao_gdvs = new DAO_A_GradeViews();
      
      ArrayList<DTO_StudentCourseGrades_A> list = dao_gdvs.subjectScore(studentSeq);
      
      System.out.println();
      System.out.printf("■ %s\n", list.get(0).getStudentName());
      System.out.println();
      System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
      System.out.println("\t과목명\t\t\t과목기간\t\t\t점수");
      System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
      
      for (DTO_StudentCourseGrades_A dto_scg : list) {
         System.out.printf("%-33s\t%s\t%s\n"
                        , dto_scg.getSubjectName()
                        , dto_scg.getSubjectDuration()
                        , dto_scg.getRecordScore());
      }
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      
      dao_gdvs.close();
      
      view.openSubjectDetailsMenu();
      String input = scan.nextLine();
      
      if (!(input==null)) {
         viewStudentCourse();
      }
      
   }//viewStudentInfo()
   
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

//---------------------------------------------------------------------------------------------------------------------------------------   

}//Class_Service_GradeViews