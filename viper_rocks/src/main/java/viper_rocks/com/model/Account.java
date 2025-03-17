package viper_rocks.com.model;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "\"account\"") 
public class Account{
	 	@Id
	    @Column(name = "id", nullable = false)
	    private String id;

	    @Column(name = "userid", nullable = false)
	    private Integer userId;

	    @Column(name = "scope", nullable = false)
	    private String scope;

	    @Column(name = "token_type", nullable = false)
	    private String tokenType;

	    @Column(name = "provider", nullable = false)
	    private String provider;

	    @Column(name = "access_token", nullable = false)
	    private String accessToken;

	    @Column(name = "createdat", nullable = false)
	    private LocalTime createdAt;

	    @Column(name = "updatedat", nullable = false)
	    private LocalTime updatedAt;
	    
	    // Default Constructor
	    public Account() {}
	    
	    
	    
}