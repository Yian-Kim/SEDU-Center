package Admin;

import java.util.ArrayList;
import java.util.Scanner;

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
import dto_common.DTO_Room;
import dto_common.DTO_Subject;
import dto_common.DTO_TeacherEval_A;
import dto_common.DTO_TeacherEval_Q;

/**
 * 관리자 - 개설 과정 및 과목 관리 - 교사 평가 관리 및 결과 조회 - 상담일지 관리 및 조회 에 관한 출력문들을 수행하는 클래스
 * 
 * @author bey15
 *
 */
public class View_AdminFunction_A {

	/**
	 * 관리자 > 개설 과정 및 과목 관리 출력 메소드
	 */
	public void vOpenMgmt() {

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 - 2. 개설 과정 및 과목 관리");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 번호\t개설과정명\t\t과정기간\t\t강의실명\t\t개설과목등록여부\t학생 등록 인원");
	}

	/**
	 * 개설 과정에 대한 정보를 출력하는 메소드
	 * 
	 * @param list 개설 과정에 대한 정보
	 */
	public void vOpenMgmtInfo(ArrayList<DTO_oc_c_r_A> list) {

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getRownum() + ".\t");
			System.out.print(list.get(i).getCourseName() + " \t");
			System.out.print(list.get(i).getCourseduration() + "\t");
			System.out.print(list.get(i).getClassName() + "\t");
			System.out.print(list.get(i).getSubjectRegistration() + "(과목수)\t");
			System.out.println(list.get(i).getStudentNum() + "명");
			System.out.println();
		}

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("a. 개설과정 정보 등록");
		System.out.println();
		System.out.println("z. 뒤로가기");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("- 상세보기를 원하시면 해당번호 또는 알파벳을 선택해주세요.");
		System.out.println();

	}

	/**
	 * 관리자 > 개설 과정 및 과목 관리 > 상세보기에서 내용을 출력하는 메소드
	 * 
	 * @param courseName     과정명
	 * @param teacherName    교사명
	 * @param className      강의실
	 * @param courseDuration 과정기간
	 * @param subjectList    과정에 대한 과목들
	 * @param studentList    과정에 대한 학생들 정보
	 */
	public void vOpenMgmtInfoDetails(String courseName, String teacherName, String className, String courseDuration,
			ArrayList<DTO_oc_osm_s_A> subjectList, ArrayList<DTO_oc_rc_stu_result_A> studentList) {

		// 1. 관리자 - 2. 개설 과정 및 과목 관리 - 1. (상세보기) 출력
		// 과정명, 교사명, 강의실명, 과정기간, 과목명 및 기간, 학생 정보 데이터를 받아옴

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 - 2. 개설 과정 및 과목 관리 - 1. (상세보기)");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

		System.out.println(" ■ 과정명 : " + courseName);
		System.out.println(" ■ 교사명 : " + teacherName);
		System.out.println(" ■ 강의실명 : " + className);
		System.out.println();
		System.out.println(" ■ 과정기간");
		System.out.println(" " + courseDuration);
		System.out.println();
		System.out.println(" ■ 과목명 및 기간");

		for (int i = 0; i < subjectList.size(); i++) {
			System.out.println(" " + (i + 1) + ". " + subjectList.get(i).getSubjectName() + " "
					+ subjectList.get(i).getSubjectDuration());
		}

		System.out.println();
		System.out.println(" ■ 학생 정보");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 이름\t주민번호 뒷자리\t전화번호\t\t등록일\t\t수료여부");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

		for (int i = 0; i < studentList.size(); i++) {

			System.out.println(" " + studentList.get(i).getStudentName() + "\t" + studentList.get(i).getStudentPw()
					+ "\t\t" + studentList.get(i).getStudentTel() + "\t\t" + studentList.get(i).getStudentRegidate()
					+ "\t\t" + studentList.get(i).getCompletion());

		}

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println();

		System.out.println("a. 개설과목 정보 등록");
		System.out.println("z. 이전으로 돌아가기");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

	}

	/**
	 * 관리자 > 개설 과정 및 과목 관리 > 상세보기 > 개설과목 정보 등록
	 * 
	 * @param list 과목정보가 담긴 리스트
	 */
	public void vOpenMgmtSubjectRegistration(ArrayList<DTO_Subject> list) {

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 - 2. 개설 과정 및 과목 관리 - 1. (상세보기) - a. 개설과목 정보 등록");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

		System.out.println(" 과목번호\t과목명\t\t\t\t\t과목기간");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(" " + list.get(i).getSubject_seq() + ".\t" + list.get(i).getName() + "\t\t\t"
					+ list.get(i).getPeriod());
		}

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

	}

	/**
	 * 관리자 > 개설 과정 및 과목관리 > 개설과정 정보 등록에 대한 출력문 메소드
	 * 
	 * @param list
	 */
	public void vCourse(ArrayList<DTO_Course> list) {

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 - 2. 개설 과정 및 과목 관리 - a. 개설과정 정보 등록");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 번호\t과정명\t\t\t\t\t\t과정기간");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(" " + list.get(i).getCourse_seq() + ".\t" + list.get(i).getName() + "\t\t\t"
					+ list.get(i).getPeriod());
		}

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

	}

	/**
	 * 관리자 > 개설 과정 및 과목관리 > 개설과정 정보 등록에서 등록가능한 교실명 출력 메소드
	 * 
	 * @param roomList
	 */
	public void vAvailClassName(ArrayList<DTO_Room> roomList) {

		System.out.println();
		System.out.println("- 등록 가능한 강의실 명");
		System.out.println();
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("번호\t강의실명");
		for (int i = 0; i < roomList.size(); i++) {
			System.out.println(roomList.get(i).getRoom_seq() + ".\t" + roomList.get(i).getRoomName());
		}
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println();

	}

	/**
	 * 관리자 > 교사 평가 관리 및 결과 조회
	 */
	public void vTeacherEval() {

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 - 6. 교사 평가 관리 및 결과 조회");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println();
		System.out.println(" a. 질문지 등록");
		System.out.println(" b. 질문지 수정 및 삭제");
		System.out.println(" c. 교사 평가 결과 조회 및 삭제");
		System.out.println();
		System.out.println("z. 뒤로가기");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	}

	/**
	 * 관리자 > 교사 평가 관리 및 결과 조회 > 질문지 등록
	 */
	public void vTeacherEvalQuestionRegister() {

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 - 6. 교사 평가 관리 및 결과 조회 - a. 질문지 등록");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println();
		System.out.println(" 질문\t\t\t\t\t유형");
		System.out.println();
		System.out.println(" EX)좋았던 점\t\t\t\t1.주관식/2.객관식");
		System.out.println();
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

	}

	/**
	 * 관리자 > 교사 평가 관리 및 결과 조회 > 질문지 수정 및 삭제 등록된 질문지 출력
	 * 
	 * @param list 등록된 질문지가 저장된 리스트
	 */
	public void vTeacherEvalQuestionModifyDelete(ArrayList<DTO_teq_t_A> list) {

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 - 6. 교사 평가 관리 및 결과 조회 - b. 질문지 수정 및 삭제");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

		System.out.println(" 질문\t\t\t\t\t\t유형");
		System.out.println();
		for (int i = 0; i < list.size(); i++) {

			System.out.println(" " + list.get(i).getEvalq_seq() + ".\t" + list.get(i).getQuestionnaire()
					+ list.get(i).getQuestionType());

		}

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("■ 질문지 수정 및 삭제를 원하시면 해당 번호를 선택해 주세요.");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("z. 뒤로가기");

	}

	/**
	 * 관리자 > 교사 평가 관리 및 결과 조회 > 질문지 수정 및 삭제 > 번호선택
	 * 
	 * @param teq_t
	 */
	public void vTeacherEvalQuestionModifyDelete(DTO_teq_t_A teq_t) {

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 - 6. 교사 평가 관리 및 결과 조회 - b. 질문지 수정 및 삭제 - 번호 선택");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

		System.out.println(" 질문\t\t\t\t\t\t\t유형");
		System.out.println();
		System.out.println(" " + teq_t.getQuestionnaire() + teq_t.getQuestionType());
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 수정하기");
		System.out.println(" 2. 삭제하기");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(" z. 뒤로가기");

	}

	/**
	 * 관리자 > 교사 평가 관리 및 결과 조회 > 질문지 수정 및 삭제 > 번호 선택 > 수정하기
	 * 
	 * @param teq_t 질문지
	 */
	public void vTeacherEvalQuestionModify(DTO_teq_t_A teq_t) {

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("  1. 관리자 - 6. 교사 평가 관리 및 결과 조회 - b. 질문지 수정 및 삭제 - 1. 수정하기");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

		System.out.println(" 질문\t\t\t\t\t\t\t유형");
		System.out.println();
		System.out.println(" " + teq_t.getQuestionnaire() + teq_t.getQuestionType());
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

	}

	/**
	 * 관리자 > 교사 평가 관리 및 결과 조회 > 질문지 수정 및 삭제 > 번호선택 > 삭제하기
	 * 
	 * @param teq_t
	 */
	public void vTeacherEvalQuestionDelete(DTO_teq_t_A teq_t) {

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 - 6. 교사 평가 관리 및 결과 조회 - b. 질문지 수정 및 삭제 - 2. 삭제하기");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

		System.out.println(" 질문\t\t\t\t\t\t\t유형");
		System.out.println();
		System.out.println(" " + teq_t.getQuestionnaire() + teq_t.getQuestionType());
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

	}

	/**
	 * 관리자 > 교사 평가 관리 및 결과 조회 > 교사 평가 결과 조회 및 삭제
	 * 
	 * @param list 과정명,교사명,평가답변(개수)가 담긴 데이터
	 */
	public void vTeacherEvalQuestionResultInfoDelete(ArrayList<DTO_t_tc_oc_c_A> list) {

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("  1. 관리자 - 6. 교사 평가 관리 및 결과 조회 - c. 교사 평가 결과 조회 및 삭제");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 번호\t과정명\t\t\t\t\t교사명");

		for (int i = 0; i < list.size(); i++) {

			System.out.println(" " + list.get(i).getOpenCourse_seq() + ".\t" + list.get(i).getCourseName()
					+ "\t\t" + list.get(i).getTeacherName());

		}

		System.out.println(" z. 뒤로가기");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("- 상세보기를 원하시면 해당번호를 선택해주세요.");

	}

	/**
	 * 관리자 > 교사 평가 관리 및 결과 조회 > 교사 평가 결과 조회 및 삭제 > 상세보기
	 * 
	 * @param courseName              과정명
	 * @param teacherName             교사명
	 * @param objectiveFormlist       객관식 보기
	 * @param objectiveFormResultlist 객관식 질문, 해당 질문의 선택한 보기 비율을 담고있는 리스트
	 * @param subjectiveEx            주관식 질문 리스트
	 */
	public void vTeacherEvalQuestionResultInfoDeleteInfo(String courseName, String teacherName,
			ArrayList<DTO_Example> objectiveFormlist, ArrayList<DTO_TeacherEval_Q> objectiveFormResultlist,
			ArrayList<DTO_TeacherEval_Q> subjectiveEx) {

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("  1. 관리자 - 6. 교사 평가 관리 및 결과 조회 - c. 교사 평가 결과 조회 및 삭제 - 1. (상세보기)");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

		System.out.println(" ■ " + courseName);
		System.out.println(" ■ " + teacherName);
		System.out.println();
		System.out.print("평가질문\t\t\t\t\t\t\t\t");

		for (int i = 0; i < objectiveFormlist.size(); i++) {
			System.out.print(objectiveFormlist.get(i).getContent());
		}
		System.out.println();
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		for (int i = 0; i < objectiveFormResultlist.size(); i++) {
			System.out.printf("%50s\t%s%% \t%s%%     %s%%   %s%%    %s%%\n",
					objectiveFormResultlist.get(i).getQuestion(), objectiveFormResultlist.get(i).getRatio1(),
					objectiveFormResultlist.get(i).getRatio2(), objectiveFormResultlist.get(i).getRatio3(),
					objectiveFormResultlist.get(i).getRatio4(), objectiveFormResultlist.get(i).getRatio5());
		}
		System.out.println();
		System.out.println();
		for (int i = 0; i < subjectiveEx.size(); i++) {

			System.out.println(subjectiveEx.get(i).getEvalQ_seq() + "." + subjectiveEx.get(i).getQuestion());

		}
		System.out.println();
		System.out.println(" z. 뒤로가기");
		System.out.println();
		System.out.print("- 선택 : ");

	}

	/**
	 * 관리자 > 상담일지 관리 및 조회
	 */
	public void vConsult() {

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 - 7. 상담일지 관리 및 조회");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" a. 상담 요청 내역");
		System.out.println(" b. 상담 일지 내역");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(" z. 뒤로가기");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 요청 내역
	 */
	public void vConsultRequestInfo() {
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 - 7. 상담일지 관리 및 조회 - a. 상담 요청 내역");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" a. 일괄 조회 및 수정");
		System.out.println(" b. 과정별 조회 및 수정");
		System.out.println(" c. 학생별 조회 및 수정");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(" z. 뒤로가기");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 요청 내역 > 일괄 조회 및 수정
	 * 
	 * @param list 상담요청 한 학생정보와 상담요청정보가 들어있는 리스트
	 */
	public void vConsultRequestInfoModify(ArrayList<DTO_request_rc_oc_c_tc_t_stu_A> list) {
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 - 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 - a. 일괄 조회 및 수정");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

		System.out.println(" 번호\t학생명\t교사명\t\t과정명\t\t\t연락처\t\t학과\t\t상담요청일시\t\t상담요청 내용(간략)");

		for (int i = 0; i < list.size(); i++) {

			System.out.println(list.get(i).getRownum() + ".\t" + list.get(i).getStudentName() + "\t"
					+ list.get(i).getTeacherName() + "\t" + list.get(i).getCourseName() + "\t"
					+ list.get(i).getStudentTel() + "\t" + list.get(i).getStudentMajor() + "\t"
					+ list.get(i).getCallRequestDate() + "\t" + list.get(i).getCallRequestDetails());

		}

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("a. 수정하기");
		System.out.println("b. 삭제하기");
		System.out.println();
		System.out.println("z. 뒤로가기");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 요청 내역 > 과정별 조회 및 수정
	 * 
	 * @param list 과정에대한 정보
	 */
	public void vConsultRequestCourse(ArrayList<DTO_c_oc_r_tc_t_A> list) {

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 - 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 - b. 과정별 조회 및 수정");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 번호\t과정명\t\t과정기간\t\t\t교사명\t\t강의실명");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getRownum() + ".\t" + list.get(i).getClassName() + "\t"
					+ list.get(i).getCoureseDuration() + "\t" + list.get(i).getTeacherName() + "\t"
					+ list.get(i).getClassName());
		}

		System.out.println(" ■ 조회 및 수정을 원하시면 해당 번호를 선택해주세요.");
		System.out.println();
		System.out.println();
		System.out.println(" z. 뒤로가기");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 요청 내역 > 과정별 조회 및 수정 > 선택
	 * 
	 * @param teacherName 교사명
	 * @param courseName  과정명
	 * @param list        과정에대한 상담요청 정보
	 */
	public void vConsultRequestCourseSelect(String teacherName, String courseName,
			ArrayList<DTO_stu_rc_request_oc_A> list) {

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 - 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 - b. 일괄 조회 및 수정");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

		System.out.println(" ■ " + teacherName + "(교사)에게 신청된 상담 요청 내역입니다.");
		System.out.println(" ■ " + courseName);
		System.out.println();
		System.out.println(" 요청번호\t\t학생명\t\t연락처\t\t학과\t\t상담요청일\t\t상담요청 내용(간략)");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getRownum() + ".\t\t" + list.get(i).getStudentName() + "\t"
					+ list.get(i).getStudentTel() + "\t" + list.get(i).getStudentMajor() + "\t"
					+ list.get(i).getCallRequestDate() + "\t" + list.get(i).getCallrequestDetails());
		}

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println();
		System.out.println(" a. 수정하기");
		System.out.println(" b. 삭제하기");
		System.out.println();
		System.out.println(" z. 뒤로가기");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 요청 내역 > 학생별 조회 및 수정
	 */
	public void vConsultStudent() {

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 - 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 - c. 학생별 조회 및 수정");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" ■ 검색 조건");
		System.out.println();
		System.out.println(" a. 학생명");
		System.out.println(" b. 주민번호뒷자리");
		System.out.println(" c. 전화번호");
		System.out.println(" d. 등록일");
		System.out.println(" e. 학과");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("z. 뒤로가기");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	}

	// 1. 관리자 – 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 – c. 학생별 조회 및 수정 – 검색 – 검색, 조회 및 수정
	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 요청 내역 > 학생별 조회 및 수정 > 검색, 조회 및 수정
	 */
	public void vConsultRequestStudentName() {

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 - 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 -c. 학생별 조회 및 수정 - 검색, 조회 및 수정");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

		System.out.print(" 학생명 : ");

	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 요청 내역 > 학생별 조회 및 수정 > 학생명
	 * 
	 * @param list
	 */
	public void vConsultRequestStudentNameAfter(ArrayList<DTO_request_rc_oc_c_stu_A> list) {
		// 1. 관리자 – 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 – c. 학생별 조회 및 수정 – 검색 – 조회 및 수정 뒷부분 출력

		System.out.println(" 요청번호\t\t학생명\t\t연락처\t\t학과\t\t상담요청일\t\t상담요청내용");

		for (int i = 0; i < list.size(); i++) {
			System.out.printf(" %s\t\t%s\t%s\t%s\t%s\t%s\n", list.get(i).getconsult_Seq(), list.get(i).getStudentName(),
					list.get(i).getStudentTel(), list.get(i).getStudentMajor(), list.get(i).getCallrequestDate(),
					list.get(i).getCallrequestDetails());
		}

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" a. 수정하기");
		System.out.println(" b. 삭제하기");
		System.out.println();
		System.out.println(" z. 뒤로가기");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 요청 내역 > 학생별 조회 및 수정 > 검색, 조회 및 수정
	 */
	public void vConsultRequestStudenPw() {
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 - 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 -c. 학생별 조회 및 수정 - 검색, 조회 및 수정");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println();
		System.out.print(" 주민번호 뒷자리 : ");

	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 요청 내역 > 학생별 조회 및 수정 > 주민번호(뒷자리)
	 * 
	 * @param list 입력한 주민번호(뒷자리)와 일치하는 학생정보와 상담요청 정보 리스트
	 */
	public void vConsultRequestStudentPwAfter(ArrayList<DTO_request_rc_oc_c_stu_A> list) {
		// 1. 관리자 – 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 – c. 학생별 조회 및 수정 – 검색 – 조회 및 수정 뒷부분 출력
		// 주민뒷자리
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 요청번호\t\t학생명\t\t연락처\t\t학과\t\t상담요청일\t\t상담요청내용");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

		for (int i = 0; i < list.size(); i++) {
			System.out.printf(" %s\t\t%s\t%s\t%s\t%s\t%s\n", list.get(i).getconsult_Seq(), list.get(i).getStudentName(),
					list.get(i).getStudentTel(), list.get(i).getStudentMajor(), list.get(i).getCallrequestDate(),
					list.get(i).getCallrequestDetails());
		}

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" a. 수정하기");
		System.out.println(" b. 삭제하기");
		System.out.println();
		System.out.println(" z. 뒤로가기");

	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 요청 내역 > 학생별 조회 및 수정 > 검색, 조회 및 수정
	 */
	public void vConsultRequestStudenTel() {
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 - 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 -c. 학생별 조회 및 수정 - 검색, 조회 및 수정");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

		System.out.print(" 전화번호(-포함) : ");
	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 요청 내역 > 학생별 조회 및 수정 > 전화번호
	 * 
	 * @param list
	 */
	public void vConsultRequestStudentTelAfter(ArrayList<DTO_request_rc_oc_c_stu_A> list) {
		// 1. 관리자 – 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 – c. 학생별 조회 및 수정 – 검색 – 조회 및 수정 뒷부분 출력
		// 전화번호

		System.out.println(" 요청번호\t\t학생명\t\t연락처\t\t학과\t\t상담요청일\t\t상담요청내용");

		for (int i = 0; i < list.size(); i++) {
			System.out.printf(" %s\t\t%s\t%s\t%s\t%s\t%s\n", list.get(i).getconsult_Seq(), list.get(i).getStudentName(),
					list.get(i).getStudentTel(), list.get(i).getStudentMajor(), list.get(i).getCallrequestDate(),
					list.get(i).getCallrequestDetails());
		}

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" a. 수정하기");
		System.out.println(" b. 삭제하기");
		System.out.println();
		System.out.println(" z. 뒤로가기");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 요청 내역 > 학생별 조회 및 수정 > 검색, 조회 및 수정
	 */
	public void vConsultRequestStudenRegdate() {
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 - 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 -c. 학생별 조회 및 수정 - 검색, 조회 및 수정");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

		System.out.print("- 등록일(ex 2017-01-01) : ");

	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 요청 내역 > 학생별 조회 및 수정 > 등록일
	 * 
	 * @param list 입력한 등록일과 일치하는 학생정보와 상담요청 정보
	 */
	public void vConsultRequestStudentRegdateAfter(ArrayList<DTO_request_rc_oc_c_stu_A> list) {
		// 1. 관리자 – 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 – c. 학생별 조회 및 수정 – 검색 – 조회 및 수정 뒷부분 출력
		// 등록일
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 요청번호\t\t학생명\t\t연락처\t\t학과\t\t상담요청일\t\t상담요청내용");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

		for (int i = 0; i < list.size(); i++) {
			System.out.printf(" %s\t\t%s\t%s\t%s\t%s\t%s\n", list.get(i).getconsult_Seq(), list.get(i).getStudentName(),
					list.get(i).getStudentTel(), list.get(i).getStudentMajor(), list.get(i).getCallrequestDate(),
					list.get(i).getCallrequestDetails());
		}

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("a. 수정하기");
		System.out.println("b. 삭제하기");
		System.out.println();
		System.out.println("z. 뒤로가기");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 요청 내역 > 학생별 조회 및 수정 > 검색, 조회 및 수정
	 */
	public void vConsultRequestStudenMajor() {
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 - 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 -c. 학생별 조회 및 수정 - 검색, 조회 및 수정");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.print("- 학과 : ");

	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 요청 내역 > 학생별 조회 및 수정 > 학과
	 * 
	 * @param list
	 */
	public void vConsultRequestStudentMajorAfter(ArrayList<DTO_request_rc_oc_c_stu_A> list) {
		// 1. 관리자 – 7. 상담일지 관리 및 조회 - a. 상담 요청 내역 – c. 학생별 조회 및 수정 – 검색 – 조회 및 수정 뒷부분 출력
		// 학과
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 요청번호\t\t학생명\t\t연락처\t\t학과\t\t상담요청일\t\t상담요청내용");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

		for (int i = 0; i < list.size(); i++) {
			System.out.printf(" %s\t\t%s\t%s\t%s\t%s\t%s\n", list.get(i).getconsult_Seq(), list.get(i).getStudentName(),
					list.get(i).getStudentTel(), list.get(i).getStudentMajor(), list.get(i).getCallrequestDate(),
					list.get(i).getCallrequestDetails());
		}

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" a. 수정하기");
		System.out.println(" b. 삭제하기");
		System.out.println();
		System.out.println(" z. 뒤로가기");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 일지 내역
	 */
	public void vConsultResult() {

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

		System.out.println(" a. 일괄 조회");
		System.out.println(" b. 과정별 조회");
		System.out.println(" c. 학생별 조회");
		System.out.println();
		System.out.println("z. 뒤로가기");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.print("선택 : ");
	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 일지 내역 > 일괄 조회
	 * 
	 * @param list 상담일지 정보
	 */
	public void vConsultResultInfo(ArrayList<DTO_record_request_rc_stu_oc_tc_t_A> list) {

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역 - a. 일괄 조회 및 수정");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 상담번호\t상담일시\t\t교사명\t학생명\t상담요청내용\t\t\t\t\t상담내용");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

		for (int i = 0; i < list.size(); i++) {
			System.out.printf(" %s\t%s\t%s\t%s\t%-50s%-50s\n", list.get(i).getRecord_seq(),
					list.get(i).getConsultationDate(), list.get(i).getTeacherName(), list.get(i).getStudentName(),
					list.get(i).getCallrequestDetails(), list.get(i).getContentsConsultation());
		}
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" a. 수정하기");
		System.out.println(" b. 삭제하기");
		System.out.println();
		System.out.println(" z. 뒤로가기");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.print("선택 : ");
	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 일지 내역 > 교사별 조회 및 수정
	 * 
	 * @param list 과정 정보
	 */
	public void vConsultResultInfoCourse(ArrayList<DTO_c_oc_r_tc_t_A> list) {
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역 - b. 과정별 조회 및 수정");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 번호\t과정명\t\t\t\t\t과정기간\t\t\t\t교사명\t\t강의실명");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

		for (int i = 0; i < list.size(); i++) {
			System.out.printf(" %s.\t%s\t\t%s\t\t%s\t\t%s\n", list.get(i).getOpencourse_seq(),
					list.get(i).getCourseName(), list.get(i).getCoureseDuration(), list.get(i).getTeacherName(),
					list.get(i).getClassName());
		}
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("- 조회 및 수정을 원하시면 해당 번호를 선택해주세요.");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("z. 뒤로가기");

	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 일지 내역 > 교사별 조회 및 수정
	 * 
	 * @param list
	 */
	public void vConsultResultInfoCourseViewModify(ArrayList<DTO_record_request_rc_stu_oc_tc_t_A> list) {

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역 - b. 과정별 조회 및 수정 - 1. 선택");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

		System.out.println(" 번호\t상담일시\t\t교사명\t학생명\t\t상담요청내용\t\t\t상담내용");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

		for (int i = 0; i < list.size(); i++) {
			System.out.printf(" %s.\t%s\t%s\t%s\t%-50s%s\n", list.get(i).getRecord_seq(),
					list.get(i).getConsultationDate(), list.get(i).getTeacherName(), list.get(i).getStudentName(),
					list.get(i).getCallrequestDetails(), list.get(i).getContentsConsultation());
		}
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" a. 수정하기");
		System.out.println(" b. 삭제하기");
		System.out.println();
		System.out.println(" z. 뒤로가기");
		System.out.print("선택 : ");

	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 일지 내역 > 학생별 조회 및 수정
	 */
	public void vConsultRecordStudentInfoModify() {

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역 - c. 학생별 조회 및 수정");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" ■ 검색 조건");
		System.out.println();
		System.out.println(" a. 학생명");
		System.out.println(" b. 주민번호뒷자리");
		System.out.println(" c. 학과");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(" z. 뒤로가기");

		System.out.println(" 선택 : ");
	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 일지 내역 > 학생별 조회 및 수정 > 검색
	 */
	public void vConsultRecordStudent() {

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 1. 관리자 - 7. 상담일지 관리 및 조회 - b. 상담 일지 내역 - c. 학생별 조회 및 수정 - 검색");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 일지 내역 > 학생별 조회 및 수정 > 검색 - 조회 및 수정
	 * 
	 * @param list 상담일지 정보
	 */
	public void vConsultRecordStudentName(ArrayList<DTO_record_request_rc_stu_oc_tc_t_A> list) {

		System.out.println(" 상담번호\t상담일시\t\t교사명\t학생명\t\t상담요청내용\t\t\t상담내용");

		for (int i = 0; i < list.size(); i++) {
			System.out.printf(" %s.\t%s\t%s\t%s\t%-50s%s\n", list.get(i).getRecord_seq(),
					list.get(i).getConsultationDate(), list.get(i).getTeacherName(), list.get(i).getStudentName(),
					list.get(i).getCallrequestDetails(), list.get(i).getContentsConsultation());
		}

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" a. 수정하기");
		System.out.println(" b. 삭제하기");
		System.out.println();
		System.out.println(" z. 뒤로가기");
		System.out.print(" 선택 : ");

	}

	/**
	 * 관리자 > 교사 평가 관리 및 결과 조회 > 교사 평가 결과 조회 및 삭제 > 주관식
	 * 
	 * @param descriptive
	 * @param list
	 */
	public void vGood(String descriptive, ArrayList<DTO_TeacherEval_A> list) {

		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 교사 평가 결과 조회");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

		System.out.println();
		System.out.println("- " + descriptive);
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(" 번호\t내용");

		int start = 0;
		int end = 9;
		boolean flag = true;
		Scanner scan = new Scanner(System.in);

		while (flag) {
			if (list.size() >= end) {

				for (int i = start; i <= end; i++) {
					System.out.println(list.get(i).getEvalA_seq() + ".\t" + list.get(i).getSubjective_A());
					System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");

				}

				System.out.println(" (" + (start + 1) + "_" + (end + 1) + "/" + list.size() + ")");
				System.out.println(" 1. 더보기");
				System.out.println(" z.돌아가기");

				String sel = scan.nextLine();

				pause();

				if (sel.equals("1")) {
					start += 10;
					end += 10;
					continue;
				} else if (sel.equalsIgnoreCase("z")) {
					break;
				}

			} else {

				for (int i = start; i < list.size(); i++) {
					System.out.println(list.get(i).getEvalA_seq() + ".\t" + list.get(i).getSubjective_A());
					System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
				}

				System.out.println(" (" + (start + 1) + "_" + list.size() + "/" + list.size() + ")");

				System.out.println(" z.돌아가기");

				String sel = scan.nextLine();

				pause();

				if (sel.equalsIgnoreCase("z")) {
					break;
				}

			}

		}
	}

	public void pause() { // 프로그램 넘어가기 전에 출력

		System.out.println("\t계속하려면 엔터를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();

		clearScreen();
		System.out.println("\t\t\t\t\tLOADING.....");
		try {
			Thread.sleep(700);
		} catch (Exception e) {
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
