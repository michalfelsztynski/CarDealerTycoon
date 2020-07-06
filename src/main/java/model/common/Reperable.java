package model.common;

import model.actor.Player;
import model.vehicle.BaseVehicle;
import model.workshop.RepairException;

public interface Reperable {
    void repair(BaseVehicle car, Player player);

    double calculateCost(BaseVehicle car, double commissionRatio);

    void failure(int bound) throws RepairException;

    void destructionOfParts();


}
