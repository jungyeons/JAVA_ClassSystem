package textView;

import java.util.Scanner;
import control.CLecture;
import valueObject.OHwewon;
import valueObject.OLecture;

public class VSugangsincheong {

	private Scanner scanner;

	private VIndex vCampus;
	private VIndex vCollege;
	private VIndex vDepartment;
	private VLecture vLecture;
	private CLecture cLecture;

	public VSugangsincheong(Scanner scanner) {
		this.scanner = scanner;
		this.vCampus = new VIndex(this.scanner);
		this.vCollege = new VIndex(this.scanner);
		this.vDepartment = new VIndex(this.scanner);
		this.vLecture = new VLecture(this.scanner);
		this.cLecture = new CLecture();
	}

	public OLecture show(OHwewon oHwewon) {
		System.out.println(oHwewon.getName() + "�� �ȳ��ϼ���");
		System.out.println("�����ϰڽ��ϴ�.");

		String campusFileName = this.vCampus.show("root", "ķ�۽���");
		if (campusFileName != null) {
			String collegeFileName = this.vCollege.show(campusFileName, "������");
			if (collegeFileName != null) {
				String departmentFileName = this.vDepartment.show(collegeFileName, "�а���");
				if (departmentFileName != null) {
					OLecture oLecture = this.vLecture.show(departmentFileName);
					return oLecture;
				}
			}
		}
		return null;
	}

	public void save(OHwewon oHwewon, OLecture oLecture, String folder) {
		this.cLecture.save(oHwewon, oLecture, folder);
	}
}