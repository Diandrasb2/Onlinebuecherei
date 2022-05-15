
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
	private Label labelName;
	@FXML
	private Label labelEmail;
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
	private Label labelPasswort;
	@FXML
	private Label labelPasswortWiederholen;
	@FXML
	private Label rPasswortAnforderung;

	@FXML
	private void handleButtonOkAction(ActionEvent event) {
//Plan: bei OK drücken alles prüfen und nicht schon vorher

		if (tfName.getText().isEmpty()) {
			rPasswortAnforderung.setText("Geben Sie bitte Ihren Namen ein.");
			return;

		} else if (tfEmail.getText().isEmpty()) {
			rPasswortAnforderung.setText("Geben Sie bitte Ihre Email ein.");
			return;
		} else if (pfPasswort.getText().isEmpty()) {
			rPasswortAnforderung.setText("Erstellen Sie bitte ein Passwort.");
			return;
		} else if (pfPasswort.getLength() < 7) {
			rPasswortAnforderung.setText("Das erstellte Passwort ist zu kurz.");
			return;
		} else if (pfPasswort.getLength() > 8) {
			rPasswortAnforderung.setText("Das erstellte Passwort ist zu lang.");
			return;
		} else if (pfPasswortW.getText().isEmpty()) {
			rPasswortAnforderung.setText("Bitte Passworteingabe wiederholen.");
			return;
		}

		else if (!pfPasswortW.getText().equals(pfPasswort.getText())) {
			rPasswortAnforderung.setText("Das Passwort muss übereinstimmen.");
			return;
		}

		else {
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
