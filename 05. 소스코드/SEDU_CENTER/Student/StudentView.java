package Student;

import java.util.ArrayList;
import java.util.Scanner;

import DTO_Student.DTO_ConsultRecode_S;
import DTO_Student.DTO_EvalOk_Consult_S;
import DTO_Student.DTO_RegiCourseInfo_S;
import DTO_Student.DTO_RegiSubjInfo_S;
import Teacher.TeacherView;

//화면에 찍어주는 클래스
/**
 * 
 * 학생계정 > 화면 출력용 클래스
 * 
 * @author 이다현
 * 
 *
 */
public class StudentView {

	// 변수
	public final static int menu = 0;
	public final static int gradeOutput = 1;
	public final static int attendanceOutput = 2;
	public final static int evaluation = 3;
	public final static int consultInput = 4;
	public final static int consultOutput = 5;
	public final static int scheduleOutput = 6;
	public final static int login = 7;	

	// 메소드
	
	/**
	 * 학생계정 > 메인메뉴 출력
	 * 
	 * @param n 입력받을 메뉴번호
	 */
	public void title(int n) { // 타이틀 출력

		if (n == StudentView.menu) { // 0
			System.out.println();
			System.out.println("\t\t\t――――――――――――――――――――――――――");
			System.out.println("\t\t\t◆\t학생 메뉴\t\t◆");
			System.out.println("\t\t\t――――――――――――――――――――――――――");
		} else if (n == StudentView.gradeOutput) { // 1
			System.out.println();
			System.out.println("\t\t\t――――――――――――――――――――――――――");
			System.out.println("\t\t\t◆\t성적 조회\t\t◆");
			System.out.println("\t\t\t――――――――――――――――――――――――――");
		} else if (n == StudentView.attendanceOutput) { // 2
			System.out.println();
			System.out.println("\t\t\t――――――――――――――――――――――――――");
			System.out.println("\t\t\t◆\t출결 조회\t\t◆");
			System.out.println("\t\t\t――――――――――――――――――――――――――");
		} else if (n == StudentView.evaluation) { // 3
			System.out.println();
			System.out.println("\t\t\t――――――――――――――――――――――――――");
			System.out.println("\t\t\t◆\t교사 평가\t\t◆");
			System.out.println("\t\t\t――――――――――――――――――――――――――");
		} else if (n == StudentView.consultInput) { // 4
			System.out.println();
			System.out.println("\t\t\t――――――――――――――――――――――――――");
			System.out.println("\t\t\t◆\t상담 신청\t\t◆");
			System.out.println("\t\t\t――――――――――――――――――――――――――");
		} else if (n == StudentView.consultOutput) { // 5 
			System.out.println();
			System.out.println("\t\t\t――――――――――――――――――――――――――");
			System.out.println("\t\t\t◆\t상담 일지 조회\t◆");
			System.out.println("\t\t\t――――――――――――――――――――――――――");
		} else if (n == StudentView.scheduleOutput) { // 6
			System.out.println();
			System.out.println("\t\t\t――――――――――――――――――――――――――");
			System.out.println("\t\t\t◆\t과정 및 과목 조회\t◆");
			System.out.println("\t\t\t――――――――――――――――――――――――――");
		} else if (n == StudentView.login) {
			System.out.println();
			System.out.println("\t\t\t――――――――――――――――――――――――――");
			System.out.println("\t\t\t◆\t학생 계정 로그인\t◆");		
			System.out.println("\t\t\t――――――――――――――――――――――――――");
		}
	}

	
	/**
	 * 프로그램 진행 전 지연 메소드
	 * @throws InterruptedException
	 */
	public void pause() throws InterruptedException { // 프로그램 넘어가기 전에 출력

		System.out.println("\t\t\t――――――――――――――――――――――――――");
		System.out.println("\t\t\t계속하려면 엔터를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();

		clearScreen();
		System.out.println("\t\t\t\t\tLOADING.....");
		Thread.sleep(700);
		clearScreen();

	}

	
	/**
	 * 화면 지우는 용도 메소드
	 */
	private void clearScreen() { // 화면지우기

		for (int i = 0; i < 50; i++) {
			System.out.println("");
		}

	}

	
	/**
	 * 학생메뉴 출력
	 */
	public void studentMenu() {

		System.out.println("\t\t\t――――――――――――――――――――――――――");
		System.out.println("\t\t\t[1] 성적 조회");
		System.out.println("\t\t\t[2] 출결 조회");
		System.out.println("\t\t\t[3] 교사 평가");
		System.out.println("\t\t\t[4] 상담 신청");
		System.out.println("\t\t\t[5] 상담 일지 조회");
		System.out.println("\t\t\t[6] 과정 및 과목 조회");
		System.out.println("\t\t\t[7] 출석부 입력");
		System.out.println("\t\t\t[0] 뒤로 가기");
		System.out.println("\t\t\t――――――――――――――――――――――――――");
		System.out.print("\t\t\t선택 : ");

	}

	/**
	 * 출석 메뉴 출력
	 */
	public void attendMenu() {

		System.out.println("\t\t\t――――――――――――――――――――――――――");
		System.out.println("\t\t\t[1] 전체 조회");
		System.out.println("\t\t\t[2] 월별 조회");
		System.out.println("\t\t\t[3] 일별 조회");
		System.out.println("\t\t\t[0] 뒤로 가기");
		System.out.println("\t\t\t――――――――――――――――――――――――――");
		System.out.print("\t\t\t선택 : ");

	}

	
	/**
	 * 
	 * 상담일지 조회시 필요한 출력문
	 * 
	 * @param list 교사평가가능한 학생의 정보
	 * @param consultList 상담 일지 조회에 사용되는 정보
	 */
	public void consultRecordInfo(ArrayList<DTO_EvalOk_Consult_S> list, ArrayList<DTO_ConsultRecode_S> consultList) {

		// 메인 > 학생 > 5 상담 일지 조회

		Scanner scan = new Scanner(System.in);

		title(StudentView.consultOutput);

		for (int i = 0; i < list.size(); i++) {
			System.out.println("\t학생번호 : " + StudentService.loginDTO.getStudent_seq());
			System.out.println("\t학생이름 : " + list.get(i).getSname());
			System.out.println("\t수강중인 과정 : " + list.get(i).getCourseName());
			System.out.println("\t담당 교사 : " + list.get(i).getTname());

			System.out.println();
			int start = 0;
			int end = 3;

			boolean flag = true;

			while (flag) { // 상담일지 조회 최대 3개씩만 보여줌
				if (end < consultList.size()) {
					for (int j = start; j < end; j++) {
						System.out.println("\t상담 날짜 : " + consultList.get(i).getRecordDate());
						System.out.println("\t상담요청 내용 : " + consultList.get(i).getRequestcontent());
						System.out.println("\t---------------------------------------------\n");
						System.out.println("\t종합의견 : " + consultList.get(i).getRecordcontent() + "\n");
						System.out.println("\t=============================================\n");
					}
					System.out.println("\t\t\t\t" + start + "-" + end + "/" + consultList.size());
					start += 3;
					end += 3;

					System.out.println("\t1. 더보기");
					System.out.println("\t2. 돌아가기");
					System.out.println();
					System.out.print("\t번호 입력 : ");
					int num = scan.nextInt();
					scan.nextLine();

					if (num == 2) {
						flag = false;
					}

				} else {
					for (int j = start; j < consultList.size(); j++) {
						System.out.println("\t상담 날짜 : " + consultList.get(i).getRecordDate());
						System.out.println("\t상담요청 내용 : " + consultList.get(i).getRequestcontent());
						System.out.println("\t---------------------------------------------\n");
						System.out.println("\t종합의견 : " + consultList.get(i).getRecordcontent() + "\n");
						System.out.println("\t=============================================\n");

					}
					System.out.println("\t\t\t\t" + start + "-" + consultList.size() + "/" + consultList.size());
					flag = false;
				}
			}

		}

	}

	
	/**
	 * 과정 및 과목 조회 출력
	 * 
	 * @param list 수강중인 과정에 대한 정보
	 * @param subjectList  수강중인 과정에 들어있는 과목정보
	 */
	public void regiCourSearch(ArrayList<DTO_RegiCourseInfo_S> list, ArrayList<DTO_RegiSubjInfo_S> subjectList) {

		// 메인 > 학생 > 6 과정 및 과목 조회 출력
		title(StudentView.scheduleOutput);
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("\t- 수강중인 과정 : " + list.get(i).getCourseName());
			System.out.println("\t- 담당 교사 : " + list.get(i).getTname());
			System.out.println("\t강의실 : " + list.get(i).getRoomName());
			System.out.println();
			System.out.println("\n\t◑ 과목정보\n");

			System.out.println("\t과목번호\t과목명\t\t\t\t\t과목시작일\t\t과목종료일\n");
			for (int j = 0; j < subjectList.size(); j++) {
				System.out.printf("\t%s\t%-35s\t\t%s\t%s\n", subjectList.get(j).getSubject_seq(),
						subjectList.get(j).getSubjName(), subjectList.get(j).getStartdate(),
						subjectList.get(j).getEnddate());
			}

		}
		try {
			pause();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 로그인 화면 출력
	 */
	public void login_T() { // 로그인 화면
		
		System.out.println("\n\n");
		System.out.println("\t\t┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┐");
		System.out.println();
		System.out.println(""
				+ "\t      _____ __________  __  _______________   __________________ \r\n" + 
				"\t     / ___// ____/ __ \\/ / / / ____/ ____/ | / /_  __/ ____/ __ \\\r\n" + 
				"\t     \\__ \\/ __/ / / / / / / / /   / __/ /  |/ / / / / __/ / /_/ /\r\n" + 
				"\t    ___/ / /___/ /_/ / /_/ / /___/ /___/ /|  / / / / /___/ _, _/ \r\n" + 
				"\t   /____/_____/_____/\\____/\\____/_____/_/ |_/ /_/ /_____/_/ |_| "); // 2칸 띄어쓰기
		System.out.println();
		System.out.println("\t\t\t\t\tSince 2019.04.17. | 디비 2조");
		System.out.println("\t\t┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┚");
		
			
		title(StudentView.login);

	}

}
