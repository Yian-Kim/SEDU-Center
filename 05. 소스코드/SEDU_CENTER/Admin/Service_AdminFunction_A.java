package Admin;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.DAO_A_AdminFunction;
import DTO_admin.DTO_c_oc_r_tc_t_A;
import DTO_admin.DTO_oc_c_r_A;
import DTO_admin.DTO_oc_osm_s_A;
import DTO_admin.DTO_oc_rc_stu_result_A;
import DTO_admin.DTO_record_request_rc_stu_oc_tc_t_A;
import DTO_admin.DTO_request_rc_oc_c_stu_A;
import DTO_admin.DTO_request_rc_oc_c_tc_t_stu_A;
import DTO_admin.DTO_stu_rc_request_oc_A;
import DTO_admin.DTO_t_tc_oc_c_A;
import DTO_admin.DTO_teq_t_A;
import dto_common.DTO_Course;
import dto_common.DTO_Example;
import dto_common.DTO_OpenCourse;
import dto_common.DTO_Room;
import dto_common.DTO_Subject;
import dto_common.DTO_TeacherEval_A;
import dto_common.DTO_TeacherEval_Q;

public class Service_AdminFunction_A implements IService_AdminFunction_A {

	private View_AdminFunction_A viewAdminFunction;
	
	public Service_AdminFunction_A() {
		
		viewAdminFunction = new View_AdminFunction_A();
		
	}
	
	@Override
	public void sOpenMgmtInfo() {
		// 1. 관리자 - 2. 개설 과정 및 과목 관리
		
		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		
		ArrayList<DTO_oc_c_r_A> list = new ArrayList<DTO_oc_c_r_A>();
		
		list = dao_adminFunction.daoOpenMgmtInfo();
		
		viewAdminFunction.vOpenMgmt();
		viewAdminFunction.vOpenMgmtInfo(list);
		
		dao_adminFunction.close();
		
	}

	@Override
	public int sOpenMgmtInfoDetails(int num) {
		
		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction(); 
		ArrayList<DTO_OpenCourse> list = new ArrayList<DTO_OpenCourse>();
		
		list = dao_adminFunction.daoOpenMgmtInfoNum();
		
		dao_adminFunction.close();
		
		return Integer.parseInt(list.get(num-1).getCourse_seq());
		
	}

	@Override
	public void sOCSmgmtdetails(int num) {
		//1. 관리자 - 2. 개설 과정 및 과목 관리 - 1. (상세보기)에서 출력할 내용들 저장하여 view에 넘겨줌
		
		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		
		String courseName = dao_adminFunction.daoOpenMgmtCourseName(num);
		String teacherName = dao_adminFunction.daoOpenMgmtTeacherName(num);
		String className = dao_adminFunction.daoOpenMgmtClassName(num);
		String courseDuration = dao_adminFunction.daoOpenMgmtcourseDuration(num);
		
		ArrayList<DTO_oc_osm_s_A> subjectList = new ArrayList<DTO_oc_osm_s_A>();
		subjectList = dao_adminFunction.daoOpenMgmtSubjectInfo(num);
		
		ArrayList<DTO_oc_rc_stu_result_A> studentList = new ArrayList<DTO_oc_rc_stu_result_A>();
		studentList = dao_adminFunction.daoOpenMgmtstudentInfo(num);
		
		viewAdminFunction.vOpenMgmtInfoDetails(courseName, teacherName, className, courseDuration, subjectList, studentList);
		
		dao_adminFunction.close();
		subjectList.clear();
		studentList.clear();
		
	}

	@Override
	public void sOpenMgmtSubjectRegistration(int selectNum) { 

		// 개설과목 정보 등록 할 때 내용 출력
		Scanner scan = new Scanner(System.in);
		
		ArrayList<DTO_Subject> list = new ArrayList<DTO_Subject>();
		
		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		list = dao_adminFunction.daoOpenMgmtSubjectRegistration();
		
		viewAdminFunction.vOpenMgmtSubjectRegistration(list);
		
		System.out.print("추가할 과목 번호 : ");
		int num = scan.nextInt();
		scan.nextLine();
		
		System.out.println("개설과목기간");
		System.out.print("시작일(ex 2019-05-06) : ");
		String startDate = scan.nextLine();
		System.out.print("종료일(ex 2019-05-06) : ");
		String endDate = scan.nextLine();
		
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("이대로 등록하시겠습니까?(y/n)");
		String choice = scan.nextLine();
		
		if(choice.equalsIgnoreCase("y")) {
			int result = dao_adminFunction.daoOpenSubjectAdd(num, startDate, endDate, selectNum);
			
			if(result == 1) 
				System.out.println("등록이 완료되었습니다.");
			else
				System.out.println("등록이 실패하였습니다.");
			
			pause();
		}else if(choice.equalsIgnoreCase("n")){
			System.out.println("등록이 취소되었습니다.");
			pause();
		}
		
		dao_adminFunction.close();
		list.clear();
	}

