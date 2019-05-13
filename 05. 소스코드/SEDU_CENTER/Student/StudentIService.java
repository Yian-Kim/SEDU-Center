package Student;

//인터페이스
public interface StudentIService {

	// 학생계정 로그인
	void studentLogin() throws InterruptedException;

	// 로그인 이후 학생의 기본정보 출력
	void studentInfo();

	// 학생이 사용가능한 메뉴 출력 및 이동 원하는 메뉴 입력 받음
	void studentMemu() throws InterruptedException;

	// 학생(본인) 성적 조회
	void gradeSearch() throws InterruptedException;

	// 출석 조회 (이동 가능한 메뉴 출력)
	void attendSearch() throws InterruptedException;

	// 전체 출석 조회
	void totalSearch() throws InterruptedException;

	// 월별 출석 조회
	void monthSearch() throws InterruptedException;

	// 일별 출석 조회
	void dailySearch();

	// 교사 평가
	void teacherEval();

	// 상담 신청
	void consRequest();

	// 상담 일지 조회
	void consRecSearch();

	// 과정 및 과목 조회
	void regiCourSearch();

}