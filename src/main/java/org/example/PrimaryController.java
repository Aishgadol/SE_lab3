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
    private static int pos=-1,ch;
    private int base;
    private int old_base;
    private LastInput lastInput=LastInput.NUM;
    private Operator activeOperator;
    private String expression="0";
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

    //this function assumes the base is 10. big important
    private int eval(){
        String expCopy=expression;
        int temp_old_base=old_base;
        int temp_base=base;
        old_base=base;
        base=10;
        convertToBase();
        String[] tokens=expression.split("(?=[-+*/()])|(?<=[^-+*/][-+*/])|(?<=[()])");
        old_base=temp_old_base;
        base=temp_base;
        convertToBase();
        int res=0;
        //this loop takes care of multiplcation/divison, left to right order since no fraction lines included
        for (int i=0;i<tokens.length;i++){
            switch(tokens[i]){
                case "*":
                    tokens[i+1]=Integer.toString((Integer.parseInt(tokens[i-1])*Integer.parseInt(tokens[i+1])));
                    tokens[i]="0";
                    tokens[i-1]="0";
                    break;
                case "/":
                    if(tokens[i+1]=="0"){
                        return -1;
                    }
                    try{
                        tokens[i+1]=Integer.toString((Integer.parseInt(tokens[i-1])/Integer.parseInt(tokens[i+1])));
                    } catch (ArithmeticException e){
                            return -1;
                    }
                    tokens[i]="0";
                    tokens[i-1]="0";
                    break;
                default:
                    break;
            }
        }
        //this loop takes care of add/sub operations, left to right again
        for(int i=0;i< tokens.length;i++){
            switch(tokens[i]){
                case "+":
                    tokens[i+1]=Integer.toString((Integer.parseInt(tokens[i-1])+Integer.parseInt(tokens[i+1])));
                    tokens[i]="0";
                    tokens[i-1]="0";
                    break;
                case "-":
                    tokens[i+1]=Integer.toString((Integer.parseInt(tokens[i-1])-Integer.parseInt(tokens[i+1])));
                    tokens[i]="0";
                    tokens[i-1]="0";
                    break;
                default:
                    break;
            }
        }
        int sum=0;
        for (String s : tokens){
            sum+=Integer.parseInt(s);
        }
        return sum;
    }

    private void convertToBase() {
        // Define valid characters for the given base
        String validChars = "";
        if (old_base == 2) validChars = "01";
        else if (old_base == 8) validChars = "01234567";
        else if (old_base == 10) validChars = "0123456789";
        else if (old_base == 16) validChars = "0123456789ABCDEF";
        else {
            System.out.println("Unsupported base");
            return;
        }

        String number = "";
        String res = "";
        for (char ch : expression.toCharArray()) {
            if (validChars.indexOf(ch) != -1) {
                number += ch;
            } else {
                if (number.length() > 0) {
                    res += Integer.toString(Integer.parseInt(number, old_base), base);
                    number = "";
                }
                res += ch;

            }
        }
        //convert last number
        if (number.length() > 0) {
            res += Integer.toString(Integer.parseInt(number, old_base), base);
        }

        expression = res.toUpperCase();
    }

    @FXML
    void pressA(ActionEvent e){
        if(expression.length()<30){
            lastInput = LastInput.NUM;
            expression+="A";
            displayTF.setText(expression);
        }
        else{
            displayTF.setText("Expression too long");
        }
    }

    @FXML
    void clearScreen(ActionEvent e){
        displayTF.setText("");
        expression="0";
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
                old_base=base;
                base=16;
                convertToBase();
                displayTF.setText(expression);

                break;
            case "DEC":
                A_btn.setDisable(true);
                B_btn.setDisable(true);
                C_btn.setDisable(true);
                D_btn.setDisable(true);
                E_btn.setDisable(true);
                F_btn.setDisable(true);
                old_base=base;
                base=10;
                convertToBase();
                displayTF.setText(expression);
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
                old_base=base;
                base=8;
                convertToBase();
                displayTF.setText(expression);
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
                old_base=base;
                base=2;
                convertToBase();
                displayTF.setText(expression);
                break;
            default:
                break;
        }
    }


    @FXML
    void press0(ActionEvent event) {
        if(expression.length()<30){
            lastInput = LastInput.NUM;
            expression+="0";
            displayTF.setText(expression);
        }
        else{
            displayTF.setText("Expression too long");
        }
    }

    @FXML
    void press1(ActionEvent event) {
        if(expression.length()<30){
            lastInput = LastInput.NUM;
            expression+="1";
            displayTF.setText(expression);
        }
        else{
            displayTF.setText("Expression too long");
        }
    }

    @FXML
    void press2(ActionEvent event) {
        if(expression.length()<30){
            lastInput = LastInput.NUM;
            expression+="2";
            displayTF.setText(expression);
        }
        else{
            displayTF.setText("Expression too long");
        }
    }

    @FXML
    void press3(ActionEvent event) {
        if(expression.length()<30){
            lastInput = LastInput.NUM;
            expression+="3";
            displayTF.setText(expression);
        }
        else{
            displayTF.setText("Expression too long");
        }
    }

    @FXML
    void press4(ActionEvent event) {
        if(expression.length()<30){
            lastInput = LastInput.NUM;
            expression+="4";
            displayTF.setText(expression);
        }
        else{
            displayTF.setText("Expression too long");
        }
    }

    @FXML
    void press5(ActionEvent event) {
        if(expression.length()<30){
            lastInput = LastInput.NUM;
            expression+="5";
            displayTF.setText(expression);
        }
        else{
            displayTF.setText("Expression too long");
        }
    }

    @FXML
    void press6(ActionEvent event) {
        if(expression.length()<30){
            lastInput = LastInput.NUM;
            expression+="6";
            displayTF.setText(expression);
        }
        else{
            displayTF.setText("Expression too long");
        }
    }

    @FXML
    void press7(ActionEvent event) {
        if(expression.length()<30){
            lastInput = LastInput.NUM;
            expression+="7";
            displayTF.setText(expression);
        }
        else{
            displayTF.setText("Expression too long");
        }
    }

    @FXML
    void press8(ActionEvent event) {
        if(expression.length()<30){
            lastInput = LastInput.NUM;
            expression+="8";
            displayTF.setText(expression);
        }
        else{
            displayTF.setText("Expression too long");
        }
    }

    @FXML
    void press9(ActionEvent event) {
        if(expression.length()<30){
            lastInput = LastInput.NUM;
            expression+="9";
            displayTF.setText(expression);
        }
        else{
            displayTF.setText("Expression too long");
        }
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
        if(expression.length()<30){
            lastInput = LastInput.NUM;
            expression+="B";
            displayTF.setText(expression);
        }
        else{
            displayTF.setText("Expression too long");
        }
    }

    @FXML
    void pressC(ActionEvent event) {
        if(expression.length()<30){
            lastInput = LastInput.NUM;
            expression+="C";
            displayTF.setText(expression);
        }
        else{
            displayTF.setText("Expression too long");
        }
    }

    @FXML
    void pressD(ActionEvent event) {
        if(expression.length()<30){
            lastInput = LastInput.NUM;
            expression+="D";
            displayTF.setText(expression);
        }
        else{
            displayTF.setText("Expression too long");
        }
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
        if(expression.length()<30){
            lastInput = LastInput.NUM;
            expression+="E";
            displayTF.setText(expression);
        }
        else{
            displayTF.setText("Expression too long");
        }
    }

    @FXML
    void pressEq(ActionEvent event) {
        if(lastInput==LastInput.OP){
            displayTF.setText("ERROR");
            return;
        }

        int res=eval();
        if(res==-1){
            displayTF.setText("DIVISION BY ZERO IMPOSSIBLE");
            expression="0";
            return;
        }
        expression=Integer.toString(res,base).toUpperCase();
        displayTF.setText(expression);

    }

    @FXML
    void pressF(ActionEvent event) {
        if(expression.length()<30){
            lastInput = LastInput.NUM;
            expression+="F";
            displayTF.setText(expression);
        }
        else{
            displayTF.setText("Expression too long");
        }
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



