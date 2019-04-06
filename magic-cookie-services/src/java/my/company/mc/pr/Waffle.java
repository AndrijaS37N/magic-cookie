/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.company.mc.pr;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andrijadjuric
 */
@Entity
@Table(name = "waffle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Waffle.findAll", query = "SELECT w FROM Waffle w")
    , @NamedQuery(name = "Waffle.findByWaffleId", query = "SELECT w FROM Waffle w WHERE w.waffleId = :waffleId")
    , @NamedQuery(name = "Waffle.findByWaffleName", query = "SELECT w FROM Waffle w WHERE w.waffleName = :waffleName")
    , @NamedQuery(name = "Waffle.findByWaffleStuffing", query = "SELECT w FROM Waffle w WHERE w.waffleStuffing = :waffleStuffing")
    , @NamedQuery(name = "Waffle.findByWaffleDescription", query = "SELECT w FROM Waffle w WHERE w.waffleDescription = :waffleDescription")
    , @NamedQuery(name = "Waffle.findByCostPerPortion", query = "SELECT w FROM Waffle w WHERE w.costPerPortion = :costPerPortion")
    , @NamedQuery(name = "Waffle.findByWaffleImage", query = "SELECT w FROM Waffle w WHERE w.waffleImage = :waffleImage")})
public class Waffle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "waffle_id")
    private Integer waffleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 145)
    @Column(name = "waffle_name")
    private String waffleName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "waffle_stuffing")
    private boolean waffleStuffing;
    @Size(max = 245)
    @Column(name = "waffle_description")
    private String waffleDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost_per_portion")
    private double costPerPortion;
    @Size(max = 445)
    @Column(name = "waffle_image")
    private String waffleImage;
    @JoinColumn(name = "treat_id", referencedColumnName = "treat_id")
    @ManyToOne(optional = false)
    private Treat treatId;
    @JoinColumn(name = "waffle_type_id", referencedColumnName = "waffle_type_id")
    @ManyToOne(optional = false)
    private WaffleType waffleTypeId;

    public Waffle() {
    }

    public Waffle(Integer waffleId) {
        this.waffleId = waffleId;
    }

    public Waffle(Integer waffleId, String waffleName, boolean waffleStuffing, double costPerPortion) {
        this.waffleId = waffleId;
        this.waffleName = waffleName;
        this.waffleStuffing = waffleStuffing;
        this.costPerPortion = costPerPortion;
    }

    public Integer getWaffleId() {
        return waffleId;
    }

    public void setWaffleId(Integer waffleId) {
        this.waffleId = waffleId;
    }

    public String getWaffleName() {
        return waffleName;
    }

    public void setWaffleName(String waffleName) {
        this.waffleName = waffleName;
    }

    public boolean getWaffleStuffing() {
        return waffleStuffing;
    }

    public void setWaffleStuffing(boolean waffleStuffing) {
        this.waffleStuffing = waffleStuffing;
    }

    public String getWaffleDescription() {
        return waffleDescription;
    }

    public void setWaffleDescription(String waffleDescription) {
        this.waffleDescription = waffleDescription;
    }

    public double getCostPerPortion() {
        return costPerPortion;
    }

    public void setCostPerPortion(double costPerPortion) {
        this.costPerPortion = costPerPortion;
    }

    public String getWaffleImage() {
        return waffleImage;
    }

    public void setWaffleImage(String waffleImage) {
        this.waffleImage = waffleImage;
    }

    public Treat getTreatId() {
        return treatId;
    }

    public void setTreatId(Treat treatId) {
        this.treatId = treatId;
    }

    public WaffleType getWaffleTypeId() {
        return waffleTypeId;
    }

    public void setWaffleTypeId(WaffleType waffleTypeId) {
        this.waffleTypeId = waffleTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (waffleId != null ? waffleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Waffle)) {
            return false;
        }
        Waffle other = (Waffle) object;
        if ((this.waffleId == null && other.waffleId != null) || (this.waffleId != null && !this.waffleId.equals(other.waffleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "my.company.mc.pr.Waffle[ waffleId=" + waffleId + " ]";
    }
    
}
