package com.bridgelabz;

public enum CabCategory {
    PREMIUM(2, 15.0, 20.0),
    NORMAL(1, 10.0, 5.0);

    private final double MINIMUM_COST_PER_KILOMETER;
    private final int COST_PER_MINUTE;
    private final double MINIMUM_FARE;

    CabCategory(int COST_PER_MINUTE, double MINIMUM_COST_PER_KILOMETER, double MINIMUM_FARE) {
        this.COST_PER_MINUTE = COST_PER_MINUTE;
        this.MINIMUM_COST_PER_KILOMETER = MINIMUM_COST_PER_KILOMETER;
        this.MINIMUM_FARE = MINIMUM_FARE;
    }

    public double totalFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_MINUTE;
        return Math.max(totalFare, MINIMUM_FARE);
    }
}
