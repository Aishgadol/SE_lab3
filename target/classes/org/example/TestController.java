package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Callback;

import javax.tools.Tool;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class TestController implements Initializable {

    @FXML
    private HBox imageHBox;

    @FXML
    private Button addImgBtn;

    @FXML
    void addImg(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files","*.png","*.jpg","*.jpeg"));
        List<File> files=fileChooser.showOpenMultipleDialog(imageHBox.getScene().getWindow());

        if(files!=null){
            for(File f : files){
                try {
                    Image image = new Image(f.toURI().toString());
                    ImageView imageView = new ImageView(image);

                    imageView.setFitHeight(200);
                    imageView.setFitWidth(200);
                    imageView.setPreserveRatio(true);

                    Label nameLabel=new Label(f.getName());

                    StackPane imageContainer=new StackPane();
                    imageContainer.getChildren().addAll(imageView,nameLabel);

                    //add tooltip
                    Tooltip tooltip = new Tooltip(f.getName());
                    Tooltip.install(imageView,tooltip);

                    imageHBox.getChildren().add(imageContainer);
                }catch(Exception e){
                    Alert alert = new Alert(AlertType.ERROR, "Failed to load image: " + f.getName());
                    alert.showAndWait();
                }
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        imageHBox.getStyleClass().add("image-view-with-border");
    }
}
