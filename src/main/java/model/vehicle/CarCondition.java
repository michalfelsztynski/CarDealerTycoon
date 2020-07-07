package model.vehicle;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

import static model.vehicle.VehicleUtil.rand;

@Getter
@Setter
public class CarCondition extends BaseCondition {
    private boolean body;
    private boolean interior;

    public CarCondition(boolean brakes, boolean engine, boolean gearbox, boolean body, boolean interior) {
        super(brakes, engine, gearbox);
        this.body = body;
        this.interior = interior;
    }

    public static CarCondition random() {
        Random r = new Random();
        return new CarCondition(r.nextBoolean(), r.nextBoolean(), r.nextBoolean(), r.nextBoolean(), r.nextBoolean());
    }

    public static CarCondition poor() {
        return new CarCondition(false, false, false, false, false);
    }

    public static CarCondition perfect() {
        return new CarCondition(true, true, true, true, true);
    }

    public void randomlyBreak(int bound) {
        int rand = rand(bound);
        int randPart = rand(5);

        if (rand == 2 && anyPartToBreak()) {
            boolean searchingPartToBreak = true;
            do {
                switch (randPart) {
                    case 0:
                        if (this.isBody()) this.setBody(false);
                        searchingPartToBreak = false;
                        break;
                    case 1:
                        if (this.isInterior()) this.setInterior(false);
                        searchingPartToBreak = false;
                        break;
                    case 2:
                        if (this.isBrakes()) this.setBrakes(false);
                        searchingPartToBreak = false;
                        break;
                    case 3:
                        if (this.isEngine()) this.setEngine(false);
                        searchingPartToBreak = false;
                        break;
                    case 4:
                        if (this.isGearbox()) this.setGearbox(false);
                        searchingPartToBreak = false;
                        break;
                    default:
                }
            } while (searchingPartToBreak);
        }
    }

    private boolean anyPartToBreak() {
        return anyPartToBreak(this);
    }
}