	@Override
	public void sOpenMgmtAdd() {

		ArrayList<DTO_Course> list = new ArrayList<DTO_Course>();
		
		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		
		list = dao_adminFunction.daoSubject();
		
		viewAdminFunction.vCourse(list);
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("번호 : ");
		int num = scan.nextInt();
		scan.nextLine();
		
		System.out.println();
		System.out.println("개설과정기간");
		System.out.print("- 시작일(ex 2019-03-05) : ");
		String startDate = scan.nextLine();
		System.out.print("- 종료일(ex 2019-03-05) : ");
		String endDate = scan.nextLine();
		
		ArrayList<DTO_Room> roomList = new ArrayList<DTO_Room>();
		
		roomList = dao_adminFunction.daoAvailClassName(startDate, endDate);
		
		viewAdminFunction.vAvailClassName(roomList);
		
		System.out.print("강의실 번호 : ");
		int classNum = scan.nextInt();
		scan.nextLine();
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("이대로 등록하시겠습니까?(y/n)");
		String choice = scan.nextLine();
		
		if(choice.equalsIgnoreCase("y")) {
			
			int result = dao_adminFunction.daoOpenCourseAdd(startDate, endDate, num, classNum);
			
			if(result == 1) 
				System.out.println("등록이 완료되었습니다.");
			else
				System.out.println("등록이 실패하였습니다.");
			
			pause();
			
		}else if(choice.equalsIgnoreCase("n")){
			System.out.println("등록이 취소되었습니다.");
			pause();
		}
		
		
		dao_adminFunction.close();
		roomList.clear();
		list.clear();
	}

	@Override
	public void sTeacherEvalQuestionRegister() {
		
		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("질문 : ");
		String question = scan.nextLine();
		System.out.print("유형번호 : ");
		int typeNum = scan.nextInt();
		scan.nextLine();
		
		System.out.println("이대로 등록하시겠습니까?(y/n)");
		String select = scan.nextLine();
		if(select.equalsIgnoreCase("y")) {
			
			int result = dao_adminFunction.daoTeacherEvalQuestionRegister(question, typeNum);
			
			if(result == 1) {
				System.out.println("등록 완료되었습니다..");
			}else if(result == 0) {
				System.out.println("등록 실패하였습니다.");
			}
			
		}else if(select.equalsIgnoreCase("n")){
			System.out.println("등록이 취소되었습니다.");
		}
		
		pause();
		
		dao_adminFunction.close();
		
	}

	@Override
	public void sTeacherEvalQuestionModifyDelete() {
		
		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		
		ArrayList<DTO_teq_t_A> list = new ArrayList<DTO_teq_t_A>();
		
		list = dao_adminFunction.daoTeacherEvalQuestionModifyDelete();
		
		viewAdminFunction.vTeacherEvalQuestionModifyDelete(list);
		
		dao_adminFunction.close();
		
	}

	@Override
	public void sTeacherEvalQuestionModifyDeleteNumber(int choiceNum) {
		
		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		
		DTO_teq_t_A teq_t = dao_adminFunction.daossTeacherEvalQuestionModifyDeleteNumber(choiceNum);
		
		viewAdminFunction.vTeacherEvalQuestionModifyDelete(teq_t);
		
		dao_adminFunction.close();
		
	}

