package dataAccessObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import model.MLecture;
import valueObject.OLecture;

public class DLecture {
	private static final String PATHNAME = "data/";

	public DLecture() {
	}

	public Vector<OLecture> readAll(String fileName) {
		Vector<OLecture> lectures = new Vector<OLecture>();
		try {
			// ������ ������ ���ϰ�ü���� -> FileŬ�������� �����ϴ� File�ٷ�� �޼ҵ带 �̿��ϱ�����
			File file = new File(PATHNAME + fileName);
			// file��ü�� Scanner��ü����
			Scanner scanner = new Scanner(file);
			MLecture mLecture = new MLecture();
			while (mLecture.read(scanner)) {
				OLecture oLecture = new OLecture();
				oLecture.set(mLecture);
				// �Ʊ�� �迭 (����)�� ����
				lectures.add(oLecture);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lectures;
	}
}
