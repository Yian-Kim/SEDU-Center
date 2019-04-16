package Admin;

public class DTO_CourseOpencourseRoomTeachercourseTeacher_A {

	private String rownum; // 상담 요청 내역의 교사별 조회 순서 번호
	private String courseName; // 상담 요청 내역의 교사별 조회 과정명
	private String coureseDuration;// 상담 요청 내역의 교사별 조회 과정기간
	private String teacherName;// 상담 요청 내역의 교사별 조회 교사명
	private String className;// 상담 요청 내역의 교사별 조회 강의실명
	private String teacherNum; // 상담 요청 내역의 교사별 조회 교사번호
	private String openCourseNum; // 상담 요청 내역의 교사별 조회 개설과정번호
	
	
	
	public String getTeacherNum() {
		return teacherNum;
	}
	public void setTeacherNum(String teacherNum) {
		this.teacherNum = teacherNum;
	}
	public String getOpenCourseNum() {
		return openCourseNum;
	}
	public void setOpenCourseNum(String openCourseNum) {
		this.openCourseNum = openCourseNum;
	}
	public String getRownum() {
		return rownum;
	}
	public void setRownum(String rownum) {
		this.rownum = rownum;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCoureseDuration() {
		return coureseDuration;
	}
	public void setCoureseDuration(String coureseDuration) {
		this.coureseDuration = coureseDuration;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	
	
}
