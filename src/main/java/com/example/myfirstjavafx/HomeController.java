package com.example.myfirstjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    @FXML
    private Label usernameLabel;

    @FXML
    private Pane loginPane;

    public void ShowLoginScene(ActionEvent e) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/LoginScene.fxml"));
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void setLoggedinUser(String username) {
        if(username != null) {
            loginPane.setVisible(false);
            usernameLabel.setText(username);
            usernameLabel.setVisible(true);
        }
    }
}
