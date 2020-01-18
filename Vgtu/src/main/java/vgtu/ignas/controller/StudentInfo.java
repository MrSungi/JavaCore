package vgtu.ignas.controller;

import vgtu.ignas.model.Group;
import vgtu.ignas.model.Student;
import vgtu.ignas.model.StudyForm;
import vgtu.ignas.model.StudyProgram;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;

public class StudentInfo implements Serializable {
    private String url = "jdbc:mysql://localhost:3306/university";
    private String user = "root";
    private String password = "";
    private Connection connection = null;

    ArrayList<StudyProgram> programs = new ArrayList();

    public boolean connectToDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("successfully connected");
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("true");
        return false;
    }

    public boolean disconnectFromDB(){
        try {
            connection.close();
            System.out.println("successfully disconnected");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public void createStudyProgram(String name, String department){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into studyprogram"
                    + "(program_id, name, department) values "
                    + "(null, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, department);
            preparedStatement.executeUpdate();
            System.out.println("added");
            System.out.println(name + "sss");
            System.out.println(department);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<StudyProgram> getAllStudyPrograms() {
        ArrayList<StudyProgram> returnList = new ArrayList<StudyProgram>();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from studyprogram");
            while (resultSet.next()){
                int code = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String department = resultSet.getString(3);
                StudyProgram newSP = new StudyProgram(name, department);
                newSP.setCode(code);
                returnList.add(newSP);
            }
        }catch (Exception e){

        }
        return returnList;
    }

    public ArrayList<StudyProgram> getFilteredStudyPrograms(String filter) {
        ArrayList<StudyProgram> filt = new ArrayList<StudyProgram>();
        filter = filter.toLowerCase();
        for(StudyProgram s:getAllStudyPrograms()){
            if(s.getDepartment().toLowerCase().contains(filter) || s.getName().toLowerCase().contains(filter)){
                filt.add(s);
            }
        }
        return filt;
    }

    public ArrayList<Group> getFilteredGroups(String filter) {
        ArrayList<Group> filt = new ArrayList<Group>();
        filter = filter.toLowerCase();

        for(Group s:getAllGroups()){
            if(s.getCode().toLowerCase().contains(filter)){
                filt.add(s);
            }
        }
        return filt;
    }

    public ArrayList<Student> getFilteredStudents(String filter) {
        ArrayList<Student> filt = new ArrayList<Student>();
        filter = filter.toLowerCase();

        for(Student s:getAllStudents()){
            if(s.getName().toLowerCase().contains(filter) || s.getSurname().toLowerCase().contains(filter)){
                filt.add(s);
            }
        }
        return filt;
    }


    public StudyProgram getStudyProgramInfo(int id) {
        for (StudyProgram sp : programs) {
            if (sp.getCode() == id) {
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
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from studyprogram where program_id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }catch (Exception e){
        }
    }

    public void updateStudyProgram(int id, String name, String departament) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("update studyprogram set name = ?, department = ? where program_id = ?");
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,departament);
            preparedStatement.setInt(3,id);
            preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateStudent(int id, String name, String surname, int group_id){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("update student set name = ?, surname = ?, group_id = ? where student.student_id = ?");
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,surname);
            preparedStatement.setInt(3,group_id);
            preparedStatement.setInt(4,id);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void createGroup(int spId, String code, StudyForm s, int year){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `groups` (`group_id`, `code`, `form`, `year`, `program_id`) "
                                                      + "VALUES (NULL, ?, ?, ?, ?)");
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, s.toString());
            preparedStatement.setInt(3, year);
            preparedStatement.setInt(4, spId);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Group> getStudyProgramGroups(int spId){
        ArrayList<Group> returnList = new ArrayList<Group>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select * from groups where program_id = ?");
            preparedStatement.setInt(1,spId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String code = resultSet.getString(2);
                StudyForm form = StudyForm.valueOf(resultSet.getString(3));
                int year = resultSet.getInt(4);
                int SpId = resultSet.getInt(5);
                Group group = new Group(SpId,code,form,year);
                group.setId(id);
                returnList.add(group);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnList;
    }

    public ArrayList<Group> getAllGroups(){
        ArrayList<Group> returnList = new ArrayList<Group>();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from groups");
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String code = resultSet.getString(2);
                StudyForm form = StudyForm.valueOf(resultSet.getString(3));
                int year = resultSet.getInt(4);
                int SpId = resultSet.getInt(5);
                Group group = new Group(SpId,code,form,year);
                group.setId(id);
                returnList.add(group);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnList;
    }

    public void deleteGroup(int gId){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from groups where group_id = ?");
            preparedStatement.setInt(1, gId);
            preparedStatement.executeUpdate();
        }catch (Exception e){

        }
    }

    public void updateGroup(int id, String code, StudyForm form, int year){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("update groups set code = ?, form = ?, year = ? where group_id = ?");
            preparedStatement.setString(1,code);
            preparedStatement.setString(2,form.toString());
            preparedStatement.setInt(3,year);
            preparedStatement.setInt(4,id);
            preparedStatement.executeUpdate();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void registerStudent(int gId, String name, String surname){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `student` " +
                            "(`student_id`, `name`, `surname`, `group_id`)" +
                            " VALUES (NULL, ?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setInt(3, gId);
            preparedStatement.executeUpdate();
            System.out.println("ok");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Student> getGroupStudents(int gId){
        ArrayList<Student> returnList = new ArrayList<Student>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student where group_id = ?");
            preparedStatement.setInt(1,gId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                int grId = resultSet.getInt(4);
                Student student = new Student(grId,name,surname,getGroupInfo(grId));
                student.setId(id);
                returnList.add(student);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnList;
    }

    public ArrayList<Student> getAllStudents(){
        ArrayList<Student> returnList = new ArrayList<Student>();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                int gId = resultSet.getInt(4);
                Student student = new Student(gId,name,surname,getGroupInfo(gId));
                student.setId(id);
                returnList.add(student);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnList;
    }

    public void removeStudent(int sId){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from student where student.student_id = ?");
            preparedStatement.setInt(1, sId);
            preparedStatement.executeUpdate();
            System.out.println(getStudentInfo(sId));
            System.out.println("deleted");
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}//class