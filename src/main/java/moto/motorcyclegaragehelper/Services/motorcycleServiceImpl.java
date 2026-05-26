package moto.motorcyclegaragehelper.Services;

import moto.motorcyclegaragehelper.Entities.Motorcycle;
import moto.motorcyclegaragehelper.Repositories.motorcycleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class motorcycleServiceImpl
        implements motorcycleService {

         private final motorcycleRepository motorcycleRepository;

    public motorcycleServiceImpl(
            motorcycleRepository motorcycleRepository
    ) {

        this.motorcycleRepository =
                motorcycleRepository;
    }

    @Override
    public List<Motorcycle> getAllMotorcycles() {

        return motorcycleRepository.findAll();
    }

    @Override
    public Motorcycle createMotorcycle(
            Motorcycle motorcycle
    ) {

        return motorcycleRepository.save(motorcycle);
    }

    @Override
    public void deleteMotorcycle(Long moto_id) {

        motorcycleRepository.deleteById(moto_id);
    }
}