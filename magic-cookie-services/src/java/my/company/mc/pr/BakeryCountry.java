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
@Table(name = "bakery_country")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BakeryCountry.findAll", query = "SELECT b FROM BakeryCountry b")
    , @NamedQuery(name = "BakeryCountry.findByBakeryCountryId", query = "SELECT b FROM BakeryCountry b WHERE b.bakeryCountryId = :bakeryCountryId")
    , @NamedQuery(name = "BakeryCountry.findByCountryName", query = "SELECT b FROM BakeryCountry b WHERE b.countryName = :countryName")})
public class BakeryCountry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bakery_country_id")
    private Integer bakeryCountryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 245)
    @Column(name = "country_name")
    private String countryName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bakeryCountryId")
    private Collection<BakeryCity> bakeryCityCollection;

    public BakeryCountry() {
    }

    public BakeryCountry(Integer bakeryCountryId) {
        this.bakeryCountryId = bakeryCountryId;
    }

    public BakeryCountry(Integer bakeryCountryId, String countryName) {
        this.bakeryCountryId = bakeryCountryId;
        this.countryName = countryName;
    }

    public Integer getBakeryCountryId() {
        return bakeryCountryId;
    }

    public void setBakeryCountryId(Integer bakeryCountryId) {
        this.bakeryCountryId = bakeryCountryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @XmlTransient
    public Collection<BakeryCity> getBakeryCityCollection() {
        return bakeryCityCollection;
    }

    public void setBakeryCityCollection(Collection<BakeryCity> bakeryCityCollection) {
        this.bakeryCityCollection = bakeryCityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bakeryCountryId != null ? bakeryCountryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BakeryCountry)) {
            return false;
        }
        BakeryCountry other = (BakeryCountry) object;
        if ((this.bakeryCountryId == null && other.bakeryCountryId != null) || (this.bakeryCountryId != null && !this.bakeryCountryId.equals(other.bakeryCountryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "my.company.mc.pr.BakeryCountry[ bakeryCountryId=" + bakeryCountryId + " ]";
    }
    
}
