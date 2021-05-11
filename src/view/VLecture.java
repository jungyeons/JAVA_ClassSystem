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
		System.out.println("���Ǹ� �����ϼ���.");
		// getAll�Լ�ȣ�� : ������ �о ���ͷ� ����
		Vector<OLecture> lectures = this.cLecture.getAll(fileName);

		for (OLecture oLecture : lectures) {
			// ķ�۽����Ͽ��ִ� id�� name�� �ϳ��� ���
			System.out.println(oLecture.getId() 
					+ "" + oLecture.getName() 
					+ "" + oLecture.getProfessor()
					+ ""+oLecture.getCredit()
					+ oLecture.getTime());
		}
		// ����ڰ� ��ȣ�� �����ϸ�
		String id = this.scanner.next();

		for (OLecture oLecture : lectures) {
			// ����ڰ� ������ ��ȣ�� ���� ��ȣ�� �ش��ϴ°��� �ڽ������� ����
			if (oLecture.getId().equals(id)) {
				return oLecture;
			}
		}
		return null;
	}
}
