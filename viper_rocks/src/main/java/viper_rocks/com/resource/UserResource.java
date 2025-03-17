package viper_rocks.com.resource;

import viper_rocks.com.model.User;
import viper_rocks.com.repository.UserRepository;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class UserResource {

    private UserRepository userRepository = new UserRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsersByEmail() {
        return userRepository.getUsers();
    }
    //query for unique email search part 1
    //SELECT * FROM public."user" where email = 'testuser@example.com'
    
    
}
