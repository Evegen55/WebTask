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
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
    @NamedQuery(name = "CreditCards.findByUserID", query = "SELECT c FROM CreditCards c WHERE c.userID = :userID"),
    @NamedQuery(name = "CreditCards.findByPan", query = "SELECT c FROM CreditCards c WHERE c.pan = :pan"),
    @NamedQuery(name = "CreditCards.findByCardSecCode", query = "SELECT c FROM CreditCards c WHERE c.cardSecCode = :cardSecCode"),
    @NamedQuery(name = "CreditCards.findByStatus", query = "SELECT c FROM CreditCards c WHERE c.status = :status"),
    @NamedQuery(name = "CreditCards.findByValidDate", query = "SELECT c FROM CreditCards c WHERE c.validDate = :validDate")})
public class CreditCards implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cardID")
    private String cardID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "userID")
    private String userID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "PAN")
    private String pan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "card_sec_code")
    private String cardSecCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "valid_date")
    private String validDate;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "creditCards1")
    private CreditCards creditCards;
    @JoinColumn(name = "cardID", referencedColumnName = "cardID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private CreditCards creditCards1;

    public CreditCards() {
    }

    public CreditCards(String cardID) {
        this.cardID = cardID;
    }

    public CreditCards(String cardID, String userID, String pan, String cardSecCode, String status, String validDate) {
        this.cardID = cardID;
        this.userID = userID;
        this.pan = pan;
        this.cardSecCode = cardSecCode;
        this.status = status;
        this.validDate = validDate;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getCardSecCode() {
        return cardSecCode;
    }

    public void setCardSecCode(String cardSecCode) {
        this.cardSecCode = cardSecCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    public CreditCards getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(CreditCards creditCards) {
        this.creditCards = creditCards;
    }

    public CreditCards getCreditCards1() {
        return creditCards1;
    }

    public void setCreditCards1(CreditCards creditCards1) {
        this.creditCards1 = creditCards1;
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
