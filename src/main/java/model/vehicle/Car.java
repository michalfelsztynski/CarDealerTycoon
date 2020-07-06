package model.vehicle;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import static model.vehicle.VehicleUtil.*;


@Getter
@Setter
public class Car extends BaseVehicle {

    private CarCondition carCondition;

    private Car(VehicleModelSetup model, Double baseValue, Integer mileage, Integer loadCapacity, CarCondition carCondition) {
        super(model, baseValue, mileage, loadCapacity);
        this.carCondition = carCondition;
    }

    public static Car createTruck(VehicleModelSetup model, Double baseValue, Integer mileage, Integer loadCapacity, CarCondition carCondition) throws CarStateException {
        if (loadCapacity < 1) {
            throw new CarStateException("some");

        }
        return new Car(model, baseValue, mileage, loadCapacity, carCondition);
    }

    public static Car create(VehicleModelSetup model, Integer mileage, Integer loadCapacity, CarCondition carCondition) throws CarStateException {
        if (model.vehicleType == VehicleModelSetup.VehicleType.CAR) {
            return new Car(model, randBaseValueBy(model), mileage, null, carCondition);
        }

        if (model.vehicleType == VehicleModelSetup.VehicleType.TRUCK) {
            return new Car(model, randBaseValueBy(model), mileage, loadCapacity, carCondition);
        }

        throw new CarStateException("not a car");
    }


    public static Set<BaseVehicle> getRandomCars(int numberOfCars, int numberOfTrucks) {
        Set<BaseVehicle> randoms = new HashSet<>();

        for (int i = 0; i < numberOfCars; i++) {
            randoms.add(randomCar());
            if (i <= numberOfTrucks) randoms.add(randomTruck());
        }
        return randoms;
    }

    private static Car randomCar() {
        int randomCarByIndex = rand(1, 13);
        VehicleModelSetup randomCar = VehicleModelSetup.getByIndex(randomCarByIndex);
        Car car = new Car(randomCar, randBaseValueBy(randomCar), randMileage(), null, CarCondition.random());

        calculateValue(car);
        return car;

    }


    private static Car randomTruck() {
        int randomCarByIndex = rand(13, 17);
        VehicleModelSetup randomCar = VehicleModelSetup.getByIndex(randomCarByIndex);
        Car car = new Car(randomCar, randBaseValueBy(randomCar), randMileage(), randomCapacity(), CarCondition.random());

        calculateValue(car);
        return car;

    }

    public void setCarCondition(CarCondition carCondition) {
        this.carCondition = carCondition;
    }


}
