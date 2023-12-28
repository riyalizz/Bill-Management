package com.learn.electricitybillmanagent.api;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CustomerControllerTest {

    @Test
    public void testCalculate() {
        CustomerController customerController = new CustomerController();
        int c = customerController.calculate(3, 5);
        Assert.assertEquals(c, 8);
    }
}
