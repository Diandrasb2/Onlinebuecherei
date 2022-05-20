//Erstellung Willkommen und Controller-Klasse: Anastasia

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
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class WillkommenController {
	//Aufrufe FXML: Anastasia
	@FXML
	private AnchorPane flaecheWillkommen;
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
	private TitledPane sprache;
	@FXML
	private AnchorPane feldSprache;
	@FXML 
	private Tooltip ttHinweisSuche;
	@FXML
	private Label labelWillkommen;
	@FXML
	private TextField tfSuche;
	
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
	private Button buttonDe;
	@FXML
	private Button buttonSp;
	@FXML
	private Button buttonEn;
	@FXML
	private Button buttonKo;
	
	@FXML
	private Label labelBeschreibung1;
	@FXML
	private Label labelBeschreibung2;

	@FXML
	private TextField tfJahr;
	@FXML
	private TextField tfISBN;
	
	//Verknüpfung Funktionen: Anastasia
	@FXML
	private void handleTfSucheAction(ActionEvent event) {
		System.out.println("Gebe hier einen Suchbegriff ein");
	}

	@FXML
	private void handleButtonOkAction(ActionEvent event) {
		System.out.println("Du hast deine Eingabe bestaetigt");
	}
	
	@FXML
	private void handleButtonAzAction(ActionEvent event) {
		System.out.println("Filter a-z");
	}
	
	@FXML
	private void handleButtonZaAction(ActionEvent event) {
		System.out.println("Filter z-a");
	}
	@FXML
	private void handleButtonBestsellerAction(ActionEvent event) {
		System.out.println("Filter Bestseller");
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
	}
	@FXML
	private void handleButtonKrimiAction(ActionEvent event) {
		System.out.println("Filter Krimi");
	}
	@FXML
	private void handleButtonSachliteraturAction(ActionEvent event) {
		System.out.println("Filter Sachliteratur");
	}
	@FXML
	private void handleTfJahrAction(ActionEvent event) {
		System.out.println("Filter Erscheinungsjahr");
	}
	@FXML
	private void handleTfISBNAction(ActionEvent event) {
		System.out.println("Filter ISBN");
	}
	@FXML
	private void handleButtonDeAction(ActionEvent event) {
		System.out.println("Filter Deutsch");
	}
	@FXML
	private void handleButtonEnAction(ActionEvent event) {
		System.out.println("Filter Englisch");
	}
	@FXML
	private void handleButtonSpAction(ActionEvent event) {
		System.out.println("Filter Spanisch");
	}
	@FXML
	private void handleButtonKoAction(ActionEvent event) {
		System.out.println("Filter Koreanisch");
	}
	
	
}
