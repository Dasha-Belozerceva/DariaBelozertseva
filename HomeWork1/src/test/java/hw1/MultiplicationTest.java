package hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiplicationTest extends DataProviderTestClass {
    @Test(dataProvider = "calculator DataProvider with 2 args")
    public void multMethodTest(double a, double b){
        Assert.assertEquals(calculator.mult(a, b), a * b);
    }
}
