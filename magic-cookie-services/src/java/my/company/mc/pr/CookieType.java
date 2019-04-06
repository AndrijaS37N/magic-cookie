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
@Table(name = "cookie_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CookieType.findAll", query = "SELECT c FROM CookieType c")
    , @NamedQuery(name = "CookieType.findByCookieTypeId", query = "SELECT c FROM CookieType c WHERE c.cookieTypeId = :cookieTypeId")
    , @NamedQuery(name = "CookieType.findByCookieTypeName", query = "SELECT c FROM CookieType c WHERE c.cookieTypeName = :cookieTypeName")
    , @NamedQuery(name = "CookieType.findByCookieTypeDescription", query = "SELECT c FROM CookieType c WHERE c.cookieTypeDescription = :cookieTypeDescription")
    , @NamedQuery(name = "CookieType.findByNumberOfChips", query = "SELECT c FROM CookieType c WHERE c.numberOfChips = :numberOfChips")})
public class CookieType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cookie_type_id")
    private Integer cookieTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 245)
    @Column(name = "cookie_type_name")
    private String cookieTypeName;
    @Size(max = 245)
    @Column(name = "cookie_type_description")
    private String cookieTypeDescription;
    @Column(name = "number_of_chips")
    private Integer numberOfChips;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cookieTypeId")
    private Collection<Cookie> cookieCollection;

    public CookieType() {
    }

    public CookieType(Integer cookieTypeId) {
        this.cookieTypeId = cookieTypeId;
    }

    public CookieType(Integer cookieTypeId, String cookieTypeName) {
        this.cookieTypeId = cookieTypeId;
        this.cookieTypeName = cookieTypeName;
    }

    public Integer getCookieTypeId() {
        return cookieTypeId;
    }

    public void setCookieTypeId(Integer cookieTypeId) {
        this.cookieTypeId = cookieTypeId;
    }

    public String getCookieTypeName() {
        return cookieTypeName;
    }

    public void setCookieTypeName(String cookieTypeName) {
        this.cookieTypeName = cookieTypeName;
    }

    public String getCookieTypeDescription() {
        return cookieTypeDescription;
    }

    public void setCookieTypeDescription(String cookieTypeDescription) {
        this.cookieTypeDescription = cookieTypeDescription;
    }

    public Integer getNumberOfChips() {
        return numberOfChips;
    }

    public void setNumberOfChips(Integer numberOfChips) {
        this.numberOfChips = numberOfChips;
    }

    @XmlTransient
    public Collection<Cookie> getCookieCollection() {
        return cookieCollection;
    }

    public void setCookieCollection(Collection<Cookie> cookieCollection) {
        this.cookieCollection = cookieCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cookieTypeId != null ? cookieTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CookieType)) {
            return false;
        }
        CookieType other = (CookieType) object;
        if ((this.cookieTypeId == null && other.cookieTypeId != null) || (this.cookieTypeId != null && !this.cookieTypeId.equals(other.cookieTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "my.company.mc.pr.CookieType[ cookieTypeId=" + cookieTypeId + " ]";
    }
    
}
