//Erstellung Reserviert und Controller-Klasse: Diandra (Vorlage: Timm)
package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
import javafx.scene.control.TitledPane;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pojo.Buch;

public class AusgeliehenController implements Initializable{
	// Aufrufe FXML: Diandra und Anastasia (Vorlage: Timm und Anastasia)
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
	private Label labelAusgeliehen;
	@FXML
	private Pane paneScrollbereich;
	@FXML
	private Button buttonAnzeigen;
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
	private Button buttonEntf;
	
	@FXML
	private ImageView imgKonto;
	@FXML
	private ImageView imgHome;
	@FXML
	private ImageView imgAusloggen;
	@FXML
	private ImageView imgHilfe;

	// Verknuepfung Funktionen: Diandra (Vorlage: Timm)
	
	//Datenbankverknüpfung Anastasia
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
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.2:3307/leihliste", "root", "");
			System.out.println("Verbunden");

			//Buecher aufrufen

			ResultSet rs = connection.createStatement()
					.executeQuery("select * from leihen");

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
			
			//Ausgabe aus der Tabelle wird für gewählte Zeile in neuem Fenster ausgegeben um alles lesen zu können
			BuchdetailsController buchdetailsController=fxmlLoader.getController();
			
			int row = tabelleSortiment.getSelectionModel().getSelectedIndex();

			if(row>=0) { //Nur wenn ein Feld ausgewählt ist, ist dieser Aufruf möglich
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
	private void handleButtonEntfAction(ActionEvent event) {

		int zeile = tabelleSortiment.getSelectionModel().getSelectedIndex();

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
				hinweis.hinweisText("Aktion erfolgreich durchgeführt!!");
				Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.2:3307/reservierliste",
						"root", "");
				String query = "delete from reservieren where titel like ('"
						+ tabelleSortiment.getSelectionModel().getSelectedItem().getTitel() + "')";
				Statement sta = connection.createStatement();
				int x = sta.executeUpdate(query);
				if (x == 0) {
					System.out.println("Funktion wird nicht durchgeführt");
				} else {
					System.out.println("Funktion wird durchgeführt");
				}
				connection.close();
				System.out.println(query);
				entfernen(zeile);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public void entfernen(int zeile) {
		if (zeile >= 0) {
			tabelleSortiment.getItems().remove(zeile);
		}
	}
	
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
		System.out.println("Du bist bereits bei Ausgeliehen");
		 
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
