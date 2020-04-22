package Student;

import java.util.Scanner;

/*
 * 메인 > 학생
 * 
 * 학생패키지의 컨트롤러 역할을 수행하는 클래스입니다.
 * 
 * 클래스명: StudenetController
 * 
 */

public class StudentController {

	private static Scanner scan;

	// 생성자
	static {
		scan = new Scanner(System.in);
	}



	/**
	 * 실질적인 학생 메인컨트롤러 역할을 시행
	 * 
	 * @throws InterruptedException
	 */
	public static void start() throws InterruptedException {

		StudentService stuService = new StudentService();

		stuService.studentLogin();
		stuService.studentInfo();
		stuService.studentMemu();

	}

}
