package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Sphere;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Timer;
import java.util.TimerTask;

public class Controller {
    @FXML
    Button btn;

    @FXML
    Label lbl;

    @FXML
    TextField txt, txt2;

    @FXML
    AudioClip submarineSound = new AudioClip("https://github.com/opendream/ODOpenAlarm/blob/master/sounds/Submarine.aiff?raw=true");

    @FXML
    Circle circle;

    @FXML
    public void btn_Click(ActionEvent e) {
        System.out.println("My First Button Click");
        String greet = txt.getText();
        String name = txt2.getText();
        System.out.println(name + greet);
        lbl.setText(greet+ ", " + name + "!");
    }



    @FXML
    public void pressEnter (KeyEvent e){
        if(e.getCode() == KeyCode.ENTER){
            System.out.println("Enter pressed");
            String greet = txt.getText();
            String name = txt2.getText();
            System.out.println(greet+ ", " + name + "!");
            lbl.setText(greet+ ", " + name + "!");
            // submarineSound.play();

        }
    }

    @FXML
    public void sound (KeyEvent e){
        if(e.getCode() == KeyCode.K){
            submarineSound.play();
        }
    }
    int r = 0, g= 0, b = 0;
    @FXML
    public void circle_Click(MouseEvent e){
        boolean circleOn = false;

        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
               /*circleOn = !circleOn;
                if (circleOn){
                    circle.setFill(Color.GREEN);
                }else{
                    circle.setFill(Color.RED);
                }*/
                circle.setFill(Color.rgb(r++, g++, b++));
            }
        },0, 100);

        };
    }


