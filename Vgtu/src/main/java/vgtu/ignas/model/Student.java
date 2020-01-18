package vgtu.ignas.model;

import vgtu.ignas.controller.StudentInfo;

import java.io.Serializable;

public class Student implements Serializable {
    int id;
    String name, surname;
    Group group;
    int gId;

    public Student(int gId, String name, String surname, Group group) {
        this.gId = gId;
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.group = group;

    }



    public int getgId() {
        return gId;
    }

    @Override
    public String toString() {
        return id +
                ", '" + name + '\'' +
                ", '" + surname + '\'' +
                ", '" + group + '\'';
    }

    public int getId() {
        return id;
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


    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}//class
