package Teacher;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.DAO_T;
import DAO.DAO_T_Attendance;
import DAO.DAO_T_Consult;
import DAO.DAO_T_Evaluation;
import DAO.DAO_T_Grade;
import DTO_Teacher.DTO_AttendanceMGMT_T;
import DTO_Teacher.DTO_ConsultFinish_T;
import DTO_Teacher.DTO_Consult_T;
import DTO_Teacher.DTO_CourseOfTeacher_T;
import DTO_Teacher.DTO_EvalObjective_T;
import DTO_Teacher.DTO_EvalSubjective_T;
import DTO_Teacher.DTO_GradeInput_T;
import DTO_Teacher.DTO_GradeOutput_T;
import DTO_Teacher.DTO_StudentOfCourse_T;
import DTO_Teacher.DTO_SubjectForGrade_T;
import DTO_Teacher.DTO_SubjectOfCourse_T;

/**
 * 교사 로그인 시  데이터 입출력, 화면 입출력, 데이터 연상 가공 등을 담당하는 클래스
 * @author KCM
 *
 */
public class TeacherService implements IService {

	// 업무 중 일부가 DAO에게 위임 > 선택
	private DAO_T dao;
	private DAO_T_Attendance daoatd;
	private DAO_T_Grade daotg;
	private DAO_T_Consult daoc;
	private DAO_T_Evaluation daoe;
	private TeacherView view;
	private Scanner scan;
	private static int flag = 0;

	public static String subjectNum;
	public static String startDate;
	public static String endDate;
	public static String seldate;
	public static String consultNum;
	public static String consultContent;
	public static String studentNum;
	public static String score;
	public static String day;
	public static String name;

	public TeacherService() {
		dao = new DAO_T();
		daotg = new DAO_T_Grade();
		daoc = new DAO_T_Consult();
		daoe = new DAO_T_Evaluation();
		view = new TeacherView();
		daoatd = new DAO_T_Attendance();
		scan = new Scanner(System.in);
	}

// ----------------------------------------------------------------------
//		[1] 강의스케줄 조회 - (1) 과정, 과목 출력
// ----------------------------------------------------------------------

	/**
	 * 강의스케줄(과정, 과목)을 출력해주고 다른 화면으로 넘겨주는 메소드, DAO와 연동
	 */
	@Override
	public void teacherSchedule() throws InterruptedException { // 강의스케줄 조회

		view.title(TeacherView.schedule); // 타이틀 출력

		ArrayList<DTO_CourseOfTeacher_T> dto_teacher_list = new ArrayList<DTO_CourseOfTeacher_T>();

		dto_teacher_list = dao.teacherSchedule_1();
		
		System.out.println();
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 과정명\t\t\t\t시작날짜\t\t종료날짜\t\t강의실명");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		// System.out.println("// DAO 부분"); //teacherSchedule1
		for (int i = 0; i < dto_teacher_list.size(); i++) {
			System.out.printf(" %s\t%s\t%s\t%s\n", dto_teacher_list.get(i).getCourseName(),
					dto_teacher_list.get(i).getCourseStartDate(), dto_teacher_list.get(i).getCourseEndDate(),
					dto_teacher_list.get(i).getRoomName());
		}
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println();
		String select = "";

		if (flag == 0) { // 맨 처음에는 flag가 0, 선택 메뉴 출력

			System.out.println("\t\t\t――――――――――――――――――――――――――");
			System.out.println("\t\t\t[  ] 안의 번호를 입력해주세요.");
			System.out.println();
			System.out.println("\t\t\t[1] 과목보기");
			System.out.println("\t\t\t[2] 학생정보 보기");
			System.out.println("\t\t\t[0] 교사 메뉴로 돌아가기");
			System.out.println("\t\t\t――――――――――――――――――――――――――");
			System.out.print("\t\t\t번호 : ");
		}

		ArrayList<DTO_SubjectOfCourse_T> dto_soc = new ArrayList<DTO_SubjectOfCourse_T>();

		dto_soc = dao.teacherSchedule_2();

		if (flag == 1) { // 과목 출력
			System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
			System.out.println(" 과목명\t\t\t\t시작날짜\t\t종료날짜\t\t학습기간");
			System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
			// System.out.println("// DAO 부분"); //teacherSchedule2
			for (int i = 0; i < dto_soc.size(); i++) {
				System.out.printf(" %-30s\t%s\t%s\t%2s\n", dto_soc.get(i).getSubjectname(),
						dto_soc.get(i).getSubjectStartDate(), dto_soc.get(i).getSubjectEndDate(),
						dto_soc.get(i).getSubjectPeriod());
			}
			System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
			System.out.println("\t\t\t――――――――――――――――――――――――――");
			System.out.println("\t\t\t[  ] 안의 번호를 입력해주세요.");
			System.out.println();
			System.out.println("\t\t\t[2] 학생정보 보기");
			System.out.println("\t\t\t[0] 교사 메뉴로 돌아가기");
			System.out.println("\t\t\t――――――――――――――――――――――――――");
			System.out.print("\t\t\t번호 : ");
		}

		select = scan.nextLine(); // 선택 번호 입력
		view.pause();

		switch (select) {

		case "1": // 과목보기
			flag = 1;
			teacherSchedule();
			break;

		case "2": // 학생정보 보기
			flag = 1;
			studentInfo();
			break;

		case "0": // 교사 메뉴로 돌아가기
			flag = 0;
			TeacherController.t_menu();
			break;
		}
	}

// ----------------------------------------------------------------------
//		[1] 강의스케줄 조회 - (2) 학생정보 출력
// ----------------------------------------------------------------------

