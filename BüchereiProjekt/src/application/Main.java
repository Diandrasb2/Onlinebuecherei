<<<<<<< Updated upstream
//Erstellung Main-Klasse: Anastasia

package application;
=======
package application;

import java.sql.SQLException;
>>>>>>> Stashed changes

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	// Aufruf Scene: Anastasia
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("MainScene.fxml"));
			Scene scene = new Scene(root, 600, 400);
			primaryStage.setTitle("Online Buecherei");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
