package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.Random;

public class Controller {

    @FXML
    Button btn;



    @FXML
    public void click(ActionEvent e){
        System.out.println("On CLick");
    }

    @FXML
    public void mouseOver(){
        Random rnd = new Random();
        int x = rnd.nextInt(550);
        int y = rnd.nextInt(550);
        System.out.println(x + "|" + y);

        btn.setLayoutX(x);
        btn.setLayoutY(y);

    }

}
