package vgtu.ignas.view.controller;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import vgtu.ignas.controller.StudentInfo;
import vgtu.ignas.model.Group;
import vgtu.ignas.model.Student;
import vgtu.ignas.model.StudyProgram;

import java.net.URL;
import java.util.ResourceBundle;


public class MainController implements Initializable {

    private StudentInfo studentInfo = null;
    private int selectedId;


    public void setStudentInfo(StudentInfo s){
        studentInfo = s;
        showSP(null);
    }



    public void setStudyProgram(StudyProgram studyProgram){

    }

    @FXML
    private TextField groupFilter;

    @FXML
    private TextField SPfilter;

    @FXML
    private TextField studentFilter;

    @FXML
    private Label connection;

    @FXML
    private TableView SPtable;

    @FXML
    private TableView studentTable;

    @FXML
    private TableView groupTable;

    public void showSP(Event event){
        System.out.println(studentInfo.getAllStudyPrograms());
        SPtable.getItems().clear();

        System.out.println(studentInfo.getAllStudyPrograms());
        if (studentInfo != null){
            SPtable.getItems().clear();
            String filter = SPfilter.getText();
            SPtable.getItems().addAll(studentInfo.getFilteredStudyPrograms(filter));
        }
    }

    public void showGroup(Event event){
        System.out.println(studentInfo.getAllGroups());
        groupTable.getItems().clear();
        System.out.println(studentInfo.getAllGroups());
        if (studentInfo != null){
            groupTable.getItems().clear();
            StudyProgram SP = (StudyProgram)SPtable.getSelectionModel().getSelectedItem();
            selectedId = SP.getCode();
            groupTable.getItems().addAll(studentInfo.getStudyProgramGroups(selectedId));

        }

    }

    public void showStudent(Event event){
        System.out.println(studentInfo.getAllStudents());
        studentTable.getItems().clear();
        System.out.println(studentInfo.getAllStudents());

        if (studentInfo != null){
            studentTable.getItems().clear();
            Group group = (Group) groupTable.getSelectionModel().getSelectedItem();
            selectedId = group.getId();
            studentTable.getItems().addAll(studentInfo.getGroupStudents(selectedId));

        }
    }

    public void showFilteredGroup(Event event){
        System.out.println(studentInfo.getAllGroups());
        groupTable.getItems().clear();
        System.out.println(studentInfo.getAllGroups());

        if (studentInfo != null){
            groupTable.getItems().clear();
            String filter = groupFilter.getText();
            groupTable.getItems().addAll(studentInfo.getFilteredGroups(filter));
        }
    }

    public void showFilteredStudent(Event event){
        System.out.println(studentInfo.getAllStudents());
        studentTable.getItems().clear();
        System.out.println(studentInfo.getAllStudents());

        if (studentInfo != null){
            studentTable.getItems().clear();
            String filter = studentFilter.getText();
            studentTable.getItems().addAll(studentInfo.getFilteredStudents(filter));
        }
    }

    public void connect(Event event){
        if (studentInfo.connectToDB()){
            connection.setText("Connected");
            showSP(null);
            showFilteredGroup(null);
            showFilteredStudent(null);
        }
    }

    public void disconnect(Event event){
        studentInfo.disconnectFromDB();
        if (studentInfo.disconnectFromDB()){
            connection.setText("Disconnected");
        }
    }


    public void openAddStudyProgram(Event e) throws Exception{
        FXMLLoader load = new FXMLLoader();
        load.setLocation(getClass().getClassLoader().getResource("SPadd.fxml"));
        Parent root = load.load();


        SPcontroller SPcontroller = load.getController();
        SPcontroller.setStudentInfo(studentInfo);
        Scene scene = new Scene(root);
        Stage add = new Stage();
        add.setTitle("Add Study program");
        add.setScene(scene);
        add.showAndWait();
        showSP(null);

    }

    public void openAddGroup(Event event) throws Exception{
        FXMLLoader load = new FXMLLoader();
        load.setLocation(getClass().getClassLoader().getResource("GroupAdd.fxml"));
        Parent root = load.load();

        GroupController groupController = load.getController();
        groupController.setStudentInfo(studentInfo);
        Scene scene = new Scene(root);
        Stage add = new Stage();
        add.setTitle("Add Group");
        add.setScene(scene);
        add.showAndWait();
        showFilteredGroup(null);

    }

    public void openAddStudent(Event event) throws Exception{
        FXMLLoader load = new FXMLLoader();
        load.setLocation(getClass().getClassLoader().getResource("StudentAdd.fxml"));
        Parent root = load.load();

        StudentController studentController = load.getController();
        studentController.setStudentInfo(studentInfo);
        Scene scene = new Scene(root);
        Stage add = new Stage();
        add.setTitle("Add Student");
        add.setScene(scene);
        add.showAndWait();
        showFilteredStudent(null);

    }

    public void openUpdateStudyProgram(Event e) throws Exception{
        FXMLLoader load = new FXMLLoader();
        load.setLocation(getClass().getClassLoader().getResource("SPupdate.fxml"));
        Parent root = load.load();


        SPcontroller SPcontroller = load.getController();
        SPcontroller.setStudentInfo(studentInfo);
        StudyProgram SP = (StudyProgram)SPtable.getSelectionModel().getSelectedItem();
        SPcontroller.setSelectedId(SP.getCode());
        Scene scene = new Scene(root);
        Stage add = new Stage();
        add.setTitle("Update Study program");
        add.setScene(scene);
        add.showAndWait();
        showSP(null);

    }

