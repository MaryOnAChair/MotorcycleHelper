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


    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegisterRequest rr){
        User user = new User();
        user.setUsername(rr.getUsername());
        user.setPassword(passwordEncoder.encode(rr.getPassword()));
        user.setEmail(rr.getEmail());

        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("message", "registered successfully"));    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){

        System.out.println("Username: " + loginRequest.getUsername());

        User user = userRepository
                .findByUsername(loginRequest.getUsername())
                .orElse(null);

        System.out.println("User found: " + user);

        if(user == null) {
            return ResponseEntity.badRequest()
                    .body("User not found");
        }

        boolean matches =
                passwordEncoder.matches(
                        loginRequest.getPassword(),
                        user.getPassword());

        System.out.println("Password matches: " + matches);

        if(!matches) {
            return ResponseEntity.badRequest()
                    .body("Bad password");
        }
        try {
            String token = jwUtil.generateToken(user.getUsername());

            System.out.println("Generated token: " + token);

            return ResponseEntity.ok(token);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }
}
