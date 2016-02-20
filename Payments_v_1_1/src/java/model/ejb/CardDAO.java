/*
 * Copyright 2016 Lartsev.
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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import model.Card;

/**
 *
 * @author Lartsev
 */
@Stateless
@LocalBean
public class CardDAO {

    @Resource(name="jdbc/paymentDB")
    private DataSource ds;
    
    public void executeModifyQuery(String sql){
        try{
            Connection conn = ds.getConnection();
            conn.createStatement().execute(sql);
            conn.close();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    public ResultSet executeFetchQuery(String sql){
        ResultSet rs = null;
        try{
            Connection conn = ds.getConnection();
            rs = conn.createStatement().executeQuery(sql);
            conn.close();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return rs;
    }
    
    public ArrayList<Card> getAllCards(){
        ArrayList<Card> list = new ArrayList<>();
        String sql = "SELECT * FROM creditCards";
        ResultSet rs = executeFetchQuery(sql);
        try{
            while(rs.next()){
                Card card = new Card();
                card.setPan(rs.getString("pan"));
                card.setCard_sec_code("card_sec_code");
                card.setStatus("status");
                card.setValid_date("valid_date");
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        return list;
    }
}
