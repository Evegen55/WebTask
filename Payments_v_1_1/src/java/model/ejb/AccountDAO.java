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
package model.ejb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.BankAccount;
import model.Client;
import model.PaymentsHistory;

/**
 *
 * @author Evegen
 */
@Stateless
public class AccountDAO {
    
    @PersistenceContext private EntityManager em;

    /**
     *
     * @return
     */
    public List getAllAccounts() {
        return em.createNamedQuery("BankAccount.findAll").getResultList();
    }
    
    /**
     *
     * @param id
     * @return
     */
    public List getAllAccountsByClientID(int id) {
        Client client = em.find(Client.class, id);
        Collection col = client.getBankAccountCollection();
        List list;
        if(col instanceof List) {
        list = (List)col;
        } else {
        list= new ArrayList(col);
        }
        return list;
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public BankAccount getAccountByID_asSingleAccount(int id){
        List resultList = em.createNamedQuery("BankAccount.findByAccountID")
                .setParameter("accountID", id)
                .getResultList();
        BankAccount account = new BankAccount();
        if (resultList.size()>0) {
            account = (BankAccount) resultList.get(0);
        }
        return account;
    }

    /**
     *
     * @param bankAccount
     */
    public void addMoney(BankAccount bankAccount) {
        BankAccount old_bankAccount = getAccountByID_asSingleAccount(bankAccount.getAccountID());
        double old_amount = old_bankAccount.getCurrentBalance();
        double new_amount = bankAccount.getCurrentBalance();
        bankAccount.setCurrentBalance(old_amount+new_amount);
        em.merge(bankAccount);
    }
    
    /**
     * 
     * @param bankAccount 
     */
    public void substractionMoney(BankAccount bankAccount) {
        BankAccount old_bankAccount = getAccountByID_asSingleAccount(bankAccount.getAccountID());
        double old_amount = old_bankAccount.getCurrentBalance();
        double new_amount = bankAccount.getCurrentBalance();
        bankAccount.setCurrentBalance(old_amount-new_amount);
        em.merge(bankAccount);
    }
    
    /**
     * This set of operations will execute in one single transaction
     * which working under Entity Manager
     * 
     * @param bankAccountFrom
     * @param bankAccountTo
     * @param clientFrom
     * @param clientTo
     * @param amount
     */
    public void makePay(BankAccount bankAccountFrom, BankAccount bankAccountTo,
            Client clientFrom, Client clientTo, double amount) {
        substractionMoney(bankAccountFrom);
        addMoney(bankAccountTo);
        writeHistory(bankAccountFrom, bankAccountTo, clientFrom, clientTo, amount);
    }

    /**
     * This set of operations will execute in one single transaction
     * which working under Entity Manager
     * 
     * @param bankAccountFrom
     * @param bankAccountTo
     * @param clientFrom
     * @param clientTo
     * @param amount 
     */
    public void writeHistory(BankAccount bankAccountFrom, BankAccount bankAccountTo, Client clientFrom, Client clientTo, double amount) {
        PaymentsHistory ph = new PaymentsHistory();
        int paymentID = 0;
        List resultList = em.createNamedQuery("PaymentsHistory.findAll").getResultList();
        if (resultList.size()>0) {
            PaymentsHistory phOld = (PaymentsHistory) resultList.get(resultList.size()-1);
            paymentID = phOld.getPaymentID();
        }
        ph.setPaymentID(paymentID+1);
        ph.setClientID(clientFrom);
        ph.setClientAccountID(bankAccountFrom);
        ph.setAmount(amount);
        ph.setBeneficiarClienstID(clientTo);
        ph.setBeneficiarAccountID(bankAccountTo);
        em.persist(ph);
    }
    
    /**
     * 
     * @param bankAccount
     * @param clientID
     * @param amount 
     */
    public void addMoneyWithHistory(BankAccount bankAccount, Client clientID, double amount) {
        addMoney(bankAccount);
        writeHistory(bankAccount, bankAccount, clientID, clientID, amount);
    }

    public void setBlockToAcount(int accountID_as_int) {
        BankAccount bankAccountOld = getAccountByID_asSingleAccount(accountID_as_int);
        BankAccount bankAccountNew = new BankAccount();
        
        bankAccountNew.setAccountID(accountID_as_int);
        bankAccountNew.setClientID(bankAccountOld.getClientID());
        bankAccountNew.setCurrentBalance(bankAccountOld.getCurrentBalance());
        bankAccountNew.setStatus(2);
        
        em.merge(bankAccountNew);
    }

    public List getAllAccountsByStatus(int status_blocked) {
        System.out.println("//---------------------------------------------");
        List resultList = em.createNamedQuery("BankAccount.findByStatus")
                .setParameter("status", status_blocked)
                .getResultList();
        return resultList;
    }
  
}