    public void openUpdateGroup(Event e) throws Exception{
        FXMLLoader load = new FXMLLoader();
        load.setLocation(getClass().getClassLoader().getResource("GroupUpdate.fxml"));
        Parent root = load.load();


        GroupController groupController = load.getController();
        groupController.setStudentInfo(studentInfo);
        Group group = (Group)groupTable.getSelectionModel().getSelectedItem();
        groupController.setSelectedId(group.getId());
        groupController.showId();
        System.out.println("-----------------------------------------");
        System.out.println(group.getId());
        Scene scene = new Scene(root);
        Stage add = new Stage();
        add.setTitle("Update Group");
        add.setScene(scene);
        add.showAndWait();
        showFilteredGroup(null);

    }

    public void openUpdateStudent(Event event) throws  Exception{
        FXMLLoader load = new FXMLLoader();
        load.setLocation(getClass().getClassLoader().getResource("StudentUpdate.fxml"));
        Parent root = load.load();


        StudentController studentController = load.getController();
        studentController.setStudentInfo(studentInfo);
        Student student = (Student)studentTable.getSelectionModel().getSelectedItem();
        studentController.setSelectedId(student.getId());
        studentController.showId();
        System.out.println("-----------------------------------------");
        System.out.println(student.getId());
        Scene scene = new Scene(root);
        Stage add = new Stage();
        add.setTitle("Update Student");
        add.setScene(scene);
        add.showAndWait();
        showFilteredStudent(null);
    }

    public void deleteSP(Event e){
        StudyProgram studyProgram = (StudyProgram)SPtable.getSelectionModel().getSelectedItem();
        if(studentInfo!=null){
            studentInfo.deleteStudyProgram(studyProgram.getCode());
            showSP(null);
        }else{
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setTitle("Error");
            err.setHeaderText("Not chosen any Study Program");
            err.setContentText("Select Study program with a mouse click on a table");
            err.showAndWait();
        }
    }

    public void deleteGroup(Event e){
        Group group = (Group) groupTable.getSelectionModel().getSelectedItem();
        if(studentInfo!=null){
            studentInfo.deleteGroup(group.getId());
            showFilteredGroup(null);
        }else{
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setTitle("Error");
            err.setHeaderText("Not chosen any Group");
            err.setContentText("Select Group with a mouse click on a table");
            err.showAndWait();
        }
    }

    public void deleteStudent(Event event){
        Student student = (Student) studentTable.getSelectionModel().getSelectedItem();
        if(studentInfo!=null){
            System.out.println("Preparing to remove::");
            studentInfo.removeStudent(student.getId());
            System.out.println("removed " + studentInfo.getStudentInfo(student.getId()));
            showFilteredStudent(null);
        }else{
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setTitle("Error");
            err.setHeaderText("Not chosen any Student");
            err.setContentText("Select Student with a mouse click on a table");
            err.showAndWait();
        }
    }


    public void close(Event event){
        Platform.exit();
    }



    public void initialize(URL location, ResourceBundle resources) {
        TableColumn<String, StudyProgram> column1 = new TableColumn<String, StudyProgram>("Department");
        column1.setCellValueFactory(new PropertyValueFactory<String, StudyProgram>("Department"));
        column1.setPrefWidth(140);

        TableColumn<String, StudyProgram> column2 = new TableColumn<String, StudyProgram>("SP name");
        column2.setCellValueFactory(new PropertyValueFactory<String, StudyProgram>("name"));
        column2.setPrefWidth(150);

        TableColumn<String, Group> column3 = new TableColumn<String, Group>("Group code");
        column3.setCellValueFactory(new PropertyValueFactory<String, Group>("code"));

        TableColumn<String,Group> column4 = new TableColumn<String, Group>("Study form");
        column4.setCellValueFactory(new PropertyValueFactory<String, Group>("form"));

        TableColumn<String,Group> column5 = new TableColumn<String, Group>("Year");
        column5.setCellValueFactory(new PropertyValueFactory<String, Group>("year"));

        TableColumn<String, Student> column6 = new TableColumn<String, Student>("Name");
        column6.setCellValueFactory(new PropertyValueFactory<String, Student>("name"));

        TableColumn<String, Student> column7 = new TableColumn<String, Student>("Surname");
        column7.setCellValueFactory(new PropertyValueFactory<String, Student>("surname"));

        TableColumn<String, Student> column8 = new TableColumn<String, Student>("Group");
        column8.setCellValueFactory(new PropertyValueFactory<String, Student>("group"));
        column8.setPrefWidth(200);

        SPtable.getColumns().clear();
        SPtable.getColumns().add(column1);
        SPtable.getColumns().add(column2);

        groupTable.getColumns().clear();
        groupTable.getColumns().add(column3);
        groupTable.getColumns().add(column4);
        groupTable.getColumns().add(column5);

        studentTable.getColumns().clear();
        studentTable.getColumns().add(column6);
        studentTable.getColumns().add(column7);
        studentTable.getColumns().add(column8);

    }
}
