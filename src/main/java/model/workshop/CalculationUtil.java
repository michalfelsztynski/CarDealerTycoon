package model.workshop;

import model.vehicle.CarCondition;
import model.vehicle.MotorcycleCondition;
import model.vehicle.VehicleModelSetup;

public class CalculationUtil {
    private static final double GEARBOX_REPAIR_COST = 400.0;
    private static final double ENGINE_REPAIR_COST = 800.0;
    private static final double BRAKES_REPAIR_COST = 300.0;
    private static final double BODY_REPAIR_COST = 400.0;
    private static final double INTERIOR_REPAIR_COST = 200.0;
    private static final double MOTORCYCLE_RATIO = 0.6;

    private CarCondition carCondition = null;
    private MotorcycleCondition motorcycleCondition = null;
    private VehicleModelSetup.Segment segment = null;
    private double commissionRatio = 0;


    public double carCalculatedCost(CarCondition carCondition, VehicleModelSetup.Segment segment, double commissionRatio) {
        setup(carCondition, segment, commissionRatio);
        double result = performCarCalculation();
        tierDown();
        return result;
    }

    public double motorcycleCalculatedCost(MotorcycleCondition motorcycleCondition, VehicleModelSetup.Segment segment, double commissionRatio) {
        setup(motorcycleCondition, segment, commissionRatio);
        double result = performCarCalculation();
        tierDown();
        return result;

    }

    private void tierDown() {
        this.carCondition = null;
        this.motorcycleCondition = null;
        this.segment = null;
        this.commissionRatio = 0;
    }

    private void setup(CarCondition carCondition, VehicleModelSetup.Segment segment, double commissionRatio) {
        this.carCondition = carCondition;
        this.segment = segment;
        this.commissionRatio = commissionRatio;
    }

    private void setup(MotorcycleCondition motorcycleCondition, VehicleModelSetup.Segment segment, double commissionRatio) {
        this.motorcycleCondition = motorcycleCondition;
        this.segment = segment;
        this.commissionRatio = commissionRatio;
    }

    private double performCarCalculation() {
        double cost = 0;
        if (carCondition.isGearbox()) cost = calcGearBox() + cost;
        if (carCondition.isEngine()) cost = calcEngine() + cost;
        if (carCondition.isBrakes()) cost = calcBrakes() + cost;
        if (carCondition.isBody()) cost = calcBody() + cost;
        if (carCondition.isInterior()) cost = calcInterior() + cost;
        return cost;
    }

    private double performMotocycleCalculation() {
        double cost = 0;
        if (motorcycleCondition.isGearbox()) cost = calcGearBox() + cost;
        if (motorcycleCondition.isEngine()) cost = calcEngine() + cost;
        if (motorcycleCondition.isBrakes()) cost = calcBrakes() + cost;
        return cost * MOTORCYCLE_RATIO;
    }

    private double calcInterior() {
        return INTERIOR_REPAIR_COST * ratio();
    }

    private double calcBody() {
        return BODY_REPAIR_COST * ratio();
    }

    private double calcBrakes() {
        return BRAKES_REPAIR_COST * ratio();
    }

    private double calcEngine() {
        return ENGINE_REPAIR_COST * ratio();
    }

    private double calcGearBox() {
        return GEARBOX_REPAIR_COST * ratio();
    }

    private double ratio() {
        switch (segment) {
            case BUDGET:
                return 0.8 * commissionRatio;
            case PREMIUM:
                return 1.2 * commissionRatio;
            default:
                return 1.0 * commissionRatio;
        }
    }
}
