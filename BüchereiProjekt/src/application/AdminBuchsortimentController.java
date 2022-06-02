//Erstellung AdminBuchsortiment und Controller-Klasse: Anastasia

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
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AdminBuchsortimentController {

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
	private TableView<?> tabelleSortiment;
	@FXML
	private ScrollBar scrollScrollbar;
	
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
	private void handleButtonBuchsortimentAction (ActionEvent event) {
		System.out.println("Wird bereits angezeigt");
	}
	@FXML
	private void handleTabelleSortimentAction(SortEvent<?> event) {
	//Hier tabelle füllen
	}
	
}
