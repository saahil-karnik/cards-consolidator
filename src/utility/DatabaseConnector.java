/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import java.sql.*;
import java.util.ArrayList;
import model.User;
import model.Card;
import model.Promotion;
/**
 * Database Connector class for interacting with database
 * @author saahilk
 */
public class DatabaseConnector {

    private static final String URL = "jdbc:mysql://localhost:3306/test?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    
    /**
     * Privatized constructor so as to not allow object creation
     */
    private DatabaseConnector() {
    } 

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
    public static void addPromotion(Promotion promotion) {
        //add to database
        String query = "INSERT INTO PROMOTIONS(PROMOTION_ID,TYPE,ELIGIBLEPOINTS,PROMOTIONNAME) VALUES(?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, promotion.getPromotionID());
            stmt.setString(2, promotion.getType());
            stmt.setInt(3, promotion.getEligiblePoints());
            stmt.setString(4, promotion.getPromotionName());
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
    
    public static Card getCard(String cardType, int userID){
        Card c = new Card();
        String query = "SELECT * FROM CARD WHERE Type=? AND UID=?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, cardType);
            stmt.setInt(2, userID);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                c.setUID(rs.getInt("UID"));
                c.setType(rs.getString("Type"));
                c.setExpiry(rs.getDate("Expiry"));
                c.setPoints(rs.getInt("Points"));
                c.setCardNo(rs.getInt("CardNo"));
            }
            rs.close();
//            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public static ArrayList<Card> getUserCards(int userID){
        ArrayList<Card> card = new ArrayList<>();
        String query = "SELECT * FROM CARD WHERE UID=?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();
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
    
    public static ArrayList<Promotion> getAllPromotions() {
//        return list of users from db
        ArrayList<Promotion> promotion = new ArrayList<>();

        String query = "SELECT * FROM PROMOTIONS";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Promotion p = new Promotion();
                p.setPromotionID(rs.getString("PromotionID"));
                p.setType(rs.getString("Type"));
                p.setPromotionName(rs.getString("PromotionName"));
                p.setEligiblePoints(rs.getInt("EligiblePoints"));
                promotion.add(p);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return promotion;
    }
    
    public static ArrayList<Promotion> getSelectPromotions(String type) {
//        return list of specific promotions from db
        ArrayList<Promotion> selectPromotion = new ArrayList<>();

        String query = "SELECT * FROM PROMOTIONS WHERE Type = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, type);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Promotion p = new Promotion();
                p.setPromotionID(rs.getString("PromotionID"));
                p.setType(rs.getString("Type"));
                p.setPromotionName(rs.getString("PromotionName"));
                p.setEligiblePoints(rs.getInt("EligiblePoints"));
                selectPromotion.add(p);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return selectPromotion;
    }

    /**
     * Delete given user from database
     * @see User
     * @param u User to be deleted
     * 
     */
    public static void deleteUser(User u) {
        String query = "delete from USER where UID = ?";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, u.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void deleteCard(Card c){
        String query = "delete from CARD where cardNo = ?";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, c.getCardNo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void deletePromotion(Promotion p) {
        String query = "delete from PROMOTION where PromotionID = ?";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, p.getPromotionID());
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
        String query = "UPDATE USER SET Name=?, Email=?, DOB=?, Password=?, UID=? WHERE UID=?";

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
        String query = "UPDATE CARD SET CardNo=?, type=?, expiry=?, UID=? WHERE CardNo=?";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, newCard.getCardNo());
            stmt.setString(2, newCard.getType());
            stmt.setDate(3, new java.sql.Date(newCard.getExpiry().getTime())); //new java.sql.Date(newCard.getExpiry().getTime()));
            stmt.setInt(4, newCard.getUID());
            stmt.setInt(5, oldCard.getCardNo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void editPromotion(Promotion oldPromotion, Promotion newPromotion) {
        String query = "UPDATE PROMOTION SET PromotionID=?, Type=?, EligiblePoints=?, PromotionName= ? WHERE PromotionID=?";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, newPromotion.getType());
            stmt.setInt(2, newPromotion.getEligiblePoints());
            stmt.setString(3, oldPromotion.getPromotionID());
            stmt.setString(4, newPromotion.getPromotionName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
}
