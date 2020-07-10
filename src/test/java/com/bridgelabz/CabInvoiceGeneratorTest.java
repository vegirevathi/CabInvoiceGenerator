package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {

    @Test
    public void givenInvoiceGeneratorShouldReturnTotalFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 5.0;
        int time = 5;
        double totalFare = cabInvoiceGenerator.totalFare(distance, time);
        Assert.assertEquals(55,totalFare,0.0);

    }
}
