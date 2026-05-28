package moto.motorcyclegaragehelper.Controllers;

import moto.motorcyclegaragehelper.Entities.User;
import moto.motorcyclegaragehelper.Repositories.UserRepository;
import moto.motorcyclegaragehelper.Security.JwUtil;
import moto.motorcyclegaragehelper.Security.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody LoginRequest loginRequest){
        Optional<User> existingUser = userRepository.findByUsername(loginRequest.getUsername());
        if(existingUser.isPresent()){
            return ResponseEntity.badRequest()
                    .body("User already exists");
        }

        User user = new User();
        user.setUsername(loginRequest.getUsername());
        user.setPassword(passwordEncoder.encode(loginRequest.getPassword()));

        userRepository.save(user);
        return ResponseEntity.ok("successfully registered <3");
    }

    @PostMapping("/login")
    public Map<String,String> login(@RequestBody LoginRequest loginRequest){
        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow();

        boolean valid = passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());
        if(!valid){
            throw new RuntimeException("Invalid username or password");
        }
        String token = jwUtil.generateJwToken(loginRequest.getUsername());
        return Map.of("token", token);
    }
}
