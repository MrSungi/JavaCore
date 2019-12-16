package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;


import java.io.IOException;
import java.net.URL;
import java.util.*;


public class Controller implements Initializable {
    @FXML
    TextField typeWord;
    @FXML
    TextArea correctWord;
    @FXML
    Button restart;
    @FXML
    Label countdown;
    @FXML
    Label wpm;
    @FXML
    Label score;
    @FXML
    Label lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10, lb11, lb12, lb13, lb14, lb15, lb16, lb17, lb18, lb19, lb20, lb21, lb22, lb23, lb24;
    private static final Integer STARTTIME = 60;
    private Integer timeSeconds = STARTTIME;
    private Timeline timeline;
    List<Label> wordsList = new ArrayList<>();
    int k =0;
    private Integer wpmCount = 0;
    private Integer count = 0;
    public Timer t = new Timer();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        restart.setText("Start");
        wpm.setText("0");
        score.setText("");

        wordsList.add(lb1);
        wordsList.add(lb2);
        wordsList.add(lb3);
        wordsList.add(lb4);
        wordsList.add(lb5);
        wordsList.add(lb6);
        wordsList.add(lb7);
        wordsList.add(lb8);
        wordsList.add(lb9);
        wordsList.add(lb10);
        wordsList.add(lb11);
        wordsList.add(lb12);
        wordsList.add(lb13);
        wordsList.add(lb14);
        wordsList.add(lb15);
        wordsList.add(lb16);
        wordsList.add(lb17);
        wordsList.add(lb18);
        wordsList.add(lb19);
        wordsList.add(lb20);
        wordsList.add(lb21);
        wordsList.add(lb22);
        wordsList.add(lb23);
        wordsList.add(lb24);

        Random rnd = new Random();

        for (int i =0; i<10 ; i ++){

            int x = rnd.nextInt(16);
            int y = rnd.nextInt(16);
            System.out.println(x+"|"+y);
            String templabelx = wordsList.get(x).getText();
            String templabely = wordsList.get(y).getText();

            wordsList.get(x).setText(templabely);
            wordsList.get(y).setText(templabelx);
        }

        wordsList.stream().forEach(o -> {System.out.println(o.getText());});
        t.timer();

    }


    @FXML
    public void press(KeyEvent e){
        if (e.getCode() == KeyCode.ENTER){



                if (wordsList.get(k).getText().equals(typeWord.getText())) {
                    wordsList.get(k).setTextFill(Color.GREEN);
                    System.out.println("true");
                    System.out.println(wordsList.get(k).getText());
                    System.out.println(typeWord.getText());
                    k++;
                    count++ ;

                    wpm.setText(count.toString());


                } else {
                    wordsList.get(k).setTextFill(Color.RED);
                    System.out.println("false");
                    System.out.println(wordsList.get(k).getText());
                    System.out.println(typeWord.getText());
                    k++;

                }
        if(wordsList.size()<= k){
            k=0;
            score.setText("Your score is " + count + "/24 right words in " + (60 - timeSeconds) + " seconds");
            t.stop();
        }
        typeWord.setText("");
            }

        }



    @FXML
    public void restart (ActionEvent e){
        if(restart.getText().equals("Start")){
            t.play();
        }else{
            t.restart();
        }

        restart.setText("Restart");


        for(int i = 0; i < wordsList.size();i++){

            wordsList.get(i).setTextFill(Color.GRAY);
        }

        count = 0;
        wpm.setText(count.toString());
        k = 0;




        Random rnd = new Random();

        for (int i =0; i<10 ; i ++){

            int x = rnd.nextInt(24);
            int y = rnd.nextInt(24);
            System.out.println(x+"|"+y);
            String templabelx = wordsList.get(x).getText();
            String templabely = wordsList.get(y).getText();

            wordsList.get(x).setText(templabely);
            wordsList.get(y).setText(templabelx);
        }

    }



    public class Timer {


        Timeline timeline = new Timeline();

        public void timer(){
            timeSeconds = STARTTIME;

            timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
                timeSeconds--;
                countdown.setText(timeSeconds.toString());
                if(timeSeconds == 0){
                    score.setText("Sorry, you are out of time!!!");
                }

            }));

            timeline.setCycleCount(60);
        }

        public void play(){
            timeline.play();
        }

        public void restart(){
            timeline.stop();
            timeline.setCycleCount(60);
            timeline.play();
            timeSeconds = STARTTIME;
        }

        public void stop(){
            timeline.stop();
        }

    }


}//class
