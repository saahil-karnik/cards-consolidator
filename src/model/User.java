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
public class User {

    public User(String email1, String hashedPassword) {
    }
 
       String name;      
       String email;
       int UID;
       String password;
       Date DOB;

    
    // Default constructor
    public User() {
    }

    // Parameterized constructor
    public User(String name, String email, int id, Date dob, String password) {
        this.name = name;
        this.email = email;
        this.UID = id;
        this.DOB = dob;
        this.password = password;
    }   
       
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getId() {
        return UID;
    }
    public void setId(int UID) {
        this.UID = UID;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getDOB() {
        return DOB;
    }
    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }
}
