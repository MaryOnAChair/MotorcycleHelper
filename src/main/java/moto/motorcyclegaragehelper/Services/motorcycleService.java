package moto.motorcyclegaragehelper.Services;

import moto.motorcyclegaragehelper.Entities.Motorcycle;
import moto.motorcyclegaragehelper.Repositories.motorcycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface motorcycleService {

    List<Motorcycle> getAllMotorcycles();

    Motorcycle createMotorcycle(
            Motorcycle motorcycle);

    void deleteMotorcycle(Long moto_id);
}