package vgtu.ignas.App;

import com.sun.javafx.binding.SelectBinding;
import vgtu.ignas.controller.StudentInfo;
import vgtu.ignas.model.Group;
import vgtu.ignas.model.Student;
import vgtu.ignas.model.StudyForm;
import vgtu.ignas.model.StudyProgram;

import java.util.ArrayList;

import static vgtu.ignas.model.StudyForm.PROLONGED;

public class Application {
    public static void main(String[] args) {



        StudentInfo info = new StudentInfo();

        info.createStudyProgram("Engineering informatics","Information technologies");
        info.createStudyProgram("Informatics","Information technologies");
        info.createStudyProgram("Mathematics","Fundamental technologies");

        Group gr1 = info.createGroup(2, "ISit-17", StudyForm.INDIRECT, 2017);
        Group gr2 = info.createGroup(2, "ISitrt-17", StudyForm.INDIRECT, 2017);
        Group gr3 = info.createGroup(1, "ISit-16", PROLONGED, 2016);

        info.registerStudent(1,"Ignas", "Sungaila", gr1, true);
        info.registerStudent(1,"Jonas", "Jonaitis", gr1, true);
        info.registerStudent(1,"Petras", "Petraitis", gr1, true);
        info.registerStudent(3,"Virgis", "Virgaitis", gr3, true);

        info.deleteGroup(2);
        info.deleteStudyProgram(3);
        info.removeStudent(3);


        ArrayList<StudyProgram> programsList = info.getAllStudyPrograms();
        for(int i =0;i<programsList.size();i++){
            System.out.println(programsList.get(i));
        }

        StudyProgram oneSP = info.getStudyProgramInfo(2);
        if(oneSP!=null){
            System.out.println(oneSP.getName() + " is " + oneSP.getGroups().size());
        }else{
            System.out.println("Study program like this doesn't exist!");
        }


        oneSP = info.getStudyProgramInfo("Engineering informatics");
        if(oneSP!=null){
            System.out.println(oneSP.getCode() + " is " + oneSP.getGroups().size());
        }else{
            System.out.println("Study program like this doesn't exist!");
        }

        info.updateStudyProgram(2, "New", "IT");

        programsList = info.getAllStudyPrograms();
        for(int i =0;i<programsList.size();i++){
            System.out.println(programsList.get(i));
        }

        info.updateGroup(1, "Math-66",  PROLONGED, 1999);
        ArrayList<Group> group = info.getStudyProgramGroups(2);
        group = info.getAllGroups();
        for(Group g:group){
            System.out.println(g);
        }


        info.updateStudent(2, "Jurgis", "Grazulis", gr3,  false);

        ArrayList<Student> students = info.getGroupStudents(1);
        students = info.getAllStudents();
        for(Student s:students) {
            System.out.println(s);
        }








    }
}
