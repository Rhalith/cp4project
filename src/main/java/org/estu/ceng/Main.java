package org.estu.ceng;

public class Main {
    public static void main(String[] args) {
        ZChart zChart = new ZChart();
        Properties properties = new Properties();
        Calculation calculation = new Calculation(properties, zChart);
        calculation.Calculate();
    }

}