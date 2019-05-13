package Student;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import DAO.DAO_S;
import DTO.DTO_Example;
import DTO.DTO_TeacherEval_Q;
import DTO_Student.DTO_AttendanceTotal_S;
import DTO_Student.DTO_ConsultRecode_S;
import DTO_Student.DTO_EvalNoStudent_S;
import DTO_Student.DTO_EvalOk_Consult_S;
import DTO_Student.DTO_GradeSearch_S;
import DTO_Student.DTO_RegiCourseInfo_S;
import DTO_Student.DTO_RegiSubjInfo_S;
import DTO_Student.DTO_StudentInfo_S;
import DTO_Student.DTO_StudentLogin_S;
import Main.MainController;

/**
 * 
 * @author 이다현
 * 학생관련 서비스가 모두 담긴 클래스
 *
 */
public class StudentService implements StudentIService {

	Scanner scan = new Scanner(System.in);
	Calendar time = Calendar.getInstance();

	private static StudentView view;
	private static String sId;
	private static String sPw;
	private DAO_S dao;
	public static DTO_StudentLogin_S loginDTO;
	private static String monthNum;
	private static String dailyNum;

	static {
		monthNum = "";
		dailyNum = "";
		view = new StudentView();
	}

	
	/**
	 * StudentService() 생성자
	 */
	public StudentService() {
		dao = new DAO_S();
	}


	
	/**
	 * 학생 로그인 메소드
	 * 
	 * @throws InterruptedException
	 */
	public void studentLogin() throws InterruptedException {

		view.login_T();
		// System.out.println("\t\t\t학생 계정으로 로그인합니다.\n\n");

		System.out.println();
		System.out.print("\t\t\t- ID : ");
		sId = scan.nextLine();

		System.out.print("\t\t\t- PW : ");
		sPw = scan.nextLine();
		System.out.println();

		// DB작업 > StudentDAO위임(select)
		loginDTO = dao.studentLogin(sId, sPw);

		StudentView view = new StudentView();

		try {

			if (loginDTO.getName().equals(sId) && loginDTO.getPw().equals(sPw)) {

				view.pause();
			}
		} catch (Exception e) {
			System.out.println("\t\t\t――――――――――――――――――――――――――");
			System.out.println("\t\t\t엔터를 눌러 다시 로그인 해주세요.");
			view.pause();
			scan.nextLine();
			studentLogin();
		}
	}


