package dataAccessObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import model.MIndex;
import valueObject.OIndex;

//���ϵ��̶� ������ �� ���ִ¾� ( M�������� )
//D - ���ϵ�� save/read�� ���� ��� (data access)
//M - ���� ����
public class DIndex {
    private static final String PATHNAME = "data/";
	public DIndex() {
		// TODO Auto-generated constructor stub
	}
	    // readAll: ���ϸ��� ������ �ش����� ��ü�� �о Vector�ڷᱸ���� �����ؼ� �����ϴ� �Լ�
		// array : �迭 ( ũ�� ���� )
		// arrayList : �迭����Ʈ (ũ�Ⱑ ���� ������)
		// Vector : �迭����Ʈ (����ȭ, ���׽�����ȯ�濡�� ����)
		// <~~> : ���׸� (Ÿ��-(��ü)�� ���)
	public Vector<OIndex> readAll(String fileName) {
		Vector<OIndex> indices = new Vector<OIndex>();
		try {
			File file = new File(PATHNAME+fileName);
			Scanner scanner = new Scanner(file);
			MIndex mIndex = new MIndex();
			while(mIndex.read(scanner)) {
				OIndex oIndex = new OIndex();
				oIndex.set(mIndex);
				//�Ʊ� ���� �迭 (����)�� ����
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
