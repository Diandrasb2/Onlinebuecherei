
package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegistrierenFensterController {
	String passwort;
	String name;
	String email;
	String passwort2;

	@FXML
	private AnchorPane flaecheRegistrierenFenster;
	@FXML
	private Label labelRegistrieren;
	@FXML
	private Label labelName;
	@FXML
	private TextField tfName;
	@FXML
	private Label labelEmail;
	@FXML
	private TextField tfEmail;
	@FXML
	private Label labelPasswort;
	@FXML
	private PasswordField pfPasswort;
	@FXML
	private Label labelPasswortW;
	@FXML
	private PasswordField pfPasswortW;
	@FXML
	private Button buttonOK;
	@FXML
	private Button buttonZurück;

	@FXML
	private void handleTfNameAction(ActionEvent event) {
		System.out.println("Tippe deinen Vor- und Nachnamen ein");
	}

	@FXML
	private void handleTfEmailAction(ActionEvent event) {
		System.out.println("Tippe deine E-Mail ein");
	}

	@FXML
	void handlePfPasswortAction(ActionEvent event) {
		System.out.println("Tippe dein Passwort ein");
		 name = labelName.getText();
		email = tfEmail.getText();
		passwort = labelPasswort.getText();

//		System.out.println("Deine Eingaben waren folgende: " + name + ", " + email + ", " + passwort);
		// Nach jeder Eingabe Enter druecken, damit Eingabe uebernommen wird

		if (passwort.length() == 6) {
			System.out.println("Gueltige Passwortwahl. Wiederhole das gewaehlte Passwort.");
			System.out.println(passwort);
		} else {
			System.out.println("Passwort muss 6 Zeichen lang sein.");
		}
	}

	@FXML
	private void handlePfPasswortWAction(ActionEvent event) {
		System.out.println("Bestaetige dein Passwort durch Wiederholung der Passworteingabe.");

		passwort2 = labelPasswortW.getText();
		System.out.println(passwort + ", " + passwort2);
		if (passwort.equals(passwort2)) {

			System.out.println("Erfolgreiche Bestaetigung des Passworts.");
		} else {
			System.out.println("Deine Eingabe stimmt nicht ueberein. Wiederhole sie bitte.");
		}
	}

	@FXML
	private void handleButtonOkAction(ActionEvent event) {
//Plan: bei OK druecken alles pruefen und nicht schon vorher
		
		System.out.println("Hier musst du dich nun einloggen um fortzufahren.");
		
		Node source = (Node) event.getSource();
		Stage oldStage = (Stage) source.getScene().getWindow();
		oldStage.close();
		
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
			AnchorPane root3 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Buecherei");
			stage.setScene(new Scene(root3));
			stage.show();
		} catch (IOException iOException) {
			System.out.println("Fenster wurde nicht geoeffnet");
		}
	}

	@FXML
	private void handleButtonZurückAction(ActionEvent event) {
		System.out.println("Du hast den Zurueck-Button gedrueckt");
		
		Node source = (Node) event.getSource();
		Stage oldStage = (Stage) source.getScene().getWindow();
		oldStage.close();
		
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
			AnchorPane root3 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Buecherei");
			stage.setScene(new Scene(root3));
			stage.show();
		} catch (IOException iOException) {
			System.out.println("Fenster wurde nicht geoeffnet");
		}
	}

}
