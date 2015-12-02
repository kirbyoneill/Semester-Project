package com.LeverInc.Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.web.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;

public class EliteBrowserController extends Region{
	public String address = "http://www.google.com";
	
    @FXML
    private WebView webView;

    @FXML
    private TextField tfAddressBar;

    @FXML
    private Button btnGo;

    public void initialize(){
    WebEngine webEngine = webView.getEngine();
    tfAddressBar.setText(address);
    webEngine.load(address);
    }
    
    @FXML
    void onGoEntered(KeyEvent event) {
    	address = tfAddressBar.getText();
    	if(event.getCode() == KeyCode.ENTER) {
    		WebEngine webEngine = webView.getEngine();
    	    webEngine.load(address);
    	}
    }

    @FXML
    void onGoClicked(ActionEvent event) {

    }

}
