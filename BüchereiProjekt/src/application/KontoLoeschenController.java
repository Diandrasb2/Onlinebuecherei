//Erstellung KontoLoeschen und Controller-Klasse: Anastasia

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

public class KontoLoeschenController {
@FXML
private AnchorPane Hinweisflaeche;
@FXML
private Label labelHinweis;
@FXML
private Button buttonOk;
@FXML
private Button buttonBack;

@FXML
private void handleButtonOkAction(ActionEvent event) {
	System.out.println("Hier soll nun Konto gelöscht werden");
}
@FXML
private void handleButtonBackAction(ActionEvent event) {
	System.out.println("Zurueck zum Einstellungsfenster");
	
	Node source = (Node) event.getSource();
	Stage oldStage = (Stage) source.getScene().getWindow();
	oldStage.close();

	try {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EinstellungenFenster.fxml"));
		AnchorPane root3 = (AnchorPane) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle("Online Buecherei - Einstellungen");
		stage.setScene(new Scene(root3));
		stage.show();
	} catch (IOException iOException) {
		System.out.println("Fenster wurde nicht geoeffnet");
	}
}
}