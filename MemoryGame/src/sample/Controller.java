package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    List<ImgInfoObject> myList;
    int turns=0;
    int check=0;
    int solved=0;
    boolean success;
    ImageView lastOpened1, lastOpened2;
    Image clickMe;
    Long startTime;


    @FXML
    public void click(MouseEvent e) {
        turns++;
        ImageView tempImgV = (ImageView) e.getSource();
        String id = tempImgV.getId();
        int index = Integer.valueOf(id);


        if(turns%2!=0){
            if( (!success) && (turns!=1) ){
                lastOpened1.setImage(clickMe);
                lastOpened2.setImage(clickMe);
            }
            else{
                success=false;
            }
            lastOpened1=tempImgV;
            check = index;

        }
        else{
            lastOpened2 = tempImgV;

            ImgInfoObject obj = myList.get(index);
            String name1 = obj.getImgName();

            obj = myList.get(check);
            String name2 = obj.getImgName();

            if(name1.equals(name2)){
                success=true;
                solved=solved + 2;
            }


        }


        //Load the correct image from the list
        ImgInfoObject obj = myList.get(index);
        Image image = obj.getImg();
        tempImgV.setImage(image);
        //System.out.println("done..." + tempImgV.getId());

        if (solved == 16) {
            Long timeTaken = System.currentTimeMillis() - startTime;
            int t = (int) (timeTaken / 1000);
            Celebration(t);//declareVictory
        }
    }
    private void Celebration(int t){
        AlertBox.display("VICTORY", "Turns: " + turns + "\nTime: " + t);
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clickMe = new Image("img/big_red_button.jpg");

        myList = new ArrayList<>();
        ImgInfoObject obj;

        obj = new ImgInfoObject("capt", new Image("img/capt.png"));
        myList.add(obj);
        myList.add(obj);
        obj = new ImgInfoObject("bat", new Image("img/bat.png") );
        myList.add(obj);
        myList.add(obj);
        obj = new ImgInfoObject("flash", new Image("img/flash.png") );
        myList.add(obj);
        myList.add(obj);
        obj = new ImgInfoObject("hulk", new Image("img/hulk.png") );
        myList.add(obj);
        myList.add(obj);
        obj = new ImgInfoObject("iron", new Image("img/iron.jpeg") );
        myList.add(obj);
        myList.add(obj);
        obj = new ImgInfoObject("super", new Image("img/super.png") );
        myList.add(obj);
        myList.add(obj);
        obj = new ImgInfoObject("thor", new Image("img/thor.jpeg") );
        myList.add(obj);
        myList.add(obj);
        obj = new ImgInfoObject("wolf", new Image("img/wolf.png") );
        myList.add(obj);
        myList.add(obj);

        myList.stream().forEach(o -> System.out.println(o.getImgName()));



        Random rnd = new Random();

        for (int i =0; i<10 ; i ++){

            int x = rnd.nextInt(16);
            int y = rnd.nextInt(16);
            System.out.println(x+"|"+y);
            ImgInfoObject tempObjX = myList.get(x);
            ImgInfoObject tempObjY = myList.get(y);

            myList.set(x,tempObjY);
            myList.set(y,tempObjX);
        }

        myList.stream().forEach(o -> {System.out.println(o.getImgName());});

        startTime = System.currentTimeMillis();

    }


}
