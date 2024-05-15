/**
 * Sample Skeleton for 'primary.fxml' Controller Class
 */

package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML // fx:id="A_btn"
    private Button A_btn; // Value injected by FXMLLoader

    @FXML // fx:id="B_btn1"
    private Button B_btn1; // Value injected by FXMLLoader

    @FXML // fx:id="D_btn"
    private Button D_btn; // Value injected by FXMLLoader

    @FXML // fx:id="F_btn"
    private Button F_btn; // Value injected by FXMLLoader

    @FXML // fx:id="clr_btn"
    private Button clr_btn; // Value injected by FXMLLoader

    @FXML // fx:id="displayTF"
    private TextField displayTF; // Value injected by FXMLLoader

    @FXML // fx:id="div_btn"
    private Button div_btn; // Value injected by FXMLLoader

    @FXML // fx:id="eq_btn"
    private Button eq_btn; // Value injected by FXMLLoader

    @FXML // fx:id="mul_btn"
    private Button mul_btn; // Value injected by FXMLLoader

    @FXML // fx:id="nine_btn"
    private Button nine_btn; // Value injected by FXMLLoader

    @FXML // fx:id="six_btn"
    private Button six_btn; // Value injected by FXMLLoader

    @FXML // fx:id="three_btn"
    private Button three_btn; // Value injected by FXMLLoader

    @FXML // fx:id="zero_btn"
    private Button zero_btn; // Value injected by FXMLLoader

    @FXML
    void printHello(ActionEvent event) {
        displayTF.setText("Hello working");
        System.out.println("Hello");
    }

}
