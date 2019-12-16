package vgtu.ignas.App;

import vgtu.ignas.controller.StudentInfo;
import vgtu.ignas.model.Group;
import vgtu.ignas.model.Student;
import vgtu.ignas.model.StudyForm;
import vgtu.ignas.model.StudyProgram;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static vgtu.ignas.model.StudyForm.INDIRECT;
import static vgtu.ignas.model.StudyForm.PROLONGED;

public class Menu {
    public static void main(String[] a) {
        boolean run = true;
        boolean caserun = false;
        StudyForm studyForm;
        boolean studies;
        StudentInfo studentInfo = null;
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("data"));
            studentInfo = (StudentInfo)in.readObject();

            int spCounter = 0;
            for (StudyProgram studyProgram:studentInfo.getAllStudyPrograms()){
                if(studyProgram.getCode()>spCounter){
                    spCounter = studyProgram.getCode();
                }
            }
            StudyProgram.setCodeGenerate(spCounter+1);

            int grCounter = 0;
            for (Group group:studentInfo.getAllGroups()){
                if(group.getId()>grCounter){
                    grCounter = group.getId();
                }
            }
            Group.setCodeGenerate(grCounter+1);

            int stCounter = 0;
            for (Student student:studentInfo.getAllStudents()){
                if(student.getId()>stCounter){
                    stCounter = student.getId();
                }
            }
            Student.setCodeGenerate(stCounter+1);