	/**
	 * DAO와 연동하여 학생정보를 출력해주는 메소드
	 */
	@Override
	public void studentInfo() throws InterruptedException { // 강의스케줄 조회 - 학생정보 보기

		view.title(TeacherView.studentInfo); // 타이틀 출력

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 이름\t학번\t연락처\t\t전공\t\t수강중인 과정");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

		ArrayList<DTO_StudentOfCourse_T> dto_soc = new ArrayList<DTO_StudentOfCourse_T>();

		dto_soc = dao.teacherSchedule_3();

		if (flag == 1) { // 25명 중 1~10번까지 DAO 출력

			// System.out.println("DAO 출력"); //teacherSchedule3
			for (int i = 0; i < 10; i++) {
				System.out.printf(" %s\t%s\t%s\t%-10s\t%s\n", dto_soc.get(i).getStudentName(),
						dto_soc.get(i).getStudent_seq(), dto_soc.get(i).getStudentTel(), dto_soc.get(i).getMajor(),
						dto_soc.get(i).getCourseName());
			}
			System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
			System.out.println("\t\t\t\t(1..10 / 25)");

		} else if (flag == 2) { // 25명 중 11~20번까지 DAO 출력

			// System.out.println("DAO 출력");
			for (int i = 10; i < 20; i++) {
				System.out.printf(" %s\t%s\t%s\t%-10s\t%s\n", dto_soc.get(i).getStudentName(),
						dto_soc.get(i).getStudent_seq(), dto_soc.get(i).getStudentTel(), dto_soc.get(i).getMajor(),
						dto_soc.get(i).getCourseName());
			}
			System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
			System.out.println("\t\t\t\t(11..20 / 25)");

		} else if (flag == 3) { // 25명 중 21~25번까지 DAO 출력

			// System.out.println("DAO 출력");
			for (int i = 20; i < dto_soc.size(); i++) {
				System.out.printf(" %s\t%s\t%s\t%-10s\t%s\n", dto_soc.get(i).getStudentName(),
						dto_soc.get(i).getStudent_seq(), dto_soc.get(i).getStudentTel(), dto_soc.get(i).getMajor(),
						dto_soc.get(i).getCourseName());
			}
			System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
			System.out.println("\t\t\t\t(21..25 / 25)");

		}

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("\t\t\t――――――――――――――――――――――――――");
		System.out.println("\t\t\t[  ] 안의 번호를 입력해주세요.");

		if (flag == 1) {
			System.out.println();
			System.out.println("\t\t\t[1] 더보기");
			System.out.println("\t\t\t[0] 교사 메뉴로 돌아가기");
		} else if (flag == 2) {
			System.out.println();
			System.out.println("\t\t\t[1] 더보기");
			System.out.println("\t\t\t[2] 이전으로 돌아가기");
			System.out.println("\t\t\t[0] 교사 메뉴로 돌아가기");
		} else if (flag == 3) {
			System.out.println();
			System.out.println("\t\t\t[2] 이전으로 돌아가기");
			System.out.println("\t\t\t[0] 교사 메뉴로 돌아가기");
		}

		System.out.println("\t\t\t――――――――――――――――――――――――――");
		System.out.print("\t\t\t번호 : ");
		String select = scan.nextLine(); // 선택 번호 입력
		view.pause();

		switch (select) {

		case "1": // 더보기
			flag++;
			studentInfo();
			break;

		case "2": // 이전으로 돌아가기
			flag--;
			studentInfo();
			break;

		case "0": // 교사 메뉴로 돌아가기
			flag = 0;
			TeacherController.t_menu();
			break;
		}
	}

// ----------------------------------------------------------------------
//		[2] 성적 입출력 - (1) 과정, 과목 출력
// ----------------------------------------------------------------------

	/**
	 * DAO와 연동하여 과정, 과목 정보를 출력해주는 메소드
	 */
	@Override
	public void gradeInputOuput() throws InterruptedException { // 성적입출력

		view.title(TeacherView.gradeInputOutput);

		ArrayList<DTO_CourseOfTeacher_T> dto_teacher_list = new ArrayList<DTO_CourseOfTeacher_T>();
		ArrayList<DTO_SubjectForGrade_T> dto_grade = new ArrayList<DTO_SubjectForGrade_T>();

		dto_teacher_list = dao.teacherSchedule_1();
		dto_grade = daotg.teacherGrade_1();

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 과정명\t\t\t\t시작날짜\t종료날짜\t강의실명");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

		// System.out.println("// DAO 부분"); //teacherSchedule1
		for (int i = 0; i < dto_teacher_list.size(); i++) {
			System.out.printf(" %-30s\t%s\t%s\t%2s\n", dto_teacher_list.get(i).getCourseName(),
					dto_teacher_list.get(i).getCourseStartDate(), dto_teacher_list.get(i).getCourseEndDate(),
					dto_teacher_list.get(i).getRoomName());
		}

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println();
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 과목번호\t과목명\t\t\t\t\t\t종료날짜");
	      System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	      // System.out.println("// DAO 부분"); //teacherGrade_1
	      for (int i = 0; i < dto_grade.size(); i++) {
	         System.out.printf(" %s\t%-50s\t\t%s\n", dto_grade.get(i).getSubject_seq(), dto_grade.get(i).getSubjectName(),
	               dto_grade.get(i).getSubjectEndDate());
	      }
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println();
		System.out.println("\t\t\t――――――――――――――――――――――――――");
		System.out.println("\t\t\t[  ] 안의 번호를 입력해주세요.");
		System.out.println();
		System.out.println("\t\t\t[1] 성적입력");
		System.out.println("\t\t\t[2] 성적조회");
		System.out.println("\t\t\t[0] 교사 메뉴로 돌아가기");
		System.out.println("\t\t\t――――――――――――――――――――――――――");
		System.out.print("\t\t\t선택 : ");
		String select = scan.nextLine(); // 선택 번호 입력
		System.out.println("\t\t\t――――――――――――――――――――――――――");

		// String subjectNum = "";

		switch (select) {

		case "1": // 성적입력
			System.out.println("\t\t\t성적을 입력하실 [ 과목번호 ]를 입력해주세요.");
			System.out.print("\t\t\t과목번호 : ");
			subjectNum = scan.nextLine(); // 과목번호

			System.out.println("\t\t\t――――――――――――――――――――――――――");
			// System.out.println("[ DAO 부분 작업 : 과목명 ] 성적입력 화면으로 이동합니다...");
			System.out.printf("\t\t\t[%s] 성적입력 화면으로 이동합니다...\n",
					dto_grade.get(Integer.parseInt(subjectNum) - 1).getSubjectName());

			view.pause();
			flag = 1;
			gradeInput();
			break;

		case "2": // 성적조회
			System.out.println("\t\t\t성적을 조회하실 [ 과목번호 ]를 입력해주세요.");
			System.out.print("\t\t\t과목번호 : ");
			subjectNum = scan.nextLine(); // 과목번호

			System.out.println("\t\t\t――――――――――――――――――――――――――");
			// System.out.println("[ DAO 부분 작업 : 과목명 ] 성적조회 화면으로 이동합니다...");
			System.out.printf("\t\t\t[%s] 성적조회 화면으로 이동합니다...\n",
					dto_grade.get(Integer.parseInt(subjectNum) - 1).getSubjectName());

			view.pause();
			flag = 1;
			gradeOutput();
			break;

		case "0": // 교사 메뉴로 돌아가기
			view.pause();
			TeacherController.t_menu();
			break;
		}
	}

// ----------------------------------------------------------------------
//		[2] 성적 입출력 - (2) 성적조회
// ----------------------------------------------------------------------

