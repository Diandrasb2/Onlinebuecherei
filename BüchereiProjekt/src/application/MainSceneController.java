package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainSceneController {
	@FXML
	private AnchorPane fläche;
	@FXML
	private Label labelOnlineBücherei;
	@FXML
	private Button buttonLogIn;
	@FXML
	private Button buttonRegistrieren;
	@FXML
	private Button buttonAdmin;

	@FXML
	private void handleButtonLogInAction(ActionEvent event){
		System.out.println("Hier neues Fenster zum Login öffnen");
		
		Node source = (Node) event.getSource();
		Stage oldStage = (Stage) source.getScene().getWindow();
		oldStage.close();
		
	try {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LogInFenster.fxml"));
		AnchorPane root1 = (AnchorPane) fxmlLoader.load();
		Stage stage=new Stage();
		stage.setTitle("Online Bücherei - Log in");
		stage.setScene(new Scene(root1));
		stage.show();
	}catch (IOException iOException) {
		System.out.println("Fenster wurde nicht geöffnet");
	}
	
	}

	@FXML
	private void handleButtonRegistrierenAction(ActionEvent event) {
		System.out.println("Hier neues Fenster zum Registrieren öffnen");
		
		Node source = (Node) event.getSource();
		Stage oldStage = (Stage) source.getScene().getWindow();
		oldStage.close();
		
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RegistrierenFenster.fxml"));
			AnchorPane root2 = (AnchorPane) fxmlLoader.load();
			Stage stage=new Stage();
			stage.setTitle("Online Bücherei - Registrieren");
			stage.setScene(new Scene(root2));
			stage.show();
		}catch (IOException iOException) {
			System.out.println("Fenster wurde nicht geöffnet");
		}
	}



}
