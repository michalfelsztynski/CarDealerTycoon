package model.vehicle;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

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
}
