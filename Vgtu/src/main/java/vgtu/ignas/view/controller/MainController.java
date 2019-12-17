package vgtu.ignas.view.controller;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import vgtu.ignas.controller.StudentInfo;
import vgtu.ignas.model.StudyProgram;

import java.net.URL;
import java.util.ResourceBundle;


public class MainController implements Initializable {

    private StudentInfo studentInfo = null;

    public void setStudentInfo(StudentInfo s){
        studentInfo = s;
        showSP(null);
    }

    @FXML
    private TextField SPfilter;

    @FXML
    private TableView SPtable;

    @FXML
    private VBox groupTable;

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

    public void close(Event event){
        Platform.exit();
    }



    public void initialize(URL location, ResourceBundle resources) {
        TableColumn<String, StudyProgram> column1 = new TableColumn<String, StudyProgram>("Department");
        column1.setCellValueFactory(new PropertyValueFactory<String, StudyProgram>("Department"));

        TableColumn<String, StudyProgram> column2 = new TableColumn<String, StudyProgram>("SP name");
        column2.setCellValueFactory(new PropertyValueFactory<String, StudyProgram>("name"));

        SPtable.getColumns().clear();
        SPtable.getColumns().add(column1);
        SPtable.getColumns().add(column2);

        groupTable.setVisible(false);
        // SPtable.getItems().add(new StudyProgram("Informacinės technologijos", "IT"));
        // SPtable.getItems().add(new StudyProgram("Matematika", "MAT"));
        // SPtable.getItems().add(new StudyProgram("Informacinės technologijos", "IT"));


    }
}
