package vgtu.ignas.model;

import java.io.Serializable;
import java.util.ArrayList;

public class StudyProgram implements Serializable {

    int code;
    String name;
    String department;
    ArrayList<Group> groups = new ArrayList();
    private static int codeGenerate = 1;

    public StudyProgram(String name, String department) {
        this.name = name;
        this.department = department;
        code = codeGenerate;
        codeGenerate++;
    }

    public static void setCodeGenerate(int id){
        codeGenerate = id;
    }


    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code +
                ".  '" + name + '\'' +
                ", '" + department + '\'';
    }

    public void addGroup(Group g){
        groups.add(g);
    }


}
