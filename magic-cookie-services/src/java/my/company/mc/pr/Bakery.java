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
@Table(name = "bakery")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bakery.findAll", query = "SELECT b FROM Bakery b")
    , @NamedQuery(name = "Bakery.findByBakeryId", query = "SELECT b FROM Bakery b WHERE b.bakeryId = :bakeryId")
    , @NamedQuery(name = "Bakery.findByBakeryDescription", query = "SELECT b FROM Bakery b WHERE b.bakeryDescription = :bakeryDescription")
    , @NamedQuery(name = "Bakery.findByBakeryAddress", query = "SELECT b FROM Bakery b WHERE b.bakeryAddress = :bakeryAddress")
    , @NamedQuery(name = "Bakery.findBySquareMeters", query = "SELECT b FROM Bakery b WHERE b.squareMeters = :squareMeters")
    , @NamedQuery(name = "Bakery.findByTables", query = "SELECT b FROM Bakery b WHERE b.tables = :tables")
    , @NamedQuery(name = "Bakery.findByStartsWorking", query = "SELECT b FROM Bakery b WHERE b.startsWorking = :startsWorking")
    , @NamedQuery(name = "Bakery.findByEndsWorking", query = "SELECT b FROM Bakery b WHERE b.endsWorking = :endsWorking")
    , @NamedQuery(name = "Bakery.findByBakeryPhone", query = "SELECT b FROM Bakery b WHERE b.bakeryPhone = :bakeryPhone")
    , @NamedQuery(name = "Bakery.findByBakeryTwitter", query = "SELECT b FROM Bakery b WHERE b.bakeryTwitter = :bakeryTwitter")})
public class Bakery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bakery_id")
    private Integer bakeryId;
    @Size(max = 45)
    @Column(name = "bakery_description")
    private String bakeryDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "bakery_address")
    private String bakeryAddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "square_meters")
    private double squareMeters;
    @Column(name = "tables")
    private Integer tables;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "starts_working")
    private String startsWorking;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ends_working")
    private String endsWorking;
    @Size(max = 45)
    @Column(name = "bakery_phone")
    private String bakeryPhone;
    @Size(max = 45)
    @Column(name = "bakery_twitter")
    private String bakeryTwitter;
    @JoinColumn(name = "bakery_city_id", referencedColumnName = "bakery_city_id")
    @ManyToOne(optional = false)
    private BakeryCity bakeryCityId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bakeryId")
    private Collection<UserEmployee> userEmployeeCollection;

    public Bakery() {
    }

    public Bakery(Integer bakeryId) {
        this.bakeryId = bakeryId;
    }

    public Bakery(Integer bakeryId, String bakeryAddress, double squareMeters, String startsWorking, String endsWorking) {
        this.bakeryId = bakeryId;
        this.bakeryAddress = bakeryAddress;
        this.squareMeters = squareMeters;
        this.startsWorking = startsWorking;
        this.endsWorking = endsWorking;
    }

    public Integer getBakeryId() {
        return bakeryId;
    }

    public void setBakeryId(Integer bakeryId) {
        this.bakeryId = bakeryId;
    }

    public String getBakeryDescription() {
        return bakeryDescription;
    }

    public void setBakeryDescription(String bakeryDescription) {
        this.bakeryDescription = bakeryDescription;
    }

    public String getBakeryAddress() {
        return bakeryAddress;
    }

    public void setBakeryAddress(String bakeryAddress) {
        this.bakeryAddress = bakeryAddress;
    }

    public double getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(double squareMeters) {
        this.squareMeters = squareMeters;
    }

    public Integer getTables() {
        return tables;
    }

    public void setTables(Integer tables) {
        this.tables = tables;
    }

    public String getStartsWorking() {
        return startsWorking;
    }

    public void setStartsWorking(String startsWorking) {
        this.startsWorking = startsWorking;
    }

    public String getEndsWorking() {
        return endsWorking;
    }

    public void setEndsWorking(String endsWorking) {
        this.endsWorking = endsWorking;
    }

    public String getBakeryPhone() {
        return bakeryPhone;
    }

    public void setBakeryPhone(String bakeryPhone) {
        this.bakeryPhone = bakeryPhone;
    }

    public String getBakeryTwitter() {
        return bakeryTwitter;
    }

    public void setBakeryTwitter(String bakeryTwitter) {
        this.bakeryTwitter = bakeryTwitter;
    }

    public BakeryCity getBakeryCityId() {
        return bakeryCityId;
    }

    public void setBakeryCityId(BakeryCity bakeryCityId) {
        this.bakeryCityId = bakeryCityId;
    }

    @XmlTransient
    public Collection<UserEmployee> getUserEmployeeCollection() {
        return userEmployeeCollection;
    }

    public void setUserEmployeeCollection(Collection<UserEmployee> userEmployeeCollection) {
        this.userEmployeeCollection = userEmployeeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bakeryId != null ? bakeryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bakery)) {
            return false;
        }
        Bakery other = (Bakery) object;
        if ((this.bakeryId == null && other.bakeryId != null) || (this.bakeryId != null && !this.bakeryId.equals(other.bakeryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "my.company.mc.pr.Bakery[ bakeryId=" + bakeryId + " ]";
    }
    
}
