package moto.motorcyclegaragehelper.Controllers;

import ch.qos.logback.core.model.Model;
import moto.motorcyclegaragehelper.Entities.Motorcycle;
import moto.motorcyclegaragehelper.Repositories.motorcycleRepository;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
@CrossOrigin(origins = "http://localhost:4200")
public class motorcycleController {

    public final motorcycleRepository motorcycleRepository;

    public motorcycleController(motorcycleRepository motorcycleRepository) {
        this.motorcycleRepository = motorcycleRepository;
    }

    @GetMapping
    public List<Motorcycle> getAll() {
        return motorcycleRepository.findAll();
    }

    @PostMapping
    public String addMotorcycle(@Validated @ModelAttribute("Model")Model model, BindingResult result){
        if(result.hasErrors()){
            return "error";
        }
        Motorcycle moto = new Motorcycle();
        moto.setModel(String.valueOf(model));
        motorcycleRepository.save(moto);
        return "success";
    }


}
