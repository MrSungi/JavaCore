package vgtu.ignas.view.controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vgtu.ignas.controller.StudentInfo;
import vgtu.ignas.model.Group;


public class StudentController {
    private StudentInfo studentInfo = null;
    private int selectedId;

    @FXML
    Label Id;

    @FXML
    private TextField gId;

    @FXML
    private TextField updateID;

    @FXML
    private TextField name;

    @FXML
    private TextField surname;

    @FXML
    private RadioButton yes;

    @FXML
    private RadioButton no;

    public void setSelectedId(int id){
        selectedId = id;
    }

    public void showId(){
        Id.setText(String.valueOf(selectedId));
    }

    public void setStudentInfo(StudentInfo s){
        studentInfo = s;
    }

    public void saveStudent(Event e){
        int id = Integer.parseInt(gId.getText());
        String sname = name.getText();
        String ssurname = surname.getText();
        boolean studies = true;


        if(sname.trim().length()<3){
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setTitle("Error");
            err.setHeaderText("Incorrect Student name");
            err.setContentText("Student name must have more than 3 characters!");
            err.showAndWait();
        }
        else if(ssurname.trim().length()<4){
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setTitle("Error");
            err.setHeaderText("Incorrect Student surname");
            err.setContentText("Student surname must have more than 4 characters!");
            err.showAndWait();
        } else{
            if(studentInfo!=null){
                System.out.println("Addded");
                Group g = studentInfo.getGroupInfo(id);
                studentInfo.registerStudent(id,sname,ssurname,g, studies);
            }
        }
        Stage stage = (Stage)name.getScene().getWindow();
        stage.close();
    }


    public void updateStudent(Event e){
        String sname = name.getText();
        String ssurname = surname.getText();
        boolean studies = true;


        if(sname.trim().length()<3){
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setTitle("Error");
            err.setHeaderText("Incorrect Student name");
            err.setContentText("Student name must have more than 3 characters!");
            err.showAndWait();
        }
        else if(ssurname.trim().length()<4){
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setTitle("Error");
            err.setHeaderText("Incorrect Student surname");
            err.setContentText("Student surname must have more than 4 characters!");
            err.showAndWait();
        } else{
            if(studentInfo!=null){
                System.out.println("Updated");
                Group g = studentInfo.getGroupInfo(Integer.parseInt(updateID.getText()));
                studentInfo.updateStudent(selectedId,sname,ssurname,g, studies);
            }
        }

        Stage stage = (Stage)name.getScene().getWindow();
        stage.close();
    }


}
