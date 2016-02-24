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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Evegen
 */
@Entity
@Table(name = "creditCards")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CreditCards.findAll", query = "SELECT c FROM CreditCards c"),
    @NamedQuery(name = "CreditCards.findByCardID", query = "SELECT c FROM CreditCards c WHERE c.cardID = :cardID"),
    @NamedQuery(name = "CreditCards.findByPan", query = "SELECT c FROM CreditCards c WHERE c.pan = :pan"),
    @NamedQuery(name = "CreditCards.findBySecureCode", query = "SELECT c FROM CreditCards c WHERE c.secureCode = :secureCode"),
    @NamedQuery(name = "CreditCards.findByValidDate", query = "SELECT c FROM CreditCards c WHERE c.validDate = :validDate"),
    @NamedQuery(name = "CreditCards.findByStatus", query = "SELECT c FROM CreditCards c WHERE c.status = :status")})
public class CreditCards implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cardID")
    private Integer cardID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "PAN")
    private String pan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "secureCode")
    private int secureCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "validDate")
    @Temporal(TemporalType.DATE)
    private Date validDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "accountID", referencedColumnName = "accountID")
    @ManyToOne(optional = false)
    private BankAccount accountID;
    @JoinColumn(name = "clientID", referencedColumnName = "clientID")
    @ManyToOne(optional = false)
    private Client clientID;

    /**
     *
     */
    public CreditCards() {
    }

    /**
     *
     * @param cardID
     */
    public CreditCards(Integer cardID) {
        this.cardID = cardID;
    }

    /**
     *
     * @param cardID
     * @param pan
     * @param secureCode
     * @param validDate
     * @param status
     */
    public CreditCards(Integer cardID, String pan, int secureCode, Date validDate, String status) {
        this.cardID = cardID;
        this.pan = pan;
        this.secureCode = secureCode;
        this.validDate = validDate;
        this.status = status;
    }

    /**
     *
     * @return
     */
    public Integer getCardID() {
        return cardID;
    }

    /**
     *
     * @param cardID
     */
    public void setCardID(Integer cardID) {
        this.cardID = cardID;
    }

    /**
     *
     * @return
     */
    public String getPan() {
        return pan;
    }

    /**
     *
     * @param pan
     */
    public void setPan(String pan) {
        this.pan = pan;
    }

    /**
     *
     * @return
     */
    public int getSecureCode() {
        return secureCode;
    }

    /**
     *
     * @param secureCode
     */
    public void setSecureCode(int secureCode) {
        this.secureCode = secureCode;
    }

    /**
     *
     * @return
     */
    public Date getValidDate() {
        return validDate;
    }

    /**
     *
     * @param validDate
     */
    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    /**
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     */
    public BankAccount getAccountID() {
        return accountID;
    }

    /**
     *
     * @param accountID
     */
    public void setAccountID(BankAccount accountID) {
        this.accountID = accountID;
    }

    /**
     *
     * @return
     */
    public Client getClientID() {
        return clientID;
    }

    /**
     *
     * @param clientID
     */
    public void setClientID(Client clientID) {
        this.clientID = clientID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cardID != null ? cardID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditCards)) {
            return false;
        }
        CreditCards other = (CreditCards) object;
        if ((this.cardID == null && other.cardID != null) || (this.cardID != null && !this.cardID.equals(other.cardID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CreditCards[ cardID=" + cardID + " ]";
    }
    
}
