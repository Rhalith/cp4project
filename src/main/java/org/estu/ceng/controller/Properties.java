package org.estu.ceng.controller;
import java.util.Locale;
import java.util.Scanner;

public class Properties {
    private double orderingCost;
    private double penaltyCost;
    private double leadTimeDemand;
    private double standardDeviation;
    private double holdingCost;
    private double annualDemand;

    public double getOrderingCost() {
        return orderingCost;
    }

    public double getPenaltyCost() {
        return penaltyCost;
    }

    public double getLeadTimeDemand() {
        return leadTimeDemand;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }

    public double getHoldingCost() {
        return holdingCost;
    }

    public double getAnnualDemand() {
        return annualDemand;
    }

    public Properties(){
        getInput();
    }

    private void getInput(){
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.println("Enter ordering cost:");
        orderingCost = scanner.nextDouble();

        System.out.println("Enter unit cost:");
        double unitCost = scanner.nextDouble();

        System.out.println("Enter penalty cost:");
        penaltyCost = scanner.nextDouble();

        System.out.println("Enter interest rate:");
        double interestRate = scanner.nextDouble();

        System.out.println("Enter lead time:");
        double leadTime = scanner.nextDouble();

        System.out.println("Enter lead time demand:");
        leadTimeDemand = scanner.nextDouble();

        System.out.println("Enter standard deviation:");
        standardDeviation = scanner.nextDouble();

        holdingCost = unitCost * interestRate;
        annualDemand = leadTimeDemand * 12 / leadTime;
    }
}
