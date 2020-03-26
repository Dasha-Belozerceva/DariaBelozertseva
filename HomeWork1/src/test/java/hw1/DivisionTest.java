package hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DivisionTest extends DataProviderTestClass {
    @Test(dataProvider = "calculator DataProvider with 2 args")
    public void divMethodTest(double a, double b){
        Assert.assertEquals(calculator.div(a, b), a / b);
    }
}
