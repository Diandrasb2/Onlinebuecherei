package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainSceneController {
	@FXML
	private AnchorPane fl�che;
	@FXML
	private Label labelOnlineB�cherei;
	@FXML
	private Button buttonLogIn;
	@FXML
	private Button buttonRegistrieren;
	@FXML
	private Button buttonAdmin;

	@FXML
	private void handleButtonLogInAction(ActionEvent event){
		System.out.println("Hier neues Fenster zum Login �ffnen");
	try {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LogInFenster.fxml"));
		AnchorPane root1 = (AnchorPane) fxmlLoader.load();
		Stage stage=new Stage();
		stage.setTitle("Online B�cherei - Log in");
		stage.setScene(new Scene(root1));
		stage.show();
	}catch (IOException iOException) {
		System.out.println("Fenster wurde nicht ge�ffnet");
	}
	
	}

	@FXML
	private void handleButtonRegistrierenAction(ActionEvent event) {
		System.out.println("Hier neues Fenster zum Registrieren �ffnen");
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RegistrierenFenster.fxml"));
			AnchorPane root2 = (AnchorPane) fxmlLoader.load();
			Stage stage=new Stage();
			stage.setTitle("Online B�cherei - Registrieren");
			stage.setScene(new Scene(root2));
			stage.show();
		}catch (IOException iOException) {
			System.out.println("Fenster wurde nicht ge�ffnet");
		}
	}

	@FXML
	private void handleButtonAdminAction(ActionEvent event) {
		System.out.println("Hier neues Fenster f�r Admins �ffnen");
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin.fxml"));
			AnchorPane root3 = (AnchorPane) fxmlLoader.load();
			Stage stage=new Stage();
			stage.setTitle("Online B�cherei - Admin");
			stage.setScene(new Scene(root3));
			stage.show();
		}catch (IOException iOException) {
			System.out.println("Fenster wurde nicht ge�ffnet");
		}
	}

}
