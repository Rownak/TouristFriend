/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sust.classnotfound.touristfriend.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rownak
 */
@Entity
@Table(name = "photos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Photos.findAll", query = "SELECT p FROM Photos p"),
    @NamedQuery(name = "Photos.findByIdPhotos", query = "SELECT p FROM Photos p WHERE p.idPhotos = :idPhotos"),
    @NamedQuery(name = "Photos.findByLat", query = "SELECT p FROM Photos p WHERE p.lat = :lat"),
    @NamedQuery(name = "Photos.findByLang", query = "SELECT p FROM Photos p WHERE p.lang = :lang"),
    @NamedQuery(name = "Photos.findByRating", query = "SELECT p FROM Photos p WHERE p.rating = :rating"),
    @NamedQuery(name = "Photos.findByNumOfUserRated", query = "SELECT p FROM Photos p WHERE p.numOfUserRated = :numOfUserRated"),
    @NamedQuery(name = "Photos.findByDate", query = "SELECT p FROM Photos p WHERE p.date = :date"),
    @NamedQuery(name = "Photos.findByDescription", query = "SELECT p FROM Photos p WHERE p.description = :description"),
    @NamedQuery(name = "Photos.findByPhotoUrl", query = "SELECT p FROM Photos p WHERE p.photoUrl = :photoUrl")})
public class Photos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_photos")
    private Integer idPhotos;
    @Basic(optional = false)
    @Column(name = "lat")
    private double lat;
    @Basic(optional = false)
    @Column(name = "lang")
    private double lang;
    @Basic(optional = false)
    @Column(name = "rating")
    private double rating;
    @Basic(optional = false)
    @Column(name = "num_of_user_rated")
    private int numOfUserRated;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "photo_url")
    private String photoUrl;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User idUser;
    @JoinColumn(name = "id_place", referencedColumnName = "id_place")
    @ManyToOne(optional = false)
    private Place idPlace;
    @JoinColumn(name = "id_season", referencedColumnName = "id_season")
    @ManyToOne(optional = false)
    private Season idSeason;

    public Photos() {
    }

    public Photos(Integer idPhotos) {
        this.idPhotos = idPhotos;
    }

    public Photos(Integer idPhotos, double lat, double lang, String photoUrl, User idUser, Place idPlace, Season idSeason) {
        this.idPhotos = idPhotos;
        this.lat = lat;
        this.lang = lang;
        this.photoUrl = photoUrl;
        this.idUser = idUser;
        this.idPlace = idPlace;
        this.idSeason = idSeason;
    }
    
    public Photos(Integer idPhotos, double lat, double lang, double rating, int numOfUserRated, String photoUrl,Place idPlace) {
        this.idPhotos = idPhotos;
        this.lat = lat;
        this.lang = lang;
        this.rating = rating;
        this.numOfUserRated = numOfUserRated;
        this.photoUrl = photoUrl;
        this.idPlace = idPlace;
    }
    public static Photos newPhotos(double lat,double lang,String photoUrl, Place idPlace){
        return new Photos(0,lat,lang,0,0,photoUrl,idPlace);
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

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Place getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(Place idPlace) {
        this.idPlace = idPlace;
    }

    public Season getIdSeason() {
        return idSeason;
    }

    public void setIdSeason(Season idSeason) {
        this.idSeason = idSeason;
    }
    public java.lang.Integer getPrimaryKey(){ 
    return getIdPhotos(); 
  } 
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPhotos != null ? idPhotos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Photos)) {
            return false;
        }
        Photos other = (Photos) object;
        if ((this.idPhotos == null && other.idPhotos != null) || (this.idPhotos != null && !this.idPhotos.equals(other.idPhotos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sust.classnotfound.touristfriend.entity.Photos[ idPhotos=" + idPhotos + " ]";
    }
    
}
