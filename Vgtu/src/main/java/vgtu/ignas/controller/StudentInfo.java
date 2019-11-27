package vgtu.ignas.controller;

import vgtu.ignas.model.StudyProgram;

import java.util.ArrayList;

public class StudentInfo {
    ArrayList<StudyProgram> programs = new ArrayList();

    public StudyProgram createStudyProgram(String name, String department){
        StudyProgram newSP = new StudyProgram(name, department);
        programs.add(newSP);
        return newSP;
    }

    public ArrayList<StudyProgram> getAllStudyPrograms(){
        return programs;
    }

    public StudyProgram getStudyProgramInfo(int id){
        for(StudyProgram sp:programs){
            if(sp.getCode()==id){
                return sp;
            }
        }
        return null;
    };

    public StudyProgram getStudyProgramInfo(String name){
        for(StudyProgram sp:programs) {
            if (sp.getName().equals(name)) {
                return sp;
            }
        }
            return null;

    };



}
