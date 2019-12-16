package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


import java.io.File;
import java.net.URI;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {



    @FXML
    TextField rate;
    TextField ticks;

    @FXML
    Button beater;
    Button pause;

    @FXML

    AudioClip tick = new AudioClip("file:src/resources/Tick.wav");

   @FXML
    TilePane ticksPane;





    public int getRate(){
        int r = Integer.parseInt(rate.getText());

        r = 60000/r;

        return r;
    }

    class Time{
        Timer t = new Timer();
        public void timer() {
        }
        public void play(){
            t.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {

                    tick.play();
                }
            },0  ,getRate());
        }

        public void stop(){
            t.cancel();
        }

    }

   Time t = new Time();

    @FXML
    public void beat(ActionEvent e){

        t.play();
    }

    @FXML
    public void pause(ActionEvent e){
        t.stop();
    }




}
