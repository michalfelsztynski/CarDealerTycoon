package model.workshop;

import model.actor.Player;
import model.common.Reperable;
import model.vehicle.*;

import static model.vehicle.VehicleUtil.rand;

public abstract class BaseWorkshop implements Reperable {

    private static final CalculationUtil util = new CalculationUtil();


    @Override
    public void destructionOfParts() {
    }

    @Override
    public double calculateCost(BaseVehicle bv, double commissionRatio) {
        double cost = 0;
        if (bv instanceof Car) {
            cost = util.carCalculatedCost(((Car) bv).getCarCondition(), bv.getModel().segment, commissionRatio);
        } else if (bv instanceof Motorcycle) {
            cost = util.motorcycleCalculatedCost(((Motorcycle) bv).getMotorcycleCondition(), bv.getModel().segment, commissionRatio);
        }
        return cost;
    }

    @Override
    public void failure(int bound) throws RepairException {
        int rand = rand(1, bound);
        if (rand == 2) {
            System.out.println("repair failure");
            throw new RepairException();
        }
    }

    void doRepair(Player player, BaseVehicle bv, double cost) {
        if (player.getCash() > cost) {
            player.setCash(player.getCash() - cost);
            if (bv instanceof Car) {
                ((Car) bv).setCarCondition(CarCondition.perfect());
            }
            if (bv instanceof Motorcycle) {
                ((Motorcycle) bv).setMotorcycleCondition(MotorcycleCondition.perfect());
            }
        } else {
            System.out.println("no enought cash");
        }
    }

    void getMonayForNothing(Player player, double cost) {
        if (player.getCash() > cost) {
            player.setCash(player.getCash() - cost);
        } else {
            System.out.println("no enought cash");
        }
    }
}
