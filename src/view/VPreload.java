package view;

import java.util.Scanner;

import control.CPreload;
import valueObject.OHwewon;
import valueObject.OLecture;
import valueObject.OPreload;

public class VPreload {
	private Scanner scanner;
	private CPreload cPreload;
	private VIndex vCampus;
	private VIndex vCollege;
	private VIndex vDepartment;
	private VLecture vLecture;

	public VPreload(Scanner scanner) {
		this.scanner = scanner;
		this.vCampus = new VIndex(this.scanner);
		this.vCollege = new VIndex(this.scanner);
		this.vDepartment = new VIndex(this.scanner);
		this.vLecture = new VLecture(this.scanner);
		this.cPreload = new CPreload(this.scanner);
	}

	// show�Լ�: Oȸ����ü���޾Ƽ� �ƹ��͵� �������� �ʴ� �Լ� -> �����ϴµ� �ǹ̰� �ִ� �Լ�
	public void show(OHwewon oHwewon) {
		System.out.println("�̸� ��⸦ �����մϴ�.");

		String campusFileName = this.vCampus.show("root", "ķ�۽���");
		if (campusFileName != null) {
			String collegeFileName = this.vCollege.show(campusFileName, "������");
			if (collegeFileName != null) {
				String departmentFileName = this.vDepartment.show(collegeFileName, "�а���");
				while(true) {
					if (departmentFileName != null) {
						OLecture oLecture = this.vLecture.show(departmentFileName, "���¸�");
						OPreload oPreload = new OPreload();
						oPreload.setId(oHwewon.getId());
						oPreload.setClassId(oLecture.getId());
						cPreload.save(oPreload);
						System.out.println("���¸� �� �����ðڽ��ϱ�?");
						System.out.println("1��: ��,2��: �ƴϿ�");
						String input = this.scanner.next();
						if(input.equals("2")) {
							System.out.println("�̸� ��� �Ϸ��մϴ�.");
							break;
						}
						
				}
				}
			}
		}
	}
	// System.out.println("�ش� ������ �����ϴ�.")
}
