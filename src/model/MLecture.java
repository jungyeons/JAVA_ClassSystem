package model;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import valueObject.OLecture;

public class MLecture {

    private String id;
    private String name;
    private String professor;
    private String grade;
    private String number;


    public MLecture() {
    }

    public boolean read(Scanner scanner) {
        if(scanner.hasNext()) {
            this.id = scanner.next();
            this.name = scanner.next();
            this.professor = scanner.next();
            this.grade = scanner.next();
            this.number = scanner.next();
            return true;
        }
        return false;
    }

    public void save(FileWriter fileWriter, OLecture oLecture) {
        this.set(oLecture);

        try {
            fileWriter.write(id);
            fileWriter.write(" ");
            fileWriter.write(name);
            fileWriter.write(" ");
            fileWriter.write(professor);
            fileWriter.write(" ");
            fileWriter.write(grade);
            fileWriter.write(" ");
            fileWriter.write(number);
            fileWriter.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void set(OLecture oLecture) {
        this.id = oLecture.getId();
        this.name = oLecture.getName();
        this.professor = oLecture.getProfessor();
        this.grade = oLecture.getGrade();
        this.number = oLecture.getNumber();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
