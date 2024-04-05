package org.estu.ceng;
import org.apache.commons.math3.distribution.NormalDistribution;

public class ZChart {

    private final NormalDistribution normalDistribution;

    public ZChart() {
        normalDistribution = new NormalDistribution(0, 1);
    }

    public double getZScore(double x) {
        return normalDistribution.inverseCumulativeProbability(1-x);
    }

    public double getLValue(double Z) {
        double probability = 1 - normalDistribution.cumulativeProbability(Z);
        return probability;
    }
}
