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

	// show함수: O회원객체를받아서 아무것도 리턴하진 않는 함수 -> 수행하는데 의미가 있는 함수
	public void show(OHwewon oHwewon) {
		System.out.println("미리 담기를 시작합니다.");

		String campusFileName = this.vCampus.show("root", "캠퍼스를");
		if (campusFileName != null) {
			String collegeFileName = this.vCollege.show(campusFileName, "대학을");
			if (collegeFileName != null) {
				String departmentFileName = this.vDepartment.show(collegeFileName, "학과를");
				while(true) {
					if (departmentFileName != null) {
						OLecture oLecture = this.vLecture.show(departmentFileName, "강좌를");
						OPreload oPreload = new OPreload();
						oPreload.setId(oHwewon.getId());
						oPreload.setClassId(oLecture.getId());
						cPreload.save(oPreload);
						System.out.println("강좌를 더 담으시겠습니까?");
						System.out.println("1번: 예,2번: 아니오");
						String input = this.scanner.next();
						if(input.equals("2")) {
							System.out.println("미리 담기 완료합니다.");
							break;
						}
						
				}
				}
			}
		}
	}
	// System.out.println("해당 파일이 없습니다.")
}
