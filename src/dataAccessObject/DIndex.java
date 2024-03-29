package dataAccessObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import model.MIndex;
import valueObject.OIndex;


public class DIndex {
    private static final String PATHNAME = "data/Index/";
    private MIndex mIndex;
	public DIndex() {
		// TODO Auto-generated constructor stub
	}
	    
	public Vector<OIndex> readAll(String fileName) {
		Vector<OIndex> indices = new Vector<OIndex>();
		try {
			File file = new File(PATHNAME+fileName);
			Scanner scanner = new Scanner(file);
			this.mIndex = new MIndex();
			while(this.mIndex.read(scanner)) {
				OIndex oIndex = new OIndex();
				oIndex.set(this.mIndex);
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