	@Override
	public void sTeacherEvalQuestionModify(int choiceNum) {
		
		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		
		DTO_teq_t_A teq_t = dao_adminFunction.daossTeacherEvalQuestionModifyDeleteNumber(choiceNum);
		
		viewAdminFunction.vTeacherEvalQuestionModify(teq_t);
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("질문 : ");
		String question = scan.nextLine();
		System.out.print("유형번호(1.주관식/2.객관식) : ");
		int typeNum = scan.nextInt();
		scan.nextLine();
		
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("정말로 수정하시겠습니까?(y/n)");
		String check = scan.nextLine();
		
		if(check.equalsIgnoreCase("y")) {
			int result = dao_adminFunction.daoTeacherEvalQuestionModify(question, typeNum, choiceNum);
			
			if(result == 1) {
				System.out.println("수정이 완료되었습니다.");
			}else if(result == 0){
				System.out.println("수정 실패하였습니다.");
			}
		}else if(check.equalsIgnoreCase("n")) {
			System.out.println("수정이 취소 되었습니다.");
		}
		
		dao_adminFunction.close();
		
	}

	@Override
	public void sTeacherEvalQuestionDelete(int choiceNum) {

		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		
		DTO_teq_t_A teq_t = dao_adminFunction.daossTeacherEvalQuestionModifyDeleteNumber(choiceNum);
		
		viewAdminFunction.vTeacherEvalQuestionDelete(teq_t);
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("정말로 삭제하시겠습니까?(y/n)");
		String check = scan.nextLine();
		
		if(check.equalsIgnoreCase("y")) {
			int result = dao_adminFunction.daoTeacherEvalQuestionDelete(choiceNum);
			
			if(result == 1) {
				System.out.println("삭제 완료되었습니다.");
			}else if(result == 0){
				System.out.println("삭제 실패하였습니다.");
			}
			System.out.println(result);
		}else if(check.equalsIgnoreCase("n")) {
			System.out.println("삭제 취소 되었습니다.");
		}
		
		dao_adminFunction.close();
		
	}

	@Override
	public void sTeacherEvalQuestionResultInfoDelete() {

		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		
		int cnt = dao_adminFunction.daoOpenCourseNum();
		
		ArrayList<DTO_t_tc_oc_c_A> list = new ArrayList<DTO_t_tc_oc_c_A>();
		
		list = dao_adminFunction.daoTeacherEvalQuestionResultInfoDelete(cnt);
		
		viewAdminFunction.vTeacherEvalQuestionResultInfoDelete(list);
		
		dao_adminFunction.close();
		list.clear();
		
	}

	@Override
	public void sTeacherEvalQuestionResultInfoDeleteInfo(String select) {

		//1. 관리자 – 6. 교사 평가 관리 및 결과 조회 - c. 교사 평가 결과 조회 및 삭제 – 1.(상세보기)
		
		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		
		String courseName = dao_adminFunction.daoCourseName(select); // 해당 과정명
		String teacherName = dao_adminFunction.daoTeacherName(select); // 해당 과정 교사명
		
		ArrayList <DTO_Example> objectiveFormlist = new ArrayList<DTO_Example>();
		objectiveFormlist = dao_adminFunction.daoobjectiveFormEx(); // 평가질문, 객관식 보기
		
		ArrayList <DTO_TeacherEval_Q> objectiveFormResultlist = new ArrayList<DTO_TeacherEval_Q>();
		objectiveFormResultlist = dao_adminFunction.daoObjectiveList(select); // 객관식 질문, 답변비율
		
		ArrayList <DTO_TeacherEval_Q> subjectiveEx = new ArrayList<DTO_TeacherEval_Q>();
		subjectiveEx = dao_adminFunction.daoSubjectiveEx(); // 주관식 질문
		
		viewAdminFunction.vTeacherEvalQuestionResultInfoDeleteInfo(courseName, teacherName, objectiveFormlist, objectiveFormResultlist, subjectiveEx);
		
		objectiveFormlist.clear();
		objectiveFormResultlist.clear();
		subjectiveEx.clear();
		dao_adminFunction.close();
		
	}

	@Override
	public void sConsultRequestInfoModify() {
		
		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		
		ArrayList<DTO_request_rc_oc_c_tc_t_stu_A> list = new ArrayList<DTO_request_rc_oc_c_tc_t_stu_A>();
		
		list = dao_adminFunction.daoConsultRequestInfoModify();
		viewAdminFunction.vConsultRequestInfoModify(list);
		
		dao_adminFunction.close();
		list.clear();
		
	}

