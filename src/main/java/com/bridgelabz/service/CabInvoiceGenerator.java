package com.bridgelabz.service;

import com.bridgelabz.utility.CabCategory;
import com.bridgelabz.repository.RideRepository;
import com.bridgelabz.model.InvoiceSummary;
import com.bridgelabz.model.Ride;

public class CabInvoiceGenerator {

    private final CabCategory cabCategory;
    RideRepository rideRepository;

    public CabInvoiceGenerator(CabCategory cabCategory) {
        this.cabCategory = cabCategory;
        this.rideRepository = new RideRepository();
    }

    public double totalFare(double distance, int time) {
        return cabCategory.totalFare(distance, time);
    }

    public InvoiceSummary totalFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride1:rides) {
            totalFare += this.totalFare(ride1.distance, ride1.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public void addRide(String userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.totalFare(rideRepository.getRides(userId));
    }
}
