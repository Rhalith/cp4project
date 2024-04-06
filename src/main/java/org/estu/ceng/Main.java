package org.estu.ceng;

import org.estu.ceng.controller.Properties;
import org.estu.ceng.model.ZChart;
import org.estu.ceng.model.Calculation;
import org.estu.ceng.view.View;

public class Main {
    public static void main(String[] args) {
        ZChart zChart = new ZChart();
        Properties properties = new Properties();
        Calculation calculation = new Calculation(properties, zChart);
        calculation.Calculate();
        View.showOutputs(calculation);
    }
}