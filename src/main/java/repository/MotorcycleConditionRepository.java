package repository;

import model.vehicle.MotorcycleCondition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorcycleConditionRepository extends JpaRepository<MotorcycleCondition,Long> {
}
