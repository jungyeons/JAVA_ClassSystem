package textView;

import java.util.Scanner;
import java.util.Vector;

import control.CLecture;
import valueObject.OHwewon;
import valueObject.OLecture;

public class VCart {

	private Scanner scanner;
	private CLecture cLecture;
	

	public VCart(Scanner scanner) {
		this.scanner = scanner;
		this.cLecture = new CLecture();
	}
	
		public void save(OHwewon oHwewon, OLecture oLecture, String folder) {

			boolean result = this.check(oHwewon, oLecture, folder);
			if (result) {
				System.out.println("이미 신청된 강좌가 있습니다.");
			} else {
				this.cLecture.save(oHwewon, oLecture, folder);
				if(folder.equals("MSugang")) {
					System.out.println("강의 미리담기가 완료되었습니다.");
				}else if (folder.equals("SSugang")) {
					System.out.println("강의 수강신청이 완료되었습니다.");
				}
			}
		}

		// 수강신청 또는 미리담기 목록에 현재 신청하려는 강좌가 있는지 체크
		public boolean check(OHwewon oHwewon, OLecture oLecture, String folder) {
			Vector<OLecture> indicies = this.read(oHwewon, folder);
			if (indicies == null) {
				return false;
			}
			for (OLecture lecture : indicies) {
				if (lecture.getId().equals(oLecture.getId())) {
					return true;
				}
			}
			return false;
		}

		// 해당 사용자의 미리담기/수강신청한 강의목록 가져오기
		public Vector<OLecture> read(OHwewon oHwewon, String folder) {
			Vector<OLecture> indicies = this.cLecture.readAll(folder+"/" + oHwewon.getId());
			return indicies;
		}

		public void show(OHwewon oHwewon) {
			// 미리담기한 목록 보여주기
			Vector<OLecture> indicies = this.read(oHwewon, "MSugang");

			for (OLecture oLecture : indicies) {
				System.out.println(oLecture.getId() + " " + oLecture.getName());
			}

			String id = this.scanner.next();
			for (OLecture oLecture : indicies) {
				if (oLecture.getId().equals(id)) {
					this.save(oHwewon, oLecture, "Ssugang");
					break;
				}
			}
		}


	}