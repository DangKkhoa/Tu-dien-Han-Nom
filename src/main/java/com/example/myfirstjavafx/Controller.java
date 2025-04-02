package com.example.myfirstjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Controller {

    @FXML
    private TextField inputField;

    @FXML
    private Label outputField;

    public void showInput(ActionEvent e) {
        outputField.setText(inputField.getText());
        System.out.println(inputField.getText());
    }
}
