package Main;

import java.util.Scanner;

public class View {
	public void pause() throws InterruptedException { // 프로그램 넘어가기 전에 출력
		
		System.out.println("\t\t\t\t계속하려면 엔터를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();

		clearScreen();
		System.out.println("\t\t\t\t\tLOADING.....");
		Thread.sleep(700);
		clearScreen();

	}

	private void clearScreen() { // 화면지우기

		for (int i = 0; i < 50; i++) {
			System.out.println("");
		}

	}
	
	public void end() { // 프로그램 종료
		System.out.println("\t\t\t프로그램을 종료합니다.");
	}

//	public void bearPic() {
//	
//		System.out.println(
//				"\t\t\t   _     _        _     _        _     _   \r\n" + 
//				"\t\t\t  (c).-.(c)      (c).-.(c)      (c).-.(c)  \r\n" + 
//				"\t\t\t   / ._. \\        / ._. \\        / ._. \\   \r\n" + 
//				"\t\t\t __\\( Y )/__    __\\( Y )/__    __\\( Y )/__ \r\n" + 
//				"\t\t\t(_.-/'-'\\-._)  (_.-/'-'\\-._)  (_.-/'-'\\-._)\r\n" + 
//				"\t\t\t   || A ||        || S ||        || T ||   \r\n" + 
//				"\t\t\t _.' `-' '._    _.' `-' '._    _.' `-' '._ \r\n" + 
//				"\t\t\t(.-./`-'\\.-.)  (.-./`-`\\.-.)  (.-./`-'\\.-.)\r\n" + 
//				"\t\t\t `-'     `-'    `-'     `-'    `-'     `-' ");
//		
//	}
	
	public void bigTitle() {
		
//		System.out.println("\n\n");
//		System.out.println("\t\t┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┐");
//		System.out.println();
//		System.out.println(""
//				+ "\t\t      ___  __           __   ___      ___  ___  __  \r\n" + 
//				"\t\t     |__  |  \\ |  |    /  ` |__  |\\ |  |  |__  |__) \r\n" + 
//				"\t\t     |___ |__/ \\__/    \\__, |___ | \\|  |  |___ |  \\ \r\n"); // 2칸 띄어쓰기
//		System.out.println();
//		System.out.println("\t\t\t\tSince 2019.04.17. | 오라클디비 2조");
//		System.out.println("\t\t┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┚");
//	
		// slant
		
		System.out.println("\n\n");
		System.out.println("\t\t┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┐");
		System.out.println();
		System.out.println(""
				+ "\t      _____ __________  __  _______________   __________________ \r\n" + 
				"\t     / ___// ____/ __ \\/ / / / ____/ ____/ | / /_  __/ ____/ __ \\\r\n" + 
				"\t     \\__ \\/ __/ / / / / / / / /   / __/ /  |/ / / / / __/ / /_/ /\r\n" + 
				"\t    ___/ / /___/ /_/ / /_/ / /___/ /___/ /|  / / / / /___/ _, _/ \r\n" + 
				"\t   /____/_____/_____/\\____/\\____/_____/_/ |_/ /_/ /_____/_/ |_| "); // 2칸 띄어쓰기
		System.out.println();
		System.out.println("\t\t\t\t\tSince 2019.04.17. | 디비 2조");
		System.out.println("\t\t┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┚");
		
		
	}
}
