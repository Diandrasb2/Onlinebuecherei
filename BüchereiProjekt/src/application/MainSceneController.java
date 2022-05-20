//Erstellung MainScene und Controller-Klasse: Anastasia

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

	// Aufrufe FXML: Anastasia
	@FXML
	private AnchorPane flaeche;
	@FXML
	private Label labelOnlineBuecherei;
	@FXML
	private Button buttonLogIn;
	@FXML
	private Button buttonRegistrieren;
	@FXML
	private Button buttonAdmin;

	// Verknüpfung Funktionen: Anastasia
	@FXML
	private void handleButtonLogInAction(ActionEvent event) {
		System.out.println("Hier neues Fenster zum Login oeffnen");

		// Neues Fenster: Anastasia
		Node source = (Node) event.getSource();
		Stage oldStage = (Stage) source.getScene().getWindow();
		oldStage.close();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LogInFenster.fxml"));
			AnchorPane root1 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Buecherei - Log in");
			stage.setScene(new Scene(root1));
			stage.show();
		} catch (IOException iOException) {
			System.out.println("Fenster wurde nicht geoeffnet");
		}

	}

	@FXML
	private void handleButtonRegistrierenAction(ActionEvent event) {
		System.out.println("Hier neues Fenster zum Registrieren oeffnen");

		// Neues Fenster: Anastasia
		Node source = (Node) event.getSource();
		Stage oldStage = (Stage) source.getScene().getWindow();
		oldStage.close();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RegistrierenFenster.fxml"));
			AnchorPane root2 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Buecherei - Registrieren");
			stage.setScene(new Scene(root2));
			stage.show();
		} catch (IOException iOException) {
			System.out.println("Fenster wurde nicht geoeffnet");
		}
	}

}
