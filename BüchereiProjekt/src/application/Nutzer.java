package application;

public class Nutzer {

String username;
String email;
String passwort;

public Nutzer( String username, String email, String passwort) {
	
	this.username=username;
	this.email=email;
	this.passwort=passwort;
	
}



public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPasswort() {
	return passwort;
}
public void setPasswort(String passwort) {
	this.passwort = passwort;
}


}
