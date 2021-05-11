package view;

import java.util.Scanner;
import control.CLogin;
import valueObject.OHwewon;
import valueObject.OLogin;

/*
V : ȭ�鿡 �α��ΰ��õȰ��� ��������� �����ְ�, ��������� ���� �޾ƿ��� ��
O : ���� ���̵�/��� ���� �������ִ� ��
C : ��¥ �α��α���� �����ϴ� �� (���̵�, ��й�ȣ�� ��ġ�ϴ��� ����)
 */
public class VLogin {
	
	private Scanner scanner;
	private CLogin cLogin;

	public VLogin(Scanner scanner) {
		this.scanner= scanner;
		this.cLogin = new CLogin();
	}
	// show�Լ� : Oȸ�� ��ü�� �����ϴ� �Լ�����
	public OHwewon show() {
		
		System.out.println("���̵�� ��й�ȣ �Է� �ϼ���");
		// O �α��� ��ü�� ���� : ����ڷκ��� ���� ���̵�, ����� ����ٰ� �����Ϸ���
		OLogin oLogin = new OLogin();
		
		System.out.println("���̵�:");
		String id = scanner.next();
		oLogin.setId(id);
		
		System.out.println("��й�ȣ:");
		String password = scanner.next();
		oLogin.setPassword(password);
		// �α��� ���� ����
		OHwewon oHwewon= this.cLogin.validate(oLogin);
		// �α��� ���� ��
		if(oHwewon !=null) {
			return oHwewon;
		}else {
			System.out.print("���̵�� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");
			return null;
		}
	}
}