	/**
	 * StudentDAO위임받아 로그인하는 메소드
	 */
	public void studentInfo() {

		// DB작업 > StudentDAO위임
		// DTO_StudentInfo_S infoDTO = dao.studentInfo(sId, sPw);

		DTO_StudentInfo_S infoDTO = dao.studentInfo(loginDTO.getStudent_seq());

		// 업무코드
		try {
			System.out.printf("\n\n\n\t\t안녕하세요, %s 님!\n\n", sId);
			System.out.println("\t\t――――――――――――――――――――――――――――――――――――――");
			System.out.println("\n\t\t- 학생 번호 : " + infoDTO.getStudent_seq());
			System.out.println("\n\t\t- 수강 과정명 : " + infoDTO.getCourseName());
			System.out.println("\n\t\t- 과정 기간 : " + infoDTO.getStartDate() + " ~ " + infoDTO.getEndDate());
			System.out.println("\n\t\t- 강의실명 : " + infoDTO.getRoomName());
			System.out.println("\n\t\t- 담당 교사명 : " + infoDTO.getTname());
			System.out.println("\t\t――――――――――――――――――――――――――――――――――――――");
			view.pause();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}


	/**
	 * StudentDAO위임받아 학생 메뉴 보여주는 메소드
	 * 
	 * @throws InterruptedException
	 */
	public void studentMemu() throws InterruptedException {

		boolean loop = true;

		while (loop) {

			StudentService stuService = new StudentService();
			StudentView stuView = new StudentView();

			view.title(StudentView.menu);
			stuView.studentMenu();

			String sel = scan.nextLine();

			if (sel.equals("1")) {
				view.pause();
				stuService.gradeSearch();
			} else if (sel.equals("2")) {
				view.pause();
				stuService.attendSearch();
			} else if (sel.equals("3")) {
				view.pause();
				stuService.teacherEval();
			} else if (sel.equals("4")) {
				view.pause();
				stuService.consRequest();
			} else if (sel.equals("5")) {
				view.pause();
				stuService.consRecSearch();
			} else if (sel.equals("6")) {
				view.pause();
				stuService.regiCourSearch();
			} else if (sel.equals("7")) {
				view.pause();
				stuService.attendInsert();
			} else {
				loop = false;
				MainController.main(null);
			}
			view.pause();

		}

	}





	/**
	 * 로그인한 학생 본인의 성적을 조회해주는 메소드
	 * 
	 * @throws InterruptedException
	 */
	public void gradeSearch() throws InterruptedException {

		view.title(StudentView.gradeOutput);
		System.out.println();
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 과목번호\t과목명\t\t\t과목시작일\t과목종료일\t교사명\t시험점수");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

		ArrayList<DTO_GradeSearch_S> list = dao.gradeSearch(loginDTO.getStudent_seq());

		for (DTO_GradeSearch_S dto : list) {

			System.out.printf(" %s\t%30s\t%s\t%s\t%s\t%s\n", dto.getSubject_seq(), dto.getSubjName(),
					dto.getStartDate(), dto.getEndDate(), dto.getTname(), dto.getScore());

		}
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		view.pause();
	}


	/**
	 * 출석조회를 위해 메뉴를 보여주는 메소드
	 * 
	 * @throws InterruptedException
	 */
	public void attendSearch() throws InterruptedException {

		view.title(StudentView.attendanceOutput);
		StudentView stuView = new StudentView();
		stuView.attendMenu();

		boolean loop = true;

		while (loop) {

			StudentService stuService = new StudentService();

			String sel = scan.nextLine();

			if (sel.equals("1")) {
				view.pause();
				stuService.totalSearch();
			} else if (sel.equals("2")) {
				view.pause();
				stuService.monthSearch();
			} else if (sel.equals("3")) {
				view.pause();
				stuService.dailySearch();
			}else {
				loop = false;
			}
		}

	}

	
	
	/**
	 * 출결 전체 조회 메소드
	 * 
	 * @throws InterruptedException
	 */
	public void totalSearch() throws InterruptedException {
		// 출결 전체 조회
		
		view.title(StudentView.attendanceOutput);
		System.out.println("\t\t\t\t- 전체 조회 -");
		System.out.println();
		System.out.println("\t\t―――――――――――――――――――――――――――――――――――――――――");
		System.out.println("\t\t 날짜\t\t입실시간\t퇴실시간\t출결상태");
		System.out.println("\t\t―――――――――――――――――――――――――――――――――――――――――");

		
		ArrayList<DTO_AttendanceTotal_S> totalList = dao.attendTotal(loginDTO.getStudent_seq());

		for (DTO_AttendanceTotal_S dto : totalList) {

			System.out.printf("\t\t %s\t%s\t%s\t%s\t\n", dto.getAttendDate(), dto.getWorkOn(), dto.getWorkOff(),
					dto.getState());
		}
		System.out.println("\t\t―――――――――――――――――――――――――――――――――――――――――");
		view.pause();
		attendSearch();

	}

	
	/**
	 * 출결 월별 조회 메소드
	 * 
	 * @throws InterruptedException
	 */
	public void monthSearch() throws InterruptedException {
		// 출결 월별 조회
		
		view.title(StudentView.attendanceOutput);
		System.out.println("\t\t\t\t- 월별 조회 -");
		System.out.println();
		System.out.println("\t\t\t――――――――――――――――――――――――――");
		System.out.print("\t\t\t조회할 월 (ex. 01) : ");
		String monthNum = scan.nextLine();
		System.out.println("\t\t\t――――――――――――――――――――――――――");
		view.pause();
		
		view.title(StudentView.attendanceOutput);
		System.out.println("\t\t\t\t- 월별 조회 -");
		System.out.println();
		System.out.println("\t\t―――――――――――――――――――――――――――――――――――――――――");
		System.out.println("\t\t 날짜\t\t입실시간\t퇴실시간\t출결상태");
		System.out.println("\t\t―――――――――――――――――――――――――――――――――――――――――");

		ArrayList<DTO_AttendanceTotal_S> monthList = dao.attendMonth(loginDTO.getStudent_seq(), monthNum);

		for (DTO_AttendanceTotal_S dto : monthList) {

			System.out.printf("\t\t %s\t%s\t%s\t%s\t\n", dto.getAttendDate(), dto.getWorkOn(), dto.getWorkOff(),
					dto.getState());
		}

		System.out.println("\t\t―――――――――――――――――――――――――――――――――――――――――");
		view.pause();
		attendSearch();

	}

	
	/**
	 * 출결 일별 조회 메소드
	 */
	  public void dailySearch() {

	      // 출결 일별 조회
	      
	      
	      // SQL 수정 필요 2019-00-00 형태로 검색
	      view.title(StudentView.attendanceOutput);
	      System.out.println("\t\t\t\t- 일별 조회 -");
	      System.out.println();
	      
	      System.out.print("\n\t\t\t\t조회할 월 : ");
	      String monthNum = scan.nextLine();

	      System.out.print("\n\n\t\t\t\t조회할 일 : ");
	      String dailyNum = scan.nextLine();

	      
	      DTO_AttendanceTotal_S dailyList = dao.attendDaily(loginDTO.getStudent_seq(), monthNum, dailyNum);

	      // 업무코드
	      try {
	         view.pause();
	         
	         view.title(StudentView.attendanceOutput);
	         System.out.println("\t\t\t\t- 일별 조회 -");
	         System.out.println();

	         System.out.println("\n\t\t\t날짜 : " + dailyList.getAttendDate());
	         System.out.println("\n\t\t\t입실시간 : " + dailyList.getWorkOn());
	         System.out.println("\n\t\t\t퇴실시간 : " + dailyList.getWorkOff());
	         System.out.println("\n\t\t\t출결상태 : " + dailyList.getState());

	         
	         view.pause();
	         attendSearch();

	      } catch (Exception e) {
	         System.out.println(e.toString());
	      }

	   }


	  
	  /**
	   * 교사평가 메소드
	   */
	public void teacherEval() {
		System.out.println("\t\t\t\t――――――――――――――――――――――――――");
		System.out.println("\t\t\t\t◆\t교사 평가\t◆");
		System.out.println("\t\t\t\t――――――――――――――――――――――――――");
		

		// 1. 미수료학생 => 평가 불가
		DTO_EvalNoStudent_S evalNo = dao.teacherEvalNo(loginDTO.getStudent_seq());
		// 2. 수료학생 => 평가 가능
		DTO_EvalOk_Consult_S evalOk = dao.teacherEvalOk(loginDTO.getStudent_seq());

		String num = dao.result(loginDTO.getStudent_seq());
		
//		String num = "0";

		// 평가개수여부로 평가완료-평가미완료 구분
		if (num.equals("1")) {

			// 미수료학생
			// 조건:오늘날짜 < 수료날짜
			System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
			System.out.printf("\n\t현재 %s 학생은 [ %s ] 진행중에 있습니다.\n", evalNo.getSname(), evalNo.getCourseName());
			System.out.println("\n\n\n\t교사 평가는 과정 종료 이후부터 가능합니다.\n\n\n");
			System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
			

		} else if (num.equals("0")) {

			// 수료학생
			String count = dao.evalCount(loginDTO.getStudent_seq());
			
//			String count = "0";
			
			if (!(count.equals("0"))) {
				System.out.println("\n\t\t\t\t 이미 평가를 완료하셨습니다.");
				System.out.println("\n\n\t\t\t\t 엔터를 누르시면 이전으로 돌아갑니다.");
				
				
			} else {

				System.out.println("\n\t\t\t\t평가 일시 : " + String.format("%tF", time));
				System.out.println("\t\t\t\t과정명    : " + evalOk.getCourseName());
				System.out.println("\t\t\t\t교사명    : " + evalOk.getTname() + "\n");

				// 객관식 문제의 보기
				ArrayList<DTO_Example> example = dao.example();

				System.out.println(
						"\n\t========================================================================================");
				for (DTO_Example dto : example) {

					System.out.printf("	%s(%s)  ", dto.getContent(), dto.getExample_seq());
				}
				System.out.println(
						"\n\t========================================================================================");

				// 객관식 문제
				System.out.println("\n\n\t\t\t\t[ 전체 강의 평가-객관식 ]");
				System.out.println("\n\t\t\t\t보기를 읽고 해당하는 답변 '번호'를 입력해주세요.\n");

				ArrayList<DTO_TeacherEval_Q> teacherEvalObj = dao.evalObj(loginDTO.getStudent_seq());

				for (DTO_TeacherEval_Q dto : teacherEvalObj) {
					System.out.print("\t\t\t\t" + dto.getEvalQ_seq() + ". " + dto.getQuestion() + "\n");
				}

				System.out.print("\n\t\t\t\t1번: ");
				String q1 = scan.nextLine();

				System.out.print("\t\t\t\t2번: ");
				String q2 = scan.nextLine();

				System.out.print("\t\t\t\t3번: ");
				String q3 = scan.nextLine();

				System.out.print("\t\t\t\t4번: ");
				String q4 = scan.nextLine();

				System.out.print("\t\t\t\t5번: ");
				String q5 = scan.nextLine();

				String regiNum;

				regiNum = dao.regiSeqSave(loginDTO.getStudent_seq());

				// 객관식 입력답안 저장
				dao.obASave(regiNum, q1, q2, q3, q4, q5);

				// 종합의견 작성-서술형
				System.out.println("\n\n\t\t\t\t[ 종합 의견 작성 - 서술형 ]");
				System.out.println("\n\n\t\t\t\t자유롭게 입력해주세요.\n\n");

				// 좋았던 점_출력
				String teacherEvalSubj6 = dao.evalSubj6();
				System.out.println("\t\t\t" + teacherEvalSubj6);

				System.out.print("\t\t\t\t");
				String q6 = scan.nextLine();
				dao.subASave(regiNum, q6);

				// 아쉬운 점 & 개선할 점_출력
				// 좋았던 점_출력
				String teacherEvalSubj7 = dao.evalSubj7();
				
				System.out.println(teacherEvalSubj7);

				System.out.print("\t\t\t\t");
				String q7 = scan.nextLine();
				dao.subASave(regiNum, q7);

				System.out.println("\n\n\t\t\t\t ※ 평가가 완료되었습니다.");
				
				
			}

		}

	}



	/**
	 * 상담 요청 메소드
	 */
	   public void consRequest() {

		      view.title(StudentView.consultInput);
		      
		      System.out.println("\n\n\t\t\t학생 번호 : " + loginDTO.getStudent_seq());
		      System.out.println("\n\t\t\t학생 이름 : " + loginDTO.getName());

		      System.out.println("\n\n\t\t\t상담 요청 날짜 : (예)2019-01-01 \n\n");
		      System.out.print("\t\t\t입력 : ");
		      String requestDate = scan.nextLine();
		      try {
		         view.pause();
		      } catch (InterruptedException e) {
		         e.printStackTrace();
		      }

		      // 상담 요청 가능여부 : 0:불가, 1:가능
		      // - 1. 상담은 과정중에만 가능하다.
		      String num = dao.passRqDate(requestDate, loginDTO.getStudent_seq());

		      if (num.equals("0")) {

		         // 불가할 때
		         System.out.println("\n\t\t\t 과정이 종료되어 상담이 불가합니다.");
		         System.out.println("\n\n\t\t\t 엔터를 누르시면 이전으로 돌아갑니다.");
		         scan.nextLine();
		         System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

		      } else {

		         // 가능할 때
		         // - 2. 상담은 하루 최대 2명까지 선착순으로 신청가능하다.
		         // - 상담 가능 일자 확인여부 : 0:불가, !0:가능
		         String count = dao.consultMax2(requestDate);

		         if (count.equals("0") || count.equals("1")) {
		            // 신청(추가)가능

		            System.out.println(
		                  "\n\t=================================[상담 요청 내용]====================================\n\n");
		            System.out.print("\t\t\t입 력 : ");

		            String content = scan.nextLine();

		            String regiNum = dao.regiSeqSave(loginDTO.getStudent_seq());

		            dao.consultContent(requestDate, content, regiNum);

		            System.out.println("\n\n\t\t\t★ 정상적으로 신청이 완료되었습니다 ★");
		            
		         } else {
		            // 2이상부터 신청불가

		            System.out.println("\n\n\t\t\t★ 신청인원을 초과했습니다. 날짜를 변경해주세요 ★");
		            try {
						view.pause();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

		            consRequest();

		         }

		      }

		   }


	   

	   /**
	    * 학생이 상담일지를 조회하는 메소드
	    */
	public void consRecSearch() {
		// 메인 > 학생 > 5 상담 일지 조회

		ArrayList<DTO_EvalOk_Consult_S> list = new ArrayList<DTO_EvalOk_Consult_S>();
		// 상담일지조회에서 학생명, 과정명, 교사명이 저장되는 리스트

		list = dao.consultInfo(loginDTO.getStudent_seq());
		// dao에서 학생명, 과정명, 교사명이 저장된 리스트를 대입

		ArrayList<DTO_ConsultRecode_S> consultList = new ArrayList<DTO_ConsultRecode_S>();
		// 상담일지조회에서 상담 날짜, 상담요청 내용, 종합의견 저장되는 리스트

		consultList = dao.consultRecordInfo(loginDTO.getStudent_seq());
		// 상담일지조회에서 상담 날짜, 상담요청 내용, 종합의견 저장된 리스트를 대입

		StudentView view = new StudentView();
		view.consultRecordInfo(list, consultList);
		// 메인 > 학생 > 5 상담 일지 조회 출력

		list.clear();
		consultList.clear();
		// clear한 이유는 혹시나 로직 꼬여서 ArrayList 안의 값이 중복되어 나타날 경우를 대비

	}

	
	/**
	 * 학생이 본인의 과정 및 과목을 조회하는 메소드
	 */
	public void regiCourSearch() {
		// 메인 > 학생 > 6 과정 및 과목 조회

		ArrayList<DTO_RegiCourseInfo_S> list = new ArrayList<DTO_RegiCourseInfo_S>();
		// 수강중인 과정, 담당교사, 강의실 정보 저장하는 list

		list = dao.regiCourSearchInfo(loginDTO.getStudent_seq());
		// 수강중인 과정, 담당교사, 강의실 정보 저장하는 list를 대입

		ArrayList<DTO_RegiSubjInfo_S> subjectList = new ArrayList<DTO_RegiSubjInfo_S>();
		// 과목번호, 과목명, 과목시작일, 과목종료일 정보 저장하는 list

		subjectList = dao.regiCourSearchSubjectInfo(loginDTO.getStudent_seq());
		// 과목번호, 과목명, 과목시작일, 과목종료일 정보 저장하는 list 대입

		StudentView view = new StudentView();
		view.regiCourSearch(list, subjectList);
		// 메인 > 학생 > 6 과정 및 과목 조회 출력

		list.clear();
		subjectList.clear();
		// clear한 이유는 혹시나 로직 꼬여서 ArrayList 안의 값이 중복되어 나타날 경우를 대비
	}

	
	/**
	 * 출석 입력 메소드
	 */
	public void attendInsert() {

		System.out.println();
		System.out.println("\t\t\t――――――――――――――――――――――――――");
		System.out.println("\t\t\t◆\t출석 입력\t◆");
		System.out.println("\t\t\t――――――――――――――――――――――――――");
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
		

		String count = dao.attendRecord(StudentService.loginDTO.getStudent_seq());

		// 동일 날짜에 insert는 1번 => 추가는 update

		if (count.equals("0")) { // 출근안한상태 : count값이 동일

			dao.attendInsert(StudentService.loginDTO.getStudent_seq());

			System.out.println();

		} else { // 출근O - 퇴근X

			dao.attendUpdate(StudentService.loginDTO.getStudent_seq());

		}
	}

}
