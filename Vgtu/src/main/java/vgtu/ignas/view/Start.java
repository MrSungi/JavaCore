package vgtu.ignas.view;

import com.sun.javafx.scene.control.skin.resources.ControlResources;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vgtu.ignas.controller.StudentInfo;
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
