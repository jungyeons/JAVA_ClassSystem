package view;

import java.util.Scanner;
import java.util.Vector;

import control.CIndex;
import valueObject.OIndex;

public class VIndex {
	
	private Scanner scanner;
	private CIndex cIndex;
    
	public VIndex(Scanner scanner) {
		this.scanner = scanner;
		this.cIndex = new CIndex();
	}
	// 캠퍼스선택 ->자식파일의 이름을 리턴
    // 문자열 형태의 파일이름을 인자로 받아서, 문자열 형태의 자식파일이름을 리턴하는 함수
	public String show(String fileName,String message) {
		System.out.println(message+"선택 하세요.");
		Vector<OIndex> indices = cIndex.getAll(fileName);
		for(OIndex index: indices) {
			System.out.println(index.getId()+""+index.getName());
		}
		String id = this.scanner.next();
		for(OIndex index: indices) {
			if (index.getId().equals(id)) {
				return index.getFileName();
			}
		}
		return null;
	}

}
