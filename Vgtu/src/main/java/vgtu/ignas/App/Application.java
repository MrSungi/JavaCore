package vgtu.ignas.App;

import com.sun.javafx.binding.SelectBinding;
import vgtu.ignas.controller.StudentInfo;
import vgtu.ignas.model.Group;
import vgtu.ignas.model.StudyProgram;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {



        StudentInfo info = new StudentInfo();
        StudyProgram sp = info.createStudyProgram("Engineering informatics","Information technologies");
        StudyProgram sp2 = info.createStudyProgram("Informatics","Information technologies");
        // Group group = info.createGroup("ISit", 2017);


        ArrayList<StudyProgram> programsList = info.getAllStudyPrograms();
        for(int i =0;i<programsList.size();i++){
            System.out.println(programsList.get(i));
        }

        StudyProgram oneSP = info.getStudyProgramInfo(1);
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


        // info.createGroup();
        // info.registerStudent();


        // info.updateStudyProgram();
        // info.updateGroup();
        // info.deleteStudyProgram();
        // info.deleteGroup();
    }
}
