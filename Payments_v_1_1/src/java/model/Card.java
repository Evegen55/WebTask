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
package model;

/**
 *
 * @author Lartsev
 */
public class Card {
    private String pan;
    private String card_sec_code;
    private String valid_date;
    private String status;
    
    /**
     *
     */
    public Card() {}
    
    /**
     *
     * @param pan
     * @param card_sec_code
     * @param valid_date
     */
    public Card(String pan, String card_sec_code, String valid_date) {
        this.pan = pan;
        this.card_sec_code = card_sec_code;
        this.valid_date = valid_date;
        this.status = "unblocked";
        
    }
    /**
     *
     * @param pan
     * @param card_sec_code
     * @param valid_date
     * @param status
     */
    public Card(String pan, String card_sec_code, String valid_date, String status) {
        this.pan = pan;
        this.card_sec_code = card_sec_code;
        this.valid_date = valid_date;
        this.status = status;
        
    }
    
    /**
     *
     * @return primary account number IN STRING FORMAT
     * @see https://en.wikipedia.org/wiki/Bank_card_number
     */
    public String getPan() {
        return pan;
    }

    /**
     *
     * @param pan primary account number IN STRING FORMAT
     * @see https://en.wikipedia.org/wiki/Bank_card_number
     */
    public void setPan(String pan) {
        this.pan = pan;
    }

    /**
     *
     * @return card security code IN STRING FORMAT
     * @see https://en.wikipedia.org/wiki/Card_security_code
     */
    public String getCard_sec_code() {
        return card_sec_code;
    }

    /**
     *
     * @param card_sec_code IN STRING FORMAT
     * @see https://en.wikipedia.org/wiki/Card_security_code
     */
    public void setCard_sec_code(String card_sec_code) {
        this.card_sec_code = card_sec_code;
    }

    /**
     *
     * @return
     */
    public String getValid_date() {
        return valid_date;
    }

    /**
     *
     * @param valid_date IN STRING FORMAT
     */
    public void setValid_date(String valid_date) {
        this.valid_date = valid_date;
    }

    /**
     *
     * @return "blocked" or "unbloked"
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status "blocked" or "unbloked"
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
