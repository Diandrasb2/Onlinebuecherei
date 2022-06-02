//Erstellung Impressum und Controller-Klasse: Anastasia (Vorlage: Timm)

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
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ImpressumFensterController {
	@FXML
	private AnchorPane flaecheBenutzerkonto;
	@FXML
	private TextField tfSuche;
	@FXML
	private Button buttonOK;
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
	private Separator separatorLine1;
	@FXML
	private Separator separatorLine2;
	@FXML
	private Label labelReserviert;
	@FXML
	private Pane paneScrollbereich;
	@FXML
	private ScrollBar scrollbarScroll;
	@FXML
	private Label labelInhalt;
	
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
			System.out.println("Du bist bereits auf dem Fenster");
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
}
