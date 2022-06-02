//Erstellung Reserviert und Controller-Klasse: Diandra (Vorlage: Timm)
package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.ScrollBar;

public class ReserviertFensterController {
	// Aufrufe FXML: Timm
	@FXML
	private AnchorPane flaecheBenutzerkonto;
	@FXML
	private Label labelKonto;
	@FXML
	private TitledPane aufklappbarBenutzer;
	@FXML
	private AnchorPane feldBenutzer;
	@FXML
	private Button buttonMerkliste;
	@FXML
	private Button buttonReserviert;
	@FXML
	private Button buttonAusgeliehen;
	@FXML
	private Button buttonEinstellungen;
	@FXML
	private Button buttonImpressum;
	@FXML
	private Label labelBuecherei;
	@FXML
	private Button buttonKonto;
	@FXML
	private Tooltip ttKonto;
	@FXML
	private Button buttonStartfenster;
	@FXML
	private Tooltip ttStartfenster;
	@FXML
	private Button buttonAusloggen;
	@FXML
	private Tooltip ttAusloggen;
	@FXML
	private Button buttonHilfe;
	@FXML
	private Tooltip ttHilfe;
	@FXML
	private Separator separatorLine;
	@FXML
	private Label labelReserviert;
	@FXML
	private Pane paneScrollbereich;
	@FXML
	private ScrollBar scrollbarScroll;

	// Verknuepfung Funktionen: Diandra (Vorlage: Timm)
	@FXML
	public void handleButtonMerklisteAction(ActionEvent event) {
		System.out.println("Merkliste Fenster");
		 Node source = (Node) event.getSource();
			Stage oldStage = (Stage) source.getScene().getWindow();
			oldStage.close();

			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MerklisteFenster.fxml"));
				AnchorPane root3 = (AnchorPane) fxmlLoader.load();
				Stage stage = new Stage();
				stage.setTitle("Online Buecherei - Merkliste");
				stage.setScene(new Scene(root3));
				stage.show();
			} catch (IOException iOException) {
				System.out.println("Fenster wurde nicht geoeffnet");
			}  
	}	

	@FXML
	public void handleButtonReserviertAction(ActionEvent event) {
		System.out.println("Du bist bereits bei Reserviert");
		}
	
	@FXML
	public void handleButtonAusgeliehenAction(ActionEvent event) {
		System.out.println("Ausgeliehen");
		  Node source = (Node) event.getSource();
			Stage oldStage = (Stage) source.getScene().getWindow();
			oldStage.close();

			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AusgeliehenFenster.fxml"));
				AnchorPane root3 = (AnchorPane) fxmlLoader.load();
				Stage stage = new Stage();
				stage.setTitle("Online Buecherei - Ausgeliehen");
				stage.setScene(new Scene(root3));
				stage.show();
			} catch (IOException iOException) {
				System.out.println("Fenster wurde nicht geoeffnet");
			}  
		}

	@FXML
	public void handleButtonEinstellungenAction(ActionEvent event) {
		System.out.println("Einstellungen");
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
	
	@FXML
	public void handleButtonImpressumAction(ActionEvent event) {
		System.out.println("Impressum");
		Node source = (Node) event.getSource();
		Stage oldStage = (Stage) source.getScene().getWindow();
		oldStage.close();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ImpressumFenster.fxml"));
			AnchorPane root3 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Buecherei - Impressum");
			stage.setScene(new Scene(root3));
			stage.show();
		} catch (IOException iOException) {
			System.out.println("Fenster wurde nicht geoeffnet");
		}	
	}
	
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
	public void handleButtonAusloggenAction(ActionEvent event) {
		System.out.println("Ausloggen");
	}
	@FXML
	public void handleButtonHilfeAction(ActionEvent event) {
		System.out.println("Hilfefenster");
		// Aufruf neues Fenster: Diandra
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
