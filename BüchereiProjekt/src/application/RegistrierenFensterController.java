
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

public class RegistrierenFensterController {
	String passwort;
	String name;
	String email;
	String passwort2;

	@FXML
	private AnchorPane fl�cheRegistrierenFenster;
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
	private Button buttonZur�ck;

	@FXML
	private void handleTfNameAction(ActionEvent event) {
		System.out.println("Tippe deinen Vor- und Nachnamen ein");
	}

	@FXML
	private void handleTfEmailAction(ActionEvent event) {
		System.out.println("Tippe deine Email ein");
	}

	@FXML
	void handlePfPasswortAction(ActionEvent event) {
		System.out.println("Tippe dein Passwort ein");
		 name = tfName.getText();
		email = tfEmail.getText();
		passwort = pfPasswort.getText();

//		System.out.println("Deine Eingaben waren folgende: " + name + ", " + email + ", " + passwort);
		// Nach jeder eingabe enter dr�cken damit eingabe �bernommen wird

		if (passwort.length() == 6) {
			System.out.println("G�ltige Passwortwahl. Wiederhole das gew�hlte Passwort.");
			System.out.println(passwort);
		} else {
			System.out.println("Passwort muss 6 Zeichen lang sein.");
		}
	}

	@FXML
	private void handlePfPasswortWAction(ActionEvent event) {
		System.out.println("Best�tige dein Passwort durch Wiederholung der Passworteingabe.");

		passwort2 = pfPasswortW.getText();
		System.out.println(passwort + ", " + passwort2);
		if (passwort.equals(passwort2)) {

			System.out.println("Erfolgreiche Best�tigung des Passworts.");
		} else {
			System.out.println("Deine Eingabe stimmt nicht �berein. Wiederhole bitte.");
		}
	}

	@FXML
	private void handleButtonOkAction(ActionEvent event) {
//Plan: bei OK dr�cken alles pr�fen und nicht schon vorher
		
		
		System.out.println("Hier musst du dich nun einloggen um fortzufahren.");
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
			AnchorPane root3 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online B�cherei");
			stage.setScene(new Scene(root3));
			stage.show();
		} catch (IOException iOException) {
			System.out.println("Fenster wurde nicht ge�ffnet");
		}
	}

	@FXML
	private void handleButtonZur�ckAction(ActionEvent event) {
		System.out.println("Du hast den Zur�ck-button gedr�ckt");
	}

}
