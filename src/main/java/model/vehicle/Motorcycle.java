package model.vehicle;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import static model.vehicle.VehicleUtil.*;

@Getter
@Setter
public class Motorcycle extends BaseVehicle {
    private MotorcycleCondition motorcycleCondition;

    public Motorcycle(VehicleModelSetup model, Double value, Integer mileage, Integer loadCapacity, MotorcycleCondition motorcycleCondition) {
        super(model, value, mileage, loadCapacity);
        this.motorcycleCondition = motorcycleCondition;
    }

    public static Set<BaseVehicle> getRandomMotorcycles(int numberOfMotorcycles) {
        Set<BaseVehicle> randoms = new HashSet<>();

        for (int i = 0; i < numberOfMotorcycles; i++) {
            randoms.add(randomMotorcycle());
        }
        return randoms;
    }

    private static Motorcycle randomMotorcycle() {
        int randomCarByIndex = rand(17, 21);
        VehicleModelSetup randomMotorcycle = VehicleModelSetup.getByIndex(randomCarByIndex);
        Motorcycle car = new Motorcycle(randomMotorcycle, randBaseValueBy(randomMotorcycle), randMileage(), null, MotorcycleCondition.random());

        calculateValue(car);
        return car;

    }

}
