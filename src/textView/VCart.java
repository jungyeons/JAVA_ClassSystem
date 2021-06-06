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
				System.out.println("�̹� ��û�� ���°� �ֽ��ϴ�.");
			} else {
				this.cLecture.save(oHwewon, oLecture, folder);
				if(folder.equals("MSugang")) {
					System.out.println("���� �̸���Ⱑ �Ϸ�Ǿ����ϴ�.");
				}else if (folder.equals("SSugang")) {
					System.out.println("���� ������û�� �Ϸ�Ǿ����ϴ�.");
				}
			}
		}

		// ������û �Ǵ� �̸���� ��Ͽ� ���� ��û�Ϸ��� ���°� �ִ��� üũ
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

		// �ش� ������� �̸����/������û�� ���Ǹ�� ��������
		public Vector<OLecture> read(OHwewon oHwewon, String folder) {
			Vector<OLecture> indicies = this.cLecture.readAll(folder+"/" + oHwewon.getId());
			return indicies;
		}

		public void show(OHwewon oHwewon) {
			// �̸������ ��� �����ֱ�
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