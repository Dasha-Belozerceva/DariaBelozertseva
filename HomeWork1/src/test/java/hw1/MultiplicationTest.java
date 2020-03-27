package hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiplicationTest extends DataProviderTestClass {
    @Test(dataProvider = "calculator DataProvider with 2 double args")
    public void multDoubleArgsMethodTest(double a, double b){
        Assert.assertNotEquals(calculator.mult(a, b), a * b);
    }

    @Test(dataProvider = "calculator DataProvider with 2 args, which multiplication gives integer result")
    public void multIntegerArgsMethodTest(double a, double b){
        Assert.assertEquals(calculator.mult(a, b), a * b);
    }
}
