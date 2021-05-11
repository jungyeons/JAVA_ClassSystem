package model;

import java.io.FileWriter;
import java.io.IOException;

import valueObject.OPreload;

public class MPreload {
	private String id;
	private String classId;
	public void save(FileWriter fileWriter, OPreload oPreload) {
        this.set(oPreload);

        try {
            fileWriter.write(id);
            fileWriter.write("\r\n");
            fileWriter.write(classId);
            fileWriter.write("\r\n");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public void set(OPreload oPreload) {
    	this.id = oPreload.getId();
    	this.classId = oPreload.getClassId();
    }

}
