package org.estu.ceng.view;

import org.estu.ceng.model.Calculation;

public class View {
    public static void showOutputs(Calculation calculation) {
        System.out.println("Optimal Lot Size: " + calculation.getOptimalLotSize());
        System.out.println("Reorder Point: " + calculation.getReorderPoint());
        System.out.println("Safety Stock: " + calculation.getSafetyStock());
        System.out.println("Average Holding Cost: " + calculation.getAverageHoldingCost());
        System.out.println("Average Ordering Cost: " + calculation.getAverageOrderingCost());
        System.out.println("Average Penalty Cost: " + calculation.getAveragePenaltyCost());
        System.out.println("Average Time Between Orders: " + calculation.getAverageTimeBetweenOrders());
        System.out.println("No Stock Proportion: %" + calculation.getNoStockProportion());
        System.out.println("No Met Proportion: %" + calculation.getNoMetProportion());
    }
}