	/**
	 * 과목별 성적을 출력해주는 메소드
	 */
	@Override
	public void gradeOutput() throws InterruptedException { // 성적조회

		ArrayList<DTO_CourseOfTeacher_T> dto_teacher_list = new ArrayList<DTO_CourseOfTeacher_T>();
		ArrayList<DTO_SubjectForGrade_T> dto_grade = new ArrayList<DTO_SubjectForGrade_T>();

		view.title(TeacherView.gradeOutput);
		System.out.println();
		// System.out.println("과정명 : DAO 작업 필요");
		for (int i = 0; i < dto_teacher_list.size(); i++) {
			System.out.printf(" 과정명 : %s\n", dto_teacher_list.get(i).getCourseName());
		}

		// System.out.println("과목명 : DAO 작업 필요");

		System.out.println();
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 학번\t이름\t과목명\t\t   점수");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

		ArrayList<DTO_GradeOutput_T> dto_gop = new ArrayList<DTO_GradeOutput_T>();

		dto_gop = daotg.teacherGrade_2();

		if (flag == 1) { // 25명 중 1~10번까지 DAO 출력

			// System.out.println("DAO 출력");
			for (int i = 0; i < 10; i++) {
				System.out.printf(" %s\t%s\t%s\t   %s\n", dto_gop.get(i).getStudent_seq(),
						dto_gop.get(i).getStudentName(), dto_gop.get(i).getSubjectName(), dto_gop.get(i).getScore());
			}
			System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
			System.out.println("\t\t\t(1..10 / 25)");

		} else if (flag == 2) { // 25명 중 11~20번까지 DAO 출력

			// System.out.println("DAO 출력");
			for (int i = 10; i < 20; i++) {
				System.out.printf(" %s\t%s\t%s\t   %s\n", dto_gop.get(i).getStudent_seq(),
						dto_gop.get(i).getStudentName(), dto_gop.get(i).getSubjectName(), dto_gop.get(i).getScore());
			}
			System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
			System.out.println("\t\t\t(11..20 / 25)");

		} else if (flag == 3) { // 25명 중 21~25번까지 DAO 출력

			// System.out.println("DAO 출력");
			for (int i = 20; i < dto_gop.size(); i++) {
				System.out.printf("%s\t%s\t%s\t   %s\n", dto_gop.get(i).getStudent_seq(),
						dto_gop.get(i).getStudentName(), dto_gop.get(i).getSubjectName(), dto_gop.get(i).getScore());
			}
			System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
			System.out.println("\t\t\t(21..25 / 25)");

		}

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("\t\t\t――――――――――――――――――――――――――");
		System.out.println("\t\t\t[  ] 안의 번호를 입력해주세요.");
		System.out.println();

		if (flag == 1) {
			System.out.println("\t\t\t[1] 다음 >>");
			System.out.println("\t\t\t[2] 점수입력");
			System.out.println("\t\t\t[#] 과목목록으로 돌아가기");
			System.out.println("\t\t\t[0] 교사 메뉴로 돌아가기");
		} else if (flag == 2) {
			System.out.println("\t\t\t[1] 다음 >>");
			System.out.println("\t\t\t[2] 점수입력");
			System.out.println("\t\t\t[3] << 이전");
			System.out.println("\t\t\t[#] 과목목록으로 돌아가기");
			System.out.println("\t\t\t[0] 교사 메뉴로 돌아가기");
		} else if (flag == 3) {
			System.out.println("\t\t\t[2] 점수입력");
			System.out.println("\t\t\t[3] << 이전");
			System.out.println("\t\t\t[#] 과목목록으로 돌아가기");
			System.out.println("\t\t\t[0] 교사 메뉴로 돌아가기");
		}

		System.out.println("\t\t\t――――――――――――――――――――――――――");
		System.out.print("\t\t\t번호 : ");
		String select = scan.nextLine(); // 선택 번호 입력
		view.pause();

		switch (select) {

		case "1": // 더보기
			flag++;
			gradeOutput();
			break;

		case "2": // 점수입력
			gradeInput();
			view.pause();
			break;

		case "3": // 이전으로 돌아가기
			flag--;
			gradeOutput();
			break;

		case "#": // 과목목록으로 돌아가기
			flag = 1;
			gradeInputOuput();
			break;

		case "0": // 교사 메뉴로 돌아가기
			flag = 0;
			TeacherController.t_menu();
			break;
		}
	}

// ----------------------------------------------------------------------
//		[2] 성적 입출력 - (3) 성적입력
// ----------------------------------------------------------------------

