package hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SubstractionTest extends DataProviderTestClass {
    @Test(dataProvider = "calculator DataProvider with 2 args")
    public void subMethodTest(double a, double b){
        Assert.assertEquals(calculator.sub(a, b), a - b);
    }
}
