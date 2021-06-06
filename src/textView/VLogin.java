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

		System.out.println("���̵�� ��й�ȣ �Է� �ϼ���");
		OLogin oLogin = new OLogin();

		System.out.println("���̵�:");
		String id = scanner.next();
		oLogin.setId(id);

		System.out.println("��й�ȣ:");
		String password = scanner.next();
		oLogin.setPassword(password);

		OHwewon oHwewon = this.cLogin.validate(oLogin);
		if (oHwewon != null) {
			return oHwewon;
		} else {
			System.out.print("���̵�� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");
			return null;
		}
	}
}