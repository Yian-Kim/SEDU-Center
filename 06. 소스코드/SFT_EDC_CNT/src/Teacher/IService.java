package Teacher;

public interface IService {

	void teacherSchedule() throws InterruptedException; // 강의스케줄 조회

	void studentInfo() throws InterruptedException; // 강의스케줄 조회 - 학생정보 조회
	
	void gradeInputOuput() throws InterruptedException; // 성적입출력
	
	void gradeInput() throws InterruptedException; // 성적 입력
	
	void gradeOutput() throws InterruptedException; // 성적 조회

	void attendanceMGMT() throws InterruptedException; // 출결관리 및 조회

	void attendanceOutput(int flag) throws InterruptedException; // 출결조회
	
	void teacherEvaluation(); // 교사평가 조회

	void teacherConsult(); // 상담일지 입력 및 조회

	
	
	

	
}
