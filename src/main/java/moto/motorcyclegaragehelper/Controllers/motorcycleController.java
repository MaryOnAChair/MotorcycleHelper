package moto.motorcyclegaragehelper.Controllers;

import moto.motorcyclegaragehelper.Entities.Motorcycle;
import moto.motorcyclegaragehelper.Entities.User;
import moto.motorcyclegaragehelper.Repositories.UserRepository;
import moto.motorcyclegaragehelper.Repositories.motorcycleRepository;
import moto.motorcyclegaragehelper.Services.motorcycleService;
import moto.motorcyclegaragehelper.Services.userService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/motorcycle")
@CrossOrigin(origins = "http://localhost:4200")
public class motorcycleController {

    public final motorcycleRepository motorcycleRepository;
    private final motorcycleService motorcycleService;
    private final UserRepository userRepository;

    public motorcycleController(motorcycleRepository motorcycleRepository, motorcycleService motorcycleService, UserRepository userRepository) {
        this.motorcycleRepository = motorcycleRepository;
        this.motorcycleService = motorcycleService;
        this.userRepository = userRepository;
    }

    @GetMapping("/{moto_id}")
    public Motorcycle getMotorcycle(@PathVariable("moto_id") Long moto_id) {
        return motorcycleRepository.findById(moto_id).orElse(null);
    }

    @GetMapping
    public List<Motorcycle> getAll(Authentication authentication) {
        System.out.println(authentication.getName());
        System.out.println(authentication);
        return  motorcycleRepository.findByUserUsername(authentication.getName());

    }



    @PostMapping
    public Motorcycle createMotorcycle(@RequestBody Motorcycle motorcycle,Authentication authentication) {
       System.out.println(authentication.getName());
       System.out.println(authentication);

       String userName = authentication.getName();

       User user = userRepository.findByUsername(userName)
                       .orElseThrow(()-> new RuntimeException("Username not found"));
       motorcycle.setUser(user);

        motorcycle.setMoto_id(null);
       return motorcycleService.createMotorcycle(motorcycle);
    }


    @DeleteMapping("/{moto_id}")
    public Motorcycle deleteMotorcycle(@PathVariable Long moto_id) {



        motorcycleService.deleteMotorcycle(moto_id);
        return null;
    }

    @PutMapping("/{moto_id}")
    public Motorcycle updateMotorcycle(
            @PathVariable Long moto_id,
            @RequestBody Motorcycle updated,Authentication authentication
    ){
        System.out.println(updated.getModel());
        System.out.println(updated.getBrand());
        System.out.println(updated.getYear());

        Motorcycle motorcycle = motorcycleRepository.findById(moto_id)
                .orElseThrow();

        motorcycle.setBrand(updated.getBrand());
        motorcycle.setModel(updated.getModel());
        motorcycle.setYear(updated.getYear());

        return motorcycleRepository.save(motorcycle);
    }


}
