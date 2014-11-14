/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sust.classnotfound.touristfriend.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rownak
 */
@Entity
@Table(name = "season")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Season.findAll", query = "SELECT s FROM Season s"),
    @NamedQuery(name = "Season.findByIdSeason", query = "SELECT s FROM Season s WHERE s.idSeason = :idSeason"),
    @NamedQuery(name = "Season.findByName", query = "SELECT s FROM Season s WHERE s.name = :name"),
    @NamedQuery(name = "Season.findByDescription", query = "SELECT s FROM Season s WHERE s.description = :description"),
    @NamedQuery(name = "Season.findByStartingDate", query = "SELECT s FROM Season s WHERE s.startingDate = :startingDate"),
    @NamedQuery(name = "Season.findByEndingDate", query = "SELECT s FROM Season s WHERE s.endingDate = :endingDate")})
public class Season implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_season")
    private Integer idSeason;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "starting_date")
    @Temporal(TemporalType.DATE)
    private Date startingDate;
    @Basic(optional = false)
    @Column(name = "ending_date")
    @Temporal(TemporalType.DATE)
    private Date endingDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSeason")
    private List<RatingMapping> ratingMappingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSeason")
    private List<Photos> photosList;

    public Season() {
    }

    public Season(Integer idSeason) {
        this.idSeason = idSeason;
    }

    public Season(Integer idSeason, String name, Date startingDate, Date endingDate) {
        this.idSeason = idSeason;
        this.name = name;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
    }

    public Integer getIdSeason() {
        return idSeason;
    }

    public void setIdSeason(Integer idSeason) {
        this.idSeason = idSeason;
    }
    public java.lang.Integer getPrimaryKey(){ 
    return getIdSeason(); 
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

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    @XmlTransient
    public List<RatingMapping> getRatingMappingList() {
        return ratingMappingList;
    }

    public void setRatingMappingList(List<RatingMapping> ratingMappingList) {
        this.ratingMappingList = ratingMappingList;
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
        hash += (idSeason != null ? idSeason.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Season)) {
            return false;
        }
        Season other = (Season) object;
        if ((this.idSeason == null && other.idSeason != null) || (this.idSeason != null && !this.idSeason.equals(other.idSeason))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sust.classnotfound.touristfriend.entity.Season[ idSeason=" + idSeason + " ]";
    }
    
}
