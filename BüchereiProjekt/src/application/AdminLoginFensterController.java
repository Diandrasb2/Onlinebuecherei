package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

public class AdminLoginFensterController {
	@FXML
	private AnchorPane flaecheLogInFenster;
	@FXML
	private Label labelAdminLogin;
	@FXML
	private TextField tfName;
	@FXML
	private TextField tfId;
	@FXML
	private TextField tfPasswort;
	@FXML
	private PasswordField pfId;
	@FXML
	private Tooltip ttHinweisPw;
	@FXML
	private Label labelName;
	@FXML
	private Label labelId;
	@FXML
	private Label labelPasswort;
	@FXML
	private Label aLoginAnforderung;
	@FXML
	private Button buttonOK;
	@FXML
	private Button buttonZurueck;

	//Verknuepfung Funktionen: Anastasia

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
		System.out.println("Tippe deinen Namen ein");
		String tfNameL = tfName.getText();
		String tfIdL = tfId.getText();
		String tfPasswortL = tfPasswort.getText();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;


		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/admindatabase", "root", "");
			System.out.println("Verbunden");

			preparedStatement = connection.prepareStatement("SELECT id, passwort FROM admin WHERE name = ?");
			preparedStatement.setString(1, tfNameL);
			resultSet = preparedStatement.executeQuery();

			if (!resultSet.isBeforeFirst()) {
				aLoginAnforderung.setText("Dieser Benutzer existiert nicht");
				System.out.println("benutzer wurde nicht gefunden");

			} else {
				while (resultSet.next()) {
					String erhaltePasswort = resultSet.getString("passwort");
					String erhalteId = resultSet.getString("id");
					if (erhalteId.equals(tfIdL));
					if (erhaltePasswort.equals(tfPasswortL)) {
						try {
							Node source = (Node) event.getSource();
							Stage oldStage = (Stage) source.getScene().getWindow();
							oldStage.close();
							FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminFenster.fxml"));
							AnchorPane root3 = (AnchorPane) fxmlLoader.load();
							Stage stage = new Stage();
							stage.setTitle("Online Buecherei - Admin-Ansicht");
							stage.setScene(new Scene(root3));
							stage.show(); 
							return;
						} catch (IOException iOException) {
							System.out.println("Fenster wurde nicht geoeffnet");
						}
					} else {	
						aLoginAnforderung.setText("Passwort oder ID ist nicht korrekt");
						System.out.println("passw�rter stimmen nicht �berein");
					}
				}
			}
			connection.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