	/**
	 * 선택한 과목별 점수와 학생정보를 함께 출력해주고, 입력받은 점수를 수정하는 클래스
	 */
	@Override
	public void gradeInput() throws InterruptedException { // 성적조회

		view.title(TeacherView.gradeInput);

		ArrayList<DTO_CourseOfTeacher_T> dto_teacher_list = new ArrayList<DTO_CourseOfTeacher_T>();

		dto_teacher_list = dao.teacherSchedule_1();

		ArrayList<DTO_GradeOutput_T> dto_gop = new ArrayList<DTO_GradeOutput_T>();

		dto_gop = daotg.teacherGrade_2();

		ArrayList<DTO_GradeInput_T> dto_gip1 = new ArrayList<DTO_GradeInput_T>();

		dto_gip1 = daotg.teacherGrade_3();

		System.out.println();
		// System.out.println("과정명 : DAO 작업 필요");
		for (int i = 0; i < dto_teacher_list.size(); i++) {
			System.out.printf("과정명 : %s\n", dto_teacher_list.get(i).getCourseName());
		}

		// System.out.println("과목명 : DAO 작업 필요");
		System.out.println();
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("학번\t이름\t과목명\t\t                     점수");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

		if (flag == 1) { // 25명 중 1~10번까지 DAO 출력

			// System.out.println("DAO 출력");
			for (int i = 0; i < 10; i++) {
				System.out.printf("%s\t%s\t%s\t\t  %s\n", dto_gop.get(i).getStudent_seq(),
						dto_gop.get(i).getStudentName(), dto_gop.get(i).getSubjectName(), dto_gop.get(i).getScore());
			}
			System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
			System.out.println("\t\t(1..10 / 25)");

		} else if (flag == 2) { // 25명 중 11~20번까지 DAO 출력

			// System.out.println("DAO 출력");
			for (int i = 10; i < 20; i++) {
				System.out.printf("%s\t%s\t%s\t\t  %s\n", dto_gop.get(i).getStudent_seq(),
						dto_gop.get(i).getStudentName(), dto_gop.get(i).getSubjectName(), dto_gop.get(i).getScore());
			}
			System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
			System.out.println("\t\t(11..20 / 25)");

		} else if (flag == 3) { // 25명 중 21~25번까지 DAO 출력

			// System.out.println("DAO 출력");
			for (int i = 20; i < dto_gop.size(); i++) {
				System.out.printf("%s\t%s\t%s\t\t  %s\n", dto_gop.get(i).getStudent_seq(),
						dto_gop.get(i).getStudentName(), dto_gop.get(i).getSubjectName(), dto_gop.get(i).getScore());
			}
			System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
			System.out.println("\t\t(21..25 / 25)");

		}

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("\t\t\t――――――――――――――――――――――――――");
		System.out.println("\t\t\t입력하실 [ 학번 ] 과 [ 점수 ]를 입력해주세요.");
		System.out.println();
		System.out.print("\t\t\t- 학번 : ");
		studentNum = scan.nextLine();
		System.out.print("\t\t\t- 점수 : ");
		score = scan.nextLine();
		// System.out.println("DAO 작업 필요\n// ** 보고 있는 화면에 따라서 출력되는 화면이 달라짐\n//SQL 수정
		// 필요");
		daotg.teacherGrade_4();
		// System.out.println("수정되었습니다. 성적조회 화면으로 이동합니다.");
		view.pause();
		gradeOutput();
	}

	// 수정 필요
	
// ----------------------------------------------------------------------
//		[3] 출결관리 및 조회 - (1) 메뉴출력
// ----------------------------------------------------------------------

