/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.ImageIcon;

/**
 *
 * @author saahilk
 */
public class Promotion {
 
       String promotionID;      
       String type;
       String promotionName;
       int eligiblePoints;

    public String getPromotionID() {
        return promotionID;
    }

    public void setPromotionID(String promotionID) {
        this.promotionID = promotionID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public int getEligiblePoints() {
        return eligiblePoints;
    }

    public void setEligiblePoints(int eligiblePoints) {
        this.eligiblePoints = eligiblePoints;
    }
      
       
    
}
