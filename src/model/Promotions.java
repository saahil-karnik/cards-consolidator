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
public class Promotions {
 
       int promotionID;      
       String type;
       String promotionName;
       int eligibilityPoints;
      
       
    public int getPromotionID() {
        return promotionID;
    }

    public void setPromotionID(String firstname) {
        this.promotionID = promotionID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getPromotionType() {
        return promotionName;
    }

    public void setPromotionType(String id) {
        this.promotionName = promotionName;
    }
    public int getEligibilityPoints() {
        return eligibilityPoints;
    }

    public void setEligibilityPoints(int id) {
        this.eligibilityPoints = eligibilityPoints;
    }
}
