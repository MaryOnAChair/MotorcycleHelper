package moto.motorcyclegaragehelper.Services;

import moto.motorcyclegaragehelper.Entities.User;
import moto.motorcyclegaragehelper.Repositories.UserRepository;
import moto.motorcyclegaragehelper.Security.JwUtil;
import moto.motorcyclegaragehelper.Security.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
// Interface class for user entity

@Service
public class userService {
    //Injects user repository
    @Autowired
    private UserRepository userRepository;

}
