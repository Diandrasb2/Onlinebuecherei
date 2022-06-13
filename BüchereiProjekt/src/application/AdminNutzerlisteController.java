//Erstellung AdminNutzerliste und Controller-Klasse: Anastasia
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
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pojo.Nutzer;

public class AdminNutzerlisteController implements Initializable{

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
	private TableView<Nutzer> tabelleNutzer;
	@FXML
	private TableColumn<Nutzer, String> username;
	@FXML
	private TableColumn<Nutzer, String> email;
	@FXML
	private TableColumn<Nutzer, String> passwort;
	@FXML
	private Button buttonEntf;
	@FXML
	private ScrollBar scrollScrollbar;
	@FXML
	private Label labelKonto;
	
	@FXML
	private ImageView imgHome;
	
	//Datenbankverknüpfung+aufruf (von Anastastia)
	
		ObservableList<Nutzer> liste = FXCollections.observableArrayList();

		@Override
		public void initialize(URL url, ResourceBundle rb) {
			username.setCellValueFactory(new PropertyValueFactory<Nutzer, String>("username"));
			email.setCellValueFactory(new PropertyValueFactory<Nutzer, String>("email"));
			passwort.setCellValueFactory(new PropertyValueFactory<Nutzer, String>("passwort"));
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.2:3307/benutzerdatabase", "root", "");
				System.out.println("Verbunden");
				ResultSet rs = connection.createStatement().executeQuery("select * from benutzer");

				while (rs.next()) {
					Nutzer n = new Nutzer(rs.getString("username"), rs.getString("email"),
							rs.getString("passwort"));
					n.setUsername(rs.getString("username"));
					n.setEmail(rs.getString("email"));
					n.setPasswort(rs.getString("passwort"));
					liste.add(n);
				}


			} catch (SQLException ex) {
				System.out.println("Fehler");
			}

			tabelleNutzer.setItems(liste);

		}

		@FXML
		private void handleButtonEntfAction(ActionEvent event) {

			int zeile = tabelleNutzer.getSelectionModel().getSelectedIndex();

			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Hinweis.fxml"));

				AnchorPane root3 = (AnchorPane) fxmlLoader.load();
				Stage stage = new Stage();
				stage.setTitle("Online Buecherei - Hinweis");
				stage.setScene(new Scene(root3));
				stage.show();

				int row = tabelleNutzer.getSelectionModel().getSelectedIndex();

				if (row >= 0) {
					HinweisController hinweis = fxmlLoader.getController();
					hinweis.hinweisText("Aktion erfolgreich durchgeführt!!");
					Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.2:3307/reservierliste",
							"root", "");
					String query = "delete from reservieren where titel like ('"
							+ tabelleNutzer.getSelectionModel().getSelectedItem().getUsername() + "')";
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
				tabelleNutzer.getItems().remove(zeile);
			}
		}

	
	@FXML
	private void handleButtonAdminStartAction (ActionEvent event) {
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
	private void handleButtonAusloggenAction (ActionEvent event) {
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
	private void handleButtonNutzerlisteAction (ActionEvent event) {
		System.out.println("Wird bereits angezeigt");
	}
	@FXML
	private void handleButtonBuchsortimentAction (ActionEvent event) {
		System.out.println("Buchsortiment wird angezeigt");
		// Neues Fenster: Anastasia
				Node source = (Node) event.getSource();
				Stage oldStage = (Stage) source.getScene().getWindow();
				oldStage.close();

				try {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminBuchsortiment.fxml"));
					AnchorPane root1 = (AnchorPane) fxmlLoader.load();
					Stage stage = new Stage();
					stage.setTitle("Online Buecherei - Buchsortiment");
					stage.setScene(new Scene(root1));
					stage.show();
				} catch (IOException iOException) {
					System.out.println("Fenster wurde nicht geoeffnet");
				}
	}

	
}
