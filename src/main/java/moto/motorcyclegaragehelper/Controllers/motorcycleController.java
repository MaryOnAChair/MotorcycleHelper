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

/** This is a controller class for all other interactions on the website.
 *  This class is used for creating/updating/deleting/viewing data from the motorcycle table.
 *
 */


@RestController
@RequestMapping("/api/motorcycle")
@CrossOrigin(origins = "http://localhost:4200")
public class motorcycleController {

    //Repositories and Services
    public final motorcycleRepository motorcycleRepository;
    private final motorcycleService motorcycleService;
    private final UserRepository userRepository;

    public motorcycleController(motorcycleRepository motorcycleRepository, motorcycleService motorcycleService, UserRepository userRepository) {
        this.motorcycleRepository = motorcycleRepository;
        this.motorcycleService = motorcycleService;
        this.userRepository = userRepository;
    }

    //Finds Motorcycle by Id
    @GetMapping("/{moto_id}")
    public Motorcycle getMotorcycle(@PathVariable("moto_id") Long moto_id) {
        return motorcycleRepository.findById(moto_id).orElse(null);
    }

    //Returns all motorcycles
    @GetMapping
    public List<Motorcycle> getAll(Authentication authentication) {
        System.out.println(authentication.getName());
        System.out.println(authentication);
        return  motorcycleRepository.findByUserUsername(authentication.getName());

    }

    //Creates New Motorcycle
    @PostMapping
    public Motorcycle createMotorcycle(@RequestBody Motorcycle motorcycle,Authentication authentication) {

        //Attaches motorcycle to user if user is valid
       String userName = authentication.getName();
       User user = userRepository.findByUsername(userName)
                       .orElseThrow(()-> new RuntimeException("Username not found"));
       motorcycle.setUser(user);

       //This is set by the database automatically
        motorcycle.setMoto_id(null);
       return motorcycleService.createMotorcycle(motorcycle);
    }


    //Deletes Motorcycle
    @DeleteMapping("/{moto_id}")
    public Motorcycle deleteMotorcycle(@PathVariable Long moto_id) {
        motorcycleService.deleteMotorcycle(moto_id);
        return null;
    }

    //Updates Motorcycle
    @PutMapping("/{moto_id}")
    public Motorcycle updateMotorcycle(
            @PathVariable Long moto_id,
            @RequestBody Motorcycle updated,Authentication authentication
    ){
        Motorcycle motorcycle = motorcycleRepository.findById(moto_id)
                .orElseThrow();

        // Updates Brand
        motorcycle.setBrand(updated.getBrand());
        // Updates Model
        motorcycle.setModel(updated.getModel());
        // Updates Year
        motorcycle.setYear(updated.getYear());
        // Updates VIN
        motorcycle.setVin(updated.getVin());
        // Updates Color
        motorcycle.setColor(updated.getColor());
        // Updates Odometer
        motorcycle.setOdometer(updated.getOdometer());

        return motorcycleRepository.save(motorcycle); // Saves Changes
    }


}
