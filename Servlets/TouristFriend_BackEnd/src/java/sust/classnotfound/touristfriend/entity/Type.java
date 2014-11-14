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
@Table(name = "type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Type.findAll", query = "SELECT t FROM Type t"),
    @NamedQuery(name = "Type.findByIdType", query = "SELECT t FROM Type t WHERE t.idType = :idType"),
    @NamedQuery(name = "Type.findByName", query = "SELECT t FROM Type t WHERE t.name = :name"),
    @NamedQuery(name = "Type.findByDescription", query = "SELECT t FROM Type t WHERE t.description = :description")})
public class Type implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_type")
    private Integer idType;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idType")
    private List<User> userList;

    public Type() {
    }

    public Type(Integer idType) {
        this.idType = idType;
    }

    public Type(Integer idType, String name) {
        this.idType = idType;
        this.name = name;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }
    public java.lang.Integer getPrimaryKey(){ 
    return getIdType(); 
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

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idType != null ? idType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Type)) {
            return false;
        }
        Type other = (Type) object;
        if ((this.idType == null && other.idType != null) || (this.idType != null && !this.idType.equals(other.idType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sust.classnotfound.touristfriend.entity.Type[ idType=" + idType + " ]";
    }
    
}
