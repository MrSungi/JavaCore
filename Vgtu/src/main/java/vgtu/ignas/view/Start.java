package vgtu.ignas.view;

import com.sun.javafx.scene.control.skin.resources.ControlResources;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vgtu.ignas.controller.StudentInfo;
import vgtu.ignas.model.StudyForm;
import vgtu.ignas.view.controller.MainController;

public class Start extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader load = new FXMLLoader();
        load.setLocation(getClass().getClassLoader().getResource("Main.fxml"));
        Parent root = load.load();

        StudentInfo studentInfo = new StudentInfo();
        studentInfo.createStudyProgram("Informacines technologijos", "IT");
        studentInfo.createStudyProgram("Matematika", "MAT");
        studentInfo.createStudyProgram("asfasfasfa", "IT");
        studentInfo.createStudyProgram("safijos", "IT");
        studentInfo.createGroup(1, "ISit-17", StudyForm.INDIRECT, 2017);
        studentInfo.createGroup(2, "Prif-16", StudyForm.PROLONGED, 2016);
        studentInfo.createGroup(3, "Kiki-18", StudyForm.INDIRECT, 2018);
        studentInfo.createGroup(4, "Mat-15", StudyForm.PROLONGED, 2015);
        studentInfo.registerStudent(1,"Ignas", "Sungaila", studentInfo.getGroupInfo(1), true);
        studentInfo.registerStudent(2,"Jonas", "Jonaitis", studentInfo.getGroupInfo(2), true);
        studentInfo.registerStudent(3,"Petras", "Petraitis", studentInfo.getGroupInfo(3), false);
        studentInfo.registerStudent(4,"Martynas", "Martinaitis", studentInfo.getGroupInfo(4), false);
        MainController mainController = load.getController();
        mainController.setStudentInfo(studentInfo);
        Scene scene = new Scene(root);
        primaryStage.setTitle("Laboratorinis 3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
