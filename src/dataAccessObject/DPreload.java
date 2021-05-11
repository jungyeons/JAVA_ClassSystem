package dataAccessObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import model.MPreload;
import valueObject.OPreload;

public class DPreload {
	public void save(OPreload oPreload) {
        try {
            File file = new File("preload");
            FileWriter fileWriter = new FileWriter(file, true);
            MPreload mPreload = new MPreload();
            mPreload.save(fileWriter, oPreload);
            fileWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
