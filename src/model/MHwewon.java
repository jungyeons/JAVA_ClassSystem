package model;

import java.io.FileWriter;
import java.io.IOException;

import valueObject.OHwewon;

public class MHwewon {

	private int id;
	private int password;
	private String name;
	private String address;
	private int hwakgwa;
	
	public MHwewon() {
		// TODO Auto-generated constructor stub
	}

	public void set (OHwewon oHwewon) {
		this.id = oHwewon.getId();
		this.password = oHwewon.getPassword();
		this.name = oHwewon.getName();
		this.address = oHwewon.getAddress();
		this.hwakgwa = oHwewon.getHwakgwa();
	}

	public void save(FileWriter fileWriter, OHwewon oHwewon) {
		this.set(oHwewon);
		
		try {
			fileWriter.write(id);
			fileWriter.write(password);
			fileWriter.write(name);
			fileWriter.write(address);
			fileWriter.write(hwakgwa);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