	/**
	 * 출결관리 및 조회에서 세부메뉴 선택, 세부내용별 검색을 위해 입력값을 넘겨주는 메소드
	 */
	@Override
	public void attendanceMGMT() throws InterruptedException { // 출결관리 및 조회

		view.title(TeacherView.attendanceMGMT);

		System.out.println();
		System.out.println("\t\t\t――――――――――――――――――――――――――");
		System.out.println();
		System.out.println("\t\t\t[1] 전체 학생 날짜 조회");
		System.out.println("\t\t\t[2] 특정 학생 기간 조회");
		System.out.println("\t\t\t[3] 특정 학생 날짜 조회");
		System.out.println("\t\t\t[0] 교사 메뉴로 돌아가기");
		System.out.println();
		System.out.println("\t\t\t――――――――――――――――――――――――――");
		System.out.println();
		System.out.println("\t\t\t이동하실 메뉴의 번호를 입력해주세요.");
		System.out.println();
		System.out.print("\t\t\t선택 : ");
		String select = scan.nextLine();

		switch (select) {

		case "1": // 날짜 조회 -> 전체 학생 // UI 수정, 과목 추가
			flag = 1;
			view.pause();
			break;

		case "2": // 기간 조회 -> 개인
			flag = 2;
			view.pause();
			break;

		case "3": // 날짜 조회 -> 개인
			flag = 1;
			view.pause();
			break;

		case "0": // 교사 메뉴로 돌아가기
			flag = 0;
			view.pause();
			TeacherController.t_menu();
			break;
		}

		view.title(TeacherView.attendanceOutput); // 출결조회

		System.out.println();
		System.out.println("\t\t\t――――――――――――――――――――――――――");
		System.out.println();

		if (flag == 1) { // 날짜 조회 -> 전체, 개인

			System.out.println("\t\t\t조회하실 날짜를 입력해주세요.");
			System.out.println();
			System.out.print("\t\t\t- 년월일 : ");
			seldate = scan.nextLine();

			if ((Integer.parseInt(select) == 3)) { // 개인

				System.out.print("\t\t\t- 이름 : ");
				name = scan.nextLine();
				flag = 5;

			} else if ((Integer.parseInt(select) == 1)) { // 전체

				flag = 3;

			}

		} else if (flag == 2) { // 기간 조회 -> 개인

			if (Integer.parseInt(select) == 2) {

				System.out.println("\t\t\t조회하실 기간을 입력해주세요.");
				System.out.println();
				System.out.print("\t\t\t- 언제부터 : ");
				startDate = scan.nextLine();
				System.out.print("\t\t\t- 언제까지 : ");
				endDate = scan.nextLine();
				System.out.print("\t\t\t- 이름 : ");
				name = scan.nextLine();

				flag = 4;
				
			}
		}
		
		
		view.pause();
		attendanceOutput(flag);
	}

// ----------------------------------------------------------------------
//			[3] 출결관리 및 조회 - (2) 출결조회
// ----------------------------------------------------------------------

	/**
	 * DAO와 연동하여 입력받은 flag 값에 따라 테이블 결과를 출력해주는 메소드
	 */
	@Override
	public void attendanceOutput(int flag) throws InterruptedException {

		view.title(TeacherView.attendanceOutput);
		
		ArrayList<DTO_AttendanceMGMT_T> dto_attendance_list1 = new ArrayList<DTO_AttendanceMGMT_T>();
		dto_attendance_list1 = daoatd.allStdDate();

		ArrayList<DTO_AttendanceMGMT_T> dto_attendance_list2 = new ArrayList<DTO_AttendanceMGMT_T>();
		dto_attendance_list2 = daoatd.persPeriodDate();

		ArrayList<DTO_AttendanceMGMT_T> dto_attendance_list3 = new ArrayList<DTO_AttendanceMGMT_T>();
		dto_attendance_list3 = daoatd.personalDate();

		if (flag == 3) { // 전체 출결 조회(날짜)

			System.out.println("\t\t\t\t-전체 출결 조회 -");
			System.out.println();
			System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
			System.out.println(" 이름\t날짜\t\t출근시간\t퇴근시간\t근태상황");
			System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

			for (int i = 0; i < dto_attendance_list1.size(); i++) {
				System.out.printf(" %s\t%s\t%s\t%s\t%s\n", dto_attendance_list1.get(i).getStudentName(),
						dto_attendance_list1.get(i).getAttendDate(), dto_attendance_list1.get(i).getStartTime(),
						dto_attendance_list1.get(i).getEndTime(), dto_attendance_list1.get(i).getState());
			}
			System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		} else if (flag == 4) { // 개인 출결 조회(기간)

			System.out.println("\t\t\t\t-개인 기간 조회 -");
			System.out.println();
			System.out.printf("\t\t 날짜 : %s ~ %s\n", startDate, endDate);
			System.out.printf("\t\t 이름 : %s\n", name);

			System.out.println("\t\t―――――――――――――――――――――――――――――――――――――――――");
			System.out.println("\t\t 날짜\t\t출근시간\t퇴근시간\t근태상황");
			System.out.println("\t\t―――――――――――――――――――――――――――――――――――――――――");

			for (int i = 0; i < dto_attendance_list2.size(); i++) {
				System.out.printf("\t\t %s\t%s\t%s\t%s\n", dto_attendance_list2.get(i).getAttendDate(),
						dto_attendance_list2.get(i).getStartTime(), dto_attendance_list2.get(i).getEndTime(),
						dto_attendance_list2.get(i).getState());
			}
			System.out.println("\t\t―――――――――――――――――――――――――――――――――――――――――");
		} else if (flag == 5) { // 개인 기간 조회(날짜)

			System.out.println("\t\t\t\t-개인 날짜 조회 -");
			System.out.println();
			System.out.printf("\t\t\t 날짜 : %s\n", seldate);
			System.out.printf("\t\t\t 이름 : %s\n", name);
			System.out.println("\t\t\t――――――――――――――――――――――――――");
			System.out.println("\t\t\t 출근시간\t퇴근시간\t근태상황");
			System.out.println("\t\t\t――――――――――――――――――――――――――");

			for (int i = 0; i < dto_attendance_list3.size(); i++) {
				System.out.printf("\t\t\t %s\t%s\t%s\n", dto_attendance_list3.get(i).getStartTime(),
						dto_attendance_list3.get(i).getEndTime(), dto_attendance_list3.get(i).getState());
			}
			System.out.println("\t\t\t――――――――――――――――――――――――――");
		}
		
		view.pause();
		attendanceMGMT();

	}

// ----------------------------------------------------------------------
//			[4] 교사평가 조회  - (1) 메뉴
// ----------------------------------------------------------------------

