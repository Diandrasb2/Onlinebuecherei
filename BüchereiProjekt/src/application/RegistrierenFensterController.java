//Erstellung RegistrierenFenster und Controller-Klasse: Anastasia
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
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class RegistrierenFensterController {

	String passwort;
	String name;
	String email;
	String passwort2;

	// Aufrufe FXML: Anastasia
	@FXML
	private AnchorPane flaecheRegistrierenFenster;
	@FXML
	private Label labelRegistrieren;
	@FXML
	private TextField tfName;
	@FXML
	private Label labelName;
	@FXML
	private Label labelEmail;
	@FXML
	private TextField tfEmail;
	@FXML
	private TextField pfPasswort;
	@FXML
	private TextField pfPasswortW;
	@FXML
	private Button buttonOK;
	@FXML
	private Button buttonZurueck;
	@FXML
	private Label labelPasswort;
	@FXML
	private Label labelPasswortWiederholen;
	@FXML
	private Label rPasswortAnforderung;
	@FXML
	private Tooltip ttHinweisPwReg;
	@FXML
	private Tooltip ttHinweisPwWiedReg;

	// Verknüpfungen Funktionen: Anastasia
	@FXML
	private void handleButtonOkAction(ActionEvent event) {
		String tfNameR = tfName.getText();
        String tfEmailR = tfEmail.getText();
        String pfPasswortR = pfPasswort.getText();
//Plan: bei OK drücken alles prüfen und nicht schon vorher

		// Abfragen: Semih und Timm
		if (tfName.getText().isEmpty()) {
			rPasswortAnforderung.setText("Geben Sie bitte Ihren Namen ein.");
			return;

		} else if (tfEmail.getText().isEmpty()) {
			rPasswortAnforderung.setText("Geben Sie bitte Ihre Email ein.");
			return;
		} else if (pfPasswort.getText().isEmpty()) {
			rPasswortAnforderung.setText("Erstellen Sie bitte ein Passwort.");
			return;
		} else if (pfPasswort.getLength() < 7) {
			rPasswortAnforderung.setText("Das erstellte Passwort ist zu kurz.");
			return;
		} else if (pfPasswort.getLength() > 30) {
			rPasswortAnforderung.setText("Das erstellte Passwort ist zu lang.");
			return;
		} else if (pfPasswortW.getText().isEmpty()) {
			rPasswortAnforderung.setText("Bitte Passworteingabe wiederholen.");
			return;
		} else if (!pfPasswortW.getText().equals(pfPasswort.getText())) {
			rPasswortAnforderung.setText("Das Passwort muss uebereinstimmen.");
			return;
		}
		// Email-Abfrage: Diandra
		else if (!tfEmail.getText().contains("@")){
			rPasswortAnforderung.setText("Diese E-Mail ist ungueltig.");

			// Neues Fenster: Anastasia
		} else		             
		       
		
	{	System.out.println("Hier musst du dich nun einloggen um fortzufahren.");

			Node source = (Node) event.getSource();
			Stage oldStage = (Stage) source.getScene().getWindow();
			oldStage.close();

			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
				AnchorPane root3 = (AnchorPane) fxmlLoader.load();
				Stage stage = new Stage();
				stage.setTitle("Online Buecherei");
				stage.setScene(new Scene(root3));
				stage.show();
			} catch (IOException iOException) {
				System.out.println("Fenster wurde nicht geoeffnet");
			}
		}
		   try {
               Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.2:3307/benutzerdatabase", "root", "");

               String query = "INSERT INTO benutzer(username, email, passwort) VALUES('"+tfNameR+"','"+tfEmailR+"','"+pfPasswortR+"')";
               Statement sta = connection.createStatement();
               int x = sta.executeUpdate(query);
               if (x == 0) {
               	rPasswortAnforderung.setText("Sie sind bereits registriert");
               } else {
               	rPasswortAnforderung.setText("Erfolgreich regisrtriert");
               }
               connection.close();
           } catch (Exception exception) {
               exception.printStackTrace();
           }
       }

	@FXML
	private void handleButtonZurueckAction(ActionEvent event) {
		System.out.println("Du hast den Zurueck-button gedrueckt");
		//Neues Fenster: Anastasia
		Node source = (Node) event.getSource();
		Stage oldStage = (Stage) source.getScene().getWindow();
		oldStage.close();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
			AnchorPane root3 = (AnchorPane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Online Buecherei");
			stage.setScene(new Scene(root3));
			stage.show();
		} catch (IOException iOException) {
			System.out.println("Fenster wurde nicht geoeffnet");
		}
	}

}
