package vgtu.ignas.view.controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import vgtu.ignas.controller.StudentInfo;
import vgtu.ignas.model.StudyForm;


import java.net.URL;
import java.util.ResourceBundle;

public class GroupController implements Initializable {
    private StudentInfo studentInfo = null;
    private int selectedId;

    @FXML
    TextField SpId;

    @FXML
    TextField code;

    @FXML
    ComboBox<String> form;

    @FXML
    TextField year;

    @FXML
    Label Id;


    public void setSelectedId(int id){
        selectedId = id;
    }

    public void showId(){
        Id.setText(String.valueOf(selectedId));
    }

    public void setStudentInfo(StudentInfo s){
        studentInfo = s;
    }



    public void saveGroup(Event e){
        int id = Integer.parseInt(SpId.getText());
        String ssform = form.getSelectionModel().getSelectedItem();
        StudyForm sform = StudyForm.valueOf(ssform);
        String gcode = code.getText();
        int gyear = Integer.parseInt(year.getText());
        if(gcode.trim().length()<3){
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setTitle("Error");
            err.setHeaderText("Incorrect Group code");
            err.setContentText("Group code must have more than 3 characters!");
            err.showAndWait();
        }
        else if(gyear < 2010 || gyear >2020) {
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setTitle("Error");
            err.setHeaderText("Incorrect Group year");
            err.setContentText("Group year must be between 2010 - 2020");
            err.showAndWait();
        }else{
            if(studentInfo!=null){
                System.out.println("Addded");
                studentInfo.createGroup(id,gcode,sform,gyear);
                Stage stage = (Stage)form.getScene().getWindow();
                stage.close();
            }
        }
    }


    public void updateGroup(Event e){
        String ssform = form.getSelectionModel().getSelectedItem();
        StudyForm sform = StudyForm.valueOf(ssform);
        String gcode = code.getText();
        int gyear = Integer.parseInt(year.getText());
        if(gcode.trim().length()<3){
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setTitle("Error");
            err.setHeaderText("Incorrect Group code");
            err.setContentText("Group code must have more than 3 characters!");
            err.showAndWait();
        }
        else if(gyear < 2010 || gyear >2020) {
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setTitle("Error");
            err.setHeaderText("Incorrect Group year");
            err.setContentText("Group year must be between 2010 - 2020");
            err.showAndWait();
        }else{
            if(studentInfo!=null){
                System.out.println("Updated");
                studentInfo.updateGroup(selectedId, gcode, sform, gyear);
                Stage stage = (Stage)form.getScene().getWindow();
                stage.close();
            }
        }
    }


    public void initialize(URL location, ResourceBundle resources) {
        form.getItems().add("INDIRECT");
        form.getItems().add("PROLONGED");

        form.getSelectionModel().selectFirst();

    }

}
