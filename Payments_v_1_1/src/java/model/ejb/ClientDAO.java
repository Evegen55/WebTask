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
import model.Client;

/**
 *
 * @author Evegen
 */
@Stateless
public class ClientDAO {

    /**
     * 
     * @param remoteUser
     * @return 
     */
    public Client getClientByNickName(String remoteUser) {
        List resultList = em.createNamedQuery("Client.findByNickName")
                .setParameter("nickName", remoteUser)
                .getResultList();
        Client client = new Client();
        if (resultList.size()>0) {
            client = (Client) resultList.get(0);
        }
        return client;
    }
    
    @PersistenceContext private EntityManager em;

    /**
     * 
     * @param id
     * @return 
     */
    public Client getClientByID_asSingleClient(int id){
        List resultList = em.createNamedQuery("Client.findByClientID")
                .setParameter("clientID", id)
                .getResultList();
        Client client = new Client();
        if (resultList.size()>0) {
            client = (Client) resultList.get(0);
        }
        return client;
    }
}