	/**
	 * 교사평가 조회 메뉴 출력, 해당 메뉴로 넘겨주는 메소드
	 */
	@Override
	public void teacherEvaluation() throws InterruptedException { // 교사평가 메뉴

		view.title(TeacherView.evaluation);

		ArrayList<DTO_CourseOfTeacher_T> dto_teacher_list = new ArrayList<DTO_CourseOfTeacher_T>();

		dto_teacher_list = dao.teacherSchedule_1();

		System.out.println();
		// System.out.println("과정명 : [ DAO 작업 필요 ]");
		for (int i = 0; i < dto_teacher_list.size(); i++) {
			System.out.printf("\t\t\t과정명 : [ %s ]\n", dto_teacher_list.get(i).getCourseName());
		}
		System.out.println();
		System.out.println("\t\t\t――――――――――――――――――――――――――");
		System.out.println();
		System.out.println("\t\t\t[1] 객관식 통계");
		System.out.println("\t\t\t[2] 좋았던 점");
		System.out.println("\t\t\t[3] 아쉬운 점 & 개선할 점");
		System.out.println("\t\t\t[0] 교사 메뉴로 돌아가기");
		System.out.println();
		System.out.println("\t\t\t――――――――――――――――――――――――――");
		System.out.println();
		System.out.println("\t\t\t[  ] 안의 번호를 입력해주세요.");
		System.out.println();
		System.out.print("\t\t\t선택 : ");
		int select = Integer.parseInt(scan.nextLine());
		String str = " ";
		view.pause();

		switch (select) {

		case 1: // 객관식 통계
			str = "객관식 통계";
			evalOutput(select, str); // 출력
			break;

		case 2: // 좋았던 점
			flag = 1;
			str = "좋았던 점";
			evalOutput(select, str); // 출력
			break;

		case 3: // 아쉬운 점 & 개선할 점
			flag = 1;
			str = "아쉬운 점 & 개선할 점";
			evalOutput(select, str); // 출력
			break;

		case 0: // 교사 메뉴로 돌아가기
			flag = 0;
			TeacherController.t_menu();
			break;
		}

	}

// ----------------------------------------------------------------------
//				[4] 교사평가 조회 - (2) 평가결과
// ----------------------------------------------------------------------

	/**
	 * DAO와 연동하여 선택한 메뉴에 따라 교사평가 결과를 출력해주는 메소드 
	 */
	
