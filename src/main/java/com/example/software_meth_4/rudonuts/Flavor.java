package com.example.software_meth_4.rudonuts;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Flavor {
    GLAZED(DonutType.YEAST),
    CHOCOLATE(DonutType.YEAST),
    STRAWBERRY(DonutType.YEAST),
    VANILLA(DonutType.YEAST),
    MAPLE(DonutType.YEAST),
    CINNAMON_SUGAR(DonutType.YEAST),

    PLAIN(DonutType.CAKE),
    MARBLE(DonutType.CAKE),
    BLUEBERRY(DonutType.CAKE),

    POWDERED(DonutType.DONUTHOLE),
    SEMI_GLAZED(DonutType.DONUTHOLE),
    CINNAMON(DonutType.DONUTHOLE),

    PUMPKIN(DonutType.SEASONAL),
    STRAWBERRY_GLAZED(DonutType.SEASONAL);

    private final DonutType type;

    Flavor(DonutType type) { this.type = type; }
    public DonutType getType() { return type; }

    public static List<Flavor> byType(DonutType type) {
        return Arrays.stream(values())
                .filter(f -> f.type == type)
                .collect(Collectors.toList());
    }
}
