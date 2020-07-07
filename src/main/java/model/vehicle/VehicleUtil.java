package model.vehicle;

import java.util.Random;

public class VehicleUtil {

    private final static Random r = new Random();

    public static int rand(int origin, int bound) {
        if (origin < bound) {
            int n = bound - origin;
            if (n > 0) {
                return rand(n) + origin;
            } else {  // range not representable as int
                int rand;
                do {
                    rand = rand();
                } while (rand < origin || rand >= bound);
                return rand;
            }
        } else {
            return r.nextInt();
        }
    }

    public static Double randBaseValueBy(VehicleModelSetup model) {
        return (double) rand(model.baseValueFrom, model.baseValueTo);
    }

    public static int rand(int bound) {
        return r.nextInt(bound);
    }

    public static int rand() {
        return r.nextInt();
    }

    public static void calculateValue(BaseVehicle baseVehicle) {
        if (baseVehicle instanceof Car) {
            Car car = (Car) baseVehicle;
            baseVehicle.setValue(calculateValue(car.getCarCondition(), car.getMileage(), car.getBaseValue()));
        }
        if (baseVehicle instanceof Motorcycle) {
            Motorcycle moto = (Motorcycle) baseVehicle;
            baseVehicle.setValue(calculateValue(moto.getMotorcycleCondition(), moto.getMileage(), moto.getBaseValue()));
        }
    }

    public static Integer randMileage() {
        return rand(1, 300) * 1000;
    }

    public static Integer randomCapacity() {
        return rand(1, 4) * 200 + 500;
    }

    private static Double calculateValue(BaseCondition condition, Integer mileage, Double value) {
        double multiplier = 1.0;


        if (condition.isBrakes()) multiplier = multiplier + 0.1;
        if (condition.isEngine()) multiplier = multiplier + 1;
        if (condition.isGearbox()) multiplier = multiplier + 0.5;
        if (condition instanceof CarCondition) {
            CarCondition carCondition = (CarCondition) condition;
            if (carCondition.isBody()) multiplier = multiplier + 0.5;
            if (carCondition.isInterior()) multiplier = multiplier + 0.2;
        }

        multiplier = mileageMultiplier(multiplier, mileage);
        return Math.floor(value * multiplier * 100) / 100;
    }

    private static double mileageMultiplier(double multiplier, Integer mileage) {
        if (mileage < 50000) return multiplier + 0.2;
        if (mileage < 100000) return multiplier + 0.1;
        if (mileage < 150000) return multiplier + 0.0;
        if (mileage < 200000) return multiplier - 0.1;
        return multiplier - 0.2;
    }
}
