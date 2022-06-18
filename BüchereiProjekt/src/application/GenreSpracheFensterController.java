//Erstellung GenreSpracheFenster und Controller-Klasse: Anastasia

package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pojo.Buch;

public class GenreSpracheFensterController implements Initializable{

	// Aufrufe FXML: Anastasia
	@FXML
	private AnchorPane flaecheSuche;
	@FXML
	private Label labelBuecherei;
	@FXML
	private TitledPane sortierenNach;
	@FXML
	private AnchorPane feldSortierenNach;
	@FXML
	private TitledPane genreFilter;
	@FXML
	private AnchorPane feldGenre;
	@FXML
	private TitledPane jahrFilter;
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
	private Button buttonOKSuchen;
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
	private Button buttonKonto;
	@FXML
	private Button buttonStartfenster;
	@FXML
	private Button buttonAusloggen;
	@FXML
	private Button buttonHilfe;
	@FXML
	private TableView<Buch> tabelleSortiment;
	@FXML
	private TableColumn<Buch, String> titel;
	@FXML
	private TableColumn<Buch, String> genre;
	@FXML
	private TableColumn<Buch, String> verfasser;
	@FXML
	private TableColumn<Buch, Integer> jahr;
	@FXML
	private TableColumn<Buch, String> verlag;
	@FXML
	private TableColumn<Buch, Long> isbn;
	@FXML
	private TableColumn<Buch, String> beschreibung;
	@FXML
	private Button buttonAnzeigen;
	@FXML
	private Button buttonMerken;
	@FXML
	private Button buttonReservieren;
	@FXML
	private Button buttonAusleihen;

	@FXML
	private ImageView imgKonto;
	@FXML
	private ImageView imgHome;
	@FXML
	private ImageView imgAusloggen;
	@FXML
	private ImageView imgHilfe;
	@FXML
	private Tooltip ttIsbn;
	@FXML 
	private Button buttonISBNSuchen;
	@FXML
	private Button buttonJahrSuchen;

	// Verknuepfung Funktionen: Anastasia
	ObservableList<Buch> liste = FXCollections.observableArrayList();
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		titel.setCellValueFactory(new PropertyValueFactory<Buch, String>("titel"));
		genre.setCellValueFactory(new PropertyValueFactory<Buch, String>("genre"));
		verfasser.setCellValueFactory(new PropertyValueFactory<Buch, String>("verfasser"));
		jahr.setCellValueFactory(new PropertyValueFactory<Buch, Integer>("jahr"));
		verlag.setCellValueFactory(new PropertyValueFactory<Buch, String>("verlag"));
		isbn.setCellValueFactory(new PropertyValueFactory<Buch, Long>("isbn"));
		beschreibung.setCellValueFactory(new PropertyValueFactory<Buch, String>("beschreibung"));

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/buecherliste", "root", "");
			System.out.println("Verbunden");

			// Suchalgorithmus nach Fremdsprachbuechern

			ResultSet rs = connection.createStatement()
					.executeQuery("select * from alleBuecher where genre like '%Fremdsprache%'");

