package moto.motorcyclegaragehelper.Controllers;

import moto.motorcyclegaragehelper.Entities.User;
import moto.motorcyclegaragehelper.Repositories.UserRepository;
import moto.motorcyclegaragehelper.Security.JwAuthFilter;
import moto.motorcyclegaragehelper.Security.JwUtil;
import moto.motorcyclegaragehelper.Security.LoginRequest;
import moto.motorcyclegaragehelper.Security.RegisterRequest;
import moto.motorcyclegaragehelper.Services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwUtil jwUtil;
    @Autowired
    private userService userService;

    /** This is a controller class for User Authentication
     * The class is used when registering/logging in users. */


    //Registering User
    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegisterRequest rr){
        User user = new User(); //Creates new user
        user.setUsername(rr.getUsername()); //Sets username
        user.setPassword(passwordEncoder.encode(rr.getPassword())); //Encodes password before saving
        user.setEmail(rr.getEmail());   //Sets Email

        userRepository.save(user);  //Saves User
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("message", "registered successfully"));
    }

    //Logging In User
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){

        //Looks for entered username
        User user = userRepository
                .findByUsername(loginRequest.getUsername())
                .orElse(null);

        //Returns null if user not found
        if(user == null) {
            return ResponseEntity.badRequest()
                    .body("User not found");
        }
        //Compares password entered with encoded password
        boolean matches =
                passwordEncoder.matches(
                        loginRequest.getPassword(),
                        user.getPassword());

        //Returns bad password if passwords don't match
        if(!matches) {
            return ResponseEntity.badRequest()
                    .body("Bad password");
        }

        //Generates token for log in session
        try {
            String token = jwUtil.generateToken(user.getUsername());

            return ResponseEntity.ok(token);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }
}
