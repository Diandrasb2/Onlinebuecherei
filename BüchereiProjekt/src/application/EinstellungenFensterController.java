//Erstellung Einstellungen und Controller-Klasse: Anastasia (Vorlage: Timm)

package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.Separator;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EinstellungenFensterController {
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
	private Label labelName;
	@FXML
	private Label labelEmail;
	@FXML
	private Label labelNameEingabe;
	@FXML
	private Label labelEmailEingabe;
	@FXML
	private Button buttonLoeschen;
	@FXML
	private Pane paneScrollbereich;
	@FXML
	private ScrollBar scrollbarScroll;

	// Verknuepfung Funktionen: Anastasia (Vorlage: Timm)
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
		System.out.println("Reserviert");
		  Node source = (Node) event.getSource();
			Stage oldStage = (Stage) source.getScene().getWindow();
			oldStage.close();

			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReserviertFenster.fxml"));
				AnchorPane root3 = (AnchorPane) fxmlLoader.load();
				Stage stage = new Stage();
				stage.setTitle("Online Buecherei - Reserviert");
				stage.setScene(new Scene(root3));
				stage.show();
			} catch (IOException iOException) {
				System.out.println("Fenster wurde nicht geoeffnet");
			}  
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
		System.out.println("Du bist bereits auf dem Einstellungsfenster");
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
	public void handleLabelNameEingabeAction(ActionEvent event) {
		System.out.println("Hier wird Benutzername aufgerufen und im Textfeld angezeigt");
	}
	@FXML
	public void handleLabelEmailEingabeAction(ActionEvent event) {
		System.out.println("Hier wird Benutzeremail aufgerufen und im Textfeld angezeigt");
	}
	@FXML
	public void handleButtonLoeschenAction(ActionEvent event) {
		System.out.println("Bestätigungsfenster wird geöffnet");
		
		Node source = (Node) event.getSource();
		Stage oldStage = (Stage) source.getScene().getWindow();
		oldStage.close();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("KontoLoeschen.fxml"));
			AnchorPane root3 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Buecherei - Loeschen");
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
		System.out.println("Du willst dich Ausloggen");
		Node source = (Node) event.getSource();
		Stage oldStage = (Stage) source.getScene().getWindow();
		oldStage.close();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Ausloggen.fxml"));
			AnchorPane root3 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Buecherei - Ausloggen");
			stage.setScene(new Scene(root3));
			stage.show();
		} catch (IOException iOException) {
			System.out.println("Fenster wurde nicht geoeffnet");
		}
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
	@FXML
	private void handleButtonOkAction(ActionEvent event) {
		System.out.println("Hier kommt das Bestaetigungsfenster zum Konto loeschen");

		// Neues Fenster: Anastasia
		Node source = (Node) event.getSource();
		Stage oldStage = (Stage) source.getScene().getWindow();
		oldStage.close();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("KontoLoeschen.fxml"));
			AnchorPane root3 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Konto loeschen");
			stage.setScene(new Scene(root3));
			stage.show();
		} catch (IOException iOException) {
			System.out.println("Fenster wurde nicht geoeffnet");
		}
	}
}
