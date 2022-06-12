//Angelegt von Anastasia

package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class HinweisController {

	@FXML
	private AnchorPane Hinweisflaeche;

	@FXML
	private Label labelHinweis;

	public void hinweisText (String text) {
		labelHinweis.setText("Aktion erfolgreich durchgeführt!");
	}
	
}
