package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Admin.DBUtil;
import DTO_admin.DTO;
import DTO_admin.DTO2;
/*
 *admin db연결
 */
public class DAO_A {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
/*
 * DAO_A 생성자
 */
	public DAO_A() {

		try {

			DBUtil util = new DBUtil();
			this.conn = util.connect();
			this.stat = conn.createStatement();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DAO.Constructor");
		}

	}
/*
 * 연결 종료 미종료 여부 확인을 위한 메소드
 */
	public boolean isConnected() {
		try {
			return !this.conn.isClosed();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void close() {
		try {

			this.conn.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

/*
 * 교사 정보 상세보기	
 */
	public ArrayList<DTO> list() {
	
		try {
			String sql = "SELECT teacher_seq,rpad(name,15,' ') as teacherName, pw, tel,(SELECT LISTAGG(s.name, ',') WITHIN GROUP (ORDER BY s.name) FROM tblTeacher t INNER JOIN tblAvlSubject a ON t.teacher_seq = a.teacher_seq INNER JOIN tblSubject s ON a.subject_seq = s.subject_seq )as tAvlSubject FROM tblTeacher";
			ResultSet rs = stat.executeQuery(sql);

			ArrayList<DTO> list = new ArrayList<DTO>();

			while (rs.next()) {
				DTO dto = new DTO();
				dto.setTeacher_seq(rs.getString("teacher_seq"));
				dto.setName(rs.getString("teacherName"));
				dto.setPw(rs.getString("pw"));
				dto.setTel(rs.getString("tel"));
				dto.settAvlSubject(rs.getString("tAvlSubject"));
				list.add(dto);
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}
/*
 * 교사 정보추가하기
 */
	public int add(DTO dto) {
		String sql = "INSERT INTO tblTeacher (teacher_seq, name, pw, tel)" + 
				"    VALUES (teacher_seq.nextval, ?, ?, ?)";
		
		try {
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getTel());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {

			System.out.println(e.toString());
		}
		
		return 0;
	}
/*
 * 교사정보 불러오기
 */

	public DTO get(String seq) {
		try {
			
			
			String sql = "select rpad(name,15,' ') as teacherName, pw, tel from tblTeacher  WHERE teacher_seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			
			ResultSet rs = pstat.executeQuery();
			
			DTO dto = new DTO();//복사용
			
			if (rs.next()) {
				dto.setName(rs.getString("teacherName"));
				dto.setPw(rs.getString("pw"));
				dto.setTel(rs.getString("tel"));
				
				
				return dto;
			}
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return null;
	}
/*
 * 교사정보 수정하기
 */
	public int edit(DTO dto) {
		try {
		String sql = "UPDATE tblTeacher SET name = ?, pw = ?, tel = ? WHERE teacher_seq = ?";
		pstat = conn.prepareStatement(sql);
		pstat.setString(1, dto.getName());
		pstat.setString(2, dto.getPw());
		pstat.setString(3, dto.getTel());
		pstat.setString(4, dto.getTeacher_seq());
		
		
		return pstat.executeUpdate();
	
	} catch (Exception e) {
		System.out.println(e.toString());
	}
		return 0;
	}
/*
 * 교사정보 삭제하기
 */

	public int del(String seq) {
		try {
			
			//1. tblTeacherCourse where teacher_seq = ?
			//2. tblAvlSubject where teacher_seq = ?
			String sql = "DELETE FROM tblAvlSubject where teacher_seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			pstat.executeUpdate();			
			
			
			String sql1 = "DELETE FROM tblTeacherCourse where teacher_seq = ?";
			
			pstat = conn.prepareStatement(sql1);
			pstat.setString(1, seq);
			
			pstat.executeUpdate();
			
			pstat = conn.prepareStatement(sql1);
			
			
			String sql2 = "DELETE FROM tblTeacher WHERE teacher_seq = ?";
			
			pstat = conn.prepareStatement(sql2);
			pstat.setString(1, seq);
			
			return pstat.executeUpdate();			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return 0;
	}
	
/*
 * 교사 정보 상세보기
 */
	public ArrayList<DTO2> detail(String sel) {
		
		try {
			
			
			String sql = "select distinct (t.teacher_seq) as teacher_num ,rpad(t.name,15,' ') as teachername, rpad(c.name,40,' ') as coursename, (oc.startdate || '~' || oc.enddate) as courseperiod, rpad(r.roomname,12,' ') as className,  s.name||s.period as jungbo from tblteacher t inner join tblteachercourse tc on t.teacher_seq = tc.teacher_seq inner join tblOpenCourse oc on tc.openCourse_seq = oc.openCourse_seq inner join tblCourse c on c.course_seq = oc.course_seq inner join tblAvlSubject als on t.teacher_seq = als.teacher_seq inner join tblSubject s on s.subject_seq = als.subject_seq inner join tblRoom r on r.room_seq = oc.room_seq where t.teacher_seq =?";
			
			pstat = conn.prepareStatement(sql);
			
			
			pstat.setString(1, sel);
			
			
			ResultSet rs = pstat.executeQuery();
			
			ArrayList<DTO2> list = new ArrayList<DTO2>();
				
			while (rs.next()) {
				
				DTO2 dto2 = new DTO2();//복사용
				
				dto2.setTeacher_seq(rs.getString("teacher_num"));
				dto2.setCoursename(rs.getString("coursename"));
				dto2.setCourseperiod(rs.getString("courseperiod"));
				dto2.setJungbo(rs.getString("jungbo"));
				dto2.setTeachername(rs.getString("teachername"));
				dto2.setRoomname(rs.getString("className"));

				
				list.add(dto2);
			}
			
			return list;
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return null;
	
	}
		
}
