/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.company.mc.pr;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andrijadjuric
 */
@Entity
@Table(name = "waffle_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WaffleType.findAll", query = "SELECT w FROM WaffleType w")
    , @NamedQuery(name = "WaffleType.findByWaffleTypeId", query = "SELECT w FROM WaffleType w WHERE w.waffleTypeId = :waffleTypeId")
    , @NamedQuery(name = "WaffleType.findByWaffleTypeName", query = "SELECT w FROM WaffleType w WHERE w.waffleTypeName = :waffleTypeName")
    , @NamedQuery(name = "WaffleType.findByWaffleTypeDescription", query = "SELECT w FROM WaffleType w WHERE w.waffleTypeDescription = :waffleTypeDescription")})
public class WaffleType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "waffle_type_id")
    private Integer waffleTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 145)
    @Column(name = "waffle_type_name")
    private String waffleTypeName;
    @Size(max = 245)
    @Column(name = "waffle_type_description")
    private String waffleTypeDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "waffleTypeId")
    private Collection<Waffle> waffleCollection;

    public WaffleType() {
    }

    public WaffleType(Integer waffleTypeId) {
        this.waffleTypeId = waffleTypeId;
    }

    public WaffleType(Integer waffleTypeId, String waffleTypeName) {
        this.waffleTypeId = waffleTypeId;
        this.waffleTypeName = waffleTypeName;
    }

    public Integer getWaffleTypeId() {
        return waffleTypeId;
    }

    public void setWaffleTypeId(Integer waffleTypeId) {
        this.waffleTypeId = waffleTypeId;
    }

    public String getWaffleTypeName() {
        return waffleTypeName;
    }

    public void setWaffleTypeName(String waffleTypeName) {
        this.waffleTypeName = waffleTypeName;
    }

    public String getWaffleTypeDescription() {
        return waffleTypeDescription;
    }

    public void setWaffleTypeDescription(String waffleTypeDescription) {
        this.waffleTypeDescription = waffleTypeDescription;
    }

    @XmlTransient
    public Collection<Waffle> getWaffleCollection() {
        return waffleCollection;
    }

    public void setWaffleCollection(Collection<Waffle> waffleCollection) {
        this.waffleCollection = waffleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (waffleTypeId != null ? waffleTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WaffleType)) {
            return false;
        }
        WaffleType other = (WaffleType) object;
        if ((this.waffleTypeId == null && other.waffleTypeId != null) || (this.waffleTypeId != null && !this.waffleTypeId.equals(other.waffleTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "my.company.mc.pr.WaffleType[ waffleTypeId=" + waffleTypeId + " ]";
    }
    
}
