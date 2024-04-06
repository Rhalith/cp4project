package org.estu.ceng;

public class Calculation {

    private final Properties properties;
    private final ZChart zChart;
    private float optimalLotSize;
    private float reorderPoint;
    private float zValue; // z-score
    private float safetyStock;
    private float averageHoldingCost;
    private float averageOrderingCost;
    private float averagePenaltyCost;
    private float averageTimeBetweenOrders;
    private float noStockProportion;
    private float noMetProportion;

    public Calculation(Properties properties, ZChart zChart) {
        this.properties = properties;
        this.zChart = zChart;
    }

    private void calculateOptimalLotSize(Boolean isIteration) {
        if(isIteration)
        {
            optimalLotSize = (float) Math.sqrt(2 * properties.getAnnualDemand() * (properties.getOrderingCost() + properties.getPenaltyCost() * properties.getStandardDeviation() * zChart.getLValue(zValue)) / properties.getHoldingCost());
        }
        else
        {
            optimalLotSize = (float) Math.sqrt((2 * properties.getAnnualDemand() * properties.getOrderingCost()) / properties.getHoldingCost());
        }
    }

    private void calculateZ() {
        zValue = (float) zChart.getZScore(optimalLotSize * properties.getHoldingCost() / (properties.getAnnualDemand() * properties.getPenaltyCost()));
    }

    private void calculateReorderPoint() {
        reorderPoint = (float) (properties.getLeadTimeDemand() + zValue * properties.getStandardDeviation());
    }

    private void iterate(){
        calculateOptimalLotSize(false);
        calculateZ();
        calculateReorderPoint();
        float oldOptimalLotSize = optimalLotSize;
        float newOptimalLotSize = 0;
        float oldReorderPoint = reorderPoint;
        float newReorderPoint = 0;
        while (oldOptimalLotSize != newOptimalLotSize || oldReorderPoint != newReorderPoint) {
            oldOptimalLotSize = optimalLotSize;
            oldReorderPoint = reorderPoint;
            calculateOptimalLotSize(true);
            calculateZ();
            calculateReorderPoint();
            newOptimalLotSize = optimalLotSize;
            newReorderPoint = reorderPoint;
        }
    }
    private void calculateSafetyStock() {
        safetyStock = (float) (reorderPoint - properties.getLeadTimeDemand());
    }
    private void calculateAverageCosts(){
        averageHoldingCost = (float) (properties.getHoldingCost() * (optimalLotSize / 2 + safetyStock));
        averageOrderingCost = (float) (properties.getOrderingCost() * properties.getAnnualDemand() / optimalLotSize);
        averagePenaltyCost = (float) (properties.getPenaltyCost() * (properties.getAnnualDemand() * properties.getStandardDeviation() * zChart.getLValue(zValue) / optimalLotSize));
    }
    
    private void calculateAverageTime(){
        averageTimeBetweenOrders = (float) (optimalLotSize / properties.getAnnualDemand());
    }

    private void calculateStockProportions(){
        noStockProportion = (float) (1 - (optimalLotSize * properties.getHoldingCost() / (properties.getAnnualDemand() * properties.getPenaltyCost())));
    }

    private void calculateNotMetProportion(){
        noMetProportion = (float) (properties.getStandardDeviation() * zChart.getLValue(zValue) / optimalLotSize);
    }
}
