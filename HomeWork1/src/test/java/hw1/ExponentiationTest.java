package hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExponentiationTest extends DataProviderTestClass{
    @Test(dataProvider = "calculator DataProvider with 2 args")
    public void powMethodTest(double a, double b){
        Assert.assertEquals(calculator.pow(a, b), Math.pow(a, Math.floor(b)));
    }
}
