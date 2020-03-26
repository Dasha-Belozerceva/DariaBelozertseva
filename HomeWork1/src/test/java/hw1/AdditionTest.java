package hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdditionTest extends DataProviderTestClass {
    @Test(dataProvider = "calculator DataProvider with 2 args")
    public void sumMethodTest(double a, double b){
        Assert.assertEquals(calculator.sum(a, b), a + b);
    }
}
