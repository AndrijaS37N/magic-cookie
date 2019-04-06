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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "bakery_city")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BakeryCity.findAll", query = "SELECT b FROM BakeryCity b")
    , @NamedQuery(name = "BakeryCity.findByBakeryCityId", query = "SELECT b FROM BakeryCity b WHERE b.bakeryCityId = :bakeryCityId")
    , @NamedQuery(name = "BakeryCity.findByCityName", query = "SELECT b FROM BakeryCity b WHERE b.cityName = :cityName")})
public class BakeryCity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bakery_city_id")
    private Integer bakeryCityId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 145)
    @Column(name = "city_name")
    private String cityName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bakeryCityId")
    private Collection<Bakery> bakeryCollection;
    @JoinColumn(name = "bakery_country_id", referencedColumnName = "bakery_country_id")
    @ManyToOne(optional = false)
    private BakeryCountry bakeryCountryId;

    public BakeryCity() {
    }

    public BakeryCity(Integer bakeryCityId) {
        this.bakeryCityId = bakeryCityId;
    }

    public BakeryCity(Integer bakeryCityId, String cityName) {
        this.bakeryCityId = bakeryCityId;
        this.cityName = cityName;
    }

    public Integer getBakeryCityId() {
        return bakeryCityId;
    }

    public void setBakeryCityId(Integer bakeryCityId) {
        this.bakeryCityId = bakeryCityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @XmlTransient
    public Collection<Bakery> getBakeryCollection() {
        return bakeryCollection;
    }

    public void setBakeryCollection(Collection<Bakery> bakeryCollection) {
        this.bakeryCollection = bakeryCollection;
    }

    public BakeryCountry getBakeryCountryId() {
        return bakeryCountryId;
    }

    public void setBakeryCountryId(BakeryCountry bakeryCountryId) {
        this.bakeryCountryId = bakeryCountryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bakeryCityId != null ? bakeryCityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BakeryCity)) {
            return false;
        }
        BakeryCity other = (BakeryCity) object;
        if ((this.bakeryCityId == null && other.bakeryCityId != null) || (this.bakeryCityId != null && !this.bakeryCityId.equals(other.bakeryCityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "my.company.mc.pr.BakeryCity[ bakeryCityId=" + bakeryCityId + " ]";
    }
    
}
