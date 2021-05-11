package dataAccessObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import model.MHwewon;
import valueObject.OHwewon;

public class DHwewonDeungrok {
	public DHwewonDeungrok() {
	}

	// read : ���̵� �޾Ƽ� ��ȸ���� �����ϴ� �Լ� (��, ���ԵȾ��̵��ΰ�)
	public OHwewon read(String id) {
		try {
			// "hwewon"�̸��� ���� �������Ϸ� FileŬ������ ��ü�� ����ڴ�.
			File file = new File("hwewon");
			// ��������� �Է��� ������ (�Է½�Ʈ��)
			Scanner scanner = new Scanner(file);
			MHwewon mHwewon = new MHwewon();
			while (mHwewon.read(scanner)) {
				if (mHwewon.getId().equals(id)) {
					// M�� �Ȱ��� ������ ����ִ� Oȸ�� ��ü�� �����ؼ� ����
					OHwewon oHwewon = new OHwewon();
					oHwewon.set(mHwewon);
					// ���� : �Լ����� (read�Լ�����)
					return oHwewon;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// �ش� ���̵�� ���Ե� ȸ�������� ����.
		return null;
	}

	public void save(OHwewon oHwewon) {
		try {
			File file = new File("hwewon");
			FileWriter fileWriter = new FileWriter(file, true);
			MHwewon mHwewon = new MHwewon();
			mHwewon.save(fileWriter, oHwewon);
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
