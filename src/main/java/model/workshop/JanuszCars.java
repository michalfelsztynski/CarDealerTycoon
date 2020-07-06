package model.workshop;

import model.actor.Player;
import model.vehicle.BaseVehicle;

public class JanuszCars extends BaseWorkshop {
    private final static double COMMISSION_RATIO = 1.5;

    @Override
    public void repair(BaseVehicle bv, Player player) {
        double cost = calculateCost(bv);
        super.doRepair(player, bv, cost);
    }

    public double calculateCost(BaseVehicle bv) {
        return super.calculateCost(bv, COMMISSION_RATIO);
    }


}
