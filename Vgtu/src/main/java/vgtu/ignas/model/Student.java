package vgtu.ignas.model;

import vgtu.ignas.controller.StudentInfo;

import java.io.Serializable;

public class Student implements Serializable {
    int id;
    String name, surname;
    Group group;
    boolean studies;
    private static int idGenerator = 1;
    int gId;

    public Student(int gId, String name, String surname, Group group, boolean studies) {
        this.gId = gId;
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.studies = studies;
        id = idGenerator++;
    }
public String studies(boolean studies){
    if(studies){
        return  "studies";
    }else{
        return "does not study";
    }}

    public static void setCodeGenerate(int id){
        idGenerator = id;
    }

    public int getgId() {
        return gId;
    }

    @Override
    public String toString() {
        return id +
                ", '" + name + '\'' +
                ", '" + surname + '\'' +
                ", '" + group + '\'' +
                ", '" + studies(studies) + '\'';
    }

    public int getId() {
        return gId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isStudies() {
        return studies;
    }

    public void setStudies(boolean studies) {
        this.studies = studies;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}//class