            in.close();
        }catch (Exception e){
            studentInfo = new StudentInfo();
        }

        while (run) {
            System.out.println("Available commands:\n"
                    + "\t1 - Study Program\n"
                    + "\t2 - Group\n"
                    + "\t3 - Student\n"
                    + "\t4 - Export Data\n"
                    + "\t5 - Exit\n");
            Scanner scanner = new Scanner(System.in);
            int command = scanner.nextInt();
            switch (command){
                case 1:
                    caserun = true;
                    while (caserun) {
                        System.out.println("Study Program commands:\n"
                                + "\t1 - Add new Study Program.\n"
                                + "\t2 - Show Study Program.\n"
                                + "\t3 - Show all Study Program.\n"
                                + "\t4 - Update Study Programs.\n"
                                + "\t5 - Delete Study Program.\n"
                                + "\t6 - Export Study program data.\n"
                                + "\t7 - Import Study program data.\n"
                                + "\t8 - Back\n");
                        int caseload = scanner.nextInt();
                        switch (caseload){
                            case 1:
                                scanner.nextLine();
                                System.out.println("Enter Study programs name:");
                                String name = scanner.nextLine();
                                System.out.println("Enter Study programs department:");
                                String dep = scanner.nextLine();
                                studentInfo.createStudyProgram(name, dep);
                                break;
                            case 2:
                                try {
                                    System.out.println("Enter Study programs id number:");
                                    int id = scanner.nextInt();
                                    if (studentInfo.getStudyProgramInfo(id) != null) {
                                        System.out.println(studentInfo.getStudyProgramInfo(id));
                                    } else {
                                        System.out.println("There is no Study program with this id.");
                                    }
                                }catch (InputMismatchException e){
                                    System.out.println("Wrong input!");
                                }
                                break;
                            case 3:
                                System.out.println("All Study Programs:");
                                ArrayList<StudyProgram> studyPrograms = studentInfo.getAllStudyPrograms();
                                if(studyPrograms.size()>0){
                                    for(StudyProgram s:studyPrograms)
                                    System.out.println(s);
                                }else{
                                    System.out.println("There is no data yet.");
                                }
                                break;
                            case 4:
                                System.out.println("Enter Study programs id number which you want to update:");
                                try {
                                   int id = scanner.nextInt();
                                    scanner.nextLine();
                                    if (studentInfo.getStudyProgramInfo(id) != null) {
                                        System.out.println("Enter updated name:");
                                        name = scanner.nextLine();
                                        System.out.println("Enter updated department:");
                                        dep = scanner.nextLine();
                                        studentInfo.updateStudyProgram(id, name, dep);
                                    } else {
                                        System.out.println("There is no Study program with this id.");
                                    }
                                }catch (InputMismatchException e){
                                    System.out.println("Wrong input!");
                                }
                                break;
                            case 5:
                                System.out.println("Enter Study programs id number which you want to delete:");
                                int id = scanner.nextInt();
                                if(studentInfo.getStudyProgramInfo(id)!=null){
                                    studentInfo.deleteStudyProgram(id);
                                }else{
                                    System.out.println("There is no Study program with this id.");
                                }
                                break;
                            case 6:
                                try{
                                    DataOutputStream file = new DataOutputStream(new FileOutputStream("StudyProgram.csv"));
                                    for(StudyProgram studyProgram : studentInfo.getAllStudyPrograms()){
                                        file.writeUTF(studyProgram.getCode() + ";" + studyProgram.getName() + ";" + studyProgram.getDepartment() + '\n');
                                    }
                                    file.close();
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                break;
                            case 7:
                                try{
                                    Scanner file = new Scanner(new File("StudyProgram.csv"));
                                    int spCounter = 0;
                                    for (StudyProgram studyProgram:studentInfo.getAllStudyPrograms()){
                                        if(studyProgram.getCode()>spCounter){
                                            spCounter = studyProgram.getCode();
                                        }
                                    }
                                    StudyProgram.setCodeGenerate(spCounter+1);
                                    while (file.hasNext()){
                                        String line = file.nextLine().trim();
                                        if(line.length()>0){

                                            String[] part = line.split(";");
                                            studentInfo.createStudyProgram(part[1], part[2]);
                                        }
                                    }
                                    file.close();
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                break;
                            case 8:
                                System.out.println("Back.");
                                caserun = false;
                                break;
                            default:
                                System.out.println("There is no such command.");
                        }//switch
                    }//while
                    break;
                case 2:
                    caserun = true;
                    while (caserun) {
                        System.out.println("Group commands:\n"
                                + "\t1 - Add new group.\n"
                                + "\t2 - Show group.\n"
                                + "\t3 - Show Study programs groups.\n"
                                + "\t4 - Show all groups\n"
                                + "\t5 - Update group.\n"
                                + "\t6 - Delete group.\n"
                                + "\t7 - Export group data.\n"
                                + "\t8 - Import group data.\n"
                                + "\t9 - Back\n");
                        int caseload = scanner.nextInt();
                        switch (caseload){
                            case 1:
                                try {
                                    System.out.println("Enter Study programs id number:");
                                    int id = scanner.nextInt();
                                    scanner.nextLine();
                                    if(studentInfo.getStudyProgramInfo(id)!=null) {
                                        System.out.println("Enter groups code:");
                                        String code = scanner.nextLine();
                                        System.out.println("Enter study form, i - indirect, p - prolonged");
                                        Character form = scanner.nextLine().toLowerCase().charAt(0);
                                        if (form == 'i') {
                                            studyForm = INDIRECT;
                                        } else if (form == 'p') {
                                            studyForm = PROLONGED;
                                        } else {
                                            System.out.println("Wrong form input.");
                                            break;
                                        }
                                        System.out.println("Enter group's year:");
                                        int year = scanner.nextInt();
                                        if (year > 2010 && year < 2020) {
                                            studentInfo.createGroup(id, code, studyForm, year);
                                        } else {
                                            System.out.println("This year is not valid.");
                                        }
                                    }else{
                                        System.out.println("Wrong id!");
                                        break;
                                    }
                                } catch (InputMismatchException e){
                                        System.out.println("Wrong input!");
                                    }
                                break;
                            case 2:
                                try {
                                    System.out.println("Enter group id number:");
                                    int id = scanner.nextInt();
                                    if (studentInfo.getGroupInfo(id) != null) {
                                        System.out.println(studentInfo.getGroupInfo(id));
                                    } else {
                                        System.out.println("There is no group with this id.");
                                    }
                                }catch (InputMismatchException e){
                                    System.out.println("Wrong input!");
                                }
                                break;
                            case 3:
                                try {
                                    System.out.println("Enter Study programs id number:");
                                    int id = scanner.nextInt();
                                    ArrayList<Group> groups = studentInfo.getStudyProgramGroups(id);
                                    if (groups != null) {
                                        for(Group g:groups)
                                            System.out.println(g);
                                    } else {
                                        System.out.println("There is no Study program with this id.");
                                    }
                                }catch (InputMismatchException e){
                                    System.out.println("Wrong input!");
                                }
                                break;
                            case 4:
                                System.out.println("All groups:");
                                ArrayList<Group> groups = studentInfo.getAllGroups();
                                if(groups.size()>0){
                                    for(Group g:groups)
                                        System.out.println(g);
                                }else{
                                    System.out.println("There is no data yet.");
                                }
                                break;
                            case 5:

                                System.out.println("Enter group id number which you want to update:");
                                try {
                                    int id = scanner.nextInt();
                                    scanner.nextLine();
                                    if (studentInfo.getGroupInfo(id) != null) {
                                        System.out.println("Enter updated code:");
                                        String code = scanner.nextLine();
                                        System.out.println("Enter updated form, i - indirect, p - prolonged:");
                                        Character form = scanner.nextLine().toLowerCase().charAt(0);
                                        if (form == 'i') {
                                            studyForm = INDIRECT;
                                        } else if (form == 'p') {
                                            studyForm = PROLONGED;
                                        } else {
                                            System.out.println("Wrong form input.");
                                            break;
                                        }
                                        System.out.println("Enter updated year:");
                                        int year = scanner.nextInt();
                                        if (year > 2010 && year < 2020) {
                                            studentInfo.updateGroup(id, code, studyForm, year);
                                        } else {
                                            System.out.println("This year is not valid.");
                                        }
                                    } else {
                                        System.out.println("There is no Study program with this id.");
                                    }
                                }catch (InputMismatchException e){
                                    System.out.println("Wrong input!");
                                }
                                break;
                            case 6:
                                System.out.println("Enter group id number which you want to delete:");
                                int id = scanner.nextInt();
                                if(studentInfo.getGroupInfo(id)!=null){
                                    studentInfo.deleteGroup(id);
                                }else{
                                    System.out.println("There is no group with this id.");
                                }
                                break;
                            case 7:
                                try{
                                    DataOutputStream file = new DataOutputStream(new FileOutputStream("Group.csv"));
                                    for(Group group : studentInfo.getAllGroups()){
                                        file.writeUTF(group.getSpId() + ";" + group.getId() + ";" + group.getCode() + ";" + group.getForm() + ";" + group.getYear() + '\n');
                                    }
                                    file.close();
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                break;
                            case 8:
                                try{
                                    Scanner file = new Scanner(new File("Group.csv"));
                                    int grCounter = 0;
                                    for (Group group:studentInfo.getAllGroups()){
                                        if(group.getId()>grCounter){
                                            grCounter = group.getId();
                                        }
                                    }
                                    Group.setCodeGenerate(grCounter+1);
                                    while (file.hasNext()){
                                        String line = file.nextLine().trim();
                                        if(line.length()>0){
                                            String[] part = line.split(";");
                                            int spId = parseInt(part[0]);
                                            int year = parseInt(part[4]);
                                            StudyForm form = StudyForm.valueOf(part[3]);
                                            studentInfo.createGroup(spId, part[2], form, year);

                                        }
                                    }
                                    file.close();
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                break;
                            case 9:
                                System.out.println("Back.");
                                caserun = false;
                                break;
                            default:
                                System.out.println("There is no such command.");
                        }//switch
                    }//while
                    break;
                case 3:
                    caserun = true;
                    while (caserun) {
                        System.out.println("Student commands:\n"
                                + "\t1 - Add new student.\n"
                                + "\t2 - Show student.\n"
                                + "\t3 - Show group students.\n"
                                + "\t4 - Show all student\n"
                                + "\t5 - Update student.\n"
                                + "\t6 - Delete student.\n"
                                + "\t7 - Export student data.\n"
                                + "\t8 - Import student data.\n"
                                + "\t9 - Back\n");
                        int caseload = scanner.nextInt();
                        switch (caseload){
                            case 1:
                                try {
                                    System.out.println("Enter group id number:");
                                    int id = scanner.nextInt();
                                    scanner.nextLine();
                                    Group group = studentInfo.getGroupInfo(id);
                                    if(group!=null) {
                                        System.out.println("Enter student name:");
                                        String name = scanner.nextLine();
                                        System.out.println("Enter student surname");
                                        String surname = scanner.nextLine();
                                        System.out.println("Does he studies? Y/N");
                                        Character stud = scanner.next().toLowerCase().charAt(0);
                                        if (stud == 'y') {
                                            studies = true;
                                        } else if (stud == 'n') {
                                            studies = false;
                                        } else {
                                            System.out.println("Wrong form input.");
                                            break;
                                        }
                                        studentInfo.registerStudent(id, name, surname, group, studies);
                                    }else{
                                        System.out.println("Wrong id!");
                                        break;
                                    }
                                } catch (InputMismatchException e){
                                    System.out.println("Wrong input!");
                                }
                                break;
                            case 2:
                                try {
                                    System.out.println("Enter student id number:");
                                    int id = scanner.nextInt();
                                    if (studentInfo.getStudentInfo(id) != null) {
                                        System.out.println(studentInfo.getStudentInfo(id));
                                    } else {
                                        System.out.println("There is no student with this id.");
                                    }
                                }catch (InputMismatchException e){
                                    System.out.println("Wrong input!");
                                }
                                break;
                            case 3:
                                try {
                                    System.out.println("Enter group id number:");
                                    int id = scanner.nextInt();
                                    ArrayList<Student> students = studentInfo.getGroupStudents(id);
                                    if (students != null) {
                                        for(Student s:students)
                                            System.out.println(s);
                                    } else {
                                        System.out.println("There is no group with this id.");
                                    }
                                }catch (InputMismatchException e){
                                    System.out.println("Wrong input!");
                                }
                                break;
                            case 4:
                                System.out.println("All students:");
                                ArrayList<Student> students = studentInfo.getAllStudents();
                                if(students.size()>0){
                                    for(Student s:students)
                                        System.out.println(s);
                                }else{
                                    System.out.println("There is no data yet.");
                                }
                                break;
                            case 5:
                                try {
                                    System.out.println("Enter student id number which you want to update:");
                                    int id = scanner.nextInt();
                                    scanner.nextLine();
                                    if (studentInfo.getStudentInfo(id) != null) {
                                        System.out.println("Enter updated student name:");
                                        String name = scanner.nextLine();
                                        System.out.println("Enter updated student surname");
                                        String surname = scanner.nextLine();
                                        System.out.println("Enter updated group id:");
                                        int gId = scanner.nextInt();
                                        Group group = studentInfo.getGroupInfo(gId);
                                        System.out.println("Does he studies? Y/N");
                                        Character stud = scanner.next().toLowerCase().charAt(0);
                                        if (stud == 'y') {
                                            studies = true;
                                        } else if (stud == 'n') {
                                            studies = false;
                                        } else {
                                            System.out.println("Wrong form input.");
                                            break;
                                        }
                                        studentInfo.updateStudent(id, name, surname, group, studies);
                                    }
                                }catch (InputMismatchException e){
                                    System.out.println("Wrong input!");
                                }
                                break;
                            case 6:
                                System.out.println("Enter student id number which you want to delete:");
                                int id = scanner.nextInt();
                                if(studentInfo.getStudentInfo(id)!=null){
                                    studentInfo.removeStudent(id);
                                }else{
                                    System.out.println("There is no student with this id.");
                                }
                                break;
                            case 7:
                                try{
                                    DataOutputStream file = new DataOutputStream(new FileOutputStream("Student.csv"));
                                    for(Student student : studentInfo.getAllStudents()){
                                        file.writeUTF(student.getgId() + ";" + student.getId() + ";" + student.getName() + ";" + student.getSurname() + ";" + student.getGroup() + ";" + student.isStudies() + '\n');
                                    }
                                    file.close();
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                break;
                            case 8:
                                try{
                                    Scanner file = new Scanner(new File("Student.csv"));
                                    int stCounter = 0;
                                    for (Student student:studentInfo.getAllStudents()){
                                        if(student.getId()>stCounter){
                                            stCounter = student.getId();
                                        }
                                    }
                                    Student.setCodeGenerate(stCounter+1);
                                    while (file.hasNext()){
                                        String line = file.nextLine().trim();
                                        if(line.length()>0){
                                            String[] part = line.split(";");
                                            int gId = parseInt(part[0].trim().substring(1));
                                            boolean bool = Boolean.parseBoolean(part[5]);
                                            Group group = studentInfo.getGroupInfo(gId);
                                            studentInfo.registerStudent(gId, part[2], part[3], group, bool);

                                        }
                                    }
                                    file.close();
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                break;
                            case 9:
                                System.out.println("Back.");
                                caserun = false;
                                break;
                            default:
                                System.out.println("There is no such command.");
                        }//switch
                    }//while
                    break;
                case 4:
                    try{
                        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data"));
                        out.writeObject(studentInfo);
                        out.close();
                        System.out.println("Data exported.");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    System.out.println("Exit");
                    run = false;
                    break;
                default:
                    System.out.println("There is no such command.");
                    break;
            }//switch
        }//main while
    }//main
}//class
