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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andrijadjuric
 */
@Entity
@Table(name = "user_admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserAdmin.findAll", query = "SELECT u FROM UserAdmin u")
    , @NamedQuery(name = "UserAdmin.findByAdminNumber", query = "SELECT u FROM UserAdmin u WHERE u.adminNumber = :adminNumber")})
public class UserAdmin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "admin_number")
    private Integer adminNumber;
    @JoinColumn(name = "responsibility_category_id", referencedColumnName = "responsibility_category_id")
    @ManyToOne(optional = false)
    private ResponsibilityCategory responsibilityCategoryId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public UserAdmin() {
    }

    public UserAdmin(Integer adminNumber) {
        this.adminNumber = adminNumber;
    }

    public Integer getAdminNumber() {
        return adminNumber;
    }

    public void setAdminNumber(Integer adminNumber) {
        this.adminNumber = adminNumber;
    }

    public ResponsibilityCategory getResponsibilityCategoryId() {
        return responsibilityCategoryId;
    }

    public void setResponsibilityCategoryId(ResponsibilityCategory responsibilityCategoryId) {
        this.responsibilityCategoryId = responsibilityCategoryId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminNumber != null ? adminNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAdmin)) {
            return false;
        }
        UserAdmin other = (UserAdmin) object;
        if ((this.adminNumber == null && other.adminNumber != null) || (this.adminNumber != null && !this.adminNumber.equals(other.adminNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "my.company.mc.pr.UserAdmin[ adminNumber=" + adminNumber + " ]";
    }
    
}
