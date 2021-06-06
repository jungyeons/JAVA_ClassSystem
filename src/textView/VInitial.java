
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
		System.out.println("���� ��� �� �������ּ���.");
		System.out.println("�α���(1), ȸ�����(2),����� ȸ�� ���� Ȯ��(3)");

		String input = this.scanner.next();
		if (input.equals("1")) {
			OHwewon oHwewon = this.login.show();
			if (oHwewon != null) {

				System.out.println("���� ��� �� �������ּ���.");
				System.out.println("������ûor�̸����(1), �̸���� �� ���� ������û(2), ���ǰ���(3)");
				String input2 = this.scanner.next();
				switch (input2) {
				case "1":
					this.vSugangsincheong = new VSugangsincheong(this.scanner);
					OLecture oLecture = this.vSugangsincheong.show(oHwewon);
					System.out.println("���� ��� �� �������ּ���.");
					System.out.println("�̸����(1), ������û(2)");
					String input3 = this.scanner.next();
					switch (input3) {
					case "1":
						this.vCart.save(oHwewon, oLecture, "Msugang");
						break;
					case "2":
						this.vSugangsincheong.save(oHwewon, oLecture, "Ssugang");
						break;
					default:
						System.out.println("�߸��Է��Ͽ����ϴ�.");
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
					System.out.println("�߸��Է��Ͽ����ϴ�.");
					break;
				}
			}
		} else if (input.equals("2")) {
			this.hwewonDeungrok.show();
		} else if (input.equals("3")) {
			this.vHwewon.show();
		} else {
			System.out.println("�߸��Է��Ͽ����ϴ�.");
		}
	}

}