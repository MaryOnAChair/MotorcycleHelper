package moto.motorcyclegaragehelper.Repositories;

import moto.motorcyclegaragehelper.Entities.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface motorcycleRepository extends JpaRepository<Motorcycle, Long> {
}

