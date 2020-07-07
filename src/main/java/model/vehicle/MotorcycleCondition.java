package model.vehicle;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Random;

import static model.vehicle.VehicleUtil.rand;

@Getter
@Setter
@Entity
public class MotorcycleCondition extends BaseCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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


    public void randomlyBreak(int bound) {
        int rand = rand(bound);
        int randPart = rand(3);

        if (rand == 2 && anyPartToBreak()) {
            boolean searchingPartToBreak = true;
            do {
                switch (randPart) {
                            case 0:
                        if (this.isBrakes()) this.setBrakes(false);
                        searchingPartToBreak = false;
                        break;
                    case 1:
                        if (this.isEngine()) this.setEngine(false);
                        searchingPartToBreak = false;
                        break;
                    case 2:
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
