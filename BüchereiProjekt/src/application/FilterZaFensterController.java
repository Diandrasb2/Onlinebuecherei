//Erstellung FilterZaFenster und Controller-Klasse: Anastasia

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

public class FilterZaFensterController {
	
	//Aufrufe FXML: Anastasia
	@FXML
	private AnchorPane flaecheSuche;
	@FXML
	private Label labelBuecherei;
	@FXML
	private TitledPane sortierenNach;
	@FXML
	private AnchorPane feldSortierenNach;
	@FXML
	private TitledPane genre;
	@FXML
	private AnchorPane feldGenre;
	@FXML
	private TitledPane jahr;
	@FXML
	private AnchorPane feldJahr;
	@FXML
	private TitledPane ISBN;
	@FXML
	private AnchorPane feldISBN;
	@FXML 
	private Tooltip ttHinweisSuche;
	@FXML
	private Label labelWillkommen;
	@FXML
	private TextField tfSuche;
	@FXML
	private Tooltip ttKonto;
	@FXML
	private Tooltip ttStartfenster;
	@FXML
	private Tooltip ttAusloggen;
	@FXML
	private Tooltip ttHilfe;
	@FXML
	private Separator separatorLinie;
	@FXML
	private Label labelRomane;
	@FXML
	private Pane paneScrollbereich;
	@FXML
	private ScrollBar scrollbarScroll;
	@FXML
	private Button buttonOK;
	@FXML
	private Button buttonAz;
	@FXML
	private Button buttonZa;
	@FXML
	private Button buttonBestseller;
	@FXML
	private Button buttonRomane;
	@FXML
	private Button buttonThriller;
	@FXML
	private Button buttonKrimi;
	@FXML
	private Button buttonSachliteratur;
	@FXML 
	private Button buttonSprache;
	@FXML
	private Label labelBeschreibung1;
	@FXML
	private Label labelBeschreibung2;
	@FXML
	private TextField tfJahrVon;
	@FXML
	private TextField tfJahrBis;
	@FXML
	private TextField tfISBN;
	
	//Verknuepfung Funktionen: Anastasia
	@FXML
	private void handleTfSucheAction(ActionEvent event) {
		System.out.println("Gebe hier einen Suchbegriff ein");
	}

