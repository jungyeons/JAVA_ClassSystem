package textView;

import java.util.Scanner;
import control.CLogin;
import valueObject.OHwewon;
import valueObject.OLogin;

public class VLogin {

	private Scanner scanner;
	private CLogin cLogin;

	public VLogin(Scanner scanner) {
		this.scanner = scanner;
		this.cLogin = new CLogin();
	}

	public OHwewon show() {

		System.out.println("아이디와 비밀번호 입력 하세요");
		OLogin oLogin = new OLogin();

		System.out.println("아이디:");
		String id = scanner.next();
		oLogin.setId(id);

		System.out.println("비밀번호:");
		String password = scanner.next();
		oLogin.setPassword(password);

		OHwewon oHwewon = this.cLogin.validate(oLogin);
		if (oHwewon != null) {
			return oHwewon;
		} else {
			System.out.print("아이디와 비밀번호가 올바르지 않습니다.");
			return null;
		}
	}
}
