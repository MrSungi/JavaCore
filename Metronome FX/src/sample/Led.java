package sample;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class Led extends Label {

    public static enum Status {
        FIRST,
        OTHER,
        OFF,
    }

    public Led(){
        super("●");
        setStatus(Status.OFF);
    }
public void setStatus(Status ledStatus){
        if (ledStatus == Status.FIRST){
            setTextFill(Color.RED);
        }
        else if (ledStatus == Status.OTHER){
            setTextFill(Color.YELLOW);
        }
        else{
            setTextFill(Color.GRAY);
        }

}


}
