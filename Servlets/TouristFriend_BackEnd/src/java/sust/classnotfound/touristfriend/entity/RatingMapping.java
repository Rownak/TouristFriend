/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sust.classnotfound.touristfriend.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rownak
 */
@Entity
@Table(name = "rating_mapping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RatingMapping.findAll", query = "SELECT r FROM RatingMapping r"),
    @NamedQuery(name = "RatingMapping.findByIdRating", query = "SELECT r FROM RatingMapping r WHERE r.idRating = :idRating"),
    @NamedQuery(name = "RatingMapping.findByRating", query = "SELECT r FROM RatingMapping r WHERE r.rating = :rating")})
public class RatingMapping implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rating")
    private Integer idRating;
    @Basic(optional = false)
    @Column(name = "rating")
    private double rating;
    @JoinColumn(name = "id_place", referencedColumnName = "id_place")
    @ManyToOne(optional = false)
    private Place idPlace;
    @JoinColumn(name = "id_season", referencedColumnName = "id_season")
    @ManyToOne(optional = false)
    private Season idSeason;

    public RatingMapping() {
    }

    public RatingMapping(Integer idRating) {
        this.idRating = idRating;
    }

    public RatingMapping(Integer idRating, double rating) {
        this.idRating = idRating;
        this.rating = rating;
    }

    public Integer getIdRating() {
        return idRating;
    }

    public void setIdRating(Integer idRating) {
        this.idRating = idRating;
    }
    public java.lang.Integer getPrimaryKey(){ 
    return getIdRating(); 
  } 
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRating != null ? idRating.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RatingMapping)) {
            return false;
        }
        RatingMapping other = (RatingMapping) object;
        if ((this.idRating == null && other.idRating != null) || (this.idRating != null && !this.idRating.equals(other.idRating))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sust.classnotfound.touristfriend.entity.RatingMapping[ idRating=" + idRating + " ]";
    }
    
}
