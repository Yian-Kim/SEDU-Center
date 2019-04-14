package Teacher;

public interface IService {

	void teacherSchedule() throws InterruptedException; // 강의스케줄 조회

	void gradeOuput(); // 성적입출력

	void attendanceMGMT(); // 출결관리 및 조회

	void teacherEvaluation(); // 교사평가 조회

	void teacherConsult(); // 상담일지 입력 및 조회
	
	
	void studentInfo() throws InterruptedException;
	
}
