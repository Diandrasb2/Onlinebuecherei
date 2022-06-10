//Erstellung Willkommen und Controller-Klasse: Anastasia

package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class WillkommenController {
	// Aufrufe FXML: Anastasia
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
	private Button buttonSprache;
	@FXML
	private Label labelBeschreibung1;
	@FXML
	private Label labelBeschreibung2;
	@FXML
	private Label labelBis;
	@FXML
	private TextField tfJahrVon;
	@FXML
	private TextField tfJahrBis;
	@FXML
	private TextField tfISBN;
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
	private ImageView imgKonto;
	@FXML
	private ImageView imgHome;
	@FXML
	private ImageView imgAusloggen;
	@FXML
	private ImageView imgHilfe;

	// Verkuepfung Funktionen: Anastasia
	@FXML
	private void handleTfSucheAction(ActionEvent event) {
		System.out.println("Gebe hier einen Suchbegriff ein");
	}

	@FXML
	private void handleButtonOkAction(ActionEvent event) {
		System.out.println("Du hast deine Eingabe bestaetigt");
		// Aufruf neues Fenster: Anastasia
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
		// Aufruf neues Fenster: Anastasia
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
		System.out.println("Filter z-a");
		// Aufruf neues Fenster: Anastasia
		Node source = (Node) event.getSource();
		Stage oldStage = (Stage) source.getScene().getWindow();
		oldStage.close();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FilterZaFenster.fxml"));
			AnchorPane root3 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Buecherei - Filter z-a");
			stage.setScene(new Scene(root3));
			stage.show();
		} catch (IOException iOException) {
			System.out.println("Fenster wurde nicht geoeffnet");
		}
	}

	@FXML
	private void handleButtonBestsellerAction(ActionEvent event) {
		System.out.println("Filter Bestseller");
		// Aufruf neues Fenster: Anastasia
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

		// Aufruf neues Fenster: Anastasia
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

		// Datenbank der B�cher erstellt und verkn�pft: Anastasia

		try {

			Connection connection = DriverManager
					.getConnection("jdbc:mysql://127.0.0.2:3307/alleBuecher\", \"root\", \"\"");
			connection.setReadOnly(true);
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("select * from alleBuecher");

			resultset.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("Die Verbindung mit der Datenbank wurd erstellt. Hier B�cher aufrufen lassen.");

		}
	}

	@FXML
	private void handleButtonThrillerAction(ActionEvent event) {
		System.out.println("Filter Thriller");

		// Aufruf neues Fenster: Anastasia
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

		// Aufruf neues Fenster: Anastasia
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
		// Aufruf neues Fenster: Anastasia
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
		// Aufruf neues Fenster: Anastasia
		Node source = (Node) event.getSource();
		Stage oldStage = (Stage) source.getScene().getWindow();
		oldStage.close();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GenreSpracheFenster.fxml"));
			AnchorPane root3 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Buecherei - Sprache");
			stage.setScene(new Scene(root3));
			stage.show();
		} catch (IOException iOException) {
			System.out.println("Fenster wurde nicht geoeffnet");
		}
	}

	@FXML
	private void handleTfJahrAction(ActionEvent event) {
		System.out.println("Filter Erscheinungsjahr");

		// Aufruf neues Fenster: Diandra
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
		// Aufruf neues Fenster: Diandra
		Node source = (Node) event.getSource();
		Stage oldStage = (Stage) source.getScene().getWindow();
		oldStage.close();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ISBNFenster.fxml"));
			AnchorPane root3 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Buecherei - ISBN");
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
	private void handleButtonAusloggenAction(ActionEvent event) {
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
	private void handleButtonHilfeAction(ActionEvent event) {
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
