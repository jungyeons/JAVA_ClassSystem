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

    //�̸�����Ҷ� ����ϴ� �Լ� (���ǳ����� txt���Ͽ� ��������)
    // ����� �̸����� ���ϸ���
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

    // data�����ȿ��ִ� Ư�������� ���Ǹ���� ���� �д� �Լ�
    public Vector<OLecture> readAll(String fileName) {

        Vector<OLecture> indices = new Vector<OLecture>();
        try {
            // ������ ������ ���ϰ�ü���� -> FileŬ�������� �����ϴ� File�ٷ�� �޼ҵ带 �̿��ϱ�����
            File file = new File("./data/"+fileName);
            // file��ü�� Scanner��ü����
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

    // ���� ���̵�� �ش� ���ǰ� ���� �����̸� ã��
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

    // ���� ���̵�� �������� ã��
    public OLecture readElement(String id) {
        File path = new File("./data/");

        // ���������� ���� ���ϸ� �־�ߵ�
        File[] fileList = path.listFiles();

        for (File file : fileList) { // ������ �ݺ�
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

    // ���Ǿ��̵�� ���� �����ϱ�
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
