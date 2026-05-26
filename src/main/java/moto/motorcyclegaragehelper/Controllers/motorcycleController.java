package moto.motorcyclegaragehelper.Controllers;

import moto.motorcyclegaragehelper.Entities.Motorcycle;
import moto.motorcyclegaragehelper.Repositories.motorcycleRepository;
import moto.motorcyclegaragehelper.Services.motorcycleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/motorcycle")
@CrossOrigin(origins = "http://localhost:4200")
public class motorcycleController {

    public final motorcycleRepository motorcycleRepository;
    private final motorcycleService motorcycleService;

    public motorcycleController(motorcycleRepository motorcycleRepository, motorcycleService motorcycleService) {
        this.motorcycleRepository = motorcycleRepository;
        this.motorcycleService = motorcycleService;
    }

    @GetMapping("/{moto_id}")
    public Motorcycle getMotorcycle(@PathVariable("moto_id") Long moto_id) {
        return motorcycleRepository.findById(moto_id).orElse(null);
    }

    @GetMapping
    public List<Motorcycle> getAll() {
        return motorcycleRepository.findAll();
    }

    @PostMapping
    public Motorcycle createMotorcycle(@RequestBody Motorcycle motorcycle) {
        motorcycle.setMoto_id(null);
       return motorcycleService.createMotorcycle(motorcycle);
    }


    @DeleteMapping("/{moto_id}")
    public Motorcycle deleteMotorcycle(@PathVariable Long moto_id) {



        motorcycleService.deleteMotorcycle(moto_id);
        return null;
    }

}
