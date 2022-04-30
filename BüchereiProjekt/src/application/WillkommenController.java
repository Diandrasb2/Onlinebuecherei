package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class WillkommenController {
	@FXML
	private AnchorPane fl�cheWillkommen;
	@FXML
	private Label labelWillkommen;
	@FXML
	private TextField tfSuche;
	@FXML
	private Button buttonOK;
	@FXML
	private void handleTfSucheAction(ActionEvent event) {
		System.out.println("Gib hier einen Suchbegriff ein");
	}

	@FXML
	private void handleButtonOkAction(ActionEvent event) {
		System.out.println("Du hast deine Eingabe best�tigt");
	}
}
