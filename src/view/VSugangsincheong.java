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

	// show함수: O회원객체를받아서 아무것도 리턴하진 않는 함수 -> 수행하는데 의미가 있는 함수
	public void show(OHwewon oHwewon) {
		System.out.println(oHwewon.getName() + "님 안녕하세요");
		System.out.println("수강 신청을 시작합니다.");

		String campusFileName = this.vCampus.show("root", "캠퍼스를");
		if (campusFileName != null) {
			String collegeFileName = this.vCollege.show(campusFileName, "대학을");
			if (campusFileName != null) {
				String departmentFileName = this.vDepartment.show(collegeFileName, "학과를");
				if (campusFileName != null) {
					OLecture oLecture = this.vLecture.show(departmentFileName);
					System.out.println("수강신청완료");
					System.out.println(oLecture.getName() + " " + oLecture.getProfessor());
				}
			}
		}
	}
	// System.out.println("해당 파일이 없습니다.")
}
