package com.LeverInc.Project;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.web.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class EliteBrowserController extends Region{
	public String address = "http://www.google.com";
	
    @FXML
    private WebView webView;

    @FXML
    private TextField tfAddressBar;

    @FXML
    private Button btnGo;

    @FXML
    private MenuBar MenuBar;

    @FXML
    private MenuItem close;

    @FXML
    private MenuItem about;

    @FXML
    private MenuItem newWindow;

    public void initialize(){
    WebEngine webEngine = webView.getEngine();
    tfAddressBar.setText(address);
    webEngine.load(address);
    }
    
    @FXML
    void onEnterPress(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    		address = tfAddressBar.getText();
    		WebEngine webEngine = webView.getEngine();
    		webEngine.load(addressCorrection());
    	}
    }

    @FXML
    void aboutButton(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("about.fxml"));
    	Stage stage = new Stage();
    	stage.setScene(new Scene(root, 200, 400));
    	stage.show();
    }

    @FXML
    void start(Stage stage) throws IOException {
    	stage = new Stage();
    	Parent parent = FXMLLoader.load(getClass().getResource("EliteBrowser.fxml"));
		Scene scene = new Scene(parent);
		stage.setTitle("Elite Browser");
		stage.setScene(scene);
		stage.show();
    }
    @FXML
    void browserClose(ActionEvent event) {
    	System.exit(0);
    }

    public String addressCorrection(){
    	if(address.substring(0, 7).equals("http://")){
    		return address;
    	} else{
    		address = "http://" + address;
    		return address;
    	}
    }
}