	@Override
	public void sConsultRequestModify() {
		
		Scanner scan = new Scanner(System.in);
		
		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		
		System.out.print("요청번호 : ");
		int num = scan.nextInt();
		scan.nextLine();
		System.out.print("요청날짜(ex 2019-04-03) : ");
		String date = scan.nextLine();
		System.out.print("요청내용 : ");
		String content = scan.nextLine();
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("정말로 수정하시겠습니까?(y/n)");
		String select = scan.nextLine();
		
		if(select.equalsIgnoreCase("y")) {
			int result = dao_adminFunction.daoConsultRequestModify(num, date, content);
			
			if(result == 1) {
				System.out.println("수정 완료!");
			}else if(result == 0) {
				System.out.println("수정 실패!");
			}
		}else if (select.equalsIgnoreCase("n")) {
			System.out.println("수정 취소");
		}
		
		dao_adminFunction.close();
		
	}

	@Override
	public void sConsultRequestDelete() {

		Scanner scan = new Scanner(System.in);
		
		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		
		System.out.print("요청번호 : ");
		int num = scan.nextInt();
		scan.nextLine();
		
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("정말로 삭제하시겠습니까?(y/n)");
		String select = scan.nextLine();
		
		if(select.equalsIgnoreCase("y")) {
			int result = dao_adminFunction.daoConsultRequestDelete(num);
			
			if(result == 1) {
				System.out.println("삭제 완료!");
			}else if(result == 0) {
				System.out.println("삭제 실패!");
			}
		}else if (select.equalsIgnoreCase("n")) {
			System.out.println("삭제 취소");
		}
		
		dao_adminFunction.close();
	}

	@Override
	public void sConsultRequestCourse() {
		
		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		
		ArrayList<DTO_c_oc_r_tc_t_A> list = new ArrayList<DTO_c_oc_r_tc_t_A>();
		
		list = dao_adminFunction.daoConsultRequestCourse();
		
		viewAdminFunction.vConsultRequestCourse(list);
		
		
		dao_adminFunction.close();
		list.clear();
	}

	@Override
	public void sConsultRequestCourseSelect(String select) {

		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		
		String teacherName = dao_adminFunction.daoConsultRequestCourseTeacherName(select);
		String courseName = dao_adminFunction.daoConsultRequestCourseCourseName(select);
		
		ArrayList<DTO_stu_rc_request_oc_A> list = new ArrayList<DTO_stu_rc_request_oc_A>();
		list = dao_adminFunction.daoConsultRequestCourseSelect(select);
		
		viewAdminFunction.vConsultRequestCourseSelect(teacherName, courseName, list);
		
		dao_adminFunction.close();
		list.clear();
		
	}

	@Override
	public void sConsultRequestCourseModify() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("■ 수정하기");
		System.out.print("요청번호 : ");
		String num = scan.nextLine();
		System.out.print("요청날짜(ex 2019-04-01) : ");
		String date = scan.nextLine();
		System.out.print("요청내용 : ");
		String content = scan.nextLine();
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("정말로 수정하시겠습니까?(y/n)");
		String choice = scan.nextLine();
		
