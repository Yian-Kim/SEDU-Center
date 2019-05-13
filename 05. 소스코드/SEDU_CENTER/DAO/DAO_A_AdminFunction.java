package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
import main_admin.DBUtil;

/**
 * 
 * 관리자 기능에서 DB연동을 위한 클래스
 *
 */
public class DAO_A_AdminFunction {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	
	// 초기화(선행 작업)
	// DB 접속
	/**
	 * 생성자
	 * DB 연결시켜주기위한 초기화 작업
	 */
	public DAO_A_AdminFunction() {
		
		try {
			DBUtil util = new DBUtil();
			this.conn = util.connect();
			this.stat = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DAO.Constructor");
		}
		
	}
	
	/**
	 * DB가 연동 되어있는지 확인해주는 메소드 true, false중 반환
	 * @return
	 */
	public boolean isConnected() { // 조건문 써먹을수 잇음
		
		try {
			return !this.conn.isClosed();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
				
	}
	
	/**
	 * DB랑 연동을 위한 자원을 해제하는 메소드
	 */
	public void close() {
		try {
			
			this.conn.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	/**
	 * 개설 과정 및 과목 관리에서 나타낼 정보들을 리스트에 담아 반환하는 메소드
	 * @return 개설 과정에 대한 정보
	 */
	public ArrayList<DTO_oc_c_r_A> daoOpenMgmtInfo() {
		// 1. 관리자 - 2. 개설 과정 및 과목 관리
		
		DTO_oc_c_r_A oc_c_r = new DTO_oc_c_r_A();
		
		ArrayList<DTO_OpenCourse> ifList = new ArrayList<DTO_OpenCourse>();
		
		String sql = "select opencourse_seq from tblOpenCourse";
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_OpenCourse oc = new DTO_OpenCourse();
				oc.setCourse_seq(rs.getString("opencourse_seq"));
				
				ifList.add(oc);
				
			}
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction_daoOpenMgmtInfo() 오류");
			e.printStackTrace();
		}
		
		
		
		ArrayList<DTO_oc_c_r_A> list = new ArrayList<DTO_oc_c_r_A>();
		
		for(int i = 0; i < ifList.size(); i++) {
		
			sql = "SELECT oc.opencourse_seq, rpad(c.name,40,' ') as courseName, oc.startDate || '~' || oc.endDate as courseduration, rpad(r.roomName, 12,' ') as className, rpad((SELECT count(*) FROM tblOpenCourse oc INNER JOIN tblOpenSubjectMgmt osm ON oc.openCourse_seq = osm.openCourse_seq WHERE osm.openCourse_seq = " + ifList.get(i).getCourse_seq() + "),2,' ') as subjectRegistration, (SELECT count(*) FROM tblOpenCourse oc INNER JOIN tblRegiCourse rc ON oc.openCourse_seq = rc.openCourse_seq INNER JOIN tblStudent s ON s.student_seq = rc.student_seq WHERE oc.openCourse_seq = " + ifList.get(i).getCourse_seq() + ") as studentNum FROM tblOpenCourse oc INNER JOIN tblCourse c ON oc.course_seq = c.course_seq INNER JOIN tblRoom r ON oc.room_seq = r.room_seq where oc.openCourse_seq = " + ifList.get(i).getCourse_seq();
			
			try {
				
				ResultSet rs = stat.executeQuery(sql);
				
				while(rs.next()) {
					
					DTO_oc_c_r_A dto_oc_c_r = new DTO_oc_c_r_A();
					dto_oc_c_r.setRownum(rs.getString("opencourse_seq"));
					dto_oc_c_r.setCourseName(rs.getString("courseName"));
					dto_oc_c_r.setCourseduration(rs.getString("courseduration"));
					dto_oc_c_r.setClassName(rs.getString("className"));
					dto_oc_c_r.setSubjectRegistration(rs.getString("subjectRegistration"));
					dto_oc_c_r.setStudentNum(rs.getString("studentNum"));
					
					list.add(dto_oc_c_r);
					
				}
				
			} catch (SQLException e) {
				System.out.println("DAO_AdminFunction_daoOpenMgmtInfo() 오류");
				e.printStackTrace();
			}
			
		
		}
		
		return list;
	}
	
	/**
	 * 개설 과정 및 과목 관리에서 선택한 과정 데이터 PK를 가져오는 메소드
	 * @return 과정PK가 담겨있는 리스트 반환
	 */
	public ArrayList<DTO_OpenCourse> daoOpenMgmtInfoNum(){
		
		ArrayList<DTO_OpenCourse> list = new ArrayList<DTO_OpenCourse>();
		
		String sql = "SELECT openCourse_seq FROM tblOpenCourse";
		
		try {
			
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_OpenCourse oc = new DTO_OpenCourse();
				
				oc.setCourse_seq(rs.getString("opencourse_seq"));
				
				list.add(oc);
				
				
			}
			
			return list;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoOpenMgmtInfoNum() 오류!");
			e.printStackTrace();
		}
		
		return null;
		
	}

