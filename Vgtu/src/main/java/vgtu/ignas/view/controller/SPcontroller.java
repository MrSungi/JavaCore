package vgtu.ignas.view.controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vgtu.ignas.controller.StudentInfo;

import java.net.URL;
import java.util.ResourceBundle;

public class SPcontroller implements Initializable {

    @FXML
    private ComboBox<String> SPdepartment;

    @FXML
    private ComboBox<String> UpdateSPdepartment;

    @FXML
    private TextField UpdateSpName;

    @FXML
    private TextField SPname;

    private StudentInfo studentInfo = null;
    private int selectedId;


    public void setSelectedId(int id){
        selectedId = id;
    }

    public void setStudentInfo(StudentInfo s){
        studentInfo = s;
    }

    public void saveSP(Event e){
        String name = SPname.getText();
        String department = SPdepartment.getSelectionModel().getSelectedItem();
        if(name.trim().length()<3){
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setTitle("Error");
            err.setHeaderText("Incorrect Study program name");
            err.setContentText("Study program name must have more than 3 characters!");
            err.showAndWait();
        }
        else{
            if(studentInfo!=null){
                System.out.println("Addded");
                studentInfo.createStudyProgram(name,department);
                Stage stage = (Stage)SPdepartment.getScene().getWindow();
                stage.close();
            }
        }
    }

    public void updateSP(Event e){
        String name = UpdateSpName.getText();
        String department = SPdepartment.getSelectionModel().getSelectedItem();
        if(name.trim().length()<3){
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setTitle("Error");
            err.setHeaderText("Incorrect Study program name");
            err.setContentText("Study program name must have more than 3 characters!");
            err.showAndWait();
        }
        else{
            if(studentInfo!=null){
                System.out.println("Updated");
                studentInfo.updateStudyProgram(selectedId,name,department);
                Stage stage = (Stage)SPdepartment.getScene().getWindow();
                stage.close();
            }
        }
    }



    public void initialize(URL location, ResourceBundle resources) {
        SPdepartment.getItems().add("IT katedra");
        SPdepartment.getItems().add("IT asdasdasd");
        SPdepartment.getSelectionModel().selectFirst();
    }
}
