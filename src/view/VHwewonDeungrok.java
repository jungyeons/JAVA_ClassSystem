package view;

import java.util.Scanner;

import control.CHwewonDeungrok;
import valueObject.OHwewon;

public class VHwewonDeungrok {
	
	private Scanner scanner;
	private CHwewonDeungrok cHwewonDeungrok;

	public VHwewonDeungrok(Scanner scanner) {
		this.scanner= scanner;
		this.cHwewonDeungrok = new CHwewonDeungrok();
	}

	public void show() {
		
		System.out.println("ȸ�� ������ �Է� �ϼ���");
		OHwewon oHwewon = new OHwewon();
		
		System.out.println("���̵�:");
		int id = scanner.nextInt();
		oHwewon.setId(id);
		
		System.out.println("��й�ȣ:");
		int password = scanner.nextInt();
		oHwewon.setPassword(password);
		
		System.out.println("�̸�:");
		String name = scanner.next();
		oHwewon.setName(name);
	
		System.out.println("�ּ�:");
		String address = scanner.next();
		oHwewon.setAddress(address);
		
		System.out.println("�а�:");
		int hwakgwa = scanner.nextInt();
		oHwewon.setHwakgwa(hwakgwa);
		this.cHwewonDeungrok.saveHwewon(oHwewon);
	}
}
