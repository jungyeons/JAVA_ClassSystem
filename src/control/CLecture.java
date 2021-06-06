package control;

import dataAccessObject.DLecture;
import valueObject.OHwewon;
import valueObject.OLecture;

import java.util.Vector;

public class CLecture {

    private DLecture dLecture;

    public CLecture(){
        this.dLecture = new DLecture();
    }

    public void save(OHwewon oHwewon, OLecture oLecture, String folder) {
        this.dLecture.save(oHwewon, oLecture, folder);
    }

    public Vector<OLecture> readAll(String fileName) {
        Vector<OLecture> indices = this.dLecture.readAll(fileName);
        return indices;
    }

    public OLecture readElement(String id) {
        return this.dLecture.readElement(id);
    }

    public void update(OLecture oLecture) {
        this.dLecture.update(oLecture);
    }

    public void delete(String id) {
        this.dLecture.delete(id);
    }
}