	/**
	 * 개설 과정명을 DB에서 가져오는 메소드
	 * @param num 선택한 과정에 대한 PK
	 * @return 선택한 과정명
	 */
	public String daoOpenMgmtCourseName(int num) {
		
		String sql = "SELECT rpad(c.name,35,' ') as courseName FROM tblOpenCourse oc INNER JOIN tblCourse c ON oc.course_seq = c.course_seq WHERE oc.openCourse_seq = " + num;
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				
				return rs.getString("courseName");
				
			}
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoOpenMgmtCourseName(int num)  오류!");
			e.printStackTrace();
		}
		
		
		return null;
	}

	/**
	 * 선택한 과정에대한 교사명을 가져오는 메소드
	 * @param num 선택한 과정에 대한 PK
	 * @return 선택한 교사명
	 */
	public String daoOpenMgmtTeacherName(int num) {
		
		String sql = "SELECT rpad(t.name,15,' ') as teacherName FROM tblOpenCourse oc INNER JOIN tblTeacherCourse tc ON oc.openCourse_seq = tc.openCourse_seq INNER JOIN tblTeacher t ON tc.teacher_seq = t.teacher_seq WHERE oc.openCourse_seq = " + num;
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				
				return rs.getString("teacherName");
				
			}
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoOpenMgmtTeacherName(int num)   오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 선택한 과정에대한 강의실명을 DB에서 가져오는 메소드
	 * @param num 선택한 과정PK
	 * @return 선택한 과정에 대한 강의실명
	 */
	public String daoOpenMgmtClassName(int num) {
		
		String sql = "SELECT rpad(r.roomName,12, ' ') as className FROM tblOpenCourse oc INNER JOIN tblRoom r ON oc.room_seq = r.room_seq WHERE oc.openCourse_seq = " + num;
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				
				return rs.getString("className");
				
			}
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoOpenMgmtCourseNameClassName(int num) 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 선택한 과정에 대한 과정기간을 DB에서 가져오는 메소드
	 * @param num 선택한 과정PK
	 * @return 선택한 과정에 대한 과정기간
	 */
	public String daoOpenMgmtcourseDuration(int num) {

		String sql = "SELECT startDate || '~' || endDate as courseDuration FROM tblOpenCourse WHERE openCourse_seq =" + num;
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				
				return rs.getString("courseDuration");
				
			}
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoOpenMgmtcourseDuration(int num) 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 선택한 과정에 대한 과목들을 DB에서 가져오는 메소드
	 * @param num 선택한 과정PK
	 * @return 선택한 과정에 대한 과목들
	 */
	public ArrayList<DTO_oc_osm_s_A> daoOpenMgmtSubjectInfo(int num) {
		
		ArrayList<DTO_oc_osm_s_A> list = new ArrayList<DTO_oc_osm_s_A>();
		
		String sql = "SELECT rpad(s.name,25,' ') as subjectName, rpad(s.period|| '일',11,' ')  as subjectDuration FROM tblOpenCourse oc INNER JOIN tblOpenSubjectMgmt osm ON oc.openCourse_seq = osm.openCourse_seq INNER JOIN tblSubject s ON osm.subject_seq = s.subject_seq WHERE oc.openCourse_seq = " + num;
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_oc_osm_s_A oc_osm_s = new DTO_oc_osm_s_A();
				
				oc_osm_s.setSubjectName(rs.getString("subjectName"));
				oc_osm_s.setSubjectDuration(rs.getString("subjectDuration"));
				
				list.add(oc_osm_s);
				
			}
			
			return list;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoOpenMgmtSubjectInfo(int num) 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 선택한 과정에 대한 학생들 정보를 DB에서 가져오는 메소드
	 * @param num 선택한 과정PK
	 * @return 선택한 과정에 대한 학생들정보
	 */
	public ArrayList<DTO_oc_rc_stu_result_A> daoOpenMgmtstudentInfo(int num) {

		ArrayList<DTO_oc_rc_stu_result_A> list = new ArrayList<DTO_oc_rc_stu_result_A>();
		
		String sql = "SELECT rpad(s.name,15,' ') as studentName, s.pw as studentPw, s.tel as studentTel, to_char(s.regiDate, 'yyyy-mm-dd') as studentRegidate, rpad(r.state, 10, ' ') as completion FROM tblOpenCourse oc INNER JOIN tblRegiCourse rc ON oc.openCourse_seq = rc.openCourse_seq INNER JOIN tblStudent s ON rc.student_seq = s.student_seq INNER JOIN tblResult r ON rc.regiCourse_seq = r.regiCourse_seq where oc.openCourse_seq = " + num;
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_oc_rc_stu_result_A oc_rc_stu_result = new DTO_oc_rc_stu_result_A();
				
				oc_rc_stu_result.setStudentName(rs.getString("studentName"));
				oc_rc_stu_result.setStudentPw(rs.getString("studentPw"));
				oc_rc_stu_result.setStudentTel(rs.getString("studentTel"));
				oc_rc_stu_result.setStudentRegidate(rs.getString("studentRegidate"));
				oc_rc_stu_result.setCompletion(rs.getString("completion"));
				
				list.add(oc_rc_stu_result);
				
			}
			
			return list;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoOpenMgmtstudentInfo(int num) 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 과목에 대한 정보를 DB에서 가져오는 메소드
	 * @return 과목 정보
	 */
	public ArrayList<DTO_Subject> daoOpenMgmtSubjectRegistration() {

		ArrayList<DTO_Subject> list = new ArrayList<DTO_Subject>();
		
		String sql = "select subject_seq, rpad(name, 30, ' ' ) as sName , rpad(period|| '일', 7, ' ') as sPeriod  from tblSubject";
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_Subject s = new DTO_Subject();
				
				s.setSubject_seq(rs.getString("subject_seq"));
				s.setName(rs.getString("sName"));
				s.setPeriod(rs.getString("sPeriod"));
				
				list.add(s);
				
			}
			
			return list;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoOpenMgmtSubjectRegistration() 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * DB에 연동하여 개설 과정에서 과목 정보 추가
	 * @param num 과목 PK
	 * @param startDate 과목 시작일
	 * @param endDate 과목 종료일
	 * @param selectNum 과목을 추가할 과정 PK 
	 * @return
	 */
	public int daoOpenSubjectAdd(int num, String startDate, String endDate, int selectNum) {
		
		String sql = "INSERT INTO tblOpenSubjectMgmt  VALUES(OpenSubjectMgmt_seq.nextval,to_date('" + startDate + "', 'yyyy-mm-dd'), to_date('" + endDate + "', 'yyyy-mm-dd'), " + num + ", " + selectNum + ")";
		
		String sql2 = "update tblOpenCourse Set endDate = to_date(' " + endDate + "','yyyy-mm-dd') where opencourse_seq = " + selectNum;
		
		try {
			int result = stat.executeUpdate(sql);
			stat.executeUpdate(sql2);
			
			return result;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoOpenSubjectAdd(int num, String startDate, String endDate, int selectNum) 오류!");
			e.printStackTrace();
		}
		return 0;
		
	}

	/**
	 * 관리자 > 개설 과정 및 과목 관리 > 개설과정 정보 등록을 위해
	 * 현재 등록된 과정 정보를 DB에서 가져오는 메소드 
	 * @return 등록된 과정 정보를 반환
	 */
	public ArrayList<DTO_Course> daoSubject() {

		ArrayList<DTO_Course> list = new ArrayList<DTO_Course>();
		
		String sql = "select course_seq, rpad(name, 35, ' ') as courseName, rpad(period|| '일', 7, ' ')  as courseDuration from tblCourse";
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_Course course = new DTO_Course();
				
				course.setCourse_seq(rs.getString("course_seq"));
				course.setName(rs.getString("courseName"));
				course.setPeriod(rs.getString("courseDuration"));
				
				list.add(course);
				
			}
			
			return list;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoSubject() 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 등록 가능한 교실 정보를 DB에서 가져오는 메소드
	 * @param startDate 입력한 과정 시작일
	 * @param endDate 입력한 과정 종료일
	 * @return 등록가능한 교실 정보 반환
	 */
	public ArrayList<DTO_Room> daoAvailClassName(String startDate, String endDate) {

		ArrayList<DTO_Room> list = new ArrayList<DTO_Room>();
		
		String sql = "SELECT room_seq, roomName FROM tblRoom WHERE not room_seq in (SELECT r.room_seq FROM tblOpenCourse oc INNER JOIN tblRoom r ON oc.room_seq = r.room_seq WHERE to_date('" + startDate + "', 'yyyy-mm-dd') between oc.startDate and oc.endDate or to_date('" + endDate + "', 'yyyy-mm-dd') between oc.startDate and oc.endDate) order by room_seq";
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_Room room = new DTO_Room();
				
				room.setRoom_seq(rs.getString("room_seq"));
				room.setRoomName(rs.getString("roomName"));
				
				list.add(room);
				
			}
			
			return list;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoAvailClassName(String startDate, String endDate) 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 개설할 과정을 DB에 등록하는 메소드
	 * @param startDate 등록할 과정 시작일
	 * @param endDate 등록할 과정 종료일
	 * @param num DB에 저장된 과정에 대한 데이터에서 선택할 과정번호
	 * @param classNum 등록할 과정이 진행될 교실
	 * @return
	 */
	public int daoOpenCourseAdd(String startDate, String endDate, int num, int classNum) {
		
		String sql = "INSERT INTO tblOpenCourse VALUES(OpenCourse_seq.nextval, to_date('" + startDate + "','yyyy-mm-dd'), to_date('" + endDate +"','yyyy-mm-dd'), "+ num +", "+ classNum +")";
		
		try {
			
			int result = stat.executeUpdate(sql);
			
			return result;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoOpenCourseAdd(String startDate, String endDate, int num, int classNum) 오류!");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 관리자 > 교사 평가 관리 및 결과 조회 > 질문지 등록
	 * @param question 질문
	 * @param typeNum 유형(객관식/주관식)
	 * @return 질문지 등록완료 1 실패 0
	 */
	public int daoTeacherEvalQuestionRegister(String question, int typeNum) {
		
		String sql = "INSERT INTO tblTeacherEval_Q VALUES (TeacherEval_Q.nextval, '" + question + "', " + typeNum + ")";
		
		try {
			int result = stat.executeUpdate(sql);
			
			return result;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoTeacherEvalQuestionRegister(String question, int typeNum) 오류!");
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 관리자 > 교사 평가 관리 및 결과 조회 > 질문지 수정 및 삭제
	 * DB와 연동하여 등록된 질문지 정보들을 가져오는 메소드
	 * @return 등록된 질문지 정보
	 */
	public ArrayList<DTO_teq_t_A> daoTeacherEvalQuestionModifyDelete() {
		
		ArrayList<DTO_teq_t_A> list = new ArrayList<DTO_teq_t_A>();
		
String sql = "SELECT teq.evalq_seq as seq, rpad(teq.question, 70, ' ') as questionnaire, rpad(t.type,9,' ') as questionType FROM tblTeacherEval_Q teq INNER JOIN tblType t ON teq.type_seq = t.type_seq ORDER BY teq.evalQ_seq";
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_teq_t_A teq_t = new DTO_teq_t_A();
				
				teq_t.setEvalq_seq(rs.getString("seq"));
				teq_t.setQuestionnaire(rs.getString("questionnaire"));
				teq_t.setQuestionType(rs.getString("questionType"));
				
				list.add(teq_t);
				
			}
			
			return list;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoTeacherEvalQuestionModifyDelete() 오류!");
			e.printStackTrace();
		}
		
		return null;
		
	}

	/**
	 * 관리자 > 교사 평가 관리 및 결과 조회 > 질문지 수정 및 삭제 > 번호 선택
	 * DB에서 선택한 질문지를 가져옴
	 * @param choiceNum 선택한 질문지번호
	 * @return 질문지
	 */
	public DTO_teq_t_A daossTeacherEvalQuestionModifyDeleteNumber(int choiceNum) {
		
		DTO_teq_t_A teq_t = new DTO_teq_t_A();
		
		String sql = "SELECT teq.evalq_seq as seq, rpad(teq.question, 70, ' ') as questionnaire, rpad(t.type,9,' ') as questionType FROM tblTeacherEval_Q teq INNER JOIN tblType t ON teq.type_seq = t.type_seq WHERE evalQ_seq = " + choiceNum;
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				teq_t.setEvalq_seq(rs.getString("seq"));
				teq_t.setQuestionnaire(rs.getString("questionnaire"));
				teq_t.setQuestionType(rs.getString("questionType"));
			}
			
			return teq_t;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daossTeacherEvalQuestionModifyDeleteNumber(int choiceNum) 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 관리자 > 교사 평가 관리 및 결과 조회 > 질문지 수정 및 삭제 > 번호선택 > 수정하기
	 * 질문지 수정하기
	 * @param question 질문지
	 * @param typeNum 유형(객관식/주관식)
	 * @param choiceNum 질문지 번호
	 * @return 수정완료 1 수정실패 0
	 */
	public int daoTeacherEvalQuestionModify(String question, int typeNum, int choiceNum) {
		
		
		
		String sql = String.format("UPDATE tblTeacherEval_Q SET question = '%s', type_seq = %d where evalq_seq = %d", question, typeNum, choiceNum);
		
		try {
			
			int result = stat.executeUpdate(sql);
			
			return result;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스  daoTeacherEvalQuestionModify(String question, int choiceNum) 오류!");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 관리자 > 교사 평가 관리 및 결과 조회 > 질문지 수정 및 삭제 > 번호선택 > 삭제하기
	 * 질문지 삭제하기
	 * @param choiceNum 질문지PK
	 * @return 삭제완료1 삭제실패 0
	 */
	public int daoTeacherEvalQuestionDelete(int choiceNum) {
		
		String sql = String.format("DELETE FROM tblTeacherEval_Q\r\n" + 
				"    WHERE evalQ_seq = %d",  choiceNum);
		
		try {
			
			int result = stat.executeUpdate(sql);
			
			return result;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스  daoTeacherEvalQuestionModify(String question, int choiceNum) 오류!");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 관리자 > 교사 평가 관리 및 결과 조회 > 교사 평가 결과 조회 및 삭제
	 * DB에서 개설 과정 개수를 가져옴
	 * @return 개설 과정 개수
	 */
	public int daoOpenCourseNum() {
		
		String sql = "SELECT COUNT(*) as numberOpenCourse FROM tblOpenCourse";
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				int cnt = Integer.parseInt(rs.getString("numberOpenCourse"));
				
				return cnt;
			}
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoOpenCourseNum() 오류!");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 관리자 > 교사 평가 관리 및 결과 조회 > 교사 평가 결과 조회 및 삭제
	 * 과정명, 교사명, 평가답변(개수)를 DB에서 가져옴
	 * @param cnt 개설과정 개수
	 * @return 과정명,교사명,평가답변이 적힌 데이터들이 한쌍으로 담겨있는 정보
	 */
	public ArrayList<DTO_t_tc_oc_c_A> daoTeacherEvalQuestionResultInfoDelete(int cnt) {

		ArrayList<DTO_t_tc_oc_c_A> list = new ArrayList<DTO_t_tc_oc_c_A>();
		
		
		for(int i = 0; i < cnt; i++) {
		
		String sql = String.format("select oc.opencourse_seq as openCourseNum, rpad(c.name, 40, ' ') as courseName, rpad(t.name, 15, ' ') as teacherName, (SELECT COUNT(*) FROM tblTeacherEval_A tea INNER JOIN tblRegiCourse rc ON tea.regiCourse_seq = rc.regiCourse_seq where rc.openCourse_seq = %d) as answerVariables from tblteacher t inner join tblteachercourse tc on t.teacher_seq = tc.teacher_seq inner join tblopencourse oc on oc.opencourse_seq = tc.opencourse_seq inner join tblcourse c on c.course_seq = oc.course_seq where oc.opencourse_seq = %d", i+1, i+1);
		
			try {
				ResultSet rs = stat.executeQuery(sql);
				
				while(rs.next()) {
					
					DTO_t_tc_oc_c_A t_tc_oc_c = new DTO_t_tc_oc_c_A();
					
					t_tc_oc_c.setOpenCourse_seq(rs.getString("openCourseNum"));
					t_tc_oc_c.setCourseName(rs.getString("courseName"));
					t_tc_oc_c.setTeacherName(rs.getString("teacherName"));
					t_tc_oc_c.setAnswerVariables(rs.getString("answerVariables"));
					
					list.add(t_tc_oc_c);
					
				}
				
			} catch (SQLException e) {
				System.out.println("DAO_AdminFunction클래스 daoTeacherEvalQuestionResultInfoDelete(int cnt) 오류!");
				e.printStackTrace();
			}
		
		}
		
		return list;
	}

	/**
	 * 개설 과정명을 DB에서 가져옴
	 * @param select 개설 과정PK
	 * @return 과정명
	 */
	public String daoCourseName(String select) {

		String sql = "SELECT rpad(c.name,40,' ') as courseName FROM tblOpenCourse oc INNER JOIN tblCourse c ON oc.course_seq = c.course_seq WHERE oc.openCourse_seq = " + select;
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				String courseName = rs.getString("courseName");
				
				return courseName;
			}
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoCourseName(String select) 오류!");
			e.printStackTrace();
		}
		
		return null;
		
	}

	/**
	 * 개설 과정을 담당하고 있는 교사명을 DB에서 가져옴
	 * @param select 개설과정PK
	 * @return 교사명
	 */
	public String daoTeacherName(String select) {

		String sql = "SELECT rpad(t.name,15,' ') as teacherName FROM tblOpenCourse oc INNER JOIN tblCourse c ON oc.course_seq = c.course_seq INNER JOIN tblTeacherCourse tc ON oc.openCourse_seq = tc.openCourse_seq INNER JOIN tblTeacher t ON tc.teacher_seq = t.teacher_seq WHERE oc.openCourse_seq = " + select;
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				String teacherName = rs.getString("teacherName");
				
				return teacherName;
			}
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoTeacherName(String select) 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 객관식 보기를 DB에서 가져옴
	 * @return 객관식 보기
	 */
	public ArrayList<DTO_Example> daoobjectiveFormEx() { // 객관식 질문 한줄로 출력
		
		ArrayList <DTO_Example> objectiveFormlist = new ArrayList<DTO_Example>();
		
		String sql = "SELECT content as con FROM tblExample";
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_Example example = new DTO_Example();
				
				example.setContent(rs.getString("con"));
				
				objectiveFormlist.add(example);
				
			}
			
			return objectiveFormlist;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoobjectiveFormEx() 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 객관식 질문과 해당 질문의 선택한 보기 비율을 DB에서 가져옴
	 * @param select 과정번호
	 * @return 객관식 질문, 해당 질문의 선택한 보기 비율
	 */
	public ArrayList<DTO_TeacherEval_Q> daoObjectiveList(String select) {
		
		//select는 개설과정번호
		
		ArrayList <DTO_TeacherEval_Q> objectiveFormResultlist = new ArrayList<DTO_TeacherEval_Q>();
		
		String sql = "select rpad(question,70,' ') as que , (select round( (select count(*) from tblExample e inner join tblTeacherEval_A tea on e.example_seq = tea.objective_a inner join tblRegiCourse rc on tea.regicourse_seq = rc.regicourse_seq inner join tblTeacherEVal_Q teq on tea.evalq_seq = teq.evalq_seq where e.example_seq = 1 and rc.opencourse_seq = 1 and teq.evalq_seq = ?) / (select count(*) from tblExample e inner join tblteachereval_a tea on e.example_seq = tea.objective_a inner join tblRegiCourse rc on tea.regicourse_seq = rc.regicourse_seq inner join tblTeacherEVal_Q teq on tea.evalq_seq = teq.evalq_seq where rc.opencourse_seq = 1 and teq.evalq_seq = ?) , 3) * 100 from dual) as ratio1, (select round( (select count(*) from tblExample e inner join tblTeacherEval_A tea on e.example_seq = tea.objective_a inner join tblRegiCourse rc on tea.regicourse_seq = rc.regicourse_seq inner join tblTeacherEVal_Q teq on tea.evalq_seq = teq.evalq_seq where e.example_seq = 2 and rc.opencourse_seq = 1 and teq.evalq_seq = ?) / (select count(*) from tblExample e inner join tblteachereval_a tea on e.example_seq = tea.objective_a inner join tblRegiCourse rc on tea.regicourse_seq = rc.regicourse_seq inner join tblTeacherEVal_Q teq on tea.evalq_seq = teq.evalq_seq where rc.opencourse_seq = 1 and teq.evalq_seq = ?) , 3) * 100 from dual) as ratio2 , (select round( (select count(*) from tblExample e inner join tblTeacherEval_A tea on e.example_seq = tea.objective_a inner join tblRegiCourse rc on tea.regicourse_seq = rc.regicourse_seq inner join tblTeacherEVal_Q teq on tea.evalq_seq = teq.evalq_seq where e.example_seq = 3 and rc.opencourse_seq = 1 and teq.evalq_seq = ?) / (select count(*) from tblExample e inner join tblteachereval_a tea on e.example_seq = tea.objective_a inner join tblRegiCourse rc on tea.regicourse_seq = rc.regicourse_seq inner join tblTeacherEVal_Q teq on tea.evalq_seq = teq.evalq_seq where rc.opencourse_seq = 1 and teq.evalq_seq = ?) , 3) * 100 from dual) as ratio3, (select round( (select count(*) from tblExample e inner join tblTeacherEval_A tea on e.example_seq = tea.objective_a inner join tblRegiCourse rc on tea.regicourse_seq = rc.regicourse_seq inner join tblTeacherEVal_Q teq on tea.evalq_seq = teq.evalq_seq where e.example_seq = 4 and rc.opencourse_seq = 1 and teq.evalq_seq = ?) / (select count(*) from tblExample e inner join tblteachereval_a tea on e.example_seq = tea.objective_a inner join tblRegiCourse rc on tea.regicourse_seq = rc.regicourse_seq inner join tblTeacherEVal_Q teq on tea.evalq_seq = teq.evalq_seq where rc.opencourse_seq = 1 and teq.evalq_seq = ?) , 3) * 100 from dual) as ratio4, (select round( (select count(*) from tblExample e inner join tblTeacherEval_A tea on e.example_seq = tea.objective_a inner join tblRegiCourse rc on tea.regicourse_seq = rc.regicourse_seq inner join tblTeacherEVal_Q teq on tea.evalq_seq = teq.evalq_seq where e.example_seq = 5 and rc.opencourse_seq = 1 and teq.evalq_seq = ?) / (select count(*) from tblExample e inner join tblteachereval_a tea on e.example_seq = tea.objective_a inner join tblRegiCourse rc on tea.regicourse_seq = rc.regicourse_seq inner join tblTeacherEVal_Q teq on tea.evalq_seq = teq.evalq_seq where rc.opencourse_seq = 1 and teq.evalq_seq = ?) , 3) * 100 from dual) as ratio5 from tblTeacherEval_Q where type_seq = 2 and evalq_seq = ?";
		
			try {
				
				pstat = conn.prepareStatement(sql);
				
				for(int i = 1; i < 6; i++) {
				
					pstat.setInt(1, i);
					pstat.setInt(2, i);
					pstat.setInt(3, i);
					pstat.setInt(4, i);
					pstat.setInt(5, i);
					pstat.setInt(6, i);
					pstat.setInt(7, i);
					pstat.setInt(8, i);
					pstat.setInt(9, i);
					pstat.setInt(10, i);
					pstat.setInt(11, i);
				
					ResultSet rs = pstat.executeQuery();
					
					while(rs.next()) {
						
						DTO_TeacherEval_Q teq = new DTO_TeacherEval_Q();
						
						teq.setQuestion(rs.getString("que"));
						teq.setRatio1(rs.getString("ratio1"));
						teq.setRatio2(rs.getString("ratio2"));
						teq.setRatio3(rs.getString("ratio3"));
						teq.setRatio4(rs.getString("ratio4"));
						teq.setRatio5(rs.getString("ratio5"));
						
						
						objectiveFormResultlist.add(teq);
						
					}
				}
				
				return objectiveFormResultlist;
				
			} catch (SQLException e) {
				System.out.println("DAO_AdminFunction클래스 daoObjectiveList(String select) 오류!");
				e.printStackTrace();
			}
		return null;
	}

	/**
	 * 주관식 질문을 DB에서 가져옴
	 * @return 주관식 질문
	 */
	public ArrayList<DTO_TeacherEval_Q> daoSubjectiveEx() {

		ArrayList <DTO_TeacherEval_Q> subjectiveEx = new ArrayList<DTO_TeacherEval_Q>();
		
		String sql = "select evalq_seq, rpad(question, 70, ' ') as que from tblTeacherEval_q where type_seq = 1";
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_TeacherEval_Q teq = new DTO_TeacherEval_Q();
				
				teq.setEvalQ_seq(rs.getString("evalq_seq"));
				teq.setQuestion(rs.getString("que"));
				
				subjectiveEx.add(teq);
				
			}
			
			return subjectiveEx;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoSubjectiveEx() 오류!");
			e.printStackTrace();
		}
		
		
		return null;
	}

	/**
	 * 상담요청을 한 학생정보와 상담요청 정보를 DB에서 가져옴
	 * @return 상담요청을 한 학생정보와 상담요청 정보
	 */
	public ArrayList<DTO_request_rc_oc_c_tc_t_stu_A> daoConsultRequestInfoModify() {

ArrayList<DTO_request_rc_oc_c_tc_t_stu_A> infoList = new ArrayList<DTO_request_rc_oc_c_tc_t_stu_A>();
		
		String sql = "SELECT cr.consult_seq as seq , stu.name as studentName, t.name as teacherName, rpad(c.name, 40, ' ') as courseName, stu.tel as studentTel, stu.major as studentMajor, to_char(cr.requestDate,'yyyy-mm-dd') as callRequestDate, rpad(cr.requestContent,70, ' ') as callRequestDetails FROM tblConsultRequest cr INNER JOIN tblRegiCourse rc ON cr.regiCourse_seq = rc.regiCourse_seq INNER JOIN tblOpenCourse oc ON rc.openCourse_seq = oc.openCourse_seq INNER JOIN tblCourse c ON oc.course_seq = c.course_seq INNER JOIN tblTeacherCourse tc ON oc.openCourse_seq = tc.openCourse_seq INNER JOIN tblTeacher t ON tc.teacher_seq = t.teacher_seq INNER JOIN tblStudent stu ON rc.student_seq = stu.student_seq";
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_request_rc_oc_c_tc_t_stu_A info = new DTO_request_rc_oc_c_tc_t_stu_A();
				
				info.setRownum(rs.getString("seq"));
				info.setStudentName(rs.getString("studentName"));
				info.setTeacherName(rs.getString("teacherName"));
				info.setCourseName(rs.getString("courseName"));
				info.setStudentTel(rs.getString("studentTel"));
				info.setStudentMajor(rs.getString("studentMajor"));
				info.setCallRequestDate(rs.getString("callRequestDate"));
				info.setCallRequestDetails(rs.getString("callRequestDetails"));
				
				infoList.add(info);
				
			}
			return infoList;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoConsultRequestInfoModify() 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 요청 내역 > 일괄 조회 및 수정 > 수정
	 * 상담요청 수정하기
	 * @param num 상담요청PK
	 * @param date 수정할 상담요청일
	 * @param content 수정할 상담요청내용
	 * @return 수정완료 1 수정실패 0
	 */
	public int daoConsultRequestModify(int num, String date, String content) {

		String sql = String.format("UPDATE tblConsultRequest SET requestDate = '%s', requestContent = '%s' WHERE consult_seq = %d", date, content, num);
		
		try {
			int result = stat.executeUpdate(sql);
			
			return result;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoConsultRequestModify(int num, String date, String content) 오류!");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 요청 내역 > 일괄 조회 및 수정 > 삭제
	 * 상담요청삭제
	 * @param num 상담요청번호(PK)
	 * @return 삭제완료1 삭제실패 0
	 */
	public int daoConsultRequestDelete(int num) {

		String sql = String.format("DELETE FROM tblConsultRequest WHERE consult_seq = %d", num);
		String sql2 = String.format("delete from tblConsultRecord where consult_seq = %d", num);
		
		try {
			stat.executeUpdate(sql2);
			int result = stat.executeUpdate(sql);
			
			return result;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoConsultRequestDelete(int num) 오류!");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 요청 내역 > 과정별 조회 및 수정
	 * DB에서 과정에 대한 정보를 가져옴
	 * @return 과정정보
	 */
	public ArrayList<DTO_c_oc_r_tc_t_A> daoConsultRequestCourse() {

		ArrayList<DTO_c_oc_r_tc_t_A> list = new ArrayList<DTO_c_oc_r_tc_t_A>();
		
		String sql = "SELECT oc.course_seq as seq, rpad(c.name,40, ' ') as courseName, oc.startDate || '~' || oc.endDate as coureseDuration, rpad(t.name,15,' ') as teacherName, rpad(r.roomName,12,' ') as className FROM tblCourse c INNER JOIN tblOpenCourse oc ON c.course_seq = oc.openCourse_seq INNER JOIN tblRoom r ON oc.room_seq = r.room_seq INNER JOIN tblTeacherCourse tc ON oc.openCourse_seq = tc.openCourse_seq INNER JOIN tblTeacher t ON tc.teacher_seq = t.teacher_seq";
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_c_oc_r_tc_t_A dto = new DTO_c_oc_r_tc_t_A();
				
				dto.setRownum(rs.getString("seq"));
				dto.setCoureseDuration(rs.getString("courseName"));
				dto.setCoureseDuration(rs.getString("coureseDuration"));
				dto.setTeacherName(rs.getString("teacherName"));
				dto.setClassName(rs.getString("className"));
			
				list.add(dto);
			}
			
			return list;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoConsultRequestCourse() 오류!");
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 요청 내역 > 과정별 조회 및 수정 > 선택
	 * DB에서 해당 과정의 교사명을 가져옴
	 * @param select 과정번호(PK)
	 * @return 교사명
	 */
	public String daoConsultRequestCourseTeacherName(String select) {
		
		String sql = "SELECT t.name as teacherName FROM tblTeacher t INNER JOIN tblTeacherCourse tc ON t.teacher_seq = tc.teacher_seq INNER JOIN tblOpenCourse oc ON tc.openCourse_seq = oc.openCourse_seq WHERE oc.openCourse_seq = " + select;
		
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				
				String teacherName = rs.getString("teacherName");
				
				return teacherName;
			}
			
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoConsultRequestCourseTeacherName(String select) 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 요청 내역 > 과정별 조회 및 수정 > 선택
	 * 과정명을 DB에서 가져옴
	 * @param select 과정번호PK
	 * @return 과정명
	 */
	public String daoConsultRequestCourseCourseName(String select) {

String sql = "SELECT rpad(c.name,40,' ') as courseName FROM tblCourse c INNER JOIN tblOpenCourse oc ON c.course_seq = oc.course_seq WHERE oc.openCourse_seq = " + select;
		
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				
				String courseName = rs.getString("courseName");
				
				return courseName;
			}
			
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoConsultRequestCourseCourseName(String select) 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 과정에 대한 상담요청 정보를 DB에서 가져옴
	 * @param select 과정번호PK
	 * @return 과정에 대한 상담요청 정보
	 */
	public ArrayList<DTO_stu_rc_request_oc_A> daoConsultRequestCourseSelect(String select) {
		String sql = "SELECT cr.consult_seq as seq , stu.name as studentName, stu.tel as studentTel, stu.major as studentMajor, to_char(cr.requestDate, 'yyyy-mm-dd') as callRequestDate, rpad(cr.requestContent,70,' ') as callrequestDetails FROM tblStudent stu INNER JOIN tblRegiCourse rc ON stu.student_seq = rc.student_seq INNER JOIN tblConsultRequest cr ON rc.regiCourse_seq = cr.regiCourse_seq INNER JOIN tblOpenCourse oc ON oc.openCourse_seq = rc.openCourse_seq WHERE oc.openCourse_seq = " + select;
		
		ArrayList<DTO_stu_rc_request_oc_A> list = new ArrayList<DTO_stu_rc_request_oc_A>();
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_stu_rc_request_oc_A dto = new DTO_stu_rc_request_oc_A();
				
				dto.setRownum(rs.getString("seq"));
				dto.setStudentName(rs.getString("studentName"));
				dto.setStudentTel(rs.getString("studentTel"));
				dto.setStudentMajor(rs.getString("studentMajor"));
				dto.setCallRequestDate(rs.getString("callRequestDate"));
				dto.setCallrequestDetails(rs.getString("callrequestDetails"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoConsultRequestCourseSelect(String select) 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 요청 내역 > 과정별 조회 및 수정 > > 선택 > 수정하기
	 * 상담요청 수정하기
	 * @param num 상담요청 번호 PK
	 * @param date 변경할 상담요청일
	 * @param content 변경할 상담요청내용
	 * @return 수정완료 1 수정실패 0
	 */
	public int daoConsultRequestCourseModify(String num, String date, String content) {
		
		String sql = "UPDATE tblConsultRequest SET requestDate = '" + date + "', requestContent = '" + content + "' WHERE consult_seq = " + num;
		
		try {
			
			int result = stat.executeUpdate(sql);
			
			return result;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoConsultRequestCourseModify(String num, String date, String content) 오류!");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 요청 내역 > 과정별 조회 및 수정 > 삭제하기
	 * 상담요청 삭제하기
	 * @param num 상담요청번호 PK
	 * @return 삭제완료 1 삭제실패 0
	 */
	public int daoConsultRequestCourseDelete(String num) {

		String sql = "DELETE FROM tblConsultRequest WHERE consult_seq = " + num;
		String sql2 = "delete from tblconsultrecord where consult_seq = " +num;
		
		try {
			stat.executeUpdate(sql2);
			int result = stat.executeUpdate(sql);
			
			return result;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoConsultRequestCourseDelete(String num) 오류!");
			e.printStackTrace();
		}
		
		return 0;
	}


	/**
	 * 입력한 상담요청번호에 관한 과정명을 DB에서 가져오기
	 * @param choice 상담요청번호
	 * @return 상담요청에 관한 과정명
	 */
	public String sConsultRequestStudentNameInfoCourseName(String choice) {
		
		String sql = "SELECT rpad(c.name,40,' ') as courseName FROM tblCourse c INNER JOIN tblOpenCourse oc ON c.course_seq = oc.course_seq INNER JOIN tblRegiCourse rc ON oc.openCourse_seq = rc.openCourse_seq INNER JOIN tblConsultRequest cr ON rc.regiCourse_seq = cr.regiCourse_seq WHERE cr.consult_seq = " + choice;
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				String courseName = rs.getString("courseName");
				return courseName;
			}
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 sConsultRequestStudentNameInfoCourseName(String choice) 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * DB에서 찾고자 하는 학생명에 대한 상담요청정보와 학생 정보를 가져옴
	 * @param name 찾고자 하는 학생명
	 * @return
	 */
	public ArrayList<DTO_request_rc_oc_c_stu_A> daoConsultRequestStudentName(String name) {
		
String sql = "SELECT cr.consult_seq, stu.name as studentName, stu.tel as studentTel, stu.major as studentMajor, to_char(cr.requestDate, 'yyyy-mm-dd') as callrequestDate, rpad(cr.requestContent,70,' ') as callrequestDetails FROM tblConsultRequest cr INNER JOIN tblRegiCourse rc ON cr.regiCourse_seq = rc.regiCourse_seq INNER JOIN tblOpenCourse oc ON rc.openCourse_seq = oc.openCourse_seq INNER JOIN tblCourse c ON oc.course_seq = c.course_seq INNER JOIN tblStudent stu ON stu.student_seq = rc.student_seq WHERE stu.name = '" + name +"'";
		
		ArrayList<DTO_request_rc_oc_c_stu_A> list = new ArrayList<DTO_request_rc_oc_c_stu_A>();
		
		try {
			
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_request_rc_oc_c_stu_A dto = new DTO_request_rc_oc_c_stu_A();
				
				dto.setconsult_Seq(rs.getString("consult_seq"));
				dto.setStudentName(rs.getString("studentName"));
				dto.setStudentTel(rs.getString("studentTel"));
				dto.setStudentMajor(rs.getString("studentMajor"));
				dto.setCallrequestDate(rs.getString("callrequestDate"));
				dto.setCallrequestDetails(rs.getString("callrequestDetails"));
				
				list.add(dto);
				
			}
			
			return list;
			
			
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoConsultRequestStudentName(String name) 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 입력한 주민번호(뒷자리)와 일치하는 상담요청정보와 학생정보를 DB에서 가져옴
	 * @param pw 입력한 주민번호(뒷자리)
	 * @return 입력한 주민번호(뒷자리)와 일치하는 상담요청정보와 학생정보가 담긴 리스트
	 */
	public ArrayList<DTO_request_rc_oc_c_stu_A> daoConsultRequestStudentPw(String pw) {
		
		String sql = "SELECT cr.consult_seq, rpad(stu.name,15,' ') as studentName, stu.tel as studentTel, rpad(stu.major,25,' ') as studentMajor, to_char(cr.requestDate, 'yyyy-mm-dd') as callrequestDate, rpad(cr.requestContent,70,' ') as callrequestDetails FROM tblConsultRequest cr INNER JOIN tblRegiCourse rc ON cr.regiCourse_seq = rc.regiCourse_seq INNER JOIN tblOpenCourse oc ON rc.openCourse_seq = oc.openCourse_seq INNER JOIN tblCourse c ON oc.course_seq = c.course_seq INNER JOIN tblStudent stu ON stu.student_seq = rc.student_seq WHERE stu.pw = '" + pw +"'";
		
		ArrayList<DTO_request_rc_oc_c_stu_A> list = new ArrayList<DTO_request_rc_oc_c_stu_A>();
		
		try {
			
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_request_rc_oc_c_stu_A dto = new DTO_request_rc_oc_c_stu_A();
				
				dto.setconsult_Seq(rs.getString("consult_seq"));
				dto.setStudentName(rs.getString("studentName"));
				dto.setStudentTel(rs.getString("studentTel"));
				dto.setStudentMajor(rs.getString("studentMajor"));
				dto.setCallrequestDate(rs.getString("callrequestDate"));
				dto.setCallrequestDetails(rs.getString("callrequestDetails"));
				
				list.add(dto);
				
			}
			
			return list;
			
			
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoConsultRequestStudentPw(String pw) 오류!");
			e.printStackTrace();
		}
		
		
		return null;
	}

	/**
	 * 입력한 전화번호와 일치하는 학생정보, 상담요청 정보를 DB에서 가져옴
	 * @param tel 입력한 전화번호
	 * @return 입력한 전화번호와 일치하는 학생정보, 상담요청 정보가 담긴 리스트
	 */
	public ArrayList<DTO_request_rc_oc_c_stu_A> daoConsultRequestStudentTel(String tel) {

		String sql = "SELECT cr.consult_seq, stu.name as studentName, stu.tel as studentTel, stu.major as studentMajor, to_char(cr.requestDate, 'yyyy-mm-dd') as callrequestDate, rpad(cr.requestContent,70,' ') as callrequestDetails FROM tblConsultRequest cr INNER JOIN tblRegiCourse rc ON cr.regiCourse_seq = rc.regiCourse_seq INNER JOIN tblOpenCourse oc ON rc.openCourse_seq = oc.openCourse_seq INNER JOIN tblCourse c ON oc.course_seq = c.course_seq INNER JOIN tblStudent stu ON stu.student_seq = rc.student_seq WHERE stu.tel = '" + tel +"'";
		
		ArrayList<DTO_request_rc_oc_c_stu_A> list = new ArrayList<DTO_request_rc_oc_c_stu_A>();
		
		try {
			
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_request_rc_oc_c_stu_A dto = new DTO_request_rc_oc_c_stu_A();
				
				dto.setconsult_Seq(rs.getString("consult_seq"));
				dto.setStudentName(rs.getString("studentName"));
				dto.setStudentTel(rs.getString("studentTel"));
				dto.setStudentMajor(rs.getString("studentMajor"));
				dto.setCallrequestDate(rs.getString("callrequestDate"));
				dto.setCallrequestDetails(rs.getString("callrequestDetails"));
				
				list.add(dto);
				
			}
			
			return list;
			
			
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoConsultRequestStudentTel(String tel) 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 요청 내역 > 학생별 조회 및 수정 > 등록일
	 * 입력한 등록일과 일치하는 학생들의 정보와 상담요청 정보를 DB에서 가져옴
	 * @param regdate 입력한 등록일
	 * @return 입력한 등록일과 일치하는 학생들의 정보와 상담요청 정보
	 */
	public ArrayList<DTO_request_rc_oc_c_stu_A> daoConsultRequestStudentRegdate(String regdate) {

		String sql = "SELECT cr.consult_seq, rpad(stu.name,15,' ') as studentName, stu.tel as studentTel, rpad(stu.major,25,' ') as studentMajor, to_char(cr.requestDate, 'yyyy-mm-dd') as callrequestDate, rpad(cr.requestContent,70,' ') as callrequestDetails FROM tblConsultRequest cr INNER JOIN tblRegiCourse rc ON cr.regiCourse_seq = rc.regiCourse_seq INNER JOIN tblOpenCourse oc ON rc.openCourse_seq = oc.openCourse_seq INNER JOIN tblCourse c ON oc.course_seq = c.course_seq INNER JOIN tblStudent stu ON stu.student_seq = rc.student_seq WHERE stu.regidate = '" + regdate +"'";
		
		ArrayList<DTO_request_rc_oc_c_stu_A> list = new ArrayList<DTO_request_rc_oc_c_stu_A>();
		
		try {
			
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_request_rc_oc_c_stu_A dto = new DTO_request_rc_oc_c_stu_A();
				
				dto.setconsult_Seq(rs.getString("consult_seq"));
				dto.setStudentName(rs.getString("studentName"));
				dto.setStudentTel(rs.getString("studentTel"));
				dto.setStudentMajor(rs.getString("studentMajor"));
				dto.setCallrequestDate(rs.getString("callrequestDate"));
				dto.setCallrequestDetails(rs.getString("callrequestDetails"));
				
				list.add(dto);
				
			}
			
			return list;
			
			
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoConsultRequestStudentRegdate(String regdate) 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 요청 내역 > 학생별 조회 및 수정 > 학과
	 * 입력한 학과와 일치하는 학생정보와 상담요청 정보를 DB에서 가져옴
	 * @param major 입력한 학과
	 * @return 입력한 학과와 일치하는 학생정보와 상담요청 정보
	 */
	public ArrayList<DTO_request_rc_oc_c_stu_A> daoConsultRequestStudentMajor(String major) {

		String sql = "SELECT cr.consult_seq, rpad(stu.name,15,' ') as studentName, stu.tel as studentTel, rpad(stu.major,25,' ') as studentMajor, to_char(cr.requestDate,'yyyy-mm-dd') as callrequestDate, rpad(cr.requestContent,70,' ') as callrequestDetails FROM tblConsultRequest cr INNER JOIN tblRegiCourse rc ON cr.regiCourse_seq = rc.regiCourse_seq INNER JOIN tblOpenCourse oc ON rc.openCourse_seq = oc.openCourse_seq INNER JOIN tblCourse c ON oc.course_seq = c.course_seq INNER JOIN tblStudent stu ON stu.student_seq = rc.student_seq WHERE stu.major = '" + major +"'";
		
		ArrayList<DTO_request_rc_oc_c_stu_A> list = new ArrayList<DTO_request_rc_oc_c_stu_A>();
		
		try {
			
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_request_rc_oc_c_stu_A dto = new DTO_request_rc_oc_c_stu_A();
				
				dto.setconsult_Seq(rs.getString("consult_seq"));
				dto.setStudentName(rs.getString("studentName"));
				dto.setStudentTel(rs.getString("studentTel"));
				dto.setStudentMajor(rs.getString("studentMajor"));
				dto.setCallrequestDate(rs.getString("callrequestDate"));
				dto.setCallrequestDetails(rs.getString("callrequestDetails"));
				
				list.add(dto);
				
			}
			
			return list;
			
			
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoConsultRequestStudentRegdate(String regdate) 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 일지 내역 > 일괄 조회
	 * 상담일지 정보를 DB에서 가져옴
	 * @return 상담일지 정보
	 */
	public ArrayList<DTO_record_request_rc_stu_oc_tc_t_A> daoConsultResultInfo() {

		ArrayList<DTO_record_request_rc_stu_oc_tc_t_A> list = new ArrayList<DTO_record_request_rc_stu_oc_tc_t_A>();
		
		String sql = "SELECT record.record_seq, to_char(record.recordDate, 'yyyy-mm-dd') as consultationDate, t.name as teacherName, stu.name as studentName, request.requestContent as callrequestDetails, record.recordContent as contentsConsultation FROM tblConsultRecord record INNER JOIN tblConsultRequest request ON record.consult_seq = request.consult_seq INNER JOIN tblRegiCourse rc ON request.regiCourse_seq = rc.regiCourse_seq INNER JOIN tblStudent stu ON rc.student_seq = stu.student_seq INNER JOIN tblOpenCourse oc ON rc.openCourse_seq = oc.openCourse_seq INNER JOIN tblTeacherCourse tc ON oc.openCourse_seq = tc.openCourse_seq INNER JOIN tblTeacher t ON tc.teacher_seq = t.teacher_seq order by request.consult_seq";
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_record_request_rc_stu_oc_tc_t_A dto = new DTO_record_request_rc_stu_oc_tc_t_A();
				
				dto.setRecord_seq(rs.getString("record_seq"));
				dto.setConsultationDate(rs.getString("consultationDate"));
				dto.setTeacherName(rs.getString("teacherName"));
				dto.setStudentName(rs.getString("studentName"));
				dto.setCallrequestDetails(rs.getString("callrequestDetails"));
				dto.setContentsConsultation(rs.getString("contentsConsultation"));
				
				list.add(dto);
				
			}
			
			return list;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoConsultResultInfo() 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 상담일지 수정하기
	 * @param num 상담일지 번호PK
	 * @param date 변경할 상담일자
	 * @param content 변경할 상담내용
	 * @return 수정완료 1 수정실패 0
	 */
	public int daoConsultResultModify(String num, String date, String content) {

		String sql = "UPDATE tblConsultRecord SET recordDate = '" + date + "', recordContent = '" + content + "' WHERE record_seq = " + num;
		
		try {
			int result = stat.executeUpdate(sql);
			
			return result;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoConsultResultModify(String num, String date, String content) 오류!");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 일지 내역 > 일괄 조회 > 삭제
	 * 상담일지 삭제하기
	 * @param num 상담일지번호 PK
	 * @return 삭제완료 1 삭제실패 0
	 */
	public int daoConsultResultDelete(int num) {
		
		String sql = "DELETE FROM tblConsultRecord WHERE record_seq = " + num;
		
		try {
			int result = stat.executeUpdate(sql);
			
			return result;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoConsultResultDelete(int num) 오류!");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 과정에 대한 정보를 DB에서 가져옴
	 * @return 과정 정보
	 */
	public ArrayList<DTO_c_oc_r_tc_t_A> daoConsultResultInfoCourse() {

		String sql = "select oc.opencourse_seq, rpad(c.name,40,' ') as courseName, oc.startdate || '~' || oc.enddate as courseDuration, t.name as teacherName, r.roomName as className from tblTeacher t inner join tblTeacherCourse tc on t.teacher_seq = tc.teacherCourse_seq inner join tblOpenCourse oc on tc.openCourse_seq = oc.openCourse_seq inner join tblCourse c on oc.course_seq = c.course_seq inner join tblRoom r on r.room_seq = oc.room_seq";
		
		ArrayList<DTO_c_oc_r_tc_t_A> list = new ArrayList<DTO_c_oc_r_tc_t_A>();
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_c_oc_r_tc_t_A dto = new DTO_c_oc_r_tc_t_A();
				
				dto.setOpencourse_seq(rs.getString("opencourse_seq"));
				dto.setCourseName(rs.getString("courseName"));
				dto.setCoureseDuration(rs.getString("courseDuration"));
				dto.setTeacherName(rs.getString("teacherName"));
				dto.setClassName(rs.getString("className"));
				
				list.add(dto);
				
			}
			
			return list;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoConsultResultInfoCourse() 오류!");
			e.printStackTrace();
		}
		
		
		return null;
	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 일지 내역 > 교사별 조회 및 수정 > 선택
	 * 상담일지에 대한 정보를 DB에서 가져옴
	 * @param choice 선택한 교사번호PK
	 * @return 상담일지 정보가 담긴 리스트
	 */
	public ArrayList<DTO_record_request_rc_stu_oc_tc_t_A> daoConsultResultInfoCourseViewModify(String choice) {

		String sql = "select record.record_seq, to_char(record.recorddate,'yyyy-mm-dd') as consultationDate, t.name as teacherName,"
				+ " stu.name as studentName, request.requestcontent as callrequestDetails, "
				+ "record.recordcontent as contentsConsultation "
					+ "from tblConsultRecord record "
					+ "inner join tblConsultRequest request "
					+ "on record.consult_seq = request.consult_seq "
					+ "inner join tblRegiCourse rc "
					+ "on request.regiCourse_seq = rc.regiCourse_seq "
					+ "inner join tblStudent stu "
					+ "on rc.student_seq = stu.student_seq "
					+ "inner join tblOpenCourse oc "
					+ "on oc.openCourse_seq = rc.openCourse_seq "
					+ "inner join tblTeacherCourse tc "
					+ "on oc.openCourse_seq = tc.openCourse_seq "
					+ "inner join tblTeacher t "
					+ "on tc.teacher_seq = t.teacher_seq "
					+ "where oc.opencourse_seq = " + choice;
		
		ArrayList<DTO_record_request_rc_stu_oc_tc_t_A> list = new ArrayList<DTO_record_request_rc_stu_oc_tc_t_A>();
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_record_request_rc_stu_oc_tc_t_A dto = new DTO_record_request_rc_stu_oc_tc_t_A();
				
				dto.setRecord_seq(rs.getString("record_seq"));
				dto.setConsultationDate(rs.getString("consultationDate"));
				dto.setTeacherName(rs.getString("teacherName"));
				dto.setStudentName(rs.getString("studentName"));
				dto.setCallrequestDetails(rs.getString("callrequestDetails"));
				dto.setContentsConsultation(rs.getString("contentsConsultation"));
				
				list.add(dto);
				
			}
			
			return list;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoConsultResultInfoCourseViewModify(String choice) 오류!");
			e.printStackTrace();
		}
		
		return null;
	}


	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 일지 내역 > 학생별 조회 및 수정 > 학생명
	 * 입력한 학생명과 일치하는 상담일지 정보를 가져옴
	 * @param name 입력한 학생명
	 * @return 입력한 학생명과 일치하는 상담일지 정보
	 */
	public ArrayList<DTO_record_request_rc_stu_oc_tc_t_A> daoConsultRecordStudentName(String name) {

		ArrayList<DTO_record_request_rc_stu_oc_tc_t_A> list = new ArrayList<DTO_record_request_rc_stu_oc_tc_t_A>();
		
		String sql = "SELECT record.record_seq, to_char(record.recordDate,'yyyy-mm-dd') as consultationDate, t.name as teacherName, stu.name as studentName, request.requestContent as callRequestDetails, record.recordcontent as contentsConsultation FROM tblConsultRecord record INNER JOIN tblConsultRequest request ON record.consult_seq = request.consult_seq INNER JOIN tblRegiCourse rc ON request.regiCourse_seq = rc.regiCourse_seq INNER JOIN tblStudent stu ON rc.student_seq = stu.student_seq INNER JOIN tblOpenCourse oc ON oc.openCourse_seq = rc.openCourse_seq INNER JOIN tblTeacherCourse tc ON oc.openCourse_seq = tc.openCourse_seq INNER JOIN tblTeacher t ON tc.teacher_seq = t.teacher_seq WHERE stu.name = '" + name + "' order by request.consult_seq";
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_record_request_rc_stu_oc_tc_t_A dto = new DTO_record_request_rc_stu_oc_tc_t_A();
				
				dto.setRecord_seq(rs.getString("record_seq"));
				dto.setConsultationDate(rs.getString("consultationDate"));
				dto.setTeacherName(rs.getString("teacherName"));
				dto.setStudentName(rs.getString("studentName"));
				dto.setCallrequestDetails(rs.getString("callRequestDetails"));
				dto.setContentsConsultation(rs.getString("contentsConsultation"));
				
				list.add(dto);
				
			}
			
			return list;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoConsultRecordStudentName(String name) 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 관리자 > 상담일지 관리 및 조회 > 상담 일지 내역 > 학생별 조회 및 수정 > 주민번호(뒷자리)
	 * 입력한 주민번호(뒷자리)와 일치하는 상담일지 정보를 DB에서 가져옴
	 * @param pw 입력한 주민번호(뒷자리)
	 * @return 상담일지 정보
	 */
	public ArrayList<DTO_record_request_rc_stu_oc_tc_t_A> daoConsultRecordStudentPw(String pw) {

		ArrayList<DTO_record_request_rc_stu_oc_tc_t_A> list = new ArrayList<DTO_record_request_rc_stu_oc_tc_t_A>();
		
		String sql = "SELECT record.record_seq, to_char(record.recordDate,'yyyy-mm-dd') as consultationDate"
				+ ", t.name as teacherName, stu.name as studentName"
				+ ", request.requestContent as callRequestDetails"
				+ ", record.recordcontent as contentsConsultation "
					+ "FROM tblConsultRecord record "
					+ "INNER JOIN tblConsultRequest request "
					+ "ON record.consult_seq = request.consult_seq "
					+ "INNER JOIN tblRegiCourse rc "
					+ "ON request.regiCourse_seq = rc.regiCourse_seq "
					+ "INNER JOIN tblStudent stu "
					+ "ON rc.student_seq = stu.student_seq "
					+ "INNER JOIN tblOpenCourse oc "
					+ "ON oc.openCourse_seq = rc.openCourse_seq "
					+ "INNER JOIN tblTeacherCourse tc "
					+ "ON oc.openCourse_seq = tc.openCourse_seq "
					+ "INNER JOIN tblTeacher t "
					+ "ON tc.teacher_seq = t.teacher_seq "
						+ "WHERE stu.pw = '" + pw + "' order by request.consult_seq" ;
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_record_request_rc_stu_oc_tc_t_A dto = new DTO_record_request_rc_stu_oc_tc_t_A();
				
				dto.setRecord_seq(rs.getString("record_seq"));
				dto.setConsultationDate(rs.getString("consultationDate"));
				dto.setTeacherName(rs.getString("teacherName"));
				dto.setStudentName(rs.getString("studentName"));
				dto.setCallrequestDetails(rs.getString("callRequestDetails"));
				dto.setContentsConsultation(rs.getString("contentsConsultation"));
				
				list.add(dto);
				
			}
			
			return list;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoConsultRecordStudentPw(String pw) 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 입력한 학과에 해당하는 상담일지 정보를 DB에서 가져옴
	 * @param major 입력한 학과
	 * @return 입력한 학과에 해당하는 상담일지 정보
	 */
	public ArrayList<DTO_record_request_rc_stu_oc_tc_t_A> daoConsultRecordStudentMajor(String major) {
		ArrayList<DTO_record_request_rc_stu_oc_tc_t_A> list = new ArrayList<DTO_record_request_rc_stu_oc_tc_t_A>();
		
		String sql = "SELECT record.record_seq, to_char(record.recordDate,'yyyy-mm-dd') as consultationDate"
				+ ", t.name as teacherName, stu.name as studentName, request.requestContent as callRequestDetails"
				+ ", record.recordcontent as contentsConsultation "
				+ "FROM tblConsultRecord record "
				+ "INNER JOIN tblConsultRequest request "
				+ "ON record.consult_seq = request.consult_seq "
				+ "INNER JOIN tblRegiCourse rc "
				+ "ON request.regiCourse_seq = rc.regiCourse_seq "
				+ "INNER JOIN tblStudent stu "
				+ "ON rc.student_seq = stu.student_seq "
				+ "INNER JOIN tblOpenCourse oc "
				+ "ON oc.openCourse_seq = rc.openCourse_seq "
				+ "INNER JOIN tblTeacherCourse tc "
				+ "ON oc.openCourse_seq = tc.openCourse_seq "
				+ "INNER JOIN tblTeacher t "
				+ "ON tc.teacher_seq = t.teacher_seq "
				+ "WHERE stu.major = '" + major + "' order by request.consult_seq";
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_record_request_rc_stu_oc_tc_t_A dto = new DTO_record_request_rc_stu_oc_tc_t_A();
				
				dto.setRecord_seq(rs.getString("record_seq"));
				dto.setConsultationDate(rs.getString("consultationDate"));
				dto.setTeacherName(rs.getString("teacherName"));
				dto.setStudentName(rs.getString("studentName"));
				dto.setCallrequestDetails(rs.getString("callRequestDetails"));
				dto.setContentsConsultation(rs.getString("contentsConsultation"));
				
				list.add(dto);
				
			}
			
			return list;
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoConsultRecordStudentMajor(String major) 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 주관식 문제에 대한 답변들을 DB에서 가져옴
	 * @param choice 선택한 주관식PK
	 * @param select 선택한 수강신청 PK
	 * @return
	 */
	public ArrayList<DTO_TeacherEval_A> daoGood(String choice, String select) {
		
		ArrayList<DTO_TeacherEval_A> list = new ArrayList<DTO_TeacherEval_A>();
		
		String sql = "select evala_seq, rpad(subjective_a,500,' ') as sub from tblTeacherEval_A tea inner join tblRegiCourse rc on tea.regiCourse_seq = rc.regiCourse_seq where evalq_seq = " + choice + " and rc.openCourse_seq = " + select;
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				
				DTO_TeacherEval_A dto = new DTO_TeacherEval_A();
				
				dto.setEvalA_seq(rs.getString("evala_seq"));
				dto.setSubjective_A(rs.getString("sub"));
				
				list.add(dto);
				
			}
			return list;
			
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daoGood(String choice) 오류!");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 질문지를 DB에서 들고옴
	 * @param choice 선택한 유형번호
	 * @return 질문지
	 */
	public String daodescriptive(String choice) {
		
		String sql = "select question from tblteachereval_q where evalq_seq = " + choice;
		
		try {
			ResultSet rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				String descriptive = rs.getString("question");
				
				return descriptive;
			}
			
		} catch (SQLException e) {
			System.out.println("DAO_AdminFunction클래스 daodescriptive(String choice) 오류!");
			e.printStackTrace();
		}
		
		return null;
	}









	
	
	
	
}
