package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
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
                    nameLabel.setAlignment(Pos.CENTER);

                    VBox imageContainer=new VBox();
                    imageContainer.getChildren().addAll(imageView,nameLabel);
                    imageContainer.setAlignment(Pos.CENTER);

                    //add tooltip
                    Tooltip tooltip = new Tooltip(f.getName());
                    Tooltip.install(imageView,tooltip);

                    imageHBox.getChildren().add(imageContainer);
                    imageHBox.setAlignment(Pos.CENTER);
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