	@Override
	public void evalOutput(int select, String str) throws InterruptedException {

		view.title(TeacherView.evaluation);

		ArrayList<DTO_CourseOfTeacher_T> dto_teacher_list = new ArrayList<DTO_CourseOfTeacher_T>();

		dto_teacher_list = dao.teacherSchedule_1();

		System.out.println();
		// System.out.println("과정명 : [ DAO 작업 필요 ]");
		for (int i = 0; i < dto_teacher_list.size(); i++) {
			System.out.printf("과정명 : [ %s ]\n", dto_teacher_list.get(i).getCourseName());
		}
		System.out.print("- ");

		if (select == 1) { // 객관식

	         ArrayList<DTO_EvalObjective_T> dto_eo = new ArrayList<DTO_EvalObjective_T>();

	         dto_eo = daoe.teacherEval_3();

	         System.out.println(str);
	         System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	         System.out.println(" 번호\t질문\t\t\t\t   매우그렇다\t그렇다\t보통이다\t아니다\t매우아니다");
	         System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	         System.out.println(" 단위 : (%)");
	         // System.out.println("DAO작업 필요");
	         for (int i = 0; i < dto_eo.size(); i++) {
	            System.out.printf(" %s\t%-30s\t%s\t%s\t%s\t%s\t%s\n", dto_eo.get(i).getEvalQ_seq(),
	                  dto_eo.get(i).getObjective_Q(), dto_eo.get(i).getVeryGood(), dto_eo.get(i).getGood(),
	                  dto_eo.get(i).getNormal(), dto_eo.get(i).getBad(), dto_eo.get(i).getVeryBad());
	         }

	      } else if (select == 2) { // 좋았던 점 주관식

	         ArrayList<DTO_EvalSubjective_T> dto_es = new ArrayList<DTO_EvalSubjective_T>();

	         dto_es = daoe.teacherEval_1();

	         System.out.println(str);
	         System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	         System.out.println(" 번호\t내용");
	         System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

	         if (flag == 1) { // 25명 중 1~10번까지 DAO 출력

	            // System.out.println("DAO 출력");
	            for (int i = 0; i < 10; i++) {
	               System.out.printf("%s\t%s\n", i + 1, dto_es.get(i).getSubjective_A());
	            }
	            System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	            System.out.println("\t\t\t(1..10 / 25)");

	         } else if (flag == 2) { // 25명 중 11~20번까지 DAO 출력

	            // System.out.println("DAO 출력");
	            for (int i = 10; i < 20; i++) {
	               System.out.printf("%s\t%s\n", i + 1, dto_es.get(i).getSubjective_A());
	            }
	            System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	            System.out.println("\t\t\t(11..20 / 25)");

	         } else if (flag == 3) { // 25명 중 21~25번까지 DAO 출력

	            // System.out.println("DAO 출력");
	            for (int i = 20; i < dto_es.size(); i++) {
	               System.out.printf("%s\t%s\n", i + 1, dto_es.get(i).getSubjective_A());
	            }
	            System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	            System.out.println("\t\t\t(21..25 / 25)");

	         }
	      } else if (select == 3) { // 아쉬운 점 주관식

	         ArrayList<DTO_EvalSubjective_T> dto_es = new ArrayList<DTO_EvalSubjective_T>();

	         dto_es = daoe.teacherEval_2();

	         System.out.println(str);
	         System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	         System.out.println("번호\t내용");
	         System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

	         if (flag == 1) { // 25명 중 1~10번까지 DAO 출력

	            // System.out.println("DAO 출력");
	            for (int i = 0; i < 10; i++) {
	               System.out.printf("%s\t%s\n", i + 1, dto_es.get(i).getSubjective_A());
	            }
	            System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	            System.out.println("\t\t\t(1..10 / 25)");

	         } else if (flag == 2) { // 25명 중 11~20번까지 DAO 출력

	            // System.out.println("DAO 출력");
	            for (int i = 10; i < 20; i++) {
	               System.out.printf("%s\t%s\n", i + 1, dto_es.get(i).getSubjective_A());
	            }
	            System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	            System.out.println("\t\t\t(11..20 / 25)");

	         } else if (flag == 3) { // 25명 중 21~25번까지 DAO 출력

	            // System.out.println("DAO 출력");
	            for (int i = 20; i < dto_es.size(); i++) {
	               System.out.printf("%s\t%s\n", i + 1, dto_es.get(i).getSubjective_A());
	            }
	            System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	            System.out.println("\t\t\t(21..25 / 25)");

	         }
	      }

	      System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	      System.out.println("\t\t\t――――――――――――――――――――――――――");
	      System.out.println("\t\t\t[  ] 안의 번호를 입력해주세요.");

		if (select == 1) { // 객관식 통계 화면

			System.out.println();
			System.out.println("\t\t\t[1] 좋았던 점");
			System.out.println("\t\t\t[2] 아쉬운 점 & 개선할 점");
			System.out.println("\t\t\t[0] 교사 메뉴로 돌아가기");

		} else if (select == 2) { // 좋았던 점 화면

			System.out.println();

			if (flag == 1) {
				System.out.println("\t\t\t[1] 다음 >>");
				System.out.println("\t\t\t[2] 객관식 통계");
				System.out.println("\t\t\t[3] 아쉬운 점 & 개선할 점");
				System.out.println("\t\t\t[0] 교사 메뉴로 돌아가기");
			} else if (flag == 2) {
				System.out.println("\t\t\t[1] 다음 >>");
				System.out.println("\t\t\t[2] 객관식 통계");
				System.out.println("\t\t\t[3] 아쉬운 점 & 개선할 점");
				System.out.println("\t\t\t[4] << 이전");
				System.out.println("\t\t\t[0] 교사 메뉴로 돌아가기");
			} else if (flag == 3) {
				System.out.println("\t\t\t[2] 객관식 통계");
				System.out.println("\t\t\t[3] 아쉬운 점 & 개선할 점");
				System.out.println("\t\t\t[4] << 이전");
				System.out.println("\t\t\t[0] 교사 메뉴로 돌아가기");
			}

		} else if (select == 3) { // 아쉬운 점 & 개선할 점 화면

			System.out.println();

			if (flag == 1) {
				System.out.println("\t\t\t[1] 다음 >>");
				System.out.println("\t\t\t[2] 객관식 통계");
				System.out.println("\t\t\t[3] 좋았던 점");
				System.out.println("\t\t\t[0] 교사 메뉴로 돌아가기");
			} else if (flag == 2) {
				System.out.println("\t\t\t[1] 다음 >>");
				System.out.println("\t\t\t[2] 객관식 통계");
				System.out.println("\t\t\t[3] 좋았던 점");
				System.out.println("\t\t\t[4] << 이전");
				System.out.println("\t\t\t[0] 교사 메뉴로 돌아가기");
			} else if (flag == 3) {
				System.out.println("\t\t\t[2] 객관식 통계");
				System.out.println("\t\t\t[3] 좋았던 점");
				System.out.println("\t\t\t[4] << 이전");
				System.out.println("\t\t\t[0] 교사 메뉴로 돌아가기");
			}

		}

		System.out.println("\t\t\t――――――――――――――――――――――――――");
		System.out.print("\t\t\t번호 : ");
		int num = Integer.parseInt(scan.nextLine());
		System.out.println("\t\t\t――――――――――――――――――――――――――");
		view.pause();

		if (num == 1) {

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

			evalOutput(select, str);

		} else if (num == 2) {

			if (select == 1) { // 객관식 통계 -> 아쉬운 점 &개선할 점
				str = "아쉬운 점 & 개선할 점";
				select = 3;
				flag = 1;
			} else if (select == 2 || select == 3) { // 좋았던 점, 아쉬운 점 -> 객관식 통계
				str = "객관식 통계";
				select = 1;
			}

			evalOutput(select, str);

		} else if (num == 3) {
			if (select == 2) { // 좋았던 점 <-> 아쉬운 점 & 개선할 점
				str = "아쉬운 점 & 개선할 점";
				select = 3;
				flag = 1;
			} else if (select == 3) {
				str = "좋았던 점";
				select = 2;
				flag = 1;
			}

			evalOutput(select, str);

		} else if (num == 4) {

			if (select == 2) {
				str = "좋았던 점";
			} else if (select == 3) {
				str = "아쉬운 점 & 개선할 점";
			}

			flag--;
			evalOutput(select, str);

		} else if (num == 0) { // 교사 메뉴로 돌아가기

			flag = 0;
			TeacherController.t_menu();
		}

	}

// ----------------------------------------------------------------------
//	[5] 상담일지 조회
//----------------------------------------------------------------------

