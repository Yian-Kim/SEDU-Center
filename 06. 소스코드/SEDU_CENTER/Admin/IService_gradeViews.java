package Admin;

public interface IService_gradeViews {

	// 1. 관리자 - 4. 성적 조회
	void gradeViewsInfo();

	// 1. 관리자 - 4. 성적 조회 - a. 과정별 성적 조회
	String viewOpenCourse();

	// 1. 관리자 - 4. 성적 조회 - a. 과정별 성적 조회 - 과정 선택결과
	void viewOpenSubject(String seq);

	// 1. 관리자 - 4. 성적 조회 - a. 과정별 성적 조회 - 과정 - 과목 선택결과
	void subjectDetails(String courseSeq, String subjectSeq);
	
	// 1. 관리자 - 4. 성적 조회 - b. 학생별 성적 조회
	String viewStudentCourse();

	// 1. 관리자 - 4. 성적 조회 - b. 학생별 성적 조회 - 학생 선택결과
	void viewStudentInfo(String studentSeq);
	
	// 문자열이 숫자인지 아닌지 판별하는 메소드
	boolean isStringDouble(String s);

	
	
}//IService_gradeViews
