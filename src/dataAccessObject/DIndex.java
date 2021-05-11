package dataAccessObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import model.MIndex;
import valueObject.OIndex;

//파일들이랑 교류를 할 수있는애 ( M과의차이 )
//D - 파일들과 save/read를 통해 통신 (data access)
//M - 실제 정보
public class DIndex {
    private static final String PATHNAME = "data/";
	public DIndex() {
		// TODO Auto-generated constructor stub
	}
	    // readAll: 파일명을 가지고 해당파일 전체를 읽어서 Vector자료구조에 저장해서 리턴하는 함수
		// array : 배열 ( 크기 고정 )
		// arrayList : 배열리스트 (크기가 변할 수있음)
		// Vector : 배열리스트 (동기화, 멀테스레드환경에서 좋다)
		// <~~> : 제네릭 (타입-(객체)을 명시)
	public Vector<OIndex> readAll(String fileName) {
		Vector<OIndex> indices = new Vector<OIndex>();
		try {
			File file = new File(PATHNAME+fileName);
			Scanner scanner = new Scanner(file);
			MIndex mIndex = new MIndex();
			while(mIndex.read(scanner)) {
				OIndex oIndex = new OIndex();
				oIndex.set(mIndex);
				//아까 만든 배열 (벡터)에 저장
				indices.add(oIndex);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return indices;
	}

}
