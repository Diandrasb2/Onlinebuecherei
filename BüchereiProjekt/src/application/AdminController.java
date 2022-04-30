package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AdminController {
	@FXML
	private AnchorPane fl�cheAdmin;
	@FXML
	private Label labelAdmin;
	@FXML
	private TextField tfName;

	@FXML
	private TextField tfPersonal;
	@FXML
	private Button buttonOK;
	@FXML
	private Button buttonZur�ck;

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
		System.out.println("Du hast deine Eingabe best�tigt");
	}

	@FXML
	private void handleButtonZur�ckAction(ActionEvent event) {
		System.out.println("Du hast den Zur�ck-button gedr�ckt");
	}
}
