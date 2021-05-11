package view;

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
		// getAll함수호출 : 파일을 읽어서 벡터로 저장
		Vector<OLecture> lectures = this.cLecture.getAll(fileName);

		for (OLecture oLecture : lectures) {
			// 캠퍼스파일에있는 id랑 name을 하나씩 출력
			System.out.println(oLecture.getId() 
					+ "" + oLecture.getName() 
					+ "" + oLecture.getProfessor()
					+ ""+oLecture.getCredit()
					+ oLecture.getTime());
		}
		// 사용자가 번호를 선택하면
		String id = this.scanner.next();

		for (OLecture oLecture : lectures) {
			// 사용자가 선택한 번호랑 같은 번호에 해당하는것의 자식파일을 리턴
			if (oLecture.getId().equals(id)) {
				return oLecture;
			}
		}
		return null;
	}
}
