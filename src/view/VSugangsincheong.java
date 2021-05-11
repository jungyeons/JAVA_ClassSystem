package view;

import java.util.Scanner;

import valueObject.OHwewon;
import valueObject.OLecture;

public class VSugangsincheong {

	private Scanner scanner;

	private VIndex vCampus;
	private VIndex vCollege;
	private VIndex vDepartment;
	private VLecture vLecture;

	public VSugangsincheong(Scanner scanner) {
		this.scanner = scanner;
		this.vCampus = new VIndex(this.scanner);
		this.vCollege = new VIndex(this.scanner);
		this.vDepartment = new VIndex(this.scanner);
		this.vLecture = new VLecture(this.scanner);
	}

	// show�Լ�: Oȸ����ü���޾Ƽ� �ƹ��͵� �������� �ʴ� �Լ� -> �����ϴµ� �ǹ̰� �ִ� �Լ�
	public void show(OHwewon oHwewon) {
		System.out.println(oHwewon.getName() + "�� �ȳ��ϼ���");
		System.out.println("���� ��û�� �����մϴ�.");

		String campusFileName = this.vCampus.show("root", "ķ�۽���");
		if (campusFileName != null) {
			String collegeFileName = this.vCollege.show(campusFileName, "������");
			if (campusFileName != null) {
				String departmentFileName = this.vDepartment.show(collegeFileName, "�а���");
				if (campusFileName != null) {
					OLecture oLecture = this.vLecture.show(departmentFileName);
					System.out.println("������û�Ϸ�");
					System.out.println(oLecture.getName() + " " + oLecture.getProfessor());
				}
			}
		}
	}
	// System.out.println("�ش� ������ �����ϴ�.")
}
