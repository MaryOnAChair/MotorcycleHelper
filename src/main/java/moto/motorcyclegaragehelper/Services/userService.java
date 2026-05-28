package moto.motorcyclegaragehelper.Services;

import moto.motorcyclegaragehelper.Entities.User;
import moto.motorcyclegaragehelper.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Autowired
    private UserRepository userRepository;

}
