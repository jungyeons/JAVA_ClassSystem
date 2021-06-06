package dataAccessObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import model.MHwewon;
import valueObject.OHwewon;

public class DHwewonDeungrok {
	private MHwewon mHwewon;
	public DHwewonDeungrok() {
	}

	// read : ���̵� �޾Ƽ� ��ȸ���� �����ϴ� �Լ� (��, ���ԵȾ��̵��ΰ�)
	public OHwewon read(String id) {
		try {
			// "hwewon"�̸��� ���� �������Ϸ� FileŬ������ ��ü�� �������
			File file = new File("hwewon");
			// ��������� �Է��� ������ (�Է½�Ʈ��)
			Scanner scanner = new Scanner(file);
			this.mHwewon = new MHwewon();
			while (mHwewon.read(scanner)) {
				if (this.mHwewon.getId().equals(id)) {
					// M�� �Ȱ��� ������ ����ִ� Oȸ�� ��ü�� �����ؼ� ����
					OHwewon oHwewon = new OHwewon();
					oHwewon.set(this.mHwewon);
					// ���� : �Լ����� (read�Լ�����)
					return oHwewon;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// �ش� ���̵�� ���Ե� ȸ�������� ����
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
	
	 public Vector<OHwewon> readAll() {

	        Vector<OHwewon> indices = new Vector<OHwewon>();
	        try {
	            File file = new File("hwewon");
	            // file��ü�� Scanner��ü����
	            Scanner scanner = new Scanner(file);
	            this.mHwewon = new MHwewon();
	            while(mHwewon.read(scanner)) {
	            	OHwewon oHwewon = new OHwewon();
	            	oHwewon.set(this.mHwewon);
	                indices.add(oHwewon);
	            }
	            scanner.close();
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return indices;
	    }

}
