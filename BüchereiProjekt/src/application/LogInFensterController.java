//Erstellung LogInFenster und Controller-Klasse: Anastasia

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
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LogInFensterController {

	// Aufrufe FXML: Anastasia
	@FXML
	private AnchorPane flaecheLogInFenster;
	@FXML
	private Label labelLogIn;
	@FXML
	private TextField tfEmail;
	@FXML
	private TextField tfPasswort;
	@FXML
	private PasswordField pfPasswort;
	@FXML
	private Tooltip ttHinweisPw;
	@FXML
	private Label labelEmail;
	@FXML
	private Label labelPasswort;
	@FXML
	private Button buttonOK;
	@FXML
	private Button buttonZurueck;

//Verknüpfung Funktionen: Anastasia
	@FXML
	private void handleTfEmailAction(ActionEvent event) {
		System.out.println("Tippe deine Email ein");
	}

	@FXML
	private void handlePfPasswortAction(ActionEvent event) {
		System.out.println("Tippe dein Passwort ein");
	}

	@FXML
	private void handleButtonZurueckAction(ActionEvent event) {
		System.out.println("Du hast den Zurueck-button gedrueckt");

		// Neues Fenster: Anastasia
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
	private void handleButtonOkAction(ActionEvent event) {
		System.out.println("Hier gelangst du zum Willkommen-Fenster");

		// Neues Fenster: Anastasia
		Node source = (Node) event.getSource();
		Stage oldStage = (Stage) source.getScene().getWindow();
		oldStage.close();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Willkommen.fxml"));
			AnchorPane root3 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Buecherei - Willkommen");
			stage.setScene(new Scene(root3));
			stage.show();
		} catch (IOException iOException) {
			System.out.println("Fenster wurde nicht geoeffnet");
		}
	}

}
