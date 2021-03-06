/*
 * Copyright 2016 Evegen.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package model;

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
 * @author Evegen
 */
@Entity
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByClientID", query = "SELECT c FROM Client c WHERE c.clientID = :clientID"),
    @NamedQuery(name = "Client.findByNickName", query = "SELECT c FROM Client c WHERE c.nickName = :nickName"),
    @NamedQuery(name = "Client.findByFirstName", query = "SELECT c FROM Client c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "Client.findByLastName", query = "SELECT c FROM Client c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "Client.findByPhone", query = "SELECT c FROM Client c WHERE c.phone = :phone"),
    @NamedQuery(name = "Client.findByEmail", query = "SELECT c FROM Client c WHERE c.email = :email")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "clientID")
    private Integer clientID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NickName")
    private String nickName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FirstName")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LastName")
    private String lastName;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Недопустимый формат номера телефона/факса (должен иметь формат xxx-xxx-xxxx)")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "Phone")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Недопустимый адрес электронной почты")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 10)
    @Column(name = "Email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientID")
    private Collection<BankAccount> bankAccountCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientID")
    private Collection<CreditCards> creditCardsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientID")
    private Collection<PaymentsHistory> paymentsHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "beneficiarClienstID")
    private Collection<PaymentsHistory> paymentsHistoryCollection1;

    /**
     *
     */
    public Client() {
    }

    /**
     *
     * @param clientID
     */
    public Client(Integer clientID) {
        this.clientID = clientID;
    }

    /**
     *
     * @param clientID
     * @param nickName
     * @param firstName
     * @param lastName
     */
    public Client(Integer clientID, String nickName, String firstName, String lastName) {
        this.clientID = clientID;
        this.nickName = nickName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    public Integer getClientID() {
        return clientID;
    }

    /**
     *
     * @param clientID
     */
    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    /**
     *
     * @return
     */
    public String getNickName() {
        return nickName;
    }

    /**
     *
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public Collection<BankAccount> getBankAccountCollection() {
        return bankAccountCollection;
    }

    /**
     *
     * @param bankAccountCollection
     */
    public void setBankAccountCollection(Collection<BankAccount> bankAccountCollection) {
        this.bankAccountCollection = bankAccountCollection;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public Collection<CreditCards> getCreditCardsCollection() {
        return creditCardsCollection;
    }

    /**
     *
     * @param creditCardsCollection
     */
    public void setCreditCardsCollection(Collection<CreditCards> creditCardsCollection) {
        this.creditCardsCollection = creditCardsCollection;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public Collection<PaymentsHistory> getPaymentsHistoryCollection() {
        return paymentsHistoryCollection;
    }

    /**
     *
     * @param paymentsHistoryCollection
     */
    public void setPaymentsHistoryCollection(Collection<PaymentsHistory> paymentsHistoryCollection) {
        this.paymentsHistoryCollection = paymentsHistoryCollection;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public Collection<PaymentsHistory> getPaymentsHistoryCollection1() {
        return paymentsHistoryCollection1;
    }

    /**
     *
     * @param paymentsHistoryCollection1
     */
    public void setPaymentsHistoryCollection1(Collection<PaymentsHistory> paymentsHistoryCollection1) {
        this.paymentsHistoryCollection1 = paymentsHistoryCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientID != null ? clientID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.clientID == null && other.clientID != null) || (this.clientID != null && !this.clientID.equals(other.clientID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Client[ clientID=" + clientID + " ]";
    }
    
}
