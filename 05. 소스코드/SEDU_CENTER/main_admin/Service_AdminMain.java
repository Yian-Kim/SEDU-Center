package main_admin;

import java.util.ArrayList;
import java.util.Scanner;

import dto_common.DTO_Admin;

public class Service_AdminMain implements IService_AdminMain{

	private DAO_AdminMain DAO_adminMain;
	
	public Service_AdminMain() {
		
		DAO_adminMain = new DAO_AdminMain();
		
	}
	
	@Override
	/**
	 * 관리자 로그인시 아이디와 비밀번호가 맞는지 확인하는 메소드
	 */
	public boolean sLogin(String id, String pw) {
		
		ArrayList<DTO_Admin> loginList = new ArrayList<DTO_Admin>();
		
		loginList = DAO_adminMain.adminLogin();
		
		boolean flag = false;
		
		for(int i = 0; i < loginList.size(); i++) {
			if( id.equals(loginList.get(i).getId()) && pw.equals(loginList.get(i).getPw()) ) {
				flag =true;
			}
			
		}
		
		return flag;
		
	}



}
