package vgtu.ignas.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Group implements Serializable {
    int id;
    int spId;
    String code;
    StudyForm form = StudyForm.INDIRECT;
    int year;
    StudyProgram studyProgram;
    ArrayList<Student> students = new ArrayList();
    private static int idGenerator = 1;

    public Group(int spId, String code, StudyForm form, int year) {
        this.spId = spId;
        this.code = code;
        this.year = year;
        this.form = form;
        id = idGenerator++;
    }

    @Override
    public String toString() {
        return id +
                ", '" + code + '\'' +
                ", '" + form + '\'' +
                ", '" + year + '\'';
    }

    public static void setCodeGenerate(int id){
        idGenerator = id;
    }

    public void addStudent(Student s){
        students.add(s);
    }

    public int getSpId() {
        return spId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public StudyForm getForm() {
        return form;
    }

    public void setForm(StudyForm form) {
        this.form = form;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}//class
