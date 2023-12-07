/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import java.sql.*;
import java.util.ArrayList;
import model.User;
import model.Card;
import model.Promotions;
/**
 * Database Connector class for interacting with database
 * @author saahilk
 */
public class DatabaseConnector {

    private static final String URL = "jdbc:mysql://localhost:3306/test?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static boolean isUserExists(User user) {
        String query = "SELECT COUNT(*) FROM USER WHERE email = ? AND password = SHA2(?, 256)";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, user.getEmail());
        stmt.setString(2, user.getPassword());
        ResultSet rs = stmt.executeQuery();
        rs.next(); // Move to the first row
        int count = rs.getInt(1);
        return count > 0; // If count is greater than 0, user exists
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
   
    }
    
        public static boolean userExists(String email) {
        String query = "SELECT COUNT(*) FROM USER WHERE email = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            rs.next(); // Move to the first row
            int count = rs.getInt(1);
            return count > 0; // If count is greater than 0, user exists
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
        
        public static String getPasswordHash(String email) {
    String query = "SELECT password FROM USER WHERE email = ?";
    
    try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            return rs.getString("password");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return null;
}


    /**
     * Privatized constructor so as to not allow object creation
     */
    private DatabaseConnector() {
    } 
    /**
     * Insert given user to database
     * @see User
     * @param user User object to be added
     */
    public static void addUser(User user) {
        //add to database
        java.util.Date utilDate = new java.util.Date();
        // Convert java.util.Date to java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        String query = "INSERT INTO USER(NAME,EMAIL,UID,PASSWORD,DOB) VALUES(?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setInt(3, user.getId());
            stmt.setString(4, user.getPassword());
            stmt.setDate(5, new java.sql.Date(user.getDOB().getTime()));
            int rows = stmt.executeUpdate();
            System.out.println("Rows impacted : " + rows);
//            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addCard(Card card) {
        //add to database
        String query = "INSERT INTO CARD(CARDNO,TYPE,EXPIRY,UID,POINTS) VALUES(?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, card.getCardNo());
            stmt.setString(2, card.getType());
            stmt.setDate(3, new java.sql.Date(card.getExpiry().getTime())); //stmt.setDate(5, new java.sql.Date(newUser.getExpiry().getTime()));
            stmt.setInt(4, card.getUID());
            stmt.setInt(5, card.getPoints());
            int rows = stmt.executeUpdate();
            System.out.println("Rows impacted : " + rows);
//            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addPromotion(Promotions promotion) {
        //add to database
        String query = "INSERT INTO PROMOTIONS(PROMOTION_ID,TYPE,ELIGIBLEPOINTS,PROMOTIONNAME) VALUES(?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, promotion.getPromotionID());
            stmt.setString(2, promotion.getType());
            stmt.setInt(3, promotion.getEligibilityPoints());
            stmt.setString(4, promotion.getPromotionType());
            int rows = stmt.executeUpdate();
            System.out.println("Rows impacted : " + rows);
//            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Return lost of all users in database
     * @see User
     * @return list of users
     */
    public static ArrayList<User> getAllusers() {
//        return list of users from db
        ArrayList<User> users = new ArrayList<>();

        String query = "SELECT * FROM USER";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                User u = new User();
                u.setName(rs.getString("Name"));
                u.setEmail(rs.getString("Email"));
                u.setId(rs.getInt("Id"));
                u.setDOB(rs.getDate("DOB"));  //stmt.setDate(5, new java.sql.Date(user.getDOB().getTime()));
                u.setPassword(rs.getString("Password"));
                users.add(u);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
    
    public static ArrayList<Card> getAllcards() {
//        return list of users from db
        ArrayList<Card> card = new ArrayList<>();

        String query = "SELECT * FROM CARD";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Card c = new Card();
                c.setUID(rs.getInt("UID"));
                c.setType(rs.getString("Type"));
                c.setExpiry(rs.getDate("Expiry"));
                c.setPoints(rs.getInt("Points"));
                c.setCardNo(rs.getInt("CardNo"));
                card.add(c);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return card;
    }
    
    public static ArrayList<Promotions> getAllPromotions() {
//        return list of users from db
        ArrayList<Promotions> promotion = new ArrayList<>();

        String query = "SELECT * FROM USER";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Promotions p = new Promotions();
                p.setPromotionID(rs.getString("name"));
                p.setType(rs.getString("Type"));
                p.setPromotionType(rs.getString("id"));
                p.setEligibilityPoints(rs.getInt("EligibilityPoints"));
                promotion.add(p);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return promotion;
    }

    /**
     * Delete given user from database
     * @see User
     * @param u User to be deleted
     * 
     */
    public static void deleteUser(User u) {
        String query = "delete from USER where id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, u.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void deleteCard(Card c){
        String query = "delete from CARD where id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, c.getCardNo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void deletePromotion(Promotions p) {
        String query = "delete from PROMOTION where id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, p.getPromotionID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Edit given user details in the database
     * @param oldUser existing user in database
     * @param newUser modified user details to be added
     */
    public static void editUser(User oldUser, User newUser) {
        String query = "UPDATE USER SET name=?, email=?, DOB=?, password=?, id=? WHERE id=?";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, newUser.getName());
            stmt.setString(2, newUser.getEmail());
            stmt.setInt(3, oldUser.getId());
            stmt.setDate(4, new java.sql.Date(newUser.getDOB().getTime()));  //stmt.setDate(5, new java.sql.Date(newUser.getDOB().getTime()));
            stmt.setString(5, newUser.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void editCard(Card oldCard, Card newCard) {
        String query = "UPDATE CARD SET cardNo=?, type=?, expiry=?, UID=?, points=? WHERE id=?";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, newCard.getUID());
            stmt.setString(2, newCard.getType());
            stmt.setInt(3, oldCard.getCardNo());
            stmt.setDate(4, new java.sql.Date(newCard.getExpiry().getTime())); //new java.sql.Date(newCard.getExpiry().getTime()));
            stmt.setInt(5, newCard.getPoints());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void editPromotion(Promotions oldPromotion, Promotions newPromotion) {
        String query = "UPDATE PROMOTION SET promotion_id=?, type=?, eligiblepoints=?, promotionName= ? WHERE id=?";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, newPromotion.getType());
            stmt.setInt(2, newPromotion.getEligibilityPoints());
            stmt.setInt(3, oldPromotion.getPromotionID());
            stmt.setString(4, newPromotion.getPromotionType());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
}
