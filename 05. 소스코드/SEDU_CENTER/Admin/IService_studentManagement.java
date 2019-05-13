package Admin;

import java.util.ArrayList;

import dto_common.DTO_Student;

public interface IService_studentManagement {

	// 1. 관리자 - 3. 학생 관리
	void StudentManagementInfo();

	// 1. 관리자 - 3. 학생 관리 - a. 학생 정보 전체보기
	void vASI();

	// 1. 관리자 - 3. 학생 관리 - b. 학생 정보 등록
	void addStudentInfo();

	// 1. 관리자 - 3. 학생 관리 - c. 학생 정보 검색 및 수정
	ArrayList<DTO_Student> searchEditStudents();

	// 1. 관리자 - 3. 학생 관리 - c. 학생 정보 검색 및 수정 - 검색 결과
	void studentSearchResults(ArrayList<DTO_Student> list);
	
	// 1. 관리자 - 3. 학생 관리 - c. 학생 정보 검색 및 수정 - 검색 결과 - 수정
	void modifyStudent(String studentNum);
	
	// 1. 관리자 - 3. 학생 관리 - c. 학생 정보 검색 및 수정 - 검색 결과 - 삭제
	void deleteStudent(String studentNum);
	
	//문자열이 숫자인지 아닌지 판별하는 메소드
	boolean isStringDouble(String s);

}//IService_studentManagement
