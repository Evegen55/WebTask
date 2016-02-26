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

/**
 *
 * @author Evegen
 */
@Stateless
public class PaymentsHistDAO {
    
    @PersistenceContext private EntityManager em;

    /**
     *
     * @return
     */
    public List getAllPaymetnsHistoryByClientID() {
        em.flush();
        //Now we've got decide how we can get a link between user John and clientID
        //in the next line clientID is just 1
        Client client = em.find(Client.class, 1);
        Collection col = client.getPaymentsHistoryCollection();
        List list;
        if(col instanceof List) {
        list = (List)col;
        } else {
        list= new ArrayList(col);
        }
        return list;
    }
}
