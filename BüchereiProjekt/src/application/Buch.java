package application;

public class Buch {
String titel;
String genre;
String verfasser;
Integer jahr;
String verlag;
Long isbn;
String beschreibung;

public Buch(String titel, String genre, String verfasser, Integer jahr, String verlag, Long isbn, String beschreibung) {
	this.titel=titel;
	this.genre=genre;
	this.verfasser=verfasser;
	this.jahr=jahr;
	this.verlag=verlag;
	this.isbn=isbn;
	this.beschreibung=beschreibung;
}

public String getTitel() {
	return titel;
}

public String getGenre() {
	return genre;
}

public void setTitel(String titel) {
	this.titel = titel;
}

public void setGenre(String genre) {
	this.genre = genre;
}

public void setVerfasser(String verfasser) {
	this.verfasser = verfasser;
}

public void setJahr(Integer jahr) {
	this.jahr = jahr;
}

public void setVerlag(String verlag) {
	this.verlag = verlag;
}

public void setIsbn(Long isbn) {
	this.isbn = isbn;
}

public String getVerfasser() {
	return verfasser;
}

public Integer getJahr() {
	return jahr;
}

public String getVerlag() {
	return verlag;
}

public Long getIsbn() {
	return isbn;
}

public String getBeschreibung() {
	return beschreibung;
}
public void setBeschreibung(String beschreibung) {
	this.beschreibung = beschreibung;
}

}