			while (rs.next()) {
				Buch b = new Buch(rs.getString("titel"), rs.getString("genre"), rs.getString("verfasser"),
						rs.getInt("jahr"), rs.getString("verlag"), rs.getLong("isbn"), rs.getString("beschreibung"));
				b.setTitel(rs.getString("titel"));
				b.setVerfasser(rs.getString("verfasser"));
				b.setGenre(rs.getString("genre"));
				b.setJahr(rs.getInt("jahr"));
				b.setVerlag(rs.getString("verlag"));
				b.setIsbn(rs.getLong("isbn"));
				b.setBeschreibung(rs.getString("beschreibung"));
				liste.add(b);

				tabelleSortiment.setItems(liste);	
			}

		} catch (SQLException ex) {
			System.out.println("Fehler");
		}
	}

	@FXML
	private void handleButtonAnzeigenAction(ActionEvent event) throws SQLException {
		//von Anastasia
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Buchdetails.fxml"));
			AnchorPane root3 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Buecherei - Buchdetails");
			stage.setScene(new Scene(root3));
			stage.show();

			//Ausgabe aus der Tabelle wird f�r gew�hlte Zeile in neuem Fenster ausgegeben um alles lesen zu k�nnen
			BuchdetailsController buchdetailsController=fxmlLoader.getController();

			int row = tabelleSortiment.getSelectionModel().getSelectedIndex();

			if(row>=0) { //Nur wenn ein Feld ausgew�hlt ist, ist dieser Aufruf m�glich
				buchdetailsController.setData(""+tabelleSortiment.getSelectionModel().getSelectedItem().getTitel(), 
						tabelleSortiment.getSelectionModel().getSelectedItem().getVerfasser(),
						""+tabelleSortiment.getSelectionModel().getSelectedItem().getGenre(),
						+tabelleSortiment.getSelectionModel().getSelectedItem().getJahr(),
						""+tabelleSortiment.getSelectionModel().getSelectedItem().getVerlag(),
						+tabelleSortiment.getSelectionModel().getSelectedItem().getIsbn(),
						""+tabelleSortiment.getSelectionModel().getSelectedItem().getBeschreibung());
			}

		} catch (IOException iOException) {
			System.out.println("Fenster wurde nicht geoeffnet");
		}
	}

	@FXML
	private void handleButtonMerkeAction(ActionEvent event) throws SQLException {
		// Von Anastasia
		System.out.println("Du hast versucht das Buch zu vermerken");
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Hinweis.fxml"));

			AnchorPane root3 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Buecherei - Hinweis");
			stage.setScene(new Scene(root3));
			stage.show();

			int row = tabelleSortiment.getSelectionModel().getSelectedIndex();

			if (row >= 0) {
				HinweisController hinweis = fxmlLoader.getController();
				hinweis.hinweisText("Aktion erfolgreich durchgef�hrt!!");

				Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.2:3307/merkliste", "root",
						"");
				String query = "INSERT INTO merken(titel, genre, verfasser, jahr, verlag, isbn, beschreibung) VALUES ('"
						+ tabelleSortiment.getSelectionModel().getSelectedItem().getTitel() + "', '"
						+ tabelleSortiment.getSelectionModel().getSelectedItem().getGenre() + "', '"
						+ tabelleSortiment.getSelectionModel().getSelectedItem().getVerfasser() + "', '"
						+ tabelleSortiment.getSelectionModel().getSelectedItem().getJahr() + "', '"
						+ tabelleSortiment.getSelectionModel().getSelectedItem().getVerlag() + "', '"
						+ tabelleSortiment.getSelectionModel().getSelectedItem().getIsbn() + "', '"
						+ tabelleSortiment.getSelectionModel().getSelectedItem().getBeschreibung() + "')";
				Statement sta = connection.createStatement();
				int x = sta.executeUpdate(query);
				if (x == 0) {
					System.out.println("Funktion wird nicht durchgef�hrt");

				} else {
					System.out.println("Funktion wird durchgef�hrt");
				}
				connection.close();
				System.out.println(query);
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@FXML
	private void handleButtonAusleihenAction(ActionEvent event) throws SQLException {
		// Von Anastasia
		System.out.println("Du hast versucht das Buch zu auszuleihen");
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Hinweis.fxml"));

			AnchorPane root3 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Buecherei - Hinweis");
			stage.setScene(new Scene(root3));
			stage.show();

			int row = tabelleSortiment.getSelectionModel().getSelectedIndex();

			if (row >= 0) {
				HinweisController hinweis = fxmlLoader.getController();
				hinweis.hinweisText("Aktion erfolgreich durchgef�hrt!!");

				Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.2:3307/leihliste", "root",
						"");
				String query = "INSERT INTO leihen(titel, genre, verfasser, jahr, verlag, isbn, beschreibung) VALUES ('"
						+ tabelleSortiment.getSelectionModel().getSelectedItem().getTitel() + "', '"
						+ tabelleSortiment.getSelectionModel().getSelectedItem().getGenre() + "', '"
						+ tabelleSortiment.getSelectionModel().getSelectedItem().getVerfasser() + "', '"
						+ tabelleSortiment.getSelectionModel().getSelectedItem().getJahr() + "', '"
						+ tabelleSortiment.getSelectionModel().getSelectedItem().getVerlag() + "', '"
						+ tabelleSortiment.getSelectionModel().getSelectedItem().getIsbn() + "', '"
						+ tabelleSortiment.getSelectionModel().getSelectedItem().getBeschreibung() + "')";
				Statement sta = connection.createStatement();
				int x = sta.executeUpdate(query);
				if (x == 0) {
					System.out.println("Funktion wird nicht durchgef�hrt");
				} else {
					System.out.println("Funktion wird durchgef�hrt");
				}
				connection.close();
				System.out.println(query);
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@FXML
	private void handleButtonReservierenAction(ActionEvent event) throws SQLException {
		// Von Anastasia
		System.out.println("Du hast versucht das Buch zu reservieren");
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Hinweis.fxml"));

			AnchorPane root3 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Buecherei - Hinweis");
			stage.setScene(new Scene(root3));
			stage.show();

			int row = tabelleSortiment.getSelectionModel().getSelectedIndex();

			if (row >= 0) {
				HinweisController hinweis = fxmlLoader.getController();
				hinweis.hinweisText("Aktion erfolgreich durchgef�hrt!!");

				Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.2:3307/reservierliste",
						"root", "");
				String query = "INSERT INTO reservieren(titel, genre, verfasser, jahr, verlag, isbn, beschreibung) VALUES ('"
						+ tabelleSortiment.getSelectionModel().getSelectedItem().getTitel() + "', '"
						+ tabelleSortiment.getSelectionModel().getSelectedItem().getGenre() + "', '"
						+ tabelleSortiment.getSelectionModel().getSelectedItem().getVerfasser() + "', '"
						+ tabelleSortiment.getSelectionModel().getSelectedItem().getJahr() + "', '"
						+ tabelleSortiment.getSelectionModel().getSelectedItem().getVerlag() + "', '"
						+ tabelleSortiment.getSelectionModel().getSelectedItem().getIsbn() + "', '"
						+ tabelleSortiment.getSelectionModel().getSelectedItem().getBeschreibung() + "')";
				Statement sta = connection.createStatement();
				int x = sta.executeUpdate(query);
				if (x == 0) {
					System.out.println("Funktion wird nicht durchgef�hrt");
				} else {
					System.out.println("Funktion wird durchgef�hrt");
				}
				connection.close();
				System.out.println(query);
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
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
		System.out.println("Filter z-a");
		//Aufruf neues Fenster: Anastasia
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
		System.out.println("Du bist bereits auf dem Fremdsprachen-Filter");
	}

	@FXML
	private void handleButtonISBNSuchenAction(ActionEvent event) {
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
	private void handleButtonJahrSuchenAction(ActionEvent event) {
		System.out.println("Filter Jahr");
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
