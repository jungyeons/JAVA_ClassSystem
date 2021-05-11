package view;

import java.util.Scanner;

import valueObject.OHwewon;

public class VInitial {
    private Scanner scanner;
	private VHwewonDeungrok hwewonDeungrok;
	private VLogin login;
	
	private VSugangsincheong vSugangsincheong;
	public VInitial(Scanner scanner) {
		this.scanner = scanner;
		this.hwewonDeungrok = new VHwewonDeungrok(this.scanner);
		this.login = new VLogin(this.scanner);
	}

	public void show() {
		System.out.println("다음 기능을 선택 하세요 ");
		System.out.println("로그인(1), 회원등록(2)");
	
		String input = this.scanner.next();
		if (input.equals("1")) {
			OHwewon oHwewon = this.login.show();
			//로그인 성공시
			if (oHwewon !=null) {
				//수강신청화면을 띄워라
				this.vSugangsincheong = new VSugangsincheong(this.scanner);
				this.vSugangsincheong.show(oHwewon);
			}
		} else if (input.equals("2")) {
			this.hwewonDeungrok.show();
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}

}
