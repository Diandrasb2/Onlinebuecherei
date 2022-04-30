package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AdminController {
	@FXML
	private AnchorPane flächeAdmin;
	@FXML
	private Label labelAdmin;
	@FXML
	private TextField tfName;

	@FXML
	private TextField tfPersonal;
	@FXML
	private Button buttonOK;
	@FXML
	private Button buttonZurück;

	@FXML
	private void handleTfNameAction(ActionEvent event) {
		System.out.println("Tippe deinen Vor- und Nachnamen ein");
	}
	
	@FXML
	private void handleTfPersonalAction(ActionEvent event) {
		System.out.println("Tippe deine Personalnummer ein");
	}

	@FXML
	private void handleButtonOkAction(ActionEvent event) {
		System.out.println("Du hast deine Eingabe bestätigt");
	}

	@FXML
	private void handleButtonZurückAction(ActionEvent event) {
		System.out.println("Du hast den Zurück-button gedrückt");
	}
}
