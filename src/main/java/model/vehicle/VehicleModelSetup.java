package model.vehicle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum VehicleModelSetup {
    FIAT_126P(VehicleType.CAR, Segment.BUDGET, 200, 1200, 1),
    LADA_SAMARA(VehicleType.CAR, Segment.BUDGET, 350, 1700, 2),
    DEAWOO_LANOS(VehicleType.CAR, Segment.BUDGET, 800, 2000, 3),
    SKODA_FAVORIT(VehicleType.CAR, Segment.BUDGET, 300, 1400, 4),
    HONDA_CIVIC(VehicleType.CAR, Segment.STANDARD, 2400, 9200, 5),
    VW_GOLF(VehicleType.CAR, Segment.STANDARD, 3000, 11000, 6),
    FORD_FOCUS(VehicleType.CAR, Segment.STANDARD, 1500, 7300, 7),
    TOYOTA_COROLLA(VehicleType.CAR, Segment.STANDARD, 4000, 6500, 8),
    PASSERATTI_TDI(VehicleType.CAR, Segment.PREMIUM, 18000, 2000000, 9),
    MERCEDES_S_CLASS(VehicleType.CAR, Segment.PREMIUM, 23000, 60000, 10),
    BUGGATI_CHIRON(VehicleType.CAR, Segment.PREMIUM, 500000, 2000000, 11),
    AUDI_A8(VehicleType.CAR, Segment.PREMIUM, 35000, 90000, 12),
    FORD_TRANSIT(VehicleType.TRUCK, Segment.STANDARD, 3500, 36000, 13),
    VW_CARTER(VehicleType.TRUCK, Segment.STANDARD, 12000, 40000, 14),
    MERCEDES_VIANO(VehicleType.TRUCK, Segment.PREMIUM, 25000, 65000, 15),
    FS_LUBLIN_33(VehicleType.TRUCK, Segment.BUDGET, 1200, 3000, 16),
    YAMAHA_XJ600(VehicleType.MOTORCYCLE, Segment.BUDGET, 1200, 2300, 17),
    HONDA_CBR600RR(VehicleType.MOTORCYCLE, Segment.STANDARD, 3000, 5000, 18),
    SUZUKI_TL1000(VehicleType.MOTORCYCLE, Segment.PREMIUM, 4000, 9000, 19),
    KTM_SX300(VehicleType.MOTORCYCLE, Segment.PREMIUM, 9000, 14000, 20);

    public final VehicleType vehicleType;
    public final Segment segment;
    public final Integer index;
    public final Integer baseValueFrom;
    public final Integer baseValueTo;


    private static final Map<Integer, VehicleModelSetup> BY_INDEX = new HashMap<>();

    private static final Set<VehicleModelSetup> cars = new HashSet<>();
    private static final Set<VehicleModelSetup> trucks = new HashSet<>();
    private static final Set<VehicleModelSetup> motorcycles = new HashSet<>();


    static {
        for (VehicleModelSetup vehicle : values()) {
            BY_INDEX.put(vehicle.index, vehicle);
            if (vehicle.vehicleType == VehicleType.CAR) cars.add(vehicle);
            if (vehicle.vehicleType == VehicleType.TRUCK) trucks.add(vehicle);
            if (vehicle.vehicleType == VehicleType.MOTORCYCLE) motorcycles.add(vehicle);
        }
    }

    VehicleModelSetup(VehicleType vehicleType, Segment segment, Integer baseValueFrom, Integer baseValueTo, int index) {
        this.vehicleType = vehicleType;
        this.segment = segment;
        this.index = index;
        this.baseValueFrom = baseValueFrom;
        this.baseValueTo = baseValueTo;
    }

    public static VehicleModelSetup getByIndex(int index) {
        return BY_INDEX.get(index);
    }

    public static Set<VehicleModelSetup> getByType(VehicleType type) {
        Set<VehicleModelSetup> result = cars;

        if (type == VehicleType.TRUCK) result = trucks;
        if (type == VehicleType.MOTORCYCLE) result = motorcycles;

        return result;
    }

    public enum VehicleType {
        CAR, TRUCK, MOTORCYCLE
    }

    public enum Segment {
        PREMIUM,
        STANDARD,
        BUDGET,
    }
}
