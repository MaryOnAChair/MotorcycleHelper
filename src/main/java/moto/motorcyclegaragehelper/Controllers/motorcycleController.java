package moto.motorcyclegaragehelper.Controllers;

import ch.qos.logback.core.model.Model;
import moto.motorcyclegaragehelper.Entities.Motorcycle;
import moto.motorcyclegaragehelper.Repositories.motorcycleRepository;
import moto.motorcyclegaragehelper.Services.motorcycleService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/motorcycles")
@CrossOrigin(origins = "http://localhost:4200")
public class motorcycleController {

    public final motorcycleRepository motorcycleRepository;
    private final motorcycleService motorcycleService;

    public motorcycleController(motorcycleRepository motorcycleRepository, motorcycleService motorcycleService) {
        this.motorcycleRepository = motorcycleRepository;
        this.motorcycleService = motorcycleService;
    }

    @GetMapping
    public List<Motorcycle> getAll() {
        return motorcycleRepository.findAll();
    }

    @PostMapping
    public Motorcycle createMotorcycle(@RequestBody Motorcycle motorcycle) {
        return motorcycleService.createMotorcycle(motorcycle);
    }


}
