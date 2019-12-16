package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    Button btn1, btn2;

    @FXML
    public void Clicks(ActionEvent e){
        Button temp = (Button)e.getSource();
        String id = temp.getId();
        System.out.println("Clicked " + id);

        temp.setText("Woohoo");
        temp.setDisable(true);
    }



}
