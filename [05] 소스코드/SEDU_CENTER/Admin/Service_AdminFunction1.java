package Admin;

import java.util.ArrayList;
import java.util.Scanner;

import DTO_admin.DTO;
import main_admin.AdminMain;

/**
 * 관리자 > 교사 계정 관리 기능 수행 클래스
 * @author bey15
 *
 */
public class Service_AdminFunction1 {
	
	private View view;
	private IService service;
	private Scanner scan;
	
	/**
	 * 관리자 > 교사 계정 관리 기능 수행하기 위해 초기화 시켜주는 생성자
	 */
	public Service_AdminFunction1() {
		view = new View();
		service = new Service();
		scan = new Scanner(System.in);
		
	}
	
	/**
	 * 관리자 > 교사 계정 관리 기능 수행 메소드
	 */
	public void adminFunction1Start() {
		
		
		
		boolean loop =true;
		while(loop) {
			
			ArrayList<DTO> list = service.list();
			
			view.begin();
			view.list(list);
			view.menu();
			
			String sel = scan.nextLine();
			view.pause();
			if(sel.equals("a"))service.add();
			else if(sel.equals("b"))service.edit();
			else if(sel.equals("c"))service.del();
			else if(sel.equals("z")) {
				loop= false;
				AdminMain adminMain = new AdminMain();
				adminMain.cAdminMainMenu();
			}
			else service.detail(sel);
			
			System.out.println();
		
		}
		
	}
	

}
