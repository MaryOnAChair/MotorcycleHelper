package moto.motorcyclegaragehelper.Services;

import moto.motorcyclegaragehelper.Entities.Motorcycle;
import moto.motorcyclegaragehelper.Repositories.motorcycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class motorcycleService {

    @Autowired
    private final motorcycleRepository motorcycleRepository;

    public motorcycleService(motorcycleRepository motorcycleRepository) {
        this.motorcycleRepository = motorcycleRepository;
    }

    public List<Motorcycle> getAllMotorcycles(){
        return motorcycleRepository.findAll();
    }

    public Motorcycle createMotorcycle(Motorcycle motorcycle){
        return motorcycleRepository.save(motorcycle);
    }

    public void deleteMotorcycle(Long id){
        motorcycleRepository.deleteById(id);
    }

}
