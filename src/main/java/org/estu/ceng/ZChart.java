package org.estu.ceng;
import org.apache.commons.math3.distribution.NormalDistribution;

public class ZChart {
    public static void main(String[] args) {
        double mean = 0;
        double stdDev = 1;

        NormalDistribution normalDistribution = new NormalDistribution(mean, stdDev);

        double x1 = 0.04;
        double x2 = 1.92;
        double x3 = -2.12;

        double cdf1 = normalDistribution.cumulativeProbability(x1);
        double cdf2 = normalDistribution.cumulativeProbability(x2);
        double cdf3 = normalDistribution.cumulativeProbability(x3);

        System.out.println("CDF at x1 = " + cdf1);
        System.out.println("CDF at x2 = " + cdf2);
        System.out.println("CDF at x3 = " + cdf3);
    }
}
