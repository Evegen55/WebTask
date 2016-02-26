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
import model.Client;
import model.CreditCards;

/**
 *
 * @author Evegen
 */
@Stateless
public class CardDAO  {
    
    @PersistenceContext private EntityManager em;
    
    /**
     *
     * @param id
     * @return
     */
    public List getCardByID(int id){
        return em.createNamedQuery("CreditCards.findByCardID").setParameter("cardID", id).getResultList();
    }
    
    /**
     *
     * @param id
     * @return
     */
    public CreditCards getCardByID_asSingleCard(int id){
        List resultList = em.createNamedQuery("CreditCards.findByCardID").setParameter("cardID", id).getResultList();
        CreditCards card = new CreditCards();
        if (resultList.size()>0) {
            card = (CreditCards) resultList.get(0);
        }
        return card;
    }
    
    /**
     *
     * @return
     */
    public List getAllCards() {
        return em.createNamedQuery("CreditCards.findAll").getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    /**
     *
     * @param client_id
     * @return
     */
    public List getAllCardsByClientID(int client_id) {
        Client find = em.find(Client.class, client_id);
        Collection col = find.getCreditCardsCollection();
        List list;
        if(col instanceof List) {
        list = (List)col;
        } else {
        list= new ArrayList(col);
        }
        return list;
    }
}
