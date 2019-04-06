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
@Table(name = "treat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Treat.findAll", query = "SELECT t FROM Treat t")
    , @NamedQuery(name = "Treat.findByTreatId", query = "SELECT t FROM Treat t WHERE t.treatId = :treatId")
    , @NamedQuery(name = "Treat.findByTreatName", query = "SELECT t FROM Treat t WHERE t.treatName = :treatName")
    , @NamedQuery(name = "Treat.findByTreatDescription", query = "SELECT t FROM Treat t WHERE t.treatDescription = :treatDescription")
    , @NamedQuery(name = "Treat.findByTreatImage", query = "SELECT t FROM Treat t WHERE t.treatImage = :treatImage")
    , @NamedQuery(name = "Treat.findByHowWasItMade", query = "SELECT t FROM Treat t WHERE t.howWasItMade = :howWasItMade")})
public class Treat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "treat_id")
    private Integer treatId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "treat_name")
    private String treatName;
    @Size(max = 445)
    @Column(name = "treat_description")
    private String treatDescription;
    @Size(max = 445)
    @Column(name = "treat_image")
    private String treatImage;
    @Size(max = 445)
    @Column(name = "how_was_it_made")
    private String howWasItMade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "treatId")
    private Collection<Cookie> cookieCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "treatId")
    private Collection<Waffle> waffleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "treatId")
    private Collection<Chocolate> chocolateCollection;

    public Treat() {
    }

    public Treat(Integer treatId) {
        this.treatId = treatId;
    }

    public Treat(Integer treatId, String treatName) {
        this.treatId = treatId;
        this.treatName = treatName;
    }

    public Integer getTreatId() {
        return treatId;
    }

    public void setTreatId(Integer treatId) {
        this.treatId = treatId;
    }

    public String getTreatName() {
        return treatName;
    }

    public void setTreatName(String treatName) {
        this.treatName = treatName;
    }

    public String getTreatDescription() {
        return treatDescription;
    }

    public void setTreatDescription(String treatDescription) {
        this.treatDescription = treatDescription;
    }

    public String getTreatImage() {
        return treatImage;
    }

    public void setTreatImage(String treatImage) {
        this.treatImage = treatImage;
    }

    public String getHowWasItMade() {
        return howWasItMade;
    }

    public void setHowWasItMade(String howWasItMade) {
        this.howWasItMade = howWasItMade;
    }

    @XmlTransient
    public Collection<Cookie> getCookieCollection() {
        return cookieCollection;
    }

    public void setCookieCollection(Collection<Cookie> cookieCollection) {
        this.cookieCollection = cookieCollection;
    }

    @XmlTransient
    public Collection<Waffle> getWaffleCollection() {
        return waffleCollection;
    }

    public void setWaffleCollection(Collection<Waffle> waffleCollection) {
        this.waffleCollection = waffleCollection;
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
        hash += (treatId != null ? treatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Treat)) {
            return false;
        }
        Treat other = (Treat) object;
        if ((this.treatId == null && other.treatId != null) || (this.treatId != null && !this.treatId.equals(other.treatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "my.company.mc.pr.Treat[ treatId=" + treatId + " ]";
    }
    
}
