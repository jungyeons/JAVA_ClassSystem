package view;

import java.util.Scanner;

public class VInitial {
    private Scanner scanner;
	private VHwewonDeungrok hwewonDeungrok;
	public VInitial(Scanner scanner) {
		this.scanner = scanner;
		this.hwewonDeungrok = new VHwewonDeungrok(this.scanner);
	}

	public void show() {
		System.out.println("���� ����� ���� �ϼ��� ");
		System.out.println("�α���(1), ȸ�����(2)");
	
		int input = this.scanner.nextInt();
		if (input == 1) {
			// login dialog show
		} else if (input == 2) {
			this.hwewonDeungrok.show();
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
	}

}
