package com.example.myfirstjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private String loggedinUser;

    Map<String, String> users = new HashMap<>();

    @FXML
    private TextField textField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label usernameLabel;

    public SceneController() {
        users.put("khoa", "123456");
        users.put("admin", "123456");
        users.put("hehe", "123456");
    }

    public void ShowLoginScene(ActionEvent e) throws IOException {

        root = FXMLLoader.load(getClass().getResource("/LoginScene.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void handleLogin(ActionEvent e) throws IOException{
        String email = textField.getText();
        String password = passwordField.getText();

        if(users.containsKey(email) && users.get(email).equals(password)) {
            loggedinUser = email;
            home(e);
        }
        else {
            System.out.println("Wrong username or password");
        }
    }

    public void home(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Scene1.fxml"));
        root = loader.load();

        HomeController homeController = loader.getController();
        homeController.setLoggedinUser(loggedinUser);
//        root = FXMLLoader.load(getClass().getResource("/HomeScene.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);

        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        stage.setResizable(true);
        stage.setScene(scene);

        stage.show();
    }
}