	/**
	 * 상담일지 메뉴에서 선택 후, 선택받은 세부메뉴에 따라 DAO와 연동하여 테이블 결과를 출력해주는 메소드
	 */
	@Override
	public void teacherConsult() throws InterruptedException {

	      view.title(TeacherView.consult);
	      
	      System.out.println();
	      System.out.println("\t\t\t――――――――――――――――――――――――――");
	      System.out.println();
	      System.out.println("\t\t\t[1] 상담 요청 조회");
	      System.out.println("\t\t\t[2] 상담 내역 확인");
	      System.out.println("\t\t\t[3] 상담 일지 입력");
	      System.out.println("\t\t\t[0] 교사 메뉴로 돌아가기");
	      System.out.println();
	      System.out.println("\t\t\t――――――――――――――――――――――――――");
	      System.out.println();

	      System.out.println("\t\t\t이동하실 메뉴의 번호를 입력해주세요.");
	      System.out.println();
	      System.out.print("\t\t\t선택 : ");
	      String select = scan.nextLine();
	    
	      view.pause();
	      
	      switch (select) {

	      case "1": // 상담 요청 조회
	         flag = 1;
	         break;

	      case "2": // 상담 내역 확인
	         flag = 2;
	         break;

	      case "3": // 상담 일지 입력
	         flag = 3;
	         break;

	      case "0": // 교사 메뉴로 돌아가기
	         flag = 0;
	         TeacherController.t_menu();
	         break;
	      }

	      System.out.println();
	      //System.out.println("\t\t\t――――――――――――――――――――――――――");
	      System.out.println();

	      if (flag == 1) { // 상담 요청 조회

	         ArrayList<DTO_Consult_T> dto_consult1 = new ArrayList<DTO_Consult_T>();

	         dto_consult1 = daoc.teacherConsult1();
	         System.out.println();
			 System.out.println("\t\t\t――――――――――――――――――――――――――");
			 System.out.println("\t\t\t◆\t상담일지 조회\t◆");
			 System.out.println("\t\t\t――――――――――――――――――――――――――");
			 System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	         System.out.println(" 요청번호\t학번\t이름\t전공\t\t요청 날짜\t\t요청 내용");
	         System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	         for (int i = 0; i < dto_consult1.size(); i++) {
	            System.out.printf(" %s\t%s\t%s\t%s\t%s\t%s\n", dto_consult1.get(i).getConsult_seq(),
	                  dto_consult1.get(i).getStudent_seq(), dto_consult1.get(i).getStudentName(),
	                  dto_consult1.get(i).getMajor(), dto_consult1.get(i).getRequestDate(),
	                  dto_consult1.get(i).getRequestContent());
	         }
	         System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	         System.out.println();
	         System.out.println("\t\t\t――――――――――――――――――――――――――");
	         System.out.println("\t\t\t[  ] 안의 번호를 입력해주세요.");
	         System.out.println();
	         System.out.println("\t\t\t[0] 상담 메뉴로 돌아가기");
	         System.out.println("\t\t\t――――――――――――――――――――――――――");
	         System.out.print("\t\t\t선택 : ");
	         select = scan.nextLine(); // 선택 번호 입력
	         view.pause();
	         teacherConsult();

	      } else if (flag == 2) { // 상담 내역 확인

	         ArrayList<DTO_ConsultFinish_T> dto_consult2 = new ArrayList<DTO_ConsultFinish_T>();

	         dto_consult2 = daoc.teacherConsult2();
	         System.out.println("\t\t\t――――――――――――――――――――――――――");
			 System.out.println("\t\t\t◆\t상담내역 확인\t◆");
			 System.out.println("\t\t\t――――――――――――――――――――――――――");
	         System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	         System.out.println(" 학번\t이름\t상담 날짜\t\t상담 내용");
	         System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

	         for (int i = 0; i < dto_consult2.size(); i++) {
	            System.out.printf(" %s\t%s\t%s\t%s\n", dto_consult2.get(i).getStudent_seq(),
	                  dto_consult2.get(i).getStudentName(), dto_consult2.get(i).getRecordDate(),
	                  dto_consult2.get(i).getRecordContent());
	         }

	         System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");;
	         System.out.println();
	         System.out.println("\t\t\t――――――――――――――――――――――――――");
	         System.out.println("\t\t\t[  ] 안의 번호를 입력해주세요.");
	         System.out.println();
	         System.out.println("\t\t\t[0] 상담 메뉴로 돌아가기");
	         System.out.println("\t\t\t――――――――――――――――――――――――――");
	         System.out.print("\t\t\t선택 : ");
	         select = scan.nextLine(); // 선택 번호 입력
	         view.pause();
	         teacherConsult();

	      } else if (flag == 3) { // 상담 일지 작성

	         ArrayList<DTO_Consult_T> dto_consult1 = new ArrayList<DTO_Consult_T>();

	         dto_consult1 = daoc.teacherConsult1();

	         System.out.println("\t\t\t――――――――――――――――――――――――――");
			 System.out.println("\t\t\t◆\t상담일지 입력\t◆");
			 System.out.println("\t\t\t――――――――――――――――――――――――――");
	         
			 System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	         System.out.println(" 요청번호\t\t학번\t이름\t전공\t\t\t요청 날짜\t\t\t요청 내용");
	         System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	         for (int i = 0; i < dto_consult1.size(); i++) {
	            System.out.printf(" %s\t\t%s\t%s\t%s\t\t%s\t\t%s\n", dto_consult1.get(i).getConsult_seq(),
	                  dto_consult1.get(i).getStudent_seq(), dto_consult1.get(i).getStudentName(),
	                  dto_consult1.get(i).getMajor(), dto_consult1.get(i).getRequestDate(),
	                  dto_consult1.get(i).getRequestContent());
	         }
	         System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	         System.out.println("\t\t\t――――――――――――――――――――――――――");
	         System.out.println("\t\t\t상담하실 [ 요청번호 ]를 입력해 주세요.");
	         System.out.println();
	         System.out.print("\t\t\t- 입력 : ");
	         consultNum = scan.nextLine();
	         System.out.println("\t\t\t――――――――――――――――――――――――――");
	         System.out.println("\t\t\t작성하실 내용을 입력해 주세요.");
	         System.out.println();
	         System.out.print("\t\t\t- 상담 내용 : ");
	         consultContent = scan.nextLine();
	         daoc.teacherConsult3();
	         daoc.teacherConsult4();
	         view.pause();
	         teacherConsult();
	      }

	   }
}
