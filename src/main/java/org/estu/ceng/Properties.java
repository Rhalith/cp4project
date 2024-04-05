package org.estu.ceng;
import java.util.Locale;
import java.util.Scanner;

public class Properties {
    private double orderingCost;
    private double unitCost;
    private double penaltyCost;
    private double interestRate;
    private double leadTime;
    private double leadTimeDemand;
    private double standardDeviation;
    private double holdingCost;
    private double annualDemand;

    public Properties(){
        getInput();
    }

    private void getInput(){
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.println("Enter ordering cost:");
        orderingCost = scanner.nextDouble();

        System.out.println("Enter unit cost:");
        unitCost = scanner.nextDouble();

        System.out.println("Enter penalty cost:");
        penaltyCost = scanner.nextDouble();

        System.out.println("Enter interest rate:");
        interestRate = scanner.nextDouble();

        System.out.println("Enter lead time:");
        leadTime = scanner.nextDouble();

        System.out.println("Enter lead time demand:");
        leadTimeDemand = scanner.nextDouble();

        System.out.println("Enter standard deviation:");
        standardDeviation = scanner.nextDouble();

        // Recalculate dependent variables
        holdingCost = unitCost * interestRate;
        annualDemand = leadTimeDemand * 12 / leadTime;
    }
}
