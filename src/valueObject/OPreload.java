package valueObject;

import model.MPreload;

public class OPreload {
	private String id;
	private String classId;
	public void set(MPreload mPreload) {
        this.id = mPreload.getId();
        this.classId = mPreload.getClassId();
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

}
