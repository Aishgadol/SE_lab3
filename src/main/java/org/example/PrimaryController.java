/**
 * Sample Skeleton for 'primary.fxml' Controller Class
 */

package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import java.lang.*;

enum Operator{
    ADD,
    SUB,
    MUL,
    DIV
}

enum LastInput{
    OP,
    NUM
}


public class PrimaryController {
    private int sum;
    private String currBase;
    private LastInput lastInput=LastInput.NUM;
    private Operator activeOperator;
    private String expression="";
    @FXML // fx:id="A_btn"
    private Button A_btn; // Value injected by FXMLLoader

    @FXML // fx:id="B_btn"
    private Button B_btn; // Value injected by FXMLLoader

    @FXML // fx:id="C_btn"
    private Button C_btn; // Value injected by FXMLLoader

    @FXML // fx:id="D_btn"
    private Button D_btn; // Value injected by FXMLLoader

    @FXML // fx:id="E_btn"
    private Button E_btn; // Value injected by FXMLLoader

    @FXML // fx:id="F_btn"
    private Button F_btn; // Value injected by FXMLLoader

    @FXML // fx:id="add_btn"
    private Button add_btn; // Value injected by FXMLLoader

    @FXML // fx:id="clr_btn"
    private Button clr_btn; // Value injected by FXMLLoader

    @FXML // fx:id="displayTF"
    private TextField displayTF; // Value injected by FXMLLoader

    @FXML // fx:id="div_btn"
    private Button div_btn; // Value injected by FXMLLoader

    @FXML // fx:id="dropDown"
    private ComboBox<String> dropDown; // Value injected by FXMLLoader

    @FXML // fx:id="eight_btn"
    private Button eight_btn; // Value injected by FXMLLoader

    @FXML // fx:id="eq_btn"
    private Button eq_btn; // Value injected by FXMLLoader

    @FXML // fx:id="five_btn"
    private Button five_btn; // Value injected by FXMLLoader

    @FXML // fx:id="four_btn"
    private Button four_btn; // Value injected by FXMLLoader

    @FXML // fx:id="mul_btn"
    private Button mul_btn; // Value injected by FXMLLoader

    @FXML // fx:id="nine_btn"
    private Button nine_btn; // Value injected by FXMLLoader

    @FXML // fx:id="one_btn"
    private Button one_btn; // Value injected by FXMLLoader

    @FXML // fx:id="seven_btn"
    private Button seven_btn; // Value injected by FXMLLoader

    @FXML // fx:id="six_btn"
    private Button six_btn; // Value injected by FXMLLoader

    @FXML // fx:id="sub_btn"
    private Button sub_btn; // Value injected by FXMLLoader

    @FXML // fx:id="three_btn"
    private Button three_btn; // Value injected by FXMLLoader

    @FXML // fx:id="two_btn"
    private Button two_btn; // Value injected by FXMLLoader

    @FXML // fx:id="zero_btn"
    private Button zero_btn; // Value injected by FXMLLoader




    @FXML
    void pressA(ActionEvent e){
        lastInput = LastInput.NUM;
        expression+="A";
        displayTF.setText(expression);
    }

    @FXML
    void clearScreen(ActionEvent e){
        displayTF.setText("");
        expression="";
    }
    @FXML
    void setMode(){
        Button[] btnArr=new Button[]{A_btn, B_btn,C_btn, D_btn,E_btn, F_btn, clr_btn,add_btn,sub_btn ,div_btn, eq_btn, mul_btn, nine_btn,eight_btn,seven_btn, six_btn,five_btn,four_btn, three_btn,two_btn,one_btn, zero_btn};
        for (Button btn : btnArr){
            btn.setDisable(false);
        }
        String currMode=dropDown.getValue();
        switch (currMode){
            case "HEX":


                break;
            case "DEC":
                A_btn.setDisable(true);
                B_btn.setDisable(true);
                C_btn.setDisable(true);
                D_btn.setDisable(true);
                E_btn.setDisable(true);
                F_btn.setDisable(true);
                break;
            case "OCT":
                A_btn.setDisable(true);
                B_btn.setDisable(true);
                C_btn.setDisable(true);
                D_btn.setDisable(true);
                E_btn.setDisable(true);
                F_btn.setDisable(true);
                nine_btn.setDisable(true);
                eight_btn.setDisable(true);
                break;
            case "BIN":
                A_btn.setDisable(true);
                B_btn.setDisable(true);
                C_btn.setDisable(true);
                D_btn.setDisable(true);
                E_btn.setDisable(true);
                F_btn.setDisable(true);
                nine_btn.setDisable(true);
                eight_btn.setDisable(true);
                seven_btn.setDisable(true);
                six_btn.setDisable(true);
                five_btn.setDisable(true);
                four_btn.setDisable(true);
                three_btn.setDisable(true);
                two_btn.setDisable(true);
                break;
            default:
                break;
        }

    }


    @FXML
    void press0(ActionEvent event) {

    }

    @FXML
    void press1(ActionEvent event) {
        expression+="1";
        lastInput = LastInput.NUM;
        displayTF.setText(expression);
    }

    @FXML
    void press2(ActionEvent event) {

    }

    @FXML
    void press3(ActionEvent event) {

    }

    @FXML
    void press4(ActionEvent event) {

    }

    @FXML
    void press5(ActionEvent event) {

    }

    @FXML
    void press6(ActionEvent event) {

    }

    @FXML
    void press7(ActionEvent event) {

    }

    @FXML
    void press8(ActionEvent event) {

    }

    @FXML
    void press9(ActionEvent event) {

    }


    @FXML
    void pressAdd(ActionEvent event) {
        activeOperator=Operator.ADD;
        switch (lastInput) {
            case NUM:
                expression += "+";
                displayTF.setText(expression);
                lastInput = LastInput.OP;
                break;
            case OP:
                expression = expression.substring(0, expression.length() - 1) + "+";
                displayTF.setText(expression);
                break;
            default:
                break;
        }


    }

    @FXML
    void pressB(ActionEvent event) {

    }

    @FXML
    void pressC(ActionEvent event) {

    }

    @FXML
    void pressD(ActionEvent event) {

    }

    @FXML
    void pressDiv(ActionEvent event) {
        activeOperator=Operator.DIV;
        switch (lastInput) {
            case NUM:
                expression += "/";
                displayTF.setText(expression);
                lastInput = LastInput.OP;
                break;
            case OP:
                expression = expression.substring(0, expression.length() - 1) + "/";
                displayTF.setText(expression);
                break;
            default:
                break;
        }

    }

    @FXML
    void pressE(ActionEvent event) {

    }

    @FXML
    void pressEq(ActionEvent event) {

    }

    @FXML
    void pressF(ActionEvent event) {

    }

    @FXML
    void pressMul(ActionEvent event) {
        activeOperator=Operator.MUL;
        switch (lastInput) {
            case NUM:
                expression += "*";
                displayTF.setText(expression);
                lastInput = LastInput.OP;
                break;
            case OP:
                expression = expression.substring(0, expression.length() - 1) + "*";
                displayTF.setText(expression);
                break;
            default:
                break;
        }
    }

    @FXML
    void pressSub(ActionEvent event) {
        activeOperator=Operator.SUB;
        switch (lastInput) {
            case NUM:
                expression += "-";
                displayTF.setText(expression);
                lastInput = LastInput.OP;
                break;
            case OP:
                expression = expression.substring(0, expression.length() - 1) + "-";
                displayTF.setText(expression);
                break;
            default:
                break;
        }


        }
    }



