package view;

import java.util.Scanner;
import control.CLogin;
import valueObject.OHwewon;
import valueObject.OLogin;

/*
V : 화면에 로그인관련된것을 사용자한테 보여주고, 사용자한테 값을 받아오는 애
O : 받은 아이디/비번 값을 가지고있는 애
C : 진짜 로그인기능을 수행하는 애 (아이디, 비밀번호가 일치하는지 검증)
 */
public class VLogin {
	
	private Scanner scanner;
	private CLogin cLogin;

	public VLogin(Scanner scanner) {
		this.scanner= scanner;
		this.cLogin = new CLogin();
	}
	// show함수 : O회원 객체를 리턴하는 함수구나
	public OHwewon show() {
		
		System.out.println("아이디와 비밀번호 입력 하세요");
		// O 로그인 객체를 만듬 : 사용자로부터 받은 아이디, 비번을 여기다가 저장하려고
		OLogin oLogin = new OLogin();
		
		System.out.println("아이디:");
		String id = scanner.next();
		oLogin.setId(id);
		
		System.out.println("비밀번호:");
		String password = scanner.next();
		oLogin.setPassword(password);
		// 로그인 로직 실행
		OHwewon oHwewon= this.cLogin.validate(oLogin);
		// 로그인 성공 시
		if(oHwewon !=null) {
			return oHwewon;
		}else {
			System.out.print("아이디와 비밀번호가 올바르지 않습니다.");
			return null;
		}
	}
}
