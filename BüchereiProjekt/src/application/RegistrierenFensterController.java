
package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegistrierenFensterController {
	String passwort;
	String name;
	String email;
	String passwort2;

	@FXML
	private AnchorPane flächeRegistrierenFenster;
	@FXML
	private Label labelRegistrieren;
	@FXML
	private TextField tfName;
	@FXML
	private TextField tfEmail;
	@FXML
	private TextField pfPasswort;
	@FXML
	private TextField pfPasswortW;
	@FXML
	private Button buttonOK;
	@FXML
	private Button buttonZurück;
	@FXML
	private Label rPasswortAnforderung;
	@FXML
	private void registrationsCheckOk(ActionEvent event) throws IOException{
		
		if(tfName.getText().isEmpty()) {
		rPasswortAnforderung.setText("Bitte Name Eingeben.");
		return;
		}
		else if(tfEmail.getText().isEmpty()) {
		rPasswortAnforderung.setText("Bitte Email Eingeben.");
		return;
		}
		else if(pfPasswort.getText().isEmpty()) {
		rPasswortAnforderung.setText("Bitte Passwort Eingeben.");
		return;
		}
		else if(pfPasswort.getLength() < 7) {
		rPasswortAnforderung.setText("Passwort zu Kurz.");
		return;
		}
		else if(pfPasswortW.getText().isEmpty()) {
		rPasswortAnforderung.setText("Bitte Paswort nochmal Eingeben.");
		return;
		}
	
		else if(!pfPasswortW.getText().equals(pfPasswort.getText()) ) {
		rPasswortAnforderung.setText("Passwort muss übereinstimmen!");
		return;
		}
	  
		rPasswortAnforderung.setText("Registrierung Erfolgreich!");
	
	}
	@FXML
	private void handleButtonOkAction(ActionEvent event) {
//Plan: bei OK drücken alles prüfen und nicht schon vorher
		
		System.out.println("Hier musst du dich nun einloggen um fortzufahren.");
		
		Node source = (Node) event.getSource();
		Stage oldStage = (Stage) source.getScene().getWindow();
		oldStage.close();
		
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
			AnchorPane root3 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Bücherei");
			stage.setScene(new Scene(root3));
			stage.show();
		} catch (IOException iOException) {
			System.out.println("Fenster wurde nicht geöffnet");
		}
	}

	@FXML
	private void handleButtonZurückAction(ActionEvent event) {
		System.out.println("Du hast den Zurück-button gedrückt");
		
		Node source = (Node) event.getSource();
		Stage oldStage = (Stage) source.getScene().getWindow();
		oldStage.close();
		
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
			AnchorPane root3 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Bücherei");
			stage.setScene(new Scene(root3));
			stage.show();
		} catch (IOException iOException) {
			System.out.println("Fenster wurde nicht geöffnet");
		}
	}

}
