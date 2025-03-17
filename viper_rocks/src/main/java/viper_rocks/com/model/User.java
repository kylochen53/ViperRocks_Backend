package viper_rocks.com.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "\"user\"") // PostgreSQL reserved keyword, must be quoted
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false, name = "role")
    private String role;

    @Column(nullable = true, name = "emailVerified")
    private LocalDateTime emailVerified;  // Email verification as TIMESTAMP

    @Column(nullable = true, name = "profilePicture")
    private String profilePicture;

    @Column(nullable = true, name = "firstName")
    private String firstName;

    @Column(nullable = true, name = "lastName")
    private String lastName;

    @Column(nullable = true, name = "over13")
    private Boolean over13;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;
    
    @Column(nullable = true, name = "reliabilityScore")
    private Integer reliabilityScore;

    @ManyToOne
    @Column(nullable = true)
    @JoinColumn(name = "parentId", referencedColumnName = "id")
    private Integer parentId; 

    // Default Constructor
    public User() {}

    // Constructor with Fields (if needed)
    public User(String email, String password, String username, String profilePicture, String role) {
        this.password = password;
        this.email = email;
        this.role = role;
        this.emailVerified = null;
        this.profilePicture = profilePicture;
    }

    public User(Integer id, String password, String email, String role, 
    			LocalDateTime emailVerified, String profilePicture, String firstName, 
    			String lastName, Boolean over13, LocalDateTime createdAt, 
    			LocalDateTime updatedAt, Integer reliabilityScore, Integer parentId) {
    	this.id = id;
        this.password = password;
        this.email = email;
        this.role = role;
        this.emailVerified = emailVerified;
        this.profilePicture = profilePicture;
        this.firstName = firstName;
        this.lastName = lastName;
        this.over13 = over13;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.reliabilityScore = reliabilityScore;
        this.parentId = parentId;
    }
    
    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public LocalDateTime getEmailVerified() { return emailVerified; }
    public void setEmailVerified(LocalDateTime emailVerified) { this.emailVerified = emailVerified; }

    public String getProfilePicture() { return profilePicture; }
    public void setProfilePicture(String profilePicture) { this.profilePicture = profilePicture; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Boolean getOver13() { return over13; }
    public void setOver13(Boolean over13) { this.over13 = over13; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public Integer getReliabilityScore() { return reliabilityScore; }
    public void setReliabilityScore(Integer reliabilityScore) { this.reliabilityScore = reliabilityScore; }

    public Integer getParent() { return parentId; }
    public void setParent(Integer parentId) { this.parentId = parentId; }
}
