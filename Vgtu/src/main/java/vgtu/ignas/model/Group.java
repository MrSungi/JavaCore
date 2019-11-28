package vgtu.ignas.model;

import java.util.ArrayList;

public class Group {
    int id;
    String code;
    StudyForm form = StudyForm.INDIRECT;
    int year;
    ArrayList<Student> students = new ArrayList();
    private static int idGenerator = 1;

    public Group(String code, StudyForm form, int year) {
        this.code = code;
        this.year = year;
        this.form = form;
        id = idGenerator++;
    }

    @Override
    public String toString() {
        return id +
                ", '" + code + '\'' +
                ", " + form +
                ", " + year + ".";
    }

    public void addStudent(Student s){
        students.add(s);
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
