package vgtu.ignas.model;

import java.util.ArrayList;

public class Group {
    int id;
    String code;
    StudyForm form = StudyForm.INDIRECT;
    int metai;
    ArrayList<Student> students = new ArrayList();

    public Group(String code, int metai) {
        this.code = code;
        this.metai = metai;
    }
}
