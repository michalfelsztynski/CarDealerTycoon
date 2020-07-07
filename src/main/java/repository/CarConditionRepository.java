package repository;

import model.vehicle.CarCondition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarConditionRepository extends JpaRepository<CarCondition,Long> {
}
