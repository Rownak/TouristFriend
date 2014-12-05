package com.example.mainprojecttheraptest;

import java.util.Date;

public class PhotosBean {
	
	private Integer idPhotos;
   private double lat;
    private double lang;
    private double rating;
    private int numOfUserRated;
   private Date date;
    private String description;
    private String photoUrl;
    
    
    
    
	public PhotosBean() {
		
	}
	public Integer getIdPhotos() {
		return idPhotos;
	}
	public void setIdPhotos(Integer idPhotos) {
		this.idPhotos = idPhotos;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLang() {
		return lang;
	}
	public void setLang(double lang) {
		this.lang = lang;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public int getNumOfUserRated() {
		return numOfUserRated;
	}
	public void setNumOfUserRated(int numOfUserRated) {
		this.numOfUserRated = numOfUserRated;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
    
    


}
