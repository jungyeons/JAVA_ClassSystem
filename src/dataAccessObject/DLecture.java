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
			// 파일을 가지고 파일객체생성 -> File클래스에서 제공하는 File다루는 메소드를 이용하기위해
			File file = new File(PATHNAME + fileName);
			// file객체로 Scanner객체생성
			Scanner scanner = new Scanner(file);
			MLecture mLecture = new MLecture();
			while (mLecture.read(scanner)) {
				OLecture oLecture = new OLecture();
				oLecture.set(mLecture);
				// 아까만든 배열 (벡터)에 저장
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
