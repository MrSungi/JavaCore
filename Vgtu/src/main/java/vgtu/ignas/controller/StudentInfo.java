package vgtu.ignas.controller;

import vgtu.ignas.model.Group;
import vgtu.ignas.model.Student;
import vgtu.ignas.model.StudyForm;
import vgtu.ignas.model.StudyProgram;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentInfo implements Serializable {
    ArrayList<StudyProgram> programs = new ArrayList();

    public StudyProgram createStudyProgram(String name, String department) {
        StudyProgram newSP = new StudyProgram(name, department);
        programs.add(newSP);
        return newSP;
    }

    public ArrayList<StudyProgram> getAllStudyPrograms() {
        return programs;
    }

    public StudyProgram getStudyProgramInfo(int id) {
        for (StudyProgram sp : programs) {
            if (sp.getCode() == id) {
                return sp;
            }
        }
        return null;
    }

    public StudyProgram getStudyProgramInfo(String name) {
        for (StudyProgram sp : programs) {
            if (sp.getName().equals(name)) {
                return sp;
            }
        }
        return null;

    }

    public Group getGroupInfo(int id){
        ArrayList<Group> group = getAllGroups();
        if(group!=null){
            for(Group g:group){
             if(id==g.getId()){
                 return g;
             }
            }
    }return null;
    }

    public Student getStudentInfo(int id){
        ArrayList<Student> student = getAllStudents();
        if(student!=null){
            for(Student s:student){
                if(id==s.getId()){
                    return s;
                }
            }
        }
        return null;
    }

    public void deleteStudyProgram(int id) {
        StudyProgram s = getStudyProgramInfo(id);
        if (s != null) {
            programs.remove(s);
        }
    }

    public void updateStudyProgram(int id, String name, String departament) {
        StudyProgram s = getStudyProgramInfo(id);
        if (s != null) {
            if (name != null && name.trim().length() > 0) {
                s.setName(name);
            }
            if(departament != null && departament.trim().length() > 1){
                s.setDepartment(departament);
            }
        }
    }

    public void updateStudent(int id, String name, String surname, Group group, boolean bool){
        Student s = getStudentInfo(id);
        if(s!=null){
            if(name != null && name.trim().length()>2){
                s.setName(name);
            }
            if(surname != null && surname.trim().length()>3){
                s.setSurname(surname);
            }
            if(group!=null){
                s.setGroup(group);
            }
            if(bool!=s.isStudies()){
                s.setStudies(bool);
            }
        }
    }

    public Group createGroup(int spId, String code, StudyForm s, int year){
        StudyProgram sp = getStudyProgramInfo(spId);
        if(sp!=null){
            Group group = new Group(spId, code, s, year);
            sp.addGroup(group);
            return group;
        }
        return null;
    }

    public ArrayList<Group> getStudyProgramGroups(int spId){
        StudyProgram sp = getStudyProgramInfo(spId);
        if(sp!=null){
            return sp.getGroups();
        }
        return null;
    }

    public ArrayList<Group> getAllGroups(){
        ArrayList<Group> full = new ArrayList();
        for(StudyProgram s:programs){
            full.addAll(s.getGroups());
        }
        return full;
    }

    public void deleteGroup(int gId){
        for(StudyProgram s:programs){
            for(Group g:s.getGroups()){
                if(g.getId()==gId){
                    s.getGroups().remove(g);
                    return;
                }
            }
        }
    }

    public void updateGroup(int id, String code, StudyForm form, int year){
        ArrayList<Group> group = getAllGroups();
        if(group!=null){
        for(Group g:group){
            if(id==g.getId()){
                if(code!=null && code.trim().length() > 3){
                    g.setCode(code);
                }
                if(form!=null){
                    g.setForm(form);
                }
                if(year > 1996 && year <2020 ){
                    g.setYear(year);
                }
            }
            }
        }
    }

    public Student registerStudent(int gId, String name, String surname,Group group, boolean studies ){
        Group g = getGroupInfo(gId);
        if(g!=null){
            Student student = new Student(gId, name, surname, group, studies);
            g.addStudent(student);
            return student;
        }
        return null;
    }

    public ArrayList<Student> getGroupStudents(int gId){
        Group gr = getGroupInfo(gId);
        if(gr!=null){
            return gr.getStudents();
        }
        return null;
    }

    public ArrayList<Student> getAllStudents(){
        ArrayList<Student> all = new ArrayList();
        for(Group g:getAllGroups()){
            all.addAll(g.getStudents());
        }
        return all;
    }

    public void removeStudent(int sId){
        for(StudyProgram s:programs){
            for(Group g:s.getGroups()){
                for(Student st:g.getStudents())
                if(st.getId()==sId){
                    g.getStudents().remove(st);
                    return;
                }
            }
        }
    }



}//class