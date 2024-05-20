package org.estu.ceng.model;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.analysis.solvers.BrentSolver;

public class ZChart {

    private final NormalDistribution normalDistribution;

    public ZChart() {
        normalDistribution = new NormalDistribution(0, 1);
    }

    public double getZScore(double x) {
        return normalDistribution.inverseCumulativeProbability(1 - x);
    }

    private double lvalue(double z) {
        return dnorm(z) - z * pnorm(z, false);
    }

    private double dnorm(double x) {
        return Math.exp(-(x * x) / 2) / Math.sqrt(2 * Math.PI);
    }

    private double pnorm(double x, boolean lowerTail) {
        if (lowerTail) {
            return normalDistribution.cumulativeProbability(x);
        } else {
            return normalDistribution.cumulativeProbability(-x);
        }
    }

    public double getLValue(double y) {
        BrentSolver solver = new BrentSolver();
        return solver.solve(100, (x) -> lvalue(y) - x, -10, 10);
    }
}