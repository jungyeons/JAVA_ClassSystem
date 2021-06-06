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

	// read : 아이디를 받아서 오회원을 리턴하는 함수 (즉, 가입된아이디인가)
	public OHwewon read(String id) {
		try {
			// "hwewon"이름을 가진 실제파일로 File클래스의 객체를 만들겠음
			File file = new File("hwewon");
			// 사용자한테 입력을 받을때 (입력스트림)
			Scanner scanner = new Scanner(file);
			this.mHwewon = new MHwewon();
			while (mHwewon.read(scanner)) {
				if (this.mHwewon.getId().equals(id)) {
					// M과 똑같은 정보를 담고있는 O회원 객체를 생성해서 리턴
					OHwewon oHwewon = new OHwewon();
					oHwewon.set(this.mHwewon);
					// 리턴 : 함수종료 (read함수종료)
					return oHwewon;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 해당 아이디로 가입된 회원정보가 없음
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
	            // file객체로 Scanner객체생성
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
