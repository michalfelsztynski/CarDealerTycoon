package model.vehicle;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class MotorcycleCondition extends BaseCondition {
    public MotorcycleCondition(boolean brakes, boolean engine, boolean gearbox) {
        super(brakes, engine, gearbox);
    }

    public static MotorcycleCondition poor() {
        return new MotorcycleCondition(false, false, false);
    }

    public static MotorcycleCondition random() {
        Random r = new Random();
        return new MotorcycleCondition(r.nextBoolean(), r.nextBoolean(), r.nextBoolean());
    }

    public static MotorcycleCondition perfect() {
        return new MotorcycleCondition(true, true, true);
    }
}
