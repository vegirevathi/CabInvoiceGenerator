package com.bridgelabz;

public class CabInvoiceGenerator {

    private static final double MINIMUM_COST_PER_KILOMETER = 10;
    private static final int COST_PER_MINUTE = 1;
    private static final double MINIMUM_FARE = 5;

    public double totalFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_MINUTE;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public double totalFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride1:rides) {
            totalFare += this.totalFare(ride1.distance, ride1.time);
        }
        return totalFare;
    }
}
