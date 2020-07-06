package model.vehicle;

import lombok.Getter;
import lombok.Setter;

import static model.vehicle.VehicleUtil.calculateValue;

@Setter
@Getter
public abstract class BaseVehicle {

    private final VehicleModelSetup model;
    private Double value;
    private transient final Double baseValue;
    private final Integer mileage;
    private final Integer loadCapacity;

    public BaseVehicle(VehicleModelSetup model, Double baseValue, Integer mileage, Integer loadCapacity) {
        this.model = model;
        this.baseValue = baseValue;
        this.mileage = mileage;
        this.loadCapacity = loadCapacity;
    }


    public Double getValue() {
        calculateValue(this);
        return this.value;
    }

}
