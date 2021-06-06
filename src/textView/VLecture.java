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
		System.out.println("강의를 선택하세요.");

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
		System.out.println("강의관리를 시작합니다.");
		System.out.println("다음기능선택");
		System.out.println("강의조회(1), 강의수정(2), 강의삭제(3)");
		String input = this.scanner.next();
		switch (input) {
		case "1":
			System.out.println("조회할 강의 아이디를 입력하세요:");
			String id = this.scanner.next().strip();
			OLecture oLecture = this.cLecture.readElement(id);
			if (oLecture != null) {
				getLecture(oLecture);
			} else {
				System.out.println("해당 강의가 없습니다.");
			}
			break;
		case "2":
			update();
			break;
		case "3":
			System.out.println("삭제할 강의 아이디를 입력하세요:");
			this.cLecture.delete(this.scanner.next());
			System.out.println("삭제되었습니다.");
			break;
		}
	}

	public void update() {

		System.out.println("수정할 강의 아이디를 입력하세요:");
		OLecture oLecture1 = this.cLecture.readElement(this.scanner.next());
		if (oLecture1 == null) {
			System.out.println("해당 강의가 없습니다.");
		} else {
			System.out.println(oLecture1.getId() + " " + oLecture1.getName());
			System.out.println("수정할 강의명을 입력하세요:");
			oLecture1.setName(scanner.next());
			System.out.println("수정할 교수명을 입력하세요:");
			oLecture1.setProfessor(scanner.next());
			System.out.println("수정할 학년 입력하세요:");
			oLecture1.setGrade(scanner.next());
			System.out.println("수정할 시간을 입력하세요:");
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
