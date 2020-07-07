package model.workshop;

import model.actor.Player;
import model.vehicle.BaseVehicle;

public class MarianAuto extends BaseWorkshop {

    private static final double COMMISSION_RATIO = 1.0;
    private static final int FAIL_BOUND = 11;

    @Override
    public void repair(BaseVehicle bv, Player player) {
        double cost = calculateCost(bv);

        try {
            super.failure(FAIL_BOUND);
            super.doRepair(player, bv, cost);
        } catch (RepairException e) {
            getMonayForNothing(player, cost);
        }
    }

    public double calculateCost(BaseVehicle bv) {
        return super.calculateCost(bv, COMMISSION_RATIO);
    }
}
