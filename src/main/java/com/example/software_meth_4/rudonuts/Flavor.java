package com.example.software_meth_4.rudonuts;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Flavor {
    YEAST_GLAZED(DonutType.YEAST),
    YEAST_CHOCOLATE(DonutType.YEAST),
    YEAST_STRAWBERRY(DonutType.YEAST),
    YEAST_VANILLA(DonutType.YEAST),
    YEAST_MAPLE(DonutType.YEAST),
    YEAST_CINNAMON_SUGAR(DonutType.YEAST),

    CAKE_PLAIN(DonutType.CAKE),
    CAKE_CHOCOLATE(DonutType.CAKE),
    CAKE_BLUEBERRY(DonutType.CAKE),

    HOLE_POWDERED(DonutType.DONUTHOLE),
    HOLE_GLAZED(DonutType.DONUTHOLE),
    HOLE_CINNAMON(DonutType.DONUTHOLE),

    PUMPKIN(DonutType.SEASONAL),
    STRAWBERRY_GLAZED(DonutType.SEASONAL);

    private final DonutType type;

    Flavor(DonutType type) { this.type = type; }
    public DonutType getType() { return type; }

    /** Helper to fetch all flavors allowed for a type */
    static List<Flavor> byType(DonutType type) {
        return Arrays.stream(values())
                .filter(f -> f.type == type)
                .collect(Collectors.toList());
    }
}
