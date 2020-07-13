package com.bridgelabz.model;

public class InvoiceSummary {
    public double averageFare;
    public double totalFare;
    public int rides;

    public InvoiceSummary(int rides, double totalFare) {
        this.rides = rides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare / this.rides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return this.rides == that.rides &&
                Double.compare(that.averageFare, averageFare) == 0 &&
                Double.compare(that.totalFare, totalFare) == 0 ;
    }

}
