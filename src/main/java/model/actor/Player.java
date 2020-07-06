package model.actor;

import lombok.Getter;
import lombok.Setter;
import model.vehicle.BaseVehicle;

@Getter
@Setter
public class Player extends BaseActor {
    private Double cash;
    private BaseVehicle vehicle;

    public Player(String playerName, Double cash, BaseVehicle vehicle) {
        super(playerName);
        this.cash = cash;
        this.vehicle = vehicle;
    }
}
