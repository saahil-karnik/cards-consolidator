/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.ImageIcon;
import java.util.Date;
/**
 *
 * @author saahilk
 */
public class Card {
 
       int cardNo;      
       String type;
       Date expiry;
       int UID;
       int points;
       
        
    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date id) {
        this.expiry = id;
    }
    public int getPoints() {
        return points;
    }

    public void setPoints(int id) {
        this.points = id;
    }
     public int getUID() {
        return UID;
    }
    public void setUID(int UID) {
        this.UID = UID;
    }
}