		if(choice.equalsIgnoreCase("y")) {
			
			DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
			
			int result = dao_adminFunction.daoConsultRequestCourseModify(num, date, content);
			
			
			
			if(result == 1) {
				System.out.println("수정 완료!");
			}else if(result == 0) {
				System.out.println("수정 실패!");
			}
			
			dao_adminFunction.close();
			
		}else if(choice.equalsIgnoreCase("n")) {
			System.out.println("수정 취소!");
		}
		
		
		
	}

	@Override
	public void sConsultRequestCourseDelete() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("■ 삭제하기");
		System.out.print("요청번호 : ");
		String num = scan.nextLine();
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("정말로 삭제하시겠습니까?(y/n)");
		String choice = scan.nextLine();
		
		if(choice.equalsIgnoreCase("y")) {
			
			DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
			
			int result = dao_adminFunction.daoConsultRequestCourseDelete(num);
			
			
			
			if(result == 1) {
				System.out.println("삭제 완료!");
			}else if(result == 0) {
				System.out.println("삭제 실패!");
			}
			
			dao_adminFunction.close();
			
		}else if(choice.equalsIgnoreCase("n")) {
			System.out.println("삭제 취소!");
		}
		
		
		
	}

	@Override
	public void sConsultRequestStudentName(String name) {
		
		ArrayList<DTO_request_rc_oc_c_stu_A> list = new ArrayList<DTO_request_rc_oc_c_stu_A>();
		
		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		
		list = dao_adminFunction.daoConsultRequestStudentName(name);
		
		viewAdminFunction.vConsultRequestStudentNameAfter(list);
		// 1. 관리자 – 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 – c. 학생별 조회 및 수정 – 검색 – 조회 및 수정 뒷부분 출력
		// 학생이름
		
		dao_adminFunction.close();
		list.clear();
		
	}

	@Override
	public void sConsultRequestStudentPw(String pw) {
		
		ArrayList<DTO_request_rc_oc_c_stu_A> list = new ArrayList<DTO_request_rc_oc_c_stu_A>();
		
		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		
		list = dao_adminFunction.daoConsultRequestStudentPw(pw);
		
		viewAdminFunction.vConsultRequestStudentPwAfter(list);
		// 1. 관리자 – 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 – c. 학생별 조회 및 수정 – 검색 – 조회 및 수정 뒷부분 출력
		// 주민번호뒷자리
		
		dao_adminFunction.close();
		list.clear();
		
	}

	@Override
	public void sConsultRequestStudentTel(String tel) {
		// 1. 관리자 – 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 – c. 학생별 조회 및 수정 – 검색 – 조회 및 수정 뒷부분 출력
		// 전화번호
		
		ArrayList<DTO_request_rc_oc_c_stu_A> list = new ArrayList<DTO_request_rc_oc_c_stu_A>();
		
		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		
		list = dao_adminFunction.daoConsultRequestStudentTel(tel);
		
		viewAdminFunction.vConsultRequestStudentTelAfter(list);
		
		dao_adminFunction.close();
		list.clear();
		
	}

	@Override
	public void sConsultRequestStudentRegdate(String regdate) {
		// 1. 관리자 – 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 – c. 학생별 조회 및 수정 – 검색 – 조회 및 수정 뒷부분 출력
		// 등록일
		
		ArrayList<DTO_request_rc_oc_c_stu_A> list = new ArrayList<DTO_request_rc_oc_c_stu_A>();
		
		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		
		list = dao_adminFunction.daoConsultRequestStudentRegdate(regdate);
		
		viewAdminFunction.vConsultRequestStudentRegdateAfter(list);
		
		dao_adminFunction.close();
		list.clear();
		
	}

	@Override
	public void sConsultRequestStudentMajor(String major) {
		
		// 1. 관리자 – 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 – c. 학생별 조회 및 수정 – 검색 – 조회 및 수정 뒷부분 출력
		// 학과
		
		ArrayList<DTO_request_rc_oc_c_stu_A> list = new ArrayList<DTO_request_rc_oc_c_stu_A>();
		
		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		
		list = dao_adminFunction.daoConsultRequestStudentMajor(major);
		
		viewAdminFunction.vConsultRequestStudentMajorAfter(list);
		
		dao_adminFunction.close();
		list.clear();
		
	}

	@Override
	public void sConsultResultInfo() {
		
		ArrayList<DTO_record_request_rc_stu_oc_tc_t_A> list = new ArrayList<DTO_record_request_rc_stu_oc_tc_t_A>();
		
		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		
		list = dao_adminFunction.daoConsultResultInfo();
		
		viewAdminFunction.vConsultResultInfo(list);
		
		dao_adminFunction.close();
		list.clear();
	}

	@Override
	public void sConsultResultModify() {
		// 상담일지 수정 고치기
		Scanner scan = new Scanner(System.in);
		
		System.out.println("■ 수정하기");
		System.out.print("상담번호 : ");
		String num = scan.nextLine();
		System.out.print("상담날짜(ex 2019-04-01) : ");
		String date = scan.nextLine();
		System.out.print("상담내용 : ");
		String content = scan.nextLine();
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("정말로 수정하시겠습니까?(y/n)");
		String choice = scan.nextLine();
		
		if(choice.equalsIgnoreCase("y")) {
			
			DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
			
			int result = dao_adminFunction.daoConsultResultModify(num, date, content);
			
			
			
			if(result == 1) {
				System.out.println("수정 완료!");
			}else if(result == 0) {
				System.out.println("수정 실패!");
			}
			
			dao_adminFunction.close();
			
		}else if(choice.equalsIgnoreCase("n")) {
			System.out.println("수정 취소!");
		}
		
		
		
	}

	@Override
	public void sConsultResultDelete() {

		// 상담 일지 삭제 고치기
		
		Scanner scan = new Scanner(System.in);
		
		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		
		System.out.println("■ 삭제하기");
		System.out.print("상담번호 : ");
		int num = scan.nextInt();
		scan.nextLine();
		
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("정말로 삭제하시겠습니까?(y/n)");
		String select = scan.nextLine();
		
		if(select.equalsIgnoreCase("y")) {
			int result = dao_adminFunction.daoConsultResultDelete(num);
			
			if(result == 1) {
				System.out.println("삭제 완료!");
			}else if(result == 0) {
				System.out.println("삭제 실패!");
			}
		}else if (select.equalsIgnoreCase("n")) {
			System.out.println("삭제 취소");
		}
		
		dao_adminFunction.close();
		
		
		
	}

	@Override
	public void sConsultResultInfoCourse() {
		
		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		
		ArrayList<DTO_c_oc_r_tc_t_A> list = new ArrayList<DTO_c_oc_r_tc_t_A>();
		
		list = dao_adminFunction.daoConsultResultInfoCourse();
		
		viewAdminFunction.vConsultResultInfoCourse(list);
		
		
		
		dao_adminFunction.close();
		list.clear();
		
	}

	@Override
	public void sConsultResultInfoCourseViewModify(String choice) {

		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		
		ArrayList<DTO_record_request_rc_stu_oc_tc_t_A> list = new ArrayList<DTO_record_request_rc_stu_oc_tc_t_A>();
		
		list = dao_adminFunction.daoConsultResultInfoCourseViewModify(choice);
		
		viewAdminFunction.vConsultResultInfoCourseViewModify(list);
		
		dao_adminFunction.close();
		list.clear();
		
	}

	@Override
	public void cConsultRecordStudentName() {
		
		Scanner scan = new Scanner(System.in);

		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		
		ArrayList<DTO_record_request_rc_stu_oc_tc_t_A> list = new ArrayList<DTO_record_request_rc_stu_oc_tc_t_A>();
		
		viewAdminFunction.vConsultRecordStudent();
		
		System.out.print("학생명 : ");
		String name = scan.nextLine();
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		
		list = dao_adminFunction.daoConsultRecordStudentName(name);
		
		viewAdminFunction.vConsultRecordStudentName(list);
		
		
		dao_adminFunction.close();
		list.clear();
	}

	@Override
	public void cConsultRecordStudentPw() {
		Scanner scan = new Scanner(System.in);

		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		
		ArrayList<DTO_record_request_rc_stu_oc_tc_t_A> list = new ArrayList<DTO_record_request_rc_stu_oc_tc_t_A>();
		
		viewAdminFunction.vConsultRecordStudent();
		
		System.out.print("주민번호 뒷자리 : ");
		String pw = scan.nextLine();
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		
		list = dao_adminFunction.daoConsultRecordStudentPw(pw);
		
		viewAdminFunction.vConsultRecordStudentName(list);
		
		
		dao_adminFunction.close();
		list.clear();
	}

	@Override
	public void cConsultRecordStudentMajor() {
		Scanner scan = new Scanner(System.in);

		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		
		ArrayList<DTO_record_request_rc_stu_oc_tc_t_A> list = new ArrayList<DTO_record_request_rc_stu_oc_tc_t_A>();
		
		viewAdminFunction.vConsultRecordStudent();
		
		System.out.print("학과 : ");
		String major = scan.nextLine();
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		
		list = dao_adminFunction.daoConsultRecordStudentMajor(major);
		
		viewAdminFunction.vConsultRecordStudentName(list);
		
		
		dao_adminFunction.close();
		list.clear();
	}

	@Override
	public void sGood(String choice,String select) {
		
		//주관식 상세보기
		
		DAO_A_AdminFunction dao_adminFunction = new DAO_A_AdminFunction();
		
		ArrayList<DTO_TeacherEval_A> list = new ArrayList<DTO_TeacherEval_A>();
		list = dao_adminFunction.daoGood(choice,select);
		
		String descriptive = dao_adminFunction.daodescriptive(choice);
		
		viewAdminFunction.vGood(descriptive, list);
		
		dao_adminFunction.close();
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
