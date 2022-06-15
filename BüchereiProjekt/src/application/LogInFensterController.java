//Erstellung LogInFenster und Controller-Klasse: Anastasia

package application;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LogInFensterController {

	// Aufrufe FXML: Anastasia
	@FXML
	private AnchorPane flaecheLogInFenster;
	@FXML
	private Label labelLogIn;
	@FXML
	private TextField tfEmail;
	@FXML
	private TextField tfPasswort;
	@FXML
	private PasswordField pfPasswort;
	@FXML
	private Tooltip ttHinweisPw;
	@FXML
	private Label lLoginAnforderung;
	@FXML
	private Label labelEmail;
	@FXML
	private Label labelPasswort;
	@FXML
	private Button buttonOK;
	@FXML
	private Button buttonZurueck;

//Verknüpfung Funktionen: Anastasia
	@FXML
	private void handleTfEmailAction(ActionEvent event) {
		System.out.println("Tippe deine Email ein");
	}

	@FXML
	private void handlePfPasswortAction(ActionEvent event) {
		System.out.println("Tippe dein Passwort ein");
	}

	@FXML
	private void handleButtonZurueckAction(ActionEvent event) {
		System.out.println("Du hast den Zurueck-button gedrueckt");

		// Neues Fenster: Anastasia
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

	@FXML
	private void handleButtonOkAction(ActionEvent event) {
		System.out.println("Hier gelangst du zum Willkommen-Fenster");
		String tfEmailL = tfEmail.getText();
		String pfPasswortL = pfPasswort.getText();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		// Neues Fenster: Anastasia
		// Login 
	try {
        connection = DriverManager.getConnection("jdbc:mysql://127.0.0.2:3307/benutzerdatabase", "root", "");
        System.out.println("Verbunden");
        
        preparedStatement = connection.prepareStatement("select passwort from benutzer where email = ?");
        preparedStatement.setString(1, tfEmailL);
        resultSet = preparedStatement.executeQuery();
       
        if (!resultSet.isBeforeFirst()) {
        	lLoginAnforderung.setText("Dieser Benutzer existiert nicht");
        	System.out.println("benutzer wurde nicht gefunden");
        	
        } else {
        	while (resultSet.next()) {
        		String erhaltePasswort = resultSet.getString("passwort");
        		if (erhaltePasswort.equals(pfPasswortL)) {
        			try {
        				Node source = (Node) event.getSource();
        				Stage oldStage = (Stage) source.getScene().getWindow();
        				oldStage.close();
        				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Willkommen.fxml"));
        				AnchorPane root3 = (AnchorPane) fxmlLoader.load();
        				Stage stage = new Stage();
        				stage.setTitle("Online Buecherei - Willkommen");
        				stage.setScene(new Scene(root3));
        				stage.show(); 
        				return;
        			} catch (IOException iOException) {
        				System.out.println("Fenster wurde nicht geoeffnet");
        			}
        				} else {	
        					lLoginAnforderung.setText("Passwort ist nicht korrekt");
        					System.out.println("passwörter stimmen nicht überein");
        			}
        		}
        	}
        		connection.close();
    } catch (Exception exception) {
        exception.printStackTrace();
    }
	}
}
