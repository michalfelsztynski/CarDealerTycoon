package model.workshop;

import model.actor.Player;
import model.vehicle.BaseVehicle;

public class MarianAuto extends BaseWorkshop {

    private static final double COMMISSION_RATIO = 1.0;
    private static final int FAIL_BOUND = 11;

    @Override
    public void repair(BaseVehicle bv, Player player) {
        try {
            super.failure(FAIL_BOUND);
        } catch (RepairException e) {
            e.printStackTrace();
        }
        calculateCost(bv);

    }


    public double calculateCost(BaseVehicle bv) {
        return super.calculateCost(bv, COMMISSION_RATIO);
    }
}
