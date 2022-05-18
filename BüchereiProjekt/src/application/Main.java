//Erstellung Main-Klasse: Anastasia

package application;

import java.sql.SQLException;

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

	// Aufruf Datenbank: Timm
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		launch(args);
		MySQL.connect();
		MySQL.update(
				"CREATE TABLE IF NOT EXISTS `BenutzerDatabase`.`benutzer` (`id` INT NOT NULL AUTO_INCREMENT,`nameNachname` VARCHAR(45) NOT NULL,`email` VARCHAR(45) NOT NULL,`passwort` VARCHAR(45) NOT NULL,PRIMARY KEY (`id`))ENGINE = InnoDB");
		MySQL.disconnect();
	}

}
