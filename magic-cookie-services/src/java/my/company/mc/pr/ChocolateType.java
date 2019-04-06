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
@Table(name = "chocolate_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChocolateType.findAll", query = "SELECT c FROM ChocolateType c")
    , @NamedQuery(name = "ChocolateType.findByChocolateTypeId", query = "SELECT c FROM ChocolateType c WHERE c.chocolateTypeId = :chocolateTypeId")
    , @NamedQuery(name = "ChocolateType.findByChocolateTypeName", query = "SELECT c FROM ChocolateType c WHERE c.chocolateTypeName = :chocolateTypeName")})
public class ChocolateType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "chocolate_type_id")
    private Integer chocolateTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 145)
    @Column(name = "chocolate_type_name")
    private String chocolateTypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chocolateTypeId")
    private Collection<Chocolate> chocolateCollection;

    public ChocolateType() {
    }

    public ChocolateType(Integer chocolateTypeId) {
        this.chocolateTypeId = chocolateTypeId;
    }

    public ChocolateType(Integer chocolateTypeId, String chocolateTypeName) {
        this.chocolateTypeId = chocolateTypeId;
        this.chocolateTypeName = chocolateTypeName;
    }

    public Integer getChocolateTypeId() {
        return chocolateTypeId;
    }

    public void setChocolateTypeId(Integer chocolateTypeId) {
        this.chocolateTypeId = chocolateTypeId;
    }

    public String getChocolateTypeName() {
        return chocolateTypeName;
    }

    public void setChocolateTypeName(String chocolateTypeName) {
        this.chocolateTypeName = chocolateTypeName;
    }

    @XmlTransient
    public Collection<Chocolate> getChocolateCollection() {
        return chocolateCollection;
    }

    public void setChocolateCollection(Collection<Chocolate> chocolateCollection) {
        this.chocolateCollection = chocolateCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chocolateTypeId != null ? chocolateTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChocolateType)) {
            return false;
        }
        ChocolateType other = (ChocolateType) object;
        if ((this.chocolateTypeId == null && other.chocolateTypeId != null) || (this.chocolateTypeId != null && !this.chocolateTypeId.equals(other.chocolateTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "my.company.mc.pr.ChocolateType[ chocolateTypeId=" + chocolateTypeId + " ]";
    }
    
}
