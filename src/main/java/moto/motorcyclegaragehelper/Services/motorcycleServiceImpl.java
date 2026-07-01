package moto.motorcyclegaragehelper.Services;

import moto.motorcyclegaragehelper.Entities.Motorcycle;
import moto.motorcyclegaragehelper.Repositories.motorcycleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/** This is a Service implementation class for motorcycles
 * The class is used for adding/updating/deleting motorcycles
 */

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

    //Gets all motorcycles
    @Override
    public List<Motorcycle> getAllMotorcycles() {

        return motorcycleRepository.findAll();
    }

    //Creates Motorcycle
    @Override
    public Motorcycle createMotorcycle(
            Motorcycle motorcycle
    ) {

        return motorcycleRepository.save(motorcycle);
    }

    //Deletes Motorcycle by Id
    @Override
    public void deleteMotorcycle(Long moto_id) {

        motorcycleRepository.deleteById(moto_id);
    }
}