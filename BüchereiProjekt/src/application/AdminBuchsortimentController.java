//Erstellung AdminBuchsortiment und Controller-Klasse: Anastasia

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AdminBuchsortimentController implements Initializable {

	@FXML
	private AnchorPane flaecheAdminansicht;
	@FXML
	private Label labelBuecherei;
	@FXML
	private Button buttonAdminStart;
	@FXML
	private Tooltip ttStart;
	@FXML
	private Button buttonAusloggen;
	@FXML
	private Button buttonNutzerliste;
	@FXML
	private Button buttonBuchsortiment;
	@FXML
	private Pane flaecheTabelle;
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

	//Datenbankverknüpfung+aufruf (von Anastastia)
	
	ObservableList<Buch> liste = FXCollections.observableArrayList();

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.2:3307/buecherliste", "root", "");
			System.out.println("Verbunden");
			ResultSet rs = connection.createStatement().executeQuery("select * from alleBuecher");

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
			}
//			System.out.println("Liste geadded");
//			System.out.println(liste);

		} catch (SQLException ex) {
			System.out.println("Fehler");
		}

//		System.out.println("Verbindung aufgegriffen");
		tabelleSortiment.setItems(liste);
//		System.out.println(liste);
	}

	@FXML
	private void handleButtonAnzeigenAction(ActionEvent event) throws SQLException {
//Hier findet Aufruf der Datenbank statt

		System.out.println("Neue verbindungen aufbauen");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.2:3307/buecherliste", "root", "");
		System.out.println("Verbunden");
		String query = "SELECT * FROM alleBuecher ORDER BY titel";// Datenbank wird alphabetisch nach Titel sortiert
		Statement sta = connection.createStatement();
		ResultSet rs = sta.executeQuery(query);
		
		int columns = rs.getMetaData().getColumnCount();
		while (rs.next()) {
			for (int i = 1; i <= columns; i++) {
				System.out.println(String.format("%-15s", rs.getString(i)));// Nur für eigene Ansicht über Eclipse
				tabelleSortiment.setId(String.format("%-15s", rs.getString(i)));// Datenbannk wird in Software angezeigt
//				System.out.println("Versuch verbindung aufgreifen");
				titel.setCellValueFactory(new PropertyValueFactory<Buch, String>("titel"));
				genre.setCellValueFactory(new PropertyValueFactory<Buch, String>("genre"));
				verfasser.setCellValueFactory(new PropertyValueFactory<Buch, String>("verfasser"));
				jahr.setCellValueFactory(new PropertyValueFactory<Buch, Integer>("jahr"));
				verlag.setCellValueFactory(new PropertyValueFactory<Buch, String>("verlag")); 
				isbn.setCellValueFactory(new PropertyValueFactory<Buch, Long>("isbn"));
				beschreibung.setCellValueFactory(new PropertyValueFactory<Buch, String>("beschreibung"));
			}
		}
		rs.close();
		sta.close();
		connection.close();

	}

	@FXML
	private void handleButtonAdminStartAction(ActionEvent event) {
		System.out.println("Startseite wird wieder geöffnet");
		// Neues Fenster: Anastasia
		Node source = (Node) event.getSource();
		Stage oldStage = (Stage) source.getScene().getWindow();
		oldStage.close();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminFenster.fxml"));
			AnchorPane root1 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Buecherei - Admin-Ansicht");
			stage.setScene(new Scene(root1));
			stage.show();
		} catch (IOException iOException) {
			System.out.println("Fenster wurde nicht geoeffnet");
		}
	}

	@FXML
	private void handleButtonAusloggenAction(ActionEvent event) {
		System.out.println("Bestaetigungsabfrage des Log-outs wird angezeigt");
		// Neues Fenster: Anastasia
		Node source = (Node) event.getSource();
		Stage oldStage = (Stage) source.getScene().getWindow();
		oldStage.close();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AusloggenAdmin.fxml"));
			AnchorPane root1 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Buecherei - Ausloggen");
			stage.setScene(new Scene(root1));
			stage.show();
		} catch (IOException iOException) {
			System.out.println("Fenster wurde nicht geoeffnet");
		}
	}

	@FXML
	private void handleButtonNutzerlisteAction(ActionEvent event) {
		System.out.println("Liste aller Nutzer");
		// Neues Fenster: Anastasia
		Node source = (Node) event.getSource();
		Stage oldStage = (Stage) source.getScene().getWindow();
		oldStage.close();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminNutzerliste.fxml"));
			AnchorPane root1 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Buecherei - Buchsortiment");
			stage.setScene(new Scene(root1));
			stage.show();
		} catch (IOException iOException) {
			System.out.println("Fenster wurde nicht geoeffnet");
		}
	}

	@FXML
	private void handleButtonBuchsortimentAction(ActionEvent event) {
		System.out.println("Wird bereits angezeigt");
	}

	

}
