package application;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LogInFensterController {
@FXML
private AnchorPane fl�cheLogInFenster;
@FXML
private Label labelLogIn;
@FXML
private TextField tfEmail;
@FXML
private TextField tfPasswort;
@FXML
private Button buttonOK;
@FXML
private Button buttonZur�ck;

@FXML
private void handleTfEmailAction(ActionEvent event) {
	System.out.println("Tippe deine Email ein");
}
@FXML
private void handlePfPasswortAction(ActionEvent event) {
	System.out.println("Tippe dein Passwort ein");
}

@FXML
private void handleButtonZur�ckAction(ActionEvent event) {
	System.out.println("Du hast den Zur�ck-button gedr�ckt");
}
@FXML
private void handleButtonOkAction(ActionEvent event) {
	System.out.println("Hier gelangst du zum Willkommen-Fenster");
	try {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Willkommen.fxml"));
		AnchorPane root3 = (AnchorPane) fxmlLoader.load();
		Stage stage=new Stage();
		stage.setTitle("Online B�cherei - Willkommen");
		stage.setScene(new Scene(root3));
		stage.show();
	}catch (IOException iOException) {
		System.out.println("Fenster wurde nicht ge�ffnet");
	}
}
    
}

