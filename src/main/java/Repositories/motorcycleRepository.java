package Repositories;

import Controllers.motorcycleController;
import Entities.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface motorcycleRepository extends JpaRepository<Motorcycle, Long> {
}

