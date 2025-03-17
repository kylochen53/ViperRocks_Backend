package viper_rocks.com.repository;

import viper_rocks.com.db.DBConnection;
import viper_rocks.com.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/* User(Integer id, String password, String email, String role, 
    			LocalDateTime emailVerified, String profilePicture, String firstName, 
    			String lastName, Boolean over13, LocalDateTime createdAt, 
    			LocalDateTime updatedAt, Integer reliabilityScore, Integer parentId)*/

public class UserRepository {
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String role = rs.getString("role");
                LocalDateTime emailVerified = rs.getTimestamp("email_verified") != null ? 
                                              rs.getTimestamp("email_verified").toLocalDateTime() : null;
                String profilePicture = rs.getString("profile_picture");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                Boolean over13 = rs.getBoolean("over13");
                LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
                LocalDateTime updatedAt = rs.getTimestamp("updated_at").toLocalDateTime();
                int reliabilityScore = rs.getInt("reliability_score");
                Integer parentId = rs.getObject("parent_id", Integer.class); // Handles null values
                // Create User object and add to list
                User user = new User(id, password, email, role, emailVerified, profilePicture, 
                                     firstName, lastName, over13, createdAt, updatedAt, 
                                     reliabilityScore, parentId);
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
    
    public User getUserByEmail(String email){
       	User user = new User();
    	String sql = "SELECT * FROM \"user\" WHERE email = ?";
    	 try (Connection conn = DBConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
    		 
    		 stmt.setString(1, email);
    		 ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String password = rs.getString("password");
                    String emails = rs.getString("email");
                    String role = rs.getString("role");
                    LocalDateTime emailVerified = rs.getTimestamp("email_verified") != null ? 
                                                  rs.getTimestamp("email_verified").toLocalDateTime() : null;
                    String profilePicture = rs.getString("profile_picture");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    Boolean over13 = rs.getBoolean("over13");
                    LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
                    LocalDateTime updatedAt = rs.getTimestamp("updated_at").toLocalDateTime();
                    int reliabilityScore = rs.getInt("reliability_score");
                    Integer parentId = rs.getObject("parent_id", Integer.class); // Handles null values
                    // Create User object and add to list
                    user = new User(id, password, email, role, emailVerified, profilePicture, 
                                         firstName, lastName, over13, createdAt, updatedAt, 
                                         reliabilityScore, parentId);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        return user;
        }
        
    }
