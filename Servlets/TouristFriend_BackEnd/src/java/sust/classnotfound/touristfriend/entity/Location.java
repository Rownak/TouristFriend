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
@Table(name = "location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
    @NamedQuery(name = "Location.findByIdLocation", query = "SELECT l FROM Location l WHERE l.idLocation = :idLocation"),
    @NamedQuery(name = "Location.findByLocationName", query = "SELECT l FROM Location l WHERE l.locationName = :locationName"),
    @NamedQuery(name = "Location.findByLatitude", query = "SELECT l FROM Location l WHERE l.latitude = :latitude"),
    @NamedQuery(name = "Location.findByLongitude", query = "SELECT l FROM Location l WHERE l.longitude = :longitude")})
public class Location implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_location")
    private Integer idLocation;
    @Basic(optional = false)
    @Column(name = "location_name")
    private String locationName;
    @Basic(optional = false)
    @Column(name = "latitude")
    private double latitude;
    @Basic(optional = false)
    @Column(name = "longitude")
    private double longitude;
    @JoinColumn(name = "id_district", referencedColumnName = "id_district")
    @ManyToOne(optional = false)
    private District idDistrict;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLocation")
    private List<Place> placeList;

    public Location() {
    }

    public Location(Integer idLocation) {
        this.idLocation = idLocation;
    }

    public Location(Integer idLocation, String locationName, double latitude, double longitude) {
        this.idLocation = idLocation;
        this.locationName = locationName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Integer idLocation) {
        this.idLocation = idLocation;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
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

    public District getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(District idDistrict) {
        this.idDistrict = idDistrict;
    }
    public java.lang.Integer getPrimaryKey(){ 
    return getIdLocation(); 
  } 

    @XmlTransient
    public List<Place> getPlaceList() {
        return placeList;
    }

    public void setPlaceList(List<Place> placeList) {
        this.placeList = placeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocation != null ? idLocation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.idLocation == null && other.idLocation != null) || (this.idLocation != null && !this.idLocation.equals(other.idLocation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sust.classnotfound.touristfriend.entity.Location[ idLocation=" + idLocation + " ]";
    }
    
}
