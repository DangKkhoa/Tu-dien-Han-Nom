package com.example.myfirstjavafx;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    private String loggedinUser = null;

    @FXML
    private Pane loginPane;
    @FXML
    private Pane userInfoPane;
    @FXML
    private Label usernameLabel;

    @FXML private TabPane tabPane;
    @FXML private Tab hanNom;
    @FXML private Tab pinyin;
    @FXML private Tab boThu;
    @FXML private Tab history;
    @FXML private Tab selectedTab;

    @FXML private Label loginRequestLabel;



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
        this.loggedinUser = username;
        if(username != null) {
            loginPane.setVisible(false);
            usernameLabel.setText(username);
            userInfoPane.setVisible(true);
        }
    }

    @FXML
    public void handleTabSelection(Event e) throws IOException {
        selectedTab = tabPane.getSelectionModel().getSelectedItem();

        if(selectedTab.isSelected()) {
            if(selectedTab == hanNom) {
                System.out.println("Đang tra hán nôm");
            }
            else if(selectedTab == pinyin) {
                System.out.println("Đang tra pinyin");
            }
            else if(selectedTab == boThu) {
                System.out.println("Đang tra bộ thủ");
            }
            else if(selectedTab == history) {
                System.out.println("Lịch sử tìm kiếm");
                historySearch(e);

            }
        }
    }

    public void historySearch(Event e) {
        if(loggedinUser != null) {
            loginRequestLabel.setVisible(false);
        }
        else {
            loginRequestLabel.setVisible(true);
        }
    }

    @FXML
    public void logout(ActionEvent e) throws IOException {
        setLoggedinUser(null);
        userInfoPane.setVisible(false);
        usernameLabel.setText("");
        loginPane.setVisible(true);

    }
}
