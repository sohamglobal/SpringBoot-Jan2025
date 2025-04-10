package com.sohamglobal.provider.entities;

public class Film {
	private String filmname;
	private String genre;
	private String language;
	public Film(String filmname, String genre, String language) {
		super();
		this.filmname = filmname;
		this.genre = genre;
		this.language = language;
	}
	public String getFilmname() {
		return filmname;
	}
	public void setFilmname(String filmname) {
		this.filmname = filmname;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	

}
