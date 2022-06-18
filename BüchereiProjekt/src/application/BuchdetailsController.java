//Angelegt von Anastasia
package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class BuchdetailsController  {

	@FXML
	private AnchorPane Hinweisflaeche;
	@FXML
	private Label labelDetails;
	@FXML
	private TextFlow text;
	@FXML
	private Text textData;

	public void setData(String titel,String verfasser, String genre,  int jahr, String verlag, long isbn, String beschreibung){

		textData.setText("Titel: " + titel + "\n"+
				"Genre: " + genre + "\n"+
				"Verfasser: " + verfasser +"\n"+ 
				"Jahr: " + jahr +"\n"+
				"Verlag: " + verlag + "\n"+
				"ISBN: " + isbn +"\n"+
				"Beschreibung: " + beschreibung);
	}
}