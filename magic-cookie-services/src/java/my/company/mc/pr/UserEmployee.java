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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andrijadjuric
 */
@Entity
@Table(name = "user_employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserEmployee.findAll", query = "SELECT u FROM UserEmployee u")
    , @NamedQuery(name = "UserEmployee.findByEmployeeNumber", query = "SELECT u FROM UserEmployee u WHERE u.employeeNumber = :employeeNumber")
    , @NamedQuery(name = "UserEmployee.findByEmployeeDescription", query = "SELECT u FROM UserEmployee u WHERE u.employeeDescription = :employeeDescription")})
public class UserEmployee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "employee_number")
    private Integer employeeNumber;
    @Size(max = 445)
    @Column(name = "employee_description")
    private String employeeDescription;
    @JoinColumn(name = "bakery_id", referencedColumnName = "bakery_id")
    @ManyToOne(optional = false)
    private Bakery bakeryId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public UserEmployee() {
    }

    public UserEmployee(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeDescription() {
        return employeeDescription;
    }

    public void setEmployeeDescription(String employeeDescription) {
        this.employeeDescription = employeeDescription;
    }

    public Bakery getBakeryId() {
        return bakeryId;
    }

    public void setBakeryId(Bakery bakeryId) {
        this.bakeryId = bakeryId;
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
        hash += (employeeNumber != null ? employeeNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserEmployee)) {
            return false;
        }
        UserEmployee other = (UserEmployee) object;
        if ((this.employeeNumber == null && other.employeeNumber != null) || (this.employeeNumber != null && !this.employeeNumber.equals(other.employeeNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "my.company.mc.pr.UserEmployee[ employeeNumber=" + employeeNumber + " ]";
    }
    
}
