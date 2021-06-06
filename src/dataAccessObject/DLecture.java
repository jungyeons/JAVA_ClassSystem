package dataAccessObject;

import model.MLecture;
import valueObject.OHwewon;
import valueObject.OLecture;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class DLecture {
	private MLecture mLecture;

    public DLecture() {
    }

    //미리담기할때 사용하는 함수 (강의내용을 txt파일에 쓰기위해)
    // 사용자 이름으로 파일만듬
    public void save(OHwewon oHwewon, OLecture oLecture, String folder) {
        try {
            File file = new File("./data/"+folder +"/"+ oHwewon.getId());
            FileWriter fileWriter = new FileWriter(file, true);
            this.mLecture = new MLecture();
            mLecture.save(fileWriter, oLecture);
            fileWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // data폴더안에있는 특정파일의 강의목록을 전부 읽는 함수
    public Vector<OLecture> readAll(String fileName) {

        Vector<OLecture> indices = new Vector<OLecture>();
        try {
            // 파일을 가지고 파일객체생성 -> File클래스에서 제공하는 File다루는 메소드를 이용하기위해
            File file = new File("./data/"+fileName);
            // file객체로 Scanner객체생성
            Scanner scanner = new Scanner(file);
            this.mLecture = new MLecture();
            while(mLecture.read(scanner)) {
                OLecture oLecture = new OLecture();
                oLecture.set(this.mLecture);
                indices.add(oLecture);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
        	 return null;
            // TODO Auto-generated catch block
           // e.printStackTrace();
        }
        return indices;
    }

    // 강의 아이디로 해당 강의가 속한 파일이름 찾기
    public String getFilename(String id) {
        File path = new File("./data/");

        File[] fileList = path.listFiles();

        for (File file : fileList) {
            if (file.isDirectory()) {
                continue;
            }
            Vector<OLecture> indices = readAll(file.getName());
            for (OLecture oLecture : indices) {
                if (oLecture.getId().equals(id)) {
                    return file.getName();
                }
            }
        }
        return null;
    }

    // 강의 아이디로 강의정보 찾기
    public OLecture readElement(String id) {
        File path = new File("./data/");

        // 강의정보에 대한 파일만 있어야됨
        File[] fileList = path.listFiles();

        for (File file : fileList) { // 파일을 반복
            if (file.isDirectory()) {
                continue;
            }
            Vector<OLecture> indices = readAll(file.getName());
            for (OLecture oLecture : indices) { 
                if (oLecture.getId().equals(id)) {
                    return oLecture;
                }
            }
        }
        return null;
    }

    // 강의아이디로 강의 삭제하기
    public void delete(String id) {
        String filename = getFilename(id);
        Vector<OLecture> indicies = readAll(filename);

        for (int i = 0; i < indicies.size(); i++) {
            if (indicies.get(i).getId().equals(id)) {
                indicies.remove(i);
                break;
            }
        }
        writeAll(filename, indicies);
    }

   
    public void update(OLecture oLecture) {
        String filename = getFilename(oLecture.getId());
        Vector<OLecture> indicies = readAll(filename);

        for (OLecture lecture : indicies) {
            if (lecture.getId().equals(oLecture.getId())) {
                lecture.update(oLecture);
                break;
            }
        }
        writeAll(filename, indicies);
    }

  
    public void writeAll(String filename, Vector<OLecture> indices) {
        try {
            File file = new File("./data/"+filename);
            FileWriter fileWriter = new FileWriter(file);
            MLecture mLecture = new MLecture();
            for (OLecture lecture : indices) {
                mLecture.save(fileWriter, lecture);
            }
            fileWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
