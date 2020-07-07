package model.workshop;

import model.actor.Player;
import model.vehicle.*;

public class PPHUAdrian extends BaseWorkshop {
    private final static double COMMISSION_RATIO = 0.65;
    private static final int FAIL_BOUND = 6;
    private static final int BREAK_BOUND = 5;


    @Override
    public void repair(BaseVehicle bv, Player player) {
        double cost = calculateCost(bv);

        try {
            super.failure(FAIL_BOUND); // try catch i z zniszczeniem innej czesci.
            super.doRepair(player, bv, cost);
        } catch (RepairException e) {
            getMonayForNothing(player, cost);
            brakePart(bv);
        }

    }

    private void brakePart(BaseVehicle bv) {
        if (bv instanceof Car) {
            randomlyBrake((((Car) bv).getCarCondition()));
        }
        if (bv instanceof Motorcycle) {
            randomlyBrake(((Motorcycle) bv).getMotorcycleCondition());
        }
    }

    public void randomlyBrake(BaseCondition bv) {
        if (bv instanceof CarCondition) {
            ((CarCondition) bv).randomlyBreak(BREAK_BOUND);
        }

        if (bv instanceof MotorcycleCondition) {
            ((MotorcycleCondition) bv).randomlyBreak(BREAK_BOUND);
        }
    }


    public double calculateCost(BaseVehicle bv) {
        return super.calculateCost(bv, COMMISSION_RATIO);
    }

}
