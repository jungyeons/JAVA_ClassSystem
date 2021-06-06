package textView;

import java.util.Scanner;
import java.util.Vector;
import control.CLecture;
import valueObject.OLecture;

public class VLecture {

	private Scanner scanner;
	private CLecture cLecture;

	public VLecture(Scanner scanner) {
		this.scanner = scanner;
		this.cLecture = new CLecture();

	}

	public OLecture show(String fileName) {
		System.out.println("���Ǹ� �����ϼ���.");

		Vector<OLecture> indices = cLecture.readAll(fileName);

		for (OLecture oLecture : indices) {

			System.out.println(oLecture.getId() + "" + oLecture.getName() + "" + oLecture.getProfessor() + ""
					+ oLecture.getGrade());
		}

		String id = this.scanner.next();

		for (OLecture oLecture : indices) {
			if (oLecture.getId().equals(id)) {
				return oLecture;
			}
		}
		return null;
	}

	public void test() {
		System.out.println("���ǰ����� �����մϴ�.");
		System.out.println("������ɼ���");
		System.out.println("������ȸ(1), ���Ǽ���(2), ���ǻ���(3)");
		String input = this.scanner.next();
		switch (input) {
		case "1":
			System.out.println("��ȸ�� ���� ���̵� �Է��ϼ���:");
			String id = this.scanner.next().strip();
			OLecture oLecture = this.cLecture.readElement(id);
			if (oLecture != null) {
				getLecture(oLecture);
			} else {
				System.out.println("�ش� ���ǰ� �����ϴ�.");
			}
			break;
		case "2":
			update();
			break;
		case "3":
			System.out.println("������ ���� ���̵� �Է��ϼ���:");
			this.cLecture.delete(this.scanner.next());
			System.out.println("�����Ǿ����ϴ�.");
			break;
		}
	}

	public void update() {

		System.out.println("������ ���� ���̵� �Է��ϼ���:");
		OLecture oLecture1 = this.cLecture.readElement(this.scanner.next());
		if (oLecture1 == null) {
			System.out.println("�ش� ���ǰ� �����ϴ�.");
		} else {
			System.out.println(oLecture1.getId() + " " + oLecture1.getName());
			System.out.println("������ ���Ǹ��� �Է��ϼ���:");
			oLecture1.setName(scanner.next());
			System.out.println("������ �������� �Է��ϼ���:");
			oLecture1.setProfessor(scanner.next());
			System.out.println("������ �г� �Է��ϼ���:");
			oLecture1.setGrade(scanner.next());
			System.out.println("������ �ð��� �Է��ϼ���:");
			oLecture1.setNumber(scanner.next());

			this.cLecture.update(oLecture1);
		}
	}

	public void getLecture(OLecture oLecture) {
		System.out.println(oLecture.getId());
		System.out.println(oLecture.getName());
		System.out.println(oLecture.getProfessor());
		System.out.println(oLecture.getGrade());
		System.out.println(oLecture.getNumber());

	}
}
