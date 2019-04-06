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
@Table(name = "cookie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cookie.findAll", query = "SELECT c FROM Cookie c")
    , @NamedQuery(name = "Cookie.findByCookieId", query = "SELECT c FROM Cookie c WHERE c.cookieId = :cookieId")
    , @NamedQuery(name = "Cookie.findByCookieName", query = "SELECT c FROM Cookie c WHERE c.cookieName = :cookieName")
    , @NamedQuery(name = "Cookie.findByCookieDescription", query = "SELECT c FROM Cookie c WHERE c.cookieDescription = :cookieDescription")
    , @NamedQuery(name = "Cookie.findByCostPerPiece", query = "SELECT c FROM Cookie c WHERE c.costPerPiece = :costPerPiece")
    , @NamedQuery(name = "Cookie.findByCookieImage", query = "SELECT c FROM Cookie c WHERE c.cookieImage = :cookieImage")})
public class Cookie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cookie_id")
    private Integer cookieId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 145)
    @Column(name = "cookie_name")
    private String cookieName;
    @Size(max = 145)
    @Column(name = "cookie_description")
    private String cookieDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost_per_piece")
    private double costPerPiece;
    @Size(max = 445)
    @Column(name = "cookie_image")
    private String cookieImage;
    @JoinColumn(name = "cookie_type_id", referencedColumnName = "cookie_type_id")
    @ManyToOne(optional = false)
    private CookieType cookieTypeId;
    @JoinColumn(name = "treat_id", referencedColumnName = "treat_id")
    @ManyToOne(optional = false)
    private Treat treatId;

    public Cookie() {
    }

    public Cookie(Integer cookieId) {
        this.cookieId = cookieId;
    }

    public Cookie(Integer cookieId, String cookieName, double costPerPiece) {
        this.cookieId = cookieId;
        this.cookieName = cookieName;
        this.costPerPiece = costPerPiece;
    }

    public Integer getCookieId() {
        return cookieId;
    }

    public void setCookieId(Integer cookieId) {
        this.cookieId = cookieId;
    }

    public String getCookieName() {
        return cookieName;
    }

    public void setCookieName(String cookieName) {
        this.cookieName = cookieName;
    }

    public String getCookieDescription() {
        return cookieDescription;
    }

    public void setCookieDescription(String cookieDescription) {
        this.cookieDescription = cookieDescription;
    }

    public double getCostPerPiece() {
        return costPerPiece;
    }

    public void setCostPerPiece(double costPerPiece) {
        this.costPerPiece = costPerPiece;
    }

    public String getCookieImage() {
        return cookieImage;
    }

    public void setCookieImage(String cookieImage) {
        this.cookieImage = cookieImage;
    }

    public CookieType getCookieTypeId() {
        return cookieTypeId;
    }

    public void setCookieTypeId(CookieType cookieTypeId) {
        this.cookieTypeId = cookieTypeId;
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
        hash += (cookieId != null ? cookieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cookie)) {
            return false;
        }
        Cookie other = (Cookie) object;
        if ((this.cookieId == null && other.cookieId != null) || (this.cookieId != null && !this.cookieId.equals(other.cookieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "my.company.mc.pr.Cookie[ cookieId=" + cookieId + " ]";
    }
    
}
