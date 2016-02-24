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

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Evegen
 */
@Stateless
public class AccountDAO {
    
    @PersistenceContext private EntityManager em;

    public List getAllAccounts() {
        //return em.createNamedQuery("BankAccount.findAll").getResultList();
        //return em.createNamedQuery("BankAccount.findByAccountID").setParameter("accountID", 3).getResultList();
        
        //TODO: create right query!!!
        return em.createNamedQuery("BankAccount.findByAccountID").setParameter("clientID", 3).getResultList();
    }
}
