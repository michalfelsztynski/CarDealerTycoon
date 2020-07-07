package model.vehicle;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Stream;

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

// przerost formy nad treścią ... jak się bawić to się bawić ;)
    public boolean anyPartToBreak(Object object) {
        Stream<Field> parentFields = Arrays.stream(object.getClass().getSuperclass().getDeclaredFields());
        Stream<Field> childFields = Arrays.stream(object.getClass().getDeclaredFields());
        Stream<Field> allFields = Stream.concat(parentFields, childFields);

        return allFields.map(f -> {
            try {
                return f.get(object);
            } catch (IllegalAccessException ignore) {
            }
            return Boolean.FALSE;
        }).anyMatch(t -> t == Boolean.TRUE);
    }
}


