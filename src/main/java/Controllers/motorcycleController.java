package Controllers;

import Entities.Motorcycle;
import Repositories.motorcycleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Garage")
@CrossOrigin(origins = "http://localhost:4200")
public class motorcycleController {

    public final motorcycleRepository motorcycleRepository;

    public motorcycleController(motorcycleRepository motoRepo) {
        this.motorcycleRepository = motoRepo;
    }



}
