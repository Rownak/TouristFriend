/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sust.classnotfound.touristfriend.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rownak
 */
@Entity
@Table(name = "place")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Place.findAll", query = "SELECT p FROM Place p"),
    @NamedQuery(name = "Place.findByIdPlace", query = "SELECT p FROM Place p WHERE p.idPlace = :idPlace"),
    @NamedQuery(name = "Place.findByName", query = "SELECT p FROM Place p WHERE p.name = :name"),
    @NamedQuery(name = "Place.findByDescription", query = "SELECT p FROM Place p WHERE p.description = :description"),
    @NamedQuery(name = "Place.findByLatitude", query = "SELECT p FROM Place p WHERE p.latitude = :latitude"),
    @NamedQuery(name = "Place.findByLongitude", query = "SELECT p FROM Place p WHERE p.longitude = :longitude")})
public class Place implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_place")
    private Integer idPlace;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "latitude")
    private double latitude;
    @Basic(optional = false)
    @Column(name = "longitude")
    private double longitude;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlace")
    private List<RatingMapping> ratingMappingList;
    @JoinColumn(name = "id_location", referencedColumnName = "id_location")
    @ManyToOne(optional = false)
    private Location idLocation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlace")
    private List<Photos> photosList;

    public Place() {
    }

    public Place(Integer idPlace) {
        this.idPlace = idPlace;
    }

    public Place(Integer idPlace, String name, double latitude, double longitude) {
        this.idPlace = idPlace;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getIdPlace() {
        return idPlace;
    }
    
    public void setIdPlace(Integer idPlace) {
        this.idPlace = idPlace;
    }
    public java.lang.Integer getPrimaryKey(){ 
    return getIdPlace(); 
  } 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @XmlTransient
    public List<RatingMapping> getRatingMappingList() {
        return ratingMappingList;
    }

    public void setRatingMappingList(List<RatingMapping> ratingMappingList) {
        this.ratingMappingList = ratingMappingList;
    }

    public Location getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Location idLocation) {
        this.idLocation = idLocation;
    }

    @XmlTransient
    public List<Photos> getPhotosList() {
        return photosList;
    }

    public void setPhotosList(List<Photos> photosList) {
        this.photosList = photosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlace != null ? idPlace.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Place)) {
            return false;
        }
        Place other = (Place) object;
        if ((this.idPlace == null && other.idPlace != null) || (this.idPlace != null && !this.idPlace.equals(other.idPlace))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sust.classnotfound.touristfriend.entity.Place[ idPlace=" + idPlace + " ]";
    }
    
}