	@FXML
	private void handleButtonOkAction(ActionEvent event) {
		System.out.println("Du hast deine Eingabe bestaetigt");
		//Aufruf neues Fenster: Anastasia
		Node source = (Node) event.getSource();
		Stage oldStage = (Stage) source.getScene().getWindow();
		oldStage.close();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SuchbegriffFenster.fxml"));
			AnchorPane root3 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Buecherei - Suchbegriff");
			stage.setScene(new Scene(root3));
			stage.show();
		} catch (IOException iOException) {
			System.out.println("Fenster wurde nicht geoeffnet");
		}
	}
	
	@FXML
	private void handleButtonAzAction(ActionEvent event) {
		System.out.println("Filter a-z");
		//Aufruf neues Fenster: Anastasia
		Node source = (Node) event.getSource();
		Stage oldStage = (Stage) source.getScene().getWindow();
		oldStage.close();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FilterAzFenster.fxml"));
			AnchorPane root3 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Buecherei - Filter a-z");
			stage.setScene(new Scene(root3));
			stage.show();
		} catch (IOException iOException) {
			System.out.println("Fenster wurde nicht geoeffnet");
		}
	}
	
	@FXML
	private void handleButtonZaAction(ActionEvent event) {
		System.out.println("Du bist bereits auf dem Filter z-a");
	}
	@FXML
	private void handleButtonBestsellerAction(ActionEvent event) {
		System.out.println("Filter Bestseller");
		//Aufruf neues Fenster: Anastasia
				Node source = (Node) event.getSource();
				Stage oldStage = (Stage) source.getScene().getWindow();
				oldStage.close();

				try {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FilterBestsellerFenster.fxml"));
					AnchorPane root3 = (AnchorPane) fxmlLoader.load();
					Stage stage = new Stage();
					stage.setTitle("Online Buecherei - Bestseller");
					stage.setScene(new Scene(root3));
					stage.show();
				} catch (IOException iOException) {
					System.out.println("Fenster wurde nicht geoeffnet");
				}
	}
	@FXML
	private void handleButtonRomaneAction(ActionEvent event) {
		System.out.println("Filter Romane");
		//Aufruf neues Fenster: Anastasia
				Node source = (Node) event.getSource();
				Stage oldStage = (Stage) source.getScene().getWindow();
				oldStage.close();

				try {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GenreRomaneFenster.fxml"));
					AnchorPane root3 = (AnchorPane) fxmlLoader.load();
					Stage stage = new Stage();
					stage.setTitle("Online Buecherei - Romane");
					stage.setScene(new Scene(root3));
					stage.show();
				} catch (IOException iOException) {
					System.out.println("Fenster wurde nicht geoeffnet");
				}
	}
	@FXML
	private void handleButtonThrillerAction(ActionEvent event) {
		System.out.println("Filter Thriller");
		//Aufruf neues Fenster: Anastasia
		Node source = (Node) event.getSource();
		Stage oldStage = (Stage) source.getScene().getWindow();
		oldStage.close();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GenreThrillerFenster.fxml"));
			AnchorPane root3 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Buecherei - Thriller");
			stage.setScene(new Scene(root3));
			stage.show();
		} catch (IOException iOException) {
			System.out.println("Fenster wurde nicht geoeffnet");
		}
	}
	@FXML
	private void handleButtonKrimiAction(ActionEvent event) {
		System.out.println("Filter Krimi");
		
		//Aufruf neues Fenster: Anastasia
		Node source = (Node) event.getSource();
		Stage oldStage = (Stage) source.getScene().getWindow();
		oldStage.close();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GenreKrimiFenster.fxml"));
			AnchorPane root3 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Buecherei - Krimi");
			stage.setScene(new Scene(root3));
			stage.show();
		} catch (IOException iOException) {
			System.out.println("Fenster wurde nicht geoeffnet");
		}
	}
	@FXML
	private void handleButtonSachliteraturAction(ActionEvent event) {
		System.out.println("Filter Sachliteratur");
		//Aufruf neues Fenster: Anastasia
				Node source = (Node) event.getSource();
				Stage oldStage = (Stage) source.getScene().getWindow();
				oldStage.close();

				try {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GenreSachliteraturFenster.fxml"));
					AnchorPane root3 = (AnchorPane) fxmlLoader.load();
					Stage stage = new Stage();
					stage.setTitle("Online Buecherei - Sachliteratur");
					stage.setScene(new Scene(root3));
					stage.show();
				} catch (IOException iOException) {
					System.out.println("Fenster wurde nicht geoeffnet");
				}
	}
	@FXML
	private void handleButtonSpracheAction(ActionEvent event) {
		System.out.println("Filter Fremdsprache");
		//Aufruf neues Fenster: Anastasia
		Node source = (Node) event.getSource();
		Stage oldStage = (Stage) source.getScene().getWindow();
		oldStage.close();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GenreSpracheFenster.fxml"));
			AnchorPane root3 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Buecherei - Fremdsprache");
			stage.setScene(new Scene(root3));
			stage.show();
		} catch (IOException iOException) {
			System.out.println("Fenster wurde nicht geoeffnet");
		}}
	@FXML
	private void handleTfJahrAction(ActionEvent event) {
		System.out.println("Filter Erscheinungsjahr");
		//Aufruf neues Fenster: Diandra
		Node source = (Node) event.getSource();
		Stage oldStage = (Stage) source.getScene().getWindow();
		oldStage.close();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("JahrFenster.fxml"));
			AnchorPane root3 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Buecherei - Jahr");
			stage.setScene(new Scene(root3));
			stage.show();
		} catch (IOException iOException) {
			System.out.println("Fenster wurde nicht geoeffnet");
		}
	}
	@FXML
	private void handleTfISBNAction(ActionEvent event) {
		System.out.println("Filter ISBN");
	}
	
	@FXML
	private void handleButtonKontoAction(ActionEvent event) {
		System.out.println("Kontoübersicht");
	}

	@FXML
	private void handleButtonStartfensterAction(ActionEvent event) {
		System.out.println("Willkommensfenster");
		// Aufruf neues Fenster: Anastasia
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
	}
}
