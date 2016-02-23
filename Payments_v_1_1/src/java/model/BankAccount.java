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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Evegen
 */
@Entity
@Table(name = "bankAccount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BankAccount.findAll", query = "SELECT b FROM BankAccount b"),
    @NamedQuery(name = "BankAccount.findByAccountID", query = "SELECT b FROM BankAccount b WHERE b.accountID = :accountID"),
    @NamedQuery(name = "BankAccount.findByCurrentBalance", query = "SELECT b FROM BankAccount b WHERE b.currentBalance = :currentBalance")})
public class BankAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "accountID")
    private Integer accountID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "currentBalance")
    private double currentBalance;
    @JoinColumn(name = "clientID", referencedColumnName = "clientID")
    @ManyToOne(optional = false)
    private Client clientID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountID")
    private Collection<CreditCards> creditCardsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientAccountID")
    private Collection<PaymentsHistory> paymentsHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "beneficiarAccountID")
    private Collection<PaymentsHistory> paymentsHistoryCollection1;

    public BankAccount() {
    }

    public BankAccount(Integer accountID) {
        this.accountID = accountID;
    }

    public BankAccount(Integer accountID, double currentBalance) {
        this.accountID = accountID;
        this.currentBalance = currentBalance;
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Client getClientID() {
        return clientID;
    }

    public void setClientID(Client clientID) {
        this.clientID = clientID;
    }

    @XmlTransient
    public Collection<CreditCards> getCreditCardsCollection() {
        return creditCardsCollection;
    }

    public void setCreditCardsCollection(Collection<CreditCards> creditCardsCollection) {
        this.creditCardsCollection = creditCardsCollection;
    }

    @XmlTransient
    public Collection<PaymentsHistory> getPaymentsHistoryCollection() {
        return paymentsHistoryCollection;
    }

    public void setPaymentsHistoryCollection(Collection<PaymentsHistory> paymentsHistoryCollection) {
        this.paymentsHistoryCollection = paymentsHistoryCollection;
    }

    @XmlTransient
    public Collection<PaymentsHistory> getPaymentsHistoryCollection1() {
        return paymentsHistoryCollection1;
    }

    public void setPaymentsHistoryCollection1(Collection<PaymentsHistory> paymentsHistoryCollection1) {
        this.paymentsHistoryCollection1 = paymentsHistoryCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountID != null ? accountID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BankAccount)) {
            return false;
        }
        BankAccount other = (BankAccount) object;
        if ((this.accountID == null && other.accountID != null) || (this.accountID != null && !this.accountID.equals(other.accountID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.BankAccount[ accountID=" + accountID + " ]";
    }
    
}
