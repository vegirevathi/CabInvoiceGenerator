package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
    CabInvoiceGenerator normalCabInvoiceGenerator;
    CabInvoiceGenerator premiumCabInvoiceGenerator;

    @Before
    public void setUp() throws Exception {
        normalCabInvoiceGenerator = new CabInvoiceGenerator(CabCategory.NORMAL);
        premiumCabInvoiceGenerator = new CabInvoiceGenerator(CabCategory.PREMIUM);
    }

    @Test
    public void givenInvoiceGenerator_ShouldReturnTotalFare() {
        double distance = 5.0;
        int time = 5;
        double totalFare = normalCabInvoiceGenerator.totalFare(distance, time);
        Assert.assertEquals(55, totalFare, 0.0);
    }

    @Test
    public void givenInvoiceGenerator_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 2;
        double totalFare = normalCabInvoiceGenerator.totalFare(distance, time);
        Assert.assertEquals(5, totalFare, 0.0);
    }

    @Test
    public void givenInvoiceGenerator_ShouldReturnInvoiceSummary() {
        String userId = "Vegi";
        Ride[] rides = {
                new Ride(5.0, 5),
                new Ride(0.1, 2)
        };
        normalCabInvoiceGenerator.addRide(userId, rides);
        InvoiceSummary invoiceSummary = normalCabInvoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary invoiceSummaryExpected = new InvoiceSummary(2, 60.0);
        Assert.assertEquals(invoiceSummaryExpected, invoiceSummary);
    }

    @Test
    public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
        String userId = "Revathi";
        Ride[] rides = {
                new Ride(5.0, 5),
                new Ride(0.1, 2)
        };
        premiumCabInvoiceGenerator.addRide(userId, rides);
        InvoiceSummary invoiceSummary = premiumCabInvoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary invoiceSummaryExpected = new InvoiceSummary(2, 105.0);
        Assert.assertEquals(invoiceSummaryExpected, invoiceSummary);
    }
}
