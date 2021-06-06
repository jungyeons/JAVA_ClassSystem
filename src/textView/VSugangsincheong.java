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
		System.out.println(oHwewon.getName() + "님 안녕하세요");
		System.out.println("시작하겠습니다.");

		String campusFileName = this.vCampus.show("root", "캠퍼스를");
		if (campusFileName != null) {
			String collegeFileName = this.vCollege.show(campusFileName, "대학을");
			if (collegeFileName != null) {
				String departmentFileName = this.vDepartment.show(collegeFileName, "학과를");
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