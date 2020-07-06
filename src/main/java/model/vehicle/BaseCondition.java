package model.vehicle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseCondition {
    private boolean brakes;
    private boolean engine;
    private boolean gearbox;

    public BaseCondition(boolean brakes, boolean engine, boolean gearbox) {
        this.brakes = brakes;
        this.engine = engine;
        this.gearbox = gearbox;
    }
}


