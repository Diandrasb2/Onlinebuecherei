//Erstellung AdminBuchsortiment und Controller-Klasse: Anastasia

package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		titel.setCellValueFactory(new PropertyValueFactory<Buch, String>("titel"));
		genre.setCellValueFactory(new PropertyValueFactory<Buch, String>("genre"));
		verfasser.setCellValueFactory(new PropertyValueFactory<Buch, String>("verfasser"));
		jahr.setCellValueFactory(new PropertyValueFactory<Buch, Integer>("jahr"));
		verlag.setCellValueFactory(new PropertyValueFactory<Buch, String>("verlag"));
		isbn.setCellValueFactory(new PropertyValueFactory<Buch, Long>("isbn"));
		beschreibung.setCellValueFactory(new PropertyValueFactory<Buch, String>("beschreibung"));

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.2:3307/buecherliste", "root", "");
			System.out.println("Verbunden");

			// ausgabe alle Bücher

			ResultSet rs = connection.createStatement()
					.executeQuery("select * from alleBuecher");

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

			if(row>=0) {			
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
