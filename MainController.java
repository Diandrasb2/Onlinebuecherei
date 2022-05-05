package application;


	
	import javafx.fxml.FXML;
	import javafx.stage.Stage;
	import javafx.scene.control.Button;
	import javafx.scene.control.Label;
	import javafx.scene.control.PasswordField;
	import javafx.scene.control.TextField;

import java.io.IOException;

import javafx.event.ActionEvent;


	public class MainController {
		
		@FXML
		private TextField rNameTextfield;
		@FXML
		private TextField rEmailTextfield;
		@FXML
		private PasswordField rPasswordTextfield;
		@FXML
		private PasswordField rPasswordWhTextfield;
		@FXML
		private Label rPasswortAnforderung;
		@FXML
		private Label rCheckPassword;
		@FXML
		private Button rZurueckButton;
		@FXML
		private Button registrierenButton;
		
		
		public void registration(ActionEvent event) throws IOException{
			registrationsCheck();
			//leangePassword();
			//checkPassword();
		}
			/*
		public void leangePassword() throws IOException{
			if(rPasswordTextfield.getLength() < 7) {
				rCheckPassword.setText("Passwort zu Kurz");
				return;
			}
				
				for (int i = 0; i < rPasswordTextfield.getLength(); i++) {
					boolean hatNum = false; boolean hatCap = false; boolean hatLow = false; char c;
					c = ((CharSequence) rPasswordTextfield).charAt(i);
					
					//checkt ob eine Zahl dabei ist
					if(Character.isDigit(c)) {
						hatNum = true;
						
					}
					
					//checkt ob ein großbuchstabe dabei ist
					else if(Character.isUpperCase(c)) {
						hatCap = true;
						
					}
					
					//checkt ob ein kleinbuchstabe dabei ist
					else if(Character.isLowerCase(c)) {
						hatLow = true;
						
					}
					
					//checkt ob alle 3 true sind
					else if(hatNum && hatCap && hatLow) {
						rCheckPassword.setText(" ");
						
					}
					
					rCheckPassword.setText("Fehler!");
					
				}
		
		
		public boolean checkPassword() throws IOException{
			boolean hatNum = false; boolean hatCap = false; boolean hatLow = false; char c;
			for (int i = 0; i < rPasswordTextfield.getLength(); i++) {
				
				c = ((CharSequence) rPasswordTextfield).charAt(i);
				
				if(Character.isDigit(c)) {
					hatNum = true;
					
				}
				else if(Character.isUpperCase(c)) {
					hatCap = true;
					
				}
				else if(Character.isLowerCase(c)) {
					hatLow = true;
					
				}
				else if(hatNum && hatCap && hatLow) {
					return true;
					
				}
			}
			
			rCheckPassword.setText("Fehler!");
			return false;
			
		}
		*/
		
			
		
		//check ob Felder ausgefüllt sind 
		
		public void registrationsCheck() throws IOException{
			
			Main m = new Main();
			
				if(rNameTextfield.getText().isEmpty()) {
					rPasswortAnforderung.setText("Bitte Name Eingeben.");
					return;
				}
				if(rEmailTextfield.getText().isEmpty()) {
					rPasswortAnforderung.setText("Bitte Email Eingeben.");
					return;
				}
				if(rPasswordTextfield.getText().isEmpty()) {
					rPasswortAnforderung.setText("Bitte Passwort Eingeben.");
					return;
				}
				if(rPasswordTextfield.getLength() < 7) {
					rPasswortAnforderung.setText("Passwort zu Kurz.");
					return;
				}
				if(rPasswordWhTextfield.getText().isEmpty()) {
					rPasswortAnforderung.setText("Bitte Paswort nochmal Eingeben.");
					return;
				}
				
				
				  if(!rPasswordWhTextfield.getText().equals(rPasswordTextfield.getText()) ) {
					rPasswortAnforderung.setText("Passwort muss übereinstimmen!");
					return;
				}
				  
				
				rPasswortAnforderung.setText("Registrierung Erfolgreich!");
				
				m.changeScene("nachRegistration.fxml");
				
		}
		
	
	}
	
