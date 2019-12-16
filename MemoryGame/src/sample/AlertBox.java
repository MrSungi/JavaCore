package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
    public static void display(String title, String message) {
        Stage newStage = new Stage();

        //Block events to other windows
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.setTitle(title);
        newStage.setMinWidth(250);


        //make & declare components
        Label label = new Label();
        label.setText(message);
        label.setFont(new Font("Arial",18));

        Button closeButton = new Button("Close this window");
        closeButton.setOnAction(e -> newStage.close());


        //make & put stuff into the Layout
        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        newStage.setScene(scene);
        newStage.showAndWait();
    }
}
