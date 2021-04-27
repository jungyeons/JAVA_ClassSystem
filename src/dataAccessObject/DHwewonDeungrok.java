package dataAccessObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import model.MHwewon;
import valueObject.OHwewon;



public class DHwewonDeungrok {
	public DHwewonDeungrok() {		
	}

	
	public void save(OHwewon oHwewon) {
		try {
			File file = new File("hwewon");
			FileWriter fileWriter = new FileWriter(file);
			MHwewon mHwewon = new MHwewon();
			mHwewon.save(fileWriter,oHwewon);
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public OHwewon read() {
		
		return null;
	}

}
