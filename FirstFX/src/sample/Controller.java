package sample;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    Button btn, btn2;

    @FXML
    Label lbl;

    @FXML
    TextField txt;


    @FXML
    public void btn_Click(ActionEvent e) {
        System.out.println("My First Button Click");
        String name = txt.getText();
        System.out.println("Hi " + name);
        lbl.setText(name);
    }

    @FXML
    public void pressEnter(KeyEvent e) {
        if (e.getCode() == KeyCode.ENTER) {
            String name = txt.getText();
            System.out.println("Hi " + name);
            lbl.setText(name);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
       /* txt.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                if(event.getCode() == KeyCode.ENTER){
                    String name = txt.getText();
                    System.out.println("Hi " + name);
                    lbl.setText(name);
                }

            }
        });*/
        /////////////////////////


        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("This is the touch Me button");
            }
        });

    }
}









