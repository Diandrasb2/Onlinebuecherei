//Erstellung Hilfe und Controller-Klasse: Diandra (Vorlage Anastasia)

package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HilfeController {
	// Aufrufe FXML: Diandra (Vorlage Anastasia)
	@FXML
	private AnchorPane flaecheBenutzerkonto;
	@FXML
	private Label labelBuecherei;
	@FXML
	private Tooltip ttKonto;
	@FXML
	private Tooltip ttStartfenster;
	@FXML
	private Tooltip ttAusloggen;
	@FXML
	private Tooltip ttHilfe;
	@FXML
	private Button buttonKonto;
	@FXML
	private Button buttonStartfenster;
	@FXML
	private Button buttonAusloggen;
	@FXML
	private Button buttonHilfe;
	@FXML
	private Label labelHilfeCaption;
	@FXML
	private Label labelHilfeText;
	

	// Verknuepfung Funktionen: Diandra (Vorlage Anastasia)

	@FXML
	private void handleButtonKontoAction(ActionEvent event) {
		System.out.println("Konto");
		Node source = (Node) event.getSource();
		Stage oldStage = (Stage) source.getScene().getWindow();
		oldStage.close();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BenutzerkontoFenster.fxml"));
			AnchorPane root3 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Buecherei - Konto");
			stage.setScene(new Scene(root3));
			stage.show();
		} catch (IOException iOException) {	
			System.out.println("Fenster wurde nicht geoeffnet");
		}	

	}

	@FXML
	private void handleButtonStartfensterAction(ActionEvent event) {
		System.out.println("Willkommensfenster");
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

	@FXML
	private void handleButtonAusloggenAction(ActionEvent event) {
		System.out.println("Ausloggen");
	}

	@FXML
	private void handleButtonHilfeAction(ActionEvent event) {
		System.out.println("Hilfefenster");
		Node source = (Node) event.getSource();
		Stage oldStage = (Stage) source.getScene().getWindow();
		oldStage.close();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HilfeFenster.fxml"));
			AnchorPane root3 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Buecherei - Hilfe");
			stage.setScene(new Scene(root3));
			stage.show();
		} catch (IOException iOException) {
			System.out.println("Fenster wurde nicht geoeffnet");
		}

	}

}
