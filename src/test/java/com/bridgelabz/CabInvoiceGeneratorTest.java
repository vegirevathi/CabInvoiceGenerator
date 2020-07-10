package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {

    @Test
    public void givenInvoiceGenerator_ShouldReturnTotalFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 5.0;
        int time = 5;
        double totalFare = cabInvoiceGenerator.totalFare(distance, time);
        Assert.assertEquals(55, totalFare, 0.0);
    }

    @Test
    public void givenInvoiceGenerator_ShouldReturnMinimumFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 0.1;
        int time = 2;
        double totalFare = cabInvoiceGenerator.totalFare(distance, time);
        Assert.assertEquals(5, totalFare, 0.0);
    }

    @Test
    public void givenInvoiceGenerator_ShouldReturnInvoiceSummary() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        Ride[] rides = {
                new Ride(5.0, 5),
                new Ride(0.1, 2)
        };
        InvoiceSummary invoiceSummary = cabInvoiceGenerator.totalFare(rides);
        InvoiceSummary invoiceSummaryExpected = new InvoiceSummary(2, 60.0);
        Assert.assertEquals(invoiceSummaryExpected, invoiceSummary);
    }
}
