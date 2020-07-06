package model.workshop;

import model.actor.Player;
import model.vehicle.*;

public class PPHUAdrian extends BaseWorkshop {
    private final static double COMMISSION_RATIO = 0.65;
    private static final int FAIL_BOUND = 6;


    @Override
    public void repair(BaseVehicle bv, Player player) {

        try {
            super.failure(FAIL_BOUND); // try catch i z zniszczeniem innej czesci.
            double cost = calculateCost(bv);
            super.doRepair(player,bv,cost);
        } catch (RepairException e) {
            //rozjebka części ? i zapłata bez nzprawy
        }

        //todo wydzielić do parenta

    }


    public double calculateCost(BaseVehicle bv) {
        return super.calculateCost(bv,COMMISSION_RATIO);
    }

}
