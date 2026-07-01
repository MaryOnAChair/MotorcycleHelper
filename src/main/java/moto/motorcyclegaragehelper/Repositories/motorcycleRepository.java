package moto.motorcyclegaragehelper.Repositories;

import moto.motorcyclegaragehelper.Entities.Motorcycle;
import moto.motorcyclegaragehelper.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//Repository for Motorcycles
public interface motorcycleRepository extends JpaRepository<Motorcycle, Long> {
    List<Motorcycle> findByUserUsername(String username);
}

