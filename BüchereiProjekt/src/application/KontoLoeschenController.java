//Erstellung KontoLoeschen und Controller-Klasse: Anastasia

package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class KontoLoeschenController {
	@FXML
	private AnchorPane Hinweisflaeche;
	@FXML
	private Label labelHinweis;
	@FXML
	private Button buttonOk;
	@FXML
	private Button buttonBack;
	@FXML
	private TextField tfEmailL;
	@FXML
	private TextField tfPasswortL;

	@FXML
	private void handleButtonOkAction(ActionEvent event) {
		System.out.println("Hier soll nun Konto gel�scht werden");

		String tfEmail = tfEmailL.getText();
		String tfPasswort = tfPasswortL.getText();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		// Neues Fenster: Anastasia
		// Login 
		try {
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.2:3307/benutzerdatabase", "root", "");
			System.out.println("Verbunden");

			preparedStatement = connection.prepareStatement("SELECT passwort FROM benutzer WHERE email = ?");
			preparedStatement.setString(1, tfEmail);
			resultSet = preparedStatement.executeQuery();

			if (!resultSet.isBeforeFirst()) {
				labelHinweis.setText("Dieser Benutzer existiert nicht");
				System.out.println("benutzer wurde nicht gefunden");

			} else {
				while (resultSet.next()) {
					String erhaltePasswort = resultSet.getString("passwort");
					if (erhaltePasswort.equals(tfPasswort)) {
						String query = "delete from benutzer where email = ('" + tfEmail + "')";
						Statement sta = connection.createStatement();
						sta.execute(query);
						sta.close();
						try {
							Node source = (Node) event.getSource();
							Stage oldStage = (Stage) source.getScene().getWindow();
							oldStage.close();
							FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
							AnchorPane root3 = (AnchorPane) fxmlLoader.load();
							Stage stage = new Stage();
							stage.setTitle("Online Buecherei");
							stage.setScene(new Scene(root3));
							stage.show(); 
							return;

						} catch (IOException iOException) {
							System.out.println("Fenster wurde nicht geoeffnet");
						}
					} else {	
						labelHinweis.setText("Passwort ist nicht korrekt");
						System.out.println("Passw�rter stimmen nicht �berein");
					}
				}
			}
			connection.close();

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@FXML
	private void handleButtonBackAction(ActionEvent event) {
		System.out.println("Zurueck zum Einstellungsfenster");

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
}