/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sust.classnotfound.touristfriend.bean;

import java.util.Date;
import sust.classnotfound.touristfriend.entity.Photos;

public class PhotosBean {
	
	private Integer idPhotos;
   private double lat;
    private double lang;
    private double rating;
    private int numOfUserRated;
   private Date date;
    private String description;
    private String photoUrl;

    public PhotosBean(Photos photos) {
        this.idPhotos = photos.getIdPhotos();
        this.lat = photos.getLat();
        this.lang = photos.getLang();
        this.rating = photos.getRating();
        this.numOfUserRated = photos.getNumOfUserRated();
        this.date = photos.getDate();
        this.description = photos.getDescription();
        this.photoUrl = photos.getPhotoUrl();
    }
    
    
    
        
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
