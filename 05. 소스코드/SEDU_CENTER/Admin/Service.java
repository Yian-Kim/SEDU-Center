package Admin;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.DAO_A;
import DTO_admin.DTO;
import DTO_admin.DTO2;

public class Service implements IService {

	private View view;
	private Scanner scan;
	
	public Service() {
		
		DAO_A dao = new DAO_A();
		scan = new Scanner(System.in);
		view=new View();
	}

	@Override
	public void add() {
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("\t\t\t\t\t\t1. 관리자 – 1. 교사 계정 관리 - a. 교사 정보 등록");
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.print("\t\t\t\t교사명:");
		String name = scan.nextLine();
		name = name.replace("'", "''");
		
		System.out.print("\t\t\t\t주민번호(뒷자리):");
		String pw = scan.nextLine();
		pw = pw.replace("'", "''");
		
		System.out.print("\t\t\t\t연락처:");
		String tel = scan.nextLine();
		tel = tel.replace("'", "''");
		
		
		//1단계 다오포장
		DAO_A dao = new DAO_A();
		
		//2단계 DTO에게 할일위임
		DTO dto = new DTO();
		dto.setName(name);
		dto.setPw(pw);
		dto.setTel(tel);
		
		int result = dao.add(dto);
		
		dao.close();
		if(result ==1) {
			System.out.println("\t\t\t\t작성완료");
		}else {
			System.out.println("\t\t\t\t작성실패");
		}
		view.pause();
	}


	@Override
	public ArrayList<DTO> list() {
		
		DAO_A dao = new DAO_A();
	
		ArrayList<DTO> list = dao.list();
		
		return list;

	}

	@Override
	public void edit() {
		DAO_A dao = new DAO_A();
		
		//수정할 메모를 선택하기 위한 목록 가져오기
		ArrayList<DTO> list = dao.list();
		
		view.edit();
		
		for (DTO dto : list) {
			System.out.printf("\t\t\t\t%s\t%s\t%s\t\t%s\n"
					, dto.getTeacher_seq()
					, dto.getName()
					, dto.getPw()
					, dto.getTel());
		}
		
		
		
		System.out.print("\t\t\t\t수정할 번호: ");
		String seq = scan.nextLine();
		
		
		DTO dto = dao.get(seq); //메모 1건(= 레코드 1개 = DTO 1개)
		
		
		
		String name = "";
		String pw = "";
		String tel = "";
		
		if (dto != null) {
			name = dto.getName();
			pw = dto.getPw();
			tel = dto.getTel();
		}
		
		
		System.out.println("\t\t\t\t기존 이름: " + name);
		System.out.print("\t\t\t\t새로운 이름: ");
		String temp = scan.nextLine();
		
		if (!temp.equals("")) { //수정
			name = temp;//사용자가 입력한 이름으로 교환
		}
		
		
		System.out.println("\t\t\t\t기존 비밀번호: " + pw);
		System.out.print("\t\t\t\t새로운 비밀번호: ");
		temp = scan.nextLine();
		
		if (!temp.equals("")) {
			pw = temp;//사용자가 입력한 메모로 교환
		}
		
		
		
		System.out.println("\t\t\t\t기존 전화번호: " + tel);
		System.out.print("\t\t\t\t새로운 전화번호: ");
		temp = scan.nextLine();
		
		if (!temp.equals("")) {
			tel = temp;//사용자가 입력한 메모로 교환
		}
		
		
		dto = new DTO();
		dto.setTeacher_seq(seq);//수정할 번호(where)
		dto.setName(name);
		dto.setPw(pw);
		dto.setTel(tel);
		
		int result = dao.edit(dto);
		
		if (result == 1) {
			System.out.println("\t\t\t\t수정 완료");
		} else {
			System.out.println("\t\t\t\t수정 실패");
		}
		
		view.pause();
		
	
	}

	@Override
	public void del() {
		
		view.delete();
		
		DAO_A dao = new DAO_A();
		
		
		ArrayList<DTO> list = dao.list();
		
		for (DTO dto : list) {
			System.out.printf("\t\t\t\t%s\t%s\t%s\t\t%s\n"
					, dto.getTeacher_seq()
					, dto.getName()
					, dto.getPw()
					, dto.getTel());
		}
		
		
		
		System.out.print("\t\t\t\t삭제할 번호: ");
		String seq = scan.nextLine();
		
		
		int result = dao.del(seq);
		
		if (result == 1) {
			System.out.println("\t\t\t\t삭제 성공");
		} else {
			System.out.println("\t\t\t\t삭제 실패");
		}
		
		
		
		dao.close();
		view.pause();
		
	}

	@Override
	public void detail(String sel) {
		
		DAO_A dao = new DAO_A();
		
		ArrayList<DTO2> list = dao.detail(sel);
		
		view.vTeacherDetails(list);
		
		
		
	}
		
		
	

}
