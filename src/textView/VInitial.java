
package textView;

import java.util.Scanner;
import valueObject.OHwewon;
import valueObject.OLecture;

public class VInitial {
	private Scanner scanner;
	private VHwewonDeungrok hwewonDeungrok;
	private VLogin login;
	private VSugangsincheong vSugangsincheong;
	private VCart vCart;
	private VLecture vLecture;
	private VHwewon vHwewon;

	public VInitial(Scanner scanner) {
		this.scanner = scanner;
		this.hwewonDeungrok = new VHwewonDeungrok(this.scanner);
		this.vCart = new VCart(this.scanner);
		this.login = new VLogin(this.scanner);
		this.vLecture = new VLecture(this.scanner);
		this.vHwewon = new VHwewon();

	}

	public void show() {
		System.out.println("다음 기능 중 선택해주세요.");
		System.out.println("로그인(1), 회원등록(2),저장된 회원 정보 확인(3)");

		String input = this.scanner.next();
		if (input.equals("1")) {
			OHwewon oHwewon = this.login.show();
			if (oHwewon != null) {

				System.out.println("다음 기능 중 선택해주세요.");
				System.out.println("수강신청or미리담기(1), 미리담기 한 강좌 수강신청(2), 강의관리(3)");
				String input2 = this.scanner.next();
				switch (input2) {
				case "1":
					this.vSugangsincheong = new VSugangsincheong(this.scanner);
					OLecture oLecture = this.vSugangsincheong.show(oHwewon);
					System.out.println("다음 기능 중 선택해주세요.");
					System.out.println("미리담기(1), 수강신청(2)");
					String input3 = this.scanner.next();
					switch (input3) {
					case "1":
						this.vCart.save(oHwewon, oLecture, "Msugang");
						break;
					case "2":
						this.vSugangsincheong.save(oHwewon, oLecture, "Ssugang");
						break;
					default:
						System.out.println("잘못입력하였습니다.");
						break;
					}
					break;
				case "2":
					this.vCart = new VCart(this.scanner);
					this.vCart.show(oHwewon);
					break;
				case "3":
					this.vLecture = new VLecture(this.scanner);
					this.vLecture.test();
					break;
				default:
					System.out.println("잘못입력하였습니다.");
					break;
				}
			}
		} else if (input.equals("2")) {
			this.hwewonDeungrok.show();
		} else if (input.equals("3")) {
			this.vHwewon.show();
		} else {
			System.out.println("잘못입력하였습니다.");
		}
	}

}