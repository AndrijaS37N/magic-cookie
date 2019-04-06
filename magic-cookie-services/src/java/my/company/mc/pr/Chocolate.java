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
@Table(name = "chocolate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chocolate.findAll", query = "SELECT c FROM Chocolate c")
    , @NamedQuery(name = "Chocolate.findByChocolateId", query = "SELECT c FROM Chocolate c WHERE c.chocolateId = :chocolateId")
    , @NamedQuery(name = "Chocolate.findByChocolateName", query = "SELECT c FROM Chocolate c WHERE c.chocolateName = :chocolateName")
    , @NamedQuery(name = "Chocolate.findByChocolateDescription", query = "SELECT c FROM Chocolate c WHERE c.chocolateDescription = :chocolateDescription")
    , @NamedQuery(name = "Chocolate.findByCostPerBlock", query = "SELECT c FROM Chocolate c WHERE c.costPerBlock = :costPerBlock")
    , @NamedQuery(name = "Chocolate.findByChocolateImage", query = "SELECT c FROM Chocolate c WHERE c.chocolateImage = :chocolateImage")})
public class Chocolate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "chocolate_id")
    private Integer chocolateId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 145)
    @Column(name = "chocolate_name")
    private String chocolateName;
    @Size(max = 145)
    @Column(name = "chocolate_description")
    private String chocolateDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost_per_block")
    private double costPerBlock;
    @Size(max = 445)
    @Column(name = "chocolate_image")
    private String chocolateImage;
    @JoinColumn(name = "chocolate_type_id", referencedColumnName = "chocolate_type_id")
    @ManyToOne(optional = false)
    private ChocolateType chocolateTypeId;
    @JoinColumn(name = "treat_id", referencedColumnName = "treat_id")
    @ManyToOne(optional = false)
    private Treat treatId;

    public Chocolate() {
    }

    public Chocolate(Integer chocolateId) {
        this.chocolateId = chocolateId;
    }

    public Chocolate(Integer chocolateId, String chocolateName, double costPerBlock) {
        this.chocolateId = chocolateId;
        this.chocolateName = chocolateName;
        this.costPerBlock = costPerBlock;
    }

    public Integer getChocolateId() {
        return chocolateId;
    }

    public void setChocolateId(Integer chocolateId) {
        this.chocolateId = chocolateId;
    }

    public String getChocolateName() {
        return chocolateName;
    }

    public void setChocolateName(String chocolateName) {
        this.chocolateName = chocolateName;
    }

    public String getChocolateDescription() {
        return chocolateDescription;
    }

    public void setChocolateDescription(String chocolateDescription) {
        this.chocolateDescription = chocolateDescription;
    }

    public double getCostPerBlock() {
        return costPerBlock;
    }

    public void setCostPerBlock(double costPerBlock) {
        this.costPerBlock = costPerBlock;
    }

    public String getChocolateImage() {
        return chocolateImage;
    }

    public void setChocolateImage(String chocolateImage) {
        this.chocolateImage = chocolateImage;
    }

    public ChocolateType getChocolateTypeId() {
        return chocolateTypeId;
    }

    public void setChocolateTypeId(ChocolateType chocolateTypeId) {
        this.chocolateTypeId = chocolateTypeId;
    }

    public Treat getTreatId() {
        return treatId;
    }

    public void setTreatId(Treat treatId) {
        this.treatId = treatId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chocolateId != null ? chocolateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chocolate)) {
            return false;
        }
        Chocolate other = (Chocolate) object;
        if ((this.chocolateId == null && other.chocolateId != null) || (this.chocolateId != null && !this.chocolateId.equals(other.chocolateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "my.company.mc.pr.Chocolate[ chocolateId=" + chocolateId + " ]";
    }
    
}
